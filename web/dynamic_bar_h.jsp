﻿<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<style>
	body { margin: 0px; padding: 0px; background-color: #d4d0c8; cursor: hand;  }
	</style>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
</head>

<script>
var buttonopen = new Image();
buttonopen.src = "images/sort_up.gif";
var buttonclose = new Image();
buttonclose.src = "images/sort_down.gif";

function sw_frameset()
{
	var obj = parent.window.document.getElementById( "controlRv" );
	if(obj==null)
		return;
	if ( obj.rows=="20,10,*" )
	{
		obj.rows = "0,10,*";
        document.body.style.cursor = "hand";
		swbutton.src = buttonclose.src;
	} else {
		obj.rows = "20,10,*";
        document.body.style.cursor = "hand";
		swbutton.src = buttonopen.src;
	}
	return true;
}
</script>

<body onload="document.body.onclick=sw_frameset;" bgcolor="#d4d0c8" leftmargin="0" topmargin="0">
<table cellpadding="0" cellspacing="0" width="100%" height="100%" align="center">
  <tr> 
    <td align="center" valign="middle" height="9" background="images/gbDbR.jpg"><a href="#" ><img src="images/sort_up.gif" border="0" height="8px" width="7px" id="swbutton" ></a></td>
  </tr>
  <tr>
    <td align="center" valign="middle" bgcolor="#000000">&nbsp;</td>
  </tr>
</table>
</body>
</html>