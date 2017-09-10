<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>销售单明细showSoitem</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="../css/style.css" />
<style type="text/css">
* {
	margin: 0px;
	padding: 0px;
}

div.product {
	position: absolute;
	top: 2px;
	left: 2px;
	width: 100%;
	height: 98%;
	background-color: #fffffe;
}
</style>
</head>
<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td nowrap class="title1">您的位置：工作台面－－销售管理－－销售单明细showSoitem</td>
		</tr>
	</table>
	<div class="formVisiblitly" id="formDiv"></div>
	<form action="/sales/SomainAddServlet" name="mainFrm" id="addSale">
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="30px" nowrap class="toolbar">&nbsp;</td>
				<td width="40px" nowrap class="toolbar" onmouseover="OMO(event)"
					onmouseout="OMOU(event)" onclick="document.mainFrm.gb.click()"><img
					src="../images/cancel.gif">关闭</td>
				<td nowrap class="toolbar">&nbsp;</td>
			</tr>
		</table>
		<table id="headTable" width="100%" border="0" align="center"
			class="a1">
			<tr align="justify">
				<td>销售单编号</td>
				<td><input type="text" size="15" name="soid"
					readonly="readonly" value="${requestScope.Somain_1.soid }" /> <span
					class="requred_symbol">*</span></td>
				<td>创建时间</td>
				<td><input type="text" size="15" name="createTime"
					readonly="readonly" value="${requestScope.Somain_1.createTime }" />
					<span class="requred_symbol">*</span></td>
				<td>客户名称</td>
				<td><input type="text" size="15" onclick="chooseCustomer()"
					name="customerCode" readonly="readonly"
					value="${requestScope.Somain_1.customerCode }" /> <span
					class="requred_symbol">*</span></td>
				<td>创建用户</td>
				<td><input name="textfield" type="text" size="15"
					name="account" readonly="readonly" readonly="readonly"
					value="${requestScope.Somain_1.account }" /> <span
					class="requred_symbol">*</span></td>
			</tr>
			<tr align="justify">
				<td>附加费用</td>
				<td><input type="text" size="15" name="tipFee"
					readonly="readonly" value="${requestScope.Somain_1.tipFee }" /> <span
					class="requred_symbol">*</span></td>
				<td>产品总价</td>
				<td><input type="text" size="15" name="productTotal"
					readonly="readonly" value="${requestScope.Somain_1.productTotal }" /></td>
				<td>付款方式</td>
				<td><input type="text" size="15" name="payType"
					readonly="readonly" readonly="readonly"
					value="${requestScope.Somain_1.payType }" /></td>
				<td>最低预付金额</td>
				<td><input type="text" size="15" name="prePayFee"
					readonly="readonly" value="${requestScope.Somain_1.prePayFee }" /></td>
			</tr>
			<tr>
				<td>备注</td>
				<td colspan="3"><input name="remark" type="text" size="100"
					readonly="readonly" value="${requestScope.Somain_1.remark }" /></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</table>
		<table width="100%" border="0" align="center" cellspacing="1"
			id="detailTable">
			<tr>
				<td class="toolbar">产品编号</td>
				<td class="toolbar">产品名称</td>
				<td class="toolbar">产品单价</td>
				<td class="toolbar">产品数量</td>
				<td class="toolbar">数量单位</td>
				<td class="toolbar">明细总价</td>
				<td class="toolbar">&nbsp;</td>
			</tr>
			<c:forEach items="${requestScope.soitemList_1}" var="soitem">
				<tr>
					<td align="center">${soitem.soid}</td>
					<td align="center">${soitem.name}</td>
					<td align="center">${soitem.unitPrice}</td>
					<td align="center">${soitem.num}</td>
					<td align="center">${soitem.unitName}</td>
					<td align="center">${soitem.itemPrice}</td>
				</tr>
			</c:forEach>
		</table>
		<table width="100%" border="0" align="center" cellspacing="1">
			<tr>
				<td class="title2"></td>
			</tr>
		</table>
		<br>
		<div align="center">
			<input type="button" id="gb" value="关闭" onclick="closeWindow()" />
		</div>
	</form>
	<iframe width=174 height=189 name="gToday:normal:agenda.js"
		id="gToday:normal:agenda.js" src="../common/calendar/ipopeng.htm"
		scrolling="no" frameborder="0"
		style="visibility:visible; z-index:999; position:absolute; left:-500px; top:0px;"></iframe>
	<script type="text/javascript" src="../script/common.js"></script>
	<script type="text/javascript" src="../script/sales.js"></script>
</body>
</html>