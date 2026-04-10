var superThis;
var calculatedThis;
var priceThis;

enyo.kind({
    //name: 'OB.UI.ModalAction',
    name: 'SSDUP.ModalSetInfoOrder',    
    kind: 'OB.UI.ModalOrderProperties',
    newAttributes: [{
            name: 'operationalQty',
            modelProperty: 'operationalQty',
            kind: 'OB.UI.OperationalQtyProperty',
            i18nLabel: 'SSDUP_OperationalQty',
            style: "height: 50px !important;"
        },
        {
            kind: 'OB.UI.DoubleUnitComboProperty',
            name: 'doubleUnitCombo',
            modelProperty: 'ssdupdoubleunit',
            modelPropertyText: 'ssdupdoubleunit_searchKey',
            i18nLabel: 'SSDUP_Unit',
            // Model Collection to use. This definition has been created when registering the
            // ServeOption model
            collection: new OB.Collection.DoubleUnitList(),
            //retrievedPropertyForValue: 'id',
            retrievedPropertyForValue: 'conversionrate',
            retrievedPropertyForText: '_identifier',
            // This function is called to determine whether the property is displayed or not
            // This implementation shows the property only if the product has a Serve Option Category
            // This function is called to get the serve options for the selected product.
            // In this case we filter by the serve options category of the selected product.
            defaultValue: function () {
                return OB.MobileApp.model.get('terminal').defaultbp_taxidtype;
            },
            change: function (sender, event) {
                // SETEO EL VALOR DE LA CANTIDAD OPERACIONAL
                var qtyOperational = calculatedThis.$.line_operationalQty.$.newAttribute.$.operationalQty.$.inputQty;
                qtyOperational.setValue(1);

                // SE HACEN LOS CALCULOS PARA LA NUEVA SELECCION DE LA UNIDAD
                var base = this.$.doubleUnitCombo;
                var selected = base.selected;
                var convertRate = base.collection.models[selected].get('conversionrate');
                var qty = qtyOperational.getValue();
                var newQty = convertRate * qty;
                var nuevoPrecio = (priceThis * newQty).toFixed(2);
                calculatedThis.$.line_priceProduct.$.newAttribute.$.priceProduct.setValue(nuevoPrecio);
            },
            fetchDataFunction: function (args) {

                // Call to client DAL functionality to query for client data for
                // OB.Model.ServeOption filtering by field serveOptionCategory
                var me = this,
                    criteria,
                    criteriaAct;

                var comm = "'";
                criteria = {
                    _orderByClause: '_identifier asc'
                };

                OB.Dal.find(OB.Model.DoubleUnit, criteria, function (data, args) {

                    if (data) {
                        if (data.length > 0) {
                            criteriaAct = {
                                _whereClause: 'where idproduct =' + comm + superThis + comm,
                                _orderByClause: '_identifier asc'
                            };

                            OB.Dal.find(OB.Model.DoubleUnit, criteriaAct, function (data) {
                                // SE AGREGAN LOS DATOS A A LA LISTA DE UNIDADES ALTERNATIVAS
                                me.dataReadyFunction(data, args);
                            }, function () {
                                OB.UTIL.showError(OB.I18N.getLabel('OBCOMTR_ErrorGettingServeOptions'));
                                me.dataReadyFunction(null, args);
                            });
                        }
                    } else {
                        me.dataReadyFunction(null, args);
                    }

                    // In case of success assign the results to the property component
                    //window.console.log(data);
                    //me.dataReadyFunction(data, args)
                }, function (error) {
                    // In case of error, show an error message to the user and
                    // clean the property component
                    OB.UTIL.showError(OB.I18N.getLabel('OBCOMTR_ErrorGettingServeOptions'));
                    me.dataReadyFunction(null, args);
                }, args);

            }
        },
        {
            name: 'priceProduct',
            modelProperty: 'priceProduct',
            kind: 'OB.UI.ProductPriceProperty',
            i18nLabel: 'SSDUP_Price'
        }
    ],

    resetProperties: function () {
        var p, att;
        for (p in this.newAttributes) {
            if (this.newAttributes.hasOwnProperty(p)) {
                att = this.$.bodyContent.$.attributes.$['line_' + this.newAttributes[p].name].$.newAttribute.$[this.newAttributes[p].name];
                if (att && att.setValue) {
                    att.setValue('');
                }
            }
        }
    },

    init: function (model) {
        this.model = model;

        function errorCallbackDoctors(tx, error) {
            OB.UTIL.showError("OBDAL error: " + error);
        }

        this.model.get('order').get('lines').on('selected', function (lineSelected) {
            var diff, att;
            this.currentLine = lineSelected;
            if (lineSelected) {
                diff = this.propertycomponents;
                for (att in diff) {
                    if (diff.hasOwnProperty(att)) {
                        this.loadValue(att);
                    }
                }
            }
        }, this);

        this.model.bind('paymentAccepted', function () {
            this.resetProperties();
        }, this);
    },

    saveDataInfo: function (inSender, inEvent) {
        var me = this;
        this.conversionSet = true;
        this.hide();
        //this.args.callback(false);
        return true;
    },

    cancel: function () {
        this.hide();
    },

    bodyButtons: {
        components: [{
            kind: 'OB.UI.ModalDialogButton',
            name: 'OB.OBSSPOS.confirmGuestQty',
            i18nContent: 'OBMOBC_LblOk',
            isDefaultAction: true,
            ontap: 'saveDataInfo'
        }, {
            kind: 'OB.UI.ModalDialogButton',
            name: 'OB.OBSSPOS.cancelGuestQty',
            i18nContent: 'OBMOBC_LblCancel',
            ontap: 'cancel'
        }]
    },

    executeBeforeHide: function () {
        var me = this;
        // SE HACE LA CONVERSION A LA DOBLE UNIDAD
        if (this.conversionSet) {

            this.conversionSet = null;

            var temp = this.$.bodyContent.$.attributes.$.line_doubleUnitCombo.$.newAttribute.$.doubleUnitCombo.$.doubleUnitCombo;
            var convertRate = temp.collection.models[temp.selected].get('conversionrate');
            var unitName = temp.collection.models[temp.selected].get('searchKey');
            var unitId = temp.collection.models[temp.selected].get('id');
            var qty = this.$.bodyContent.$.attributes.$.line_operationalQty.$.newAttribute.$.operationalQty.$.inputQty.getValue();

            this.args.productToAdd.set('convertRate', convertRate);
            this.args.productToAdd.set('operationalQty', qty);
            this.args.productToAdd.set('unitId', unitId);
            this.args.productToAdd.set('unitName', unitName);

            this.args.callback(false);

        } else {
            // SE PRESIONA EL BOTON CANCELAR
            if (me.name === 'SSDUP_ModalSetInfoOrder') {
                this.args.callback(true);
                return true;
            }
        }
    },

    executeOnShow: function () {
        var me = this;

        this.$.bodyButtons.saveDataInfo = function (inSender, inEvent) {
            me.saveDataInfo(inSender, inEvent);
        };
        this.$.bodyButtons.cancel = function () {
            me.cancel();
        };

        // RECUPERAR LA UNIDAD OPERATIVA CUANDO SE EDITA
        var editLine = true;
        var newOpeQty;
        if (this.args.receipt.get('lines').models.length > 0) {
            for (var i = 0; this.args.receipt.get('lines').models.length > i; i++) {
                var line = this.args.receipt.get('lines').at(i);
                if (line) {
                    var product = this.args.productToAdd.get('id');
                    if (line.get('product').id === product) {
                        newOpeQty = line.get('qty');
                        editLine = false;
                    }
                }
            }
        }

        var base = this.$.bodyContent.$.attributes;
        var headerName = this.args.productToAdd.get('_identifier') + ' - ' + this.args.productToAdd.get('uOMsymbol');
        this.$.header.setContent(headerName);
        base.$.line_priceProduct.$.newAttribute.$.priceProduct.setValue(this.args.productToAdd.get('standardPrice'));
        base.$.line_operationalQty.$.newAttribute.$.operationalQty.$.inputQty.setValue(newOpeQty);

        superThis = this.args.productToAdd.get('id');
        calculatedThis = this.$.bodyContent.$.attributes;
        priceThis = this.args.productToAdd.get('standardPrice');

    }
});

OB.UI.WindowView.registerPopup('OB.OBPOSPointOfSale.UI.PointOfSale', {
    kind: 'SSDUP.ModalSetInfoOrder',
    name: 'SSDUP_ModalSetInfoOrder'
});

