package com.sidesoft.hrm.payroll.ad_callouts;

import javax.servlet.ServletException;

import org.apache.commons.lang.StringUtils;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;

public class Add_Operation extends SimpleCallout {

  private static final long serialVersionUID = 1L;

  @Override
  protected void execute(CalloutInfo info) throws ServletException {

    // Parámetros recibidos del formulario
    String strOperation = info.getStringParameter("inpoperation", null);
    String strAmount   = info.getStringParameter("inpamount", null);
    String strFormula  = info.getStringParameter("inpformula", null);

    if (strFormula == null) {
      strFormula = "";
    }
    if (strOperation == null) {
      return;
    }

    // =========================
    // Lógica original del callout
    // =========================

    if (isArithmeticOperator(strOperation)) {
      strFormula = strFormula + " " + strOperation;

      if (StringUtils.isNotBlank(strAmount)) {
        strFormula = strFormula + " " + strAmount;
      }

    } else if (isParenthesis(strOperation)) {
      strFormula = strFormula + " " + strOperation;

    } else if ("BS".equals(strOperation)) { // Backspace

      if (strFormula.endsWith(">")) {
        strFormula = strFormula.substring(0, strFormula.lastIndexOf("<"));
      } else if (strFormula.length() == 1) {
        strFormula = "";
      } else if (strFormula.contains(" ")) {
        strFormula = strFormula.substring(0, strFormula.lastIndexOf(" "));
      } else {
        strFormula = "";
      }
    }

    // Resultado al campo destino
    info.addResult("inpformula", strFormula.trim());
  }

  // =========================
  // Métodos auxiliares
  // =========================

  private boolean isArithmeticOperator(String op) {
    return "+".equals(op) || "-".equals(op) || "*".equals(op) || "/".equals(op);
  }

  private boolean isParenthesis(String op) {
    return "(".equals(op) || ")".equals(op);
  }
}

