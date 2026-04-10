/*
 *************************************************************************
 * The contents of this file are subject to the Openbravo  Public  License
 * Version  1.0  (the  "License"),  being   the  Mozilla   Public  License
 * Version 1.1  with a permitted attribution clause; you may not  use this
 * file except in compliance with the License. You  may  obtain  a copy of
 * the License at http://www.openbravo.com/legal/license.html
 * Software distributed under the License  is  distributed  on  an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific  language  governing  rights  and  limitations
 * under the License.
 * The Original Code is Openbravo ERP.
 * The Initial Developer of the Original Code is Openbravo SLU
 * All portions are Copyright (C) 2014-2018 Openbravo SLU
 * All Rights Reserved.
 * Contributor(s):  ______________________________________.
 *************************************************************************
 */

package ec.com.sidesoft.creditcard.reconciliation.hqlinjections;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.openbravo.client.kernel.ComponentProvider;
import org.openbravo.service.datasource.hql.HqlQueryTransformer;
import org.openbravo.service.db.DalConnectionProvider;

@ComponentProvider.Qualifier("65C7190151DA4722896331211DD8440A")
public class AddFinaccTransformer extends HqlQueryTransformer {
  final static String RDBMS = new DalConnectionProvider(false).getRDBMS();
  final static String TABLE_ID = "65C7190151DA4722896331211DD8440A";

  @Override
  public String transformHqlQuery(String _hqlQuery, Map<String, String> requestParameters,
      Map<String, Object> queryNamedParameters) {
    String hqlQuery = _hqlQuery;
    // Retrieve Parameters
    StringBuffer whereClause = getWhereClause();

    String transformedHql = hqlQuery;
    transformedHql = transformedHql.replace("@whereClause@", whereClause.toString());

    // Sets parameters
    queryNamedParameters.put("financialAccountId",
        requestParameters.get("fin_financial_account_id"));
    queryNamedParameters.put("startDate", formatDate(requestParameters.get("start_date")));
    queryNamedParameters.put("endDate", formatDate(requestParameters.get("end_date")));
    return transformedHql;
  }

  protected StringBuffer getWhereClause() {

    StringBuffer whereClause = new StringBuffer();
    // Create WhereClause
    whereClause.append(" fat.account.id = :financialAccountId and ");
    whereClause.append(" e.transactionDate >= :startDate and ");
    whereClause.append(" e.transactionDate <= :endDate ");

    return whereClause;

  }

  protected Date formatDate(String date) {
    try {
      Date res = new SimpleDateFormat("yyyy-MM-dd").parse(date);
      return new SimpleDateFormat("yyyy-MM-dd").parse(date);
    } catch (Exception e) {
      return null;
      // TODO: handle exception
    }
  }
}