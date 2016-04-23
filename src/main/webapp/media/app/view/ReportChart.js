Ext.define('Pandora.view.ReportChart',{
    extend:'Ext.chart.Chart',
    alias:'widget.reportChart',
    id:'reportChart',
    animate: true,
    shadow: true,
    store: 'DevReportStore',

    axes: [{
        type: 'Numeric',
        position: 'left',
        fields: ['weight'],
        label: {
            renderer: Ext.util.Format.numberRenderer('0,0')
        },
        title: '总加料值',
        grid: true,
        minimum: 0
    }, {
        type: 'Category',
        position: 'bottom',
        fields: ['devId'],
        title: '设备编号'
    }],
    series: [{
        type: 'column',
        axis: 'left',
        highlight: true,
        tips: {
            trackMouse: true,
            width: 200,
            height: 28,
            renderer: function(storeItem, item) {
                this.setTitle(storeItem.get('devId') + ': ' + storeItem.get('weight') + ' $');
            }
        },
        //label: {
        //    display: 'insideEnd',
        //    'text-anchor': 'middle',
        //    field: 'devId',
        //    renderer: Ext.util.Format.numberRenderer('0'),
        //    orientation: 'vertical',
        //    color: '#FFF'
        //},
        xField: 'devId',
        yField: 'weight'
    }],
    renderTo: Ext.getBody()
});