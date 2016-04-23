Ext.define('Pandora.store.CompanyStore', {
    extend: 'Ext.data.Store',
    requires: 'Pandora.model.CompanyModel',
    model: 'Pandora.model.CompanyModel',

    autoLoad: true,
    clearOnLoad : true,

    proxy: {
        type: 'ajax',
        url: '/get/company',
        reader: {
            type: 'json',
            root: 'companies'
        }
    }
});