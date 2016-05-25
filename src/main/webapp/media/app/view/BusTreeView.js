var busIds = "";
var selDevIds = "";

var task = { //Ext的定时器，每隔2秒刷新store。
    run : function() {
        selDevIds = "";
        var devStore = Ext.getCmp('deviceListPanel').store;
        for(var i =0;i<devStore.getCount();i++){
            var o = devStore.getAt(i);
            var id = o.get('devId'); //遍历每一行
            selDevIds += id + ",";
        }

        Ext.Ajax.request({
            url: '/get/realData',
            method: 'post',
            params: { "selids": selDevIds  },
            success: function (response, options) {
                var deviceData = Ext.JSON.decode(response.responseText).realDataList;
                devStore.loadData(deviceData,false);
                for(var i = 0; i < devStore.getCount() ; i++){
                    mapObject.updateMarkerArray(devStore.getAt(i));
                }


                //for (var i = 0 ; i< deviceData.length ; i++){
                //    mapObject.updateMarkerArray(deviceData[i]);
                //}

                //alert(deviceData.length);
            },
            failure: function () {
                console.log('系统出错，请联系管理人员！');
            }
        });

        //devStore.load({
        //    callback : function(r,options,success){
        //        mapObject.removeAllMarker();
        //        r.forEach(function(record){
        //            if(mapObject == null){
        //                Ext.Msg.alert('警告', '地图加载失败.');
        //            }else {
        //                mapObject.updateMarkerArray(record);
        //            }
        //        })
        //    }
        //});
    },
    interval : 5000
};


Ext.TaskManager.start(task);

Ext.define('Pandora.view.BusTreeView',{
    extend:'Ext.tree.Panel',
    alias:'widget.BusTree',
    store:'BusTreeStore',
    rootVisible : false,

    listeners : {

        'checkchange': function(node, state) {
            setChildChecked(node,state);
            setParentChecked(node,state);

            var groups = this.getChecked();
            busIds = "";
            groups.forEach(function(group){

                if(group.get('id') != '0'){

                    if(getNodeType(group.get('id')) == "node_device"){
                        var nodeId = getNodeId(group.get('id'));
                        busIds += nodeId + "," ;
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