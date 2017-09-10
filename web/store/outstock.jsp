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
            document.getElementById("SOID").value=obj.innerHTML;
            document.getElementById("SOForm").submit();
        }

        function sale(obj) {
            var flag=window.confirm("确定要出库吗？");
            if(flag==true){
                document.getElementById("sale").value=obj.parentNode.parentNode.cells[0].childNodes[0].innerHTML
                document.getElementById("saleForm").submit();
            }
        }

        function getSO1() {
            window.location="../storeServlet/ShowSO1Servlet";
        }
        function getSO2() {
            window.location="../storeServlet/ShowSO2Servlet";
        }
        function getSO3() {
            window.location="../storeServlet/ShowSO3Servlet";
        }



    </script>

</head>
<body>
<div id="POMain">
    <table width="100%"  border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td nowrap class="title1">您的位置：工作台面－－出库登记</td>
        </tr>
    </table>
    <table width="100%"  border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td width="30px" nowrap class="toolbar">&nbsp;</td>
            <td nowrap class="toolbar">&nbsp;</td>
            <td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)">&nbsp;</td>
            <td width="20px" nowrap class="toolbar">|</td>
            <td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)"><a onclick="getSO1()">款到发货</a></td>
            <td width="20px" nowrap class="toolbar">|</td>
            <td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)"><a onclick="getSO2()">预付款到发货</a></td>
            <td width="20px" nowrap class="toolbar">|</td>
            <td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)"><a onclick="getSO3()">货到付款</a></td>
            <td width="20px" nowrap class="toolbar">|</td>
        </tr>
    </table>
    <table width="100%"  border="0" align="center" cellspacing="1">
        <tr>
            <td class="title1">销售单编号</td>
            <td class="title1">创建时间</td>
            <td class="title1">客户名称</td>
            <td class="title1">创建用户</td>
            <td class="title1">附加费用</td>
            <td class="title1">销售产品总价格</td>
            <td class="title1">付款方式</td>
            <td class="title1">最低预付款金额</td>
            <td class="title1">备注</td>
            <td class="title1">处理状态</td>
            <td class="title1">操作</td>
        </tr>
        <tr>
            <c:forEach items="${requestScope.SOMain}" var="so">
                <td align="center"><a href="#" onclick="getDetails(this)">${so.soid}</a></td>
                <td align="center">${so.createTime}</td>
                <td align="center">${so.customerCode}</td>
                <td align="center">${so.account}</td>
                <td align="center">${so.tipFee}</td>
                <td align="center">${so.productTotal}</td>
                <td align="center">${so.payType}</td>
                <td align="center">${so.prePayFee}</td>
                <td align="center">${so.remark}</td>
                <td align="center">${so.status}</td>
                <td align="center"><a href="#" onclick="sale(this)">出库</a></td>
            </c:forEach>

        </tr>

        <tr>
            <td class="title2"></td>
        </tr>
    </table>
</div>

<%--得到SOID跳转servlet进行操作--%>
<form action="../storeServlet/GetSaleDetailsServlet"  id="SOForm" method="post" style="display: none">
    <input type="hidden" id="SOID" name="SOID">
</form>

<%--出库操作--%>
<form action="../storeServlet/outStockServlet" method="post" id="saleForm" style="display: none">
<input type="hidden" id="sale" name="sale">
</form>

</body>
</html>
