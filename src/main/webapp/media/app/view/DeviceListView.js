Ext.define('Pandora.view.DeviceListView', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.deviceList',
    id : 'deviceListPanel',
    
    store: 'DeviceStore',
    hideHeaders: false,
    
    initComponent: function() {
        this.columns = [
            {text:'ID', dataIndex :'id'},
            {text:'编号', dataIndex :'deviceId'},
            {text:'类型', dataIndex :'deviceType'},
            {text:'序列号', dataIndex :'deviceSn'},
            {text:'名称', dataIndex :'deviceName'},
            {text:'父节点编号', dataIndex :'parentNodeId'}
        ];
        //this.columns = [
        //    { text: '类型',  dataIndex: 'type' },
        //    { text: '设备编号',  dataIndex: 'devId' },
        //    { text: '自编号',  dataIndex: 'nickName' },
        //    { text: '时间', dataIndex: 'gpsTime' },
        //    { text: '经度', dataIndex: 'longitude' },
        //    { text: '纬度', dataIndex: 'latitude' },
        //    { text: '速度', dataIndex: 'speed' },
        //    { text: '角度', dataIndex: 'angel' },
        //    { text: '位置', dataIndex: 'location' },
        //    { text: '重量', dataIndex: 'weight' },
        //    { text: '报警信息', dataIndex: 'alarmData' },
        //    { text: '生产厂家',  dataIndex: 'product' },
        //    { text: '型号',  dataIndex: 'model' },
        //    { text: '创建时间',  dataIndex: 'creationDate' },
        //    { text: 'sim卡号',  dataIndex: 'simCardNum' },
        //    { text: '使用时间',  dataIndex: 'dateCost' },
        //    { text: '上次维修时间',  dataIndex: 'lastModifiedDate' },
        //    { text: '报警值', dataIndex: 'threshold'},
        //    { text: '最大称重', dataIndex: 'keyValue'}
        //];
        this.listeners =  {
            itemdblclick: function (me, record, item, index, e, eOpts) {
                var _window=new Ext.Window({
                    title:record.get("id"),
                    width:500,
                    height:350,
                    isModel:true,
                    plain:true,
                    layout:{
                        type:'vbox'
                    },
                    items:[{
                        xtype:'panel',
                        width: 500,
                        height:60,
                        layout:{
                            type:'hbox'
                        },
                        items:[{
                                xtype: 'textfield',
                                id:'cmdTxt',
                                name: 'cmd',
                                fieldLabel: '输入命令',
                                allowBlank: true,  // 表单项非空
                                style:'marginTop:15px;marginLeft:-15px;text-align:right;color:red'
                            },
                            {
                                xtype:'button',
                                text: '下行透传',
                                height:'26px',
                                width:'100px',
                                style:'marginTop:15px;marginLeft:15px',
                                handler: function() {
                                    var edit = Ext.getCmp("cmdTxt");
                                    alert(edit.getValue());
                                    Ext.Ajax.request({
                                        url: '/sendCmd?Cmd='+'01f1'+'&devId='+record.get("devId")+"&message="+edit.getValue(),
                                        success: function(resp,opts) {
                                            var respText = Ext.JSON.decode(resp.responseText).message;
                                            var txtArea = Ext.getCmp('resultContent');
                                            txtArea.setValue(respText);

                                        },
                                        failure: function(resp,opts) {
                                            var respText = Ext.util.JSON.decode(resp.responseText);
                                            Ext.Msg.alert('错误', respText.error);
                                        }
                                    });
                                }
                            }]
                    },{
                        xtype     : 'textareafield',
                        id : 'resultContent',
                        grow      : true,
                        name      : 'message',
                        fieldLabel: '消息结果',
                        width: 400,
                        height : 200,
                        style:'marginTop:15px;marginLeft:-15px;marginRight:10px;text-align:right;color:red'
                    }],
                    buttons:[
                        //{
                        //    text:"OK",
                        //    handler:function(){
                        //        this.close();
                        //    }
                        //},
                        //{text:"Cancel"}
                    ]
                });
                _window.show();
            },
            itemclick : function(me,record,item,index,e,eOption){
                mapObject.centerPoint(record);
            }
        }
        this.callParent();
    }
});