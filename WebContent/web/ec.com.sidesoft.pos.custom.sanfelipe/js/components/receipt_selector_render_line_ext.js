/*global OB */

(function () {
  OB.UI.ReceiptSelectorRenderLine.prototype.kindComponents
    .find((c) => c.name === 'line')
    .components.at(0)
    .components.push({
      style: 'padding-top: 3px',
      components: [
        {
          style: 'float: left; width: 90px;',
          name: 'delivered',
        },
        {
          style: 'float: left; padding-left:15px;',
          name: 'distpatcher',
        },
        {
          style:
            'float: right; padding-right:5px; width: 90px; text-align: right;',
          name: 'invoiced',
        },
        {
          style: 'clear: both;',
        },
      ],
    });
})();
