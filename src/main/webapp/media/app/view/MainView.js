Ext.define('Pandora.view.MainView',{
    extend:'Ext.panel.Panel',
    alias:'widget.mainView',
    id:'mainView',
    width: '100%',
    height:'100%',
    layout: 'border',
    hidden : false,
    requires: [
        'Pandora.view.DeviceListView',
        'Pandora.view.MapView',
        'Pandora.view.TankTreeView',
        'Pandora.view.BusTreeView'
    ],
    items: [{
            // xtype: 'panel' implied by default
            region:'west',
            title:'设备列表',
            xtype: 'DeviceTree',
            margins: '5 0 0 5',
            width: 300,
            collapsible: true,   // make collapsible
            id: 'west-region-container',
            split:true,
            layout: 'fit'
        },{
            title: '设备实时信息',
            region: 'south',     // position for region
            xtype: 'deviceList',//
            height: 200,
            split: true,         // enable resizing
            margins: '0 5 5 5'
        },{
            title: 'Center Region',
            region: 'center',     // center region is required, no width/height specified
            margins: '5 5 0 0',
            xtype:  'container',
            layout: 'fit',
            items: [{
                xtype: 'map',
                flex: 1
            }]
        }],
    renderTo: Ext.getBody()
});