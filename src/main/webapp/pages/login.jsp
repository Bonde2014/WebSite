<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<%
	String root = request.getContextPath();
%>
<script type="text/javascript">
 var root = "<%=root%>"; //js中存放当前页面的root路径方便调用
</script>
<link rel="stylesheet" type="text/css" href="<%=root%>/css/style.css">
<link rel="stylesheet" type="text/css" href="<%=root%>/scripts/jquery-easyui-1.3.6/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=root%>/scripts/jquery-easyui-1.3.6/themes/icon.css">
<script type="text/javascript" src="<%=root%>/scripts/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="<%=root%>/scripts/comm.js"></script>
<script type="text/javascript" src="<%=root%>/scripts/jquery-easyui-1.3.6/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=root%>/scripts/jquery-easyui-1.3.6/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=root%>/scripts/jquery-easyui-1.3.6/validate/easyui_validate.js"></script>
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