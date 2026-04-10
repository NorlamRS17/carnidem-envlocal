-- =============================================================================
-- APRM: Diagnóstico de relaciones huérfanas en conciliación
-- =============================================================================
-- Problema: Líneas de extracto bancario (BSL) tienen fin_finacc_transaction_id
-- y matchingtype configurados, pero la transacción NO está en ninguna línea
-- de reconciliación (fin_reconciliation_id IS NULL en la transacción).
--
-- Esto impide desconciliar y eliminar pagos porque la BSL mantiene la referencia.
-- =============================================================================

-- 1. CONSULTA: Cantidad de líneas de extracto afectadas
-- (tienen ID de transacción y matchingtype AU, pero la transacción NO está en ninguna reconciliación)
SELECT COUNT(*) AS lineas_afectadas
  FROM fin_bankstatementline bsl
  JOIN fin_finacc_transaction t ON t.fin_finacc_transaction_id = bsl.fin_finacc_transaction_id
 WHERE bsl.fin_finacc_transaction_id IS NOT NULL
   AND bsl.matchingtype = 'AU'
   AND t.fin_reconciliation_id IS NULL;

-- 2. DETALLE: Listado de las líneas afectadas con información para auditoría
SELECT
  fa.fin_financial_account_id AS cuenta_financiera_id,
  fa.name AS cuenta_financiera,
  bsl.fin_bankstatementline_id,
  bs.documentno AS numero_extracto,
  bsl.referenceno,
  bsl.bpartnername,
  bsl.datetrx,
  bsl.cramount - bsl.dramount AS importe,
  bsl.fin_finacc_transaction_id,
  bsl.matchingtype,
  t.fin_reconciliation_id,
  t.depositamt AS deposito
FROM fin_bankstatementline bsl
JOIN fin_finacc_transaction t ON t.fin_finacc_transaction_id = bsl.fin_finacc_transaction_id
JOIN fin_bankstatement bs ON bs.fin_bankstatement_id = bsl.fin_bankstatement_id
JOIN fin_financial_account fa ON fa.fin_financial_account_id = bs.fin_financial_account_id
WHERE bsl.fin_finacc_transaction_id IS NOT NULL
  AND bsl.matchingtype = 'AU'
  AND t.fin_reconciliation_id IS NULL
ORDER BY fa.name, bs.documentno, bsl.datetrx DESC;

-- 3. RESUMEN: Cantidad por tipo de relación (matchingtype)
-- AU=Auto, MA=Manual, AP=Algoritmo
SELECT bsl.matchingtype AS tipo_relacion,
       COUNT(*) AS cantidad
  FROM fin_bankstatementline bsl
  JOIN fin_finacc_transaction t ON t.fin_finacc_transaction_id = bsl.fin_finacc_transaction_id
 WHERE bsl.fin_finacc_transaction_id IS NOT NULL
   AND t.fin_reconciliation_id IS NULL
 GROUP BY bsl.matchingtype;
