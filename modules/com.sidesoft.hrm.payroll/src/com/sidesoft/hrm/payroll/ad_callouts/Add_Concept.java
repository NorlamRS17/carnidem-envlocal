package com.sidesoft.hrm.payroll.ad_callouts;

import javax.servlet.ServletException;

import org.openbravo.erpCommon.ad_callouts.SimpleCallout;

public class Add_Concept extends SimpleCallout {

  private static final long serialVersionUID = 1L;

  @Override
  protected void execute(CalloutInfo info) throws ServletException {

    // Leer parámetros enviados por el formulario
    String strChanged = info.getStringParameter("inpLastFieldChanged", null);
    String strConceptFormulaId = info.getStringParameter("inpssprConceptFormulaId", null);
    String strFormula = info.getStringParameter("inpformula", null);

    if (strFormula == null) {
      strFormula = "";
    }

    try {
      // Mantiene la lógica original:
      // Si hay fórmula seleccionada, concatenar su valor
      if (strConceptFormulaId != null && !strConceptFormulaId.isEmpty()) {
        String strConceptFormulaValue = AddConceptData.select(this, strConceptFormulaId);
        strFormula = strFormula + " <" + strConceptFormulaValue + ">";
      }

      // Devolver el valor al campo inpformula
      info.addResult("inpformula", strFormula.trim());

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}

