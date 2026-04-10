package ec.com.sidesoft.xml.irbp;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.client.kernel.RequestContext;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.enterprise.OrganizationInformation;
import org.openbravo.model.financialmgmt.calendar.Period;
import org.openbravo.model.financialmgmt.calendar.Year;
import org.openbravo.model.financialmgmt.tax.TaxRate;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.DalBaseProcess;
import org.openbravo.service.db.DalConnectionProvider;
import org.openbravo.xmlEngine.XmlEngine;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreateXmlIrbp extends DalBaseProcess {

  public XmlEngine xmlEngine = null;
  public static String strDireccion;
  public String StrCodigoCompra = "";
  public String Stridprov = "";
  public String StrPeriodId = "";
  public Element ventas = null;
  static Logger log4j = Logger.getLogger(Utility.class);

  @Override
  protected void doExecute(ProcessBundle bundle) throws Exception {
    try {
      StrPeriodId = (String) bundle.getParams().get("cPeriodId");
      final String StrOrgID = (String) bundle.getParams().get("adOrgId");
      final String Stryear = (String) bundle.getParams().get("cYearId");

      String taxidOrg = "";
      String taxidType = "";
      String yearAnio = "";
      String periodName = "";
      String socialName = "";
      String codImpuesto = "";
      String codeCountry = "";
      log4j.info("*******************  ATS IRBP - SIDESOFT ******************");

      OBCriteria<Organization> obcO = OBDal.getInstance().createCriteria(Organization.class);
      obcO.add(Restrictions.eq(Organization.PROPERTY_ID, StrOrgID));
      obcO.setMaxResults(1);
      Organization org = (Organization) obcO.uniqueResult();
      if (org != null) {
        System.out.println(org.getOrganizationInformationList());

        if (org.getOrganizationInformationList().size() > 0) {

          String strIdorgInfo = org.getOrganizationInformationList().get(0).getId();

          OBCriteria<OrganizationInformation> obcOrg = OBDal.getInstance()
              .createCriteria(OrganizationInformation.class);
          obcOrg.add(Restrictions.eq(OrganizationInformation.PROPERTY_ID, strIdorgInfo));
          obcOrg.setMaxResults(1);
          OrganizationInformation orgInfo = (OrganizationInformation) obcOrg.uniqueResult();

          if (orgInfo != null) {
            // Tercero relacionado a la Org
            if (orgInfo.getBusinessPartner() == null) {
              throw new OBException(
                  "La organización no tiene relacionado un Tercero. (OrganizationInfo");
            }
            if (orgInfo.getSorgiCountry() == null) {
              throw new OBException(
                  "La organización no tiene relacionado un País para el codigo necesario. (OrganizationInfo");
            } else {
              if (orgInfo.getSorgiCountry().getSsprCoderesidence() != null) {
                codeCountry = orgInfo.getSorgiCountry().getSsprCoderesidence();
              } else {
                throw new OBException(
                    "El pais de la organizacion selecionada no tiene un Codigo de Residencia (Obligatorio)");
              }
            }
            if (orgInfo.getBusinessPartner() != null) {
              socialName = orgInfo.getOrganization().getName();

              OBCriteria<BusinessPartner> obcBp = OBDal.getInstance()
                  .createCriteria(BusinessPartner.class);
              obcBp.add(Restrictions.eq(BusinessPartner.PROPERTY_ID,
                  orgInfo.getBusinessPartner().getId()));
              obcBp.setMaxResults(1);
              BusinessPartner bpartner = (BusinessPartner) obcBp.uniqueResult();
              if (bpartner != null) {
                if (bpartner.getSswhTaxidtype() != null && bpartner.getTaxID() != null) {
                  taxidOrg = bpartner.getTaxID().toString();
                  taxidType = bpartner.getSswhTaxidtype().toString();
                }
              }
            }
          }

        }

      }
      if (org.getSsxmlGruopIrbp() == null) {
        throw new OBException(
            "Se requiere definir el tipo de agrupación para generar el xml, verifique el campo Agrupación Anexo IRBP en la Organización. ");
      }

      final OBError message = new OBError();
      String language = OBContext.getOBContext().getLanguage().getLanguage();
      try {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        Document doc = docBuilder.newDocument();
        doc.setXmlStandalone(true);

        Element rootElement = doc.createElement("ibp");
        doc.appendChild(rootElement);

        // CUERPO XML

        // ******************** HEADER ***************************
        Element TipoIDInformante = doc.createElement("TipoIDInformante");
        TipoIDInformante.appendChild(doc.createTextNode(taxidType));
        rootElement.appendChild(TipoIDInformante);

        Element IdInformante = doc.createElement("IdInformante");
        IdInformante.appendChild(doc.createTextNode(taxidOrg));
        rootElement.appendChild(IdInformante);

        // determinar anio por parametro
        OBCriteria<Year> obcY = OBDal.getInstance().createCriteria(Year.class);
        obcY.add(Restrictions.eq(Year.PROPERTY_ID, Stryear));
        obcY.setMaxResults(1);
        Year year = (Year) obcY.uniqueResult();
        if (year != null) {
          yearAnio = year.getFiscalYear();
        }

        Element Anio = doc.createElement("Anio");
        Anio.appendChild(doc.createTextNode(yearAnio));
        rootElement.appendChild(Anio);

        // determinar mes por parametro
        OBCriteria<Period> obcP = OBDal.getInstance().createCriteria(Period.class);
        obcP.add(Restrictions.eq(Period.PROPERTY_ID, StrPeriodId));
        obcP.setMaxResults(1);
        Period period = (Period) obcP.uniqueResult();
        if (period != null) {
          periodName = period.getStartingDate().toString();
        }
        String patronFecha = "yyyy-MM-dd HH:mm:ss.S";
        SimpleDateFormat formatoFecha = new SimpleDateFormat(patronFecha);
        java.util.Date fecha = formatoFecha.parse(periodName);

        int anio = Integer.parseInt(yearAnio);
        int mes = fecha.getMonth() + 1;
        DecimalFormat formatoMes = new DecimalFormat("00");
        String mesFormateado = formatoMes.format(mes);
        Element Mes = doc.createElement("Mes");
        Mes.appendChild(doc.createTextNode(String.valueOf(mesFormateado)));
        rootElement.appendChild(Mes);

        String razonSocialOrg = "";
        Element razonSocial = doc.createElement("razonSocial");
        if (socialName.equals("*") || socialName == "*") {
          razonSocialOrg = getReazonOrganization();
        } else {
          razonSocialOrg = socialName;
        }
        razonSocial.appendChild(doc.createTextNode(razonSocialOrg));
        rootElement.appendChild(razonSocial);

        Element codigoOperativo = doc.createElement("codigoOperativo");
        codigoOperativo.appendChild(doc.createTextNode("IBP"));
        rootElement.appendChild(codigoOperativo);

        // ******************************************************
        // Fecha Inicio y Fecha fin del mes solicitado

        // Obtener la fecha de inicio del mes
        Calendar calInicio = Calendar.getInstance();
        calInicio.set(Calendar.YEAR, anio);
        calInicio.set(Calendar.MONTH, mes - 1); // Los meses en Calendar van de 0 a 11
        calInicio.set(Calendar.DAY_OF_MONTH, 1);

        // Obtener la fecha de fin del mes
        Calendar calFin = Calendar.getInstance();
        calFin.set(Calendar.YEAR, anio);
        calFin.set(Calendar.MONTH, mes - 1);
        calFin.set(Calendar.DAY_OF_MONTH, calFin.getActualMaximum(Calendar.DAY_OF_MONTH));
        calFin.add(Calendar.DAY_OF_MONTH, 1);

        // DETERMINAR CODIGO IMPUESTO DE IRBP
        OBCriteria<TaxRate> obcRate = OBDal.getInstance().createCriteria(TaxRate.class);
        // obcPlan.add(Restrictions.eq(ProductionPlan.PROPERTY_ORGANIZATION, org));
        obcRate.add(Restrictions.eq(TaxRate.PROPERTY_SLPLAGIRBP, true));
        obcRate.setMaxResults(1);
        TaxRate taxRate = (TaxRate) obcRate.uniqueResult();
        if (taxRate != null) {
          if (taxRate.getEeiSriTaxcatCode() != null) {
            codImpuesto = taxRate.getEeiSriTaxcatCode();
          } else {
            throw new OBException(
                "No existe código para IRBP en Rango Impuesto que sea de tipo IRBP.");
          }
        } else {
          throw new OBException("No existe un Rango Impuesto que sea de tipo IRBP.");
        }

        // ************* Enbotellamiento *************************
        Element embotellamiento = doc.createElement("embotellamiento");
        rootElement.appendChild(embotellamiento);

        ConnectionProvider conn = new DalConnectionProvider(false);
        PreparedStatement st = null;

        SimpleDateFormat sdfI = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDateI = sdfI.format(calInicio.getTime());
        String formattedDateF = sdfI.format(calFin.getTime());

        String validationPr = validationPr(formattedDateI.toString(), formattedDateF.toString());
        if (!validationPr.equals("OK")) {
          throw new OBException(validationPr);
        }

        // TABLA TEMPORAL ALMACENA PRODUCTOS Y SUBPRODUCTOS LDM

        String tempTable = createTemoTableIbp(org.getSsxmlGruopIrbp(), formattedDateI.toString(),
            formattedDateF.toString(), codImpuesto, codeCountry);

        String sql = "SELECT M_PRODUCT_ID ,codeibp ,embibp, sale, dev, baja  FROM ssxml_data_xml_ibp";

        st = conn.getPreparedStatement(sql);
        ResultSet rs = st.executeQuery();
        try {
          while (rs.next()) {
            // -- XML IRBP
            Element emb = doc.createElement("emb");
            embotellamiento.appendChild(emb);
            String codeIbpProd = rs.getString("codeibp");

            Element idProv = doc.createElement("codProdIBP");
            idProv.appendChild(doc.createTextNode(codeIbpProd));
            emb.appendChild(idProv);

            Element embIBP = doc.createElement("embIBP");
            embIBP.appendChild(doc.createTextNode(rs.getString("embibp")));
            emb.appendChild(embIBP);

            Element canProBajaEmb = doc.createElement("canProBajaEmb");
            canProBajaEmb.appendChild(doc.createTextNode("0"));
            emb.appendChild(canProBajaEmb);

            Element ventaIBP = doc.createElement("ventaIBP");
            ventaIBP.appendChild(doc.createTextNode(rs.getString("sale")));
            emb.appendChild(ventaIBP);

            Element devIBP = doc.createElement("devIBP");
            devIBP.appendChild(doc.createTextNode(rs.getString("dev")));
            emb.appendChild(devIBP);

            Element canProBajaVenta = doc.createElement("canProBajaVenta");
            canProBajaVenta.appendChild(doc.createTextNode(rs.getString("baja")));
            emb.appendChild(canProBajaVenta);
            // ----------------------------------------
          }
        } catch (Exception e) {
          log4j.error("Error IRBP_ " + e.getMessage().toString());
          rs.close();
          st.close();

          throw new OBException(e.getMessage().toString());
        }

        rs.close();
        st.close();

        // ---------------------------------------------------------

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        try {
          transformer = transformerFactory.newTransformer();
        } catch (TransformerConfigurationException e1) {
          e1.printStackTrace();
        }

        StreamResult result = new StreamResult(new StringWriter());
        DOMSource source = new DOMSource(doc);

        transformer.transform(source, result);

        String nameFile = "anexo.xml";

        HttpServletResponse response = RequestContext.get().getResponse();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/xml");
        response.setHeader("Content-Disposition", "attachment; filename=" + nameFile);
        PrintWriter out = response.getWriter();
        out.println(result.getWriter().toString());
        out.close();

      } catch (

      Exception e) {
        log4j.error("Error IRBP_ " + e.getMessage().toString());

        throw new OBException(e.getMessage().toString());
      }

    } catch (Exception e) {
      log4j.error("Error IRBP_ " + e.getMessage().toString());

      throw new OBException(e.getMessage().toString());
    }

  }

  private String validationPr(String initDate, String endDate) {
    String result = null;
    ConnectionProvider conn = new DalConnectionProvider(false);
    PreparedStatement st = null;
    try {
      String sql = "SELECT * FROM ssxml_validate_ibps(?,?) AS result";
      st = conn.getPreparedStatement(sql);
      st.setString(1, initDate);
      st.setString(2, endDate);

      ResultSet rs = st.executeQuery();

      while (rs.next()) {
        result = rs.getString("result");
      }

      rs.close();
      st.close();
    } catch (Exception e) {
      throw new OBException("validate: " + e.getMessage());
    } finally {
      try {
        conn.releasePreparedStatement(st);
        conn.destroy();
      } catch (Exception ignore) {
        ignore.printStackTrace();
      }
    }
    return result;
  }

  private String createTemoTableIbp(String group, String initDate, String endDate,
      String codImpuesto, String codeCountry) {
    String result = null;
    ConnectionProvider conn = new DalConnectionProvider(false);
    PreparedStatement st = null;
    try {
      String sql = "SELECT * FROM ssxml_temp_data_xml_ibp(?,?,?,?,?) AS result";
      st = conn.getPreparedStatement(sql);
      st.setString(1, group);
      st.setString(2, initDate);
      st.setString(3, endDate);
      st.setString(4, codImpuesto);
      st.setString(5, codeCountry);

      ResultSet rs = st.executeQuery();

      while (rs.next()) {
        result = rs.getString("result");
      }

      rs.close();
      st.close();
    } catch (Exception e) {
      throw new OBException("createTemoTableIbp: " + e.getMessage());
    } finally {
      try {
        conn.releasePreparedStatement(st);
        conn.destroy();
      } catch (Exception ignore) {
        ignore.printStackTrace();
      }
    }
    return result;
  }

  public static String getReazonOrganization() throws Exception {

    ConnectionProvider conn = new DalConnectionProvider(false);
    PreparedStatement st = null;
    String sql = "select o.social_name from AD_Orgtype ot LEFT JOIN ad_org o ON o.AD_Orgtype_id =  ot.AD_Orgtype_id WHERE UPPER(ot.NAME) = UPPER('Legal with accounting')";

    String reazonOrg = "";
    st = conn.getPreparedStatement(sql);
    ResultSet rs = st.executeQuery();
    try {
      while (rs.next()) {
        reazonOrg = rs.getString("social_name");
      }
    } catch (Exception e) {
      System.out.println(e);
      rs.close();
      st.close();
    }
    rs.close();
    st.close();

    return reazonOrg;
  }

}
