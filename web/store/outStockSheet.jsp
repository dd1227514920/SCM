<%--
  Created by IntelliJ IDEA.
  User: leo
  Date: 2017/7/14
  Time: 下午3:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link href="../css/style.css" rel="stylesheet" type="text/css">
    <script src="../script/jquery-1.8.1.min.js"></script>
    <script language="javascript" src="../script/common.js" ></script>
    <script type="text/javascript" src="../script/productDiv.js" ></script>
    <script language="javascript" type="text/javascript">
    function get() {
        var dateMin=$("#date1").val();
        var dateMax=$("#date2").val();
        window.location="../storeServlet/outStockSheetServlet?DateMin="+dateMin+"&DateMax="+dateMax;
    }

    </script>
</head>

<body>
<div id="m">
    <table width="100%"  border="0" cellpadding="0" cellspacing="0" id="m">
        <tr>
            <td nowrap class="title1">您的位置：工作台面－－出库报表</td>
        </tr>

    </table >
    <table width="100%"  border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td width="40px" nowrap class="toolbar">请选择您要查询的时间范围:<input type="month" id="date1">&nbsp;<input type="date" id="date2">&nbsp;&nbsp;&nbsp;<img src="../images/search.gif"><a onclick="get()" style="cursor: hand">查询</a></td>

        </tr>

    </table>
</div>

<c:if test="${not empty outStockSheet}">
<div>
    <table width="100%"  border="0" align="center" cellspacing="1" class="c">
        <tr>
            <td class="title1">总单据数：${requestScope.size}</td>
            <td class="title1">总金额：￥${requestScope.money}</td>
            <td class="title1" colspan="6">时间：${requestScope.dateMin}</td>

        </tr>
        <tr>
            <td class="title1">序列号</td>
            <td class="title1">产品编号</td>
            <td class="title1">相关单据编号</td>
            <td class="title1">出库数量</td>
            <td class="title1">出库类型</td>
            <td class="title1">出库时间</td>
            <td class="title1">经手人</td>
        </tr>

        <c:forEach items="${outStockSheet}" var="outstock">
            <tr>
                <td align="center">${outstock.stockID}</td>
                <td align="center">${outstock.productCode}</td>
                <td align="center">${outstock.orderCode}</td>
                <td align="center">${outstock.stockNum}</td>
                <td align="center">${outstock.stockType}</td>
                <td align="center">${outstock.stockTime}</td>
                <td align="center">${outstock.createUser}</td>
            </tr>
        </c:forEach>


    </table>
</div>
</c:if>

</body>
</html>

