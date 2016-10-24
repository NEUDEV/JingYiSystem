$(document).ready(function () {
    $("#mycard").click(function () {
        $.ajax({
            url:"/mycardlist.action",
            type:'POST',
            data:"{}",
            dataType:'json',
            success:function (data) {
            	alter("on");
            	var obj = $.parseJSON(data);
            	var msgname = obj.result;
            	var str="";
            	str+=("<option value=\""+data[i].name+"\">"+data[i].name+"</option>");
                $("#mycard").append(str);
                alter("yes");
            }
        ,error:function(){
            alert("err111");
       }
        });
        /*$.getJSON("/test/input_user!queryHello", function (data) {
         //通过.操作符可以从data.hello中获得Action中hello的值
         $("#allUser").html("输出了: " + data.hello);
         });*/
    });
    

})