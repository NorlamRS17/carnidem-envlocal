OB.SSPRJ = OB.SSPRJ || { Movement: {} };

OB.SSPRJ.Movement.locatorIdOnChangeFunction = function (item, view, form, grid) {
    var lines = form.getItem('window').canvas.viewGrid, newCriteria;

    if (item.getValue() === item.oldSelectedValue) {
        // only fetch new data if the selected value has changed.
        return;
    }
    item.oldSelectedValue = item.getValue();
    newCriteria = lines.addSelectedIDsToCriteria(lines.getCriteria(), true);
    newCriteria.criteria = newCriteria.criteria || [];
    // add dummy criterion to force fetch
    newCriteria.criteria.push(isc.OBRestDataSource.getDummyCriterion());
    lines.invalidateCache();
    form.redraw();
}