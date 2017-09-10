<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<title>提货</title>

<link href="../css/style.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="/purchase/js/jquery-1.8.1.min.js"></script>
<script language="javascript" src="../script/common.js"></script>
<script type="text/javascript" src="../script/productDiv.js" ></script>
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
	function deleted(obj){
		var flag = window.confirm("确定要删除吗？");
		if(flag){
			//var obj2 = obj.parentNode.parentNode.cells[0];
			var poId = $(obj).parent().parent().find("a").attr("name");
			window.location ="../purchaseservlet/PomainDeleteServlet?poId="+poId;
		}
	}
	function update(obj){
			var poId = $(obj).parent().parent().find("a").attr("name");
			window.location ="../purchaseservlet/PomainUpdateServlet?poId="+poId;
		
	}
	function test(){
		document.getElementById("con").style.display="block";
		}
</script>
</head>

<body>
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td nowrap class="title1">您的位置：采购管理－－采购单查询</td>
  </tr>
</table>
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    
    <td width="20px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="window.location.href='../purchaseservlet/PomainAddServlet'"><img src="../images/new.gif">新增</td>
    <td width="100px" nowrap class="toolbar">&nbsp;</td>
    <td width="100px" nowrap class="toolbar">&nbsp;</td>
    <td width="100px" nowrap class="toolbar">&nbsp;</td>
    <td width="100px" nowrap class="toolbar">&nbsp;</td>
  </tr>
</table>
<form accept="../purchaseservlet/PomainServlet" method="get">
  <table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr >
  <td class="title1">采购单编号<input type="text" name="poId"></td>
  <td class="title1">开始日期<input type="date" name="startTime">
  </td>
  <td class="title1">截止日期<input type="date" name="endTime">
  </td>
  </tr>
  <tr>
  <td class="title1">供应商<select name="venderCode"><option value="请选择供应商">请选择供应商</option><c:forEach items="${vList }" var="vender"><option value="${vender.venderCode }">${vender.name }</option></c:forEach></select></td>
  <td class="title1">付款方式<select name="payType"><option value="请选择">请选择</option><option value="货到付款">货到付款</option><option value="款到发货">款到发货</option><option value="预付款到发货">预付款到发货</option></select></td>
  </tr>
  <tr>
  <td colspan="3"  class="title1"><input type="submit" value="查询"><input type="reset" value="重置"></td>
  </tr>
</table>
</form>
<table width="100%"  border="0" align="center" cellspacing="1">
  <tr>
    <td class="title1">采购单编号</td>
    <td class="title1">创建时间</td>
	<td class="title1">创建用户</td>
	<td class="title1">供应商编号</td>
    <td class="title1">附加费用</td>
    <td class="title1">采购单总价</td>
    <td class="title1">商品总价</td>
    <td class="title1">付款方式</td>
    <td class="title1">最低预付款金额</td>
    <td class="title1">采购单状态</td>
    <td class="title1">操作</td>
  </tr>
  <c:forEach items="${pList }" var="pomain">
  <tr>
    <td align="center"><a href="../purchaseservlet/PoitemServlet?poId=${pomain.poId}" name="${pomain.poId}">${pomain.poId}</a></td>
    <td align="center">${pomain.createTime}</td>
	<td align="center">${pomain.account}</td>
	<td align="center">${pomain.venderCode}</td>
    <td align="center">${pomain.tipFee}</td>
    <td align="center">${pomain.productTotal}</td>
    <td align="center">${pomain.poTotal}</td>
    <td align="center">${pomain.payType}</td>
    <td align="center">${pomain.prePayFee}</td>
    <td align="center">${pomain.status}</td>
    <td align="center"><a onclick="update(this)">修改</a> <a onclick="deleted(this)">删除</a> </td>
  </tr>
  </c:forEach>
  <tr>
  	<td class="title2"></td>
  </tr>
</table>

<iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="common/calendar/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; left:-500px; top:0px;"></iframe>
</body>
</html>