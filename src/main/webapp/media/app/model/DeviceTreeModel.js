Ext.define('Pandora.model.DeviceTreeModel',{
    extend: 'Ext.data.Model',
    fields: ['id', 'parentId', 'text', 'memo', 'userGroupId','type','leaf']
});