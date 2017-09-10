<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>销售单查询</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="../script/common.js"></script>
</head>
<body>
	<div id="m">
		<table width="100%" border="0" cellpadding="0" cellspacing="0" id="m1">
			<tr>
				<td nowrap class="title1">您的位置：工作台面－－销售单查询</td>
			</tr>
		</table>
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="30px" nowrap class="toolbar">&nbsp;</td>
				<td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)"
					onMouseOut="OMOU(event)" onClick="window.open('th_detail.htm')"><img
					src="../images/new.gif" />新增</td>
				<td width="20px" nowrap class="toolbar">|</td>
				<td width="40px" nowrap class="toolbar"><img
					src="../images/search.gif" /><a href="querygoods.htm">查询</a></td>
				<td nowrap class="toolbar">&nbsp;</td>
				<td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)"
					onMouseOut="OMOU(event)">&nbsp;</td>
				<td width="20px" nowrap class="toolbar">&nbsp;</td>
				<td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)"
					onMouseOut="OMOU(event)">&nbsp;</td>
				<td width="20px" nowrap class="toolbar">&nbsp;</td>
				<td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)"
					onMouseOut="OMOU(event)">&nbsp;</td>
				<td width="20px" nowrap class="toolbar">&nbsp;</td>
				<td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)"
					onMouseOut="OMOU(event)">&nbsp;</td>
				<td width="20px" nowrap class="toolbar">&nbsp;</td>
			</tr>
		</table>
		<table width="100%" border="0" align="center" cellspacing="1"
			class="c">
			<tr>
				<td class="title1">销售单编号</td>
				<td class="title1">创建时间</td>
				<td class="title1">客户名称</td>
				<td class="title1">创建用户</td>
				<td class="title1">附加费用</td>
				<td class="title1">产品总价</td>
				<td class="title1">付款方式</td>
				<td class="title1">最低预付款金额</td>
				<td class="title1">操作</td>
			</tr>
			<c:forEach items="${requestScope.somainAll}" var="Somain">
				<tr>
					<td align="center">${Somain.soid}</td>
					<td align="center">${Somain.createTime}</td>
					<td align="center">${Somain.customerCode}</td>
					<td align="center">${Somain.account}</td>
					<td align="center">${Somain.tipFee}</td>
					<td align="center">${Somain.productTotal}</td>
					<td align="center">${Somain.payType}</td>
					<td align="center">${Somain.prePayFee}</td>
					<td align="center"><a href="th_detail.htm" target="_blank">修改</a>
						<a href="#">删除</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
