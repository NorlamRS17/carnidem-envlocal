# Corrección de relaciones huérfanas en conciliación bancaria

## Contexto del problema

Tras pulsar por error el botón **"Reconcile All"** (Reconciliar Todo), algunas transacciones quedan en un estado inconsistente:

- Las **líneas de extracto bancario** (`fin_bankstatementline`) mantienen la relación con transacciones (`fin_finacc_transaction_id`, `matchingtype`, `matched_document`).
- Pero la **transacción** no figura en ninguna reconciliación (`fin_reconciliation_id IS NULL`).
- Resultado:
  - No se pueden ver las transacciones al intentar desconciliar.
  - No se puede eliminar el cobro/pago por error "registro relacionado con otros elementos".
  - Las líneas de extracto no aparecen como pendientes de conciliar.

## Solución

### 1. Diagnóstico

Ejecutar el script de diagnóstico para identificar las líneas afectadas:

```bash
# PostgreSQL
psql -U openbravo -d tu_base -f APRM_OrphanedReconciliation_Diagnostic.sql
```

O ejecutar las consultas manualmente en el cliente SQL:

- **Consulta 1**: Cantidad total de líneas afectadas.
- **Consulta 2**: Detalle de cada línea (ID, referencia, importe, tipo relación, cuenta, etc.).
- **Consulta 3**: Resumen por tipo de relación (AU=Auto, MA=Manual, AP=Algoritmo).

### 2. Corrección

Ejecutar el script de corrección **solo después** de revisar el diagnóstico:

```bash
# PostgreSQL
psql -U openbravo -d tu_base -f APRM_OrphanedReconciliation_Fix.sql
```

El script hace `UPDATE` en `fin_bankstatementline` para las líneas donde:

- `fin_finacc_transaction_id IS NOT NULL`
- La transacción asociada tiene `fin_reconciliation_id IS NULL`

Se limpian: `fin_finacc_transaction_id`, `matchingtype`, `matched_document`.

### 3. Corrección de una sola línea (por ID)

Para modificar **solo una línea** específica, usar `fin_bankstatementline_id`:

```sql
UPDATE fin_bankstatementline bsl
   SET fin_finacc_transaction_id = NULL,
       matchingtype = NULL,
       matched_document = NULL,
       updated = NOW()
 WHERE bsl.fin_bankstatementline_id = 'AQUI_EL_ID_DE_LA_LINEA'
   AND bsl.fin_finacc_transaction_id IS NOT NULL
   AND bsl.matchingtype = 'AU'
   AND EXISTS (
     SELECT 1
       FROM fin_finacc_transaction t
      WHERE t.fin_finacc_transaction_id = bsl.fin_finacc_transaction_id
        AND t.fin_reconciliation_id IS NULL
   );
```

Reemplazar `AQUI_EL_ID_DE_LA_LINEA` por el `fin_bankstatementline_id` obtenido en la consulta de diagnóstico (columna `fin_bankstatementline_id`).

## Checklist de pruebas

Después de aplicar la corrección:

- [ ] **Conciliación**: Las transacciones afectadas vuelven a aparecer en la pantalla de conciliación como pendientes.
- [ ] **Desconciliar**: Si aplica, las transacciones se pueden desconciliar con normalidad.
- [ ] **Eliminar pago/cobro**: Se puede eliminar el registro que antes daba error de "relación con otros elementos".
- [ ] **Reportería**: Los informes financieros no se ven afectados (saldos, extractos, etc.).
- [ ] **Conciliación manual**: Se puede volver a conciliar manualmente las líneas corregidas.

## Archivos

| Archivo | Descripción |
|---------|-------------|
| `APRM_OrphanedReconciliation_Diagnostic.sql` | Consultas de diagnóstico |
| `APRM_OrphanedReconciliation_Fix.sql` | Script de corrección (UPDATE) |
| `README_OrphanedReconciliation.md` | Este documento |

## Notas técnicas

- La relación se almacena en `fin_bankstatementline`: `fin_finacc_transaction_id`, `matchingtype`, `matched_document`.
- Una transacción está en reconciliación cuando `fin_finacc_transaction.fin_reconciliation_id IS NOT NULL`.
- El script de corrección no modifica `fin_finacc_transaction` ni `fin_payment`; solo elimina la relación desde la línea de extracto.
- Se recomienda hacer **backup** de la base de datos antes de ejecutar el fix en producción.
