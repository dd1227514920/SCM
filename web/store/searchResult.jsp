<%--
  Created by IntelliJ IDEA.
  User: leo
  Date: 2017/7/14
  Time: 上午9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link href="../css/style.css" rel="stylesheet" type="text/css">
    <script language="javascript" src="../script/common.js" ></script>
    <script type="text/javascript" src="../script/productDiv.js" ></script>
    <script language="javascript" type="text/javascript">




    </script>
</head>

<body>
<div id="m1">
    <table width="100%"  border="0" cellpadding="0" cellspacing="0" id="m">
        <tr>
            <td nowrap class="title1">您的位置：工作台面－－库存查询</td>
        </tr>
    </table>

    <table width="100%"  border="0" align="center" cellspacing="1" class="c">
        <tr>
            <td class="title1">产品编号</td>
            <td class="title1">产品名称</td>
            <td class="title1">数量单位</td>
            <td class="title1">库存数</td>
        </tr>
        <c:forEach items="${requestScope.SearchResult}" var="result">
            <tr>
                <td align="center">${result.productCode}</td>
                <td align="center">${result.name}</td>
                <td align="center">${result.unitName}</td>
                <td align="center">${result.num}</td>
            </tr>
        </c:forEach>

    </table>
</div>


</body>
</html>
