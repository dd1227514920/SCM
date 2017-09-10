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
        <td nowrap class="title1">您的位置：工作台面－－月度收支报表</td>
    </tr>
</table>
<form action="../financeservlet/MonthReport" method="get">
    <table width="100%"  border="0" align="center" cellspacing="1" class="c">
        <tr>
            <td class="title1">收款总金额：${requestScope.intotal}</td>
            <td class="title1">付款总金额：${requestScope.outtotal}</td>
            <td class="title1">收款交易次数：${requestScope.sms.size()}</td>
            <td class="title1">付款交易次数：${requestScope.pms.size()}</td>
            <td class="title1">时间:
                 <input type="date" name="begin" value="${requestScope.inout.begin}">
                 <input type="date" name="end" value="${requestScope.inout.end}">
                <input type="submit" value="查询">
            </td>

        </tr>
    </table>
</form>
<table width="49%"  border="0" align="center" cellspacing="1" class="c" style="float: left">
    <tr>
        <td class="title1">销售单号</td>
        <td class="title1">销售单日期</td>
        <td class="title1">收款日期</td>
        <td class="title1">收款金额</td>
        <td class="title1">经手人</td>
        <td class="title1">处理状态</td>
    </tr>
    <c:forEach items="${requestScope.sms}" var="sms">
        <tr>
            <td align="center"><a href="../financeservlet/ReportDetails?${sms.soID}">${sms.soID}</a></td>
            <td align="center">${sms.createTime}</td>
            <td align="center">${sms.payTime}</td>
            <td align="center">${sms.soTotal}</td>
            <td align="center">${sms.account}</td>
            <td align="center">${sms.status}</td>
        </tr>
    </c:forEach>

</table>
<table width="49%"  border="0" align="center" cellspacing="1" class="c" style="float: right">
    <tr>
        <td class="title1">采购单号</td>
        <td class="title1">采购单日期</td>
        <td class="title1">付款日期</td>
        <td class="title1">付款金额</td>
        <td class="title1">经手人</td>
        <td class="title1">处理状态</td>
    </tr>
    <c:forEach items="${requestScope.pms}" var="pms">
        <tr>
            <td align="center"><a href="../financeservlet/ReportDetails?${pms.poID}">${pms.poID}</a></td>
            <td align="center">${pms.createTime}</td>
            <td align="center">${pms.payTime}</td>
            <td align="center">${pms.poTotal}</td>
            <td align="center">${pms.account}</td>
            <td align="center">${pms.status}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
