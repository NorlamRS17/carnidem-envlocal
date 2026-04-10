package ec.com.sidesoft.daily.closing.charge.utils;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.service.db.DbUtility;

public abstract class Sdcc_Helper {

  static public String getString(Cell cell) throws Exception {
    if (cell.getCellTypeEnum().equals(CellType.NUMERIC)) {
      cell.setCellType(CellType.STRING);
    }
    DataFormatter dataFormatter = new DataFormatter();
    String value = dataFormatter.formatCellValue(cell);
    return value.trim();
  }

  static public BigDecimal getBigDecimal(Cell cell) throws Exception {
    return new BigDecimal(cell.getNumericCellValue());
  }

  static public Boolean getBoolean(Cell cell) throws Exception {
    return cell.getBooleanCellValue();
  }

  static public Date getDate(Cell cell) throws Exception {
    return cell.getDateCellValue();

  }

  static public String getDateString(Date date) throws IOException {
    if (date == null) {
      return null;
    } else {
      SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
      return df.format(date);
    }
  }

  static public String getTimestampString(Date date) throws IOException {
    if (date == null) {
      return null;
    } else {
      SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
      return df.format(date);
    }

  }

  static public String stripExtraInformation(String message) {
    String cleanedMsg;
    // if the message is a directly from postgres generated one, it has an 'ERROR :' prefix
    // if it is passed via an AD_PINSTACE result, then the 'ERROR: ' has already been stripped
    if ((message.length() > 7) && (message.startsWith("ERROR: "))) {
      cleanedMsg = message.substring(7);
    } else {
      cleanedMsg = message;
    }
    // remove technical information added by the PostgreSQL JDBC driver
    int pos = cleanedMsg.indexOf("\n  Where: ");
    if (pos != -1) {
      cleanedMsg = cleanedMsg.substring(0, pos);
    }

    return cleanedMsg;
  }

  static public String getErrorMessage(Exception e) {
    Throwable throwable = DbUtility.getUnderlyingSQLException(e);
    String message = OBMessageUtils.translateError(throwable.getMessage()).getMessage();
    return stripExtraInformation(message);
  }
}