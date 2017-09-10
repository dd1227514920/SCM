<%--Created by IntelliJ IDEA.
  User: leo
  Date: 2017/7/10
  Time: 上午10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
    <link href="../css/style.css" rel="stylesheet" type="text/css">
    <script language="javascript" src="../script/common.js" ></script>
    <script type="text/javascript" src="../script/productDiv.js" ></script>
    <script>
        function add(){
            window.location="/store/addGoodsClass.jsp";
        }

        function update(obj){
            document.getElementById("m1").style.display="none";
            document.getElementById("update").style.display="block";
            document.getElementById("categoryId1").value=obj.parentNode.parentNode.cells[0].innerHTML;
            document.getElementById("categoryName1").value=obj.parentNode.parentNode.cells[1].innerHTML;
            document.getElementById("categoryRemark1").value=obj.parentNode.parentNode.cells[2].innerHTML;
        }


        function deleteCate(obj) {
            document.getElementById("deleteCategoryId").value=obj.parentNode.parentNode.cells[0].innerHTML;
            document.getElementById("deleteForm").submit();

        }



        function save(){
            document.getElementById("updateForm").submit();
            document.getElementById("m1").style.display="block";
            document.getElementById("update").style.display="none";
        }



        function showMessage() {
            if("${requestScope.info}"=="添加成功"){
                alert("添加成功");
            }else if("${requestScope.info}"=="添加失败"){
                alert("添加失败");
            }else if("${requestScope.Delete}"=="类中有产品，无法删除"){
                alert("类中有产品，无法删除");
            }else if("${requestScope.Delete}"=="删除成功"){
                alert("删除成功");
            }

        }





    </script>
</head>
<body  onload="showMessage()">
<div id="m1">

<table width="100%"  border="0" cellpadding="0" cellspacing="0" id="m">
    <tr>
        <td nowrap class="title1">您的位置：工作台面－－产品分类管理</td>
    </tr>
</table>
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td width="30px" nowrap class="toolbar">&nbsp;</td>
        <td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="add()"><img src="../images/new.gif">新增</td>
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
        <td class="title1">类别序列号</td>
        <td class="title1">名称</td>
        <td class="title1">描述</td>
        <td class="title1">操作</td>
    </tr>
    <c:forEach items="${requestScope.category}" var="cate">
        <tr>
            <td align="center" id="categoryId">${cate.categoryId}</td>
            <td align="center" id="categoryName">${cate.name}</td>
            <td align="center" id="categoryRemark">${cate.remark}</td>
            <td align="center"><a href="#" onclick="update(this)">修改</a> <a href="#" onclick="deleteCate(this)">删除</a></td>
        </tr>
    </c:forEach>

    <%--隐藏表单--%>

    <form action="../storeServlet/DeleteCategoryServlet" style="display: none" method="post" id="deleteForm" >
        <input type="hidden" id="deleteCategoryId" name="deleteCategoryId">
    </form>

</table>
</div>


<div id="update" style="display: none;">
    <form action="../storeServlet/UpdateCategoryServlet",method="post" id="updateForm">
    <table width="100%"  border="0" align="center" cellspacing="1" class="c">

        <tr>
            <td align="center">类别序列号</td>
            <td align="center"><input type="text" id="categoryId1" name="categoryId1" readonly/></td>
            <td></td>
        </tr>
        <tr>
            <td align="center">名称</td>
            <td align="center"><input type="text"  id="categoryName1" name="categoryName1"/></td>
            <td><span style="color: red;float: left">*必填项</span></td>
        </tr>
        <tr>
            <td align="center">描述</td>
            <td align="center" ><input type="text" id="categoryRemark1" name="categoryRemark1"/></td>
            <td></td>
        </tr>

        <tr>
            <td height="18" colspan="3" align="center"><input type="reset"/> <input type="button" value="保存" onclick="save()"/></td>

        </tr>
    </table>
    </form>

</div>

</body>
</html>
