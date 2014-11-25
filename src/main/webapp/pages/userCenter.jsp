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
			<span><a href="<%=root%>/init.do">首页</a>
				&nbsp;&gt;&nbsp;<a href="<%=root%>/userCenter.action">用户中心</a></span>
		</div>
	</div>
	<div class="mainbox usermain clearfix">
        <div class="user-right">
            <div class="shiptitle">
                <h3>订单状态：</h3>
                <div class="orderstate">您有 <span>5</span>  个订单待确认收货</div>
                <div class="orderstate">您有 <span>5</span>  个订单待付款</div>
            </div>
            <div class="shiptitle">
                <h3>用户信息：</h3>
                <s:set name="khxx" value="#session.session_khxx"></s:set>
                <div class="useraddr">
                	<b>登陆账号：</b> <s:property value="#khxx.dlm"/>
                </div>
                <div class="useraddr">
                	<b>用户名：</b> <s:property value="#khxx.khMc"/>
                </div>
                <div class="useraddr">
                	<b>渠道商级别：</b>
                	<s:if test="#khxx.qdsJb==1">一级</s:if>
                	<s:if test="#khxx.qdsJb==2">二级</s:if>
                	<s:if test="#khxx.qdsJb==3">三级</s:if>
                </div>
                <div class="useraddr">
                	<b>负责人：</b><s:property value="#khxx.fzrXm"/>
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
            <h1>用户中心</h1>
            <ul>
                <li><a href="<%=root%>/userCenter.do" class="current">个人主页</a></li>
                <li><a href="#">修改密码</a> </li>
                <li><a href="#">我的购物车</a> </li>
                <li><a href="<%=root%>/userOrder.do">我的订单</a> </li>
                <li><a href="#">汇款方式</a> </li>
            </ul>
        </div>
    </div>
	<s:include value="foot.html"></s:include>
</body>
</html>