SELECT 
1 as ordinal,
aa.c_invoice_id,
aa.c_invoiceline_id,
aa.line AS numero,
'#' AS nombre,
a.upc AS valor
FROM m_product a
JOIN c_invoiceline aa ON a.m_product_id = aa.m_product_id
AND a.upc IS NOT NULL
WHERE c_invoice_id=?
AND a.upc IS NOT NULL  and a.upc <>''
ORDER BY ordinal, c_invoice_id, c_invoiceline_id, numero