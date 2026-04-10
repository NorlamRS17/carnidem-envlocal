(function () {
  var BPL = OB.Model.BPLocation.prototype;
  BPL.saveCustomerAddr = function (callback, callbackError) {
    console.log("Custom Save Customer Addr");
    var nameLength, newSk;
    if (!this.get('isBillTo') && !this.get('isShipTo')) {
      OB.UTIL.showError(OB.I18N.getLabel('OBPOS_shippedOrInvoicedNotChekedOff'));
      if (callbackError instanceof Function) {
        callbackError();
      }
      return;
    }
    if (this.get('name') === '') {
      OB.UTIL.showError(OB.I18N.getLabel('OBPOS_NameReqForBPAddress'));
      if (callbackError instanceof Function) {
        callbackError();
      }
      return false;
    }
    this.set('_identifier', this.get('name'));
    this.set('salesRegion', localStorage.getItem("salesRegion"));

    if (OB.MobileApp.model.hasPermission('OBMOBC_SynchronizedMode', true)) {
      OB.DATA.executeCustomerAddressSave(this, callback, callbackError);
    } else {
      this.trigger('customerAddrSaved');
      callback();
    }
    localStorage.removeItem("salesRegion");
    return true;
  };
}());