<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="base.jsp"%>
<%@include file="top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>克莱姆购物平台</title>
</head>
<body>
	<div class="global_menu">
		<div class="mainbox">
			<div class="bigmenu">
				<h1 style="cursor:pointer" onclick="pageLink('/init.do')">全部商品分类</h1>
				<ul id="catalogtree">
				</ul>
			</div>
			<ul class="topmenu">
				<li onclick="pageLink('/todayPrice.action')">今日报价</li>
				<li onclick="pageLink('/init.do')">首页</li>
				<li>特价专区</li>
				<li>自助装机</li>
			</ul>
		</div>
	</div>

	<div class="topnav mainbox">
		<div class="breadcrumb">
		    <span>供货商&nbsp;&gt;&nbsp;用户中心
            </span>
		</div>
	</div>
	<div class="mainbox usermain clearfix">
        <div class="user-right">
            <div class="shiptitle">
                <h3>用户信息：</h3>
                <s:set name="khxx" value="#session.session_khxx"></s:set>
                <div class="useraddr">
                	<b>登录账号：</b> <s:property value="#khxx.dlm"/>
                </div>
                <div class="useraddr">
                	<b>客户名称：</b> <s:property value="#khxx.khMc"/>
                </div>
                <div class="useraddr">
                	<b>负责人姓名：</b><s:property value="#khxx.fzrXm"/>
                </div>
                <div class="useraddr">
                	<b>联系方式：</b><s:property value="#khxx.lxdh"/>
                </div>
                <div class="useraddr">
                    <b>联系地址：</b><s:property value="#khxx.lxdz"/>
                </div>
               <div class="useraddr" align="center"> <input type="button" name="name" class="btn4" align="middle" value="修改" /></div>
            </div>
        </div>
        <div class="user-left">
            <h1>供货商</h1>
            <ul>
                 <li><a href="<%=root%>/pages/supplyCenter.jsp" class="current">用户中心</a>    </li>
                <li><a href="<%=root%>/supplyManageInit.do" >我的货架</a> </li>
            </ul>
        </div>
    </div>
	<s:include value="foot.html"></s:include>
</body>
</html>