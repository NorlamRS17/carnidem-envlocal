# Reportes del módulo Carnidem Production

Este directorio contiene los reportes JRXML del módulo de producción Carnidem.

---

## Rpt_Injectionloss — Merma de inyección respecto a la materia prima

### Parámetros de entrada (desde Openbravo)

| Parámetro              | Descripción        |
|------------------------|--------------------|
| `DateFrom`             | Fecha inicial      |
| `DateTo`               | Fecha final        |
| `crprod_mproduct_id`   | Producto (M_Product_ID) |
| `AD_User_ID`           | Usuario (auditoría) |

### Enfoque del dato: Parte de fabricación primero

El reporte se construye partiendo de la **parte de fabricación** (`M_ProductionLine`) y luego se obtienen las órdenes de trabajo. Solo deben aparecer las partes donde el **producto del filtro es P+** (producto producido en esa línea).

1. **Filtrar por producto y fechas:**  
   El filtro de fechas actúa sobre la **orden de fabricación** (`MA_WorkRequirement`), columna **`launchdate`**: solo se consideran órdenes cuya fecha de lanzamiento está entre `DateFrom` y `DateTo`. Dentro de esas órdenes se buscan líneas de `M_ProductionLine` donde:
   - `M_Product_ID = $P{crprod_mproduct_id}`
   - `productiontype = '+'` (solo donde ese producto es P+).
   Si una orden no tiene partes de fabricación con ese producto como P+, la orden no se muestra.

2. **De cada línea de producción (P+):**
   - **P+:** cantidad producida → `M_ProductionLine.MovementQty`
   - **Lote:** valor de atributos/lote de `M_ProductionLine` (columna donde se guarda el lote; en muchos modelos es `m_attributesetinstance_id` o un atributo derivado).

3. **Relaciones para Orden y Parte de trabajo:**
   - `M_ProductionLine` → `M_ProductionPlan` (`M_ProductionPlan_ID`).
   - `M_ProductionPlan` → `MA_WRPhase` (`MA_WRPhase_ID`) → `MA_WorkRequirement` (orden de fabricación).
   - `MA_WorkRequirement.DocumentNo` = **Orden de fabricación** (primera columna).
   - `M_ProductionPlan` → `M_Production` (`M_Production_ID`).
   - `M_Production.documentno` = **Parte de trabajo** (documento de la producción/parte).

### Jerarquía de tablas (referencia)

| Nivel        | Tabla               | Uso en el reporte                          |
|-------------|----------------------|--------------------------------------------|
| Header      | MA_WorkRequirement   | Orden de fabricación (`DocumentNo`)        |
| Operation   | MA_WRPhase           | Fase de trabajo (enlace con plan)          |
| Product     | MA_WRPhaseProduct    | Producto en la fase (P+ / P-)               |
| Parte fab.  | M_ProductionPlan     | Plan de producción (enlace WR ↔ Production)|
| Línea       | M_ProductionLine     | P+ (`MovementQty`), lote, producto filtrado |
| Parte trab. | M_Production         | Documento parte de trabajo (`documentno`)   |

### Orden de columnas en el reporte (según diseño)

| # | Columna                               | Origen / Nota |
|---|----------------------------------------|----------------|
| 1 | **Orden**                              | `MA_WorkRequirement.DocumentNo` |
| 2 | **Producto**                           | Nombre del producto (filtro o línea P+) |
| 3 | **Parte**                              | Parte de trabajo → `M_Production.documentno` |
| 4 | **P+**                                 | `M_ProductionLine.MovementQty` (donde producto = filtro y P+) |
| 5 | **LOTE**                               | Atributos/lote de `M_ProductionLine` |
| 6 | **Peso Original proceso inyección P-**| Ver lógica abajo (centro curados, P- mayor volumen kg) |
| 7 | **Merma**                              | Sum(P+ producto filtro en cocción) − Peso Original P- |
| 8 | **% Merma**                            | (Merma / Peso Original P-) × 100 |
| 9 | **Eficiencia**                         | 100 − % Merma (o según definición) |

- Agrupación: por **orden de fabricación**. Las columnas 6 (Peso Original P-) y 7 (Merma) son **a nivel orden**: un valor por orden, repetido en todas las filas de esa orden (celdas fusionadas por orden en el diseño). Totales: fila de totales al final (P+ total, Peso original total, Merma total; % Merma y Eficiencia luego).

### Centro de costo ↔ parte de fabricación

- La **parte de fabricación** (`M_ProductionPlan`) se relaciona con el centro de costo mediante el campo **`MA_Costcenter_Version_ID`**.
- A partir de ahí se determina si la parte pertenece a cc_cocción_hornos o cc_curados (según la versión/centro de costo asociado).

### Lógica: Peso Original proceso inyección P- y Merma (columnas 6 y 7)

**Constantes:**

- **cc_cocción_hornos:** `14451B6783C443EAB3D3F256A3F5A6FE`
- **cc_curados:** `64A61E9EA1914D0C86D002759BFE5278`
- **UOM Kilogramos (solo esta UOM para volumen en kg):** `72BA247D31F745F3AF11F74A5E2CCBEF` — para el P- en curados solo se consideran líneas con `C_UOM_ID = este valor`.

**Agrupación en reporte:** Todas las columnas se agrupan por **orden de fabricación**. Peso Original P- y Merma son **un valor por orden** (mismo valor en todas las filas de esa orden; celdas fusionadas a nivel orden). Totales al final (suma de P+, suma Peso Original, suma Merma).

**Vinculo curados ↔ cocción:** Se ancla por **lote y producto** (no se exige que la parte de curados sea de la misma orden; basta mismo producto y mismo lote para identificar la parte de curados que “alimenta” cocción).

#### Paso 1 — P- de mayor cantidad en cocción (cc_cocción_hornos)

- Partes de fabricación (`M_ProductionPlan`) de la **misma orden** cuya versión de centro de costo apunta a **cc_cocción_hornos** (vía `MA_Costcenter_Version_ID`).
- En las líneas de esas partes (`M_ProductionLine`), solo tipo **P-** (`productiontype = '-'`).
- De esas P-, la de **mayor** `MovementQty` → ese producto P- y su lote son los que se consumen en cocción.

#### Paso 2 — Vincular con curados (cc_curados)

- Con ese **producto P-** y su **lote** (mismo lote que en cocción):
  - Buscar en **cc_curados** una **parte de fabricación** (cualquier orden) donde ese producto sea **P+** y tenga el **mismo lote**.
- Anclaje por lote (y producto); no se exige misma orden.

#### Paso 3 — Peso Original proceso inyección P- (valor por orden)

- En **esa parte de fabricación de cc_curados** (la que tiene el P+ con el mismo lote):
  - De sus líneas **P-** solo considerar las que tengan **UOM = kg** (`C_UOM_ID = '72BA247D31F745F3AF11F74A5E2CCBEF'`).
  - De esas, tomar el **P-** con **mayor** `MovementQty` (en kg).
- Ese valor es el **Peso Original proceso inyección P-** para la orden. Se repite en todas las filas de la misma orden.

#### Paso 4 — Merma (por orden)

- **Sumar** el **producto del filtro** como **P+** en **todas las partes de cc_cocción_hornos** de esa **misma orden**: suma de `MovementQty` donde producto = filtro, P+, y la parte es de cc_cocción_hornos.
- **Merma =** esa suma **menos** el **Peso Original proceso inyección P-** del paso 3.  
  **Merma = Sum(P+ producto filtro en cocción, por orden) − Peso Original P-**
- Un valor por orden; se repite en todas las filas de la orden.

#### Resumen (solo columnas 6 y 7 por ahora)

- **Peso Original proceso inyección P-:** En la parte de cc_curados que tiene el P+ (mismo producto y lote que cocción), el P- con mayor `MovementQty` en **UOM kg** (`72BA247D31F745F3AF11F74A5E2CCBEF`). Un valor por orden.
- **Merma:** Suma(P+ producto filtro en partes cocción de la orden) − Peso Original P-. Un valor por orden.

**% Merma y Eficiencia:** se desarrollan después.

### Regla de filtrado

- **Solo incluir líneas donde el producto del filtro (`crprod_mproduct_id`) es P+.**  
  Es decir: partir de `M_ProductionLine` con `M_Product_ID = $P{crprod_mproduct_id}` y `productiontype = '+'`, y desde ahí enlazar a parte de fabricación, orden de trabajo y parte de trabajo.

---

## Estándar de reportes JRXML

Para cabecera, parámetros, campos obligatorios, UUID y dimensiones de página, aplicar la regla de Cursor:  
`.cursor/rules/jrxml-report-header-standard.mdc`.
