package ec.com.sidesoft.debit.collection.ad_actionbutton;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.hibernate.criterion.Restrictions;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.model.common.businesspartner.BusinessPartner;

import ec.com.sidesoft.debit.collection.SdcDcConfirmations;
import ec.com.sidesoft.debit.collection.SdcDebitcollect;
import ec.com.sidesoft.debit.collection.utils.SDC_Helper;

public class ImportDataFile {
  private static final Logger log = Logger.getLogger(ImportDataFile.class);

  public static void loadFileLinesTmpxls(String pathfile, String recordId)
      throws Exception, IOException {

    try {
      Workbook wb = WorkbookFactory.create(new File(pathfile));

      Sheet sheet = wb.getSheetAt(0);

      final SdcDebitcollect head = OBDal.getInstance().get(SdcDebitcollect.class, recordId);
      // Remove old lines
      for (SdcDcConfirmations line : head.getSdcDcConfirmationsList()) {
        OBDal.getInstance().remove(line);
      }
      OBDal.getInstance().refresh(head);

      for (Row row : sheet) {
        // Obtenemos los registros desde la fila 12 cuando tengan mas de 15 columnas
        if (row.getRowNum() > 11 && row.getPhysicalNumberOfCells() > 15) {
          SdcDcConfirmations newLine = OBProvider.getInstance().get(SdcDcConfirmations.class);

          for (Cell cell : row) {
            String value = "";
            // Obtenemos las columnas desde A4 hasta X4
            if (cell.getColumnIndex() < 24) {

              switch (cell.getColumnIndex()) {
              case 4:// Tercero --> E
                value = SDC_Helper.getString(cell);
                newLine.setCustomer(value);
                BusinessPartner bp = getPartner(value);
                if (bp != null) {
                  bp.setSdcLastConfirmation(new Date());
                }
                newLine.setBusinessPartner(bp);
                break;
              case 6:// Monto --> G
                newLine.setOutstandingAmount(SDC_Helper.getBigDecimal(cell));
                break;
              case 9:// Fecha --> J
                newLine.setDueDate(SDC_Helper.getDate(cell));
                break;
              case 16:// # Deposito --> Q
                value = SDC_Helper.getString(cell);
                newLine.setReferenceNo(value);
                break;
              case 18:// Medio de Cobro --> S
                value = SDC_Helper.getString(cell);
                newLine.setMedium(value);
                break;
              default:
                break;
              }
              newLine.setOrganization(head.getOrganization());
              newLine.setSDCDebitcollect(head);
            }
          }
          OBDal.getInstance().save(newLine);
        }
      }
      wb.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static BusinessPartner getPartner(String taxId) throws Exception {
    OBCriteria<BusinessPartner> qBPartner = OBDal.getInstance()
        .createCriteria(BusinessPartner.class);
    qBPartner.add(Restrictions.eq(BusinessPartner.PROPERTY_ACTIVE, true));
    qBPartner.add(Restrictions.eq(BusinessPartner.PROPERTY_SEARCHKEY, taxId.trim()));
    qBPartner.setMaxResults(1);
    return (BusinessPartner) qBPartner.uniqueResult();
  }
}
