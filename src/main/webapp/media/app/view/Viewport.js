Ext.define('Pandora.view.Viewport', {
    extend: 'Ext.container.Viewport',
    layout: {
        type : 'vbox',
        align : 'center'
    },
    
    requires: [
        'Pandora.view.MainView',
        'Pandora.view.NavigateView',
        'Pandora.view.ReportView'
    ],
    
    initComponent: function() {
        this.items = [
            {
                xtype: 'navigate',
                height : 65 ,
                width : '100%'
            },
            {
                xtype: 'mainView',
                width : '100%',
                //height : 300
                flex: 1
            },
            {
                xtype:'reportView',
                width : '100%',
                flex : 1
            },
            {
                xtype: 'panel',
                title: 'Inner Panel Three',
                width : '100%',
                height: 30
            }
        ];

        this.callParent();
    }
});