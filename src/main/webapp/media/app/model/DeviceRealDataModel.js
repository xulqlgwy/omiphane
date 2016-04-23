Ext.define('Pandora.model.DeviceRealDataModel', {
    extend: 'Ext.data.Model',
    fields: ['did','type', 'devId','nickName','gpsTime','latitude','longitude',
        'speed','angel','location','weight','alarmData','product','threshold',
        'model','creationDate','simCardNum','dateCost','lastModifiedDate','keyValue',
        'tankType']
});