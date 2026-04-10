(function () {
  /*global OB */

  OB.Model.BPLocation.addIndex([
    {
      name: 'bploc_bp_idx',
      columns: [
        {
          name: 'c_bpartner_id',
        },
      ],
    },
  ]);
})();
