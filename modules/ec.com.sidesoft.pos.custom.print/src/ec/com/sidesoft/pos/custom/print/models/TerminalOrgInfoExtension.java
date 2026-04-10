package ec.com.sidesoft.pos.custom.print.models;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.openbravo.client.kernel.ComponentProvider.Qualifier;
import org.openbravo.mobile.core.model.HQLProperty;
import org.openbravo.mobile.core.model.ModelExtension;
import org.openbravo.retail.posterminal.term.Terminal;

/**
 * Extension para agregar propiedades de información de organización contable al terminal
 * Estas propiedades se usan en el template de impresión de facturas
 */
@ApplicationScoped
@Qualifier(Terminal.terminalPropertyExtension)
public class TerminalOrgInfoExtension extends ModelExtension {

  @Override
  public List<HQLProperty> getHQLProperties(Object params) {
    ArrayList<HQLProperty> list = new ArrayList<HQLProperty>();
    
    list.add(new HQLProperty(
        "(SELECT COALESCE(legalOrg.socialName, legalOrg.name) FROM Organization legalOrg WHERE legalOrg.organizationType.name = 'Legal with accounting' AND legalOrg.client.id = pos.client.id)",
        "legalOrgName"));
    list.add(new HQLProperty(
        "(SELECT legalOrgInfo.taxID FROM Organization legalOrg, OrganizationInformation legalOrgInfo WHERE legalOrg.organizationType.name = 'Legal with accounting' AND legalOrg.client.id = pos.client.id AND legalOrgInfo.organization.id = legalOrg.id)",
        "legalOrgTaxId"));
    list.add(new HQLProperty(
        "(SELECT CONCAT(CONCAT(COALESCE(oi2.locationAddress.addressLine1, ''), CASE WHEN oi2.locationAddress.addressLine2 IS NOT NULL AND oi2.locationAddress.addressLine2 != '' THEN CONCAT(' - ', oi2.locationAddress.addressLine2) ELSE '' END), CASE WHEN oi2.locationAddress.cityName IS NOT NULL AND oi2.locationAddress.cityName != '' THEN CONCAT(' - ', oi2.locationAddress.cityName) ELSE '' END) FROM OrganizationInformation oi2 WHERE oi2.organization.id = pos.organization.id AND oi2.active = true)",
        "posAddress"));
    
    list.add(new HQLProperty(
        "(SELECT oi3.userContact.phone FROM OrganizationInformation oi3 WHERE oi3.organization.id = pos.organization.id AND oi3.active = true)",
        "orgContactPhone"));
    
    return list;
  }
}

