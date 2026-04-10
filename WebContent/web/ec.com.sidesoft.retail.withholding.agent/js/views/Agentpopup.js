enyo.kind({
    kind: 'OB.UI.ModalAction',
    name: 'OB.UI.WarningAgent',
    i18nHeader: 'OBMOBC_Error',
    bodyContent: {
      //content: OB.I18N.getLabel('ECSDS_ErrorSequence')
    },
    bodyButtons: {
      components: [{
        kind: 'OBPOS_LblApplyButton'
      }]
    },
    initComponents: function () {
      this.bodyContent.content = 'EL CLIENTE SELECCIONADO ES AGENTE DE RETENCIÓN';//OB.I18N.getLabel('ECSDS_ErrorSequence');
      this.inherited(arguments);
    }
  });

OB.UI.WindowView.registerPopup('OB.OBPOSPointOfSale.UI.PointOfSale', {
    kind: 'OB.UI.WarningAgent',
    name: 'OB.UI.WarningAgent'
});