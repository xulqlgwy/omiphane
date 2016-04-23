Ext.define('Pandora.view.ReportDetail',{
    extend:'Ext.panel.Panel',
    alias:'widget.reportDetail',
    id:'reportDetail',
    layout: {
        type : 'vbox',
        align : 'stretch'
    },
    requires: [
        'Pandora.form.FormQueryPanel',
        'Pandora.view.DevReportDataList',
        'Pandora.view.ReportPanel'

    ],
    items: [
        {
            xtype: 'queryForm',
            height : 70
        }, {
            layout:{
                type:'border'
            },
            flex: 1,
            items:[{
                title: '图表',
                region: 'center',     // center region is required, no width/height specified
                xtype: 'reportPanel',
                layout: 'fit',
                flex:1
            },{
                // xtype: 'panel' implied by default
                title: '详细',
                region:'south',
                xtype: 'devReportDataList',
                collapsible: true,   // make collapsible
                layout: 'fit',
                split: true,
                flex:1
            }]
        }],
    renderTo: Ext.getBody()
});