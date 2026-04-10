Carnidem
Descripcion
El presente modulo es usado para remplazar nombres de campos y la creacion de alertas en el contexto de Oportunidades, Actividades y Clientes potenciales

Alertas Configuradas:
Cabe resaltar que para que una alerta sea enviada una sola vez es recomendable modificar get_uuid() AS referencekey_id por el id del registro

--1. Alerta de rcordatorio de actividad
SELECT 
  a.opcrm_activity_id AS record_id,
  a.opcrm_activity_id AS referencekey_id,
  0 AS ad_role_id,
  a.createdby  AS ad_user_id,
  COALESCE(
    'Alerta de Actividad Programada' || E'\n\n' ||
    'Le recordamos que tiene una actividad programada para el día de hoy:' || E'\n' ||
    'Tipo de actividad: ' || COALESCE(art.name, arl.name, 'No especificado') || E'\n' ||
    'Cliente asociado: ' || COALESCE(bp.name, bp2.name, 'No especificado') || E'\n' ||
    'Oportunidad relacionada: ' || COALESCE(op.em_scmecu_Documentno||' '||op.opportunity_name, a.activity_subject) || E'\n' ||
    'Descripción: ' || COALESCE(a.description, 'Sin descripción') || E'\n' ||
    'Fecha y hora de inicio: ' || TO_CHAR(a.activity_startdate, 'YYYY-MM-DD HH24:MI') || E'\n\n' ||
    'Por favor, asegúrese de realizar el seguimiento correspondiente y actualizar el estado de la actividad en el sistema.'
  ) AS description,
  a.isactive AS isActive,
  a.ad_org_id,
  a.ad_client_id, 
  a.created AS created, 
  a.createdby AS createdBy, 
  a.updated AS updated, 
  a.updatedby AS updatedBy 
FROM opcrm_activity a
LEFT JOIN ad_ref_list arl ON arl.value = a.activity_type AND arl.ad_reference_id = '5DD1BD096384449E8E30774781EFE2B5'
LEFT JOIN ad_ref_list_trl art ON art.ad_ref_list_id = arl.ad_ref_list_id AND art.ad_language = 'es_ES'
LEFT JOIN c_bpartner bp ON bp.c_bpartner_id = a.c_bpartner_id
LEFT JOIN AD_User bp2 ON bp2.AD_User_id = a.related_lead
LEFT JOIN opcrm_opportunities op ON op.opcrm_opportunities_id = a.opcrm_opportunities_id
WHERE activity_startdate > now()
  AND (
    activity_startdate - 
    CASE reminder
      WHEN 'opcrmReminder1min' THEN INTERVAL '1 minute'
      WHEN 'opcrmReminder5min' THEN INTERVAL '5 minutes'
      WHEN 'opcrmReminder15min' THEN INTERVAL '15 minutes'
      WHEN 'opcrmReminder30min' THEN INTERVAL '30 minutes'
      WHEN 'opcrmReminder1hour' THEN INTERVAL '1 hour'
      ELSE INTERVAL '0 minutes'
    END
  ) <= now()



--2. ALERTA EN “ENTREGA DE MUESTRA AL CLIENTE” en la actividad
SELECT 
  a.opcrm_activity_id AS record_id,
  a.opcrm_activity_id AS referencekey_id,
  0 AS ad_role_id,
  a.createdby  AS ad_user_id,
  COALESCE(
  	'Estimado/a '||ad.name||','|| E'\n\n' ||
    'Se ha registrado en el sistema la entrega de muestra al cliente '||COALESCE(bp.name, bp2.name, 'No especificado')||', correspondiente a la oportunidad '||COALESCE(op.opportunity_name, '') || E'\n\n' ||
    'Responsable: '||ad.name|| E'\n\n' ||
    'Próximo paso sugerido:'||E'\n' ||
	'Contactar al cliente en un plazo no mayor a 3 días para confirmar su impresión sobre la muestra entregada.'||E'\n'
  ) AS description,
  a.isactive AS isActive,
  a.ad_org_id, 
  a.ad_client_id, 
  a.created AS created, 
  a.createdby AS createdBy, 
  a.updated AS updated, 
  a.updatedby AS updatedBy 
FROM opcrm_activity a
LEFT JOIN ad_ref_list arl ON arl.value = a.activity_type AND arl.ad_reference_id = '5DD1BD096384449E8E30774781EFE2B5'
LEFT JOIN ad_ref_list_trl art ON art.ad_ref_list_id = arl.ad_ref_list_id AND art.ad_language = 'es_ES'
LEFT JOIN c_bpartner bp ON bp.c_bpartner_id = a.c_bpartner_id
LEFT JOIN AD_User bp2 ON bp2.AD_User_id = a.related_lead
LEFT JOIN opcrm_opportunities op ON op.opcrm_opportunities_id = a.opcrm_opportunities_id
LEFT JOIN AD_User ad ON ad.AD_User_id = a.assigned_to
WHERE a.activity_type = 'crpco_SampleD'



--3. ALERTA EN “APROBACION DE LA MUESTRA” en la Actividad
SELECT 
  a.opcrm_activity_id AS record_id,
  a.opcrm_activity_id AS referencekey_id,
  0 AS ad_role_id,
  a.createdby  AS ad_user_id,
  COALESCE(
  	'Estimado/a '||ad.name||','|| E'\n\n' ||
    'El cliente '||COALESCE(bp.name, bp2.name, 'No especificado')||', ha aprobado la muestra entregada, correspondiente a la oportunidad '||COALESCE(op.opportunity_name, '') || E'\n\n' ||
    'Observaciones: '||a.description|| E'\n\n' ||
    'Siguiente acción recomendada:'||E'\n' ||
	'Genere una propuesta comercial o cotización desde el sistema y actualice el estado de la oportunidad a Avance Comercial o Negociación.'||E'\n'
  ) AS description,
  a.isactive AS isActive,
  a.ad_org_id, 
  a.ad_client_id, 
  a.created AS created, 
  a.createdby AS createdBy, 
  a.updated AS updated, 
  a.updatedby AS updatedBy 
FROM opcrm_activity a
LEFT JOIN ad_ref_list arl ON arl.value = a.activity_type AND arl.ad_reference_id = '5DD1BD096384449E8E30774781EFE2B5'
LEFT JOIN ad_ref_list_trl art ON art.ad_ref_list_id = arl.ad_ref_list_id AND art.ad_language = 'es_ES'
LEFT JOIN c_bpartner bp ON bp.c_bpartner_id = a.c_bpartner_id
LEFT JOIN AD_User bp2 ON bp2.AD_User_id = a.related_lead
LEFT JOIN opcrm_opportunities op ON op.opcrm_opportunities_id = a.opcrm_opportunities_id
LEFT JOIN AD_User ad ON ad.AD_User_id = a.assigned_to
WHERE a.activity_type = 'crpco_SampleA'



--4. ALERTA EN “CERRADO-GANADO” de la Oportunidad
SELECT 
  a.opcrm_opportunities_id AS record_id,
  a.opcrm_opportunities_id AS referencekey_id,
  0 AS ad_role_id,
  a.createdby  AS ad_user_id,
  COALESCE(
    'Asunto del mensaje:'|| E'\n' ||
	'Oportunidad Ganada – Iniciar flujo de pedido y facturación'|| E'\n\n' ||
  	'Estimado/a '||ad.name||','|| E'\n\n' ||
    'La oportunidad '||COALESCE(a.opportunity_name, 'No especificada')||', asociada al cliente '||COALESCE(bp.name, 'No especificado')||', ha sido marcada como CERRADA – GANADA.'|| E'\n\n' ||
    'Fecha de cierre: '||a.expected_close_date|| E'\n\n' ||
	'Acciones requeridas:'|| E'\n\n' ||
    '      • Verificar la existencia del cliente formalizado en el sistema'||E'\n' ||
	'      • Generar el pedido de venta'||E'\n' ||
	'      • Iniciar el proceso de facturación y/o entrega'||E'\n'
  ) AS description,
  a.isactive AS isActive,
  a.ad_org_id, 
  a.ad_client_id, 
  a.created AS created, 
  a.createdby AS createdBy, 
  a.updated AS updated, 
  a.updatedby AS updatedBy 
FROM opcrm_opportunities a
LEFT JOIN c_bpartner bp ON bp.c_bpartner_id = a.c_bpartner_id
LEFT JOIN opcrm_opportunities op ON op.opcrm_opportunities_id = a.opcrm_opportunities_id
LEFT JOIN AD_User ad ON ad.AD_User_id = a.createdby
WHERE a.opportstatus = 'CLOSED'



--5. ALERTA EN “PERDIDO” de la oportunidad
SELECT 
  a.opcrm_opportunities_id AS record_id,
  a.opcrm_opportunities_id AS referencekey_id,
  0 AS ad_role_id,
  a.createdby  AS ad_user_id,
  COALESCE(
	'Asunto del mensaje:'|| E'\n' ||
	'Oportunidad Perdida – Registrar motivo y análisis de pérdida'|| E'\n\n' ||
  	'Estimado/a '||ad.name||','|| E'\n\n' ||
    'La oportunidad '||COALESCE(a.opportunity_name, 'No especificada')||', asociada al cliente '||COALESCE(bp.name, 'No especificado')||', ha sido marcada como CERRADA – PERDIDA.'|| E'\n\n' ||
	'Fecha de cierre: '||a.expected_close_date|| E'\n\n' ||
	'Acción requerida:'|| E'\n\n' ||
    '      • Verifique y/o complemente el motivo de pérdida en el sistema.'||E'\n' ||
	'      • Si aplica, programe actividad de recontacto futuro.'||E'\n\n' ||
	'Esta información es fundamental para el análisis comercial y la mejora continua del proceso de ventas.'|| E'\n'
  ) AS description,
  a.isactive AS isActive,
  a.ad_org_id, 
  a.ad_client_id, 
  a.created AS created, 
  a.createdby AS createdBy, 
  a.updated AS updated, 
  a.updatedby AS updatedBy 
FROM opcrm_opportunities a
LEFT JOIN c_bpartner bp ON bp.c_bpartner_id = a.c_bpartner_id
LEFT JOIN opcrm_opportunities op ON op.opcrm_opportunities_id = a.opcrm_opportunities_id
LEFT JOIN AD_User ad ON ad.AD_User_id = a.createdby
WHERE a.opportstatus = 'LOST'




Autores ✒️
Esteban Cuasapaz - 16933-YS-CRM-Cliente Potencial - Oportunidades - Actividades
