function isDup(obj) {
    var httpRequest=new XMLHttpRequest();
    httpRequest.open("get","../financeservlet/AccountDuplicate?username="+obj.value,true);
    httpRequest.send(null);

    httpRequest.onreadystatechange=function () {
        if(httpRequest.readyState==4&&httpRequest.status==200){
            var text = httpRequest.responseText;//获得响应的结果
            var span = $(obj).next("span");
            span.text(text);
            if(text=="√")
                span.css('color','green');
            else
                span.css('color','red');
        }
    }
}/**
 * Created by JerryCheng on 2017.7.17.
 */
