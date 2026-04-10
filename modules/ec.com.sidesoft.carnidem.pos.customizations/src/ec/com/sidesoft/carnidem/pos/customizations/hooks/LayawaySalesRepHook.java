package ec.com.sidesoft.carnidem.pos.customizations.hooks;

import java.util.Comparator;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.openbravo.base.exception.OBException;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBDal;
import org.openbravo.dal.service.OBQuery;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOut;
import org.openbravo.model.ad.access.User;
import org.openbravo.retail.posterminal.OrderLoaderHook;

/**
 * Hook para asignar automáticamente el agente comercial en pedidos
 * 
 * Lógica de asignación:
 * 1. Para pedidos Layaway: Buscar usuarios asociados al BusinessPartner del cliente
 *    - Si encuentra 1 usuario: asignar ese usuario como agente comercial
 *    - Si encuentra múltiples usuarios: asignar el más reciente (por fecha de creación)
 *    - Si no encuentra usuarios: usar el usuario actual del POS
 * 2. Para pedidos normales: Asignar el usuario actual del POS como agente comercial
 */
@ApplicationScoped
public class LayawaySalesRepHook implements OrderLoaderHook {

    private static final Logger log = Logger.getLogger(LayawaySalesRepHook.class);

    @Override
    public void exec(JSONObject jsonorder, Order order, ShipmentInOut shipment, Invoice invoice) 
            throws Exception {
        
        try {
            if (isOrderReallyLayaway(order)) {
                // Para pedidos Layaway: SIEMPRE asignar agente comercial del BusinessPartner
                log.debug("Procesando pedido Layaway confirmado: " + order.getDocumentNo());
                
                // Obtener BusinessPartner del pedido
                BusinessPartner bp = order.getBusinessPartner();
                if (bp == null) {
                    log.warn("No se encontró BusinessPartner para el pedido: " + order.getDocumentNo());
                    return;
                }
                
                // Obtener el agente comercial del BusinessPartner
                User selectedUser = getSalesRepresentativeFromBusinessPartner(bp, order);

                // Asignar agente comercial solo si se encuentra un usuario válido
                if (selectedUser != null) {
                    order.setSalesRepresentative(selectedUser);
                    log.debug("Agente comercial asignado (Layaway): " + selectedUser.getName() + 
                            " para pedido: " + order.getDocumentNo());
                } else {
                    log.debug("No se encontró agente comercial válido para Layaway, asignando usuario actual");
                    assignCurrentUserAsSalesRep(order);
                }
            } else {
                // Para pedidos que NO son Layaway: verificar si ya hay selección manual
                if (order.getSalesRepresentative() != null) {
                    log.debug("Pedido normal ya tiene representante de ventas asignado: " + 
                            order.getSalesRepresentative().getName() + " - respetando selección manual");
                    return;
                }
                
                // Solo asignar usuario actual si no hay selección manual
                log.debug("Procesando pedido normal - asignando usuario actual del POS: " + order.getDocumentNo());
                assignCurrentUserAsSalesRep(order);
            }
            
        } catch (Exception e) {
            log.error("Error en LayawaySalesRepHook para pedido: " + 
                    (order != null ? order.getDocumentNo() : "unknown"), e);
            throw new OBException("Error al asignar agente comercial en pedido Layaway", e);
        }
    }
    
    
    /**
     * Verifica si el Order realmente es Layaway usando el campo obposIslayaway
     */
    private boolean isOrderReallyLayaway(Order order) {
        try {
            // Verificar el campo obposIslayaway que es el campo real del sistema
            Boolean obposIslayaway = order.isObposIslayaway();
            boolean isReallyLayaway = obposIslayaway != null && obposIslayaway;
            
            log.info("Validación definitiva - Order obposIslayaway: " + obposIslayaway + 
                    ", es realmente Layaway: " + isReallyLayaway);
            
            return isReallyLayaway;
            
        } catch (Exception e) {
            log.error("Error al verificar obposIslayaway: " + e.getMessage(), e);
            return false;
        }
    }
    
    /**
     * Asigna el usuario actual del POS como agente comercial
     */
    private void assignCurrentUserAsSalesRep(Order order) {
        try {
            // Obtener el usuario actual del contexto
            User currentUser = OBContext.getOBContext().getUser();
            
            if (currentUser != null) {
                order.setSalesRepresentative(currentUser);
                log.info("Usuario actual asignado como agente comercial: " + currentUser.getName() + 
                        " para pedido: " + order.getDocumentNo());
            } else {
                log.warn("No se pudo obtener el usuario actual del contexto para pedido: " + order.getDocumentNo());
            }
            
        } catch (Exception e) {
            log.error("Error al asignar usuario actual como agente comercial: " + e.getMessage(), e);
        }
    }
    
    /**
     * Obtiene el agente comercial del BusinessPartner
     * Lógica:
     * 1. Obtener el agente comercial del BusinessPartner (campo salesrep_id)
     * 2. Buscar el usuario que tenga ese agente comercial en su c_bpartner_id
     * 3. Si no encuentra, usar usuario actual del POS
     */
    private User getSalesRepresentativeFromBusinessPartner(BusinessPartner bp, Order order) {
        try {
            // 1. Obtener el agente comercial del BusinessPartner
            BusinessPartner salesRepBP = bp.getSalesRepresentative();
            
        if (salesRepBP == null) {
            log.info("BusinessPartner no tiene agente comercial asignado, siguiendo flujo normal");
            return null;
        }
            
            log.info("Agente comercial del BusinessPartner: " + salesRepBP.getName());
            
            // 2. Buscar el usuario que tenga ese agente comercial en su c_bpartner_id
            String userHqlWhereClause = " usr where usr.businessPartner = :salesRepBP and usr.organization.id in (:orgs) order by usr.creationDate DESC";
            
            OBQuery<User> queryUser = OBDal.getInstance().createQuery(User.class, userHqlWhereClause);
            queryUser.setNamedParameter("salesRepBP", salesRepBP);
            queryUser.setNamedParameter("orgs", OBContext.getOBContext()
                .getOrganizationStructureProvider().getNaturalTree(order.getOrganization().getId()));
            queryUser.setFilterOnReadableOrganization(false);
            queryUser.setMaxResult(1);
            
            List<User> users = queryUser.list();
            
            if (users != null && !users.isEmpty()) {
                User selectedUser = users.get(0);
                log.info("Usuario encontrado para agente comercial: " + selectedUser.getName());
                return selectedUser;
            } else {
                log.info("No se encontró usuario para el agente comercial, siguiendo flujo normal");
                return null;
            }
            
        } catch (Exception e) {
            log.error("Error al obtener agente comercial del BusinessPartner: " + e.getMessage(), e);
            return null;
        }
    }
}
