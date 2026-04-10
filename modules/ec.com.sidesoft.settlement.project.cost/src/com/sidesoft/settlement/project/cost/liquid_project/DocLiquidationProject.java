package com.sidesoft.settlement.project.cost.liquid_project;

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

/**
 * MODULARIZACION CONTABILIDAD ENAJENACIÓN DE ACTIVOS CREADO POR: ING CARLOS CHIZA FECHA DE
 * CREACION: 8 DE MARZO DEL 2016
 */

public class DocLiquidationProject extends AcctServer {
  private static final long serialVersionUID = 1L;
  private String SeqNo = "0";
  protected Logger logger = Logger.getLogger(this.getClass());
  static Logger log4jDocLiquidateProject = Logger.getLogger(DocLiquidationProject.class);
  public String strMessage = null;

  private static final String SSTPC_COST = "4";
  private static final String SSTPC_COSTNEW = "5";

  // Final Settlement
  public static final String DOCTYPE_LiquidationProjects = "SSTPC_LQ";

  public DocLiquidationProject() {
  }

  public DocLiquidationProject(String AD_Client_ID, String AD_Org_ID,
      ConnectionProvider connectionProvider) {
    super(AD_Client_ID, AD_Org_ID, connectionProvider);
  }

  public String nextSeqNo(String oldSeqNo) {
    log4jDocLiquidateProject.debug("DocSettlement - oldSeqNo = " + oldSeqNo);
    BigDecimal seqNo = new BigDecimal(oldSeqNo);
    SeqNo = (seqNo.add(new BigDecimal("10"))).toString();
    log4jDocLiquidateProject.debug("DocSettlement - nextSeqNo = " + SeqNo);
    return SeqNo;
  }

  public void loadObjectFieldProvider(ConnectionProvider conn, String stradClientId, String Id)
      throws ServletException {
    setObjectFieldProvider(DocLiquidationProjectData.selectRecord(conn, stradClientId, Id));
  }

  @Override
  public boolean loadDocumentDetails(FieldProvider[] data, ConnectionProvider conn) {
    DocumentType = DOCTYPE_LiquidationProjects;
    log4jDocLiquidateProject.debug("data.length = " + data.length + " - DocumentType = "
        + DocumentType);

    // Amounts
    Amounts[AcctServer.AMTTYPE_Gross] = data[0].getField("Value");
    if (Amounts[AcctServer.AMTTYPE_Gross] == null)
      Amounts[AcctServer.AMTTYPE_Gross] = ZERO.toString();

    loadDocumentType(); // lines require doc type

    // Contained Objects
    p_lines = loadLines(conn);
    log4jDocLiquidateProject.debug("Lines=" + p_lines.length);
    return true;
  } // loadDocumentDetails

  private DocLine[] loadLines(ConnectionProvider conn) {
    ArrayList<Object> list = new ArrayList<Object>();
    DocLineLiquidationProjectData[] data = null;

    try {
      data = DocLineLiquidationProjectData.select(conn, Record_ID);
    } catch (ServletException e) {
      log4jDocLiquidateProject.warn(e);
    }

    for (int i = 0; data != null && i < data.length; i++) {
        String Line_ID = "";
        Line_ID = data[i].sstpcConsumptionLineId;
        DocLine_LiquidationProject docLine = new DocLine_LiquidationProject(DocumentType, Record_ID,
                Line_ID);
        docLine.loadAttributes(data[i], this);
        docLine.m_ssptc_liquidation_projects_id = data[i].sstpcLiquidationProjectsId;
        docLine.m_p_cogs_product_id = data[i].pCogsAcct;
        docLine.m_sstpc_newcost = data[i].emSstpcCostProcessProd;
        docLine.m_amount = data[i].amount;
        docLine.m_netvalue = data[i].amount;
        list.add(docLine);
    }

    // Return Array
    DocLine[] dl = new DocLine[list.size()];
    list.toArray(dl);
    return dl;
  } // loadLines

  public Fact createFact(AcctSchema as, ConnectionProvider conn, Connection con,
      VariablesSecureApp vars) throws ServletException {
    log4jDocLiquidateProject.debug("createFact - Inicio");

    // create Fact Header
    Fact fact = null;
    String Fact_Acct_Group_ID = SequenceIdData.getUUID();
    log4jDocLiquidateProject.debug("createFact - object created");
    log4jDocLiquidateProject.debug("createFact - p_lines.length - " + p_lines.length);
    // Lines
    fact = new Fact(this, as, Fact.POST_Actual);
    for (int i = 0; p_lines != null && i < p_lines.length; i++) {
      DocLine_LiquidationProject line = (DocLine_LiquidationProject) p_lines[i];

      // log4jDocAlienate.debug("createFact - low asset");
      fact.createLine(line, getAccount(SSTPC_COST, line.m_p_cogs_product_id, as, conn),
          line.m_C_Currency_ID, line.m_netvalue, "", Fact_Acct_Group_ID, nextSeqNo(SeqNo),
          DocumentType, conn);
      fact.createLine(line, getAccount(SSTPC_COSTNEW, line.m_sstpc_newcost, as, conn),
          line.m_C_Currency_ID, "", line.m_amount, Fact_Acct_Group_ID, nextSeqNo(SeqNo),
          DocumentType, conn);

      // DocLiquidationProjectAcctData.updateStatusAsset(conn, line.m_typereason,
      // line.m_a_asset_id);

    }
    SeqNo = "0";
    return fact;
  } // createFact

  public Account getAccount(String AcctType, String A_Asset_ID, AcctSchema as,
      ConnectionProvider conn) {
    if (Integer.parseInt(AcctType) < 1 || Integer.parseInt(AcctType) > 10)
      return null;

    DocLiquidationProjectAcctData[] data = null;
    Account acc = null;
    try {
      // data = DocLiquidationProjectAcctData.selectAcct(conn, A_Asset_ID, as.getC_AcctSchema_ID());
      // if (data == null || data.length == 0)
      // return null;

      String validCombination_ID = "";
      switch (Integer.parseInt(AcctType)) {

      case 4:
        // validCombination_ID = data[0].pCogsAcct;
        validCombination_ID = A_Asset_ID;

        if (validCombination_ID == null || validCombination_ID.equals("")) {
          String language = OBContext.getOBContext().getLanguage().getLanguage();
          /*
           * strMessage = Utility.messageBD(conn, "Asset: Historic Account is null " +
           * data[0].nameassets, language);
           */
          OBError err = new OBError();
          err.setType("Error");
          err.setMessage(strMessage);
          setMessageResult(err);
        }
        break;
      case 5:
        // validCombination_ID = data[0].emSstpcCostProcessProd;

        validCombination_ID = A_Asset_ID;
        if (validCombination_ID == null || validCombination_ID.equals("")) {
          String language = OBContext.getOBContext().getLanguage().getLanguage();
          /*
           * strMessage = Utility.messageBD(conn, "Asset: Result Alienate Account is null " +
           * data[0].nameassets, language);
           */
          OBError err = new OBError();
          err.setType("Error");
          err.setMessage(strMessage);
          setMessageResult(err);
        }
        break;
      }
      if (validCombination_ID.equals(""))
        return null;
      acc = Account.getAccount(conn, validCombination_ID);
      log4jDocLiquidateProject.debug("DocAmortization - getAccount - " + acc.Account_ID);
    } catch (ServletException e) {
      log4jDocLiquidateProject.warn(e);
    }
    return acc;
  } // getAccount

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
