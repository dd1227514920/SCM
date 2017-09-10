<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<title>提货</title>

<link href="../css/style.css" rel="stylesheet" type="text/css">
      <script type="text/javascript" src="/purchase/js/jquery-1.8.1.min.js"></script>
<script language="javascript" src="../script/common.js"></script>
<script language="javascript" type="text/javascript">
	function query() {
		var params = new Object();
		var bm = new Array(8);
		bm[0] = "bdbh";
		bm[1] = "zt";
		bm[2] = "jzrq";
		bm[3] = "tdr";
		bm[4] = "strq";
		bm[5] = "tdrq";
		bm[6] = "lrrq";
		bm[7] = "lry";
		var mc = new Array(8);
		mc[0] = "表单编号";
		mc[1] = "表单状态";
		mc[2] = "截止日期";
		mc[3] = "填单人";
		mc[4] = "实提日期";
		mc[5] = "填单日期";
		mc[6] = "录入日期";
		mc[7] = "录入员";
		params.bm = bm;
		params.mc = mc;
		params.actionUrl = "";
		window.showModalDialog("common/cxtj.htm", params, "dialogHeight:400px; dialogWidth:600px; help:no; status:no");
	}
	function add(){
			var obj2=document.getElementById("adddialog");
			obj2.style.display="block";
			var obj3=document.getElementById("updatedialog");
			obj3.style.display="none";
			
			
			var da = new Date();
			var year=da.getFullYear();
			var mon=da.getMonth()+1;
			var day=da.getDate();
			var hour=da.getHours();
			var min=da.getMinutes();
			var sec=da.getSeconds();
			if(mon<10){
			mon="0"+mon;
			}
			if(day<10){
			day="0"+day;
			}
			if(hour<10){
			hour="0"+hour;
			}
			if(min<10){
			min="0"+min;
			}
			if(sec<10){
			sec="0"+sec;
			}
			var obj5 = document.getElementsByName("createdate");
			obj5[0].value=year+"-"+mon+"-"+day+" "+hour+":"+min+":"+sec;
	}
	function cancel(){
			var obj2=document.getElementById("adddialog");
			obj2.style.display="none";
			var obj3=document.getElementById("updatedialog");
			obj3.style.display="none";
	}
	function update(obj){
			var obj2=document.getElementById("adddialog");
			obj2.style.display="none";
			var obj3=document.getElementById("updatedialog");
			obj3.style.display="block";
			
			document.getElementsByName("vendercode2")[0].value=obj.parentNode.parentNode.cells[0].innerHTML;
			document.getElementsByName("name2")[0].value=obj.parentNode.parentNode.cells[1].innerHTML;
			document.getElementsByName("password2")[0].value="";
			document.getElementsByName("contactor2")[0].value=obj.parentNode.parentNode.cells[2].innerHTML;
			document.getElementsByName("address2")[0].value=obj.parentNode.parentNode.cells[3].innerHTML;
			document.getElementsByName("postcode2")[0].value=obj.parentNode.parentNode.cells[4].innerHTML;
			document.getElementsByName("createdate2")[0].value=obj.parentNode.parentNode.cells[5].innerHTML;
			document.getElementsByName("tel2")[0].value=obj.parentNode.parentNode.cells[6].innerHTML;
			document.getElementsByName("fax2")[0].value=obj.parentNode.parentNode.cells[7].innerHTML;
			
			
	}
	function deleted(obj){
		var flag = window.confirm("确定要删除吗？");
		if(flag){
			var vendercode = obj.parentNode.parentNode.cells[0].innerHTML;
			window.location ="../purchaseservlet/VVenderDeletedServlet?vendercode="+vendercode;
		}
	}
	function ongo(){
	var currentp=document.getElementById("currentp").value;
	window.location="../purchaseservlet/VenderServlet?page="+currentp;
	}
</script>
</head>

<body>
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td nowrap class="title1">您的位置：工作台面－－供应商管理</td>
  </tr>
</table>
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    
    <td width="20px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="add()"><img src="../images/new.gif">新增</td>
    <td width="100px" nowrap class="toolbar">&nbsp;</td>
    <td width="100px" nowrap class="toolbar">&nbsp;</td>
    <td width="100px" nowrap class="toolbar">&nbsp;</td>
    <td width="100px" nowrap class="toolbar">&nbsp;</td>
  </tr>
</table>
<table width="100%"  border="0" align="center" cellspacing="1">
  <tr>
    <td class="title1">供应商编号</td>
    <td class="title1">供应商名称</td>
	<td class="title1">联系人</td>
	<td class="title1">地址</td>
    <td class="title1">邮政编码</td>
 
    <td class="title1">注册日期</td>
    <td class="title1">电话</td>
    <td class="title1">传真</td>
    <td class="title1">操作</td>
  </tr>
  <c:forEach items="${venderPage.data }" var="ven">
  <tr>
    <td align="center">${ven.venderCode}</td>
    <td align="center">${ven.name}</td>
	<td align="center">${ven.contactor}</td>
	<td align="center">${ven.address}</td>
    <td align="center">${ven.postCode}</td>
    <td align="center">${ven.createDate}</td>
    <td align="center">${ven.tel }</td>
    <td align="center">${ven.fax }</td>
    <td align="center"><a onclick="update(this)">修改</a> <a onclick="deleted(this)">删除</a> </td>
  </tr>
  </c:forEach>
  <tr>
  	<td class="title2"></td>
  </tr>
</table>
<div style="display:none" id="adddialog">
<form action="../purchaseservlet/VenderAddServlet" method=post>
<table width=100% border=0>
<tr>
<td width="50%" align="right">供应商编号:</td><td  width="50%"><input name="vendercode"></td>
</tr>
<tr>
<td width="50%" align="right">供应商姓名:</td><td width="50%" ><input name="name"></td>
</tr>
<tr>
<td width="50%" align="right">供应商密码:</td><td width="50%" ><input name="password"></td>
</tr>
<tr>
<td width="50%" align="right">联系人:</td><td width="50%" ><input name="contactor"></td>
</tr>
<tr>
<td width="50%" align="right">地址:</td><td width="50%" ><input name="address"></td>
</tr>
<tr>
<td width="50%" align="right">邮政编码:</td><td width="50%"><input name="postcode"></td>
</tr>
<tr>
<td width="50%" align="right">注册日期:</td><td width="50%"><input name="createdate"></td>
</tr>
<tr>
<td width="50%" align="right">电话:</td><td width="50%" ><input name="tel"></td>
</tr>
<tr>
<td width="50%" align="right">传真:</td><td width="50%" ><input name="fax"></td>
</tr>
<tr>
<td width="50%" align="right"><input type="submit" value="保存"/></td><td width="50%"><input type="reset" value = "取消" onclick="cancel()"></td>
</tr>
</table>
</form>
</div>

<div style="display:none" id="updatedialog">
<form action="../purchaseservlet/VenderUpdateServlet" method=post>
<table width=100% border=0>
<tr>
<td width="50%" align="right">供应商编号:</td><td  width="50%"><input name="vendercode2" readonly="readonly"></td>
</tr>
<tr>
<td width="50%" align="right">供应商姓名:</td><td width="50%" ><input name="name2"></td>
</tr>
<tr>
<td width="50%" align="right">供应商密码:</td><td width="50%" ><input name="password2"></td>
</tr>
<tr>
<td width="50%" align="right">联系人:</td><td width="50%" ><input name="contactor2"></td>
</tr>
<tr>
<td width="50%" align="right">地址:</td><td width="50%" ><input name="address2"></td>
</tr>
<tr>
<td width="50%" align="right">邮政编码:</td><td width="50%"><input name="postcode2"></td>
</tr>
<tr>
<td width="50%" align="right">注册日期:</td><td width="50%"><input name="createdate2"></td>
</tr>
<tr>
<td width="50%" align="right">电话:</td><td width="50%" ><input name="tel2"></td>
</tr>
<tr>
<td width="50%" align="right">传真:</td><td width="50%" ><input name="fax2"></td>
</tr>
<tr>
<td width="50%" align="right"><input type="submit" value="保存"/></td><td width="50%"><input type="reset" value = "取消" onclick="cancel()"></td>
</tr>
</table>
</form>
</div>
<c:if test="${not empty requestScope.message}"><script language="JavaScript" type="text/javascript">alert('${message}');</script></c:if>

<c:choose>
    	<c:when test="${venderPage.currentPage==1 }">
		    <a href="../purchaseservlet/VenderServlet?page=${venderPage.currentPage+1 }">下一页</a>
		    <a href="../purchaseservlet/VenderServlet?page=${venderPage.totalPage }">末页</a>
    	</c:when>
    	<c:when test="${venderPage.currentPage==venderPage.totalPage }">
		    <a href="../purchaseservlet/VenderServlet?page=1">首页</a>
		    <a href="../purchaseservlet/VenderServlet?page=${venderPage.currentPage-1 }">上一页</a>
    	</c:when>
    	<c:otherwise>
		    <a href="../purchaseservlet/VenderServlet?page=1">首页</a>
		    <a href="../purchaseservlet/VenderServlet?page=${venderPage.currentPage-1 }">上一页</a>
		    <a href="../purchaseservlet/VenderServlet?page=${venderPage.currentPage+1 }">下一页</a>
		    <a href="../purchaseservlet/VenderServlet?page=${venderPage.totalPage }">末页</a>
    	</c:otherwise>
    </c:choose>
 
    当前第${venderPage.currentPage }页/共${venderPage.totalPage }页
特定页 <input type="number" size="1" min="1" max="${venderPage.totalPage }" id="currentp"/> <input type="button" value="Go" onclick="ongo()"/>
</body>
</html>
