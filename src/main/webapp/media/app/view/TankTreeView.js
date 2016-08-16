Ext.define('Pandora.view.TankTreeView',{
    extend:'Ext.tree.Panel',
    id:'nodeTree',
    alias:'widget.DeviceTree',
    store:'DeviceTreeStore',
    rootVisible : false,
    animate: true,
    border: false,

    listeners : {
        beforeitemexpand:function(record,eOpts){
            var root = this.getStore().getProxy();
            root.extraParams.root = record.data.id;
        },
        itemclick: function(view,record,item,index,e,eOpts) {
            //var str = record.data.memo;

        },
        'checkchange': function(node, state) {
            globalInfo.setChildChecked(node,state);
            globalInfo.setParentChecked(node,state);

            var groups = this.getChecked();

            //清空历史id
            globalInfo.deviceIds = "";
            groups.forEach(function(group){
                var nodeId = group.get('id');
                if( nodeId != '0' && nodeId != undefined && nodeId != null && nodeId != ""){
                    globalInfo.deviceIds += nodeId + "," ;
                }
            });
            //changePanel();
            var devStore = Ext.getCmp('deviceListPanel').store;
            devStore.load({
                callback : function(r,options,success){
                    globalInfo.mapObject.removeAllMarker();
                    r.forEach(function(record){
                        if(globalInfo.mapObject == null){
                            Ext.Msg.alert('警告', '地图加载失败.');
                        }else {
                            globalInfo.mapObject.updateMarkerArray(record);
                        }
                    })
                }
            });
        }
    },


    initComponent:function(){
        this.callParent();
    }
});

function changePanel(){
    var  col = [
        { text: '类型',  dataIndex: 'type' },
        { text: '设备编号',  dataIndex: 'devId' },
        { text: '自编号',  dataIndex: 'nickName' },
        { text: '时间', dataIndex: 'gpsTime' },
        { text: '经度', dataIndex: 'longitude' },
        { text: '纬度', dataIndex: 'latitude' },
        { text: '速度', dataIndex: 'speed' },
        { text: '角度', dataIndex: 'angel' },
        { text: '位置', dataIndex: 'location' }
        ];

    var grid = Ext.getCmp('deviceListPanel');
    grid.reconfigure(grid.store,col);

}
