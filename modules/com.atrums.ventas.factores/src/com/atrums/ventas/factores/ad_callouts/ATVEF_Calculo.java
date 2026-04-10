package com.atrums.ventas.factores.ad_callouts;

import java.math.BigDecimal;

public class ATVEF_Calculo {

  /**
   * 
   * @param bdCostoPOE
   * @param bdEntradaPor
   * @return valor del recargo mensual - Entrada
   * 
   */
  public static BigDecimal valor_Menos_Entrada(BigDecimal bdCostoPOE, BigDecimal bdEntradaPor) {
    return bdCostoPOE.add((bdCostoPOE.negate()).multiply(bdEntradaPor
        .divide(new BigDecimal(100), 2)));
  }

  /**
   * 
   * @param intPlazos
   * @param bpValorMenosEntrada
   * @param dbRecragaMensualPor
   * @return Valor del Recargo Mensual
   */
  public static BigDecimal recargoMensual(int intPlazos, BigDecimal bpValorMenosEntrada,
      BigDecimal dbRecragaMensualPor) {
    return bpValorMenosEntrada.multiply(new BigDecimal(intPlazos).multiply(dbRecragaMensualPor))
        .divide(new BigDecimal(100), 2);
  }

  /**
   * 
   * @param bpValorMenosEntrada
   * @param recargoMensual
   * @return VAlor POE mas Riesgo
   */
  public static BigDecimal poeMasRiesgo(BigDecimal bpValorMenosEntrada, BigDecimal recargoMensual) {
    return bpValorMenosEntrada.add(recargoMensual);
  }

  /**
   * 
   * @param bpValorMenosEntrada
   * @param ivaPor
   * @return Valor precio Iva
   */
  public static BigDecimal pvpIncluyeIva(BigDecimal bpValorMenosEntrada, BigDecimal ivaPor) {
    return bpValorMenosEntrada.add((bpValorMenosEntrada.multiply(ivaPor)).divide(
        new BigDecimal(100), 2));
  }

  /**
   * 
   * @param bdPvpIva
   * @param bpEntradaPor
   * @return Valor de la Entrada Minima
   */
  public static BigDecimal EntradaMinima(BigDecimal bdPvpIva, BigDecimal bpEntradaPor) {
    return (bdPvpIva.multiply(bpEntradaPor)).divide(new BigDecimal(100));
  }

  /**
   * 
   * @param dbFinanciamientoPor
   * @param dbPvpMensoEntrada
   * @param intPlazo
   * @return Valor de la Cuota
   */
  public static BigDecimal valorCuota(BigDecimal dbFinanciamientoPor, BigDecimal dbPvpMensoEntrada,
      int intPlazo) {

    BigDecimal bFinanciamiento = dbFinanciamientoPor.divide(new BigDecimal(100), 2);

    BigDecimal val0 = bFinanciamiento.divide(new BigDecimal(12), 8, 5);
    BigDecimal val1 = new BigDecimal(1).add(val0);
    BigDecimal val2 = val1.pow(intPlazo);

    BigDecimal val3 = (bFinanciamiento.multiply(dbPvpMensoEntrada))
        .divide(new BigDecimal(12), 8, 5);
    if (intPlazo > 0)
      return val3.multiply(val2).divide((val2.add(new BigDecimal(1).negate())), 8, 5);
    else
      return BigDecimal.ZERO;

  }

}