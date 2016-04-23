Ext.define('Pandora.view.ReportPanel',{
    extend:'Ext.panel.Panel',
    alias:'widget.reportPanel',
    id:'reportPanel',
    animate: true,
    shadow: true,

    layout: {
        type : 'fit'
    },

    requires: [
        'Pandora.view.ReportChart'
    ],

    items:[{
        xtype:'reportChart',
        defaultMargins:'10px,10px,10px,10px'
    }],

    renderTo: Ext.getBody()
});