Ext.define('Pandora.store.DevReportStore', {
    extend: 'Ext.data.Store',
    requires: 'Pandora.model.DeviceRealDataModel',
    model: 'Pandora.model.DeviceRealDataModel',

    listeners: {

    },

    autoLoad: false
});