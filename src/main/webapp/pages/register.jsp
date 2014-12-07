<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="base.jsp"%>
<%@include file="/pages/top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>克莱姆购物平台</title>
<script src="<%=root%>/scripts/supply.js"></script>
</head>
<body>
	<div class="topnav mainbox">
		<div class="breadcrumb">
			<span><a href="<%=root%>/init.do">首页</a>
				&nbsp;&gt;&nbsp;客户注册</span>
		</div>
	</div>
	<div class="mainbox usermain clearfix">
        <div class="user-right">
        <form action="" id="registForm" method="post">
        <s:hidden id="khlb"  name="khlb"></s:hidden>
            <div class="shiptitle">
                <h3>账户信息：</h3>
                <div class="useraddr">
                	<b>登录用户名：　 </b><input type="text" name="qxDlxx.dlm" id="dlm"  maxlength="30"/> 
                	<!-- 这里要增加判断是否重复的用户名 -->
                </div>
                <div class="useraddr">
                	<b>设置密码：　　 </b><input type="password" id="dlkl" name="qxDlxx.dlkl"  maxlength="20">
                </div>
                <div class="useraddr">
                	<b>确认密码：　　 </b><input type="password" id="dlkl_2" maxlength="20">
                </div>
            </div>
            <div class="shiptitle">
                <h3>客户信息：</h3>
                <div class="useraddr">
                	<b>客户/公司名称：</b><input type="text" style="width:300px;" name="qxKhxx.khMc" id="khMc"  maxlength="50"/>
                </div>
                <div class="useraddr">
                	<b>联系地址：　  　</b><input type="text" style="width:450px;" name="qxKhxx.lxdz" id="lxdz"  maxlength="90"/>
                </div>
            </div>
            <div class="shiptitle">
                <h3>联系人信息：</h3>
                <div class="useraddr">
                	<b>负责人姓名：  　</b><input type="text" name="qxKhxx.fzrXm" id="fzrXm"  maxlength="20"/>
                </div>
                <div class="useraddr">
                	<b>联系电话：　 　</b><input type="text" name="qxKhxx.lxdh" id="lxdh"  maxlength="20"/>
                </div>
                <div class="useraddr">
                    <b>QQ：　　　 　</b><input type="text" name="qq" id="qq"  maxlength="20"/>
                </div>
               <div class="useraddr" align="center"> <input type="button" name="name" class="btn4" align="middle" value="注册" onclick="saveRegist()"/></div>
            </div>
        </form>    
        </div>
        <div class="user-left">
            <h1>客户注册</h1>
            <ul>
                <li><a href="<%=root%>/initRegister.do?khlb=0"  <s:if test="#khlb=='0'"> class="current" </s:if>  >渠道商注册</a></li>
                <li><a href="<%=root%>/initRegister.do?khlb=1" <s:if test="#khlb=='1'"> class="current" </s:if>  >供货商注册</a></li>
            </ul>
        </div>
    </div>
	<s:include value="foot.html"></s:include>
</body>
</html>
