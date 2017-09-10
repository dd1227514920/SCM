<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>销售单修改sale_detaile</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../css/style.css" rel="stylesheet" type="text/css">
<style type="text/css">
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
<div></div>
<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td nowrap class="title1">您的位置：工作台面－－销售管理－－销售单修改</td>
		</tr>
	</table>
	<div class="formVisiblitly" id="formDiv"></div>
	<form action="/sales/UpdateServlet" name="mainFrm" id="edition">
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="30px" nowrap class="toolbar">&nbsp;</td>
				<td width="70px" nowrap class="toolbar" onMouseOver="OMO(event)"
					onMouseOut="OMOU(event)" onClick="document.mainFrm.mx.click()"><img
					src="../images/add.gif">增加明细</td>
				<td width="20px" nowrap class="toolbar">|</td>
				<td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)"
					onMouseOut="OMOU(event)" onClick="document.mainFrm.bc.click()"><img
					src="../images/save.gif">保存</td>
				<td width="20px" nowrap class="toolbar">|</td>

				<td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)"
					onMouseOut="OMOU(event)" onClick="document.mainFrm.gb.click()"><img
					src="../images/cancel.gif">关闭</td>
				<td nowrap class="toolbar">&nbsp;</td>
			</tr>
		</table>
		<table id="headTable" width="100%" border="0" align="center"
			class="a1">
			<tr align="justify">
				<td>销售单编号</td>
				<td><input type="text" size="15" name="soid"
					value="${requestScope.somain.soid }" readonly="readonly" /> <span
					class="requred_symbol">*</span></td>
				<td>创建时间</td>
				<td><input type="text" size="15" name="createTime"
					value="${requestScope.somain.createTime }" readonly="readonly" />
					<span class="requred_symbol">*</span></td>
				<td>客户编号</td>
				<td><input type="text" size="15" name="customerCode"
					onclick="chooseCustomer()"
					value="${requestScope.somain.customerCode }" /> <span
					class="requred_symbol">*</span></td>
				<td>创建用户</td>
				<td><input name="account" type="text" size="15"
					value="${requestScope.somain.account }" readonly="readonly" /> <span
					class="requred_symbol">*</span></td>
			</tr>
			<tr align="justify">
				<td>附加费用</td>
				<td><input type="text" size="15" name="tipFee"
					value="${requestScope.somain.tipFee }" /> <span
					class="requred_symbol">*</span></td>
				<td>产品总价</td>
				<td><input type="text" size="15" name="productTotal"
					value="${requestScope.somain.productTotal }" readonly="readonly" /></td>
				<td>付款方式</td>
				<td><input name="payType" list="payType" size="15"
					placeholder="点击选择付款方式" value="${requestScope.somain.payType }"
					onchange="choosePayType()" /> <datalist id="payType">
					<option>货到付款</option>
					<option>预付款到发货</option>
					<option>款到发货</option>
					</datalist></td>
				<td>最低预付款金额</td>
				<td><input type="text" size="15" name="prePayFee"
					value="${requestScope.somain.prePayFee }" readonly="readonly" /></td>
			</tr>
			<tr>
				<td>备注</td>
				<td colspan="3"><input name="remark" type="text" size="100"
					value="${requestScope.somain.remark }" /></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</table>
		<table width="100%" border="0" align="center" cellspacing="1"
			id="detailTable">
			<tr>
				<td width="10px"></td>
				<td class="toolbar">产品编号</td>
				<td class="toolbar">产品名称</td>
				<td class="toolbar">产品单价</td>
				<td class="toolbar">产品数量</td>
				<td class="toolbar">数量单位</td>
				<td class="toolbar">明细总价</td>
				<td class="toolbar">&nbsp;</td>
			</tr>
			<c:forEach items="${requestScope.soitemList}" var="Soitem"
				varStatus="status">
				<tr>
					<td align="center">${status.index + 1}</td>
					<td align="center"><input type="text" readonly="readonly"
						name="productCode" value=${Soitem.productCode } /></td>
					<td align="center"><input type="text" readonly="readonly"
						name="name" value=${Soitem.name } } /></td>
					<td align="center"><input type="text" name="unitPrice"
						readonly="readonly" value=${Soitem.unitPrice }
						onchange='itemPrice_auto(this)' /></td>
					<td align="center"><input type="text" name="num"
						value=${Soitem.num } onchange='itemPrice_auto(this)' /><input
						type="hidden" name="num_before" value=${Soitem.num } /></td>
					<td align="center"><input type="text" readonly="readonly"
						name="unitName" value=${Soitem.unitName } readonly="readonly" /></td>
					<td align="center"><input type="text" readonly="readonly"
						name="itemPrice" value=${Soitem.itemPrice } /></td>
					<td align="center"><image style='cursor:pointer'
							src='../images/delete.gif' class='LL'
							onclick='deleteThisRow(this)' /></td>
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
			<input type="button" id="mx" value="增加明细" onClick="addItem()" />&nbsp;&nbsp;<input
				type="button" id="bc" value="保存" onclick="dataTest()" />&nbsp;&nbsp;<input
				type="button" id="gb" value="关闭" onClick="window.close()" />
		</div>
		<div id="productDiv" style="visibility: hidden;" class="product">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td width="30px" nowrap="nowrap" nowrap="nowrap"
						class="toolbar">&nbsp;</td>
					<td width="40px" nowrap="nowrap" class="toolbar"
						onMouseOver="OMO(event)" onMouseOut="OMOU(event)"
						onClick="choiceAnonymous('productDiv');productCode_norepeat()"><img
						src="../images/confirm.gif">确定</td>
					<td width="20px" nowrap="nowrap" class="toolbar">|</td>
					<td width="40px" nowrap="nowrap" class="toolbar"
						onMouseOver="OMO(event)" onMouseOut="OMOU(event)"
						onClick="hiddenDiv();cancelChooseProduct()"><img
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
				</tr>
				<tr>
					<td class="title2"></td>
				</tr>
			</table>
		</div>
	</form>
	<!-- 客户选择 -->
	<div id="chooseCustomer"
		style="display: none;background-color: #dbeaf5;width:250px;height:60px;margin: 50px auto;">
		<label for="customerCode">客户编号：</label><input id="customerCode"
			type="text" list="codes" value="" placeholder="点击选择客户" />
		<datalist id="codes"> <c:forEach
			items="${requestScope.customerAll}" var="customer">
			<option>${customer.customerCode} ${customer.name}</option>
		</c:forEach> </datalist>
		<br /> <br /> <input type="button" value="确定"
			onclick="confirmChooseCustomer1()" />&nbsp;&nbsp;&nbsp;&nbsp;<input
			type="button" value="取消" onclick="cancelChooseCustomer()" />
	</div>
	<iframe width=174 height=189 name="gToday:normal:agenda.js"
		id="gToday:normal:agenda.js" src="../common/calendar/ipopeng.htm"
		scrolling="no" frameborder="0"
		style="visibility:visible; z-index:999; position:absolute; left:-500px; top:0px;"></iframe>
	<form id="dsoitem" action="/sales/DeleteServlet_1" method="post">
		<input type="hidden" name="dsoitem_soid" /> <input type="hidden"
			name="dsoitem1" /> <input type="hidden" name="dsoitem2" /><input
			type="hidden" name="productTotal_new" />
	</form>
	<script type="text/javascript" src="../script/common.js"></script>
	<script type="text/javascript" src="../script/sales.js"></script>
</body>
</html>