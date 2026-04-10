OB.UTIL.HookManager.registerHook('OBPOS_PreCustomerAddrSave', function (args, callbacks) {
        // Extension to the customer address save process

        var salesZoneSelected =  args.meObject.$.customerAddrAttributes.$.line_customerSalesZone.$.newAttribute.$.customerSalesZone.getValue();
        
        if (salesZoneSelected == "0") {
            salesZoneSelected = null;
        }
        
        localStorage.setItem("salesRegion", salesZoneSelected);
        
        OB.UTIL.HookManager.callbackExecutor(args, callbacks);
});