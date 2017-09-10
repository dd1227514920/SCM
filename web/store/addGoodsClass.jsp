<%--
  Created by IntelliJ IDEA.
  User: leo
  Date: 2017/7/10
  Time: 下午1:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link href="../css/style.css" rel="stylesheet" type="text/css">
    <script language="javascript" src="../script/common.js" ></script>
    <script type="text/javascript" src="../script/productDiv.js" ></script>
    <script>
        function getSerial() {
            var date=new Date();
            var serial=date.getFullYear()+(date.getMonth()+1)+date.getDate()+date.getHours()+date.getMinutes()+date.getSeconds();
            document.getElementsByName("categoryId")[0].value=serial;
        }

        function goback() {
            window.location="/store/addGoodsClass.jsp";
        }



    </script>
</head>
<body onload="getSerial()">

<table width="100%"  border="0" cellpadding="0" cellspacing="0" id="m">
    <tr>
        <td nowrap class="title1">您的位置：工作台面－－产品分类管理</td>
    </tr>
</table>
<form action="../storeServlet/AddCategoryServlet" method="post" id="addForm">
<div id="add" >
    <table width="100%"  border="0" align="center" cellspacing="1" class="c">

        <tr>
            <td align="center">类别序列号</td>
            <td align="center"><input type="text" name="categoryId" readonly/></td>
            <td></td>
        </tr>
        <tr>
            <td align="center">名称</td>
            <td align="center"><input type="text" name="categoryName"/></td>
            <td><span style="color: red;float: left">*必填项</span></td>
        </tr>
        <tr>
            <td align="center">描述</td>
            <td align="center"><input type="text" name="categoryRemark"/></td>
            <td></td>
        </tr>
        <tr>
            <td height="18" colspan="3" align="center"><input type="button" onclick="goback()" value="重置"/> <input type="submit" value="保存"/></td>
        </tr>
    </table>


</div>
</form>
</body>
</html>
