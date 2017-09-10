<%--
  Created by IntelliJ IDEA.
  User: leo
  Date: 2017/7/11
  Time: 上午9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<head>
    <title></title>
    <link href="../css/style.css" rel="stylesheet" type="text/css">
    <script src="../script/jquery-1.8.1.min.js"></script>
    <script language="javascript" src="../script/common.js" ></script>
    <script type="text/javascript" src="../script/productDiv.js" ></script>
    <script>
        function getDate() {
            var date=new Date();
            document.getElementsByName("createDate")[0].value=date.toLocaleDateString();
        }

        function re(){
            window.location="addGoods.jsp";
        }

        function save(){
            document.getElementById("addForm").submit();
        }
        
        function isDupCode(obj) {
            var httpRequest;
            if(window.XMLHttpRequest){
                httpRequest=new XMLHttpRequest();
            }else{
                httpRequest=new ActiveXObject("Microsoft.XMLHTTP");
            }

            httpRequest.open("get","../storeServlet/ProductCodeDupServlet?productCode="+obj.value,true);
            httpRequest.send(null);

            httpRequest.onreadystatechange=function () {
                if(httpRequest.readyState==4&&httpRequest.status==200){
                    var text=httpRequest.responseText;
                    $("#dup").text(text);
                    if(text=="产品编号重复"){
                        $("#dup").css("color","red");
                    }else if(text=="√"){
                        $("#dup").css("color","green");
                    }
                }
            };

        }

        function isDupName(obj) {
            var httpRequest;
            if(window.XMLHttpRequest){
                httpRequest=new XMLHttpRequest();
            }else{
                httpRequest=new ActiveXObject("Microsoft.XMLHTTP");
            }

            httpRequest.open("get","../storeServlet/ProductNameDupServlet?productName="+obj.value,true);
            httpRequest.send(null);

            httpRequest.onreadystatechange=function () {
                if(httpRequest.readyState==4&&httpRequest.status==200){
                    var text=httpRequest.responseText;
                    $("#dupName").text(text);
                    if(text=="产品名称重复"){
                        $("#dupName").css("color","red");
                    }else if(text=="√"){
                        $("#dupName").css("color","green");
                    }
                }
            };

        }

    </script>

</head>
<body onload="getDate()">
<table width="100%"  border="0" cellpadding="0" cellspacing="0" id="m">
    <tr>
        <td nowrap class="title1">您的位置：工作台面－－产品管理</td>
    </tr>
</table>
<form action="../storeServlet/AddProductServlet" method="post" id="addForm">
    <div id="add" >
        <table width="100%"  border="0" align="center" cellspacing="1" class="c">

            <tr>
                <td align="center">产品编号</td>
                <td align="center"><input type="text" name="productCode" onchange="isDupCode(this)"/><span id="dup"></span></td>
                <td><span style="color: red;float: left">*必填项</span></td>
            </tr>
            <tr>
                <td align="center">产品名称</td>
                <td align="center"><input type="text" name="productName" onchange="isDupName(this)" /><span id="dupName"></span></td>
                <td><span style="color: red;float: left">*必填项</span></td>
            </tr>
            <tr>
                <td align="center">类别序列号</td>
                <td align="center">
                    <select name="categoryId" style="width: 120px;text-align: center">
                        <c:forEach items="${sessionScope.ProductsCategorys}" var="id">
                        <option>${id}</option>
                        </c:forEach>
                    </select>
                </td>
                <td></td>
            </tr>
            <tr>
                <td align="center">销售价</td>
                <td align="center"><input type="text" name="productPrice" value="0"/></td>
                <td></td>
            </tr>
            <tr>
                <td align="center">数量单位</td>
                <td align="center"><input type="text" name="unitName"/></td>
                <td><span style="color: red;float: left">*必填项</span></td>
            </tr>
            <tr>
                <td align="center">添加日期</td>
                <td align="center"><input type="text" name="createDate" readonly/></td>
                <td></td>
            </tr>
            <tr>
                <td align="center">描述</td>
                <td align="center"><input type="text" name="remark"/></td>
                <td></td>
            </tr>

            <tr>
                <td height="18" colspan="3" align="center"><input type="button" onclick="re()" value="重置" /> <input type="button" onclick="save()" value="保存"/></td>
            </tr>
        </table>


    </div>
</form>
</body>
</html>
