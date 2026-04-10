package com.sidesoft.settlement.project.cost.liquid_project;

import org.openbravo.erpCommon.ad_forms.DocLine;

public class DocLine_LiquidationProject extends DocLine {

  public DocLine_LiquidationProject(String DocumentType, String TrxHeader_ID, String TrxLine_ID) {
    super(DocumentType, TrxHeader_ID, TrxLine_ID);
    // TODO Auto-generated constructor stub
  }

  public String m_ssptc_consumption_id;
  public String m_ssptc_liquidation_projects_id;
  public String m_p_cogs_product_id;
  public String m_sstpc_newcost;
  public String m_amount = ZERO.toString();
  public String m_netvalue = ZERO.toString();

}
