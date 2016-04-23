/**
 * Created by Administrator on 2015/7/1.
 */
MapInfo = function(){
    this.map =null ;
    this.realMarkerArray;
    this.allMarker = [];

    this.initMap = function(point, zoom , nav, scale , override){
        //if(this.isMapInvalid) return "地图加载失败" ;
        this.realMarkerArray = new Hashtable();//车辆标记点表
        this.map.centerAndZoom(point , zoom) ;
        this.map.addControl(new BMap.NavigationControl());
        this.map.addControl(new BMap.ScaleControl());
        this.map.addControl(new BMap.OverviewMapControl());
        this.map.enableScrollWheelZoom();
        this.map.addControl(new BMap.MapTypeControl());
        this.map.enableContinuousZoom();
        this.contextMenu = new BMap.ContextMenu();
        this.txtMenuItem = [
            {
                text:'放大',
                callback:function(){
                    alert("放大");
                    this.map.zoomIn()
                }
            },
            {
                text:'缩小',
                callback:function(){this.map.zoomOut()}
            },
            {
                text:'放置到最大级',
                callback:function(){this.map.setZoom(18)}
            },
            {
                text:'查看全国',
                callback:function(){this.map.setZoom(4)}
            },
            {
                text:'查找',
                callback:function(){
                    //window.external.ClickEvent_Setting("",XG_RET_SERCH);
                    Ext.Msg.alert('', '查找.');
                }
            },
            {
                text:'在此添加兴趣点',
                callback:function(p){
                    //window.external.ClickEvent_AddPoint(p.lng+ "," +p.lat,XG_RET_ADDPOINT);
                    Ext.Msg.alert('', '在此添加兴趣点.');
                }

            },
            {
                text:'设置',
                callback:function()
                {
                    Ext.Msg.alert('', '设置.');
                }
            }
        ];

        for(var i=0; i < this.txtMenuItem.length; i++) {

            this.contextMenu.addItem(new BMap.MenuItem(this.txtMenuItem[i].text, this.txtMenuItem[i].callback, 100));
            if (i == 1 || i == 3) {
                this.contextMenu.addSeparator();
            }
        }

        this.map.addContextMenu(this.contextMenu);
    }

    this.centerPoint = function (record) {
        var point = new BMap.Point(record.get('longitude'), record.get('latitude'));
        var zoom = this.map.getZoom();
        this.map.centerAndZoom(point, zoom);
    }


    /**
     * 创建车辆点
     */
    this.setMarker = function(record) {
        var point = new BMap.Point(record.get('longitude'), record.get('latitude'));
        var iconImg = "";
        if(record.get('type') == 2)//车辆图标
        {
            //switch(record.Xg_Businfoconfig_Imgpath)
            //{
            //    case "混凝土": nSel=0; break;
            //    case "面包车": nSel=1; break;
            //    case "物流车": nSel=2; break;
            //    case "私家车": nSel=3; break;
            //    case "出租车": nSel=4; break;
            //    default:
            //        nSel=0; break;
            //}
            var nSel = 0 ;
            var s0 = basePath + "/media/image/bus/" + (nSel + 1) + "_" + "green.png";
            var s1 = basePath + "/media/image/bus/" + (nSel + 1) + "_" + "off.png";
            var s2 = basePath + "/media/image/bus/" + (nSel + 1) + "_" + "overspeed.png";
            var s3 = basePath + "/media/image/bus/" + (nSel + 1) + "_" + "stop.png";
            var s4 = basePath + "/media/image/bus/" + (nSel + 1) + "_" + "warn.png";


            //var s0=makeIconPath(json.Angel);
            var n=this.getcurrentState();
            var path = "";
            switch(n)
            {
                case 0:  iconImg = this.createIcon(s0);break;
                case 1:  iconImg = this.createIcon(s1);break;
                case 2:  iconImg = this.createIcon(s2);break;
                case 3:  iconImg = this.createIcon(s3);break;
                case 4:  iconImg = this.createIcon(s4);break;
                default:  iconImg = this.createIcon(s0);break;
            }
        }
        else if(record.get('type') ==1)
        {
            var rat=Math.round((record.get('weight')/record.get('keyValue'))*100);
            if(rat>=100)rat=100;
            var n=parseInt(rat/2);
            var m=n*2+2;
            if(rat<record.get('threshold'))
            {
                var path= basePath + "/media/image/plot_red/" +m+".png";
            }
            else if(rat>100)
            {
                m=100;
                var path=basePath + "/media/image/plot_red/" +m+".png";
            }
            else var path=basePath + "/media/image/plot_blue/" +m+".png";
            iconImg = this.createIcon(path);
        }

        //alert(json.Xg_businfoconfig_BusType);
        var marker = new BMap.Marker(point, { icon: iconImg });

        var label = new BMap.Label(record.get('nickName'), { "offset": new BMap.Size(5 - 6 + 10, -20) });

        label.setStyle({ borderColor: "#0000FF",color: "#0000FF", cursor: "pointer" });
        marker.setLabel(label);


        var _iw = this.createInfoWindow(record);
        (function () {
            //var _iw = this.createInfoWindow(record);
            var _marker = marker;
            _marker.addEventListener("click", function () {
                this.openInfoWindow(_iw);
            })
            _iw.addEventListener("open", function () {
                _marker.getLabel().hide();
            })
            _iw.addEventListener("close", function () {
                _marker.getLabel().show();
            })
            label.addEventListener("click", function () {
                _marker.openInfoWindow(_iw);
            })
            //if (!!json.isOpen) {
            //    label.hide();
            //    _marker.openInfoWindow(_iw);
            //}
        })()
        this.map.addOverlay(marker);
        //     map.centerAndZoom(point, 15);
        //      marker.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画


        return marker;
    }

    this.getcurrentState = function(record){
        return 0;
    }

    /**
     * 设置图标偏移
     * @param img
     * @returns {BMap.Icon}
     */
    this.createIcon = function(img) {
        var icon = new BMap.Icon(img, new BMap.Size(32, 47),
            { imageOffset: new BMap.Size(-0, -0),
                infoWindowAnchor: new BMap.Size(5 + 5, 1),
                offset: new BMap.Size(6, 33) })
        return icon;
    }

    this.updateMarkerArray = function (record) {
        var markerId= record.get('devId');
        var marker = null ;
        if(this.realMarkerArray.containsKey(markerId))//判断是否存在，存在则删除，不存在则添加
        {
            marker =this.realMarkerArray.get(markerId);
            if(marker!=null)
            {
                this.map.removeOverlay(marker);
                marker = this.setMarker(record);
                this.realMarkerArray.put(markerId,marker);
            }
            else
            {
                marker = this.setMarker(record);
                this.realMarkerArray.put(markerId,marker);
            }
        }
        else
        {
            marker = this.setMarker(record);
            this.realMarkerArray.put(markerId , marker);
        }
        this.allMarker.push(marker);
        this.getAddressByPoint(record);
    }

    /**
     * 返回解析后的地址
     * @param record
     */
    this.getAddressByPoint = function(record) {
        var gc = new BMap.Geocoder();

        var pt = new BMap.Point(record.get('longitude'), record.get('latitude'));
        gc.getLocation(pt, function(rs) {
            var addComp = rs.addressComponents;
            if( addComp.streetNumber != ""){
                var address=addComp.province + ", " + addComp.city + ", " + addComp.district + ", " + addComp.street + ", " + addComp.streetNumber;
                record.set('location',address)
            }else{
                var address=addComp.province + ", " + addComp.city + ", " + addComp.district + ", " + addComp.street ;
                record.set('location',address)
            }

            //window.external.MapRetAddress(ret,XG_RET_MAPADDRESS);
        });
    }

    /**
     * 删除全部图标
     */
    this.removeAllMarker = function() {
        for( var i = 0 ; i < this.allMarker.length ; i++){
            this.map.removeOverlay(this.allMarker[i]);
        }
    }

    //创建InfoWindow
    this.createInfoWindow = function(record) {
        if(record.get('type') == 2){//车辆infowindow
            var opts = {title : "<span style='font-size:14px;color:#0000FF';align='center'>"+record.get('nickName')+"</span>"};
            var iw = new BMap.InfoWindow("<div style='line-height:1.8em;font-size:12px;'>"+
            "<b>车牌号:</b>"+record.get('nickName')+"</br>"+
            "<b>信息时间:</b>"+record.get('gpsTime')+"</br>"+
            "<b>位置:</b>"+record.get('longitude')+"</br>"+
            "<b>速度:</b>"+record.get('speed')+"</br>"+
            //"<a style='text-decoration:none;color:#2679BA;float:right' onclick='showtrack()'>查看轨迹>></a>"+
            //"<a style='text-decoration:none;color:#2679BA;float:right' onclick='showvedio()'>预览视频>></a>"+
            //"<a style='text-decoration:none;color:#2679BA;float:right' onclick='showvedio_detail()'>查看视频>></a>"+
            "</div>",opts);
            return iw;
        }
        else if(record.get('type') == 1)
        {
            var opts = {title : "<span style='font-size:14px;color:#313335';align='center'>"+record.get('nickName')+"</span>"};
            var iw = new BMap.InfoWindow("<div style='line-height:1.8em;font-size:12px;'>"+
            "<b>信息时间:</b>"+record.get('gpsTime')+"</br>"+
            "<b>位置:</b>"+record.get('longitude')+ "," +record.get('latitude')+"</br>"+
            "<b>砂浆类型:</b>"+record.get('tankType')+"</br>"+
            "<b>重量:</b>"+record.get('weight')+"</br>"+
            "<b>容量:</b>"+record.get('keyValue')+"</br>"+
            "<b>比例:</b>"+((record.get('weight')/record.get('keyValue'))*100).toFixed(2)+"%"+"</br>"+
            "</div>",opts);
            return iw;
        }

    }
};