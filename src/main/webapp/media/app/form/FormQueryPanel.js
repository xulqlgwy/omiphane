Ext.define('Pandora.form.FormQueryPanel', {
    extend: 'Ext.form.Panel',
    bodyPadding: 5,
    width: 350,
    alias:'widget.queryForm',

    // 将会通过 AJAX 请求提交到此URL
    url: '/query/report',

    // 表单域 Fields 将被竖直排列, 占满整个宽度
    layout: {
        type: 'vbox'
    },

    items:[{
        layout:{
            type:'hbox'
        },
        items: [{
            xtype: "combo",
            fieldLabel: '公司名称',style:'text-align:right;color:red',
            width: 300,
            height: 26,
            hideTrigger: false,
            typeAhead:true,
            store: 'CompanyStore',
            queryMode: 'remote',
            queryParam:'filter',
            editable: false,
            displayField: 'name',
            valueField: 'cid',
            allowBlank: true,
            selectOnFocus:'true',
            name:'companyId',
            queryCaching:false,//当为false，每次都会从后台请求数据
            listeners:{
                "select":function(combo,record,opt){
                    comboCompanyId  = record[0].get('cid');
                }
            }
        },{
            xtype: "combo",
            id:'devCombo',
            fieldLabel: '选择终端',style:'text-align:right;color:red',
            width: 300,
            height: 26,
            hideTrigger: false,
            typeAhead:true,
            store: 'DevComboStore',
            queryMode: 'remote',
            //queryParam:'companyId',
            editable: true,
            displayField: 'devId',
            valueField: 'devId',
            name:'devId',
            allowBlank: true,
            enabled: true,
            selectOnFocus: true,
            queryCaching:false
            //style:{
            //    marginLeft:'30px'
            //}
        },{
            xtype: "combo",
            id:'typeCombo',
            fieldLabel: '选择材料类型',
            width: 300,
            height: 26,
            hideTrigger: false,
            typeAhead:true,
            store: 'TypeComboStore',
            queryMode: 'remote',
            editable: false,
            displayField: 'tankType',
            valueField: 'tankType',
            name:'tankType',
            allowBlank: true,
            enabled: true,
            selectOnFocus: true,
            queryCaching:false,
            style:'text-align:right;color:red;marginLeft:20px'
        },{

        }]
    },{
        layout:{
            type:'hbox'
        },
        items:[{
            xtype: "datetimefield",
            id:'startTime',
            fieldLabel: '开始时间',
            width: 300,
            height:26,
            allowBlank: false,
            name:'startTime',
            style:'text-align:right;color:red;'
        },{
            xtype: "datetimefield",
            id:'endTime',
            fieldLabel: '结束时间',
            width: 300,
            height:26,
            name:'endTime',
            allowBlank: false,
            style:'text-align:right;color:red;'
        },{
            xtype:'button',
            text: '查询',
            height:26,
            width: 100,

            style:{
                marginLeft : '223px'
            },

            formBind: true, //only enabled once the form is valid
            disabled: true,
            handler: function() {
                var form = this.up('form').getForm();
                if (form.isValid()) {
                    form.submit({
                        success: function(form, action) {
                            //Ext.Msg.alert('保存成功', action.result.msg);
                            var devStore = Ext.getCmp('devReportDataList').store;
                            devStore.loadData(action.result.deviceReportData,false);
                        },
                        failure: function(form, action) {
                            alert(1);
                            //Ext.Msg.alert('操作失败', action.result.msg);
                        }
                    });
                }
            }
        }]
    }],


    // The fields
    //defaultType: 'textfield',


    renderTo: Ext.getBody()
});