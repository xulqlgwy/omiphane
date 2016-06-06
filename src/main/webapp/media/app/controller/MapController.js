Ext.define('Pandora.controller.MapController', {
    extend: 'Ext.app.Controller',
    refs: [{
        ref: 'MapView',
        selector: 'MapView'
    }],
    init : function () {
        this.control({
            'map' : {
                afterrender:function( component, eOpts){
                    //初始化地图
                    render: this.initMap(component.el.dom);
                }
            }
        });


        this.callParent();
    },

    initMap:function(div){
        /*
         初始化地图
         */

        if (globalInfo.mapObject == null){
            globalInfo.mapObject = new MapInfo();
            globalInfo.mapObject.map = new BMap.Map(div);
        }
        //默认位置
        //var point = new BMap.Point(116.3972,39.9096);
        //mapObject.map.centerAndZoom(point, 12);



        /*
        获取当前位置
        */
        var localCity = new BMap.LocalCity();
        localCity.get(function(result){
            var cityName = result.name;
            var localPoint = new BMap.Point(result.center.lng, result.center.lat);
            globalInfo.mapObject.initMap(localPoint , 12 ,1 ,1 ,1);
            globalInfo.mapObject.map.setCenter(localPoint,cityName);
        });




        ////
        /////*
        //// 启用鼠标滚动
        //// */
        //map.enableScrollWheelZoom();    //启用滚轮放大缩小，默认禁用
        //map.enableContinuousZoom();    //启用地图惯性拖拽，默认禁用

    }
})