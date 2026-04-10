package ec.com.sidesoft.retatil.order.dimensions.hook;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.openbravo.dal.service.OBDal;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOut;
import org.openbravo.retail.posterminal.OrderLoaderHook;
import org.openbravo.model.common.businesspartner.BusinessPartner;

import org.openbravo.service.db.CallStoredProcedure;
import org.openbravo.service.db.DalConnectionProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.dal.service.OBQuery;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.financialmgmt.accounting.Costcenter;
import org.openbravo.model.financialmgmt.accounting.UserDimension1;

public class SDRSFO_OrderDimensions implements OrderLoaderHook {

	@Override
	public void exec(JSONObject jsonorder, Order order, ShipmentInOut shipment, Invoice invoice) throws Exception {
		// TODO Auto-generated method stub
		
		 String idDocumentType = jsonorder.getString("documentType");
		 BusinessPartner businessPartner = order.getBusinessPartner();
		 StringBuilder whereString = new StringBuilder();
         whereString.append("WHERE");
         whereString.append(" TRIM('" + idDocumentType + "') IN (" + "c_doctype_id" + ")" );
            OBQuery<DocumentType> docTypeQuery = 
                    (OBQuery<DocumentType>)OBDal.getInstance().createQuery((Class)DocumentType.class, whereString.toString());

         DocumentType documentType = docTypeQuery.list().get(0);
         // id de centro de costo
         String costCenterId = documentType.getSsfcCostcenter().getId();
         String user1Id = businessPartner.getSsfcUser1().getId();
         
		 whereString = new StringBuilder();
         whereString.append("WHERE");
         whereString.append(" TRIM('" + costCenterId + "') IN (" + "c_costcenter_id" + ")" );
            OBQuery<Costcenter> costCenterQuery = 
                    (OBQuery<Costcenter>)OBDal.getInstance().createQuery((Class)Costcenter.class, whereString.toString());

           // Variable del centro de costo de pedido de venta
         Costcenter costCenter = costCenterQuery.list().get(0);
         
         whereString = new StringBuilder();
         whereString.append("WHERE");
         whereString.append(" TRIM('" + user1Id + "') IN (" + "user1_id" + ")" );
            OBQuery<UserDimension1> user1Query = 
                    (OBQuery<UserDimension1>)OBDal.getInstance().createQuery((Class)UserDimension1.class, whereString.toString());

           // Variable de canal
            UserDimension1 user1 = user1Query.list().get(0);
         
         //setamos datos del pedido de venta
         order.setCostcenter(costCenter);
         order.setStDimension(user1);
         OBDal.getInstance().save((Object)order);
                 
         if(invoice != null) {
        	//seteamos datos a la factura(cliente)
             invoice.setCostcenter(invoice.getDocumentType().getSsfcCostcenter());
             invoice.setStDimension(user1);
             OBDal.getInstance().save((Object)invoice);
         }
         
         if(shipment != null) {
        	//seteamos datos a la Albaran(cliente)
             shipment.setCostcenter(shipment.getDocumentType().getSsfcCostcenter());
             shipment.setStDimension(user1);
             OBDal.getInstance().save((Object)shipment);
         }
         
	}

}
