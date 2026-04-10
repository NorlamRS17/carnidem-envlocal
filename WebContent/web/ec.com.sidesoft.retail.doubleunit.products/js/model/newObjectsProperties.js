// COMPONENTE UNIDAD OPERATIVA
enyo.kind({
	name: 'OB.UI.OperationalQtyProperty',
	style: 'width: 100%;',
	components: [{
			name: "addAndRemoveQtyOperational",
			style: "padding: 0px 0px 0px 10px; margin-left: -10px;",
			updateCount: function (value, avoidPropagation) {
				var me = this;
				var value2;
				if (typeof value === "undefined" || value === null) {
					// If there is no value passed as first argument, probably it has been called from a keydown
					// so there is a timeout to ensure the value is refreshed
					setTimeout(function () {
						me.updateCount(me.owner.$.inputQty.getValue(), avoidPropagation);
					}, 100);
					return;
				}

				value2 = value;

				if (value !== "") {
					//value = parseInt(value, 10);
					value = parseFloat(value);

					//if (isNaN(value)) {
					//	value = 1;
					//}
				}

				this.applyStyle("display", "block");
				var validNmb = parseFloat(this.owner.$.inputQty.getValue().toString());

				//if (this.owner.$.inputQty.getValue().toString() !== value.toString()) {
				if (validNmb > 0) {
					if (value === 0) {
						value = 1;
					}

					var temp = calculatedThis.$.line_doubleUnitCombo.$.newAttribute.$.doubleUnitCombo.$.doubleUnitCombo;
					var convertRate = temp.collection.models[temp.selected].get('conversionrate');
					var qty = value;
					var newQty = convertRate * qty;
					var nuevoPrecio = (priceThis * newQty).toFixed(2);
					calculatedThis.$.line_priceProduct.$.newAttribute.$.priceProduct.setValue(nuevoPrecio);
					//this.owner.$.inputQty.setValue(value);
					var formatvalue2 = value2.toString();
					this.owner.$.inputQty.setValue(formatvalue2.replace('..', '.'));

					//this.owner.$.addAndRemoveQtyOperational.updateCount(nuevoPrecio);

				}

				// Then we call super 'setCProductQty' to propagate the change
				if (!avoidPropagation && value !== "") {
					// setProductQtyDependingOfComboQty
					//this.owner.owner.owner.owner.setProductQtyDependingOfComboQty(parseInt(value, 10));
				}
			},
			getCount: function () {
				var count = this.owner.$.inputQty.getValue();
				if (!count) {
					count = 0;
				}
				count = parseFloat(count);
				if (isNaN(count)) {
					count = 1;
				}
				return count;
			},
			components: [
				// INICIO BOTON MENOS CANTIDAD OPERATIVA
				{
					kind: "OB.UI.SmallButton",
					name: "removeButton",
					label: "-",
					style: "width: 42px; height: 38px; padding: 0px; margin: 0px 10px 0px 0px; border: 1px solid #cccccc;",
					classes: "btnlink-white btn-icon-small",
					tap: function () {
						var currentValue = this.owner.$.inputQty.getValue();
						currentValue = currentValue || 1;
						//currentValue = parseInt(currentValue, 10) - 1;
						currentValue = parseFloat(currentValue) - 1;
						if (currentValue < 0) {
							currentValue = 1;
						}
						this.owner.$.addAndRemoveQtyOperational.updateCount(currentValue);
					}
				},
				// FIN BOTON MENOS CANTIDAD OPERATIVA

				// INICIO INPUT CANTIDAD OPERATIVO
				{
					kind: "enyo.Input",
					type: "text",
					name: "inputQty",
					classes: "input-login",
					value: 1,
					handlers: {
						onkeydown: "keydownHandler",
						onchange: "changeHandler"
					},
					keydownHandler: function (inSender, inEvent) {
						var charCode = inEvent.which || inEvent.keyCode;
						if (
							(charCode < 48 ||
								(charCode > 57 && charCode < 96) ||
								charCode > 105) &&
							charCode !== 46 &&
							charCode !== 8 &&
							charCode !== 37 &&
							charCode !== 39 &&
							charCode !== 35 &&
							charCode !== 36 &&
							charCode !== 190
						) {
							//Only allow numbers / Del / Backspace / arrows / Start / End
							inEvent.preventDefault();
							return false;
						}

						var validpoint;

						if (charCode !== 190 || charCode !== 48) {
							var chark = ".";
							validpoint = this.owner.$.inputQty.getValue() + chark;

						}

						if (parseFloat(validpoint) && charCode == 190) {

							var preg = /^([0-9]+\.?[0-9]{0,2})$/;
							if (preg.test(validpoint) === false) {
								inEvent.preventDefault();
								return false;
							}
						}

						this.owner.$.addAndRemoveQtyOperational.updateCount();
					},
					changeHandler: function (inSender, inEvent) {
						// To avoid empty or invalid input values be in the input once the input blurs
						this.owner.$.addAndRemoveQtyOperational.updateCount(
							this.owner.$.addAndRemoveQtyOperational.getCount()
						);
					},
					style: "width: 80px; text-align: center; height: 40px; margin: 0px 0px 10px 0px;"
				},
				// FIN INPUT CANTIDAD OPERATIVO

				// INICIO BOTON MAS CANTIDAD OPERATIVO
				{
					kind: "OB.UI.SmallButton",
					name: "addButton",
					label: "+",
					style: "width: 42px; height: 38px; padding: 0px; margin: 0px 0px 10px 10px; border: 1px solid #cccccc;",
					classes: "btnlink-white btn-icon-small",
					tap: function () {
						var currentValue = this.owner.$.inputQty.getValue();
						currentValue = currentValue || 1;
						currentValue = parseFloat(currentValue) + 1;
						if (currentValue < 0) {
							currentValue = 1;
						}
						this.owner.$.addAndRemoveQtyOperational.updateCount(currentValue);
					}
				}
				// FIN BOTON MAS CANTIDAD OPERATIVO

			]
		},
		{
			style: "clear: both;"
		}
	]
});

// COMPONENTE COMBO DE LA DOBLE UNIDAD DEL PRODUCTO
enyo.kind({
	name: 'OB.UI.DoubleUnitComboProperty',
	handlers: {
		onLoadValue: 'loadValue',
		onSaveChange: 'saveChange',
		onApplyChange: 'applyChange',
		onchange: 'change'
	},
	events: {
		onSaveProperty: ''
	},
	components: [{
		kind: 'OB.UI.List',
		name: 'doubleUnitCombo',
		classes: 'combo',
		style: 'width: 101%; margin:0;',
		renderLine: enyo.kind({
			kind: 'enyo.Option',
			initComponents: function () {
				this.inherited(arguments);
				this.setValue(this.model.get(this.parent.parent.retrievedPropertyForValue));
				this.setContent(this.model.get(this.parent.parent.retrievedPropertyForText));
			}
		}),
		renderEmpty: 'enyo.Control'
	}],
	loadValue: function (inSender, inEvent) {
		this.$.doubleUnitCombo.setCollection(this.collection);
		this.fetchDataFunction(inEvent);
	},
	applyChange: function (inSender, inEvent) {
		console.log('apply change; ', inSender);
		console.log('apply change; ', inEvent);
		//return this.applyValue(inEvent.orderline);
	},
	dataReadyFunction: function (data, inEvent) {

		var index = 0,
			result = null;

		if (this.destroyed) {
			return;
		}

		if (data) {
			this.collection.reset(data.models);
		} else {
			this.collection.reset(null);
			return;
		}

		if (calculatedThis) {
			var temp = calculatedThis.$.line_doubleUnitCombo.$.newAttribute.$.doubleUnitCombo.$.doubleUnitCombo;
			var seleccionado;
			if (temp.selected >= temp.collection.length) {
				seleccionado = temp.selected - 1;
			} else {
				seleccionado = temp.selected;
			}
			var convertRate = temp.collection.models[seleccionado].get('conversionrate');
			var nuevoPrecio = (priceThis * convertRate).toFixed(2);
			calculatedThis.$.line_priceProduct.$.newAttribute.$.priceProduct.setValue(nuevoPrecio);
		}

		result = _.find(this.collection.models, function (categ) {
			if (inEvent.customer) {
				//Edit: select actual value
				if (categ.get(this.retrievedPropertyForValue) === inEvent.customer.get(this.modelProperty)) {
					return true;
				}
			} else {
				//New: select default value
				if (categ.get(this.retrievedPropertyForValue) === this.defaultValue()) {
					return true;
				}
			}
			index += 1;
		}, this);

		if (result) {
			this.$.doubleUnitCombo.setSelected(index);
		} else {
			this.$.doubleUnitCombo.setSelected(0);
		}
	},
	saveChange: function (inSender, inEvent) {
		var selected = this.collection.at(this.$.doubleUnitCombo.getSelected());
		inEvent.customer.set(this.modelProperty, selected.get(this.retrievedPropertyForValue));
		if (this.modelPropertyText) {
			inEvent.customer.set(this.modelPropertyText, selected.get(this.retrievedPropertyForText));
		}
	}
});

// COMPONENTE PRECIO DEL PRODUCTO
enyo.kind({
	name: 'OB.UI.ProductPriceProperty',
	kind: 'enyo.Input',
	type: 'text',
	classes: 'input',
	style: 'width: 100%;',
	initComponents: function () {
		this.setAttribute('readonly', 'readonly');
	}
});

// COMPONENTE NOMBRE DEL PRODUCTO
/*enyo.kind({
	name: 'OB.UI.ProductNameProperty',
	kind: 'enyo.Input',
	type: 'text',
	classes: 'input',
	style: 'width: 100%;',
	initComponents: function () {
		this.setAttribute('readonly', 'readonly');
	}
}); */

// UNIDAD PRINCIPAL DEL PRODUCTO
/*enyo.kind({
	name: 'OB.UI.ProductUomProperty',
	kind: 'enyo.Input',
	type: 'text',
	classes: 'input',
	style: 'width: 100%;',
	initComponents: function () {
		this.setAttribute('readonly', 'readonly');
	}
});	*/

enyo.kind({
	name: 'OB.UI.ModalOrderProperties',
	kind: 'OB.UI.ModalAction',
	handlers: {
		onApplyChanges: 'applyChanges'
	},
	bodyContent: {
		kind: 'Scroller',
		maxHeight: '400px',
		style: 'background-color: #ffffff;',
		thumb: true,
		horizontal: 'hidden',
		components: [{
			name: 'attributes'
		}]
	},
	bodyButtons: {
		components: [{
			kind: 'OB.UI.OrderPropertiesDialogApplyy'
		}, {
			kind: 'OB.UI.OrderPropertiesDialogCancell'
		}]
	},
	loadValue: function (mProperty) {
		this.waterfall('onLoadValue', {
			model: this.model,
			modelProperty: mProperty
		});
	},

	applyChanges: function (inSender, inEvent) {
		var diff, att, result = true;

		return result;
	},
	initComponents: function () {
		this.inherited(arguments);
		this.attributeContainer = this.$.bodyContent.$.attributes;
		this.propertycomponents = {};
		if (this.attributeContainer) {
			enyo.forEach(this.newAttributes, function (natt) {
				if (natt.kind === 'OB.UI.DoubleUnitComboProperty' ||
					natt.kind === 'OB.UI.OperationalQtyProperty' ||
					natt.kind === 'OB.UI.ProductPriceProperty') {

					var editline = this.$.bodyContent.$.attributes.createComponent({
						kind: 'OB.UI.PropertyEditLine',
						name: 'line_' + natt.name,
						newAttribute: natt
					});
					this.propertycomponents[natt.modelProperty] = editline.propertycomponent;
					this.propertycomponents[natt.modelProperty].propertiesDialog = this;
				}
			}, this);
		}
	}
});