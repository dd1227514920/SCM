<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
<title>提货</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="../script/common.js" ></script>
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
		window.showModalDialog("../common/cxtj.htm", params, "dialogHeight:400px; dialogWidth:600px; help:no; status:no");
	}
	
	
	function update(){
		document.getElementById("m").style.display="none";
		document.getElementById("add").style.display="block";
		}
	function re(){
		document.getElementById("m").style.display="block";
		document.getElementById("add").style.display="none";
		}
		
		
</script>
</head>

<body>
<div id="m">
<table width="100%"  border="0" cellpadding="0" cellspacing="0" id="m">
  <tr>
    <td nowrap class="title1">您的位置：工作台面－－提货管理</td>
  </tr>
</table>
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="30px" nowrap class="toolbar">&nbsp;</td>
    <td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="window.open('th_detail.jsp')"><img src="../images/new.gif">新增</td>
    <td width="20px" nowrap class="toolbar">|</td>
    <td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="query()"><img src="../images/search.gif">查询</td>
	<td nowrap class="toolbar">&nbsp;</td>
    <td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)">&nbsp;</td>
    <td width="20px" nowrap class="toolbar">&nbsp;</td>
    <td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)">&nbsp;</td>
    <td width="20px" nowrap class="toolbar">&nbsp;</td>
    <td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)">&nbsp;</td>
    <td width="20px" nowrap class="toolbar">&nbsp;</td>
    <td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)">&nbsp;</td>
    <td width="20px" nowrap class="toolbar">&nbsp;</td>
  </tr>
</table>
<table width="100%"  border="0" align="center" cellspacing="1" class="c">
  <tr>
    <td class="title1">&nbsp;</td>
  </tr>
</table>
</div>
<div id="add" >
	<table width="100%"  border="0" align="center" cellspacing="1" class="c">
  <tr>
    <td class="title1">用户账号</td>
    <td class="title1">用户姓名</td>
	</tr>
  <tr>
    <td align="center">分类序号</td>
    <td align="center"><input type="text"/></td>
	</tr>
  <tr>
    <td align="center">名称</td>
    <td align="center"><input type="text"/></td>
	</tr>
  <tr>
    <td align="center">描述</td>
    <td align="center"><input type="text"/></td>
	</tr>
  <tr>
    <td height="18" colspan="2" align="center"><input type="reset"/> <input type="button" value="保存" onClick="re()"/></td>
  </tr>
</table>


</div>

<iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="../common/calendar/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; left:-500px; top:0px;"></iframe>
</body>
</html>
