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
package com.atrums.indumoto.postventa.data;

import com.atrums.indumot.supervision.data.indsupConsol;
import com.atrums.indumot.supervision.data.indsupOrdenDespacho;
import com.atrums.indumot.supervision.data.indsupTipofac;
import com.sidesoft.localization.ecuador.finances.SsfiModelProduct;

import ec.com.sidesoft.aftersale.machinery.Satmac_Contract;
import ec.com.sidesoft.aftersale.machinery.Satmac_MachineType;
import ec.com.sidesoft.workorder.consult.SSWCLBinnacle;
import ec.com.sidesoft.workorder.consult.SSWCLWorkOrderLine;
import ec.com.sidesoft.workorder.simplified.SswosBinnacle;
import ec.com.sidesoft.workorder.simplified.SswosColor;
import ec.com.sidesoft.workorder.simplified.SswosTransfer;
import ec.com.sidesoft.workorder.simplified.SswosYear;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.businesspartner.Location;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Locator;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.enterprise.Warehouse;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.common.plm.Brand;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentMethod;
import org.openbravo.model.financialmgmt.payment.PaymentTerm;
import org.openbravo.model.materialmgmt.transaction.InventoryCount;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOut;
import org.openbravo.model.pricing.pricelist.PriceList;
import org.openbravo.model.project.Project;
/**
 * Entity class for entity atindpo_postventa (stored in table atindpo_postventa).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class atindpo_postventa extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "atindpo_postventa";
    public static final String ENTITY_NAME = "atindpo_postventa";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_PAYMENTMETHOD = "paymentMethod";
    public static final String PROPERTY_SALESTRANSACTION = "salesTransaction";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_DOCUMENTSTATUS = "documentStatus";
    public static final String PROPERTY_DOCACTIONPV = "docactionpv";
    public static final String PROPERTY_DOCUMENTTYPE = "documentType";
    public static final String PROPERTY_FECHA = "fecha";
    public static final String PROPERTY_FECHAPROPUESTAENTREGA = "fechaPropuestaEntrega";
    public static final String PROPERTY_TIPOSERVICIO = "tipoServicio";
    public static final String PROPERTY_CLIENTE = "cliente";
    public static final String PROPERTY_PARTNERADDRESS = "partnerAddress";
    public static final String PROPERTY_NOMBRE = "nombre";
    public static final String PROPERTY_APELLIDO = "apellido";
    public static final String PROPERTY_CDULA = "cdula";
    public static final String PROPERTY_TELFONO = "telfono";
    public static final String PROPERTY_CELULAR = "celular";
    public static final String PROPERTY_DIRECCIN = "direccin";
    public static final String PROPERTY_TIPOVEHCULO = "tipoVehculo";
    public static final String PROPERTY_MARCA = "marca";
    public static final String PROPERTY_MODELO = "modelo";
    public static final String PROPERTY_AO = "ao";
    public static final String PROPERTY_NMOTOR = "nMotor";
    public static final String PROPERTY_NCHASIS = "nChasis";
    public static final String PROPERTY_PLACA = "placa";
    public static final String PROPERTY_COLOR = "color";
    public static final String PROPERTY_KMHORAS = "kmHoras";
    public static final String PROPERTY_FECHAVENTA = "fechaVenta";
    public static final String PROPERTY_LOCALDEVENTA = "localDeVenta";
    public static final String PROPERTY_MECNICOASIGNADO = "mecnicoAsignado";
    public static final String PROPERTY_DESCRIPCINDELPEDIDODELCLIENTE = "descripcinDelPedidoDelCliente";
    public static final String PROPERTY_OBSERVACIN = "observacin";
    public static final String PROPERTY_DESPACHO = "despacho";
    public static final String PROPERTY_CREARFACTURA = "crearfactura";
    public static final String PROPERTY_STORAGEBIN = "storageBin";
    public static final String PROPERTY_PAYMENTTERMS = "paymentTerms";
    public static final String PROPERTY_PRICELIST = "priceList";
    public static final String PROPERTY_IMPRIMIRPREFACTURA = "imprimirPreFactura";
    public static final String PROPERTY_SUMMEDLINEAMOUNT = "summedLineAmount";
    public static final String PROPERTY_GRANDTOTALAMOUNT = "grandTotalAmount";
    public static final String PROPERTY_HORA = "hora";
    public static final String PROPERTY_WAREHOUSE = "warehouse";
    public static final String PROPERTY_ORDENTRABAJO = "ordenTrabajo";
    public static final String PROPERTY_INDSUPREACTIVARORDEN = "indsupReactivarOrden";
    public static final String PROPERTY_EMAIL = "email";
    public static final String PROPERTY_INDSUPCREARFACTURA = "indsupCrearFactura";
    public static final String PROPERTY_INDSUPISCONSOL = "indsupIsConsol";
    public static final String PROPERTY_INDSUPVALIDA = "indsupValida";
    public static final String PROPERTY_INDSUPCONSOLIDA = "indsupConsolida";
    public static final String PROPERTY_INDSUPESTCONSOL = "indsupEstConsol";
    public static final String PROPERTY_INDSUPFACTCONSOL = "indsupFactConsol";
    public static final String PROPERTY_INDSUPTIPCONSOL = "indsupTipConsol";
    public static final String PROPERTY_SSWOSNEW = "sswosNew";
    public static final String PROPERTY_SSWOSMBRAND = "sswosMBrand";
    public static final String PROPERTY_SSWOSSSFIMODELPROD = "sswosSsfiModelProd";
    public static final String PROPERTY_SSWOSYEAR = "sswosYear";
    public static final String PROPERTY_SSWOSCOLOR = "sswosColor";
    public static final String PROPERTY_SSWOSCDOCTYPETARGET = "sswosCDoctypetarget";
    public static final String PROPERTY_SSWOSTRANSFERPARTS = "sswosTransferparts";
    public static final String PROPERTY_SSWOSCDOCTYPETARGETS = "sswosCDoctypetargets";
    public static final String PROPERTY_SSWOSCREATEORDER = "sswosCreateorder";
    public static final String PROPERTY_SSWOSCREATEORDERS = "sswosCreateorders";
    public static final String PROPERTY_SSWOSCORDER = "sswosCOrder";
    public static final String PROPERTY_SSWONSENDPREFECTURE = "sswonSendprefecture";
    public static final String PROPERTY_SSWOSTRANSFERPARTSRETURN = "sSWOSTransferPartsReturn";
    public static final String PROPERTY_SSWOSLOADCONSOL = "sswosLoadconsol";
    public static final String PROPERTY_SATMACSALESREP = "satmacSalesrep";
    public static final String PROPERTY_SSWOSREPRINTDOCUMENTS = "sswosrePrintdocuments";
    public static final String PROPERTY_SATMACPROJECT = "satmacProject";
    public static final String PROPERTY_SATMACMACHINETYPE = "satmacMachineType";
    public static final String PROPERTY_SATMACCONTRACT = "satmacContract";
    public static final String PROPERTY_SATMACINVENTORY = "satmacInventory";
    public static final String PROPERTY_SATMACNAME = "satmacName";
    public static final String PROPERTY__COMPUTEDCOLUMNS = "_computedColumns";
    public static final String PROPERTY_INVOICEEMATINDPOPOSTVENTAIDLIST = "invoiceEMAtindpoPostventaIDList";
    public static final String PROPERTY_MATERIALMGMTSHIPMENTINOUTEMATINDPOPOSTVENTAIDLIST = "materialMgmtShipmentInOutEMAtindpoPostventaIDList";
    public static final String PROPERTY_SSWOSBINNACLELIST = "sswosBinnacleList";
    public static final String PROPERTY_SSWOSTRANSFERLIST = "sswosTransferList";
    public static final String PROPERTY_ATINDPOPOSTVENTALINEALIST = "atindpoPostventalineaList";
    public static final String PROPERTY_INDSUPCONSOLLIST = "indsupConsolList";
    public static final String PROPERTY_INDSUPCONSOLEMSSWOSATINDPOPOSTVENTAIDLIST = "indsupConsolEMSswosAtindpoPostventaIDList";
    public static final String PROPERTY_INDSUPORDDESPLIST = "indsupOrdDespList";
    public static final String PROPERTY_SSWCLBINNACLEVLIST = "sswclBinnacleVList";
    public static final String PROPERTY_SSWCLWORKORDERLINEVLIST = "sswclWorkOrderlineVList";


    // Computed columns properties, these properties cannot be directly accessed, they need
    // to be read through _commputedColumns proxy. They cannot be directly used in HQL, OBQuery
    // nor OBCriteria. 
    public static final String COMPUTED_COLUMN_SATMACCONTRACTPROJECT = "sATMACContractProject";

    public atindpo_postventa() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_SALESTRANSACTION, true);
        setDefaultValue(PROPERTY_DOCUMENTSTATUS, "EE");
        setDefaultValue(PROPERTY_DOCACTIONPV, "EP");
        setDefaultValue(PROPERTY_DESPACHO, false);
        setDefaultValue(PROPERTY_CREARFACTURA, false);
        setDefaultValue(PROPERTY_IMPRIMIRPREFACTURA, false);
        setDefaultValue(PROPERTY_INDSUPREACTIVARORDEN, false);
        setDefaultValue(PROPERTY_INDSUPCREARFACTURA, false);
        setDefaultValue(PROPERTY_INDSUPVALIDA, false);
        setDefaultValue(PROPERTY_INDSUPCONSOLIDA, false);
        setDefaultValue(PROPERTY_INDSUPESTCONSOL, "BR");
        setDefaultValue(PROPERTY_INDSUPFACTCONSOL, false);
        setDefaultValue(PROPERTY_SSWOSNEW, false);
        setDefaultValue(PROPERTY_SSWOSTRANSFERPARTS, false);
        setDefaultValue(PROPERTY_SSWOSCREATEORDER, false);
        setDefaultValue(PROPERTY_SSWOSCREATEORDERS, false);
        setDefaultValue(PROPERTY_SSWONSENDPREFECTURE, false);
        setDefaultValue(PROPERTY_SSWOSTRANSFERPARTSRETURN, false);
        setDefaultValue(PROPERTY_SSWOSLOADCONSOL, false);
        setDefaultValue(PROPERTY_SSWOSREPRINTDOCUMENTS, false);
        setDefaultValue(PROPERTY_INVOICEEMATINDPOPOSTVENTAIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTSHIPMENTINOUTEMATINDPOPOSTVENTAIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWOSBINNACLELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWOSTRANSFERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ATINDPOPOSTVENTALINEALIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INDSUPCONSOLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INDSUPCONSOLEMSSWOSATINDPOPOSTVENTAIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INDSUPORDDESPLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWCLBINNACLEVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWCLWORKORDERLINEVLIST, new ArrayList<Object>());
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

    public FIN_PaymentMethod getPaymentMethod() {
        return (FIN_PaymentMethod) get(PROPERTY_PAYMENTMETHOD);
    }

    public void setPaymentMethod(FIN_PaymentMethod paymentMethod) {
        set(PROPERTY_PAYMENTMETHOD, paymentMethod);
    }

    public Boolean isSalesTransaction() {
        return (Boolean) get(PROPERTY_SALESTRANSACTION);
    }

    public void setSalesTransaction(Boolean salesTransaction) {
        set(PROPERTY_SALESTRANSACTION, salesTransaction);
    }

    public String getDocumentNo() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentNo(String documentNo) {
        set(PROPERTY_DOCUMENTNO, documentNo);
    }

    public String getDocumentStatus() {
        return (String) get(PROPERTY_DOCUMENTSTATUS);
    }

    public void setDocumentStatus(String documentStatus) {
        set(PROPERTY_DOCUMENTSTATUS, documentStatus);
    }

    public String getDocactionpv() {
        return (String) get(PROPERTY_DOCACTIONPV);
    }

    public void setDocactionpv(String docactionpv) {
        set(PROPERTY_DOCACTIONPV, docactionpv);
    }

    public DocumentType getDocumentType() {
        return (DocumentType) get(PROPERTY_DOCUMENTTYPE);
    }

    public void setDocumentType(DocumentType documentType) {
        set(PROPERTY_DOCUMENTTYPE, documentType);
    }

    public Date getFecha() {
        return (Date) get(PROPERTY_FECHA);
    }

    public void setFecha(Date fecha) {
        set(PROPERTY_FECHA, fecha);
    }

    public Date getFechaPropuestaEntrega() {
        return (Date) get(PROPERTY_FECHAPROPUESTAENTREGA);
    }

    public void setFechaPropuestaEntrega(Date fechaPropuestaEntrega) {
        set(PROPERTY_FECHAPROPUESTAENTREGA, fechaPropuestaEntrega);
    }

    public String getTipoServicio() {
        return (String) get(PROPERTY_TIPOSERVICIO);
    }

    public void setTipoServicio(String tipoServicio) {
        set(PROPERTY_TIPOSERVICIO, tipoServicio);
    }

    public BusinessPartner getCliente() {
        return (BusinessPartner) get(PROPERTY_CLIENTE);
    }

    public void setCliente(BusinessPartner cliente) {
        set(PROPERTY_CLIENTE, cliente);
    }

    public Location getPartnerAddress() {
        return (Location) get(PROPERTY_PARTNERADDRESS);
    }

    public void setPartnerAddress(Location partnerAddress) {
        set(PROPERTY_PARTNERADDRESS, partnerAddress);
    }

    public String getNombre() {
        return (String) get(PROPERTY_NOMBRE);
    }

    public void setNombre(String nombre) {
        set(PROPERTY_NOMBRE, nombre);
    }

    public String getApellido() {
        return (String) get(PROPERTY_APELLIDO);
    }

    public void setApellido(String apellido) {
        set(PROPERTY_APELLIDO, apellido);
    }

    public String getCdula() {
        return (String) get(PROPERTY_CDULA);
    }

    public void setCdula(String cdula) {
        set(PROPERTY_CDULA, cdula);
    }

    public String getTelfono() {
        return (String) get(PROPERTY_TELFONO);
    }

    public void setTelfono(String telfono) {
        set(PROPERTY_TELFONO, telfono);
    }

    public String getCelular() {
        return (String) get(PROPERTY_CELULAR);
    }

    public void setCelular(String celular) {
        set(PROPERTY_CELULAR, celular);
    }

    public String getDireccin() {
        return (String) get(PROPERTY_DIRECCIN);
    }

    public void setDireccin(String direccin) {
        set(PROPERTY_DIRECCIN, direccin);
    }

    public String getTipoVehculo() {
        return (String) get(PROPERTY_TIPOVEHCULO);
    }

    public void setTipoVehculo(String tipoVehculo) {
        set(PROPERTY_TIPOVEHCULO, tipoVehculo);
    }

    public String getMarca() {
        return (String) get(PROPERTY_MARCA);
    }

    public void setMarca(String marca) {
        set(PROPERTY_MARCA, marca);
    }

    public String getModelo() {
        return (String) get(PROPERTY_MODELO);
    }

    public void setModelo(String modelo) {
        set(PROPERTY_MODELO, modelo);
    }

    public Long getAo() {
        return (Long) get(PROPERTY_AO);
    }

    public void setAo(Long ao) {
        set(PROPERTY_AO, ao);
    }

    public String getNMotor() {
        return (String) get(PROPERTY_NMOTOR);
    }

    public void setNMotor(String nMotor) {
        set(PROPERTY_NMOTOR, nMotor);
    }

    public String getNChasis() {
        return (String) get(PROPERTY_NCHASIS);
    }

    public void setNChasis(String nChasis) {
        set(PROPERTY_NCHASIS, nChasis);
    }

    public String getPlaca() {
        return (String) get(PROPERTY_PLACA);
    }

    public void setPlaca(String placa) {
        set(PROPERTY_PLACA, placa);
    }

    public String getColor() {
        return (String) get(PROPERTY_COLOR);
    }

    public void setColor(String color) {
        set(PROPERTY_COLOR, color);
    }

    public Long getKmHoras() {
        return (Long) get(PROPERTY_KMHORAS);
    }

    public void setKmHoras(Long kmHoras) {
        set(PROPERTY_KMHORAS, kmHoras);
    }

    public Date getFechaVenta() {
        return (Date) get(PROPERTY_FECHAVENTA);
    }

    public void setFechaVenta(Date fechaVenta) {
        set(PROPERTY_FECHAVENTA, fechaVenta);
    }

    public Organization getLocalDeVenta() {
        return (Organization) get(PROPERTY_LOCALDEVENTA);
    }

    public void setLocalDeVenta(Organization localDeVenta) {
        set(PROPERTY_LOCALDEVENTA, localDeVenta);
    }

    public BusinessPartner getMecnicoAsignado() {
        return (BusinessPartner) get(PROPERTY_MECNICOASIGNADO);
    }

    public void setMecnicoAsignado(BusinessPartner mecnicoAsignado) {
        set(PROPERTY_MECNICOASIGNADO, mecnicoAsignado);
    }

    public String getDescripcinDelPedidoDelCliente() {
        return (String) get(PROPERTY_DESCRIPCINDELPEDIDODELCLIENTE);
    }

    public void setDescripcinDelPedidoDelCliente(String descripcinDelPedidoDelCliente) {
        set(PROPERTY_DESCRIPCINDELPEDIDODELCLIENTE, descripcinDelPedidoDelCliente);
    }

    public String getObservacin() {
        return (String) get(PROPERTY_OBSERVACIN);
    }

    public void setObservacin(String observacin) {
        set(PROPERTY_OBSERVACIN, observacin);
    }

    public Boolean isDespacho() {
        return (Boolean) get(PROPERTY_DESPACHO);
    }

    public void setDespacho(Boolean despacho) {
        set(PROPERTY_DESPACHO, despacho);
    }

    public Boolean isCrearfactura() {
        return (Boolean) get(PROPERTY_CREARFACTURA);
    }

    public void setCrearfactura(Boolean crearfactura) {
        set(PROPERTY_CREARFACTURA, crearfactura);
    }

    public Locator getStorageBin() {
        return (Locator) get(PROPERTY_STORAGEBIN);
    }

    public void setStorageBin(Locator storageBin) {
        set(PROPERTY_STORAGEBIN, storageBin);
    }

    public PaymentTerm getPaymentTerms() {
        return (PaymentTerm) get(PROPERTY_PAYMENTTERMS);
    }

    public void setPaymentTerms(PaymentTerm paymentTerms) {
        set(PROPERTY_PAYMENTTERMS, paymentTerms);
    }

    public PriceList getPriceList() {
        return (PriceList) get(PROPERTY_PRICELIST);
    }

    public void setPriceList(PriceList priceList) {
        set(PROPERTY_PRICELIST, priceList);
    }

    public Boolean isImprimirPreFactura() {
        return (Boolean) get(PROPERTY_IMPRIMIRPREFACTURA);
    }

    public void setImprimirPreFactura(Boolean imprimirPreFactura) {
        set(PROPERTY_IMPRIMIRPREFACTURA, imprimirPreFactura);
    }

    public BigDecimal getSummedLineAmount() {
        return (BigDecimal) get(PROPERTY_SUMMEDLINEAMOUNT);
    }

    public void setSummedLineAmount(BigDecimal summedLineAmount) {
        set(PROPERTY_SUMMEDLINEAMOUNT, summedLineAmount);
    }

    public BigDecimal getGrandTotalAmount() {
        return (BigDecimal) get(PROPERTY_GRANDTOTALAMOUNT);
    }

    public void setGrandTotalAmount(BigDecimal grandTotalAmount) {
        set(PROPERTY_GRANDTOTALAMOUNT, grandTotalAmount);
    }

    public String getHora() {
        return (String) get(PROPERTY_HORA);
    }

    public void setHora(String hora) {
        set(PROPERTY_HORA, hora);
    }

    public Warehouse getWarehouse() {
        return (Warehouse) get(PROPERTY_WAREHOUSE);
    }

    public void setWarehouse(Warehouse warehouse) {
        set(PROPERTY_WAREHOUSE, warehouse);
    }

    public String getOrdenTrabajo() {
        return (String) get(PROPERTY_ORDENTRABAJO);
    }

    public void setOrdenTrabajo(String ordenTrabajo) {
        set(PROPERTY_ORDENTRABAJO, ordenTrabajo);
    }

    public Boolean isIndsupReactivarOrden() {
        return (Boolean) get(PROPERTY_INDSUPREACTIVARORDEN);
    }

    public void setIndsupReactivarOrden(Boolean indsupReactivarOrden) {
        set(PROPERTY_INDSUPREACTIVARORDEN, indsupReactivarOrden);
    }

    public String getEmail() {
        return (String) get(PROPERTY_EMAIL);
    }

    public void setEmail(String email) {
        set(PROPERTY_EMAIL, email);
    }

    public Boolean isIndsupCrearFactura() {
        return (Boolean) get(PROPERTY_INDSUPCREARFACTURA);
    }

    public void setIndsupCrearFactura(Boolean indsupCrearFactura) {
        set(PROPERTY_INDSUPCREARFACTURA, indsupCrearFactura);
    }

    public Boolean isIndsupIsConsol() {
        return (Boolean) get(PROPERTY_INDSUPISCONSOL);
    }

    public void setIndsupIsConsol(Boolean indsupIsConsol) {
        set(PROPERTY_INDSUPISCONSOL, indsupIsConsol);
    }

    public Boolean isIndsupValida() {
        return (Boolean) get(PROPERTY_INDSUPVALIDA);
    }

    public void setIndsupValida(Boolean indsupValida) {
        set(PROPERTY_INDSUPVALIDA, indsupValida);
    }

    public Boolean isIndsupConsolida() {
        return (Boolean) get(PROPERTY_INDSUPCONSOLIDA);
    }

    public void setIndsupConsolida(Boolean indsupConsolida) {
        set(PROPERTY_INDSUPCONSOLIDA, indsupConsolida);
    }

    public String getIndsupEstConsol() {
        return (String) get(PROPERTY_INDSUPESTCONSOL);
    }

    public void setIndsupEstConsol(String indsupEstConsol) {
        set(PROPERTY_INDSUPESTCONSOL, indsupEstConsol);
    }

    public Boolean isIndsupFactConsol() {
        return (Boolean) get(PROPERTY_INDSUPFACTCONSOL);
    }

    public void setIndsupFactConsol(Boolean indsupFactConsol) {
        set(PROPERTY_INDSUPFACTCONSOL, indsupFactConsol);
    }

    public indsupTipofac getIndsupTipConsol() {
        return (indsupTipofac) get(PROPERTY_INDSUPTIPCONSOL);
    }

    public void setIndsupTipConsol(indsupTipofac indsupTipConsol) {
        set(PROPERTY_INDSUPTIPCONSOL, indsupTipConsol);
    }

    public Boolean isSswosNew() {
        return (Boolean) get(PROPERTY_SSWOSNEW);
    }

    public void setSswosNew(Boolean sswosNew) {
        set(PROPERTY_SSWOSNEW, sswosNew);
    }

    public Brand getSswosMBrand() {
        return (Brand) get(PROPERTY_SSWOSMBRAND);
    }

    public void setSswosMBrand(Brand sswosMBrand) {
        set(PROPERTY_SSWOSMBRAND, sswosMBrand);
    }

    public SsfiModelProduct getSswosSsfiModelProd() {
        return (SsfiModelProduct) get(PROPERTY_SSWOSSSFIMODELPROD);
    }

    public void setSswosSsfiModelProd(SsfiModelProduct sswosSsfiModelProd) {
        set(PROPERTY_SSWOSSSFIMODELPROD, sswosSsfiModelProd);
    }

    public SswosYear getSswosYear() {
        return (SswosYear) get(PROPERTY_SSWOSYEAR);
    }

    public void setSswosYear(SswosYear sswosYear) {
        set(PROPERTY_SSWOSYEAR, sswosYear);
    }

    public SswosColor getSswosColor() {
        return (SswosColor) get(PROPERTY_SSWOSCOLOR);
    }

    public void setSswosColor(SswosColor sswosColor) {
        set(PROPERTY_SSWOSCOLOR, sswosColor);
    }

    public DocumentType getSswosCDoctypetarget() {
        return (DocumentType) get(PROPERTY_SSWOSCDOCTYPETARGET);
    }

    public void setSswosCDoctypetarget(DocumentType sswosCDoctypetarget) {
        set(PROPERTY_SSWOSCDOCTYPETARGET, sswosCDoctypetarget);
    }

    public Boolean isSswosTransferparts() {
        return (Boolean) get(PROPERTY_SSWOSTRANSFERPARTS);
    }

    public void setSswosTransferparts(Boolean sswosTransferparts) {
        set(PROPERTY_SSWOSTRANSFERPARTS, sswosTransferparts);
    }

    public DocumentType getSswosCDoctypetargets() {
        return (DocumentType) get(PROPERTY_SSWOSCDOCTYPETARGETS);
    }

    public void setSswosCDoctypetargets(DocumentType sswosCDoctypetargets) {
        set(PROPERTY_SSWOSCDOCTYPETARGETS, sswosCDoctypetargets);
    }

    public Boolean isSswosCreateorder() {
        return (Boolean) get(PROPERTY_SSWOSCREATEORDER);
    }

    public void setSswosCreateorder(Boolean sswosCreateorder) {
        set(PROPERTY_SSWOSCREATEORDER, sswosCreateorder);
    }

    public Boolean isSswosCreateorders() {
        return (Boolean) get(PROPERTY_SSWOSCREATEORDERS);
    }

    public void setSswosCreateorders(Boolean sswosCreateorders) {
        set(PROPERTY_SSWOSCREATEORDERS, sswosCreateorders);
    }

    public Order getSswosCOrder() {
        return (Order) get(PROPERTY_SSWOSCORDER);
    }

    public void setSswosCOrder(Order sswosCOrder) {
        set(PROPERTY_SSWOSCORDER, sswosCOrder);
    }

    public Boolean isSswonSendprefecture() {
        return (Boolean) get(PROPERTY_SSWONSENDPREFECTURE);
    }

    public void setSswonSendprefecture(Boolean sswonSendprefecture) {
        set(PROPERTY_SSWONSENDPREFECTURE, sswonSendprefecture);
    }

    public Boolean isSSWOSTransferPartsReturn() {
        return (Boolean) get(PROPERTY_SSWOSTRANSFERPARTSRETURN);
    }

    public void setSSWOSTransferPartsReturn(Boolean sSWOSTransferPartsReturn) {
        set(PROPERTY_SSWOSTRANSFERPARTSRETURN, sSWOSTransferPartsReturn);
    }

    public Boolean isSswosLoadconsol() {
        return (Boolean) get(PROPERTY_SSWOSLOADCONSOL);
    }

    public void setSswosLoadconsol(Boolean sswosLoadconsol) {
        set(PROPERTY_SSWOSLOADCONSOL, sswosLoadconsol);
    }

    public User getSatmacSalesrep() {
        return (User) get(PROPERTY_SATMACSALESREP);
    }

    public void setSatmacSalesrep(User satmacSalesrep) {
        set(PROPERTY_SATMACSALESREP, satmacSalesrep);
    }

    public Boolean isSswosrePrintdocuments() {
        return (Boolean) get(PROPERTY_SSWOSREPRINTDOCUMENTS);
    }

    public void setSswosrePrintdocuments(Boolean sswosrePrintdocuments) {
        set(PROPERTY_SSWOSREPRINTDOCUMENTS, sswosrePrintdocuments);
    }

    public Project getSatmacProject() {
        return (Project) get(PROPERTY_SATMACPROJECT);
    }

    public void setSatmacProject(Project satmacProject) {
        set(PROPERTY_SATMACPROJECT, satmacProject);
    }

    public Satmac_MachineType getSatmacMachineType() {
        return (Satmac_MachineType) get(PROPERTY_SATMACMACHINETYPE);
    }

    public void setSatmacMachineType(Satmac_MachineType satmacMachineType) {
        set(PROPERTY_SATMACMACHINETYPE, satmacMachineType);
    }

    public Satmac_Contract getSatmacContract() {
        return (Satmac_Contract) get(PROPERTY_SATMACCONTRACT);
    }

    public void setSatmacContract(Satmac_Contract satmacContract) {
        set(PROPERTY_SATMACCONTRACT, satmacContract);
    }

    public InventoryCount getSatmacInventory() {
        return (InventoryCount) get(PROPERTY_SATMACINVENTORY);
    }

    public void setSatmacInventory(InventoryCount satmacInventory) {
        set(PROPERTY_SATMACINVENTORY, satmacInventory);
    }

    public String getSatmacName() {
        return (String) get(PROPERTY_SATMACNAME);
    }

    public void setSatmacName(String satmacName) {
        set(PROPERTY_SATMACNAME, satmacName);
    }

    public Project getSATMACContractProject() {
        return (Project) get(COMPUTED_COLUMN_SATMACCONTRACTPROJECT);
    }

    public void setSATMACContractProject(Project sATMACContractProject) {
        set(COMPUTED_COLUMN_SATMACCONTRACTPROJECT, sATMACContractProject);
    }

    public atindpo_postventa_ComputedColumns get_computedColumns() {
        return (atindpo_postventa_ComputedColumns) get(PROPERTY__COMPUTEDCOLUMNS);
    }

    public void set_computedColumns(atindpo_postventa_ComputedColumns _computedColumns) {
        set(PROPERTY__COMPUTEDCOLUMNS, _computedColumns);
    }

    @SuppressWarnings("unchecked")
    public List<Invoice> getInvoiceEMAtindpoPostventaIDList() {
      return (List<Invoice>) get(PROPERTY_INVOICEEMATINDPOPOSTVENTAIDLIST);
    }

    public void setInvoiceEMAtindpoPostventaIDList(List<Invoice> invoiceEMAtindpoPostventaIDList) {
        set(PROPERTY_INVOICEEMATINDPOPOSTVENTAIDLIST, invoiceEMAtindpoPostventaIDList);
    }

    @SuppressWarnings("unchecked")
    public List<ShipmentInOut> getMaterialMgmtShipmentInOutEMAtindpoPostventaIDList() {
      return (List<ShipmentInOut>) get(PROPERTY_MATERIALMGMTSHIPMENTINOUTEMATINDPOPOSTVENTAIDLIST);
    }

    public void setMaterialMgmtShipmentInOutEMAtindpoPostventaIDList(List<ShipmentInOut> materialMgmtShipmentInOutEMAtindpoPostventaIDList) {
        set(PROPERTY_MATERIALMGMTSHIPMENTINOUTEMATINDPOPOSTVENTAIDLIST, materialMgmtShipmentInOutEMAtindpoPostventaIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SswosBinnacle> getSswosBinnacleList() {
      return (List<SswosBinnacle>) get(PROPERTY_SSWOSBINNACLELIST);
    }

    public void setSswosBinnacleList(List<SswosBinnacle> sswosBinnacleList) {
        set(PROPERTY_SSWOSBINNACLELIST, sswosBinnacleList);
    }

    @SuppressWarnings("unchecked")
    public List<SswosTransfer> getSswosTransferList() {
      return (List<SswosTransfer>) get(PROPERTY_SSWOSTRANSFERLIST);
    }

    public void setSswosTransferList(List<SswosTransfer> sswosTransferList) {
        set(PROPERTY_SSWOSTRANSFERLIST, sswosTransferList);
    }

    @SuppressWarnings("unchecked")
    public List<atindpo_postventalinea> getAtindpoPostventalineaList() {
      return (List<atindpo_postventalinea>) get(PROPERTY_ATINDPOPOSTVENTALINEALIST);
    }

    public void setAtindpoPostventalineaList(List<atindpo_postventalinea> atindpoPostventalineaList) {
        set(PROPERTY_ATINDPOPOSTVENTALINEALIST, atindpoPostventalineaList);
    }

    @SuppressWarnings("unchecked")
    public List<indsupConsol> getIndsupConsolList() {
      return (List<indsupConsol>) get(PROPERTY_INDSUPCONSOLLIST);
    }

    public void setIndsupConsolList(List<indsupConsol> indsupConsolList) {
        set(PROPERTY_INDSUPCONSOLLIST, indsupConsolList);
    }

    @SuppressWarnings("unchecked")
    public List<indsupConsol> getIndsupConsolEMSswosAtindpoPostventaIDList() {
      return (List<indsupConsol>) get(PROPERTY_INDSUPCONSOLEMSSWOSATINDPOPOSTVENTAIDLIST);
    }

    public void setIndsupConsolEMSswosAtindpoPostventaIDList(List<indsupConsol> indsupConsolEMSswosAtindpoPostventaIDList) {
        set(PROPERTY_INDSUPCONSOLEMSSWOSATINDPOPOSTVENTAIDLIST, indsupConsolEMSswosAtindpoPostventaIDList);
    }

    @SuppressWarnings("unchecked")
    public List<indsupOrdenDespacho> getIndsupOrdDespList() {
      return (List<indsupOrdenDespacho>) get(PROPERTY_INDSUPORDDESPLIST);
    }

    public void setIndsupOrdDespList(List<indsupOrdenDespacho> indsupOrdDespList) {
        set(PROPERTY_INDSUPORDDESPLIST, indsupOrdDespList);
    }

    @SuppressWarnings("unchecked")
    public List<SSWCLBinnacle> getSswclBinnacleVList() {
      return (List<SSWCLBinnacle>) get(PROPERTY_SSWCLBINNACLEVLIST);
    }

    public void setSswclBinnacleVList(List<SSWCLBinnacle> sswclBinnacleVList) {
        set(PROPERTY_SSWCLBINNACLEVLIST, sswclBinnacleVList);
    }

    @SuppressWarnings("unchecked")
    public List<SSWCLWorkOrderLine> getSswclWorkOrderlineVList() {
      return (List<SSWCLWorkOrderLine>) get(PROPERTY_SSWCLWORKORDERLINEVLIST);
    }

    public void setSswclWorkOrderlineVList(List<SSWCLWorkOrderLine> sswclWorkOrderlineVList) {
        set(PROPERTY_SSWCLWORKORDERLINEVLIST, sswclWorkOrderlineVList);
    }


    @Override
    public Object get(String propName) {
      if (COMPUTED_COLUMN_SATMACCONTRACTPROJECT.equals(propName)) {
        if (get_computedColumns() == null) {
          return null;
        }
        return get_computedColumns().getSATMACContractProject();
      }
    
      return super.get(propName);
    }
}
