/*global OB, _, Backbone */

(function () {
	//Modal Tercero
	const renderSalesZoneSelector = OB.OBPOSPointOfSale.UI.customers.edit_createcustomers_impl.prototype.shipAddrAttributes.find(
		(c) => c.name === 'customerSalesZone'
	);
	
	//Modal Direccion
	const renderSalesZoneSelectorAddr = OB.OBPOSPointOfSale.UI.customeraddr.edit_createcustomers_impl.prototype.newAttributes.find(
		(c) => c.name === 'customerSalesZone'
	);

	renderSalesZoneSelector.initComponents = _.wrap(
		renderSalesZoneSelector.initComponents,
		function (wrapper) {
			var datasources = [OB.Model.PosSalesZone];

			const columns = [{ id: '0', name: '' }];
			var me = this;
			criteria = {};

			OB.Dal.find(OB.Model.PosSalesZone, criteria, function (data) {
				if (data && (data.length > 0)) {
					var tempArray = [];
					_.forEach(data.models, function (model) {
						var item = {
							id: model.get('id'),
							name: model.get('name'),
						};

						tempArray.push(item);
					});

					tempArray.sort(function (a, b) {
						return a.name.localeCompare(b.name);
					});

					_.forEach(tempArray, function (item) {
						columns.push(item);
					});
				}

				me.setCollection(new Backbone.Collection());
				me.getCollection().reset(columns);

			}, function (error) {
				me.setCollection(new Backbone.Collection());
				me.getCollection().reset(columns);
				console.log("PosSalesZone Combo Error: ", error);
			});

		}
	);

	renderSalesZoneSelectorAddr.initComponents = _.wrap(
		renderSalesZoneSelectorAddr.initComponents,
		function (wrapper) {
			var datasources = [OB.Model.PosSalesZone];

			const columns = [{ id: '0', name: '' }];
			var me = this;
			criteria = {};

			OB.Dal.find(OB.Model.PosSalesZone, criteria, function (data) {
				if (data && (data.length > 0)) {
					var tempArray = [];
					_.forEach(data.models, function (model) {
						var item = {
							id: model.get('id'),
							name: model.get('name'),
						};

						tempArray.push(item);
					});

					tempArray.sort(function (a, b) {
						return a.name.localeCompare(b.name);
					});

					_.forEach(tempArray, function (item) {
						columns.push(item);
					});
				}

				me.setCollection(new Backbone.Collection());
				me.getCollection().reset(columns);

			}, function (error) {
				me.setCollection(new Backbone.Collection());
				me.getCollection().reset(columns);
				console.log("PosSalesZone Combo Error: ", error);
			});

		}
	);

	OB.OBPOSPointOfSale.UI.customeraddr.edit_createcustomers_impl.extend({
		loadSalesZones: function () {
			var columns = [{ id: '0', name: '' }];

			OB.Dal.find(OB.Model.PosSalesZone, {}, function (data) {
				if (data && data.length > 0) {
					var tempArray = [];
					_.forEach(data.models, function (model) {
						var item = {
							id: model.get('id'),
							name: model.get('name'),
						};

						tempArray.push(item);
					});

					tempArray.sort(function (a, b) {
						return a.name.localeCompare(b.name);
					});

					_.forEach(tempArray, function (item) {
						columns.push(item);
					});
				}

				this.$.customerAddrAttributes.$.line_customerSalesZone.$.newAttribute.$.customerSalesZone.setCollection(new Backbone.Collection());
				this.$.customerAddrAttributes.$.line_customerSalesZone.$.newAttribute.$.customerSalesZone.getCollection().reset(columns);
			}.bind(this), function (error) {
				this.$.customerAddrAttributes.$.line_customerSalesZone.$.newAttribute.$.customerSalesZone.setCollection(new Backbone.Collection());
				this.$.customerAddrAttributes.$.line_customerSalesZone.$.newAttribute.$.customerSalesZone.getCollection().reset([]);
			}.bind(this));
		},

	});

	OB.OBPOSPointOfSale.UI.customers.edit_createcustomers_impl.extend({
		loadSalesZones: function () {
			var columns = [{ id: '0', name: '' }];

			OB.Dal.find(OB.Model.PosSalesZone, {}, function (data) {
				if (data && data.length > 0) {
					var tempArray = [];
					_.forEach(data.models, function (model) {
						var item = {
							id: model.get('id'),
							name: model.get('name'),
						};

						tempArray.push(item);
					});

					tempArray.sort(function (a, b) {
						return a.name.localeCompare(b.name);
					});

					_.forEach(tempArray, function (item) {
						columns.push(item);
					});
				}

				this.$.customerAttributes.$.line_customerSalesZone.$.newAttribute.$.customerSalesZone.setCollection(new Backbone.Collection());
				this.$.customerAttributes.$.line_customerSalesZone.$.newAttribute.$.customerSalesZone.getCollection().reset(columns);
			}.bind(this), function (error) {
				this.$.customerAttributes.$.line_customerSalesZone.$.newAttribute.$.customerSalesZone.setCollection(new Backbone.Collection());
				this.$.customerAttributes.$.line_customerSalesZone.$.newAttribute.$.customerSalesZone.getCollection().reset([]);
			}.bind(this));
		},

	});
})();
