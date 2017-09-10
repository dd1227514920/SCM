<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>login</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
    <script src="script/jquery-1.8.1.min.js"></script>
</head>
<body bgcolor="#ffffff" >

<form action="LoginServlet" method="post">
<table width="100%"  border="0"  >
	<tr>
		<td class="title1">&nbsp;</td>
	</tr>
  <tr>
    <td width="50%" align="right">用户名&nbsp;&nbsp;</td>
      <td width="50%"><input type="text" name="username" id="username"/><c:if test="${not empty requestScope.loginFailed }"><span id="message" style="color: red">${requestScope.loginFailed}</span></c:if></td>
  </tr>
  <tr>
    <td align="right">密码&nbsp;&nbsp;&nbsp;</td>
    <td><input type="password" name="password" id="password"/></td>
  </tr>
  <tr>
  	<td class="title1"><div align="right"><input type="submit" value="登录"/></div></td>
	<td class="title1"><div align="left"><input type="reset" value="重置"/></div></td>
  </tr>
</table>
</form>
</body>
</html>
