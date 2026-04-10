# Carnidem env — modelo de integración por punteros

Este documento describe **cómo debe pensarse** el repositorio del ambiente (`carnidem-env` / este repo) frente a los repositorios de módulos y cores: **como punteros a commits concretos**, no como una copia “congelada” que revalida todo el historial en cada pasada.

## Idea central

- El repo del **ambiente** no sustituye a los repos fuente; **registra qué versión (SHA) de cada fuente ya integró con éxito**.
- Cada ejecución del flujo de CI solo se pregunta: **¿cambió el puntero remoto desde la última vez?** Si no, no hace trabajo innecesario sobre código ya asumido como integrado.
- Así **se ignora el pasado en el sentido operativo**: no “reconcilias” todo el árbol; solo **novedades desde el último SHA guardado**.

## Archivo de estado: `last_commits.json`

Archivo en la **raíz del repo del ambiente**, generado y actualizado por el workflow. El orden del array respeta la jerarquía: **core → capas → módulos** (igual que en `update-env.yml`).

```json
{
  "version": 1,
  "sources": [
    { "type": "core", "repo": "Org/OpenbravoCore", "sha": "abc…" },
    { "type": "layer", "repo": "Org/CarnidemCore", "sha": "def…" },
    { "type": "module", "repo": "Org/Estandar24Q1", "sha": "ghi…" }
  ]
}
```

Cada `sha` es el último commit de la **rama por defecto** de ese remoto que el ambiente ya tiene registrado como integrado.

## Implementación

- **Workflow:** `.github/workflows/update-env.yml` (disparo en `push` a `main`).
- **Lógica:** `scripts/env_pointer_sync.py` — se usa **Python** sobre todo para leer/escribir JSON con seguridad y para orquestar `git diff` / `rsync`; el Action solo hace checkout, ejecuta el script y hace commit/push si hay cambios.

## Flujo del GitHub Action (comportamiento real)

### Paso A — Cargar el último estado

Leer `last_commits.json`. Si **no existe**, es la **primera corrida (bootstrap)**: se consulta el HEAD de cada remoto con `git ls-remote`, se escribe el JSON y **no se copia ni modifica** el árbol de Openbravo/módulos (solo el puntero queda guardado).

### Paso B — Consultar el puntero actual de cada origen

Para cada entrada, en orden jerárquico, se obtiene el SHA de **`git ls-remote … HEAD`** (rama por defecto del remoto).

### Paso C — Comparar y actuar solo si hay novedad

Para cada par `(nombre_en_json, repo_remoto)`:

| Condición | Acción |
|-----------|--------|
| SHA guardado **=** SHA remoto | Nada que integrar para ese origen. |
| SHA guardado **≠** SHA remoto | Hay código nuevo desde la última integración exitosa. |

En ese caso el Action debe **aplicar solo lo nuevo**, en una de estas líneas (elección de diseño):

- **Submódulos Git**: actualizar el submódulo al commit objetivo (`git submodule update` / checkout del SHA en el submódulo) y commitear el cambio de puntero en el repo padre.
- **Merge selectivo / cherry-pick**: traer el rango `viejo..nuevo` sobre una rama de trabajo del ambiente (más complejo si los historiales no son ancestros directos).
- **Sincronización por diff** (si se mantiene estrategia por archivos): aplicar únicamente el diff entre el SHA almacenado y el SHA remoto, equivalente conceptual a “mover el puntero y materializar el delta”.

Lo que **no** debe hacer el flujo en cada run es re-procesar todo el contenido histórico como si no existiera registro previo: el registro (`last_commits.json`) es la fuente de verdad de **hasta dónde llegó la última integración buena**.

### Paso D — Persistir

Si la integración termina bien:

1. Escribir en `last_commits.json` los **nuevos SHA** por cada origen actualizado.
2. Hacer **commit y push** en el repo del ambiente (con `[skip ci]` u otra convención para evitar bucles infinitos de workflows, si aplica).

Así la **próxima ejecución** parte exactamente de esos punteros.

## Resumen en una frase

**Los otros repositorios son orígenes versionados; este repo guarda los punteros (commits) que ya asimiló y el Action solo avanza esos punteros cuando detecta novedad.**

### Detalles útiles

- Si **todos** los SHA remotos coinciden con el JSON, el job **no modifica archivos** del ambiente y no hace commit.
- Variable opcional `SYNC_APPLY_DELETES=0` desactiva borrados en disco para entradas `D` del diff (por defecto se aplican).
- Si cambiás el orden o la lista de repos en el workflow, hay que alinear o regenerar `last_commits.json` (el script lo detecta y falla con mensaje claro).
