<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
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
<link rel="stylesheet" type="text/css" href="<%=root%>/scripts/jquery-easyui-1.3.6/themes/bootstrap/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=root%>/scripts/jquery-easyui-1.3.6/themes/icon.css">
<script type="text/javascript" src="<%=root%>/scripts/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=root%>/scripts/comm.js"></script>
<script type="text/javascript" src="<%=root%>/scripts/common.js"></script>
<script type="text/javascript" src="<%=root%>/scripts/jquery-easyui-1.3.6/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=root%>/scripts/jquery-easyui-1.3.6/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=root%>/scripts/jquery-easyui-1.3.6/validate/easyui_validate.js"></script>
<head>
</head>
<body>
	 <div class="hd_global_top_bar">
        <div class="mainbox">
        	 <s:if test="#session.session_login!=null">
        	 	<span class="top_bar_wrap"><a href="<%=root%>/doLogout.do" >注销</a></span>
        	 </s:if>
            <span class="top_bar_wrap">客服热线：0571-56839396</span>
            <s:if test="#session.session_login.dllx==2">
            	 <span class="top_bar_wrap "><a href="<%=root%>/supplyManageInit.action" >我的货架</a></span>
            	 <span class="top_bar_wrap"><a href="<%=root%>/supplyCenter.action" >用户中心</a></span>
            </s:if>
            <s:else>
            	<span class="top_bar_wrap "><a href="<%=root%>/goShopcart.action" >我的购物车</a></span>
            	<span class="top_bar_wrap"><a href="<%=root%>/userCenter.action" >用户中心</a></span>
            </s:else>
            <span class="top_bar_wrap"><a href="<%=root%>/init.do">首页</a></span>
            <s:if test="#session.session_login!=null">
            	<span class="top_bar_wrap" style="border-left:0"><s:property value="#session.session_khxx.khMc"/> 您好，欢迎来到克莱姆！</span>
            </s:if>
            <s:else>
            	<span class="top_bar_wrap" style="border-left:0">您好，欢迎来到克莱姆！
            		<a href="<%=root%>/pages/login.jsp">登录</a>
            	</span>
            </s:else>
        </div>
    </div>
</body>
</html>
