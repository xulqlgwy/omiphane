Ext.define('Pandora.store.DeviceStore', {
    extend: 'Ext.data.Store',
    requires: 'Pandora.model.DeviceModel',
    model: 'Pandora.model.DeviceModel',
    proxy: {
        type: 'ajax',
        url: '/get/deviceList',

        reader: {
            type: 'json',
            root: 'devices'
        }
    },
    listeners: {
        'beforeload': function (store, op, options) {
            var params = {'extraParam':globalInfo.deviceIds};
            Ext.apply(store.proxy.extraParams, params);
        },
        'callback' : function(r,options,success){
            if(success) {
                alert(r.getCount());
            }
        }
    },

    autoLoad: true
});