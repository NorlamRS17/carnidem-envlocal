/*
 ************************************************************************************
 * Copyright (C) 2009-2010 Openbravo S.L.U.
 * Licensed under the Openbravo Commercial License version 1.0
 * You may obtain a copy of the License at http://www.openbravo.com/legal/obcl.html
 * or in the legal folder of this module distribution.
 ************************************************************************************
 */

package ec.com.sidesoft.custom.closecash.advanced.ad_process;

import org.openbravo.base.exception.OBException;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.dal.service.OBDal;
import org.openbravo.idl.proc.Parameter;
import org.openbravo.idl.proc.Validator;
import org.openbravo.idl.proc.Value;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentMethod;
import org.openbravo.module.idljava.proc.IdlServiceJava;

import ec.com.sidesoft.custom.closecash.advanced.SccaCardsSettlement;

/**
 * 
 * @author Rodney Jácome
 */
public class ImportCardSettlement extends IdlServiceJava {

  public String getEntityName() {
    return "Simple Products";
  }

  public Parameter[] getParameters() {
    return new Parameter[] { new Parameter("Metodo de Pago", Parameter.STRING), // 0
        new Parameter("Tipo de Tarjeta", Parameter.STRING), // 1
        new Parameter("Lote", Parameter.STRING), // 2
        new Parameter("Fecha", Parameter.STRING), // 3
        new Parameter("Valor Cobrado", Parameter.STRING), // 4
        new Parameter("Retencion IVA", Parameter.STRING), // 5
        new Parameter("Retencion Renta", Parameter.STRING), // 6
        new Parameter("Valor Coimision", Parameter.STRING), // 7
        new Parameter("Valor Depositado", Parameter.STRING) };// 8

  }

  protected Object[] validateProcess(Validator validator, String... values) throws Exception {

    validator.checkString(values[0], 32);
    validator.checkString(values[1], 32);
    validator.checkString(values[2], 32);
    validator.checkDate(values[3]);
    validator.checkString(values[4], 500);
    validator.checkString(values[5], 32);
    validator.checkString(values[6], 32);
    validator.checkString(values[7], 500);
    validator.checkString(values[8], 32);
    return values;

  }

  public BaseOBObject internalProcess(Object... values) throws Exception {

    return createPacificard((String) values[0], (String) values[1], (String) values[2],
        (String) values[3], (String) values[4], (String) values[5], (String) values[6],
        (String) values[7], (String) values[8]);
  }

  public BaseOBObject createPacificard(final String MetodoPago, final String TipoTarjeta,
      final String Lote, final String Fecha, final String ValorCobrado, final String RetencionIVA,
      final String RetencionRenta, final String ValorCoimision, final String ValorDepositado)
      throws Exception {

    SccaCardsSettlement ObjSccaCardsSettlement = OBProvider.getInstance()
        .get(SccaCardsSettlement.class);

    FIN_PaymentMethod ObjPaymentMethod = findDALInstance(false, FIN_PaymentMethod.class,
        new Value(FIN_PaymentMethod.PROPERTY_NAME, MetodoPago));
    if (ObjPaymentMethod == null || ObjPaymentMethod.equals("")) {
      throw new OBException("Método de pago: " + ObjPaymentMethod + " no existe");
    }
    // Tipo tarjeta
    String StrTipoTarjeta = "NA";
    if (TipoTarjeta.toUpperCase().equals("MEDIANET") | TipoTarjeta.toUpperCase().equals("ME")) {
      StrTipoTarjeta = "ME";
    } else if (TipoTarjeta.toUpperCase().equals("DATAFAST")
        | TipoTarjeta.toUpperCase().equals("DT")) {
      StrTipoTarjeta = "DT";
    } else if (TipoTarjeta.toUpperCase().equals("NO APLICA")
        | TipoTarjeta.toUpperCase().equals("NA")) {
      StrTipoTarjeta = "NA";
    }

    try {
      // Metodo de pago
      ObjSccaCardsSettlement.setPaymentMethod(ObjPaymentMethod);
      // TipoTarjeta
      ObjSccaCardsSettlement.setCardType(StrTipoTarjeta);
      // Lote
      ObjSccaCardsSettlement.setLotName(Lote);
      // Fecha
      ObjSccaCardsSettlement.setDateTransaction((Parameter.DATE.parse(Fecha)));
      // ValorCobrado
      ObjSccaCardsSettlement
          .setReceivedAmount(Parameter.BIGDECIMAL.parse(changeFormatBigDecimal(ValorCobrado)));
      // RetIVA
      ObjSccaCardsSettlement
          .setIVARetention(Parameter.BIGDECIMAL.parse(changeFormatBigDecimal(RetencionIVA)));
      // RetRenta
      ObjSccaCardsSettlement
          .setRentRetention(Parameter.BIGDECIMAL.parse(changeFormatBigDecimal(RetencionRenta)));
      // ValorComission
      ObjSccaCardsSettlement
          .setCommissionAmount(Parameter.BIGDECIMAL.parse(changeFormatBigDecimal(ValorCoimision)));
      // ValorDepositado
      ObjSccaCardsSettlement
          .setBondedAmount(Parameter.BIGDECIMAL.parse(changeFormatBigDecimal(ValorDepositado)));

      OBDal.getInstance().save(ObjSccaCardsSettlement);
      OBDal.getInstance().flush();

    } catch (Exception e) {
      e.printStackTrace();
    }

    OBDal.getInstance().commitAndClose();
    return ObjSccaCardsSettlement;
  }

  public String changeFormatBigDecimal(String numbers) {
    String Remplace = "0";

    Remplace = numbers.replace(".", "");
    Remplace = numbers.replace(",", ".");

    return Remplace;
  }

}
