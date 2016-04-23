Ext.define('Pandora.store.BusTreeStore', {
    extend: 'Ext.data.TreeStore',
    requires: 'Pandora.model.DeviceTreeModel',
    model: 'Pandora.model.DeviceTreeModel',

    autoLoad: true,
    clearOnLoad : true,

    proxy: {
        type: 'ajax',
        url: '/get/busTree',
        reader: {
            type: 'json',
            root: 'busTree'
        }
    },
    root: {
        id: 0,
        expanded: true,
        text: 'My Root'
    }
});