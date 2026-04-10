//OB.ECSPB.Confirmation.showBalanceWindow
OB.ECSPB = OB.ECSPB || {};
var sccrt_popUp;

OB.ECSPB.Confirmation = {
  showBalanceWindow: function (params, view) {
    var selection = params.button.contextView.viewGrid.getSelectedRecord();
	var transaction = selection.documentNo;
	var transactionID = selection.id;
	
    sccrt_popUp = isc.ECSPB_Confirmation.create({
      parentWindow: view,
      selectedRecord: selection,
	  transaction: transaction,
	  transactionId: transactionID
    });
    sccrt_popUp.show();
  }
};


isc.defineClass('ECSPB_Confirmation', isc.OBPopup);
ECSPB_Confirmation.addProperties({
  title: 'CONFIRMACIONES',
  width: '50%',
  parentWindow: '',
  selectedRecord: '',
  importOrExportOptions: '',
  fileToImport: '',
  dataForm: null,
  processButton: null,
  cancelButton: null,
  toolBar: null,
  
  loadComboProducts: function(){
  	var view = this;
  	  OB.RemoteCallManager.call(
  	    'ec.com.sidesoft.product.balance.ad_actionbutton.LoadCombo',
  	    { transactionId: view.transactionId, typeTrx:'A' },
  	    {},
  	    function (response) {
  	      if (response && response.data && response.data.success) {
  	        const products = response.data.data.data || [];
  	        const valueMap = {};

  	        products.forEach(p => {
  	          valueMap[p.code] = p.code;
  	        });
  			
  			const valueMap2 = {};
  			products.forEach(p => {
  				valueMap2[p.name] = p.name;
  			});

  	        const productField = view.dataForm1.getItem('productCode');
  			const productNameField = view.dataForm1.getItem('productName');
  			
  	        productField.setValueMap(valueMap);
  			productNameField.setValueMap(valueMap2);
  	      }
  	    }
  	  );
  	
  },
  refresh:function(view, form, item, keyName){
		const total = view.dynamicGrid.getTotalRows();
		for (let i = total - 1; i >= 0; i--) {
		    const record = view.dynamicGrid.getRecord(i);
		    view.dynamicGrid.removeData(record);
		}
		view.totalForm.setValue("totalQuantity", 0);
		
		const formData = view.dataForm1.getValues();
		formData.transactionId = view.transactionId;
	      OB.RemoteCallManager.call(
	        'ec.com.sidesoft.product.balance.ad_actionbutton.LoadProductInfo',
	        formData,
	        {},
	        function (response) {
	          if (response && response.data && response.data.success) {
	            const data = response.data.data;
	
				view.productID = data.productID;
				view.lineID = data.lineID;
				view.uomMain = data.uomMain;
				view.dataForm1.setValue('barcode', data.barcode || '');
	            view.dataForm1.setValue('productCode', data.productCode || '');
	            view.dataForm1.setValue('line', data.lineNo || null);
	            view.dataForm1.setValue('quantity', data.quantity || 0);
				view.dataForm1.setValue('productName', data.productName || '');
	
	            // UOM Form
				const uomField = view.dataForm1.getItem('uom');
				const uomMainValueMap = {};
				if (data.uomID && data.uom) {
				  uomMainValueMap[data.uomID] = data.uom;
				}
				uomField.setValueMap(uomMainValueMap);
				view.dataForm1.setValue('uom', data.uomID || '');
	
				// Actualizar el grid
				const uoms = data.Uoms || [];
				const uomGridValueMap = uoms.reduce((acc, uom) => {
				  acc[uom.id] = uom.name;
				  return acc;
				}, {});
				
				if (data.uomID && data.uom && !(data.uomID in uomGridValueMap)) {
				  uomGridValueMap[data.uomID] = data.uom;
				}
	
				// Asignar al campo 'uom' del grid (si existe)
				const uomGridField = view.dynamicGrid.getField('uom');
				if (uomGridField) {
				  uomGridField.valueMap = uomGridValueMap;
				  view.dynamicGrid.refreshFields();
				}
				const uomGridFieldMain = view.dynamicGrid.getField('uomMain');
				if (uomGridFieldMain) {
				  uomGridFieldMain.valueMap = uomGridValueMap;
				  view.dynamicGrid.refreshFields();
				}
	
	            // Lotes
				const lots = data.lotes || [];
		        const valueMap = {};

		        lots.forEach(l => {
		          valueMap[l.id] = l.name;
		        });
				
				const lotField = view.dataForm1.getItem('lot');
				lotField.setValueMap(valueMap);
				view.dataForm1.setValue('lot', data.lotID || '');
				view.dataForm1.setValue('lots', lots);
						
	            const lotGridField = view.dynamicGrid.getField('lot');
	            lotGridField.valueMap = valueMap;
	            view.dynamicGrid.markForRedraw();
	          } else {
				view.productID = null;
				view.dataForm1.setValue('barcode', '');
	            view.dataForm1.setValue('productCode','');
	            view.dataForm1.setValue('line', '');
	            view.dataForm1.setValue('quantity', 0);
				view.dataForm1.setValue('productName', '');
				view.dataForm1.setValue('uom', '');
				view.dataForm1.setValue('lot', '');
				view.dataForm1.setValue('lots', []);
				const lotField = view.dataForm1.getItem('lot');
				var valueMap = {}; 
				lotField.setValueMap(valueMap);
								
	            isc.warn('Producto no encontrado o linea ya confirmada.');
	          }
	        }
	      );
	
  },
  transformQty: function (record, productID, callback) {
    OB.RemoteCallManager.call('ec.com.sidesoft.product.balance.ad_actionbutton.Transform', {
      productID: productID,
	  uomMain: record.uomMain,
	  uom: record.uom,
      quantity: record.operativeQty
    }, {}, function (response, data, request) {
      if (data && data.data.qty !== undefined) {
        callback({ quantity: data.data.qty });
      } else {
        callback({});
      }
    });
  },
  addTransformQty: function (productID,uomMain,uom,quantity, callback) {
      OB.RemoteCallManager.call('ec.com.sidesoft.product.balance.ad_actionbutton.Transform', {
        productID: productID,
		uomMain: uomMain,
		uom: uom,
		quantity: quantity
      }, {}, function (response, data, request) {
        if (data && data.data.qty !== undefined) {
          callback({ quantity: data.data.qty });
        } else {
          callback({});
        }
      });
    },
  getScale: function(callback){
	OB.RemoteCallManager.call('ec.com.sidesoft.product.balance.services.ApiBalance', {
		tableName: 'm_inout'
	    }, {}, function (response, data, request) {
	      if (data && data.data && data.data.result !== undefined) {
	        callback({ success: true, quantity: data.data.result });
	      } else {
			var message = "No se pudo capturar el peso. Verifique la conexión con la balanza."
	        callback({success: false, message: message});
	      }
	    });
  },
  updateTotalQuantity: function (view) {
    const data = view.dynamicGrid.getData();
    let total = 0;

    for (let i = 0; i < data.length; i++) {
      const qty = parseFloat(data[i].quantity);
      if (!isNaN(qty)) {
        total += qty;
      }
    }
	var totalFixed = total.toFixed(3);
    view.totalForm.setValue("totalQuantity", totalFixed);
	
	const values = view.dataForm1.getValues();
	if(totalFixed > values.quantity){
		isc.warn('Se ha alcanzado el límite de captura permitido para este producto.');
	}
	
  },


  initWidget: function () {
    var view = this;
    var fixedColWidth = 120;
    var labelBlackStyle = "color: black; font-weight: bold;";

    this.dataForm1 = isc.DynamicForm.create({
      ID: 'productFormLine1',
      width: '100%',
      numCols: 9,
      colWidths: Array(9).fill(fixedColWidth),
      cellPadding: 5,
      labelStyle: labelBlackStyle,
      fields: [
        { name: 'transaction', title: 'Transacción', type: 'text', colSpan: 2, defaultValue: view.transaction, canEdit: false },
        {
          name: 'barcode', title: 'Código de barras', type: 'text', colSpan: 2,
          keyPress: function (form, item, keyName) {
            if (keyName === "Enter") {
				view.refresh(view,form, item, keyName);
              return false;
            }
          }
        },
        { name: 'line', title: 'Línea', type: 'integer', colSpan: 2, keyPressFilter: "[0-9\\.]", canEdit: false },
        {
          name: 'productCode', title: 'Código', type: 'OBPickListItem', colSpan: 2, valueMap: {},
          keyPress: function (form, item, keyName) {
            if (keyName === "Enter") {
              view.refresh(view, form, item, keyName);
              return false;
            }
          }
        },
        {
          name: 'productName', title: 'Nombre Producto', type: 'OBPickListItem', colSpan: 2, valueMap: {},
          keyPress: function (form, item, keyName) {
            if (keyName === "Enter") {
              view.refresh(view,form, item, keyName);
              return false;
            }
          }
        },
        { name: 'uom', title: 'UND', type: 'OBPickListItem', colSpan: 2, valueMap: {}, canEdit: false },
        { name: 'quantity', title: 'Cantidad', type: 'float', colSpan: 2, keyPressFilter: "[0-9\\.]" },
        { name: 'lot', title: 'Lote', type: 'OBPickListItem', colSpan: 2, valueMap: {}, canEdit: true,
		keyPress: function (form, item, keyName) {
		            if (keyName === "Enter") {
						var dataValues = view.dataForm1.getValues();
						var lots = dataValues.lots || [];
					    var lot = dataValues.lot || ''; 
						var loteEncontrado = lots.find(l => l.id === lot);
						if(loteEncontrado){
							var quantityLot = loteEncontrado.qty || 0;
							var line = loteEncontrado.line || 0;
							view.dataForm1.setValue('quantity', quantityLot);
							view.dataForm1.setValue('line', line);
						}
		              return true;
		            }
		  }
		},
        {
          name: 'newLotButton',
          type: 'button',
          title: 'Nuevo Lote',
          icon: '[SKINIMG]actions/add.png',
          width: fixedColWidth,
          colSpan: 3,
          startRow: false,
          align: "center",
          click: function () {
            isc.warn('Nuevo lote.');
          },
		  showIf: function () {
			return false;
		  }
		
        }
      ]
    });

    
    this.centeredFormLayout = isc.VLayout.create({
      width: "100%",
      members: [this.dataForm1]
    });

	// CAPTURA PESO
	this.captureWeightButtonLayout = isc.HLayout.create({
	  width: "100%",
	  align: "left",
	  membersMargin: 10, // para separar los elementos
	  members: [
	    // Btn +
	    isc.IButton.create({
	      title: '+',
	      baseStyle: 'formButton',
	      width: 30,
	      click: function () {
	        const values = view.dataForm1.getValues();
	        if (!values.line || !values.uom || !view.productID) {
	          isc.warn('No se ha encontrado el producto referenciado en las lineas.');
	          return;
	        }
	        view.dynamicGrid.addData({
	          barcode: values.barcode,
	          productCode: values.productCode,
	          productName: values.productName,
	          operativeQty: 1,
	          uom: values.uom,
	          quantity: 1,
	          uomMain: values.uom,
	          lot: values.lot,
	          remove: 'BORRAR'
	        });
	        view.dynamicGrid.markForRedraw();
	        view.updateTotalQuantity(view);
	      }
	    }),

	    // Btn CAPTURA PESO
	    isc.IButton.create({
	      title: 'CAPTURA PESO',
	      width: 140,
	      baseStyle: 'formButton',
	      click: function () {
	        const values = view.dataForm1.getValues();
	        if (!values.line || !values.uom) {
	          isc.warn('No se ha encontrado el producto referenciado en las lineas.');
	          return;
	        }
	        view.getScale(function (scaleInfo) {
	          if (scaleInfo && scaleInfo.success && scaleInfo.quantity !== undefined && view.productID) {
	            var productID = view.productID;
	            var uomMain = values.uom;
	            var uom = values.uom;
	            var quantity = scaleInfo.quantity;
	            view.addTransformQty(productID, uomMain, uom, quantity, function (updatedInfo) {
	              if (updatedInfo && updatedInfo.quantity !== undefined) {
	                view.dynamicGrid.addData({
	                  barcode: values.barcode,
	                  productCode: values.productCode,
	                  productName: values.productName,
	                  operativeQty: scaleInfo.quantity,
	                  uom: values.uom,
	                  quantity: updatedInfo.quantity,
	                  uomMain: values.uom,
	                  lot: values.lot,
	                  remove: 'BORRAR'
	                });
	                view.dynamicGrid.markForRedraw();
	                view.updateTotalQuantity(view);
	              }
	            });
	          }else{
				isc.warn(scaleInfo.message);
			  }
	        });
	      }
	    })
	  ]
	});

    this.dynamicGrid = isc.ListGrid.create({
      ID: 'dynamicProductGrid',
      width: '100%',
      height: 250,
      autoDraw: false,
      canEdit: true,
      editByCell: true,
      showAllRecords: true,
      fields: [
        { name: 'barcode', title: 'Código de barras', width: 100, headerAlign: 'center', cellAlign: 'center', canEdit: false, },
        { name: 'productCode', title: 'Código', width: 100, headerAlign: 'center', cellAlign: 'center', canEdit: false, },
        { name: 'productName', title: 'Nombre Producto', width: 150, headerAlign: 'center', cellAlign: 'center', canEdit: false, },
		{
          name: 'operativeQty',
          title: 'Cantidad Operativa',
          type: 'float',
		  headerAlign: 'center',
		  cellAlign: 'center',
          width: 145,
          editorProperties: {
            editorType: "FloatItem",
            keyPressFilter: "[0-9\\.]",
            validateOnChange: true,
            validators: [{
              type: "floatRange",
              min: 0
            }]
          }
        },
        { name: 'uom', title: 'UND', width: 100, valueMap: {}, headerAlign: 'center', cellAlign: 'center' },
        {
          name: 'quantity',
          title: 'Cantidad',
          type: 'float',
          width: 80,
		  headerAlign: 'center', cellAlign: 'center',
		  canEdit: false,
          editorProperties: {
            editorType: "FloatItem",
            keyPressFilter: "[0-9\\.]",
            validateOnChange: true,
            validators: [{
              type: "floatRange",
              min: 0
            }]
          }
        },
		{ name: 'uomMain', title: 'UND Principal', width: 100, canEdit: false, valueMap: {}, headerAlign: 'center', cellAlign: 'center' },
        { name: 'lot', title: 'Lote', width: 100, canEdit: false, valueMap: {}, headerAlign: 'center', cellAlign: 'center' },
        {
          name: 'remove',
          title: ' ',
          width: 100,
          type: 'button',
          canSort: false,
          canEdit: false,
          canFilter: false,
          cellAlign: 'center',
          formatCellValue: function () {
            return '<button style="background-color: green; color: white; border: none; border-radius: 4px; padding: 5px 10px; font-weight: bold; cursor: pointer; width: 100%;">BORRAR</button>';
          }
        }
      ],
      recordClick: function (viewer, record, rowNum, colNum) {
        if (this.getField(colNum).name === 'remove') {
			  this.removeData(record, function () {
			    view.updateTotalQuantity(view);
			  });
			  this.markForRedraw();
        }
      },
	  cellChanged: function (record, newUomValue, oldUomValue, rowIndex, colIndex) {
	      const fieldName = this.getFieldName(colIndex);
	      if (fieldName === 'uom' || fieldName === 'operativeQty') {
	          const productID = view.productID;
	          
	          view.transformQty(record, productID, function (updatedInfo) {
	              if (updatedInfo && updatedInfo.quantity !== undefined) {
	                  record.quantity = updatedInfo.quantity;
	                  view.dynamicGrid.refreshRow(rowIndex);
	              }
				  view.updateTotalQuantity(view);
	          });
	      }
	  }
    });
	
	this.totalForm = isc.DynamicForm.create({
	  width: "100%",
	  numCols: 1,
	  fields: [
	    {
	      name: "totalQuantity",
	      type: "float",
	      title: "Total",
	      canEdit: false,
	      textAlign: "right",
	      defaultValue: 0
	    }
	  ],
	  styleName: "total-form",
	  titleAlign: "right",
	  align: "right"
	});


	this.gridSection = isc.VLayout.create({
	    width: "100%",
	    membersMargin: 2, // Separacion
	    members: [
	        this.captureWeightButtonLayout,
	        this.dynamicGrid,
	        this.totalForm
	    ]
	});

    this.processButton = isc.IButton.create({
      title:'CONFIRMAR',
	  width: 120,
      baseStyle: 'formButton', //formButton', OBFormButton
      click: function () {
        const formData = view.dataForm1.getValues();
		const data = view.dynamicGrid.getData();
		const lineID = view.lineID;
		const productID = view.productID;
        OB.RemoteCallManager.call('ec.com.sidesoft.product.balance.ad_process.BalanceOfProducts',{
			formData: formData,
			data: data,
			lineID: lineID,
			productID: productID
		  },{},
          function (response) {
            if (response && response.data && response.data.success) {
              isc.say('Confirmación realizada correctamente');
              view.closeClick();
            } else {
				var message = 'Hubo un error al confirmar';
				if (response && response.data && response.data.message) {
					message = response.data.message;
				}
				isc.warn(message);
            }
          }
        );
      }
    });

    this.cancelButton = isc.IButton.create({
      title:'CANCELAR',
	  width: 120,
      baseStyle: 'formButton',
      click: function () {
        view.closeClick();
      }
    });

    this.footerButtons = isc.HLayout.create({
      width: '100%',
      align: 'center',
      membersMargin: 20,
      members: [this.processButton, this.cancelButton]
    });

    this.mainLayout = isc.VLayout.create({
      membersMargin: 10,
      padding: 10,
      width: '100%',
      overflow: "visible", //auto",
      members: [
		this.centeredFormLayout,
		this.gridSection,
		this.footerButtons
      ]
    });

    this.items = [this.mainLayout];
    this.Super("initWidget", arguments);

	
	this.show = function () {
	  this.Super("show", arguments);
	  this.loadComboProducts();
	};

	
  }



  
  
});
