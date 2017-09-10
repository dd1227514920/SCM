<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>销售单查询queryDetailedSale</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="m">
		<table width="100%" border="0" cellpadding="0" cellspacing="0" id="m">
			<tr>
				<td nowrap class="title1">您的位置：工作台面－－销售单管理－－销售单查询</td>
			</tr>
		</table>
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="40px" nowrap class="toolbar"><img
					src="../images/search.gif" /><span onclick="queryPrecisely()">精确查询</span>
				</td>
				<td width="40px" nowrap class="toolbar"><img
					src="../images/search.gif" /><span onclick="queryAll()">查询全部</span>
				</td>
			</tr>
		</table>
		<table width="100%" border="0" align="center" cellspacing="1"
			class="c">
			<tr>
				<td align="center">销售单编号<input type="text" name="i1" id="i1">&nbsp;&nbsp;&nbsp;&nbsp;
					起始时间<input type="month" name="i2" id="i2">&nbsp;&nbsp;&nbsp;&nbsp;结束时间<input
					type="month" name="i6" id="i6" /><br />客户编号<input type="text"
					onclick="chooseCustomer()" name="i3" id="i3" />&nbsp;&nbsp;&nbsp;&nbsp;付款方式
					<input type="text" name="i4" id="i4">&nbsp;&nbsp;&nbsp;&nbsp;处理状态
					<input type="text" name="i5" id="i5">
				</td>
			</tr>
		</table>
	</div>
	<iframe width=174 height=189 name="gToday:normal:agenda.js"
		id="gToday:normal:agenda.js" src="../common/calendar/ipopeng.htm"
		scrolling="no" frameborder="0"
		style="visibility:visible; z-index:999; position:absolute; left:-500px; top:0px;"></iframe>
	<!-- 客户选择 -->
	<div id="chooseCustomer" style="display: none">
		<label for="customerCode">客户编号：</label><input id="customerCode"
			type="text" list="codes" value="" placeholder="点击选择客户" />
		<datalist id="codes"> <c:forEach
			items="${requestScope.customerAll}" var="customer">
			<option>${customer.customerCode} ${customer.name}</option>
		</c:forEach> </datalist>
		<br /> <br /> <input type="button" value="确定"
			onclick="confirmChooseCustomer()" />&nbsp;&nbsp;&nbsp;&nbsp;<input
			type="button" value="取消" onclick="cancelChooseCustomer()" />
	</div>
	<form id="queryPrecisely" action="/sales/SomainDetailedQueryServlet"
		method="post">
		<input type="hidden" id="h1" name="h1" /><input type="hidden" id="h2"
			name="h2" /><input type="hidden" id="h3" name="h3" /><input
			type="hidden" id="h4" name="h4" /><input type="hidden" id="h5"
			name="h5" /><input type="hidden" id="h6" name="h6" />
	</form>
	<form id="queryAll" action="/sales/SomainQueryServlet" method="post"></form>
	<script type="text/javascript" src="../script/common.js"></script>
	<script type="text/javascript" src="../script/sales.js"></script>
</body>
</html>
