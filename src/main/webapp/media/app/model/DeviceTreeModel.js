Ext.define('Pandora.model.DeviceTreeModel',{
    extend: 'Ext.data.Model',
    //fields: ['id', 'parentId', 'text', 'memo', 'userGroupId','type','leaf']
    //fields: ['id','parentId','nodeName','nodeType','nodeLayer','isLeaf','nodeIcon'];
    fields : [ {
        name : 'id',
        type : 'string',
        defaultValue : null
    }, {
        name : 'text',
        type : 'string',
        defaultValue : null
    }, {
        name : 'leaf',
        type : 'bool',
        defaultValue : false
    }, {
        name : 'cls',
        type : 'string',
        defaultValue : null
    }, {
        name : 'iconCls',
        type : 'string',
        defaultValue : null
    }, {
        name : 'page',// 自定义
        type : 'string',
        defaultValue : null
    }, {
        name : 'checked',
        type : 'bool',
        defaultValue :'false'
    }]
});