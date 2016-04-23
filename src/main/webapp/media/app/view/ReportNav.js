Ext.define('Pandora.view.ReportNav',{
    extend: 'Ext.panel.Panel',
    alias:'widget.reportNav',
    defaults: {
        // applied to each contained panel
        bodyStyle: 'padding:5px'
    },
    layout: {
        // layout-specific configs go here
        type: 'accordion',
        titleCollapse: false,
        animate: true,
        activeOnTop: false
    },
    items: [{
        title: '加料报表',
        items:[{
            xtype: 'button',
            text: '自定加料报表',
            width:280,
            scale : 'large',
            textAlign :'left',
            icon : basePath + '/media/image/my_image/main.png',
            style: {
                marginLeft:'5px',
                marginRight:'5px'
            }
        },{
            xtype: 'button',
            text: '日加料报表',
            width:280,
            scale : 'large',
            textAlign :'left',
            icon : basePath + '/media/image/my_image/main.png',
            style: {
                marginLeft:'5px',
                marginRight:'5px',
                marginTop:'2px'
            }
        },{
            xtype: 'button',
            text: '月加料报表',
            width:280,
            scale : 'large',
            textAlign :'left',
            icon : basePath + '/media/image/my_image/main.png',
            style: {
                marginLeft:'5px',
                marginRight:'5px',
                marginTop: '2px'
            }
        }]
    },{
        title: 'Panel 2',
        html: 'Panel content!',
        listeners:{
            click: function () {
                alert(1);
            }
        }
    },{
        title: 'Panel 3',
        html: 'Panel content!'
    }],
    renderTo: Ext.getBody()
});