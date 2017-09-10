<%--
  Created by IntelliJ IDEA.
  User: leo
  Date: 2017/7/11
  Time: 上午9:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css">
    <script src="../script/jquery-1.8.1.min.js"></script>
    <script language="javascript" src="../script/common.js" ></script>
    <script type="text/javascript" src="../script/productDiv.js" ></script>

    <script>
        function add(){
            window.location="/store/addGoods.jsp";
        }

        function update(obj){
            document.getElementById("m1").style.display="none";
            document.getElementById("update").style.display="block";
            var date=new Date();
            var d=date.toLocaleDateString();
            document.getElementById("productCode").value=obj.parentNode.parentNode.cells[0].innerHTML;
            document.getElementById("productName").value=obj.parentNode.parentNode.cells[1].innerHTML;
            document.getElementById("categoryId").value=obj.parentNode.parentNode.cells[3].innerHTML;
            document.getElementById("unitName").value=obj.parentNode.parentNode.cells[2].innerHTML;
            document.getElementById("createDate").value=d;
            document.getElementById("remark").value=obj.parentNode.parentNode.cells[6].innerHTML;
        }


        function deleteProduct(obj) {
            document.getElementById("deleteProductCode").value=obj.parentNode.parentNode.cells[0].innerHTML;
            document.getElementById("deleteProductForm").submit();

        }

        function save(){
            document.getElementById("updateForm").submit();
            document.getElementById("m1").style.display="block";
            document.getElementById("update").style.display="none";
        }

        function message() {
            if("${requestScope.info}"=="添加成功"){
                alert("添加成功");
            }else if("${requestScope.info}"=="添加失败"){
                alert("添加失败");
            }else if("${requestScope.info}"=="删除成功"){
                alert("删除成功");
            }else if("${requestScope.info}"=="删除失败"){
                alert("删除失败");
            }else if("${requestScope.info}"=="修改成功"){
                alert("修改成功");
            }else if("${requestScope.info}"=="修改失败"){
                alert("修改失败");
            }
        }

        function goPage() {
            var currentPage=$("#inputPage").val();
            if(currentPage!=""&&currentPage<=${pageList.totalPage}&&currentPage>=1&&currentPage%1==0){
                window.location="../storeServlet/PageSplitServlet?CurrentPage="+currentPage;
            }else{
                alert("跳转页面输入有误！")
            }
        }


    </script>
</head>
<body onload="message()">

<div id="m1">
    <table width="100%"  border="0" cellpadding="0" cellspacing="0" id="m">
        <tr>
            <td nowrap class="title1">您的位置：工作台面－－产品管理</td>
        </tr>
    </table>
    <table width="100%"  border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td width="30px" nowrap class="toolbar">&nbsp;</td>
            <td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onclick="add()"><img src="../images/new.gif">新增</td>
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
            <td class="title1">产品编号</td>
            <td class="title1">产品名称</td>
            <td class="title1">数量单位</td>
            <td class="title1">类别序列号</td>
            <td class="title1">添加日期</td>
            <td class="title1">销售价</td>
            <td class="title1">产品描述</td>
            <td class="title1">操作</td>
        </tr>


        <c:forEach items="${requestScope.pageList.data}" var="product">
        <tr>
        <td align="center">${product.productCode}</td>
        <td align="center">${product.name}</td>
        <td align="center">${product.unitName}</td>
        <td align="center">${product.categoryID}</td>
        <td align="center">${product.createDate}</td>
        <td align="center">${product.price}</td>
        <td align="center">${product.remark}</td>
        <td align="center"><a href="#" onclick="update(this)">修改</a> <a href="#" onclick="deleteProduct(this)">删除</a></td>
        </tr>
        </c:forEach>
    </table>

        当前第${pageList.currentPage}页
        <c:choose>
            <c:when test="${pageList.currentPage==1 }">
                <a href="../storeServlet/PageSplitServlet?CurrentPage=${pageList.currentPage+1 }">下一页</a>
                <a href="../storeServlet/PageSplitServlet?CurrentPage=${pageList.totalPage}">末页</a>
                跳至第<input type="text" id="inputPage" size="2px">页 <a onclick="goPage()" style="cursor: hand">go</a>
                共有${pageList.totalPage}页
            </c:when>
            <c:when test="${pageList.currentPage==pageList.totalPage }">
                <a href="../storeServlet/PageSplitServlet?CurrentPage=1">首页</a>
                <a href="../storeServlet/PageSplitServlet?CurrentPage=${pageList.currentPage-1 }">上一页</a>
                跳至第<input type="text" id="inputPage" size="2px">页 <a onclick="goPage()" style="cursor: hand">go</a>
                共有${pageList.totalPage}页
            </c:when>
            <c:otherwise>
                <a href="../storeServlet/PageSplitServlet?CurrentPage=1">首页</a>
                <a href="../storeServlet/PageSplitServlet?CurrentPage=${pageList.currentPage-1 }">上一页</a>
                <a href="../storeServlet/PageSplitServlet?CurrentPage=${pageList.currentPage+1 }">下一页</a>
                <a href="../storeServlet/PageSplitServlet?CurrentPage=${pageList.totalPage }">末页</a>
                跳至第<input type="text" id="inputPage" size="2px">页 <a onclick="goPage()" style="cursor: hand">go</a>
                共有${pageList.totalPage}页
            </c:otherwise>
        </c:choose>

</div>

<form action="../storeServlet/DeleteProductServlet" method="post" id="deleteProductForm" name="deleteProductForm" style="display: none;" >
    <input type="hidden" id="deleteProductCode" name="deleteProductCode">
</form>

<div id="update" style="display: none;">
    <form action="../storeServlet/UpdateProductServlet",method="post" id="updateForm">
        <table width="100%"  border="0" align="center" cellspacing="1" class="c">

            <tr>
                <td align="center">产品编号</td>
                <td align="center"><input type="text" id="productCode" name="productCode" readonly/></td>
                <td></td>
            </tr>
            <tr>
                <td align="center">产品名称</td>
                <td align="center"><input type="text"  id="productName" name="productName"/></td>
                <td><span style="color: red;float: left">*必填项</span></td>
            </tr>
            <tr>
                <td align="center">类别序列号</td>
                <td align="center">
                    <select name="categoryId" id="categoryId" style="width: 120px;text-align: center">
                        <c:forEach items="${sessionScope.ProductsCategorys}" var="id">
                            <option>${id}</option>
                        </c:forEach>
                    </select>
                </td>
                <td><span style="color: red;float: left">*必填项</span></td>
            </tr>
            <tr>
                <td align="center">销售价</td>
                <td align="center"><input type="text"  id="productPrice" name="productPrice" value="0"/></td>
                <td></td>
            </tr>
            <tr>
                <td align="center">数量单位</td>
                <td align="center"><input type="text"  id="unitName" name="unitName"/></td>
                <td><span style="color: red;float: left">*必填项</span></td>
            </tr>
            <tr>
                <td align="center">添加日期</td>
                <td align="center"><input type="text"  id="createDate" name="createDate" readonly/></td>
                <td><span style="color: red;float: left">*必填项</span></td>
            </tr>
            <tr>
                <td align="center">描述</td>
                <td align="center" ><input type="text" id="remark" name="remark"/></td>
                <td></td>
            </tr>

            <tr>
                <td height="18" colspan="3" align="center"><input type="reset"/> <input type="button" value="保存" onclick="save()" /></td>

            </tr>
        </table>
    </form>

</div>
</body>
</html>
