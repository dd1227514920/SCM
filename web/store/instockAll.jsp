<%--
  Created by IntelliJ IDEA.
  User: leo
  Date: 2017/7/11
  Time: 下午3:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
    <link href="../css/style.css" rel="stylesheet" type="text/css">
    <script language="javascript" src="../script/common.js"></script>
    <script>
        function getDetails(obj) {
            document.getElementById("POID").value=obj.innerHTML;
            document.getElementById("POForm").submit();
        }

//        function stock(obj) {
//            var flag=window.confirm("确定要入库吗？");
//            if(flag==true){
//                document.getElementById("stock").value=obj.parentNode.parentNode.cells[0].childNodes[0].innerHTML
//                document.getElementById("stockForm").submit();
//            }
//        }

        function getPO1() {
            window.location="../storeServlet/ShowPO1Servlet";
        }
        function getPO2() {
            window.location="../storeServlet/ShowPO2Servlet";
        }
        function getPO3() {
            window.location="../storeServlet/ShowPO3Servlet";
        }

        function message() {
            if("${requestScope.stockinfo}"=="入库成功"){
                alert("入库成功");
            }else if("${requestScope.stockinfo}"=="入库失败"){
                alert("入库失败");
            }
        }


    </script>

</head>
<body onload="message()">
<div id="POMain">
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td nowrap class="title1">您的位置：工作台面－－入库登记</td>
    </tr>
</table>
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td width="30px" nowrap class="toolbar">&nbsp;</td>
        <td nowrap class="toolbar">&nbsp;</td>
        <td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)">&nbsp;</td>
        <td width="20px" nowrap class="toolbar">|</td>
        <td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)"><a onclick="getPO1()">款到发货</a></td>
        <td width="20px" nowrap class="toolbar">|</td>
        <td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)"><a onclick="getPO2()">预付款到发货</a></td>
        <td width="20px" nowrap class="toolbar">|</td>
        <td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)"><a onclick="getPO3()">货到付款</a></td>
        <td width="20px" nowrap class="toolbar">|</td>
    </tr>
</table>
<table width="100%"  border="0" align="center" cellspacing="1">
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
    </tr>

    <c:forEach items="${requestScope.POMain}" var="po">
        <tr>
            <td align="center"><a href="#" onclick="getDetails(this)">${po.poID}</a></td>
            <td align="center">${po.createTime}</td>
            <td align="center">${po.venderCode}</td>
            <td align="center">${po.account}</td>
            <td align="center">${po.tipFee}</td>
            <td align="center">${po.productTotal}</td>
            <td align="center">${po.poTotal}</td>
            <td align="center">${po.payType}</td>
            <td align="center">${po.prePayFee}</td>
            <td align="center">${po.status}</td>
        <%--<td align="center"><a href="#" onclick="stock(this)">入库</a></td>--%>
        </tr>
    </c:forEach>



    <tr>
        <td class="title2"></td>
    </tr>
</table>
</div>

<%--得到POID跳转servlet进行操作--%>
<form action="../storeServlet/GetStockDetailsServlet"  id="POForm" method="post" style="display: none">
    <input type="hidden" id="POID" name="POID">
</form>

<%--入库操作--%>
<%--<form action="../inStockServlet" method="post" id="stockForm" style="display: none">--%>
    <%--<input type="hidden" id="stock" name="stock">--%>
<%--</form>--%>

</body>
</html>
