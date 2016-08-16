Ext.define("Pandora.js.GlobalInfo",{
    alias:"GlobalInfo",
    /**
     * 全局变量，地图对象
     */
    mapObject : null ,
    comboCompanyId : "",
    /**
     *  全局变量，当前被选中的id
     * @type {string}
     */
    deviceIds : "",
    /**
     * 列表类
     */
    listColumns: null,
    constructor:function() {
        console.log("init global param");
        var lc= Ext.create('ListColumn',{});
        if(lc){
            this.listColumns = lc ;
        }else{
            console.log("list columns create error");
        }
    },

    setChildChecked:function(node,checked){
        node.expand();
        node.set({checked:checked});
        if(node.hasChildNodes()){
            node.eachChild(function(child) {
                this.setChildChecked(child,checked);
            });
        }
    },
    setParentChecked:function(node,checked){
        node.set({checked:checked});
        var parentNode = node.parentNode;
        if(parentNode !=null){
            var flag = false;
            parentNode.eachChild(function(child) {
                if(child.data.checked == true){
                    flag = true;
                }
            });
            if(checked == false){
                if(!flag){
                    this.setParentChecked(parentNode,checked);
                }
            }else{
                if(flag){
                    this.setParentChecked(parentNode,checked);
                }
            }
        }
    },
    getNodeType:function(nodeId){
        var nodeInfo = nodeId.split("-");
        return nodeInfo[0];

    },
    getNodeId:function(nodeId){
        var nodeInfo = nodeId.split("-");
        return nodeInfo[1];
    }
});


//function initWebSocket(){
//    var ws = new WebSocket("ws://127.0.0.1:8084");
//    ws.onopen = function(evt) {
//        console.log("socket on open");
//    };
//    ws.onclose = function(evt) {
//        console.log("socke on close");
//    };
//    ws.onmessage = function(evt){
//        console.log("socket on message");
//    };
//    ws.onerror = function(evt){
//        console.log("socket error");
//    }
//}
//
//function setChildChecked(node,checked){
//
//}
//
//function setParentChecked(node,checked){
//
//}
//
//function getNodeType(nodeId){
//}
//
//function getNodeId(nodeId){
//    var nodeInfo = nodeId.split("-");
//    return nodeInfo[1];
//}


