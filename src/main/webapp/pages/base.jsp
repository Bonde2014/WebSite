<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String root = request.getContextPath();
%>
<script type="text/javascript">
 var root = "<%=root%>"; //js中存放当前页面的root路径方便调用
</script>
<link rel="stylesheet" type="text/css" href="<%=root%>/css/style.css">
<link rel="stylesheet" type="text/css" href="<%=root%>/scripts/jquery-easyui-1.3.6/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=root%>/scripts/jquery-easyui-1.3.6/themes/icon.css">
<script type="text/javascript" src="<%=root%>/scripts/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=root%>/scripts/comm.js"></script>
<script type="text/javascript" src="<%=root%>/scripts/jquery-easyui-1.3.6/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=root%>/scripts/jquery-easyui-1.3.6/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=root%>/scripts/jquery-easyui-1.3.6/validate/easyui_validate.js"></script>
<head>
</head>
<body>
	 <div class="hd_global_top_bar">
        <div class="mainbox">
            <span class="top_bar_wrap">客服热线：0571-56839396</span>
            <span class="top_bar_wrap ">购物车</span>
            <span class="top_bar_wrap">用户中心</span>
            <span class="top_bar_wrap">首页</span>
            <span class="top_bar_wrap" style="border-left:0"> magister.feng  您好，欢迎来到克莱姆！</span>
        </div>
    </div>
</body>
</html>
