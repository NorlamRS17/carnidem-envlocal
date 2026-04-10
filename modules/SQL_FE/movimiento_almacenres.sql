SELECT * FROM
(
SELECT
1 as ordinal,
aa.m_movement_id,
aa.m_movementline_id,
UNNEST(ARRAY[1,2,3,4,5,6,7,8,9,10,11,12,13,14]) AS numero,
' ' AS nombre,
UNNEST(ARRAY[ g.name,h.name
			]) AS valor
FROM m_product a
LEFT JOIN ad_treenode tn ON tn.node_id = a.m_product_category_id
LEFT JOIN m_movementline aa ON  aa.m_product_id = a.m_product_id
LEFT JOIN m_movement bb ON  aa.m_movement_id = bb.m_movement_id




LEFT JOIN m_brand g ON g.m_brand_id = a.m_brand_id
LEFT JOIN ssfi_model_prod h ON h.ssfi_model_prod_id = a.em_ssfi_model_prod_id




GROUP BY aa.m_movement_id,aa.m_movementline_id,numero,nombre,valor

UNION ALL

SELECT
2,
aa.m_movement_id,
aa.m_movementline_id,
au.seqno AS numero,
' ' AS nombre,
ab.description AS valor
FROM m_movementline aa 
INNER JOIN m_product a ON a.m_product_id = aa.m_product_id
INNER JOIN m_movement bb ON aa.m_movement_id = bb.m_movement_id
INNER JOIN m_attributesetinstance ab ON ab.m_attributesetinstance_id = aa.m_attributesetinstance_id --
INNER JOIN m_attributeset ats ON ats.m_attributeset_id = ab.m_attributeset_id -- CONJUNTO DE ATRIBUTOS
INNER JOIN m_attributeinstance ai ON ai.m_attributesetinstance_id = aa.m_attributesetinstance_id -- VALOR ATRIBUTO
INNER JOIN m_attribute ma ON ai.m_attribute_id = ma.m_attribute_id --NOMBRE ATRIBUTO
INNER JOIN m_attributeuse au ON  ma.m_attribute_id = au.m_attribute_id AND ats.m_attributeset_id = au.m_attributeset_id--ORDEN ATRIBUTO
WHERE
	ma.description<>'N'	
) sq
WHERE sq.m_movement_id= ?
AND sq.nombre IS NOT NULL AND sq.valor IS NOT NULL  and sq.valor <>''
ORDER BY sq.m_movement_id, sq.m_movementline_id, sq.ordinal, sq.numero