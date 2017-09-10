<%@ page import="javafx.scene.control.Alert" %><%--
  Created by IntelliJ IDEA.
  User: leo
  Date: 2017/7/10
  Time: 上午10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
    <link href="../css/style.css" rel="stylesheet" type="text/css">
    <script src="jquery-1.8.1.min.js"></script>
    <script language="javascript" src="../script/common.js" ></script>
    <script type="text/javascript" src="../script/productDiv.js" ></script>
    <script>


    </script>
</head>
<body >
<div id="m1">


    <table width="100%"  border="0" cellpadding="0" cellspacing="0" id="m">
        <tr>
            <td nowrap class="title1">您的位置：工作台面－－库存查询</td>
        </tr>
    </table>
    <table width="100%"  border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td width="30px" nowrap class="toolbar">&nbsp;</td>
            <td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)"></td>
            <td nowrap class="toolbar">&nbsp;</td>
            <td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)">&nbsp;</td>
            <td width="20px" nowrap class="toolbar">&nbsp;</td>
            <td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)">&nbsp;</td>
            <td width="20px" nowrap class="toolbar">&nbsp;</td>
            <td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)">&nbsp;</td>
            <td width="20px" nowrap class="toolbar">&nbsp;</td>
            <td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)">&nbsp;</td>
            <td width="20px" nowrap class="toolbar">&nbsp;</td>
        </tr>
    </table>


    <table width="100%"  border="0" align="center" cellspacing="1" class="c">
        <tr>
            <td class="title1">库存记录序列号</td>
            <td class="title1">产品编号</td>
            <td class="title1">相关单据号</td>
            <td class="title1">数量</td>
            <td class="title1">入库/出库类型(1为入库，0为出库)</td>
            <td class="title1">入库/出库时间</td>
            <td class="title1">经手人</td>
        </tr>


        <c:forEach items="${requestScope.records}" var="record">
            <tr>
                <td align="center" >${record.stockID}</td>
                <td align="center" >${record.productCode}</td>
                <td align="center" >${record.orderCode}</td>
                <td align="center" >${record.stockNum}</td>
                <td align="center" >${record.stockType}</td>
                <td align="center" >${record.stockTime}</td>
                <td align="center" >${record.createUser}</td>
            </tr>
        </c:forEach>


    </table>
</div>


</body>
</html>
