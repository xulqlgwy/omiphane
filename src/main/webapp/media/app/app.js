Ext.application({
    requires:['Ext.container.Viewport','Pandora.js.GlobalInfo','Pandora.js.ListColumn'],
    name: 'Pandora',
    appFolder: 'media/app',
    autoCreateViewport: true,
    models: ['DeviceModel','DeviceTreeModel','DeviceRealDataModel'],
    stores: ['DeviceStore','DeviceTreeStore','BusTreeStore','CompanyStore','DevComboStore','TypeComboStore','DevReportStore'],
    controllers: ['DeviceController','MapController','TreeController'],
    constructor:function(){
        console.log("init");
        var globalInfo = Ext.create("GlobalInfo",{

        });

        console.log(globalInfo);
    },
    launch:function(){
        //Ext.util.CSS.swapStyleSheet('theme',basePath + '/media/extjs/resources/ext-theme-neptune/ext-theme-neptune.css');
        Ext.util.CSS.swapStyleSheet('theme',basePath + '/media/extjs/resources/ext-theme-access/ext-theme-access-all.css');
        //Ext.util.CSS.swapStyleSheet('theme',basePath + '/media/extjs/resources/ext-theme-classic-sandbox/ext-theme-classic-sandbox-all.css');
        //initWebSocket();
    }
});

var globalInfo = null;

