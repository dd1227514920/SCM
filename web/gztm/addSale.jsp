<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>销售单添加addSale</title>
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
<body onload="init()">
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td nowrap class="title1">您的位置：工作台面－－销售管理－－销售单添加</td>
		</tr>
	</table>
	<div class="formVisiblitly" id="formDiv"></div>
	<form action="/sales/AddServlet" name="mainFrm" id="addSale">
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="30px" nowrap class="toolbar">&nbsp;</td>
				<td width="70px" nowrap class="toolbar" onmouseover="OMO(event)"
					onmouseout="OMOU(event)" onclick="document.mainFrm.mx.click()"><img
					src="../images/add.gif">增加明细</td>
				<td width="20px" nowrap class="toolbar">|</td>
				<td width="40px" nowrap class="toolbar" onmouseover="OMO(event)"
					onmouseout="OMOU(event)" onclick="document.mainFrm.bc.click()"><img
					src="../images/save.gif">保存</td>
				<td width="20px" nowrap class="toolbar">|</td>
				<td width="40px" nowrap class="toolbar" onmouseover="OMO(event)"
					onmouseout="OMOU(event)" onclick="reset()"><img
					src="../images/reset.gif">重置</td>
				<td width="20px" nowrap class="toolbar">|</td>
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
					readonly="readonly" /> <span class="requred_symbol">*</span></td>
				<td>创建时间</td>
				<td><input type="text" size="15" name="createTime"
					readonly="readonly" /> <span class="requred_symbol">*</span></td>
				<td>客户编号</td>
				<td><input type="text" size="15" onclick="chooseCustomer()"
					id="i3" name="customerCode" /> <span class="requred_symbol">*</span></td>
				<td>创建用户</td>
				<td><input type="text" size="15" name="account"
					value="${sessionScope.username }" readonly="readonly" /> <span
					class="requred_symbol">*</span></td>
			</tr>
			<tr align="justify">
				<td>附加费用</td>
				<td><input type="text" size="15" name="tipFee" value="0" /> <span
					class="requred_symbol">*</span></td>
				<td>产品总价</td>
				<td><input type="text" size="15" name="productTotal"
					readonly="readonly" /></td>
				<td>付款方式</td>
				<td><input name="payType" list="payType" size="15"
					placeholder="点击选择付款方式" onchange="choosePayType()" /> <datalist
						id="payType">
						<option>货到付款</option>
						<option>预付款到发货</option>
						<option>款到发货</option>
					</datalist></td>
				<td>最低预付金额</td>
				<td><input type="text" size="15" name="prePayFee" value="0"
					readonly="readonly" /></td>
			</tr>
			<tr>
				<td>备注</td>
				<td colspan="3"><input name="remark" type="text" size="100" /></td>
				<td>处理状态</td>
				<td><input name="status" type="text" size="15" /></td>
				<td></td>
				<td></td>
			</tr>
		</table>
		<table width="100%" border="0" align="center" cellspacing="1"
			id="detailTable">
			<tr>
				<td class="toolbar">&nbsp;</td>
				<td class="toolbar">产品编号</td>
				<td class="toolbar">产品名称</td>
				<td class="toolbar">产品单价</td>
				<td class="toolbar">产品数量</td>
				<td class="toolbar">数量单位</td>
				<td class="toolbar">明细总价</td>
				<td class="toolbar">&nbsp;</td>
			</tr>
		</table>
		<table width="100%" border="0" align="center" cellspacing="1">
			<tr>
				<td class="title2"></td>
			</tr>
		</table>
		<br>
		<div align="center">
			<input type="button" id="mx" value="增加明细" onclick="addItem()" /> <input
				type="button" id="bc" value="保存" onclick="check();" /> <input
				type="button" id="gb" value="关闭" onclick="closeWindow()" />
		</div>
		<div id="productDiv" style="visibility: hidden;" class="product">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td width="30px" nowrap="nowrap" ="nowrap="nowrap"
						" class="toolbar">&nbsp;</td>
					<td width="40px" nowrap="nowrap" class="toolbar"
						onmouseover="OMO(event)" onmouseout="OMOU(event)"
						onclick="choiceAnonymous();productCode_norepeat()"><img
						src="../images/confirm.gif">确定</td>
					<td width="20px" nowrap="nowrap" class="toolbar">|</td>
					<td width="40px" nowrap="nowrap" class="toolbar"
						onmouseover="OMO(event)" onmouseout="OMOU(event)"
						onclick="hiddenDiv();cancelChooseProduct()"><img
						src="../images/cancel.gif">取消</td>
					<td align="center" valign="middle" nowrap="nowrap" class="toolbar">&nbsp;</td>
				</tr>
			</table>
			<table width="100%" border="0" align="center" cellspacing="1"
				class="a1" id="spxxTable">
				<tr>
					<td class="title1">选择</td>
					<td class="title1">产品编号</td>
					<td class="title1">产品名称</td>
					<td class="title1">产品单价</td>
					<td class="title1">数量单位</td>
				</tr>
				<c:forEach items="${requestScope.productList }" var="product">
					<tr onclick="selectItem(this)" onmouseover="OMO1(event)"
						onDblClick="choice()" align="center">
						<td>&nbsp;</td>
						<td>${product.productCode }</td>
						<td>${product.name }</td>
						<td>${product.price }</td>
						<td>${product.unitName }</td>
					</tr>
				</c:forEach>
				<tr>
					<td class="title2"></td>
				</tr>
			</table>
		</div>
		<!-- 客户选择 -->
		<div id="chooseCustomer"
			style="display: none;background-color: #dbeaf5;width:250px;height:60px;margin: 50px auto;">
			<label for="customerCode">客户编号：</label><input id="customerCode"
				type="text" list="codes" value="" placeholder="点击选择客户" />
			<datalist id="codes">
				<c:forEach items="${requestScope.customerAll}" var="customer">
					<option>${customer.customerCode} ${customer.name}</option>
				</c:forEach>
			</datalist>
			<br /> <br /> <input type="button" value="确定"
				onclick="confirmChooseCustomer()" />&nbsp;&nbsp;&nbsp;&nbsp;<input
				type="button" value="取消" onclick="cancelChooseCustomer()" />
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