var deviceIds = "";

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
            setChildChecked(node,state);
            setParentChecked(node,state);

            var groups = this.getChecked();
            deviceIds = "";
            groups.forEach(function(group){
                if(group.get('id') != '0'){
                    if(getNodeType(group.get('id')) == "node_device"){
                        var nodeId = getNodeId(group.get('id'));
                        deviceIds += nodeId + "," ;
                    }
                }
            });
            var devStore = Ext.getCmp('deviceListPanel').store;
            devStore.load({
                callback : function(r,options,success){
                    mapObject.removeAllMarker();
                    r.forEach(function(record){
                        if(mapObject == null){
                            Ext.Msg.alert('警告', '地图加载失败.');
                        }else {
                            mapObject.updateMarkerArray(record);
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