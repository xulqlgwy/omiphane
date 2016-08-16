Ext.define('Pandora.controller.DeviceController', {
    extend: 'Ext.app.Controller',
    refs: [{
        ref: 'deviceList',
        selector: 'deviceList'
    }],

    stores: ['DeviceStore'],

    init : function () {

        this.callParent();
    }
})