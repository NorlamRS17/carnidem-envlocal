/*
 ************************************************************************************
 * Copyright (C) 2021 Openbravo S.L.U.
 * Licensed under the Openbravo Commercial License version 1.0
 * You may obtain a copy of the License at http://www.openbravo.com/legal/obcl.html
 * or in the legal folder of this module distribution.
 ************************************************************************************
 */

package ec.com.sidesoft.pos.geolocation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openbravo.client.kernel.ComponentProvider.Qualifier;
import org.openbravo.mobile.core.model.HQLProperty;
import org.openbravo.mobile.core.model.ModelExtension;
import org.openbravo.retail.posterminal.master.BPLocation;
import org.openbravo.retail.posterminal.master.BusinessPartner;

@Qualifier(BPLocation.bpLocationPropertyExtension)
public class CustomerLocationAddressProperties extends ModelExtension {

  @Override
  public List<HQLProperty> getHQLProperties(Object params) {
    return Arrays.asList(new HQLProperty("bploc.sspsiLatitude", "sspsiLatitude"),
        new HQLProperty("bploc.sspsiLongitude", "sspsiLongitude"));
  }
}
