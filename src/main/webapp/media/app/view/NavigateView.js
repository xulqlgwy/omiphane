Ext.define('Pandora.view.NavigateView',{
    extend : 'Ext.panel.Panel',
    alias : 'widget.navigate',
    width : '100%',
    bodyStyle: 'background:#232D38; padding:10px;',
    layout : {
        type : 'hbox',
        align: 'bottom'
    },
    items:[{
        xtype: 'box', //或者xtype: 'component',
        width: 200, //图片宽度
        height: 50, //图片高度
        autoEl: {
            tag: 'img',    //指定为img标签
            src: basePath + '/media/image/my_image/logo.png'    //指定url路径
        }
    },{
        xtype: 'button',
        text: '实时监控',
        scale : 'large',
        width : '300' ,
        icon : basePath + '/media/image/my_image/main.png',
        style: {
            marginLeft:'30px',
            marginRight:'12px'
        },
        handler:function(){
            var mainPanel = Ext.getCmp('mainView');
            var reportPanel = Ext.getCmp('reportView');
            mainPanel.show();
            reportPanel.hide();
        }
    },{
        xtype: 'button',
        text: '报表统计',
        scale : 'large',
        width : '300' ,
        icon : basePath + '/media/image/my_image/report.png',
        style: {
            marginRight:'12px'
        },
        handler:function(){
            var mainPanel = Ext.getCmp('mainView');
            var reportPanel = Ext.getCmp('reportView');
            mainPanel.hide();
            reportPanel.show();
        }
    },{
        xtype: 'button',
        text: '工控机数据',
        scale : 'large',
        width : '300' ,
        icon : basePath + '/media/image/my_image/ipc.png',
        style: {
            marginRight:'12px'
        }
    },{
        xtype: 'button',
        text: '系统设置',
        scale : 'large',
        width : '300' ,
        icon : basePath + '/media/image/my_image/setting.png',
        style: {
            marginRight:'12px'
        }
    }]
})