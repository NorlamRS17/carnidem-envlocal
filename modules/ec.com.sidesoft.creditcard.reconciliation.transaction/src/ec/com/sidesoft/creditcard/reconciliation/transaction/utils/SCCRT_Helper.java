package ec.com.sidesoft.creditcard.reconciliation.transaction.utils;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

public abstract class SCCRT_Helper {

  static public String getString(Cell cell) throws Exception {
    if (cell.getCellTypeEnum().equals(CellType.NUMERIC)) {
      cell.setCellType(Cell.CELL_TYPE_STRING);
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

  static public boolean isRowEmpty(Row row) {
    boolean isEmpty = true;
    DataFormatter dataFormatter = new DataFormatter();

    if (row != null) {
      for (Cell cell : row) {
        if (dataFormatter.formatCellValue(cell).trim().length() > 0) {
          isEmpty = false;
          break;
        }
      }
    }

    return isEmpty;
  }

}
