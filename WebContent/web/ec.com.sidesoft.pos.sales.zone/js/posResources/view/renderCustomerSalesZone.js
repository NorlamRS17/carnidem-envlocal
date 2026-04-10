(function () {
    var PropertyOptionDefinition = {
        kind: 'OB.UI.List',
        classes: 'combo',
        name: 'customerSalesZone',
        i18nLabel: 'SPSZ_SaleZoneLabel',
        handlers: {
            onLoadValue: 'loadValue',
            onApplyChange: 'applyChange'
        },
        renderLine: enyo.kind({
            kind: "enyo.Option",
            initComponents: function () {
                this.inherited(arguments);
                this.setValue(this.model.get("id"));
                this.setContent(this.model.get("name"));
            },
        }),
        style: 'width: 101%; margin:0;',
        initComponents: function () {
            var me = this;
            var columns = [{ id: '0', name: '' }];
            criteria = {};

            me.setCollection(new Backbone.Collection());
            me.getCollection().reset(columns);
        },
        renderEmpty: "enyo.Control",
        mandatory: false,
        change: function () {
            var value = this.getValue();
        },
        hideShow: function (inSender, inEvent) {
            if (inEvent.checked) {
                this.owner.removeClass('width52');
                this.owner.owner.$.labelLine.removeClass('width40');
            } else {
                this.owner.addClass('width52');
                this.owner.owner.$.labelLine.addClass('width40');
            }
        },
        loadValue: function (inSender, inEvent) {
            if (inEvent.customerAddr) {
                var me = this;
                var data = me.getCollection();
                var salesRegion = inEvent.customerAddr.attributes.salesRegion;

                if (salesRegion === null || salesRegion === "null") {
                    indexCanal = 0;
                } else {
                    for (var i = 0; i < data.length; i++) {
                        var SalesZoneModel = data.models[i];
                        if (SalesZoneModel.get('id') === inEvent.customerAddr.attributes.salesRegion) {
                            indexCanal = i;
                            break;
                        }
                    }
                }
                this.setSelected(indexCanal);
            }
        },
    };

    OB.OBPOSPointOfSale.UI.customeraddr.edit_createcustomers_impl.prototype.newAttributes.push(PropertyOptionDefinition);
    OB.OBPOSPointOfSale.UI.customers.edit_createcustomers_impl.prototype.shipAddrAttributes.push(PropertyOptionDefinition);
})();

