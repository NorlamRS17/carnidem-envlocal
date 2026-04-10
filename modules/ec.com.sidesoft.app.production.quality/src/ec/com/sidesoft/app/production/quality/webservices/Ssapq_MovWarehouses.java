package ec.com.sidesoft.app.production.quality.webservices;

import java.io.Writer;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.time.LocalDate;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.model.ad.utility.Sequence;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Locator;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.plm.AttributeSetInstance;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.plm.ProductAUM;
import org.openbravo.model.common.uom.UOM;
import org.openbravo.model.materialmgmt.transaction.InternalMovement;
import org.openbravo.model.materialmgmt.transaction.InternalMovementLine;
import org.openbravo.model.materialmgmt.transaction.ProductionLine;
import org.openbravo.model.materialmgmt.transaction.ProductionPlan;
import org.openbravo.model.materialmgmt.transaction.ProductionTransaction;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.DalConnectionProvider;
import org.openbravo.service.web.WebService;
import org.openbravo.model.ad.access.User;

import ec.com.sidesoft.app.production.quality.Ssapq_AppParamMovil;
import ec.com.sidesoft.app.production.quality.utils.Ssapq_Helper;
import ec.com.sidesoft.custom.ws.api.ScwsapLog;

public class Ssapq_MovWarehouses implements WebService {
    private final Logger logger = Logger.getLogger(Ssapq_MovWarehouses.class);
    JSONObject jsonResponse = new JSONObject();

    @Override
    public void doGet(String path, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void doPost(String path, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub
        JSONObject json = new JSONObject();
        String logId = null;
        ConnectionProvider conn = new DalConnectionProvider(false);
        try {
            OBContext.setAdminMode(true);
            logger.info("Begin Ssapq_MovWarehouses doPost");

            JSONObject body = Ssapq_Helper.readAllIntoJSONObject(request.getInputStream());

            ScwsapLog log = Ssapq_Helper.createLog(body, "createMovWarehouses", "IN");
            logId = log.getId();

            createMovWarehouses(conn, body);
            json = Ssapq_Helper.getResponse(body);

            log.setJsonResponse(json.toString());
            log.setRecordID(body.getString("id"));
            log.setResult("OK");
            OBDal.getInstance().save(log);
            OBDal.getInstance().flush();
            OBDal.getInstance().commitAndClose();
        } catch (Exception e) {
            OBDal.getInstance().rollbackAndClose();
            String message = Ssapq_Helper.getErrorMessage(logger, e);
            logger.error(message);
            ScwsapLog log = OBDal.getInstance().get(ScwsapLog.class, logId);
            if (log != null) {
                log.setResult("ERROR");
                log.setError(message);
                OBDal.getInstance().save(log);
                OBDal.getInstance().flush();
                OBDal.getInstance().getConnection().commit();
            }
            json = Ssapq_Helper.getErrorResponse(message);
        } finally {
            try {
                conn.getConnection().close();
                conn.destroy();
            } catch (Exception e) {
                Ssapq_Helper.getErrorMessage(logger, e);
            }
            OBContext.restorePreviousMode();
            logger.info("Finish Ssapq_MovWarehouses doPost");
        }
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Writer w = response.getWriter();
        w.write(json.toString());
        w.close();
    }

    public InternalMovement createMovWarehouses(ConnectionProvider conn, JSONObject body) throws Exception {
        String strDocumetnNo = "";
        String workefforId = Ssapq_Helper.getString(body, "workefforId", true);
        String organizacionId = Ssapq_Helper.getString(body, "organizacionId", true);
        String productId = Ssapq_Helper.getString(body, "productId", true);
        String storageBinId = Ssapq_Helper.getString(body, "storageBinId", true);
        Double cantApproved = Double.parseDouble(Ssapq_Helper.getString(body, "cantApproved", true));
        Integer cantRejected = Integer.parseInt(Ssapq_Helper.getString(body, "cantRejected", true));
        String attributeValueId = Ssapq_Helper.getString(body, "attributeValueId", true);
        String productionPlanId = Ssapq_Helper.getString(body, "productionPlanId", true);
        String unitId = Ssapq_Helper.getString(body, "unitId", true);
        String createdBy = Ssapq_Helper.getString(body, "createdBy", false);
        String updatedBy = Ssapq_Helper.getString(body, "updatedBy", false);
        String cantidadProduccion = "";
        String nDocumentWorkEffor = "";
        String fechaExt = "";

        final SimpleDateFormat FORMATO_ENTRADA = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        final SimpleDateFormat FORMATO_SALIDA = new SimpleDateFormat("yyyy-MM-dd");

        final ProductionTransaction ObjWork = OBDal.getInstance().get(ProductionTransaction.class, workefforId);
        final Organization ObjOrg = OBDal.getInstance().get(Organization.class, organizacionId);
        final Product ObjPro = OBDal.getInstance().get(Product.class, productId);
        final ProductionPlan ObjProPlanC = OBDal.getInstance().get(ProductionPlan.class, productionPlanId);
        InternalMovement ObjMovementInt = OBProvider.getInstance().get(InternalMovement.class);

        nDocumentWorkEffor = ObjWork.getDocumentNo().toString();
        Date fechaComplete = FORMATO_ENTRADA.parse(ObjWork.getMovementDate().toString());
        String fechaWorkEffor = FORMATO_SALIDA.format(fechaComplete);

        OBCriteria<ProductionLine> queryProLine = OBDal.getInstance().createCriteria(ProductionLine.class);
        queryProLine.add(Restrictions.eq(ProductionLine.PROPERTY_PRODUCTIONPLAN, ObjProPlanC));
        queryProLine.add(Restrictions.eq(ProductionLine.PROPERTY_PRODUCTIONTYPE, "+")); // Filtrar solo líneas con tipo "+"
        queryProLine.setMaxResults(1); // Obtener solo la primera línea

        ProductionLine proline = (ProductionLine) queryProLine.uniqueResult();
        if (proline != null) {
            cantidadProduccion = proline.getMovementQuantity().toString();
        }

        OBCriteria<Ssapq_AppParamMovil> criteria = OBDal.getInstance().createCriteria(Ssapq_AppParamMovil.class);

        // Primero, busca por ORGANIZACIÓN + PRODUCTO
        criteria.add(Restrictions.eq(Ssapq_AppParamMovil.PROPERTY_ORGANIZATION, ObjOrg));
        criteria.add(Restrictions.eq(Ssapq_AppParamMovil.PROPERTY_PRODUCT, ObjPro));
        criteria.addOrder(Order.desc(Ssapq_AppParamMovil.PROPERTY_PRODUCT));
        criteria.setMaxResults(1);

        Ssapq_AppParamMovil config = (Ssapq_AppParamMovil) criteria.uniqueResult();

        // Si no encontró configuración con producto, busca solo por ORGANIZACIÓN
        if (config == null) {
            criteria = OBDal.getInstance().createCriteria(Ssapq_AppParamMovil.class);
            criteria.add(Restrictions.eq(Ssapq_AppParamMovil.PROPERTY_ORGANIZATION, ObjOrg));
            criteria.add(Restrictions.isNull(Ssapq_AppParamMovil.PROPERTY_PRODUCT)); // Solo las que no tienen producto
            criteria.setMaxResults(1);
            config = (Ssapq_AppParamMovil) criteria.uniqueResult();
        }

        // Si no encuentra ninguna configuración, lanza error
        if (config == null) {
            throw new OBException(
                    "No se encontró una Configuración en los Parámetros con la organización y/o producto especificado.");
        }

        // Obtener tipo de documento asociado a la configuración
        DocumentType docType = config.getDocumentType();
        if (docType == null) {
            throw new OBException("El tipo de documento en la configuración es nulo.");
        }

        // Generar número de documento
        Sequence sequence = docType.getDocumentSequence();
        if (sequence != null) {
            strDocumetnNo = sequence.getNextAssignedNumber().toString();
            // sequence.setNextAssignedNumber(sequence.getNextAssignedNumber() +
            // sequence.getIncrementBy());
            OBDal.getInstance().save(sequence);
            OBDal.getInstance().flush();
        } else {
            strDocumetnNo = "001-001-000000001"; // Valor por defecto
        }

        // Crear objeto InternalMovement
        ObjMovementInt.setOrganization(ObjOrg);
        ObjMovementInt.setSsrsCDoctype(docType);
        ObjMovementInt.setSsinDoctype(docType);
        ObjMovementInt.setDocumentNo(strDocumetnNo);
        ObjMovementInt.setSsinDocumentno(strDocumetnNo);
        ObjMovementInt.setName(cantidadProduccion + " - " + nDocumentWorkEffor + " - " + fechaWorkEffor);

        Date currentDate = new Date();
        ObjMovementInt.setMovementDate(currentDate);
        ObjMovementInt.setSmvaiEnddateoftransport(currentDate);
        
        // Asignar campos de auditoría si están presentes
        if (createdBy != null && !createdBy.isEmpty()) {
            try {
                org.openbravo.model.ad.access.User user = OBDal.getInstance().get(org.openbravo.model.ad.access.User.class, createdBy);
                if (user != null) {
                    ObjMovementInt.setCreatedBy(user);
                }
            } catch (Exception e) {
                logger.warn("No se pudo obtener el usuario createdBy: " + createdBy + " - " + e.getMessage());
            }
        }
        if (updatedBy != null && !updatedBy.isEmpty()) {
            try {
                org.openbravo.model.ad.access.User user = OBDal.getInstance().get(org.openbravo.model.ad.access.User.class, updatedBy);
                if (user != null) {
                    ObjMovementInt.setUpdatedBy(user);
                }
            } catch (Exception e) {
                logger.warn("No se pudo obtener el usuario updatedBy: " + updatedBy + " - " + e.getMessage());
            }
        }

        // Guardar objeto y líneas de movimiento
        OBDal.getInstance().save(ObjMovementInt);
        OBDal.getInstance().flush();

        createInternalMovementLine(organizacionId, productId, storageBinId, attributeValueId, cantRejected,
                cantApproved, ObjMovementInt, config, conn, productionPlanId, unitId, createdBy, updatedBy);

        // Actualizar el cuerpo con el ID generado
        body.put("id", ObjMovementInt.getId());

        return ObjMovementInt;
    }

    @SuppressWarnings("unused")
    private void createInternalMovementLine(String organizationId, String productId, String storageBinId,
            String attributeValueId, Integer cantRejected, Double cantApproved, InternalMovement objMovementInt,
            Ssapq_AppParamMovil listObjParMovil, ConnectionProvider conn, String productionPlanId, String unitId,
            String createdBy, String updatedBy) throws Exception {
        try {
            BigDecimal approvedQty;
            BigDecimal rejectedQty;

            BigDecimal converCant = new BigDecimal("0");
            BigDecimal converCantFinalApro = new BigDecimal("0");
            BigDecimal converCantFinalReje = new BigDecimal("0");

            try {
                // Conversión segura de Integer a BigDecimal
                approvedQty = BigDecimal.valueOf(cantApproved.doubleValue());
                rejectedQty = BigDecimal.valueOf(cantRejected.doubleValue());
            } catch (NumberFormatException e) {
                throw new OBException("Error al convertir las cantidades a BigDecimal: " + e.getMessage(), e);
            }

            // Validar que los valores no sean negativos
            if (approvedQty.compareTo(BigDecimal.ZERO) <= 0 && rejectedQty.compareTo(BigDecimal.ZERO) <= 0) {
                throw new OBException("Ambas cantidades son <= 0, valores inválidos para crear las líneas");
            }

            // Consulta para obtener la línea máxima y sumar 10
            String StrMaxLineQuery = "SELECT COALESCE(MAX(line), 0) + 10 FROM M_MovementLine WHERE M_Movement_ID = ?";
            PreparedStatement psLine = conn.getPreparedStatement(StrMaxLineQuery);
            psLine.setString(1, objMovementInt.getId().toString());
            ResultSet rs = psLine.executeQuery();

            int vLine = 0;
            if (rs.next()) {
                vLine = rs.getInt(1);
            }
            long StrMaxLine = (long) vLine;

            final AttributeSetInstance ObjattributeValueId = OBDal.getInstance().get(AttributeSetInstance.class,
                    attributeValueId);

            final Product ObjPro = OBDal.getInstance().get(Product.class, productId);
            final UOM ObjUOM = OBDal.getInstance().get(UOM.class, unitId);
            final Organization ObjOrg = OBDal.getInstance().get(Organization.class, organizationId); // ← Obtener la
                                                                                                     // organización

            OBCriteria<ProductAUM> ObjProAum = OBDal.getInstance().createCriteria(ProductAUM.class);
            ObjProAum.add(Restrictions.eq(ProductAUM.PROPERTY_PRODUCT, ObjPro));
            ObjProAum.add(Restrictions.eq(ProductAUM.PROPERTY_UOM, ObjUOM));
            ProductAUM ListObjProAum = (ProductAUM) ObjProAum.uniqueResult();

            if (ListObjProAum != null) {
                // Realizar cálculos con ObjProAum
                converCant = ListObjProAum.getConversionRate();
                converCantFinalApro = converCant.multiply(approvedQty);
                converCantFinalReje = converCant.multiply(rejectedQty);

            }

            final Locator Objlocatorfromid = OBDal.getInstance().get(Locator.class, storageBinId);
            final Locator ObjlocatortoApprovedid = OBDal.getInstance().get(Locator.class,
                    listObjParMovil.getPROApprovedMLocator().getId().toString());
            final Locator ObjlocatortoDisapprovedid = OBDal.getInstance().get(Locator.class,
                    listObjParMovil.getPRODisapprovedMLocator().getId().toString());

            // Procesar cantApproved
            if (new BigDecimal(cantApproved).compareTo(BigDecimal.ZERO) > 0) {
                InternalMovementLine lineApproved = OBProvider.getInstance().get(InternalMovementLine.class);
                lineApproved.setMovement(objMovementInt);
                lineApproved.setLineNo(StrMaxLine);
                lineApproved.setProduct(ObjPro);
                lineApproved.setStorageBin(Objlocatorfromid);
                lineApproved.setOperativeQuantity(approvedQty);
                lineApproved.setOrganization(ObjOrg);

                if (converCantFinalApro.compareTo(BigDecimal.ZERO) > 0) {
                    lineApproved.setMovementQuantity(converCantFinalApro);
                } else {
                    lineApproved.setMovementQuantity(approvedQty);
                }

                lineApproved.setNewStorageBin(ObjlocatortoApprovedid);

                lineApproved.setUOM(ObjPro.getUOM());

                if (ListObjProAum != null) {
                    lineApproved.setAlternativeUOM(ListObjProAum.getUOM());
                } else {
                    lineApproved.setAlternativeUOM(ObjPro.getUOM());
                }

                lineApproved.setAttributeSetValue(ObjattributeValueId);
                // Asignar campos de auditoría a la línea aprobada
                if (createdBy != null && !createdBy.isEmpty()) {
                    try {
                        org.openbravo.model.ad.access.User user = OBDal.getInstance().get(org.openbravo.model.ad.access.User.class, createdBy);
                        if (user != null) {
                            lineApproved.setCreatedBy(user);
                        }
                    } catch (Exception e) {
                        logger.warn("No se pudo obtener el usuario createdBy para línea aprobada: " + createdBy + " - " + e.getMessage());
                    }
                }
                if (updatedBy != null && !updatedBy.isEmpty()) {
                    try {
                        org.openbravo.model.ad.access.User user = OBDal.getInstance().get(org.openbravo.model.ad.access.User.class, updatedBy);
                        if (user != null) {
                            lineApproved.setUpdatedBy(user);
                        }
                    } catch (Exception e) {
                        logger.warn("No se pudo obtener el usuario updatedBy para línea aprobada: " + updatedBy + " - " + e.getMessage());
                    }
                }
                // Guardar línea aprobada
                OBDal.getInstance().save(lineApproved);
                StrMaxLine += 10; // Incrementar el número de línea
            }

            // Procesar cantRejected
            if (new BigDecimal(cantRejected).compareTo(BigDecimal.ZERO) > 0) {
                InternalMovementLine lineRejected = OBProvider.getInstance().get(InternalMovementLine.class);
                lineRejected.setMovement(objMovementInt);
                lineRejected.setLineNo(StrMaxLine);
                lineRejected.setProduct(ObjPro);
                lineRejected.setStorageBin(Objlocatorfromid);
                lineRejected.setOperativeQuantity(rejectedQty);
                lineRejected.setOrganization(ObjOrg); // Organización
                if (converCantFinalReje.compareTo(BigDecimal.ZERO) > 0) {
                    lineRejected.setMovementQuantity(converCantFinalReje);
                } else {
                    lineRejected.setMovementQuantity(rejectedQty);
                }
                lineRejected.setNewStorageBin(ObjlocatortoDisapprovedid);

                lineRejected.setUOM(ObjPro.getUOM());
                if (ListObjProAum != null) {
                    lineRejected.setAlternativeUOM(ListObjProAum.getUOM());
                } else {
                    lineRejected.setAlternativeUOM(ObjPro.getUOM());
                }
                lineRejected.setAttributeSetValue(ObjattributeValueId);
                // Asignar campos de auditoría a la línea rechazada
                if (createdBy != null && !createdBy.isEmpty()) {
                    try {
                        org.openbravo.model.ad.access.User user = OBDal.getInstance().get(org.openbravo.model.ad.access.User.class, createdBy);
                        if (user != null) {
                            lineRejected.setCreatedBy(user);
                        }
                    } catch (Exception e) {
                        logger.warn("No se pudo obtener el usuario createdBy para línea rechazada: " + createdBy + " - " + e.getMessage());
                    }
                }
                if (updatedBy != null && !updatedBy.isEmpty()) {
                    try {
                        org.openbravo.model.ad.access.User user = OBDal.getInstance().get(org.openbravo.model.ad.access.User.class, updatedBy);
                        if (user != null) {
                            lineRejected.setUpdatedBy(user);
                        }
                    } catch (Exception e) {
                        logger.warn("No se pudo obtener el usuario updatedBy para línea rechazada: " + updatedBy + " - " + e.getMessage());
                    }
                }
                // Guardar línea rechazada
                OBDal.getInstance().save(lineRejected);
            }

            // Confirmar cambios
            OBDal.getInstance().flush();

            try {
                // Llamar al proceso
                OBError response = MovementProcess(objMovementInt.getId().toString(), conn);

                // Verificar el mensaje en el response
                if (response == null || !response.getType().equalsIgnoreCase("Success")) {
                    // Construir el mensaje de error
                    String errorMessage = response != null ? response.getMessage()
                            : "Error desconocido al ejecutar el proceso.";

                    // Lanzar la excepción personalizada
                    throw new OBException("El proceso falló: " + errorMessage);
                }
            } catch (OBException e) {
                // Manejo de la excepción si es necesario
                throw e; // Relanzar la excepción para el flujo de manejo superior
            } catch (Exception e) {
                // Manejo genérico para otras excepciones
                throw new OBException("Se produjo un error inesperado: " + e.getMessage(), e);
            }

            updateTransfer(productionPlanId);

        } catch (Exception e) {

            e.printStackTrace();
            throw new OBException("Error creating InternalMovementLine: " + e.getMessage(), e);

        }
    }

    private void updateTransfer(String productionPlanId) {
        // TODO Auto-generated method stub
        final ProductionPlan ObjProductionPlan = OBDal.getInstance().get(ProductionPlan.class, productionPlanId);
        ObjProductionPlan.setSsapqTransferred(true);
        OBDal.getInstance().save(ObjProductionPlan);
        OBDal.getInstance().flush();
    }

    private OBError MovementProcess(String mMovementID, ConnectionProvider con) throws Exception {
        OBError myMessage = null; // Inicialización para evitar problemas
        try {
            // Crear un contexto seguro para la ejecución
            OBContext.setAdminMode();
            InternalMovement ObjMovement = OBDal.getInstance().get(InternalMovement.class, mMovementID);

            ProcessBundle bundle = new ProcessBundle("C2F74951B30442D7A2681EE2E7A6DAM8", new VariablesSecureApp("",
                    ObjMovement.getClient().getId(), ObjMovement.getOrganization().getId(), ""));

            Map<String, Object> params = new HashMap<>();
            params.put("m_movement_id", mMovementID);
            bundle.setParams(params);
            bundle.setConnection(con);
            Ssapg_postMovement pr = new Ssapg_postMovement();

            // Ejecuta el proceso
            try {
                pr.execute(bundle);
            } catch (Exception e) {
                // Aquí puedes manejar el mensaje de error mejor
                String errorResult;
                if (e instanceof OBException) {
                    errorResult = e.getMessage(); // Mensaje de OBException
                } else {
                    errorResult = "Error: " + e.getMessage(); // Mensaje genérico
                }
                jsonResponse.put("Error", errorResult);
                throw new OBException(errorResult);
            }

            // Guarda y vacía el buffer de la sesión de Hibernate
            OBDal.getInstance().flush();

            // Refresca el objeto objProductionPlan
            myMessage = (OBError) bundle.getResult();

            if (myMessage != null && !myMessage.getType().equals("Success")) {
                jsonResponse.put("Mensaje", myMessage.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsonResponse.put("Error", "Error: " + e.getMessage());
        } finally {
            OBContext.restorePreviousMode();
        }
        return myMessage;
    }

    @Override
    public void doDelete(String path, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void doPut(String path, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub

    }

}
