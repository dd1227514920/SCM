<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script/common.js"></script>
<title>标题</title>
<SCRIPT language=JavaScript>
	<!--
function closeAlert() {
	question = confirm("您要退出系统，确定吗？");
  	if (question != "0"){
        <%--${sessionScope.remove("username")};--%>
        parent.close();
  	}
}

function login() {
    this.parent.location="login.jsp";
}

function loginout() {
    this.parent.location="LoginOutServlet";
}


	//-->
</SCRIPT>
</head>

<body topmargin=0 leftmargin=0>
<table width="100%" border="0" align="right" cellpadding="0" cellspacing="0" height="25">

<c:choose >
  <c:when test="${empty sessionScope.username}">
    <tr>
      <td class="toolbar">&nbsp;</td>
      <td class="toolbar" width="45px" onMouseOver="OMO()" onMouseOut="OMOU()" style="cursor: hand" onclick="login()">
        <img src="images/jrxt.jpg" border="0">登录</td>
      <td width="20px" nowrap class="toolbar">|</td>
      <td class="toolbar" width="45px" onMouseOver="OMO()" onMouseOut="OMOU()" style="cursor: hand" onClick="closeAlert()">
        <img src="images/lkxt.jpg" border="0">离开</td>
      <td width="20px" nowrap class="toolbar">|</td>
    </tr>
  </c:when>

  <c:when test="${not empty sessionScope.username}">
    <tr>
      <td style="text-align: right" width="20px" nowrap class="toolbar">欢迎，${sessionScope.username}&nbsp;&nbsp;&nbsp;<img src="images/lkxt.jpg"><span onclick=loginout() style="cursor: hand">退出登录</span></td>
    </tr>
  </c:when>
</c:choose>

</table>
</body>
</html>
