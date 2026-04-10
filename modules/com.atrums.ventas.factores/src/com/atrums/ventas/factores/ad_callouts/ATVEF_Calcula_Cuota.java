/*
 *************************************************************************
 * The contents of this file are subject to the Openbravo  Public  License
 * Version  1.1  (the  "License"),  being   the  Mozilla   Public  License
 * Version 1.1  with a permitted attribution clause; you may not  use this
 * file except in compliance with the License. You  may  obtain  a copy of
 * the License at http://www.openbravo.com/legal/license.html 
 * Software distributed under the License  is  distributed  on  an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific  language  governing  rights  and  limitations
 * under the License. 
 * The Original Code is Openbravo ERP. 
 * The Initial Developer of the Original Code is Openbravo SLU 
 * All portions are Copyright (C) 2001-2013 Openbravo SLU 
 * All Rights Reserved. 
 * Contributor(s):  ______________________________________.
 ************************************************************************
 */
package com.atrums.ventas.factores.ad_callouts;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.xmlEngine.XmlDocument;

public class ATVEF_Calcula_Cuota extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;

  public void init(ServletConfig config) {
    super.init(config);
    boolHist = false;
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
    VariablesSecureApp vars = new VariablesSecureApp(request);
    if (vars.commandIn("DEFAULT")) {
      String strChanged = vars.getStringParameter("inpLastFieldChanged");
      log4j.debug("CHANGED: " + strChanged);

      String strPOE = vars.getNumericParameter("inpmProductId_PSTD");
      String strPriceListId = vars.getStringParameter("inpmPricelistId");
      String strCTaxID = vars.getStringParameter("inpcTaxId");

      String strMProductID = vars.getStringParameter("inpmProductId");
      if (strMProductID.equals(""))
        strMProductID = vars.getStringParameter("inpemAtvefProduct2Id");
      String strPlazo = vars.getStringParameter("inpemAtvefCuota");
      String strEntrada = vars.getStringParameter("inpemAtvefEntrada");

      try {
        printPage(response, vars, strMProductID, strPlazo, strEntrada, strPOE, strCTaxID,
            strPriceListId);
      } catch (ServletException ex) {
        pageErrorCallOut(response);
      }
    } else
      pageError(response);
  }

  private void printPage(HttpServletResponse response, VariablesSecureApp vars,
      String strMProductID, String strPlazo, String strEntrada, String strPOE, String strCTaxID,
      String strPriceListId) throws IOException, ServletException {
    log4j.debug("Output: dataSheet");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate(
        "org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();

    StringBuffer resultado = new StringBuffer();
    resultado.append("var calloutName='ATVEF_Calcula_Cuota';\n\n");
    // Inicio Creditos

    int intPlazo = Integer.parseInt(strPlazo);

    int intPlazoIni = 0;

    ATVEFProductData[] precio = ATVEFProductData.select(this, strMProductID, strPriceListId);
    strPOE = precio[0].pricelist;

    BigDecimal bdPoe = new BigDecimal(strPOE);
    FactorData[] datosfactor = FactorData.select(this, strMProductID);

    if (!datosfactor.equals(null) && datosfactor.length > 0) {

      BigDecimal bdFinanciamiento = new BigDecimal(datosfactor[0].financiamiento);
      BigDecimal bdEntrada = new BigDecimal(datosfactor[0].entrada);
      BigDecimal bdRecargo = new BigDecimal(datosfactor[0].recargo);

      FactorData[] datosIva = FactorData.selectIva(this, strCTaxID);
      BigDecimal bdIva = new BigDecimal(datosIva[0].iva);

      BigDecimal bdValMEntrada = BigDecimal.ZERO;
      bdValMEntrada = ATVEF_Calculo.valor_Menos_Entrada(bdPoe, bdEntrada);

      BigDecimal bdRecargoMen = ATVEF_Calculo.recargoMensual(intPlazo, bdValMEntrada, bdRecargo);
      BigDecimal bdRecargoMenIni = ATVEF_Calculo.recargoMensual(intPlazoIni, bdValMEntrada,
          bdRecargo);

      BigDecimal bdPoeMasRiesgoIni = bdRecargoMenIni.add(bdPoe);

      BigDecimal bdPoeMasRiesgo = bdRecargoMen.add(bdPoe);

      BigDecimal bdPvpIvaIni = ATVEF_Calculo.pvpIncluyeIva(bdPoeMasRiesgoIni, bdIva);
      BigDecimal bdPvpIva = ATVEF_Calculo.pvpIncluyeIva(bdPoeMasRiesgo, bdIva);

      BigDecimal bdEntradaMin = ATVEF_Calculo.EntradaMinima(bdPvpIvaIni, bdEntrada);

      String message = "";

      if (intPlazo == 0)
        bdEntradaMin = BigDecimal.ZERO;
      else {
        if (strEntrada.equals("0.00")) {

          bdEntradaMin = ATVEF_Calculo.EntradaMinima(bdPvpIvaIni, bdEntrada);
          message = "El valor de la entrada no puede ser menor a la entrada mínima: "
              + bdEntradaMin.setScale(2, BigDecimal.ROUND_UP).toString();

        } else if (new BigDecimal(strEntrada.replace(",", "")).compareTo(bdEntradaMin) == -1) {

          bdEntradaMin = ATVEF_Calculo.EntradaMinima(bdPvpIvaIni, bdEntrada);
          message = "El valor de la entrada no puede ser menor a la entrada mínima: "
              + bdEntradaMin.setScale(2, BigDecimal.ROUND_UP).toString();
        } else {
          bdEntradaMin = new BigDecimal(strEntrada.replace(",", ""));
        }

      }
      BigDecimal bdPvpMenosEntrada = bdPvpIva.add(bdEntradaMin.negate());

      BigDecimal bdValCuota = ATVEF_Calculo.valorCuota(bdFinanciamiento, bdPvpMenosEntrada,
          intPlazo);

      BigDecimal dbSubTotal = bdValCuota.multiply(new BigDecimal(intPlazo));

      BigDecimal bdSubTotalSiva = dbSubTotal.divide(
          (bdIva.divide(new BigDecimal(100))).add(new BigDecimal(1)), 2);

      BigDecimal bdValFinanciamiento = BigDecimal.ZERO;

      if (intPlazo > 0) {
        // BigDecimal v1 = bdPvpMenosEntrada.divide(new BigDecimal(1.12), 2);
        // bdValFinanciamiento = bdSubTotalSiva.add(v1.negate());
        bdValFinanciamiento = dbSubTotal.add(bdPvpMenosEntrada.negate());
      }

      BigDecimal bdValorTotal = BigDecimal.ZERO;

      if (intPlazo > 0)
        bdValorTotal = bdEntradaMin.add(dbSubTotal);
      else
        bdValorTotal = bdPvpIva;

      resultado.append("var respuesta = new Array(");

      if (!message.equals(""))
        resultado.append("new Array(\"MESSAGE\", \"" + message + "\"),");

      resultado.append("new Array(\"inpemAtvefFinanciamiento\", \"" + bdValFinanciamiento + "\"),");
      resultado.append("new Array(\"inpemAtvefEntrada\", \"" + bdEntradaMin + "\"),");
      resultado.append("new Array(\"inpemAtvefValorcuota\", \"" + bdValCuota + "\"),");
      resultado.append("new Array(\"inppriceactual\", \""
          + bdValorTotal.divide((bdIva.divide(new BigDecimal(100))).add(new BigDecimal(1)), 2) + "\"));");
          

      // Fin Creditos
    } else {
      resultado.append("var respuesta = new Array(null);");
    }
    xmlDocument.setParameter("array", resultado.toString());
    xmlDocument.setParameter("frameName", "appFrame");
    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println(xmlDocument.print());
    out.close();
  }
}
