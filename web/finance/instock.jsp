<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: JerryCheng
  Date: 2017.7.12
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>付款登记</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<c:if test="${requestScope.instockflag eq 'success'}"><script language="JavaScript" type="text/javascript">alert("付款成功");</script></c:if>
<c:if test="${requestScope.instockflag eq 'fail'}"><script language="JavaScript" type="text/javascript">alert("付款失败");</script></c:if>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td nowrap class="title1">您的位置：工作台面－－付款登记</td>
    </tr>
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td width="30px" nowrap class="toolbar">&nbsp;</td>
        <td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick=""><img
                src="../images/new.gif">新增
        </td>
        <td width="20px" nowrap class="toolbar">|</td>
        <td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="query()"><img
                src="../images/search.gif">查询
        </td>
        <td nowrap class="toolbar">&nbsp;</td>
        <td width="80px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)"><a
                href="../financeservlet/ChooseInStockStatus?paytype=预付款到发货">预付款到发货</a></td>
        <td width="20px" nowrap class="toolbar">|</td>
        <td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)"><a
                href="../financeservlet/ChooseInStockStatus?Status=1&paytype=款到发货">款到发货</a></td>
        <td width="20px" nowrap class="toolbar">|</td>
        <td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)"><a
                href="../financeservlet/ChooseInStockStatus?Status=2&paytype=货到付款">货到付款</a></td>
        <td width="20px" nowrap class="toolbar">|</td>
        <td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)"><a href="../financeservlet/InStock?">全部记录</a>
        </td>
        <td width="20px" nowrap class="toolbar">|</td>
    </tr>
</table>
<table width="100%" border="0" align="center" cellspacing="1">
    <tr>
        <td class="title1">采购单编号</td>
        <td class="title1">创建时间</td>
        <td class="title1">供应商名称</td>
        <td class="title1">创建用户</td>
        <td class="title1">附加费用</td>
        <td class="title1">采购产品总价格</td>
        <td class="title1">采购单总价格</td>
        <td class="title1">付款方式</td>
        <td class="title1">最低预付款金额</td>
        <td class="title1">处理状态</td>
        <td class="title1">操作</td>
    </tr>
    <c:forEach items="${sessionScope.pms}" var="pms">
        <tr>
            <td align="center"><a href="../financeservlet/QueryPoItem?Poid=${pms.poID}">${pms.poID}</td>
            <td align="center">${pms.createTime}</td>
            <td align="center">${pms.name}</td>
            <td align="center">${pms.account}</td>
            <td align="center">${pms.tipFee}</td>
            <td align="center">${pms.productTotal}</td>
            <td align="center">${pms.poTotal}</td>
            <td align="center">${pms.payType}</td>
            <td align="center">${pms.prePayFee}</td>
            <td align="center">${pms.status}</td>
            <c:choose>
                <c:when test="${pms.payType=='预付款到发货'}">
                    <c:if test="${pms.status==1}">
                        <td align="center"><a href="../financeservlet/Pay?status=5&poid=${pms.poID}" onclick= "return confirm('确定付款?');">付预付款</a></td>
                    </c:if>
                    <c:if test="${pms.status==2}">
                        <td align="center"><a href="../financeservlet/Pay?status=3&poid=${pms.poID}" onclick= "return confirm('确定付款?');">付余款</a></td>
                    </c:if>
                </c:when>
                <c:otherwise>
                    <td align="center"><a href="../financeservlet/Pay?status=3&poid=${pms.poID}" onclick= "return confirm('确定付款?');">付款</a></td>
                </c:otherwise>
            </c:choose>
        </tr>
    </c:forEach>

    <tr>
        <td class="title2"></td>
    </tr>
</table>
</body>
</html>
