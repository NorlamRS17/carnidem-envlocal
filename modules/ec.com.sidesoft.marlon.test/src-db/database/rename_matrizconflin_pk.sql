-- Migración: Corregir nombre de columna PK truncada en ESMP_MatrizConfiguracion_LIN
-- Error: column esmp_matrizconfiguracion_lin_id does not exist (Hint: esmp_matrizconf_uracion_lin_id)
-- Causa: truncamiento por límite de 30 caracteres
-- Solución: renombrar a esmp_matrizconflin_id (20 chars)
--
-- Ejecutar ANTES de update/compilar si la tabla ya existe con el nombre incorrecto.
-- PostgreSQL

DO $$
BEGIN
  -- Si existe la columna con nombre truncado, renombrar
  IF EXISTS (
    SELECT 1 FROM information_schema.columns 
    WHERE table_schema = 'public' 
    AND table_name = 'esmp_matrizconfiguracion_lin' 
    AND column_name = 'esmp_matrizconf_uracion_lin_id'
  ) THEN
    ALTER TABLE esmp_matrizconfiguracion_lin 
    RENAME COLUMN esmp_matrizconf_uracion_lin_id TO esmp_matrizconflin_id;
    RAISE NOTICE 'Columna renombrada: esmp_matrizconf_uracion_lin_id -> esmp_matrizconflin_id';
  END IF;
  
  -- Si la tabla fue creada recientemente con esmp_matrizconfiguracion_lin_id (sin truncar),
  -- no hacer nada (la compilación creará la tabla correcta desde cero si se elimina)
END $$;
