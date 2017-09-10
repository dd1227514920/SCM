<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>客户管理customer</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../css/style.css" rel="stylesheet" type="text/css">
<style type="text/css">
#addCustomer {
	display: none;
	width: 390px;
	margin: 100px auto;
	z-index: 9;
}

#queryCustomer {
	display: none;
}

#updateCustomer {
	width: 350px;
	margin: 100px auto;
	z-index: 9;
}

#dg {
	padding-top: 20px;
}
</style>
<script type="text/javascript" src="../script/common.js"></script>
<script type="text/javascript" src="../script/sales.js"></script>
<script type="text/javascript" src="../script/jquery-3.2.1.js"></script>
<script type="text/javascript" src="../script/sales_ajax.js"></script>
</head>
<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td nowrap class="title1">您的位置：工作台面－－销售管理--客户管理customer</td>
		</tr>
	</table>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="30px" nowrap class="toolbar">&nbsp;</td>
			<td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)"
				onMouseOut="OMOU(event)"
				onClick="showAddCustomer();createDate_auto()"><img
				src="../images/new.gif">新增</td>
			<td width="20px" nowrap class="toolbar">|</td>
			<td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)"
				onMouseOut="OMOU(event)" onClick="showQueryCustomer()"><img
				src="../images/search.gif">查询</td>
			<td nowrap class="toolbar">&nbsp;</td>
		</tr>
	</table>
	<form id="queryCustomer" method="post">
		<table width="100%" border="0" align="center" cellspacing="1"
			class="c">
			<tr>
				<td align="center">客户编号<input type="text" name="i1" id="i1" />&nbsp;&nbsp;&nbsp;&nbsp;
					客户名称<input type="text" name="i2" id="i2" />&nbsp;&nbsp;&nbsp;&nbsp;查询条件
					<input name="i3" id="i3" list="option" placeholder="点击选择查询条件">
					<datalist id="option">
					<option>and</option>
					<option>or</option>
					</datalist>&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="条件查询"
					onclick="queryCustomer()" />&nbsp;&nbsp;&nbsp;&nbsp;<input
					type="button" value="查询全部" onclick="queryCustomerAll()" />
				</td>
			</tr>
		</table>
	</form>
	<table width="100%" border="0" align="center" cellspacing="1"
		id="customerTable">
		<tr>
			<td class="title1">客户编号</td>
			<td class="title1">客户名称</td>
			<td class="title1">联系人</td>
			<td class="title1">地址</td>
			<td class="title1">邮政编码</td>
			<td class="title1">注册日期</td>
			<td class="title1">电话</td>
			<td class="title1">传真</td>
			<td class="title1">操作</td>
		</tr>
		<c:forEach items="${requestScope.customerList }" var="customer">
			<tr onclick="toggleChoose(event)" class="no">
				<td align="center" class="ci">${customer.customerCode }</td>
				<td align="center" class="ci">${customer.name }</td>
				<td align="center" class="ci">${customer.contactor }</td>
				<td align="center" class="ci">${customer.address }</td>
				<td align="center" class="ci">${customer.postcode }</td>
				<td align="center" class="ci">${customer.createDate }</td>
				<td align="center" class="ci">${customer.tel }</td>
				<td align="center" class="ci">${customer.fax }</td>
				<td align="center"><span onclick="modify(this)">修改</span> <span
					onclick="deleteCustomer(this);">删除</span></td>
			</tr>
		</c:forEach>
		<c:forEach items="${requestScope.customerPage.data }" var="customer">
			<tr>
				<td align="center" class="ci">${customer.customerCode }</td>
				<td align="center" class="ci">${customer.name }</td>
				<td align="center" class="ci">${customer.contactor }</td>
				<td align="center" class="ci">${customer.address }</td>
				<td align="center" class="ci">${customer.postcode }</td>
				<td align="center" class="ci">${customer.createDate }</td>
				<td align="center" class="ci">${customer.tel }</td>
				<td align="center" class="ci">${customer.fax }</td>
				<td align="center"><span onclick="modify(this)">修改</span> <span
					onclick="deleteCustomer(this);">删除</span></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="9" class="title2"><c:choose>
					<c:when test="${requestScope.customerPage.currentPage==1 }">
						<a
							href="../sales/CustomerQueryPageServlet?page=${requestScope.customerPage.currentPage+1 }">下一页</a>
						<a
							href="../sales/CustomerQueryPageServlet?page=${requestScope.customerPage.totalPage }">末页</a>
					</c:when>
					<c:when
						test="${requestScope.customerPage.currentPage==requestScope.customerPage.totalPage }">
						<a href="../sales/CustomerQueryPageServlet?page=1">首页</a>
						<a
							href="../sales/CustomerQueryPageServlet?page=${requestScope.customerPage.currentPage-1 }">上一页</a>
					</c:when>
					<c:otherwise>
						<a href="../sales/CustomerQueryPageServlet?page=1">首页</a>
						<a
							href="../sales/CustomerQueryPageServlet?page=${requestScope.customerPage.currentPage-1 }">上一页</a>
						<a
							href="../sales/CustomerQueryPageServlet?page=${requestScope.customerPage.currentPage+1 }">下一页</a>
						<a
							href="../sales/CustomerQueryPageServlet?page=${requestScope.customerPage.totalPage }">末页</a>
					</c:otherwise>
				</c:choose> 当前第${customerPage.currentPage }页/共${customerPage.totalPage }页 特定页 <input
				id="whichPage" type="text" size="2" />&nbsp;<input type="button"
				value="Go" onclick="go()" /></td>
		</tr>
	</table>
	<div align="center" id="dg" onclick="deleteCustomers()">
		<input type="button" value="批量删除" />
	</div>
	<form id="addCustomer" action="/sales/CustomerAddServlet"
		method="post">
		<table width="400px">
			<tr>
				<td>客户编号</td>
				<td><input type="text" name="customerCode" class="add"
					size="30" id="customerCode" placeholder="必填, 4~20位字母或数字"
					onblur="password_auto()" /></td>
			</tr>
			<tr>
				<td>客户名称</td>
				<td><input type="text" name="name" class="add" size="30"
					placeholder="必填，不超过100个字符" /></td>
			</tr>
			<tr>
				<td>客户密码</td>
				<td><input type="password" name="password" class="add"
					size="30" placeholder="初始密码为客户编号，4-20个字符" /></td>
			</tr>
			<tr>
				<td>联系人</td>
				<td><input type="text" name="contactor" class="add" size="30"
					placeholder="必填" /></td>
			</tr>
			<tr>
				<td>地址</td>
				<td><input type="text" name="address" class="add" size="30" /></td>
			</tr>
			<tr>
				<td>邮政编码</td>
				<td><input type="text" name="postcode" class="add" size="30" /></td>
			</tr>
			<tr>
				<td>注册日期</td>
				<td><input type="text" name="createDate" class="add" size="30"
					readonly="readonly" /></td>
			</tr>
			<tr>
				<td>电话</td>
				<td><input type="text" name="tel" class="add" size="30"
					placeholder="必填" /></td>
			</tr>
			<tr>
				<td>传真</td>
				<td><input type="text" name="fax" class="add" size="30" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="button" value="保存"
					onclick="confirmAddCustomer()" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
					type="button" value="取消" onclick="cancelAddCustomer()" /></td>
			</tr>
		</table>
	</form>
	<c:if test="${not empty requestScope.customer.customerCode }">
		<form id="updateCustomer" action="../sales/CustomerUpdateServlet"
			method="post">
			<table width="400px">
				<tr>
					<td>客户编号</td>
					<td><input type="text" name="customerCodeUpdate" size="30"
						readonly="readonly" value="${requestScope.customer.customerCode }"
						onblur="password_auto()" /></td>
				</tr>
				<tr>
					<td>客户名称</td>
					<td><input type="text" name="nameUpdate" size="30"
						value="${requestScope.customer.name }" placeholder="必填，不超过100个字符" /></td>
				</tr>
				<tr>
					<td>客户密码</td>
					<td><input type="password" name="passwordUpdate" size="30"
						value="${requestScope.customer.password }" placeholder="4-20个字符" /></td>
				</tr>
				<tr>
					<td>联系人</td>
					<td><input type="text" name="contactorUpdate" size="30"
						value="${requestScope.customer.contactor }" placeholder="必填" /></td>
				</tr>
				<tr>
					<td>地址</td>
					<td><input type="text" name="addressUpdate" size="30"
						value="${requestScope.customer.address }" /></td>
				</tr>
				<tr>
					<td>邮政编码</td>
					<td><input type="text" name="postcodeUpdate" size="30"
						value="${requestScope.customer.postcode }" /></td>
				</tr>
				<tr>
					<td>注册日期</td>
					<td><input type="text" name="createDateUpdate" size="30"
						value="${requestScope.customer.createDate }" readonly="readonly" /></td>
				</tr>
				<tr>
					<td>电话</td>
					<td><input type="text" name="telUpdate" size="30"
						value="${requestScope.customer.tel }" placeholder="必填" /></td>
				</tr>
				<tr>
					<td>传真</td>
					<td><input type="text" name="faxUpdate" size="30"
						value="${requestScope.customer.fax }" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="button" value="保存"
						onclick="confirmUpdateCustomer()" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
						type="button" value="取消" onclick="cancelUpdateCustomer()" /></td>
				</tr>
			</table>
		</form>
	</c:if>
	<form id="modify" action="../sales/CustomerQueryOneServlet"
		method="post">
		<input type="hidden" name="cc" />
	</form>
	<form id="delete" action="../sales/SomainQueryOneServlet_2"
		method="post">
		<input type="hidden" name="cc1" />
	</form>
	<form id="deletes" action="../sales/SomainQueryOneServlet_3"
		method="post">
		<input type="hidden" name="cc2" />
	</form>
	<script type="text/javascript">
		if ("${requestScope.deleteDone}" == "true") {
			alert("删除成功！");
		} else if ("${requestScope.deleteDone}" == "false") {
			alert("删除失败！");
		}
		if ("${requestScope.ifDone}" == "yes") {
			alert("批量删除成功！");
		} else if ("${requestScope.ifDone}" == "no") {
			alert("批量删除失败！");
		}
		if ("${requestScope.customerDuplicate}" == "yes") {
			alert("客户已存在，添加失败！");
		} else if ("${requestScope.customerDuplicate}" == "no") {
			alert("添加客户成功！");
		}
		if ("${requestScope.updateDone}" == "1") {
			alert("客户信息修改成功！");
		} else if ("${requestScope.updateDone}" == "0") {
			alert("客户信息修改失败！");
		}
	</script>
	<script type="text/javascript">
	function go() {
	var pageReg=/^[1-9]\d*$/;
	var page=document.getElementById("whichPage").value;
	var maxPage=parseInt(${requestScope.customerPage.totalPage });
	if(!pageReg.test(page)||page>maxPage){
		alert("输入不合法！");
		return;
	}else if(parseInt(page)<=maxPage||parseInt(page)>0){
	window.location = "../sales/CustomerQueryPageServlet?page=" +page ;
	}
}
	</script>
</body>
</html>