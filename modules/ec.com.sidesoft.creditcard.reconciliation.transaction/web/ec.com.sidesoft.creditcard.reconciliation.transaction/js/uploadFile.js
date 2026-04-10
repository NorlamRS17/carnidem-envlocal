OB.SCCRT = OB.SCCRT || {};

var sccrt_popUp;

OB.SCCRT.UploadFile = {
  showUploadWindow: function (params, view) {
    var selection = params.button.contextView.viewGrid.getSelectedRecord();
    sccrt_popUp = isc.SCCRT_UploadFileView.create({
      parentWindow: view,
      selectedRecord: selection
    });
    sccrt_popUp.show();
  }
};

OB.SCCRT.closePopUp = function (success, fileName) {
  var messageBar = sccrt_popUp.parentWindow.view.messageBar;
  sccrt_popUp.loading.hide();
  sccrt_popUp.closeClick();
  if (success) {
   // messageBar.setMessage(isc.OBMessageBar.TYPE_SUCCESS, OB.I18N.getLabel('OBUIAPP_Success'), `File Uploaded: ${fileName}`);
	messageBar.setMessage(isc.OBMessageBar.TYPE_SUCCESS, OB.I18N.getLabel('OBUIAPP_Success'), 'Carga completada Exitosamente.');
  } else {
    messageBar.setMessage(isc.OBMessageBar.TYPE_ERROR, OB.I18N.getLabel('OBUIAPP_Error'), `Carga completada.  ${fileName}`);
  }
  sccrt_popUp.parentWindow.refresh();
};

isc.defineClass('SCCRT_UploadFileView', isc.OBPopup);

SCCRT_UploadFileView.addProperties({
  title: 'Upload File',
  width: '40%',
  height: '*',
  parentWindow: '',
  selectedRecord: '',
  importOrExportOptions: '',
  fileToImport: '',
  dataForm: null,
  processButton: null,
  cancelButton: null,
  toolBar: null,
  initWidget: function () {
    var view = this;

    // Create form
    this.dataForm = isc.OBViewForm.create({
      ID: 'optionsForm',
      width: '70%',
      height: '50%',
      titleOrientation: 'left',
      numCols: 1,
      fields: [{
        title: 'File to Import',
        name: 'inpFile',
        id: 'fileToImport',
        type: 'upload',
        width: '*',
        titleClassName: 'OBFormFieldLabel',
        cellClassName: 'OBFormField',
        multiple: false,
        canFocus: false
      }],
      encoding: 'multipart',
      target: 'background_target',
      action: 'ec.com.sidesoft.creditcard.reconciliation.transaction.ad_actionbutton/UploadFileProcess.html',
      redraw: function () { }
    });

    // Create process button
    this.processButton = isc.OBFormButton.create({
      title: 'Process',
      showFocused: true,
      align: 'center',
      showFocusedAsOver: true,
      click: function () {
        view.dataForm.submitForm();
        view.loading.show();
      }
    });

    // Create cancel button
    this.cancelButton = isc.OBFormButton.create({
      title: 'Cancel',
      showFocused: true,
      showFocusedAsOver: true,
      click: function () {
        view.closeClick();
        view.parentWindow.refresh();
      }
    });

    this.firstFocusedItem = this.processButton;

    // Create button layout
    this.buttonLayout = isc.HLayout.create({
      ID: "SCCRT_importOrExportActionButtonsLayout",
      align: 'center',
      width: '*',
      height: '*',
      overflow: 'visible',
      height: OB.Styles.Process.PickAndExecute.buttonLayoutHeight,
      members: [isc.HLayout.create({
        width: 1,
        overflow: 'visible',
        styleName: this.buttonBarStyleName,
        height: this.buttonBarHeight,
        defaultLayoutAlign: 'center',
        members: [this.processButton, isc.LayoutSpacer.create({
          width: 32
        }), this.cancelButton]
      })]
    });

    this.loading = OB.Utilities.createLoadingLayout(OB.I18N.getLabel('OBUIAPP_PROCESSING'));
    this.loading.hide();

    // Vertical layout
    this.mainLayout = isc.VLayout.create({
      ID: "SCCRT_vLayoutLayoutSpacers",
      autoDraw: false,
      height: "50%",
      width: "100%",
      layoutMargin: 0,
      defaultLayoutAlign: "center",
      members: [this.dataForm, this.loading, this.buttonLayout]
    });

    this.items = [this.mainLayout];
    this.Super("initWidget", arguments);
  }
});
