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
            var str = record.data.memo;
            //alert(str);
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