<%--
  Created by IntelliJ IDEA.
  User: leo
  Date: 2017/7/12
  Time: 上午11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
    <link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td nowrap class="title1">您的位置：工作台面－－采购单详细</td>
    </tr>
</table>

<div id="PODetail">
    <table width="100%"  border="0" align="center" cellspacing="1" class="c">
        <tr>
            <td align="center">产品编号</td>
            <td align="center">产品名称</td>
            <td align="center">产品数量单位</td>
            <td align="center">产品数量</td>
            <td align="center">采购单价</td>
            <td align="center">产品明细总价</td>
        </tr>

        <c:forEach items="${requestScope.pois}" var="pois">
            <tr>
                <td align="center">${pois.productCode}</td>
                <td align="center">${pois.name}</td>
                <td align="center">${pois.unitName}</td>
                <td align="center">${pois.num}</td>
                <td align="center">${pois.unitPrice}</td>
                <td align="center">${pois.itemPrice}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>