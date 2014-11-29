<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="base.jsp"%>
<%@include file="/pages/top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>克莱姆购物平台</title>
<script type="text/javascript">
	function submitForm(){
		if(($('#dlkl_new').val()=="")||($('#dlkl_old').val()=="")){
			$.messager.alert('提示信息','密码不能为空','info');
			return;
		}
		
		if($('#dlkl_new').val()!=$('#dlkl_new2').val()){
			$.messager.alert('提示信息','两次录入的新密码不一致','info');
			return;
		}
		$.ajax({
			type : "post",
			url : root+"/changePassword.action?"+Math.random(),
			data : {
				"dlkl_old" :$('#dlkl_old').val(),
				"dlkl_new":$('#dlkl_new').val()
			},
			async : false,
			error : function() {
			},
			success : function(data) {
				//alert(data);
				if(data=="true"){
					$.messager.alert('提示信息','密码修改成功','info');
				}else{
					$.messager.alert('提示信息','密码修改失败','info');
				}
			}
		});
	}
</script>
</head>
<body>
	<div class="topnav mainbox">
		<div class="breadcrumb">
			<span><a href="<%=root%>/init.do">首页</a>
				&nbsp;&gt;&nbsp;<a href="<%=root%>/userCenter.action">渠道商</a></span>
		</div>
	</div>
	<div class="mainbox usermain clearfix">
        <div class="user-right">
        	<div class="shiptitle">
        	<s:set name="dlxx" value="#session.session_login"></s:set>
            <div class="useraddr">
                <b>用户名：　　</b> <s:property value="#dlxx.dlm"/>
            </div>
            <div class="useraddr">
                <b>原密码：　　</b> <input type="password" id="dlkl_old" maxlength="20">
            </div>
             <div class="useraddr">
                <b>新密码：　　</b> <input type="password" id="dlkl_new" maxlength="20">
            </div>
            <div class="useraddr">
                <b>确认新密码：</b> <input type="password" id="dlkl_new2" maxlength="20">
            </div>
            	<div align="center"> 
            		<input type="button" class="btn4" align="middle" value="修改" onclick="submitForm()"/>
            	</div>
           </div> 
        </div>
        <div class="user-left">
			<h1>渠道商</h1>
			<ul>
				<li><a href="<%=root%>/userCenter.action">用户中心</a></li>
				<li><a href="<%=root%>/changePasswordInit.action" class="current">修改密码</a></li>
				<li><a href="<%=root%>/goShopcart.action">我的购物车</a></li>
				<li><a href="<%=root%>/userOrder.action">我的订单</a></li>
				<li><a href="#">汇款方式</a></li>
			</ul>
        </div>
    </div>
	<s:include value="foot.html"></s:include>
</body>
</html>
