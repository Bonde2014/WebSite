<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>My JSP 'success.jsp' starting page</title>
	</head>

	<body>
		注册成功!你好,
		<s:property value="username" />
		!
		<br/>
		<table border="1px " style="color: black;border-color: black;" width="300px;"><tr >
		<td style="width: 50px;">用户名</td>
		<td style="width: 50px;">密码</td>
		</tr>
		<s:iterator value="list"  var="user"><tr><td><s:property value="#user.username"/>  </td><td><s:property value="#user.password"/> </td><tr></s:iterator>
</table>
	</body>
</html>
