<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>
<html>
<head>
<title>销售报表sale_sheet</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../script/common.js"></script>
<script type="text/javascript" src="../script/sales.js"></script>
</head>


<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td nowrap class="title1">您的位置：工作台面－－销售管理--客户管理</td>
		</tr>
	</table>
	<form action="/sales/SomainSheetQueryServlet" method="post" id="getSheet">
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="40px" nowrap align="center"><span>起始月：</span> <input
					type="month" name="start" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<span>结束月：</span> <input type="month" name="end" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
					type="button" value="查询报表" onclick="querySheet()" />
			</tr>
		</table>
	</form>
	<table style="width:100%;">
		<tr>
			<td class="title1">销售单编号</td>
			<td class="title1">创建时间</td>
			<td class="title1">客户编号</td>
			<td class="title1">创建用户</td>
			<td class="title1">附加费用</td>
			<td class="title1">产品总价</td>
			<td class="title1">付款方式</td>
			<td class="title1">最低预付款金额</td>
			<td class="title1">处理状态</td>
		</tr>
		<c:forEach items="${requestScope.somainList}" var="somain">
			<tr>
				<td align="center">${somain.soid}</td>
				<td align="center">${somain.createTime}</td>
				<td align="center">${somain.customerCode}</td>
				<td align="center">${somain.account}</td>
				<td align="center">${somain.tipFee}</td>
				<td align="center">${somain.productTotal}</td>
				<td align="center">${somain.payType}</td>
				<td align="center">${somain.prePayFee}</td>
				<td align="center">${somain.status}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5"></td>
			<td colspan="2">销售单条数：${requestScope.number }</td>
			<td colspan="2">产品总价：${requestScope.totalPrice }</td>
		</tr>
	</table>
	<br />
	<br />
	<table style="width:100%;">
		<tr>
			<td class="title1">销售单编号</td>
			<td class="title1">产品编号</td>
			<td class="title1">产品单价</td>
			<td class="title1">产品数量</td>
			<td class="title1">数量单位</td>
			<td class="title1">明细总价</td>
		</tr>
		<c:forEach items="${requestScope.soitemList}" var="soitem">
			<tr>
				<td align="center">${soitem.soid}</td>
				<td align="center">${soitem.productCode}</td>
				<td align="center">${soitem.unitPrice}</td>
				<td align="center">${soitem.num}</td>
				<td align="center">${soitem.unitName}</td>
				<td align="center">${soitem.itemPrice}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
