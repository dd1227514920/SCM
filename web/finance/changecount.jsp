<%--
  Created by IntelliJ IDEA.
  User: JerryCheng
  Date: 2017.7.12
  Time: 9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>盘点数量修改</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
    <table width="100%"  border="0" cellpadding="0" cellspacing="0" id="m">
        <tr>
            <td nowrap class="title1">您的位置：工作台面－－盘点修改</td>
        </tr>
    </table>
    <table width="100%"  border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td width="30px" nowrap class="toolbar">&nbsp;</td>
            <td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="window.open('th_detail.htm')"><img src="../images/new.gif">新增</td>
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

<form action="../financeservlet/SaveChange" method="post">
        <table width="100%"  border="0" align="center" cellspacing="1" class="c">
            <tr>
                <td class="title1">变化数量</td>
                <td class="title1"><input type="text" name="num"></td>
            </tr>
            <tr>
                <td align="center">变化类型</td>
                <td align="center"><select name="type"/>
                    <option value="0">盘余</option>
                    <option value="1">损耗</option>
                </td>
            </tr>
            <tr>
                <td align="center">原因</td>
                <td align="center"><input type="text" name="Description"/></td>
            </tr>
            <tr>
                <td height="18" colspan="2" align="center"><input type="reset"/> <input type="submit" value="保存"/></td>
            </tr>
        </table>

</form>
</body>
</html>
