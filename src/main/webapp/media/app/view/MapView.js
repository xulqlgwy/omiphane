Ext.define('Pandora.view.MapView',{
    extend : 'Ext.panel.Panel',
    alias : 'widget.map',
    layout : 'fit',

    initComponent: function () {
        Ext.apply(this,{
            html:'加载地图panel'

        });
        this.callParent();
    }
})
