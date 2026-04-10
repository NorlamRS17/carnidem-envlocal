-- =============================================================================
-- APRM: Corrección de relaciones huérfanas en conciliación
-- =============================================================================
-- ATENCIÓN: Ejecutar SOLO después de revisar el diagnóstico con:
-- APRM_OrphanedReconciliation_Diagnostic.sql
--
-- Este script elimina la relación (fin_finacc_transaction_id, matchingtype,
-- matched_document) en líneas de extracto que apuntan a transacciones que
-- NO están en ninguna reconciliación. Las líneas quedarán disponibles para
-- ser conciliadas nuevamente.
-- =============================================================================

-- Iniciar transacción (descomentar según el cliente de BD)
-- BEGIN;

UPDATE fin_bankstatementline bsl
   SET fin_finacc_transaction_id = NULL,
       matchingtype = NULL,
       matched_document = NULL,
       updated = NOW()
 FROM fin_bankstatement bs
 WHERE bsl.fin_bankstatement_id = bs.fin_bankstatement_id
   AND bs.fin_financial_account_id = '9B55E74322CD4C39B637DC59FAF7153C'
   AND bsl.fin_finacc_transaction_id IS NOT NULL
   AND bsl.matchingtype = 'AU'
   AND EXISTS (
     SELECT 1
       FROM fin_finacc_transaction t
      WHERE t.fin_finacc_transaction_id = bsl.fin_finacc_transaction_id
        AND t.fin_reconciliation_id IS NULL
   );

-- Verificar filas afectadas (mostrará el número de registros actualizados)
-- COMMIT;   -- Confirmar si todo es correcto
-- ROLLBACK; -- Revertir en caso de error
