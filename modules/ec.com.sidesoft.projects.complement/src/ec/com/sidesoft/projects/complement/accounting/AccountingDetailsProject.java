package ec.com.sidesoft.projects.complement.accounting;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import org.openbravo.service.db.DalConnectionProvider;

public class AccountingDetailsProject extends AcctServer {
  // private static final long serialVersionUID = 1L;
  // static Logger log4jDocInventory = Logger.getLogger(AccountingDetailsProject.class);
  private ConnectionProvider conector;
  public String DocumentType = "";

  private static final long serialVersionUID = 1L;
  // protected Logger logger = Logger.getLogger(this.getClass());
  // static Logger log4jAccDetailsProj = Logger.getLogger(AccountingDetailsProject.class);
  public String strMessage = null;

  private String SeqNo = "0";
  // private Category log4j;
  public String detailCostId;

  public static final String DOCTYPE_TaskProject = "SPROCTM_TP";
  public Connection conPrincipal;
  public Logger log4jDocProjectTask = Logger.getLogger(AccountingDetailsProject.class);

  public static final String ACCTTYPE_C_Debit = "1";
  /** Concept C_Credit Acct */
  public static final String ACCTTYPE_C_Credit = "2";
  /** Concept C_Closing Acct */
  public static final String ACCTTYPE_C_Closing = "3";

  public AccountingDetailsProject() {

  }

  public AccountingDetailsProject(String AD_Client_ID, String AD_Org_ID,
      ConnectionProvider connectionProvider) {
    super(AD_Client_ID, AD_Org_ID, connectionProvider);
  }

  public String nextSeqNo(String oldSeqNo) {
    BigDecimal seqNo = new BigDecimal(oldSeqNo);
    SeqNo = (seqNo.add(new BigDecimal("10"))).toString();
    return SeqNo;
  }

  @Override
  public void loadObjectFieldProvider(ConnectionProvider conn, String stradClientId, String Id)
      throws ServletException {
    detailCostId = Id;
    setObjectFieldProvider(AccountingDetailsProjectData.selectRecord(conn, Id));
  }

  @Override
  public boolean loadDocumentDetails(FieldProvider[] data, ConnectionProvider conn) {
    // TODO Auto-generated method stub
    // log4jAccDetailsProj.debug("data.length = " + data.length + " - DocumentType = " +
    DocumentType = DOCTYPE_TaskProject;
    C_Currency_ID = "100";

    loadDocumentType(); // lines require doc type

    // Contained Objects
    p_lines = loadLines(conn);
    // log4jAccDetailsProj.debug("Lines=" + p_lines.length);
    return true;

  }

  @Override
  public BigDecimal getBalance() {
    // TODO Auto-generated method stub
    return ZERO;
  }

  @Override
  public Fact createFact(AcctSchema as, ConnectionProvider conn, Connection con,
      VariablesSecureApp vars) throws ServletException {

    log4jDocProjectTask.debug("Starting create fact");
    // p_lines = loadLines(conn);
    // create Fact Header
    Fact fact = new Fact(this, as, Fact.POST_Actual);

    String Fact_Acct_Group_ID = SequenceIdData.getUUID();
    Double amount = 0.0;

    // Lines
    for (int i = 0; p_lines != null && i < p_lines.length; i++) {
      DocLine_DetailsProj line = (DocLine_DetailsProj) p_lines[i];

      try {
        if (!line.m_IsBalance.equals("Y")) {

          Account account = Account.getAccount(conn, line.m_SPROCTM_in_proces_c_elementvalue_id);

          fact.createLine(line, account, line.m_C_Currency_ID, "", line.m_AmtAcctCr,
              Fact_Acct_Group_ID, nextSeqNo(SeqNo), DOCTYPE_TaskProject, conn);

        } else {

          Account account = Account.getAccount(conn, line.m_SPROCTM_in_proces_c_elementvalue_id);

          fact.createLine(line, account, line.m_C_Currency_ID, line.m_AmtAcctDr, "",
              Fact_Acct_Group_ID, nextSeqNo(SeqNo), DOCTYPE_TaskProject, conn);
        }
      } catch (Exception e) {
        log4jDocProjectTask.warn(e);
      }
    }
    // StrFlag = "NOMINA";
    // FactLine closing = fact.balanceSource(conn);
    // closing.setAccount(as, ConceptInfo.getAccountDefault(ConceptInfo.ACCTTYPE_C_Closing, as,
    // conn));
    // StrFlag = "ND";
    SeqNo = "0";
    return fact;

  }

  public static String getAccCombination(String accountId) throws Exception {
    ConnectionProvider conn = new DalConnectionProvider(false);
    PreparedStatement st = null;
    String sql = " SELECT C_ValidCombination_id FROM C_ValidCombination  "
        + "   where account_id = '" + accountId + "'";
    String v_combinationId = null;
    st = conn.getPreparedStatement(sql);
    ResultSet rs = st.executeQuery();
    try {
      while (rs.next()) {
        v_combinationId = rs.getString("C_ValidCombination_id");
      }
    } catch (Exception e) {
      System.out.println(e);
      rs.close();
      st.close();
    }
    rs.close();
    st.close();
    return (v_combinationId == null) ? null : v_combinationId;
  }

  private DocLine[] loadLines(ConnectionProvider conn) {

    ConnectionProvider connProvider = new DalConnectionProvider(false);
    conn = connProvider;

    ArrayList<Object> list = new ArrayList<Object>();

    DocLineProjecxtTaskData[] data = null;
    try {
      String businessPartner = null;
      Double amount = 0.0;
      Integer line = 10;
      String strMessage = "";
      // AcctServer vo = null;
      DocProjecxtTaskData headerData[] = DocProjecxtTaskData.selectRecord(connectionProvider,
          Record_ID);
      if (headerData.length == 0) {
        String language = OBContext.getOBContext().getLanguage().getLanguage();
        strMessage = Utility.messageBD(conn, "NoRecordsFound", language);
        OBError err = new OBError();
        err.setType("Error");
        err.setMessage(strMessage);
        setMessageResult(err);
      }
      data = DocLineProjecxtTaskData.select(connectionProvider, Record_ID);

      int totalData = data.length;
      for (int i = 0; data != null && i < data.length; i++) {
        String t_Line_ID = data[i].sproctmTaskWorkforceId;

        businessPartner = data[i].cBpartnerId;
        if (businessPartner != null) {

          if (data.length > 0 // && !data[0].balanceacctId.equals("")
          ) {
            DocLine_DetailsProj docLine = new DocLine_DetailsProj(DOCTYPE_TaskProject, Record_ID,
                null);
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
            docLine.m_C_BPartner_ID = businessPartner;
            list.add(docLine);
          } else {
            String language = OBContext.getOBContext().getLanguage().getLanguage();
            strMessage = Utility.messageBD(connectionProvider, "20270", language);
            OBError err = new OBError();
            err.setType("Error");
            err.setMessage(strMessage);
            setMessageResult(err);
          }
        }
      }
    } catch (ServletException e) {
      // log4jDocPayroll.warn(e);
    }
    // Return Array
    DocLine[] dl = new DocLine[list.size()];
    list.toArray(dl);
    return dl;
  } // loadLines

  @Override
  public boolean getDocumentConfirmation(ConnectionProvider conn, String strRecordId) {
    // TODO Auto-generated method stub
    return true;
  }

  public String getServletInfo() {
    return "Servlet for the accounting";
  } // end of getServletInfo() method

}