/*global OB */

(function () {
  OB.Model.OrderFilter.prototype.source = 'ec.com.sidesoft.pos.custom.sanfelipe.model.SFWPCUSPaidReceiptsFilter';

  OB.Model.OrderFilter.addProperties([
    {
      name: 'dispatcher',
      column: 'dispatcher',
      filter: false,
      type: 'TEXT',
    },
    {
      name: 'deliveryStatus',
      column: 'deliveryStatus',
      filter: false,
      type: 'TEXT',
    },
    {
      name: 'invoiceStatus',
      column: 'invoiceStatus',
      filter: false,
      type: 'TEXT',
    },
  ]);
})();
