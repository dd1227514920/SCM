<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>销售单查询querySale</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="m">
		<table width="100%" border="0" cellpadding="0" cellspacing="0" id="m1">
			<tr>
				<td nowrap class="title1">您的位置：工作台面－－销售管理－－销售单查询</td>
			</tr>
		</table>
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="30px" nowrap class="toolbar">&nbsp;</td>
				<td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)"
					onMouseOut="OMOU(event)" onClick="showSoitem()"><img
					src="../images/new.gif" />明细</td>
				<td width="20px" nowrap class="toolbar">|</td>
				<td width="40px" nowrap class="toolbar"><img
					src="../images/search.gif" /><a
					href="/sales/CustomerQueryServlet_2">查询</a></td>
				<td nowrap class="toolbar">&nbsp;</td>
			</tr>
		</table>
		<table width="100%" border="0" align="center" cellspacing="1"
			class="c">
			<tr>
				<td class="title1">选中</td>
				<td class="title1">销售单编号</td>
				<td class="title1">创建时间</td>
				<td class="title1">客户编号</td>
				<td class="title1">创建用户</td>
				<td class="title1">附加费用</td>
				<td class="title1">产品总价</td>
				<td class="title1">付款方式</td>
				<td class="title1">最低预付款金额</td>
				<td class="title1">处理状态</td>
				<td class="title1">操作</td>
			</tr>
			<c:forEach items="${requestScope.somainMatched}" var="somain">
				<tr>
					<td align="center" onclick="chooseSale(this)" class="choose"></td>
					<td align="center" onclick="chooseSale(this)">${somain.soid}</td>
					<td align="center" onclick="chooseSale(this)">${somain.createTime}</td>
					<td align="center" onclick="chooseSale(this)">${somain.customerCode}</td>
					<td align="center" onclick="chooseSale(this)">${somain.account}</td>
					<td align="center" onclick="chooseSale(this)">${somain.tipFee}</td>
					<td align="center" onclick="chooseSale(this)">${somain.productTotal}</td>
					<td align="center" onclick="chooseSale(this)">${somain.payType}</td>
					<td align="center" onclick="chooseSale(this)">${somain.prePayFee}</td>
					<td align="center" onclick="chooseSale(this)">${somain.status}</td>
					<td align="center" onclick="chooseSale(this)"><span
						onclick="getVar(this)">修改</span> <span
						onclick="deleteSomain(this)">删除</span></td>
				</tr>
			</c:forEach>
			<c:forEach items="${requestScope.somainList}" var="somain">
				<tr>
					<td align="center" onclick="chooseSale(this)" class="choose"></td>
					<td align="center" onclick="chooseSale(this)">${somain.soid}</td>
					<td align="center" onclick="chooseSale(this)">${somain.createTime}</td>
					<td align="center" onclick="chooseSale(this)">${somain.customerCode}</td>
					<td align="center" onclick="chooseSale(this)">${somain.account}</td>
					<td align="center" onclick="chooseSale(this)">${somain.tipFee}</td>
					<td align="center" onclick="chooseSale(this)">${somain.productTotal}</td>
					<td align="center" onclick="chooseSale(this)">${somain.payType}</td>
					<td align="center" onclick="chooseSale(this)">${somain.prePayFee}</td>
					<td align="center" onclick="chooseSale(this)">${somain.status}</td>
					<td align="center" onclick="chooseSale(this)"><span
						onclick="getVar(this)">修改</span> <span
						onclick="deleteSomain(this)">删除</span></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<form id="hidden_form" action="/sales/SomainQueryOneServlet"
		method="post">
		<input id="hidden_soid" name="hidden_soid" type="hidden" />
	</form>
	<form id="showSoitem" action="/sales/SomainQueryOneServlet_1"
		method="post">
		<input type="hidden" id="soid_checked" name="soid_checked" />
	</form>
	<form id="deleteSomain" action="/sales/DeleteServlet" method="post">
		<input type="hidden" id="somain_checked" name="somain_checked" />
	</form>
	<script type="text/javascript" src="../script/common.js"></script>
	<script type="text/javascript" src="../script/sales.js"></script>
</body>
</html>