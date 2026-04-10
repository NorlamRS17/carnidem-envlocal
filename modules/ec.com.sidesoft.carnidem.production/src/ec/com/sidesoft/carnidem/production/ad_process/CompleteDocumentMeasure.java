package ec.com.sidesoft.carnidem.production.ad_process;

import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.exception.NoConnectionAvailableException;
import org.openbravo.model.ad.process.ProcessInstance;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Locator;
import org.openbravo.model.common.plm.AttributeSetInstance;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.uom.UOM;
import org.openbravo.model.manufacturing.quality.MeasureShift;
import org.openbravo.model.materialmgmt.transaction.InternalMovement;
import org.openbravo.model.materialmgmt.transaction.InternalMovementLine;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.CallProcess;
import org.openbravo.service.db.DalBaseProcess;
import org.openbravo.service.db.DalConnectionProvider;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBDal;
import org.openbravo.data.UtilSql;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.database.SessionInfo;
import org.openbravo.client.kernel.RequestContext;
import org.apache.log4j.Logger;


import ec.com.sidesoft.carnidem.production.quality.crprqy_paramsSafetyQly;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CompleteDocumentMeasure extends DalBaseProcess{
	private final Logger logger = Logger.getLogger(CompleteDocumentMeasure.class);

	@Override
	protected void doExecute(ProcessBundle bundle) throws Exception {
		// TODO Auto-generated method stub
		OBError msg = new OBError();
		try {
			ConnectionProvider conn = new DalConnectionProvider(false);
			String recordID = (String) bundle.getParams().get("MA_Measure_Shift_ID");
			String paramStatusID = (String) bundle.getParams().get("emCrprodParamstatus");
			Boolean paramMovNoClose = ((String) bundle.getParams().get("emCrprodMovemennoclose")).equals("Y")? true : false;
			Boolean paramMovNoGen = ((String) bundle.getParams().get("emCrprodMovemennogen")).equals("Y")? true : false;
			
			if(paramMovNoClose && paramMovNoGen) {
				throw new OBException("Para poder completar solo uno de los 2 checks puede seleccionarse , NO AMBOS.");
			} else if (paramMovNoGen) {
				completeMeasureShift(recordID, null, paramStatusID);
			} else if(paramMovNoClose) {
				preProcessMovement(conn,recordID, paramStatusID, paramMovNoClose, paramMovNoGen);
				InternalMovement newMov = createMovement(conn,recordID, paramStatusID, paramMovNoClose, paramMovNoGen);
				completeMeasureShift(recordID, newMov, paramStatusID);
			} else {
				preProcessMovement(conn,recordID, paramStatusID, paramMovNoClose, paramMovNoGen);
				InternalMovement newMov = createMovement(conn, recordID, paramStatusID, paramMovNoClose, paramMovNoGen);
				processMovement(newMov, conn);
				completeMeasureShift(recordID, newMov, paramStatusID);
			}
			
			msg.setType("Success");
			msg.setTitle(OBMessageUtils.messageBD("Success"));
			msg.setMessage("Se ha completado la operación con éxito");
		}catch(Exception e) {
			OBDal.getInstance().rollbackAndClose();
			logger.debug(e.getMessage() + e);
			msg.setType("Error");
			msg.setTitle(OBMessageUtils.messageBD("Error"));
			msg.setMessage("No se logró completar la operación. "+e.getMessage());
		}finally {
			bundle.setResult(msg);
		}
	}
	
	public void preProcessMovement(ConnectionProvider conn, String recordID, String paramStatusID, Boolean paramMovNoClose, Boolean paramMovNoGen) throws NoConnectionAvailableException {
		VariablesSecureApp vars = RequestContext.get().getVariablesSecureApp();
		
		MeasureShift objMSC = OBDal.getInstance().get(MeasureShift.class, recordID);
		crprqy_paramsSafetyQly objParamStatus = OBDal.getInstance().get(crprqy_paramsSafetyQly.class, paramStatusID);

		Product objProd = objMSC.getSpqulyProduct() != null ? objMSC.getSpqulyProduct() : null;
		Product objProdTerm = objMSC.getSpqulyFinishedprod() != null ? objMSC.getSpqulyFinishedprod() : null;

		if(objProd == null && objProdTerm == null) {
			throw new OBException("No se ha encontrado el producto configurado.");
		}
		DocumentType objDocType = objParamStatus.getTransactionDocument();
		if(objDocType == null) {
			throw new OBException("No se ha encontrado un tipo de documento configurado.");
		}
		Locator objLocator = objParamStatus.getInitlocator();
		if(objLocator == null) {
			throw new OBException("No se ha encontrado un hueco configurado.");
		}
		Locator objLocatorTo = objParamStatus.getNewStorageBin();
		if(objLocatorTo == null) {
			throw new OBException("No se ha encontrado un hueco configurado.");
		}
		BigDecimal qtyMov = objMSC.getSpqulyTotalqty();
		if (qtyMov.compareTo(BigDecimal.ZERO) <= 0) {
			throw new OBException("La cantidad a mover es nula.");
		}
		UOM objUOM = objMSC.getSpqulyUom();
		if(objUOM == null) {
			throw new OBException("No hay una unidad configurada.");
		}
		AttributeSetInstance objLote = objMSC.getSpqulyAttrsi();
		String strLote = (objLote != null && objLote.getDescription()!= null)? objLote.getDescription() : "";
		if(!validateStock( conn,  objLocator,  objProd, objProdTerm, objLote,  qtyMov)) {
			String prodName = (objProd != null ? objProd.getName() : (objProdTerm != null ? objProdTerm.getName() : "Desconocido"));
			throw new OBException("El producto " + prodName +
		    " atributo: " + strLote +
		    " cantidad: " + qtyMov +
		    " seleccionado no se encuentra disponible en el almacén de transferencia.");
		}
	}
	
	public InternalMovement createMovement(ConnectionProvider conn, String recordID, String paramStatusID, Boolean paramMovNoClose, Boolean paramMovNoGen) throws Exception {
		VariablesSecureApp vars = RequestContext.get().getVariablesSecureApp();
		
			MeasureShift objMSC = OBDal.getInstance().get(MeasureShift.class, recordID);
			crprqy_paramsSafetyQly objParamStatus = OBDal.getInstance().get(crprqy_paramsSafetyQly.class, paramStatusID);

			Product objProd = objMSC.getSpqulyProduct() != null ? objMSC.getSpqulyProduct() : null;
			Product objProdTerm = objMSC.getSpqulyFinishedprod() != null ? objMSC.getSpqulyFinishedprod() : null;
			Product prodToUse = objProd != null ? objProd : objProdTerm;



			DocumentType objDocType = objParamStatus.getTransactionDocument();
			Locator objLocator = objParamStatus.getInitlocator();
			Locator objLocatorTo = objParamStatus.getNewStorageBin();
			String StrDoc = objDocType.getId();
			String docNo = Utility.getDocumentNo(conn.getConnection(), conn, vars, "",MeasureShift.ENTITY_NAME, StrDoc, StrDoc, false, false);
			if(docNo == null || docNo.equals("")) {
				throw new OBException("No se ha encontrado una secuencia confiurada.");
			}
			ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("America/Guayaquil"));
			Date objCurrentDate = Date.from(zonedDateTime.toInstant());
			Long line =Long.valueOf(10);
			BigDecimal qtyMov = objMSC.getSpqulyTotalqty();
			UOM objUOM = objMSC.getSpqulyUom();
			AttributeSetInstance objLote = objMSC.getSpqulyAttrsi();
			
			InternalMovement newMov = OBProvider.getInstance().get(InternalMovement.class);
			newMov.setOrganization(objParamStatus.getOrganization());
			newMov.setSsrsCDoctype(objDocType);
			newMov.setSsinDoctype(objDocType);
			newMov.setDocumentNo(docNo);
			newMov.setMovementDate(objCurrentDate);
			newMov.setSmvaiEnddateoftransport(objCurrentDate);
			String newName = "Generado por Toma de Datos MSC - "+objMSC.getCrprodDocumentno();
			if (newName.length() > 60) {
				newName = newName.substring(0, 60);
			}
			newMov.setName(newName);
			newMov.setDescription(objMSC.getCrprodDocumentno());
			OBDal.getInstance().save(newMov);
			
			InternalMovementLine newMovLine = OBProvider.getInstance().get(InternalMovementLine.class);
			//newMovLine.setClient(newMovLine.getClient());
			newMovLine.setClient(objParamStatus.getOrganization().getClient());
			newMovLine.setOrganization(objParamStatus.getOrganization());
			newMovLine.setMovement(newMov);
			newMovLine.setLineNo(line);
			newMovLine.setStorageBin(objLocator);
			newMovLine.setNewStorageBin(objLocatorTo);
			newMovLine.setProduct(prodToUse);
			newMovLine.setMovementQuantity(qtyMov);
			newMovLine.setSprliIdentifier(prodToUse.getSearchKey());
			newMovLine.setUOM(objUOM);
			if(objLote != null) {
				newMovLine.setAttributeSetValue(objLote);
			}
			
			OBDal.getInstance().save(newMovLine);
			OBDal.getInstance().flush();
			
			return newMov;
	}
	
	public String  processMovement(InternalMovement newMov, ConnectionProvider conn) throws Exception {
		Map<String, String> parameters = new HashMap<String, String>();
	    parameters.put("M_Movement_ID", newMov.getId());
	    org.openbravo.model.ad.ui.Process process = OBDal.getInstance().get(org.openbravo.model.ad.ui.Process.class, "122");
	    ProcessInstance pInstance = CallProcess.getInstance().call(process, newMov.getId(), parameters);
	    OBError oberror = OBMessageUtils.getProcessInstanceMessage(pInstance);
	    String msg = oberror.getMessage();
	    if (pInstance.getResult() == 0) {
	      throw new OBException(msg);
	    }
	    return msg;
	}
	
	
	public void completeMeasureShift(String recordID, InternalMovement newMov, String paramStatusID) {
		MeasureShift objMSC = OBDal.getInstance().get(MeasureShift.class, recordID);
		objMSC.setSsfdcStatus("CP");
		objMSC.setSsfdcCompleted(true);
		if(newMov != null) {
			objMSC.setCrprodMovement(newMov);
		}
		if(paramStatusID != null && !paramStatusID.equals("")) {
			crprqy_paramsSafetyQly objParamStatus = OBDal.getInstance().get(crprqy_paramsSafetyQly.class, paramStatusID);
			objMSC.setCrprodStatus(objParamStatus.getCrprqyParamsStatus());
		}
		OBDal.getInstance().save(objMSC);
		OBDal.getInstance().flush();
	}
	
	public Boolean validateStock(ConnectionProvider conn, Locator objLocator, Product objProd,Product objProdTerm, AttributeSetInstance objLote, BigDecimal qtyMov) {
		Boolean response = false;

		String sql = "SELECT COUNT(*) AS records " + 
				"FROM M_Storage_Detail s " + 
				"WHERE s.M_Locator_ID = ? " + 
				"AND s.M_Product_ID = ? " + 
				"AND s.QtyOnHand >= ? " ;
		if(objLote != null) {
			sql = sql + "AND s.M_AttributeSetInstance_ID = ?";
		}

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.getPreparedStatement(sql);
			st.setString(1, objLocator.getId());
			st.setString(2, (objProd != null ? objProd.getId() : objProdTerm.getId()));
			st.setBigDecimal(3, qtyMov);
			if(objLote != null) {
				st.setString(4, objLote.getId());
			}

			QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
			rs = st.executeQuery();

			if (rs.next()) {
				response = rs.getInt("records") > 0;
			}
		} catch (Exception e) {
			logger.debug("Error al validar stock: " + e.getMessage(), e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
			} catch (Exception e) {
				logger.debug("Error al cerrar recursos: " + e.getMessage(), e);
			}
		}

		return response;
	}
	
	
	
}
