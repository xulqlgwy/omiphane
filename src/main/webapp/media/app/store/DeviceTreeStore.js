Ext.define('Pandora.store.DeviceTreeStore', {
    extend: 'Ext.data.TreeStore',
    requires: 'Pandora.model.DeviceTreeModel',
    model: 'Pandora.model.DeviceTreeModel',

    autoLoad: true,
    clearOnLoad : true,
    rootVisible : false,


    proxy: {
        type: 'ajax',
        url: '/get/deviceTree',
        actionMethods: 'post',
        reader: {
            type: 'json',
            root: 'deviceTree'
        },
        extraParams:{
            root:''
        }
    },
    root: {
        id: 0,
        expanded: false,
        text: '欧米凡科技'
    },
    sorters: [{
        property: 'text',
        direction: 'ASC'
    }]
});