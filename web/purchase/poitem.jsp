<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
	function deleted(obj){
		var flag = window.confirm("确定要删除吗？");
		if(flag){
			var vendercode = obj.parentNode.parentNode.cells[0].innerHTML;
			window.location ="purchase/deleted?vendercode="+vendercode;
		}
	}

</script>
</head>

<body>
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td nowrap class="title1">您的位置：采购管理－－采购明细</td>
  </tr>
</table>
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    

    <td width="20px" nowrap class="toolbar">|</td> -->
  </tr>
</table>
<table width="100%"  border="0" align="center" cellspacing="1">
  <tr>
    <td class="title1">序号</td>
    <td class="title1">产品编号</td>
	<td class="title1">产品名称</td>
	<td class="title1">单位</td>
    <td class="title1">单价</td>
    <td class="title1">数量</td>
    <td class="title1">总价</td>
<!--     <td class="title1">操作</td> -->
  </tr>
  <c:set var="order" value="0"></c:set>
  <c:forEach items="${piList }" var="poitem">
  <c:set var="order" value="${order+1}"></c:set>
  <tr>
	<td align="center">${order }</td>
    <td align="center">${poitem.productCode}</td>
    <c:set var="proname" value=""></c:set>
    <c:forEach items="${prList }" var="product">
    <c:if test="${poitem.productCode==product.productCode}">
    <c:set var="proname" value="${product.name }"></c:set>
    </c:if>
    </c:forEach>
    <td align="center">${proname }</td>
    <td align="center">${poitem.unitName}</td>
    <td align="center">${poitem.unitPrice}</td>
    <td align="center">${poitem.num}</td>
    <td align="center">${poitem.itemPrice}</td>
  </tr>
  </c:forEach>
  <tr>
  	<td class="title2"></td>
  </tr>
</table>
</body>
</html>
