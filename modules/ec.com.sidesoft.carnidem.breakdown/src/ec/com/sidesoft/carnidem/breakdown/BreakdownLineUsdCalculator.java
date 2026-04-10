package ec.com.sidesoft.carnidem.breakdown;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.openbravo.model.common.enterprise.Organization;

/**
 * Cálculos de porcentajes y valor USD para líneas de despiece.
 * <p>
 * Misma regla que {@code GetInfoForBreakdownLine}: el denominador del % de masa es la
 * {@code Total_Mass} del cabecero; {@code Value_Usd} = {@code percentageQuality} ×
 * (suma de {@code percentageQuality} de todas las líneas) × 100.
 * </p>
 */
public final class BreakdownLineUsdCalculator {

  private BreakdownLineUsdCalculator() {
  }

  /** Precisión monetaria de la organización; por defecto 2 decimales. */
  public static int currencyScale(Organization org) {
    if (org != null && org.getCurrency() != null && org.getCurrency().getCostingPrecision() != null) {
      return org.getCurrency().getCostingPrecision().intValue();
    }
    return 2;
  }

  /**
   * % de masa de la línea respecto a la masa total del cabecero: (masa / totalCabecero) × 100.
   */
  public static BigDecimal computePercentageTotalMass(BigDecimal lineMass, BigDecimal headerTotalMass,
      int scale) {
    if (lineMass == null || headerTotalMass == null) {
      return BigDecimal.ZERO.setScale(scale, RoundingMode.HALF_UP);
    }
    if (lineMass.compareTo(BigDecimal.ZERO) <= 0 || headerTotalMass.compareTo(BigDecimal.ZERO) <= 0) {
      return BigDecimal.ZERO.setScale(scale, RoundingMode.HALF_UP);
    }
    return lineMass.divide(headerTotalMass, scale, RoundingMode.HALF_UP)
        .multiply(BigDecimal.valueOf(100))
        .setScale(scale, RoundingMode.HALF_UP);
  }

  /**
   * ({@code percentageTotalMass} × {@code referencePrice}) / 100; 0 si la masa de línea no es positiva.
   */
  public static BigDecimal computePercentageQuality(BigDecimal percentageTotalMass,
      BigDecimal referencePrice, BigDecimal lineMass, int scale) {
    if (lineMass == null || lineMass.compareTo(BigDecimal.ZERO) <= 0) {
      return BigDecimal.ZERO.setScale(scale, RoundingMode.HALF_UP);
    }
    BigDecimal ptm = percentageTotalMass != null ? percentageTotalMass : BigDecimal.ZERO;
    BigDecimal ref = referencePrice != null ? referencePrice : BigDecimal.ZERO;
    return ptm.multiply(ref)
        .divide(BigDecimal.valueOf(100), scale, RoundingMode.HALF_UP)
        .setScale(scale, RoundingMode.HALF_UP);
  }

  /**
   * {@code percentageQuality} × {@code sumAllPercentageQuality} × 100; 0 si la masa de línea no es positiva.
   */
  public static BigDecimal computeValueUsd(BigDecimal linePercentageQuality,
      BigDecimal sumAllPercentageQuality, BigDecimal lineMass, int scale) {
    if (lineMass == null || lineMass.compareTo(BigDecimal.ZERO) <= 0) {
      return BigDecimal.ZERO.setScale(scale, RoundingMode.HALF_UP);
    }
    BigDecimal pq = linePercentageQuality != null ? linePercentageQuality : BigDecimal.ZERO;
    BigDecimal sum = sumAllPercentageQuality != null ? sumAllPercentageQuality : BigDecimal.ZERO;
    return pq.multiply(sum)
        .multiply(BigDecimal.valueOf(100))
        .setScale(scale, RoundingMode.HALF_UP);
  }

  /** Valor USD / masa; 0 si masa o valor no son positivos. */
  public static BigDecimal computeUsdKg(BigDecimal valueUsd, BigDecimal lineMass, int scale) {
    if (lineMass == null || lineMass.compareTo(BigDecimal.ZERO) <= 0 || valueUsd == null
        || valueUsd.compareTo(BigDecimal.ZERO) <= 0) {
      return BigDecimal.ZERO.setScale(scale, RoundingMode.HALF_UP);
    }
    return valueUsd.divide(lineMass, scale, RoundingMode.HALF_UP).setScale(scale, RoundingMode.HALF_UP);
  }
}
