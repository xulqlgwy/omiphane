Ext.application({
    requires:['Ext.container.Viewport'],
    name: 'Pandora',
    appFolder: 'media/app',
    autoCreateViewport: true,
    models: ['DeviceModel','DeviceTreeModel','DeviceRealDataModel'],
    stores: ['DeviceStore','DeviceTreeStore','BusTreeStore','CompanyStore','DevComboStore','TypeComboStore','DevReportStore'],
    controllers: ['DeviceController','MapController','TreeController'],
    launch:function(){
        //Ext.util.CSS.swapStyleSheet('theme',basePath + '/media/extjs/resources/ext-theme-neptune/ext-theme-neptune.css');
        Ext.util.CSS.swapStyleSheet('theme',basePath + '/media/extjs/resources/ext-theme-access/ext-theme-access-all.css');
        //Ext.util.CSS.swapStyleSheet('theme',basePath + '/media/extjs/resources/ext-theme-classic-sandbox/ext-theme-classic-sandbox-all.css');
        //initWebSocket();
    }
});

/**
 * 全局变量，地图对象
 */
var mapObject;
var comboCompanyId;
/**
 *  全局变量，当前被选中的id
 * @type {string}
 */
var deviceIds = "";
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

function setChildChecked(node,checked){
    node.expand();
    node.set({checked:checked});
    if(node.hasChildNodes()){
        node.eachChild(function(child) {
            setChildChecked(child,checked);
        });
    }
}

function setParentChecked(node,checked){
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
                setParentChecked(parentNode,checked);
            }
        }else{
            if(flag){
                setParentChecked(parentNode,checked);
            }
        }
    }
}

function getNodeType(nodeId){
    var nodeInfo = nodeId.split("-");
    return nodeInfo[0];
}

function getNodeId(nodeId){
    var nodeInfo = nodeId.split("-");
    return nodeInfo[1];
}


