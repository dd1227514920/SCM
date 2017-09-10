<%--
  Created by IntelliJ IDEA.
  User: JerryCheng
  Date: 2017.7.10
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增用户</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="js/jquery-1.8.1.min.js"></script>
    <script type="text/javascript" src="js/isDup.js"></script>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" id="m">
    <tr>
        <td nowrap class="title1">您的位置：工作台面－－新增用户</td>
    </tr>
</table>
<form id="modifyForm" action="../financeservlet/AddUser" method="post">
    <table id="modify" width="100%" border="0" align="center" cellspacing="1" class="c">
        <tr>
            <td align="right" width="700px">用户名</td>
            <td align="left"><input type="text" name="username" onchange="isDup(this)"><span></span></td>
        </tr>
        <tr>
            <td align="right" width="700px">姓名</td>
            <td align="left"><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td align="right" width="700px">密码</td>
            <td align="left"><input type="text" name="password"/></td>
        </tr>
        <tr>
            <td align="right" width="700px">添加日期</td>
            <td align="left">
                <input type="date" name="createDate"> <span class="requred_symbol">*</span>
            </td>
        </tr>
        <tr>
            <td align="right" width="700px">锁定状态</td>
            <td align="left"><input type="radio" name="status" value="1"/>是 <input type="radio" name="status" value="0"/>否</td>
        </tr>
        <tr>
            <td align="right" width="700px">用户权限</td>
            <td align="left">
                <input type="checkbox" name="limits" value="经理"/>经理
                <input type="checkbox" name="limits" value="采购"/>采购
                <input type="checkbox" name="limits" value="仓管"/>仓管
                <input type="checkbox" name="limits" value="财务"/>财务
            </td>
        </tr>
        <tr>
            <td height="18" colspan="2" align="center"><input type="reset"/> <input type="submit" value="保存"/></td>
        </tr>
    </table>
</form>
</body>
</html>
