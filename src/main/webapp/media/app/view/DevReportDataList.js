Ext.define('Pandora.view.DevReportDataList', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.devReportDataList',
    id : 'devReportDataList',
    
    store: 'DevReportStore',
    hideHeaders: false,
    
    initComponent: function() {
        this.columns = [
            { text: '类型',  dataIndex: 'type' },
            { text: '设备编号',  dataIndex: 'devId' },
            { text: '自编号',  dataIndex: 'nickName' },
            { text: '时间', dataIndex: 'gpsTime' },
            { text: '经度', dataIndex: 'longitude' },
            { text: '纬度', dataIndex: 'latitude' },
            { text: '速度', dataIndex: 'speed' },
            { text: '角度', dataIndex: 'angel' },
            { text: '位置', dataIndex: 'location' },
            { text: '重量', dataIndex: 'weight' },
            { text: '报警信息', dataIndex: 'alarmData' },
            { text: '生产厂家',  dataIndex: 'product' },
            { text: '型号',  dataIndex: 'model' },
            { text: '创建时间',  dataIndex: 'creationDate' },
            { text: 'sim卡号',  dataIndex: 'simCardNum' },
            { text: '使用时间',  dataIndex: 'dateCost' },
            { text: '上次维修时间',  dataIndex: 'lastModifiedDate' },
            { text: '报警值', dataIndex: 'threshold'},
            { text: '最大称重', dataIndex: 'keyValue'}
        ];
        this.listeners =  {
            itemdblclick: function (me, record, item, index, e, eOpts) {
                //mapObject.centerPoint(record);
                alert("double click");
            }
        }
        this.callParent();
    }
});