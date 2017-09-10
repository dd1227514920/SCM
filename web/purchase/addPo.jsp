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
	var no=0;
	var ii;
	var posum=0.0;
	var pot=0.0;
	var tipf=0.0;
	var rowlength; //每行多少个单元
	var spxxTable;
	var rowlength2;
	var venderTable;
	var rowIndex;
	function addPoitem(){
		no=no+1;
		$("#poitem tr:last-child").after("<tr name="+no+"><td align=center>"+no+"</td><td align=center><input readonly='readonly' type='text' name='productCode"+no+"'><img onClick='changediv(this)' style='cursor:hand' src='../images/selectDate.gif'></td><td align=center><input readonly='readonly' type='text' name='productName"+no+"'></td><td align=center><input readonly='readonly' type='text' name='unitName"+no+"'></td><td align=center><input readonly='readonly' type='text' name='unitPrice"+no+"'></td><td align=center><input value='0' onchange='sum(this)' type='text' name='num"+no+"'></td><td align=center><input readonly='readonly' type='text' value='0' name='itemPrice"+no+"'></td><td align=center><span onClick='deleted(this)' style='cursor:hand'>×</span></td></tr>");
		$("input[name=max]").attr("value",no);
	}

	function load(){
	rowlength = document.getElementById("spxxTable").rows[0].cells.length;
	rowlength2 = document.getElementById("venderTable").rows[0].cells.length;
	spxxTable = document.getElementById("spxxTable");
	venderTable = document.getElementById("venderTable");
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
			var obj5 = document.getElementsByName("poId");
			obj5[0].value=year+""+mon+""+day+""+hour+""+min+""+sec;
			var obj6 = document.getElementsByName("createTime");
			obj6[0].value=year+"-"+mon+"-"+day;
	}
	function changediv(obj){
		$("#maindiv").attr("style","display:none");
		$("#productitem").attr("style","display:block");
		ii=obj.parentNode.parentNode.cells[0].innerHTML;
	}
	function changediv2(obj){
		$("#maindiv").attr("style","display:none");
		$("#vender").attr("style","display:block");
		//ii=obj.parentNode.parentNode.cells[0].innerHTML;
	}
	function hiddenDiv2(){
		$("#maindiv").attr("style","display:block");
		$("#vender").attr("style","display:none");
	}
	function selectItem2(tr) {
	clearTable2();
	tr.cells[0].innerHTML = "\u221a";
	var tds = tr.cells;
	for (var j = 0; j < tds.length; j += 1) {
		tds[j].style.backgroundColor = "#C1CDD8";
		}
	}
	function clearTable2() {
		var trs = venderTable.rows;
		for (var i = 1; i < trs.length - 1; i += 1) {
			trs[i].cells[0].innerHTML = "";
			var tds = trs[i].cells;
			for (var j = 0; j < tds.length; j += 1) {
				tds[j].style.backgroundColor = "#fff7e5";
			}
		}
	}
	function choice2(index) {
		var row = document.getElementById("venderTable").rows[index];
		var result = new Array(rowlength2);
		var i;
		for (i = 1; i < rowlength2; i++) {
			result[i - 1] = row.cells[i].innerHTML;
		}
		return result;
	}
	function choiceAnonymous2() {
		var len = venderTable.rows.length;
		var returnValue;
		var i;
		var j;
	//	var t = document.getElementById("poitem").rows;
		for (i = 1; i < len - 1; i++) {
			if (venderTable.rows[i].cells[0].innerHTML == "\u221a") {
				returnValue = choice2(i);
				setValue();
				hiddenDiv2();
				return;	
				}
		}
		alert("\u8bf7\u5148\u9009\u62e9\u5546\u54c1");
		function setValue() {
			var pomainTable = document.getElementById("pomaintable");
		//	var length = pomainTable.rows.length;
			var i0=returnValue[0];
			var i1=returnValue[1];
			$("input[name=venderCode]").attr("value",i0+"-------"+i1);
		}
	}
	function deleted(obj){
		var flag = window.confirm("确定要删除吗？");
		if(flag){
			ii=obj.parentNode.parentNode.cells[0].innerHTML;
			$("#poitem tr[name="+ii+"]").remove();
			posum=0.0;
			var x=document.getElementById("poitem").rows.length-1;
		var i;
		for(i=1;i<=x;i++){
		posum+=parseInt($("#poitem tr:eq("+i+") td:eq(6) > input").attr("value"));}
		$("input[name=productTotal]").attr("value",posum);
		$("input[name=poTotal]").attr("value",tipf+posum);
		}
	}
	function sum(obj){
	//	var num=obj
	posum=0.0;
	var reg=/^[0-9]+$/;
		ii=obj.parentNode.parentNode.cells[0].innerHTML;
		var num=$("input[name=num"+ii+"]").attr("value");
		var res = reg.test(num);
		if(res==false){
			alert("请输入数字！");
			$("input[name=num"+ii+"]").attr("value",0);
			num=$("input[name=num"+ii+"]").attr("value");
		}
		var price=$("input[name=unitPrice"+ii+"]").attr("value");
		$("input[name=itemPrice"+ii+"]").attr("value",num*price);
		var x=document.getElementById("poitem").rows.length-1;
		var i;
		for(i=1;i<=x;i++){
		posum+=parseInt($("#poitem tr:eq("+i+") td:eq(6) > input").attr("value"));}
		$("input[name=productTotal]").attr("value",posum);
		tipf=parseInt($("input[name=tipFee]").attr("value"));
		posum=parseInt($("input[name=productTotal]").attr("value"));
		$("input[name=poTotal]").attr("value",tipf+posum);
	}
	function setpot(){
		tipf=parseInt($("input[name=tipFee]").attr("value"));
		var reg=/^[0-9]+$/;
		var res = reg.test(tipf);
		if(res==false){
			alert("请输入数字！");
			$("input[name=tipFee]").attr("value",0);
			tipf=parseInt($("input[name=tipFee]").attr("value"));
		}
		posum=parseInt($("input[name=productTotal]").attr("value"));
		$("input[name=poTotal]").attr("value",tipf+posum);
	}
	function hiddenDiv(){
		$("#maindiv").attr("style","display:block");
		$("#productitem").attr("style","display:none");
	}
	function selectItem(tr) {
	clearTable();
	tr.cells[0].innerHTML = "\u221a";
	var tds = tr.cells;
	for (var j = 0; j < tds.length; j += 1) {
		tds[j].style.backgroundColor = "#C1CDD8";
		}
	}
	
	function clearTable() {
		var trs = spxxTable.rows;
		for (var i = 1; i < trs.length - 1; i += 1) {
			trs[i].cells[0].innerHTML = "";
			var tds = trs[i].cells;
			for (var j = 0; j < tds.length; j += 1) {
				tds[j].style.backgroundColor = "#fff7e5";
			}
		}
	
	}
	function choice(index) {
		var row = document.getElementById("spxxTable").rows[index];
		var result = new Array(rowlength);
		var i;
		for (i = 1; i < rowlength; i++) {
			result[i - 1] = row.cells[i].innerHTML;
		}
		return result;
	}
	function choiceAnonymous() {
		var len = spxxTable.rows.length;
		var returnValue;
		var i;
		var j;
		var t = document.getElementById("poitem").rows;
		for (i = 1; i < len - 1; i++) {
			if (spxxTable.rows[i].cells[0].innerHTML == "\u221a") {
				for(j=1;j<t.length;j++){
					if(spxxTable.rows[i].cells[1].innerHTML==$("#poitem tr:eq("+j+") td:eq(1) input").attr("value")){
						alert("不可选择重复商品");
						return;
					}
				}
				returnValue = choice(i);
				setValue();
				hiddenDiv();
				return;
			}
		}
		alert("\u8bf7\u5148\u9009\u62e9\u5546\u54c1");
		function setValue() {
			var detailTable = document.getElementById("poitem");
			var length = detailTable.rows.length;
			var i0=returnValue[0];
			var i1=returnValue[1];
			var i2=returnValue[2];
			var i3=returnValue[3];
			$("input[name='productCode"+ii+"']").attr("value",i0);
			$("input[name='productName"+ii+"']").attr("value",i1);
			$("input[name='unitName"+ii+"']").attr("value",i2);
			$("input[name='unitPrice"+ii+"']").attr("value",i3);

		}
	}
	function yufukuan(){
		if($("select[name='payType'] option:selected").text()=="预付款到发货"){
			$("input[name='prePayFee']").removeAttr("readonly");
		}
		else{
		$("input[name='prePayFee']").attr("readonly","readonly");
		}
	}
	function zhengze(){
		var yufukuan=parseInt($("input[name=prePayFee]").attr("value"));
		var reg=/^[0-9]+$/;
		var res = reg.test(yufukuan);
		if(res==false){
			alert("请输入数字！");
			$("input[name=prePayFee]").attr("value",0);
			return;
		}
	}
	function baocun(){
	var i;
	var x=document.getElementById("poitem").rows.length-1;
	var code=$("input[name=venderCode]").attr("value");
	code=code.split("-")[0];
	//alert(code);
	$("input[name=venderCode]").attr("value",code);
	for(i=1;i<=x;i++){
	if($("#poitem tr:eq("+i+") td:eq(1) > input").attr("value")==""){
	alert("产品不能为空");
	return;
		}
		document.getElementById("pomain").submit();
	}
	}
</script>
</head>

<body onload="load()">
<div id="maindiv">
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td nowrap class="title1">您的位置：采购管理－－新增采购单</td>
  </tr>
</table>
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    
    <td width="25px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="addPoitem()"><img src="../images/new.gif">增加明细</td>
    <td width="100px" nowrap class="toolbar">&nbsp;</td>
    <td width="100px" nowrap class="toolbar">&nbsp;</td>
    <td width="100px" nowrap class="toolbar">&nbsp;</td>
    <td width="100px" nowrap class="toolbar">&nbsp;</td>
  </tr>
</table>
<form action="../purchaseservlet/PomainSaveServlet" method="post" id="pomain">
<table width="100%"  border="0" align="center" cellspacing="1" id="pomaintable">
  <tr>
    <td class="title1">采购单编号</td>
    <td class="title1"><input type="text" readonly="readonly" name="poId"></td>
	<td class="title1">供应商</td>
	<%-- <td class="title1"><select name="venderCode"><c:forEach items="${vList }" var="vender"><option value="${vender.venderCode }">${vender.name }</option></c:forEach></select></td> --%>
	<td class="title1"><input name="venderCode" readonly="readonly"><img onClick='changediv2(this)' style='cursor:hand' src='../images/selectDate.gif'></td>
    <td class="title1">创建用户</td>
    <td class="title1"><input type="text" name="account" value="${sessionScope.username}"></td>
    <td class="title1">付款类型</td>
    <td class="title1"><select name="payType" onchange="yufukuan()"><option>货到付款</option><option>款到发货</option><option>预付款到发货</option></select></td>
<!--     <td class="title1">操作</td> -->
  </tr>
  <tr>
      <td class="title1">附加费用</td>
    <td class="title1"><input type="text" name="tipFee" value="0" onchange="setpot()"></td>
        <td class="title1">采购产品总价</td>
    <td class="title1"><input type="text" name="productTotal" value="0" readonly="readonly"></td>
        <td class="title1">采购单总价</td>
    <td class="title1"><input type="text" name="poTotal" value="0" readonly="readonly"></td>
        <td class="title1">预付款</td>
    <td class="title1"><input type="text" name="prePayFee" value="0" readonly="readonly" onchange="zhengze()"></td>
  </tr>
  <tr>
      <td class="title1">采购单状态</td>
    <td class="title1"><input type="text" name="status" value="1" readonly="readonly"></td>
    <td class="title1">创建时间</td>
    <td class="title1"><input type="text" name="createTime" readonly="readonly"></td>
    <td class="title1" colspan="4" >备注<input size="100" type="text" name="remark"></td>
  </tr>
  <tr>
  	<td class="title2"></td>
  </tr>
</table>
<table width="100%"  border="0" cellpadding="0" cellspacing="0" id="poitem">
	<tr>
	<th nowrap class="toolbar">序号</th>
	<th nowrap class="toolbar">产品编号</th>
	<th nowrap class="toolbar">产品名称</th>
	<th nowrap class="toolbar">单位</th>
	<th nowrap class="toolbar">单价</th>
	<th nowrap class="toolbar">数量</th>
	<th nowrap class="toolbar">总价</th>
	<th nowrap class="toolbar">操作</th>
	</tr>
</table>
<input type="hidden" name=max value="0">
<input type="button" value="保存" onclick="baocun()"/>
</form>
</div>
<div id="productitem" style="display:none">
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
	  <tr>
	    <td width="30px" nowrap="nowrap" class="toolbar">&nbsp;</td>
	    <td width="40px" nowrap="nowrap" class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="choiceAnonymous('productitem')"><img src="../images/confirm.gif">确定</td>
	    <td width="20px" nowrap="nowrap" class="toolbar">|</td>
	    <td width="40px" nowrap="nowrap" class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="hiddenDiv()"><img src="../images/cancel.gif">取消</td>
		<td align="center" valign="middle" nowrap="nowrap" class="toolbar">&nbsp;</td>
	  </tr>
	</table>
	<table width="100%"  border="0" align="center" cellspacing="1" class="a1" id="spxxTable">
	  <tr>
	    <td class="title1">选择</td>
	    <td class="title1">产品编号</td>
	    <td class="title1">产品名称</td>
	    <td class="title1">单位</td>
	    <td class="title1">单价</td>
	  </tr>
	  <c:forEach items="${pdList }" var="product">
	  <tr onClick="selectItem(this)" onMouseOver="OMO1(event)" align="center">
	    <td>&nbsp;</td>
	    <td>${product.productCode }</td>
	    <td>${product.name }</td>
	    <td>${product.unitName }</td>
	    <td>${product.price }</td>
	  </tr>
	  </c:forEach>  
	   <tr>
	    <td class="title2"></td>
	  </tr>
	</table>
</div>
<div id="vender" style="display:none">
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
	  <tr>
	    <td width="30px" nowrap="nowrap" class="toolbar">&nbsp;</td>
	    <td width="40px" nowrap="nowrap" class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="choiceAnonymous2('vender')"><img src="../images/confirm.gif">确定</td>
	    <td width="20px" nowrap="nowrap" class="toolbar">|</td>
	    <td width="40px" nowrap="nowrap" class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="hiddenDiv2()"><img src="../images/cancel.gif">取消</td>
		<td align="center" valign="middle" nowrap="nowrap" class="toolbar">&nbsp;</td>
	  </tr>
	</table>
	<table width="100%"  border="0" align="center" cellspacing="1" class="a1" id="venderTable">
	  <tr>
	    <td class="title1">选择</td>
	    <td class="title1">供应商编号</td>
	    <td class="title1">供应商名称</td>
	  </tr>
	  <c:forEach items="${vList }" var="vender">
	  <tr onClick="selectItem2(this)" onMouseOver="OMO1(event)" align="center">
	    <td>&nbsp;</td>
	    <td>${vender.venderCode }</td>
	    <td>${vender.name }</td>
	  </tr>
	  </c:forEach>  
	   <tr>
	    <td class="title2"></td>
	  </tr>
	</table>
</div>
</body>
</html>