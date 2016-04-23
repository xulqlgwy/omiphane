Ext.define('Pandora.view.ReportView',{
    extend:'Ext.panel.Panel',
    alias:'widget.reportView',
    id:'reportView',
    hidden : true,
    layout: {
        type : 'hbox',
        align : 'stretch'
    },
    requires: [
        'Pandora.view.ReportNav',
        'Pandora.view.ReportDetail'
    ],
    items: [
        {
            xtype: 'reportNav',
            title: '报表类型',
            width : 300
        },{
            xtype: 'reportDetail',
            title: '报表详情',
            flex: 1
        }],
    renderTo: Ext.getBody()
});