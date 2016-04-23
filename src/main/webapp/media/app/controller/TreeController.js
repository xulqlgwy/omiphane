Ext.define('Pandora.controller.TreeController', {
    extend: 'Ext.app.Controller',
    refs: [{
        ref: 'DeviceTree',
        selector: 'DeviceTree'
    }],

    stores: ['DeviceTreeStore'],

    init : function () {
        this.callParent();
    }
});