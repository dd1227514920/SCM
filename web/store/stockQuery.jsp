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
    <script src="../script/jquery-1.8.1.min.js"></script>
    <script language="javascript" src="../script/common.js" ></script>
    <script type="text/javascript" src="../script/productDiv.js" ></script>
    <script>
        function showDetails(obj) {
//            var productCode=$(obj).text();
            var productCode=obj.innerHTML;
            window.location="../storeServlet/StockDetailsServlet?ProductCode="+productCode;
        }

        function goSearch() {
            window.location="/store/queryDetailedStock.htm";
        }


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
        <td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="goSearch()"><img src="../images/new.gif">查询</td>
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
        <td class="title1">产品编号</td>
        <td class="title1">产品名称</td>
        <td class="title1">库存数量</td>
        <td class="title1">采购在途数</td>
        <td class="title1">预销售数</td>
    </tr>


    <c:forEach items="${requestScope.ProductStocks}" var="p">
        <tr>
            <td align="center" id="productCode"><a onclick="showDetails(this)" style="cursor: hand">${p.productCode}</a></td>
            <td align="center" id="name">${p.name}</td>
            <td align="center" id="num">${p.num}</td>
            <td align="center" id="PONum">${p.poNum}</td>
            <td align="center" id="SONum">${p.soNum}</td>
        </tr>
    </c:forEach>


</table>
</div>




</body>
</html>
