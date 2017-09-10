<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: JerryCheng
  Date: 2017.7.11
  Time: 9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>盘点</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link href="../css/style.css" rel="stylesheet" type="text/css">
    <script language="javascript" src="../script/common.js"></script>
    <script language="javascript" type="text/javascript">

        function query() {
            var params = new Object();
            var bm = new Array(8);
            bm[0] = "bdbh";
            bm[1] = "zt";
            bm[2] = "jzrq";
            bm[3] = "tdr";
            bm[4] = "strq";
            bm[5] = "tdrq";
            bm[6] = "lrrq";
            bm[7] = "lry";
            var mc = new Array(8);
            mc[0] = "表单编号";
            mc[1] = "表单状态";
            mc[2] = "截止日期";
            mc[3] = "填单人";
            mc[4] = "实提日期";
            mc[5] = "填单日期";
            mc[6] = "录入日期";
            mc[7] = "录入员";
            params.bm = bm;
            params.mc = mc;
            params.actionUrl = "";
            window.showModalDialog("../common/cxtj.htm", params, "dialogHeight:400px; dialogWidth:600px; help:no; status:no");
        }
    </script>
</head>

<body>
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td nowrap class="title1">您的位置：工作台面－－盘点管理</td>
    </tr>
</table>
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td width="30px" nowrap class="toolbar">&nbsp;</td>
        <td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="window.open('th_detail.htm')"><img src="../images/new.gif">新增</td>
        <td width="20px" nowrap class="toolbar">|</td>
        <td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="query()"><img src="../images/search.gif">查询</td>
        <td nowrap class="toolbar">&nbsp;</td>
        <td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)">未审核单据</td>
        <td width="20px" nowrap class="toolbar">|</td>
        <td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)">审核中单据</td>
        <td width="20px" nowrap class="toolbar">|</td>
        <td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)">已审核单据</td>
        <td width="20px" nowrap class="toolbar">|</td>
        <td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)">被退回单据</td>
        <td width="20px" nowrap class="toolbar">|</td>
    </tr>
</table>
<table width="100%"  border="0" align="center" cellspacing="1">
    <tr>
        <td class="title1">产品单编号</td>
        <td class="title1">产品名称</td>
        <td class="title1">当前库存</td>
        <td class="title1">采购在途数</td>
        <td class="title1">销售待发数</td>
        <td class="title1">操作</td>
    </tr>
    <c:forEach items="${sessionScope.products}" var="products">
        <tr>
            <td align="center">${products.productcode}</td>
            <td align="center">${products.name}</td>
            <td align="center">${products.num}</td>
            <td align="center">${products.ponum}</td>
            <td align="center">${products.sonum}</td>
            <td align="center"><a href="../financeservlet/ChangeCount?productcode=${products.productcode}">盘点</a></td>
        </tr>

    </c:forEach>



    <tr>
        <td class="title2"></td>
    </tr>
</table>
</body>
</html>
