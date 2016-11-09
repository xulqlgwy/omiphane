/**
 * Created by Administrator on 2016/10/19.
 */

$(function(){
    $.ajax({
        type:'POST',
        url:basePath+"/initListView",
        dataType:'json',
        success:function(data){
            if(data.error){
                alert(data.error);
            }else{
                var realDataList = data.message;
                renderRealDataList(realDataList);

            }

        }
    })
});

function renderRealDataList(realDataList){
    //$("#real_data_list li").remove();
    for(var i = 0 ; i< realDataList.length ; i++){


        //var html = "<li class='ui-li-has-thumb ui-li ui-li-static ui-body-c'><img src='../media/image/plot_gray/50.png' class='li_class'/>  <h3>Reviewer A</h3> <p>jQuery Mobile 很方便的把这类结构调整为你看到的这个样式</p></li>";
        //

        var html = "";
        html += "<li class='ui-li-has-thumb ui-li ui-li-static ui-body-c'>";
        html += "<img src='../media/image/plot_gray/50.png' class='li_class ui-li-thumb' />";
        html += "<h3 class='ui-li-heading'>"+realDataList[i].deviceId+"</h3>";
        html += " <p class='ui-li-desc'>经纬度:"+realDataList[i].latitude+","+realDataList[i].longtitude+";重量:"+realDataList[i].weight+"</p>";
        html += "<p class='ui-li-desc'><a href='#pagethree'>参数设置</a></p>"
        html += "</li>";
        $("#real_data_list").append(html);
    }
}
