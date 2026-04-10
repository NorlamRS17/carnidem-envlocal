(function () {
  var BP = OB.Model.BusinessPartner.prototype;
  BP.saveCustomer = function (callback) {
    console.log("Custom Save Customer");
    var nameLength, newSk;

    if (!this.get('name')) {
      OB.UTIL.showError(OB.I18N.getLabel('OBPOS_BPartnerNameRequired'));
      return false;
    }

    if (!this.get('id')) {
      if (this.get('useSameAddrForShipAndInv')) {
        //Create 1 address for shipping and invoicing
        if (!this.get('locName')) {
          OB.UTIL.showError(OB.I18N.getLabel('OBPOS_BPartnerAddressRequired'));
          return false;
        }
        this.set('locId', OB.UTIL.get_UUID());
        this.set('shipLocId', this.get('locId'));
        this.set('shipLocName', this.get('locName'));
        this.set('shipPostalCode', this.get('postalCode'));
        this.set('shipCityName', this.get('cityName'));
        this.set('shipCountryName', this.get('countryName'));
        this.set('shipCountryId', this.get('countryId'));
        this.set('salesRegion', localStorage.getItem("salesRegion"));
      } else {
        //Create 1 address for shipping and 1 for invoicing
        if (!this.get('locName') || !this.get('shipLocName')) {
          OB.UTIL.showError(OB.I18N.getLabel('OBPOS_BPartnerAddressRequired'));
          return false;
        }
        this.set('locId', OB.UTIL.get_UUID());
        this.set('shipLocId', OB.UTIL.get_UUID());
      }
    }

    if (!this.get('contactId')) {
      this.set('contactId', OB.UTIL.get_UUID());
    }

    if (!this.get('searchKey')) {
      nameLength = this.get('name').toString().length;
      newSk = this.get('name');
      if (nameLength > 30) {
        newSk = this.get('name').substring(0, 30);
      }
      this.set('searchKey', newSk);
    }

    if (this.get('birthDay') && typeof this.get('birthDay') !== 'object') {
      return;
    }

    if (this.get('birthDay') && !OB.UTIL.isInThePast(OB.I18N.formatDate(this.get('birthDay')))) {
      OB.UTIL.showError(OB.I18N.getLabel('OBPOS_BPartnerBirthDayIncorrect'));
      return false;
    }

    this.set('_identifier', this.get('name'));

    localStorage.removeItem("salesRegion");
    // in case of synchronized then directly call customer save with the callback
    OB.DATA.executeCustomerSave(this, callback);
    return true;
  };
}());