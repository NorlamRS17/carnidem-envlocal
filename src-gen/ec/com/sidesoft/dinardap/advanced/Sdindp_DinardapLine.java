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
 * All portions are Copyright (C) 2008-2014 Openbravo SLU
 * All Rights Reserved.
 * Contributor(s):  ______________________________________.
 ************************************************************************
*/
package ec.com.sidesoft.dinardap.advanced;

import java.math.BigDecimal;
import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
/**
 * Entity class for entity sdindp_dinardap_line (stored in table sdindp_dinardap_line).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Sdindp_DinardapLine extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sdindp_dinardap_line";
    public static final String ENTITY_NAME = "sdindp_dinardap_line";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_SDINDPDINARDAP = "sdindpDinardap";
    public static final String PROPERTY_CODIGOENTIDAD = "codigoEntidad";
    public static final String PROPERTY_FECHA = "fecha";
    public static final String PROPERTY_TIPOIDENTIFICACION = "tipoIdentificacion";
    public static final String PROPERTY_IDENTIFICACIONSUJETO = "identificacionSujeto";
    public static final String PROPERTY_NOMBRESUJETO = "nombreSujeto";
    public static final String PROPERTY_CLASESUJETO = "claseSujeto";
    public static final String PROPERTY_PROVINCIA = "provincia";
    public static final String PROPERTY_CANTON = "canton";
    public static final String PROPERTY_PARROQUIA = "parroquia";
    public static final String PROPERTY_SEXO = "sexo";
    public static final String PROPERTY_ESTADOCIVIL = "estadoCivil";
    public static final String PROPERTY_ORIGENINGRESOS = "origenIngresos";
    public static final String PROPERTY_NUMEROOPERACION = "numeroOperacion";
    public static final String PROPERTY_VALOROPERACION = "valorOperacion";
    public static final String PROPERTY_SALDOOPERACION = "saldoOperacion";
    public static final String PROPERTY_FECHACONCESION = "fechaConcesion";
    public static final String PROPERTY_FECHAVENCIMIENTO = "fechaVencimiento";
    public static final String PROPERTY_FECHAEXIGIBLE = "fechaExigible";
    public static final String PROPERTY_PLAZOOPERACION = "plazoOperacion";
    public static final String PROPERTY_PERIODICIDADPAGOS = "periodicidadPagos";
    public static final String PROPERTY_DIASMOROSIDAD = "diasMorosidad";
    public static final String PROPERTY_MONTOMOROSIDAD = "montoMorosidad";
    public static final String PROPERTY_MONTOINTERESENMORA = "montoInteresEnMora";
    public static final String PROPERTY_VALORXVENCER1A30 = "valorXVencer1A30";
    public static final String PROPERTY_VALORXVENCER31A90 = "valorXVencer31A90";
    public static final String PROPERTY_VALORXVENCER91A180 = "valorXVencer91A180";
    public static final String PROPERTY_VALORXVENCER181A360 = "valorXVencer181A360";
    public static final String PROPERTY_VALORXVENCERMAS360 = "valorXVencerMas360";
    public static final String PROPERTY_VALORVENCIDO1A30 = "valorVencido1A30";
    public static final String PROPERTY_VALORVENCIDOG31A90 = "valorVencidoG31A90";
    public static final String PROPERTY_VALORVENCIDO91A180 = "valorVencido91A180";
    public static final String PROPERTY_VALORVENCIDO181A360 = "valorVencido181A360";
    public static final String PROPERTY_VALORVENCIDOMAS360 = "valorVencidoMas360";
    public static final String PROPERTY_VALORENDEMANDAJUDICIAL = "valorEnDemandaJudicial";
    public static final String PROPERTY_CARTERACASTIGADA = "carteraCastigada";
    public static final String PROPERTY_CUOTACREDITO = "cuotaCredito";
    public static final String PROPERTY_FECHACANCELACION = "fechaCancelacion";
    public static final String PROPERTY_FORMACANCELACION = "formaCancelacion";
    public static final String PROPERTY_REMOVABLE = "removable";

    public Sdindp_DinardapLine() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_VALOROPERACION, new BigDecimal(0));
        setDefaultValue(PROPERTY_SALDOOPERACION, new BigDecimal(0));
        setDefaultValue(PROPERTY_PLAZOOPERACION, (long) 0);
        setDefaultValue(PROPERTY_PERIODICIDADPAGOS, (long) 0);
        setDefaultValue(PROPERTY_DIASMOROSIDAD, (long) 0);
        setDefaultValue(PROPERTY_MONTOMOROSIDAD, new BigDecimal(0));
        setDefaultValue(PROPERTY_MONTOINTERESENMORA, new BigDecimal(0));
        setDefaultValue(PROPERTY_VALORXVENCER1A30, new BigDecimal(0));
        setDefaultValue(PROPERTY_VALORXVENCER31A90, new BigDecimal(0));
        setDefaultValue(PROPERTY_VALORXVENCER91A180, new BigDecimal(0));
        setDefaultValue(PROPERTY_VALORXVENCER181A360, new BigDecimal(0));
        setDefaultValue(PROPERTY_VALORXVENCERMAS360, new BigDecimal(0));
        setDefaultValue(PROPERTY_VALORVENCIDO1A30, new BigDecimal(0));
        setDefaultValue(PROPERTY_VALORVENCIDOG31A90, new BigDecimal(0));
        setDefaultValue(PROPERTY_VALORVENCIDO91A180, new BigDecimal(0));
        setDefaultValue(PROPERTY_VALORVENCIDO181A360, new BigDecimal(0));
        setDefaultValue(PROPERTY_VALORVENCIDOMAS360, new BigDecimal(0));
        setDefaultValue(PROPERTY_VALORENDEMANDAJUDICIAL, new BigDecimal(0));
        setDefaultValue(PROPERTY_CARTERACASTIGADA, new BigDecimal(0));
        setDefaultValue(PROPERTY_CUOTACREDITO, new BigDecimal(0));
        setDefaultValue(PROPERTY_REMOVABLE, false);
    }

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
    }

    public String getId() {
        return (String) get(PROPERTY_ID);
    }

    public void setId(String id) {
        set(PROPERTY_ID, id);
    }

    public Client getClient() {
        return (Client) get(PROPERTY_CLIENT);
    }

    public void setClient(Client client) {
        set(PROPERTY_CLIENT, client);
    }

    public Organization getOrganization() {
        return (Organization) get(PROPERTY_ORGANIZATION);
    }

    public void setOrganization(Organization organization) {
        set(PROPERTY_ORGANIZATION, organization);
    }

    public Boolean isActive() {
        return (Boolean) get(PROPERTY_ACTIVE);
    }

    public void setActive(Boolean active) {
        set(PROPERTY_ACTIVE, active);
    }

    public Date getCreationDate() {
        return (Date) get(PROPERTY_CREATIONDATE);
    }

    public void setCreationDate(Date creationDate) {
        set(PROPERTY_CREATIONDATE, creationDate);
    }

    public User getCreatedBy() {
        return (User) get(PROPERTY_CREATEDBY);
    }

    public void setCreatedBy(User createdBy) {
        set(PROPERTY_CREATEDBY, createdBy);
    }

    public Date getUpdated() {
        return (Date) get(PROPERTY_UPDATED);
    }

    public void setUpdated(Date updated) {
        set(PROPERTY_UPDATED, updated);
    }

    public User getUpdatedBy() {
        return (User) get(PROPERTY_UPDATEDBY);
    }

    public void setUpdatedBy(User updatedBy) {
        set(PROPERTY_UPDATEDBY, updatedBy);
    }

    public Sdindp_Dinardap getSdindpDinardap() {
        return (Sdindp_Dinardap) get(PROPERTY_SDINDPDINARDAP);
    }

    public void setSdindpDinardap(Sdindp_Dinardap sdindpDinardap) {
        set(PROPERTY_SDINDPDINARDAP, sdindpDinardap);
    }

    public String getCodigoEntidad() {
        return (String) get(PROPERTY_CODIGOENTIDAD);
    }

    public void setCodigoEntidad(String codigoEntidad) {
        set(PROPERTY_CODIGOENTIDAD, codigoEntidad);
    }

    public Date getFecha() {
        return (Date) get(PROPERTY_FECHA);
    }

    public void setFecha(Date fecha) {
        set(PROPERTY_FECHA, fecha);
    }

    public String getTipoIdentificacion() {
        return (String) get(PROPERTY_TIPOIDENTIFICACION);
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        set(PROPERTY_TIPOIDENTIFICACION, tipoIdentificacion);
    }

    public String getIdentificacionSujeto() {
        return (String) get(PROPERTY_IDENTIFICACIONSUJETO);
    }

    public void setIdentificacionSujeto(String identificacionSujeto) {
        set(PROPERTY_IDENTIFICACIONSUJETO, identificacionSujeto);
    }

    public String getNombreSujeto() {
        return (String) get(PROPERTY_NOMBRESUJETO);
    }

    public void setNombreSujeto(String nombreSujeto) {
        set(PROPERTY_NOMBRESUJETO, nombreSujeto);
    }

    public String getClaseSujeto() {
        return (String) get(PROPERTY_CLASESUJETO);
    }

    public void setClaseSujeto(String claseSujeto) {
        set(PROPERTY_CLASESUJETO, claseSujeto);
    }

    public String getProvincia() {
        return (String) get(PROPERTY_PROVINCIA);
    }

    public void setProvincia(String provincia) {
        set(PROPERTY_PROVINCIA, provincia);
    }

    public String getCanton() {
        return (String) get(PROPERTY_CANTON);
    }

    public void setCanton(String canton) {
        set(PROPERTY_CANTON, canton);
    }

    public String getParroquia() {
        return (String) get(PROPERTY_PARROQUIA);
    }

    public void setParroquia(String parroquia) {
        set(PROPERTY_PARROQUIA, parroquia);
    }

    public String getSexo() {
        return (String) get(PROPERTY_SEXO);
    }

    public void setSexo(String sexo) {
        set(PROPERTY_SEXO, sexo);
    }

    public String getEstadoCivil() {
        return (String) get(PROPERTY_ESTADOCIVIL);
    }

    public void setEstadoCivil(String estadoCivil) {
        set(PROPERTY_ESTADOCIVIL, estadoCivil);
    }

    public String getOrigenIngresos() {
        return (String) get(PROPERTY_ORIGENINGRESOS);
    }

    public void setOrigenIngresos(String origenIngresos) {
        set(PROPERTY_ORIGENINGRESOS, origenIngresos);
    }

    public String getNumeroOperacion() {
        return (String) get(PROPERTY_NUMEROOPERACION);
    }

    public void setNumeroOperacion(String numeroOperacion) {
        set(PROPERTY_NUMEROOPERACION, numeroOperacion);
    }

    public BigDecimal getValorOperacion() {
        return (BigDecimal) get(PROPERTY_VALOROPERACION);
    }

    public void setValorOperacion(BigDecimal valorOperacion) {
        set(PROPERTY_VALOROPERACION, valorOperacion);
    }

    public BigDecimal getSaldoOperacion() {
        return (BigDecimal) get(PROPERTY_SALDOOPERACION);
    }

    public void setSaldoOperacion(BigDecimal saldoOperacion) {
        set(PROPERTY_SALDOOPERACION, saldoOperacion);
    }

    public Date getFechaConcesion() {
        return (Date) get(PROPERTY_FECHACONCESION);
    }

    public void setFechaConcesion(Date fechaConcesion) {
        set(PROPERTY_FECHACONCESION, fechaConcesion);
    }

    public Date getFechaVencimiento() {
        return (Date) get(PROPERTY_FECHAVENCIMIENTO);
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        set(PROPERTY_FECHAVENCIMIENTO, fechaVencimiento);
    }

    public Date getFechaExigible() {
        return (Date) get(PROPERTY_FECHAEXIGIBLE);
    }

    public void setFechaExigible(Date fechaExigible) {
        set(PROPERTY_FECHAEXIGIBLE, fechaExigible);
    }

    public Long getPlazoOperacion() {
        return (Long) get(PROPERTY_PLAZOOPERACION);
    }

    public void setPlazoOperacion(Long plazoOperacion) {
        set(PROPERTY_PLAZOOPERACION, plazoOperacion);
    }

    public Long getPeriodicidadPagos() {
        return (Long) get(PROPERTY_PERIODICIDADPAGOS);
    }

    public void setPeriodicidadPagos(Long periodicidadPagos) {
        set(PROPERTY_PERIODICIDADPAGOS, periodicidadPagos);
    }

    public Long getDiasMorosidad() {
        return (Long) get(PROPERTY_DIASMOROSIDAD);
    }

    public void setDiasMorosidad(Long diasMorosidad) {
        set(PROPERTY_DIASMOROSIDAD, diasMorosidad);
    }

    public BigDecimal getMontoMorosidad() {
        return (BigDecimal) get(PROPERTY_MONTOMOROSIDAD);
    }

    public void setMontoMorosidad(BigDecimal montoMorosidad) {
        set(PROPERTY_MONTOMOROSIDAD, montoMorosidad);
    }

    public BigDecimal getMontoInteresEnMora() {
        return (BigDecimal) get(PROPERTY_MONTOINTERESENMORA);
    }

    public void setMontoInteresEnMora(BigDecimal montoInteresEnMora) {
        set(PROPERTY_MONTOINTERESENMORA, montoInteresEnMora);
    }

    public BigDecimal getValorXVencer1A30() {
        return (BigDecimal) get(PROPERTY_VALORXVENCER1A30);
    }

    public void setValorXVencer1A30(BigDecimal valorXVencer1A30) {
        set(PROPERTY_VALORXVENCER1A30, valorXVencer1A30);
    }

    public BigDecimal getValorXVencer31A90() {
        return (BigDecimal) get(PROPERTY_VALORXVENCER31A90);
    }

    public void setValorXVencer31A90(BigDecimal valorXVencer31A90) {
        set(PROPERTY_VALORXVENCER31A90, valorXVencer31A90);
    }

    public BigDecimal getValorXVencer91A180() {
        return (BigDecimal) get(PROPERTY_VALORXVENCER91A180);
    }

    public void setValorXVencer91A180(BigDecimal valorXVencer91A180) {
        set(PROPERTY_VALORXVENCER91A180, valorXVencer91A180);
    }

    public BigDecimal getValorXVencer181A360() {
        return (BigDecimal) get(PROPERTY_VALORXVENCER181A360);
    }

    public void setValorXVencer181A360(BigDecimal valorXVencer181A360) {
        set(PROPERTY_VALORXVENCER181A360, valorXVencer181A360);
    }

    public BigDecimal getValorXVencerMas360() {
        return (BigDecimal) get(PROPERTY_VALORXVENCERMAS360);
    }

    public void setValorXVencerMas360(BigDecimal valorXVencerMas360) {
        set(PROPERTY_VALORXVENCERMAS360, valorXVencerMas360);
    }

    public BigDecimal getValorVencido1A30() {
        return (BigDecimal) get(PROPERTY_VALORVENCIDO1A30);
    }

    public void setValorVencido1A30(BigDecimal valorVencido1A30) {
        set(PROPERTY_VALORVENCIDO1A30, valorVencido1A30);
    }

    public BigDecimal getValorVencidoG31A90() {
        return (BigDecimal) get(PROPERTY_VALORVENCIDOG31A90);
    }

    public void setValorVencidoG31A90(BigDecimal valorVencidoG31A90) {
        set(PROPERTY_VALORVENCIDOG31A90, valorVencidoG31A90);
    }

    public BigDecimal getValorVencido91A180() {
        return (BigDecimal) get(PROPERTY_VALORVENCIDO91A180);
    }

    public void setValorVencido91A180(BigDecimal valorVencido91A180) {
        set(PROPERTY_VALORVENCIDO91A180, valorVencido91A180);
    }

    public BigDecimal getValorVencido181A360() {
        return (BigDecimal) get(PROPERTY_VALORVENCIDO181A360);
    }

    public void setValorVencido181A360(BigDecimal valorVencido181A360) {
        set(PROPERTY_VALORVENCIDO181A360, valorVencido181A360);
    }

    public BigDecimal getValorVencidoMas360() {
        return (BigDecimal) get(PROPERTY_VALORVENCIDOMAS360);
    }

    public void setValorVencidoMas360(BigDecimal valorVencidoMas360) {
        set(PROPERTY_VALORVENCIDOMAS360, valorVencidoMas360);
    }

    public BigDecimal getValorEnDemandaJudicial() {
        return (BigDecimal) get(PROPERTY_VALORENDEMANDAJUDICIAL);
    }

    public void setValorEnDemandaJudicial(BigDecimal valorEnDemandaJudicial) {
        set(PROPERTY_VALORENDEMANDAJUDICIAL, valorEnDemandaJudicial);
    }

    public BigDecimal getCarteraCastigada() {
        return (BigDecimal) get(PROPERTY_CARTERACASTIGADA);
    }

    public void setCarteraCastigada(BigDecimal carteraCastigada) {
        set(PROPERTY_CARTERACASTIGADA, carteraCastigada);
    }

    public BigDecimal getCuotaCredito() {
        return (BigDecimal) get(PROPERTY_CUOTACREDITO);
    }

    public void setCuotaCredito(BigDecimal cuotaCredito) {
        set(PROPERTY_CUOTACREDITO, cuotaCredito);
    }

    public Date getFechaCancelacion() {
        return (Date) get(PROPERTY_FECHACANCELACION);
    }

    public void setFechaCancelacion(Date fechaCancelacion) {
        set(PROPERTY_FECHACANCELACION, fechaCancelacion);
    }

    public String getFormaCancelacion() {
        return (String) get(PROPERTY_FORMACANCELACION);
    }

    public void setFormaCancelacion(String formaCancelacion) {
        set(PROPERTY_FORMACANCELACION, formaCancelacion);
    }

    public Boolean isRemovable() {
        return (Boolean) get(PROPERTY_REMOVABLE);
    }

    public void setRemovable(Boolean removable) {
        set(PROPERTY_REMOVABLE, removable);
    }

}
