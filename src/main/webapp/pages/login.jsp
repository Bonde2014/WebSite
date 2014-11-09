<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/pages/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<script type="text/javascript" src="<%=root%>/scripts/login.js"></script>
<title>购物平台登录界面</title>
</head>
<body>
	<div id="login" style="padding: 5px; width: 400px; height: 220px;">
		<table onkeydown="if(event.keyCode==13){doLogin();}" id="loginTable">
			<tr>
				<td align="right"><b style="font: 12px">用户名：</b></td>
				<td><input type="text" class="easyui-validatebox" id="dlm"
					style="width:200px;" maxlength="20" required="true"></input></td>
			</tr>
			<tr>
				<td align="right"><b style="font: 12px">密码：</b></td>
				<td><input type="password" class="easyui-validatebox" id="dlkl"
					style="width:200px;" maxlength="20" required="true"></input></td>
			</tr>
			<tr>
				<td></td>
				<td id="login_msg" style="color: red;font: 12px">&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><a href="#"
					class="easyui-linkbutton" icon="icon-ok" onclick="doLogin();">确定</a>
					<a href="#" class="easyui-linkbutton" icon="icon-redo"
					onclick="doReset();">重置</a></td>
			</tr>
		</table>
	</div>

</body>
</html>