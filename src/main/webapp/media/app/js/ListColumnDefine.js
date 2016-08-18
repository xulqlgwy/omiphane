Ext.define("Pandora.js.ListColumn",{
    alias:'ListColumn',
    listColumn: null,
    currentColumns : null,
    constructor: function () {
        console.log("开始初始化列定义");
        Ext.Ajax.request({
            url:'/get/columnList',
            method:'post',
            success:function(response,option){
                //返回列定义的Json
                var error = Ext.JSON.decode(response.responseText).error;
                if(error){
                    Ext.Msg.alert(error);
                    return;
                }

                var listJson = Ext.JSON.decode(response.responseText).columnJson;
                this.listColumn = new Hashtable();

                for(var i = 0 ; i < listJson.length ; i++){
                    if(this.listColumn.containsKey(listJson[i].type)) {
                        console.log("类型" + listJson[i].type + "有重复")
                        continue;
                    }
                    this.listColumn.put(listJson[i].type,listJson.columns)
                    if(listJson[i].type == 'Tank'){
                        this.currentColumns = listJson.columns ;
                    }
                }
                if(this.currentColumns == null){
                    Ext.Msg.alert("当前列类型为空");
                }
            }
        })
    },
    /**
     * 返回列
     * @param listColumn
     */
    getColumnsByType:function(listColumn){
        return this.listColumn.get(listColumn)
    },

    toString:function(){
        if(this.listColumn != null && this.listColumn.length > 0){
            console.log("系统包含"+this.listColumn.length+"种列定义");
        }
    },

    getCurrentColumns : function(){
        if(this.currentColumns == null){
            Ext.Msg.alert("当前列类型为空");
            return ;
        }
        return this.currentColumns;
    }
});