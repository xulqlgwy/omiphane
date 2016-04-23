Ext.define('Pandora.store.TypeComboStore', {
    extend: 'Ext.data.Store',
    requires: 'Pandora.model.DeviceModel',
    model: 'Pandora.model.DeviceModel',

    autoLoad: true,
    clearOnLoad : true,

    proxy: {
        type: 'ajax',
        url: '/get/tankType',
        reader: {
            type: 'json',
            root: 'devices'
        }
    },
    listeners:{
        'beforeload':function(store,op, options){
            var params = {'extraParam':comboCompanyId};
            Ext.apply(store.proxy.extraParams, params);
        }
    }
});