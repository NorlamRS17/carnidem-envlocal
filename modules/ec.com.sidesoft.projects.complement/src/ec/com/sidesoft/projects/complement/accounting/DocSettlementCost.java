package ec.com.sidesoft.projects.complement.accounting;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;

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
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.SequenceIdData;
import org.openbravo.erpCommon.utility.Utility;

/**
 * MODULARIZACION CONTABILIDAD LIQUIDACION DE EMPLEADOS CREADO POR: ING DIEGO ARMANDO GUALLASAMIN
 * COLUMBA FECHA DE CREACION: 12 DE JULIO EL 2022
 */

public class DocSettlementCost extends AcctServer {
  private static final long serialVersionUID = 1L;
  private String SeqNo = "0";
  protected Logger logger = Logger.getLogger(this.getClass());
  static Logger log4jDocSettlementCost = Logger.getLogger(DocSettlementCost.class);
  public String strMessage = null;

  // Final Settlement
  public static final String DOCTYPE_SettlementCost = "CSAAA_ANC";

  public DocSettlementCost() {
  }

  public DocSettlementCost(String AD_Client_ID, String AD_Org_ID,
      ConnectionProvider connectionProvider) {
    super(AD_Client_ID, AD_Org_ID, connectionProvider);
  }

  public String nextSeqNo(String oldSeqNo) {
    log4jDocSettlementCost.debug("DocSettlementCost - oldSeqNo = " + oldSeqNo);
    BigDecimal seqNo = new BigDecimal(oldSeqNo);
    SeqNo = (seqNo.add(new BigDecimal("10"))).toString();
    log4jDocSettlementCost.debug("DocSettlementCost - nextSeqNo = " + SeqNo);
    return SeqNo;
  }

  public void loadObjectFieldProvider(ConnectionProvider conn, String stradClientId, String Id)
      throws ServletException {
    setObjectFieldProvider(AccountingSettlementCostData.selectRecord(conn, Id));
  }

  @Override
  public boolean loadDocumentDetails(FieldProvider[] data, ConnectionProvider conn) {
    DocumentType = DOCTYPE_SettlementCost;
    log4jDocSettlementCost
        .debug("data.length = " + data.length + " - DocumentType = " + DocumentType);

    // Amounts
    Amounts[AcctServer.AMTTYPE_Gross] = data[0].getField("Value");
    if (Amounts[AcctServer.AMTTYPE_Gross] == null)
      Amounts[AcctServer.AMTTYPE_Gross] = ZERO.toString();

    loadDocumentType(); // lines require doc type

    // Contained Objects
    p_lines = loadLines(conn);
    log4jDocSettlementCost.debug("Lines=" + p_lines.length);
    return true;
  } // loadDocumentDetails

  private DocLine[] loadLines(ConnectionProvider conn) {
    ArrayList<Object> list = new ArrayList<Object>();
    DocLineSettlementCostData data[] = null;
    Integer line = 10;

    try {
      // data = DocLineSettlementCostData.select(conn, DOCTYPE_SettlementCost,
      // DOCTYPE_SettlementCost, DOCTYPE_SettlementCost, DOCTYPE_SettlementCost,
      // DOCTYPE_SettlementCost, strMessage, SeqNo, DOCTYPE_SettlementCost, AMTTYPE_Charge,
      // AMTTYPE_Allocation)
      // (ConnectionProvider connectionProvider, String ProjectID, String DateTo, String PhaseID,
      // String TaskID, String Project1ID, String DateTo1, String Project2ID, String DateTo2, int
      // firstRegister, int numberRegisters)

      // (connectionProvider, Record_ID, Record_ID);
      Double amount = 0.0;
      Integer line2 = 10;
      String strMessage = "";
      // AcctServer vo = null;
      AccountingSettlementCostData headerData[] = AccountingSettlementCostData
          .selectRecord(connectionProvider, Record_ID);
      if (headerData.length == 0) {
        String language = OBContext.getOBContext().getLanguage().getLanguage();
        strMessage = Utility.messageBD(conn, "NoRecordsFound", language);
        OBError err = new OBError();
        err.setType("Error");
        err.setMessage(strMessage);
        setMessageResult(err);
      }

      String strProjectID = headerData[0].cProjectId.toString().equals("ND") ? null
          : headerData[0].cProjectId;
      String strPhaseID = headerData[0].cProjectphaseId.toString().equals("ND") ? null
          : headerData[0].cProjectphaseId;
      String strTaskID = headerData[0].cProjecttaskId.toString().equals("ND") ? null
          : headerData[0].cProjecttaskId;

      data = DocLineSettlementCostData.select(connectionProvider, Record_ID, strProjectID,
          Record_ID, strPhaseID, strTaskID, Record_ID, strProjectID, Record_ID, Record_ID,
          strProjectID, Record_ID);

      for (int i = 0; data != null && i < data.length; i++) {
        String t_Line_ID = data[i].sproctmTaskWorkforceId;
        DocLine_SettlementCost docLine = new DocLine_SettlementCost(DocumentType, Record_ID,
            t_Line_ID);
        Account balanceAccount = new Account(connectionProvider, data[i].accountId);
        balanceAccount.Account_ID = data[i].accountId;
        docLine.loadAttributes(headerData[0], this);
        docLine.setAccount(balanceAccount);
        docLine.m_IsBalance = data[i].isbalance;
        docLine.m_SPROCTM_in_proces_c_elementvalue_id = data[i].accountId;
        docLine.m_SSPR_Concept_ID = data[i].accountId;
        docLine.m_C_Currency_ID = data[i].cCurrencyId;
        docLine.setAmount(data[i].amount);
        docLine.m_SPROCTM_cost = data[i].amount;
        if (data[i].isbalance.equals("Y")) {
          docLine.m_AmtAcctDr = data[i].amount;
        } else {
          docLine.m_AmtAcctCr = data[i].amount;
        }

        docLine.m_Line = line.toString();

        line += 10;
        docLine.setAmount(amount.toString());
        // docLine.m_C_BPartner_ID = businessPartner;
        list.add(docLine);
        line += 10;
      }
    } catch (Exception e) {
      log4jDocSettlementCost.warn(e);
    }
    // Return Array
    DocLine[] dl = new DocLine[list.size()];
    list.toArray(dl);
    return dl;
  } // loadLines

  @SuppressWarnings("unused")
  public Fact createFact(AcctSchema as, ConnectionProvider conn, Connection con,
      VariablesSecureApp vars) throws ServletException {

    log4jDocSettlementCost.debug("Starting create fact");

    // create Fact Header
    Fact fact = new Fact(this, as, Fact.POST_Actual);

    String Fact_Acct_Group_ID = SequenceIdData.getUUID();
    Double amount = 0.0;

    // Lines
    for (int i = 0; p_lines != null && i < p_lines.length; i++) {
      DocLine_SettlementCost line = (DocLine_SettlementCost) p_lines[i];

      try {
        if (!line.m_IsBalance.equals("Y")) {

          Account account = Account.getAccount(conn, line.m_SPROCTM_in_proces_c_elementvalue_id);

          fact.createLine(line, account, line.m_C_Currency_ID, "", line.m_AmtAcctCr,
              Fact_Acct_Group_ID, nextSeqNo(SeqNo), DOCTYPE_SettlementCost, conn);

        } else {

          Account account = Account.getAccount(conn, line.m_SPROCTM_in_proces_c_elementvalue_id);

          fact.createLine(line, account, line.m_C_Currency_ID, line.m_AmtAcctDr, "",
              Fact_Acct_Group_ID, nextSeqNo(SeqNo), DOCTYPE_SettlementCost, conn);
        }
      } catch (Exception e) {
        log4jDocSettlementCost.warn(e);
      }
    }

    // FactLine closing = fact.balanceSource(conn);
    // closing.setAccount(as, ConceptInfo.getAccountDefault(ConceptInfo.ACCTTYPE_C_Closing, as,
    // conn));

    SeqNo = "0";
    return fact;

  }// createFact

  @Override
  public BigDecimal getBalance() {
    return ZERO; // Lines are balanced
  }

  public boolean getDocumentConfirmation(ConnectionProvider conn, String strRecordId) {
    return true;
  }

  public String getServletInfo() {
    return "Servlet for the accounting";
  } // end of getServletInfo() method

}
