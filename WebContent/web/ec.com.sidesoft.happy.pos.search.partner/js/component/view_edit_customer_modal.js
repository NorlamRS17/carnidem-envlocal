(function () {
    /*global OB */
  
    OB.UI.ModalAdvancedFilterBP.extend({
        initComponents: function () {
            this.inherited(arguments);
            _.each(this.model.getProperties(), function (prop) {
              // Set filter options for bpCategory and taxID
              if (prop.name === 'bpCategory') {
                prop.filter = OB.MobileApp.model.get('terminal').bp_showcategoryselector;
              }
              if (prop.name === 'taxID') {
                prop.filter = OB.MobileApp.model.get('terminal').bp_showtaxid;
                prop.caption = 'SHCSBP_TaxID';
              }
            }, this);
            this.setFilters(this.model.getProperties());
          }
    });
  })();
  