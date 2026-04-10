/*global OB */

(function () {
    OB.Model.BusinessPartner.addProperties([
      {
        name: 'taxIdType',
        column: 'taxIdType',
        filter: false,
        type: 'TEXT',
      },
      {
        name: 'invoiceLimitAmount',
        column: 'invoiceLimitAmount',
        filter: false,
        type: 'NUMERIC',
      }
    ]);
  })();