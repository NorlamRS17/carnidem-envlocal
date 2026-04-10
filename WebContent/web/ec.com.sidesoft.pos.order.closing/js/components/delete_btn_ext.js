/*global OB */

(function () {
  OB.UI.ButtonDelete.extend({
    tap: function () {
      const close = () => {
        var me = this,
          isMultiOrders = this.model.isValidMultiOrderState();
        this.disableButton();
        if (isMultiOrders) {
          this.doRemoveMultiOrders();
          return true;
        }
        if (this.model.get('order').checkOrderPayment()) {
          this.updateDisabled(false);
          return false;
        }
        if (this.hasClass('paidticket')) {
          this.doDeleteOrder();
        } else {
          if (
            OB.MobileApp.model.hasPermission(
              'OBPOS_approval.removereceipts',
              true
            )
          ) {
            this.doShowPopup({
              popup: 'modalConfirmReceiptDelete',
            });
          } else {
            OB.UTIL.Approval.requestApproval(
              this.model,
              'OBPOS_approval.removereceipts',
              function (approved) {
                if (approved) {
                  me.doDeleteOrder({
                    notSavedOrder: true,
                  });
                }
              }
            );
          }
        }
      };
      OB.UTIL.showConfirmation.display(
        OB.I18N.getLabel('SSFOC_CloseReceiptTitle'),
        OB.I18N.getLabel('SSFOC_CloseReceiptBody', [
          this.model.get('order').get('documentNo'),
        ]),
        [
          {
            label: OB.I18N.getLabel('OBMOBC_LblYes'),
            isConfirmButton: true,
            action: function () {
              OB.MobileApp.view.$.containerWindow.getRoot().doShowPopup({
                popup: 'OB_UI_ModalReceiptCloseReason',
                args: {
                  callbackFn: close,
                },
              });
            },
          },
          {
            label: OB.I18N.getLabel('OBMOBC_LblNo'),
            isConfirmButton: true,
            action: function () {
              close();
            },
          },
        ]
      );
    },
  });
})();
