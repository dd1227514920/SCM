<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<style>
	body { margin: 0px; padding: 0px; background-color: #d4d0c8; cursor: hand; border-left: outset 2px white; }
	</style>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
</head>

<script>
var buttonopen = new Image();
buttonopen.src = "images/sort_left.gif";
var buttonclose = new Image();
buttonclose.src = "images/sort_right.gif";

function sw_frameset()
{
	var obj = parent.window.document.getElementById( "controlFv" );
	if ( obj.cols=="120,10,*" )
	{
		obj.cols = "0,10,*";
		document.body.style.borderLeft = "solid 2px #d4d0c8";
		swbutton.src = buttonclose.src;
	} else {
		obj.cols = "120,10,*";
		document.body.style.borderLeft = "outset 2px white";
		swbutton.src = buttonopen.src;
	}
	/*
	if ( parent.controlFv.cols=="130,10,*" )
	{
		parent.controlFv.cols = "0,10,*";
		document.body.style.borderLeft = "solid 2px #d4d0c8";
		swbutton.src = buttonclose.src;
	} else {
		parent.controlFv.cols = "130,10,*";
		document.body.style.borderLeft = "outset 2px white";
		swbutton.src = buttonopen.src;
	}
	*/
	return true;
}
</script>

<body onload="document.body.onclick=sw_frameset;" bgcolor="#d4d0c8">

<table border="0" cellpadding="0" cellspacing="0" width="100%" height="650" align="center">
  <tr> 
    <td align="center" valign="middle" width="8" background="images/gbDb.jpg"  > <a href="#"><img src="images/sort_left.gif" border="0" height=8 width=7 id="swbutton"></a></td>
    <td align="center" valign="middle" width="1164" bgcolor="#000000" > 
      <div align="left"></div>
      <div align="left"></div>
    </td>
  </tr>
</table>

</body>
</html>

