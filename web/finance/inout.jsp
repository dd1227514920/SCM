<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: JerryCheng
  Date: 2017.7.14
  Time: 0:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>收支查询</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" id="m">
    <tr>
        <td nowrap class="title1">您的位置：工作台面－－收支管理－－查询</td>
    </tr>
</table>

<form action="../financeservlet/InOutServlet" method="get">
<table width="100%"  border="0" align="center" cellspacing="1" class="c">
    <tr>
        <td align="center">日期段：
            开始日期 <input type="date" name="begin" value="${requestScope.inout.begin}">
            截至日期 <input type="date" name="end" value="${requestScope.inout.end}">
            收支类型<select  name="type" >
                <option value="in" <c:if test="${requestScope.inout.type eq 'in'}">selected="selected"</c:if>>收入</option>
                <option value="out"<c:if test="${requestScope.inout.type eq 'out'}">selected="selected"</c:if>>支出</option>
            </select>
            收支类型<select  name="paytype" value="">
                <option value="货到付款" <c:if test="${requestScope.inout.paytype eq '货到付款'}">selected="selected"</c:if>>货到付款</option>
                <option value="款到发货" <c:if test="${requestScope.inout.paytype eq '款到发货'}">selected="selected"</c:if>>款到发货</option>
                <option value="预付款发货" <c:if test="${requestScope.inout.paytype eq '预付款到发货'}">selected="selected"</c:if>>预付款发货</option>
                <option value="" <c:if test="${requestScope.inout.paytype eq ''}">selected="selected"</c:if>></option>
            </select>

            相关单据号<input type="text" name="id" value="${requestScope.inout.id}">
            <input type="submit" value="查询">
        </td>
    </tr>
</table>
</form>
<table width="100%" border="0" align="center" cellspacing="1">
<tr>
    <td class="title1">日期</td>
    <td class="title1">相关单据号</td>
    <td class="title1">金额</td>
    <td class="title1">经手人</td>
    <td class="title1">单据付款方式</td>
</tr>
    <c:if test="${not empty requestScope.pms}" >
    <c:forEach items="${requestScope.pms}" var="pms">
        <tr>
            <c:choose>
                <c:when test="${(pms.payType eq '预付款到发货') && (pms.status eq '3')}"><td align="center">${pms.payTime}</td></c:when>
                <c:when test="${(pms.payType eq '预付款到发货') && (pms.status eq '5')}"><td align="center">${pms.prePayTime}</td></c:when>
                <c:otherwise> <td align="center">${pms.payTime}</td></c:otherwise>
            </c:choose>
            <td align="center">${pms.poID}</td>
            <c:choose>
            <c:when test="${(pms.payType eq '预付款到发货') && (pms.status eq '3')}"><td align="center">${pms.poTotal}</td><td align="center">${pms.payUser}</td></c:when>
            <c:when test="${(pms.payType eq '预付款到发货') && (pms.status eq '5')}"><td align="center">${pms.prePayFee}</td><td align="center">${pms.prePayUser}</td></c:when>
                <c:otherwise><td align="center">${pms.poTotal}</td><td align="center">${pms.payUser}</td></c:otherwise>
       </c:choose>
            <td align="center">${pms.payType}</td>

        </tr>
    </c:forEach>
</c:if>
<c:if test="${not empty requestScope.sms}">
        <c:forEach items="${requestScope.sms}" var="sms">
            <tr>
                <c:choose>
                <c:when test="${(sms.payType eq '预付款到发货') && (sms.status eq '3')}"><td align="center">${sms.payTime}</td></c:when>
                <c:when test="${(sms.payType eq '预付款到发货') && (sms.status eq '7')}"><td align="center">${sms.prePayTime}</td></c:when>
                <c:otherwise> <td align="center">${sms.payTime}</td></c:otherwise>
         </c:choose>
                <td align="center">${sms.soID}</td>
                <c:choose>
                    <c:when test="${(sms.payType eq '预付款到发货') && (sms.status eq '3')}"><td align="center">${sms.soTotal}</td><td align="center">${sms.payUser}</td></c:when>
                    <c:when test="${(sms.payType eq '预付款到发货') && (sms.status eq '7')}"><td align="center">${sms.prePayFee}</td><td align="center">${sms.prePayUser}</td></c:when>
                    <c:otherwise><td align="center">${sms.soTotal}</td><td align="center">${sms.payUser}</td></c:otherwise>
                </c:choose>
                <td align="center">${sms.payType}</td>

            </tr>
        </c:forEach>
    </c:if>

</table>
</body>
</html>
