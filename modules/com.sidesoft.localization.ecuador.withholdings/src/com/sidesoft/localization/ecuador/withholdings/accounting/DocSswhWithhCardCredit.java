package com.sidesoft.localization.ecuador.withholdings.accounting;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.dal.core.OBContext;
import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.ad_forms.Account;
import org.openbravo.erpCommon.ad_forms.AcctSchema;
import org.openbravo.erpCommon.ad_forms.AcctServer;
import org.openbravo.erpCommon.ad_forms.DocLine;
import org.openbravo.erpCommon.ad_forms.Fact;
import org.openbravo.erpCommon.ad_forms.FactLine;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.SequenceIdData;
import org.openbravo.erpCommon.utility.Utility;

public class DocSswhWithhCardCredit extends AcctServer {
  private static final long serialVersionUID = 1L;
  private String SeqNo = "0";
  protected Logger logger = Logger.getLogger(this.getClass());
  private DocSswhWithhCardCreditData[] headerData = null;
  String strMessage = null;

  static Logger loggerDocWithhCardCredit = Logger.getLogger(DocSswhWithhCardCredit.class);

  public static final String DOCTYPE_Payroll = "SFB_BC";

  /**
   * Constructor
   * 
   * @param AD_Client_ID
   *          AD_Client_ID
   */

  public DocSswhWithhCardCredit() {

  }

  public DocSswhWithhCardCredit(String AD_Client_ID, String AD_Org_ID,
      ConnectionProvider connectionProvider) {
    super(AD_Client_ID, AD_Org_ID, connectionProvider);
  }

  public String nextSeqNo(String oldSeqNo) {
    loggerDocWithhCardCredit.debug("DocSswhWithhCardCredit - oldSeqNo = " + oldSeqNo);
    BigDecimal seqNo = new BigDecimal(oldSeqNo);
    SeqNo = (seqNo.add(new BigDecimal("10"))).toString();
    loggerDocWithhCardCredit.debug("DocSswhWithhCardCredit - nextSeqNo = " + SeqNo);
    return SeqNo;
  }

  public void loadObjectFieldProvider(ConnectionProvider conn, String stradClientId, String Id)
      throws ServletException {
    setObjectFieldProvider(DocSswhWithhCardCreditData.selectRecord(conn, stradClientId, Id));
  }

  /**
   * Load Specific Document Details
   * 
   * @return true if loadDocumentType was set
   */
  public boolean loadDocumentDetails(FieldProvider[] data, ConnectionProvider conn) {
    DocumentType = DOCTYPE_Payroll;
    loggerDocWithhCardCredit
        .debug("data.length = " + data.length + " - DocumentType = " + DocumentType);

    // Amounts
    Amounts[AcctServer.AMTTYPE_Gross] = data[0].getField("Value");
    if (Amounts[AcctServer.AMTTYPE_Gross] == null)
      Amounts[AcctServer.AMTTYPE_Gross] = ZERO.toString();

    loadDocumentType(); // lines require doc type

    // Contained Objects
    p_lines = loadLines(conn);
    loggerDocWithhCardCredit.debug("Lines=" + p_lines.length);
    return true;
  } // loadDocumentDetails

  /**
   * Load Budget Certificate Line
   * 
   * @return DocLine Array
   */
  private DocLine[] loadLines(ConnectionProvider conn) {
    ArrayList<Object> list = new ArrayList<Object>();
    DocLineSswhWithhCardCreditData[] data = null;
    try {
      headerData = DocSswhWithhCardCreditData.selectRecord(connectionProvider, AD_Client_ID,
          Record_ID);
      if (headerData.length == 0) {
        String language = OBContext.getOBContext().getLanguage().getLanguage();
        strMessage = Utility.messageBD(conn, "NoRecordsFound", language);
        OBError err = new OBError();
        err.setType("Error");
        err.setMessage(strMessage);
        setMessageResult(err);
      }
      data = DocLineSswhWithhCardCreditData.select(connectionProvider, Record_ID);

    } catch (ServletException e) {
      loggerDocWithhCardCredit.warn(e);
    }

    for (int i = 0; data != null && i < data.length; i++) {
      String Line_ID = data[i].sswhWithhCardCreditId;
      DocLine_SswhWithhCardCredit docLine = new DocLine_SswhWithhCardCredit(DocumentType, Record_ID,
          Line_ID);
      docLine.loadAttributes(data[i], this);

      docLine.m_withhRent = data[i].withhRent;
      docLine.m_withhVat = data[i].withhVat;
      docLine.m_total = data[i].total;

      list.add(docLine);
    }
    // Return Array
    DocLine[] dl = new DocLine[list.size()];
    list.toArray(dl);
    return dl;
  } // loadLines

  public Fact createFact(AcctSchema as, ConnectionProvider conn, Connection con,
      VariablesSecureApp vars) throws ServletException {

    loggerDocWithhCardCredit.debug("Starting create fact");

    // create Fact Header
    Fact fact = new Fact(this, as, Fact.POST_Actual);

    String Fact_Acct_Group_ID = SequenceIdData.getUUID();

    String language = OBContext.getOBContext().getLanguage().getLanguage();

    ConceptInfoData[] data = ConceptInfoData.selectDefaultAcct(conn, as.getC_AcctSchema_ID());

    // Lines
    for (int i = 0; p_lines != null && i < p_lines.length; i++) {
      DocLine_SswhWithhCardCredit line = (DocLine_SswhWithhCardCredit) p_lines[i];

      try {

        if (StringUtils.isBlank(data[0].cWithhrent)) {
          strMessage = Utility.messageBD(conn,
              "La cuenta <b>Retencion Renta</b> no se encuentra configurada en el Esquema Contable: ",
              language);
          OBError err = new OBError();
          err.setType("Error");
          err.setMessage(strMessage);
          setMessageResult(err);
        }
        if (StringUtils.isBlank(data[0].cWithhvat)) {
          strMessage = Utility.messageBD(conn,
              "La cuenta: <b>Retencion IVA</b> no se encuentra configurada en el Esquema Contable: ",
              language);
          OBError err = new OBError();
          err.setType("Error");
          err.setMessage(strMessage);
          setMessageResult(err);
        }
        if (StringUtils.isBlank(data[0].cClosing)) {
          strMessage = Utility.messageBD(conn,
              "La cuenta: <b>Valores en transito</b> no se encuentra configurada en el Esquema Contable: ",
              language);
          OBError err = new OBError();
          err.setType("Error");
          err.setMessage(strMessage);
          setMessageResult(err);
        }
        // Accounts General
        fact.createLine(line, Account.getAccount(conn, data[0].cWithhrent), C_Currency_ID,
            line.getM_withhRent(), "", Fact_Acct_Group_ID, nextSeqNo("10"), DocumentType, conn);
        fact.createLine(line, Account.getAccount(conn, data[0].cWithhvat), C_Currency_ID,
            line.getM_withhVat(), "", Fact_Acct_Group_ID, nextSeqNo("20"), DocumentType, conn);

      } catch (ServletException e) {
        loggerDocWithhCardCredit.warn(e);
      }
    }

    FactLine closing = fact.balanceSource(conn);
    closing.setAccount(as, Account.getAccount(conn, data[0].cClosing));

    SeqNo = "0";
    return fact;

  }// createFact

  /**
   * Get Source Currency Balance - subtracts line amounts from total - no rounding
   * 
   * @return positive amount, if total invoice is bigger than lines
   */
  public BigDecimal getBalance() {
    return ZERO; // Lines are balanced
  } // getBalance

  /**
   * Get Document Confirmation
   * 
   * not used
   */
  public boolean getDocumentConfirmation(ConnectionProvider conn, String strRecordId) {
    return true;
  }

  public String getServletInfo() {
    return "Servlet for the accounting";
  } // end of getServletInfo() method
}
