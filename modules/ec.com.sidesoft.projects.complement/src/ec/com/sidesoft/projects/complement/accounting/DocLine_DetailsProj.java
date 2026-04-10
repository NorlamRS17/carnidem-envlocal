package ec.com.sidesoft.projects.complement.accounting;

import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.ad_forms.Account;
import org.openbravo.erpCommon.ad_forms.AcctSchema;
import org.openbravo.erpCommon.ad_forms.DocLine;

public class DocLine_DetailsProj extends DocLine {

  public DocLine_DetailsProj(String DocumentType, String TrxHeader_ID, String TrxLine_ID) {
    super(DocumentType, TrxHeader_ID, TrxLine_ID);
    // TODO Auto-generated constructor stub
  }

  // References
  public String m_SPROCTM_in_proces_c_elementvalue_id = "";
  public String m_SPROCTM_transfer_c_elementvalue_id = "";
  public String m_SPROCTM_setlement_c_elementvalue_id = "";
  public String m_SPROCTM_C_Salary_Category_ID = "";

  public String m_SPROCTM_record_id = "";
  public String m_SPROCTM_SalaryCategoryId = "";
  public String m_SPROCTM_cost = "";
  public String m_SPROCTM_hours = "";
  public String m_SPROCTM_IsPosted = "";
  public String m_SPROCTM_C_CURRENCY_ID = "";
  public String m_SSPR_CONCEPT_ID = "";
  public String m_EM_SSPR_CATEGORY_ACCT_ID = "";
  // References
  public String m_SSPR_Concept_ID = "";
  public String m_SSPR_Category_Acct_ID = "";
  public String m_IsBalance = "N";

  /**
   * Get Amount
   * 
   * @return Amount
   */
  public String getAmount() {
    return m_SPROCTM_cost;
  }

  /**
   * Set Amount
   * 
   * @param Amount
   *          amount
   */
  public void setAmount(String Amount) {
    if (!Amount.equals(""))
      m_SPROCTM_cost = Amount;
    super.setAmount(Amount);
  } // setAmount

  /**
   * Line Account from Business Concept.
   * 
   * @param AcctType
   *          see BusinessConcept.ACCTTYPE_* (0..3)
   * @param as
   *          Accounting schema
   * @param AcctCategory
   *          Accounting Category
   * @return Requested Business Concept Account
   */
  public Account getAccount(String AcctType, AcctSchema as, String AcctCategory,
      ConnectionProvider conn) {
    ConceptInfo c_conceptInfo = new ConceptInfo(AcctCategory, conn);
    // Concept Account
    return c_conceptInfo.getAccount(AcctType, as, AcctCategory, conn);
  }

  public String getServletInfo() {
    return "Servlet for the accounting";
  } // end of getServletInfo() method
}
