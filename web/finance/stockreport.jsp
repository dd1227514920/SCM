<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: JerryCheng
  Date: 2017.7.14
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<table width="100%"  border="0" cellpadding="0" cellspacing="0" id="m">
    <tr>
        <td nowrap class="title1">您的位置：工作台面－－月度库存报表</td>
    </tr>
</table>
<form action="../financeservlet/StockReport" method="get">
    <table width="100%"  border="0" align="center" cellspacing="1" class="c">
        <tr>
            <td class="title1">产品总库存数：${requestScope.numtotal}</td>
            <td class="title1">时间:
                <input type="month" name="begin" value="${requestScope.begin}">
                <input type="month" name="end" value="${requestScope.end}">
                <input type="submit" value="查询">
            </td>

        </tr>
    </table>
</form>
<table width="100%"  border="0" align="center" cellspacing="1" class="c">
    <tr>
        <td class="title1">产品单号</td>
        <td class="title1">产品名称</td>
        <td class="title1">库存数</td>
    </tr>
    <c:forEach items="${requestScope.rss}" var="rss">
        <tr>

            <td align="center"><a href="#?${rss.productcode}">${rss.productcode}</a></td>
            <td align="center">${rss.name}</td>
            <td align="center">${rss.num}</td>
    </c:forEach>

</table>
</body>
</html>