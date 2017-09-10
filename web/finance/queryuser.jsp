<%--
  Created by IntelliJ IDEA.
  User: JerryCheng
  Date: 2017.7.10
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-1.8.1.min.js"></script>
    <link href="../css/style.css" rel="stylesheet" type="text/css">
    <script language="JavaScript" type="text/javascript">
        function update(obj) {
            var tds = obj.parentNode.parentNode.cells;
            var table = document.getElementById("modify");
            document.getElementsByName("username")[0].value = tds[0].innerHTML;
            document.getElementsByName("name")[0].value = tds[1].innerHTML;
            document.getElementsByName("password")[0].value = tds[2].innerHTML;
            document.getElementsByName("createDate")[0].value = tds[3].innerHTML;
            var sta=tds[4].innerHTML;
            if(sta=='1')
                document.getElementById("yes").checked=true;
            else
                document.getElementById("no").checked=true;

            var lims=tds[5].innerHTML.split(';');
            for(var i=0;i<lims.length;i++){
                if(lims[i]=="经理")
                    document.getElementById("manager").checked=true;
                if(lims[i]=="仓管")
                    document.getElementById("stocker").checked=true;
                if(lims[i]=="采购")
                    document.getElementById("buyer").checked=true;
                if(lims[i]=="财务")
                    document.getElementById("accounter").checked=true;
            }
            document.getElementById("table").style.display = "none";
            document.getElementById("modifyForm").style.display = "block";

        }

       function re() {
            document.getElementById("table").style.display = "block";
            document.getElementById("modifyForm").style.display = "none";
        }
        function change() {
            window.location="../finance/adduser.jsp";
        }

        function tan(obj) {
            var httpRequest = new XMLHttpRequest();
            var account = obj.parentNode.parentNode.cells[0].innerHTML;
            httpRequest.open("get", "../financeservlet/DeleteUser?account=" + account, true);
            httpRequest.send(null);

            httpRequest.onreadystatechange = function () {
                if (httpRequest.readyState == 4 && httpRequest.status == 200) {
                    var text = httpRequest.responseText;
                    alert(text);
                    window.location = "../financeservlet/QueryUser";
                }
        }
}

    </script>
</head>
<body>
<c:if test="${requestScope.flag eq 'success'}"><script language="JavaScript" type="text/javascript">alert("添加成功");</script></c:if>
<c:if test="${requestScope.flag eq 'fail'}"><script language="JavaScript" type="text/javascript">alert("添加失败");</script></c:if>
<c:if test="${requestScope.updateflag eq 'success'}"><script language="JavaScript" type="text/javascript">alert("修改成功");</script></c:if>
<c:if test="${requestScope.updateflag eq 'fail'}"><script language="JavaScript" type="text/javascript">alert("修改失败");</script></c:if>
<table width="100%" border="0" cellpadding="0" cellspacing="0" id="m">
    <tr>
        <td nowrap class="title1">您的位置：工作台面－－用户管理</td>
    </tr>
</table>
<div id="table">
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td width="30px" nowrap class="toolbar">&nbsp;</td>
            <td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)"
            onClick="change()"><img src="../images/new.gif">新增
            </td>
            <td width="20px" nowrap class="toolbar">|</td>
            <td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="query()">
                <img src="../images/search.gif">查询
            </td>

        </tr>
    </table>
    <table width="100%" border="0" align="center" cellspacing="1" class="c">
        <tr>
            <td class="title1">用户账号</td>
            <td class="title1">用户姓名</td>
            <td class="title1">用户密码</td>
            <td class="title1">添加日期</td>
            <td class="title1">锁定状态</td>
            <td class="title1">用户权限列表</td>
            <td class="title1">操作</td>
        </tr>
        <c:forEach items="${requestScope.userpage.data}" var="user">
            <tr>
                <td align="center">${user.account}</td>
                <td align="center">${user.name}</td>
                <td align="center">${user.password}</td>
                <td align="center">${user.createDate}</td>
                <td align="center">${user.status}</td>
                <td align="center">${user.limits}</td>
                <td align="center"><a href="#" onClick="update(this)">修改</a> <a onclick="tan(this)" style="cursor: pointer;">删除</a></td>
            </tr>
        </c:forEach>
    </table>

    <div style="float:right">
    <c:choose>
        <c:when test="${requestScope.userpage.currentPage==1 }">
            <a href="../financeservlet/QueryUser?page=${userpage.currentPage+1 }">下一页</a>
            <a href="../financeservlet/QueryUser?page=${userpage.totalPage }">末页</a>
        </c:when>
        <c:when test="${userpage.currentPage==userpage.totalPage }">
            <a href="../financeservlet/QueryUser?page=1">首页</a>
            <a href="../financeservlet/QueryUser?page=${userpage.currentPage-1 }">上一页</a>
        </c:when>
        <c:otherwise>
            <a href="../financeservlet/QueryUser?page=1">首页</a>
            <a href="../financeservlet/QueryUser?page=${userpage.currentPage-1 }">上一页</a>
            <a href="../financeservlet/QueryUser?page=${userpage.currentPage+1 }">下一页</a>
            <a href="../financeservlet/QueryUser?page=${userpage.totalPage }">末页</a>
        </c:otherwise>
    </c:choose>
        当前第${userpage.currentPage }页/共${userpage.totalPage }页
        特定页 <input id="pages" style="width: auto" type="number" size="1" min="1" max="${userpage.totalPage }"/> <input type="button" value="Go" onclick="window.location.href='../financeservlet/QueryUser?page='+document.getElementById('pages').value"/>
    </div>
</div>

<form id="modifyForm" action="../financeservlet/ModifyUser" method="post" style="display: none">
    <table id="modify" width="100%" border="0" align="center" cellspacing="1" class="c">
        <tr>
            <td align="center">用户名</td>
            <td align="center"><input type="text" name="username" readonly></td>
        </tr>
        <tr>
            <td align="center">姓名</td>
            <td align="center"><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td align="center">密码</td>
            <td align="center"><input type="text" name="password"/></td>
        </tr>
        <tr>
            <td align="center">添加日期</td>
            <td align="center">
                <input type="date" name="createDate"> <span class="requred_symbol">*</span>
            </td>
        </tr>
        <tr>
            <td align="center">锁定状态</td>
            <td align="center"><input id="yes" type="radio" name="status" value="1"/>是 <input id="no" type="radio" name="status" value="0"/>否</td>
        </tr>
        <tr>
            <td align="center">用户权限</td>
            <td align="center">
                <input id="manager" type="checkbox" name="limits" value="经理"/>经理
                <input id="buyer" type="checkbox" name="limits" value="采购"/>采购
                <input id="stocker" type="checkbox" name="limits" value="仓管"/>仓管
                <input id="accounter" type="checkbox" name="limits" value="财务"/>财务
            </td>
        </tr>
        <tr>
            <td height="18" colspan="2" align="center"><input type="reset"/> <input type="submit" value="保存"
                                                                                    onClick="re()"/></td>
        </tr>
    </table>
</form>

</body>
</html>