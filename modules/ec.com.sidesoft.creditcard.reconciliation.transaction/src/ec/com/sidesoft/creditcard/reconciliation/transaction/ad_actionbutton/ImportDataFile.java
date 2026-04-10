package ec.com.sidesoft.creditcard.reconciliation.transaction.ad_actionbutton;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.openbravo.idl.proc.Value;
import org.hibernate.criterion.Restrictions;
import java.util.Objects;
import org.openbravo.base.exception.OBException;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.hibernate.criterion.Restrictions;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.financialmgmt.accounting.Costcenter;
import org.openbravo.model.financialmgmt.accounting.UserDimension1;
import org.openbravo.model.financialmgmt.payment.FIN_FinaccTransaction;
import org.openbravo.model.financialmgmt.payment.FIN_FinancialAccount;

import ec.com.sidesoft.creditcard.reconciliation.transaction.SccrtCardLoadLine;
import ec.com.sidesoft.creditcard.reconciliation.transaction.SccrtCardLoadTransaction;
import ec.com.sidesoft.creditcard.reconciliation.transaction.utils.SCCRT_Helper;

public class ImportDataFile {
  private static final Logger log = Logger.getLogger(ImportDataFile.class);

  public static void loadFileLinesTmpxls(String pathfile, String recordId)
      throws Exception, IOException {

    try {
      Workbook wb = WorkbookFactory.create(new File(pathfile));

      Sheet sheet = wb.getSheetAt(0);
      
      int sin_lote = 0;
      String mensajeErrorComparacion = null;

      final SccrtCardLoadTransaction head = OBDal.getInstance().get(SccrtCardLoadTransaction.class,
          recordId);
      
      if (head.getSccrtCardLoadLineList().size() > 0) {
        head.getSccrtCardLoadLineList().clear();
        OBDal.getInstance().save(head);
      }
	  Set<String> transaccionesAsignadas = new HashSet<>();
	  FIN_FinaccTransaction idinsert =null;
      for (Row row : sheet) {

    	  Cell cellF = row.getCell(5, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL); // Valor Acreditado 
    	  Cell cellG = row.getCell(6, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL); // Comision 
    	  Cell cellH = row.getCell(7, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL); // Ret. renta 
    	  Cell cellI = row.getCell(8, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL); // Ret. iva
    	  
          Cell cellC = row.getCell(2, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL); // Lote
          Cell cellE = row.getCell(4, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL); // Importe
          Cell cellM = row.getCell(12, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL); // Cost Center
          Cell cellN = row.getCell(13, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL); // User

        // Obtenemos los registros desde la fila A2 cuando tengan mas de 8 columnas
        if (row.getRowNum() > 0 && row.getPhysicalNumberOfCells() > 2
            && !SCCRT_Helper.isRowEmpty(row)) {

          SccrtCardLoadLine newLine = OBProvider.getInstance().get(SccrtCardLoadLine.class);
          String lote=null;
          for (Cell cell : row) {
            // Obtenemos las columnas desde A2 hasta L2
            if (cell.getColumnIndex() < 14) {

              switch (cell.getColumnIndex()) {
              case 0:// Fecha deposito --> A
            	  lote=null;
                  newLine.setDateDeposit(SCCRT_Helper.getDate(cell));             
              case 1: // ID de Lote Agrupador
            	  lote=null;
            	  Cell cells = row.getCell(1, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
            	  if (cells == null) {
            	      newLine.setGroupingBatch("lote unitario "+sin_lote);
            	      sin_lote++;
            	  } else {
            	      String batchValue = SCCRT_Helper.getString(cells);
            	      newLine.setGroupingBatch(batchValue == null ? "" : batchValue.trim());
            	  }
            	    break;
              case 2:// Lote --> B
            	  lote=SCCRT_Helper.getString(cell);
                  newLine.setLotName(SCCRT_Helper.getString(cell));
                  break;   
              case 3:// Recap --> C
            	  lote=null;
                newLine.setRecap(SCCRT_Helper.getString(cell));
                break;
              case 4:// Importe --> D
            	  lote=null;
                  newLine.setAmount(SCCRT_Helper.getBigDecimal(cell));
                  break;
              case 5:// Valor Acreditado --> E
            	  lote=null;
                newLine.setAccreditValue(SCCRT_Helper.getBigDecimal(cell));
                break;
              case 6:// Comision --> F
            	  lote=null;
                newLine.setCommisionValue(SCCRT_Helper.getBigDecimal(cell));
                break;
              case 7:// Ret. renta --> G
            	  lote=null;
                newLine.setWithhRent(SCCRT_Helper.getBigDecimal(cell));
                break;
              case 8:// Ret. iva --> H
            	  lote=null;
                newLine.setWithhIva(SCCRT_Helper.getBigDecimal(cell));
                break;
              case 9:// IVA --> I
            	  lote=null;
                newLine.setIva(SCCRT_Helper.getBigDecimal(cell));
                break;
              case 10:// Ref. deposito --> J
            	  lote=null;
                newLine.setDepositReference(SCCRT_Helper.getString(cell));
                break;
              case 11:// Ref. deposito --> K
            	  lote=null;
                newLine.setSettled(SCCRT_Helper.getString(cell).equals("N") ? false : true);
                break;
              case 12:// Cost. Center --> L
            	  lote=null;
                newLine.setTextcostcenter(SCCRT_Helper.getString(cell));
                  break;
              case 13:// User --> M
            	  lote=null;
                newLine.setTextuser(SCCRT_Helper.getString(cell));
                  break;
              default:
                break;
              }
              newLine.setOrganization(head.getOrganization());
              newLine.setSccrtCardLoadTransaction(head);
            //validar si hay algun archivo con lote gemelo
              String verificar_lote=lote;
              OBCriteria<FIN_FinancialAccount> finanAcct = OBDal.getInstance().createCriteria(FIN_FinancialAccount.class);
              finanAcct.add(Restrictions.eq(FIN_FinancialAccount.PROPERTY_ID, head.getFINFinancialAccountFrom().getId()));
              finanAcct.setMaxResults(1);
              FIN_FinancialAccount finanAcctRow = (FIN_FinancialAccount) finanAcct.uniqueResult();
              
              // Ahora el criteria para obtener las transacciones relacionadas
              //verificar si el lote esta lleno
              if(verificar_lote!= null) {
            	  //verificar los datos duplicados
            	  String hql = "select t.depositAmount, t.costCenter.id, t.organization.id " +
            	             "from " + FIN_FinaccTransaction.class.getName() + " t " +
            	             "where t.account = :account " +
            	             "group by t.depositAmount, t.costCenter.id, t.organization.id " +
            	             "having count(t.id) > 1";
//            	  String hql2 = "select t.depositAmount, t.costCenter.id, t.organization.id " +
//            	             "from " + FIN_FinaccTransaction.class.getName() + " t " +
//            	             "where t.account.id = :accountId " +
//            	             "and t.sSccrLot = :lote " +
//            	             "order by t.depositAmount";
            	  List<Object[]> duplicados = OBDal.getInstance()
            	    .getSession()
            	    .createQuery(hql)
            	    .setParameter("account", finanAcctRow)
            	    .list();
            	  
            	  	BigDecimal depositAmount = BigDecimal.ZERO;
	      		    String costCenterId = null;
	      		    String orgId = null;
            	  for (Object[] rows : duplicados) {
            		    depositAmount = (BigDecimal) rows[0];
            		    costCenterId = (String) rows[1];
            		    orgId = (String) rows[2];
            		}
            	  //si hay datos duplicados entonces me coja los distintos registros de la tabla FIN_FinaccTransaction
            	  if(depositAmount!=BigDecimal.ZERO && costCenterId!= null && orgId!=null) {
            		  OBCriteria<FIN_FinaccTransaction> critTx = OBDal.getInstance().createCriteria(FIN_FinaccTransaction.class);
                      critTx.add(Restrictions.eq(FIN_FinaccTransaction.PROPERTY_ACCOUNT, finanAcctRow));
                      critTx.add(Restrictions.eq(FIN_FinaccTransaction.PROPERTY_SSCCRLOT, verificar_lote));
                      critTx.add(Restrictions.eq(FIN_FinaccTransaction.PROPERTY_SSCCRRECONCILED, "N"));
                      critTx.add(Restrictions.eq(FIN_FinaccTransaction.PROPERTY_TRANSACTIONTYPE, "BPD"));
                   // Excluir transacciones ya asignadas
                      if (!transaccionesAsignadas.isEmpty()) {
                          critTx.add(Restrictions.not(Restrictions.in(FIN_FinaccTransaction.PROPERTY_ID, transaccionesAsignadas)));
                      }
                      List<FIN_FinaccTransaction> transacciones = critTx.list();
                      System.out.println("Transacciones encontradas: " + transacciones.size());
                      int tamano=transacciones.size();
          	          
          	          if (tamano == 0) {
          	        	  mensajeErrorComparacion = "No se ha hecho match con ninguna Transaccion.";
          	          }
          	          
                      System.out.println("Transacciones asignadas hasta ahora: " + transaccionesAsignadas);

                      boolean matchFound = false;

                      for (FIN_FinaccTransaction tx : transacciones) {
                    	    // Verificar si ya se asignó esta transacción
                   	    	
                    	        String user_id = null;
                    	        String costcenter_id = null;
                    	        BigDecimal montoTransaccion = tx.getDepositAmount();
                    	        BigDecimal importeExcelStr = new BigDecimal(cellE.toString());
                    	        BigDecimal importeExcelStrQA;
                    	        BigDecimal valorAcreditado = BigDecimal.ZERO;
                    	        BigDecimal comision = BigDecimal.ZERO;
                    	        BigDecimal ret_venta = BigDecimal.ZERO;
                    	        BigDecimal ret_iva = BigDecimal.ZERO;

                    	        
                    	        
                    	    if (!transaccionesAsignadas.contains(tx.getId())) {
                    	    	// cellE
                    	    	if (cellE == null) {
                    	    	    importeExcelStrQA = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
                    	    	} else {
                    	    	    switch (cellE.getCellType()) {
                    	    	        case Cell.CELL_TYPE_NUMERIC:
                    	    	            importeExcelStrQA = BigDecimal.valueOf(cellE.getNumericCellValue()).setScale(2, RoundingMode.HALF_UP);
                    	    	            break;
                    	    	        case Cell.CELL_TYPE_STRING:
                    	    	            importeExcelStrQA = new BigDecimal(cellE.getStringCellValue().trim()).setScale(2, RoundingMode.HALF_UP);
                    	    	            break;
                    	    	        case Cell.CELL_TYPE_FORMULA:
                    	    	            importeExcelStrQA = BigDecimal.valueOf(cellE.getNumericCellValue()).setScale(2, RoundingMode.HALF_UP);
                    	    	            break;
                    	    	        default:
                    	    	            importeExcelStrQA = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
                    	    	            break;
                    	    	    }
                    	    	}

                    	    	// cellF
                    	    	if (cellF == null) {
                    	    	    valorAcreditado = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
                    	    	} else {
                    	    	    switch (cellF.getCellType()) {
                    	    	        case Cell.CELL_TYPE_NUMERIC:
                    	    	            valorAcreditado = BigDecimal.valueOf(cellF.getNumericCellValue()).setScale(2, RoundingMode.HALF_UP);
                    	    	            break;
                    	    	        case Cell.CELL_TYPE_STRING:
                    	    	            valorAcreditado = new BigDecimal(cellF.getStringCellValue().trim()).setScale(2, RoundingMode.HALF_UP);
                    	    	            break;
                    	    	        case Cell.CELL_TYPE_FORMULA:
                    	    	            valorAcreditado = BigDecimal.valueOf(cellF.getNumericCellValue()).setScale(2, RoundingMode.HALF_UP);
                    	    	            break;
                    	    	        default:
                    	    	            valorAcreditado = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
                    	    	            break;
                    	    	    }
                    	    	}

                    	    	// cellG
                    	    	if (cellG == null) {
                    	    	    comision = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
                    	    	} else {
                    	    	    switch (cellG.getCellType()) {
                    	    	        case Cell.CELL_TYPE_NUMERIC:
                    	    	            comision = BigDecimal.valueOf(cellG.getNumericCellValue()).setScale(2, RoundingMode.HALF_UP);
                    	    	            break;
                    	    	        case Cell.CELL_TYPE_STRING:
                    	    	            comision = new BigDecimal(cellG.getStringCellValue().trim()).setScale(2, RoundingMode.HALF_UP);
                    	    	            break;
                    	    	        case Cell.CELL_TYPE_FORMULA:
                    	    	            comision = BigDecimal.valueOf(cellG.getNumericCellValue()).setScale(2, RoundingMode.HALF_UP);
                    	    	            break;
                    	    	        default:
                    	    	            comision = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
                    	    	            break;
                    	    	    }
                    	    	}

                    	    	// cellH
                    	    	if (cellH == null) {
                    	    	    ret_venta = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
                    	    	} else {
                    	    	    switch (cellH.getCellType()) {
                    	    	        case Cell.CELL_TYPE_NUMERIC:
                    	    	            ret_venta = BigDecimal.valueOf(cellH.getNumericCellValue()).setScale(2, RoundingMode.HALF_UP);
                    	    	            break;
                    	    	        case Cell.CELL_TYPE_STRING:
                    	    	            ret_venta = new BigDecimal(cellH.getStringCellValue().trim()).setScale(2, RoundingMode.HALF_UP);
                    	    	            break;
                    	    	        case Cell.CELL_TYPE_FORMULA:
                    	    	            ret_venta = BigDecimal.valueOf(cellH.getNumericCellValue()).setScale(2, RoundingMode.HALF_UP);
                    	    	            break;
                    	    	        default:
                    	    	            ret_venta = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
                    	    	            break;
                    	    	    }
                    	    	}

                    	    	// cellI
                    	    	if (cellI == null) {
                    	    	    ret_iva = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
                    	    	} else {
                    	    	    switch (cellI.getCellType()) {
                    	    	        case Cell.CELL_TYPE_NUMERIC:
                    	    	            ret_iva = BigDecimal.valueOf(cellI.getNumericCellValue()).setScale(2, RoundingMode.HALF_UP);
                    	    	            break;
                    	    	        case Cell.CELL_TYPE_STRING:
                    	    	            ret_iva = new BigDecimal(cellI.getStringCellValue().trim()).setScale(2, RoundingMode.HALF_UP);
                    	    	            break;
                    	    	        case Cell.CELL_TYPE_FORMULA:
                    	    	            ret_iva = BigDecimal.valueOf(cellI.getNumericCellValue()).setScale(2, RoundingMode.HALF_UP);
                    	    	            break;
                    	    	        default:
                    	    	            ret_iva = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
                    	    	            break;
                    	    	    }
                    	    	}


                    	        BigDecimal sumatoria = valorAcreditado.add(comision).add(ret_iva).add(ret_venta);  
                    	        String costcenterExcelStr = new String(cellM.toString());
                    	        String userExcelStr = (cellN != null) ? cellN.toString().trim() : null;
                    	        
                    	        OBCriteria<Costcenter> ObjCostCenterXlsx = OBDal.getInstance()
                    	                .createCriteria(Costcenter.class);
                    	        ObjCostCenterXlsx.add(Restrictions.eq(Costcenter.PROPERTY_NAME, costcenterExcelStr)); 
                    	        ObjCostCenterXlsx.setMaxResults(1);
                    	        Costcenter costcenterXlsx = (Costcenter) ObjCostCenterXlsx.uniqueResult();
                    	        
                    	        UserDimension1 userXlsx = null;

                    	        if (userExcelStr != null && !userExcelStr.trim().isEmpty()) {
                    	            OBCriteria<UserDimension1> ObjUserXlsx = OBDal.getInstance()
                    	                    .createCriteria(UserDimension1.class);
                    	            ObjUserXlsx.add(Restrictions.eq(UserDimension1.PROPERTY_NAME, userExcelStr.trim()));
                    	            ObjUserXlsx.setMaxResults(1);
                    	            userXlsx = (UserDimension1) ObjUserXlsx.uniqueResult();
                    	        }
                    	        
                    	        // ===== Obtener IDs de transacción =====
                    	        if (tx.getCostCenter() != null) {
                    	            costcenter_id = tx.getCostCenter().getId();
                    	        }
                    	        if (tx.getStDimension() != null) {
                    	            user_id = tx.getStDimension().getId();
                    	        }


                    	        // ===== Obtener IDs desde Excel (criterias) =====
                    	        String costcenter_id_xlsx = costcenterXlsx != null ? costcenterXlsx.getId() : null;
                    	        String user_id_xlsx = userXlsx != null ? userXlsx.getId() : null;

                    	        // ===== Comparaciones =====
                    	        boolean sumamontoIgual = (montoTransaccion != null 
                    	                && montoTransaccion.compareTo(sumatoria) == 0);
                    	        boolean costCenterIgual = (costcenter_id != null && costcenter_id.equals(costcenter_id_xlsx));
                    	        boolean userIgual = Objects.equals(user_id, user_id_xlsx);
                    	        boolean sinTransacciones = (tamano == 0);

                    	        mensajeErrorComparacion = null;

                    	        // Verificar errores específicos
                    	        if (!sumamontoIgual) {
                    	            mensajeErrorComparacion = "No se ha hecho match con ninguna Transaccion: valor de importe no coincide.";
                    	        } else if (!costCenterIgual) {
                    	            mensajeErrorComparacion = "No se ha hecho match con ninguna Transaccion: Centro de costo no coincide.";
                    	        } else if (!userIgual) {
                    	            mensajeErrorComparacion = "No se ha hecho match con ninguna Transaccion: Usuario no coincide.";
                    	        }
                    	        
                    	        if(costCenterIgual && userIgual && sumamontoIgual) {
                    	    	// Asignar al newLine
                    	    	newLine.setFINFinaccTranssaction(tx);
                          	  	idinsert=newLine.getFINFinaccTranssaction();

                    	        //newLine.setFINFinaccTranssaction(tx);
                    	        // Guardar el id en el set
                    	        transaccionesAsignadas.add(tx.getId());
                    	        // Salimos del for para que solo asigne una transacción por ejecución
                    	        matchFound = true;
                    	        break;
                    	        }
                    	    }

                    	}
                      if (!matchFound) {
                    	    newLine.setLOGError(mensajeErrorComparacion);
                    	    newLine.setError(true);
                    	}
            	  }
            	  
            	  newLine.setFINFinaccTranssaction(idinsert);
                  
              }
              
            }
          
          }
    	  OBDal.getInstance().save(newLine);

        }
      }


      OBDal.getInstance().flush();
	  OBDal.getInstance().commitAndClose();
      wb.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
