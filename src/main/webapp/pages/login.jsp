<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<script type="text/javascript" src="<%=root%>/scripts/jquery-1.4.2.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=root%>/scripts/jquery-easyui-1.3.6/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=root%>/scripts/jquery-easyui-1.3.6/themes/icon.css">
<script type="text/javascript" src="<%=root%>/scripts/comm.js"></script>
<script type="text/javascript" src="<%=root%>/scripts/jquery-easyui-1.3.6/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=root%>/scripts/jquery-easyui-1.3.6/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=root%>/scripts/jquery-easyui-1.3.6/validate/easyui_validate.js"></script>
<script type="text/javascript" src="<%=root%>/scripts/login.js"></script>
<title>购物平台登录界面</title>
<script type="text/javascript">
$(function () {
    $(".click1").click(function () {
        $("#topswitch").removeClass("btn2").addClass("btn1");
        $('#dllx').val(1);
        $("#form1").show();
        $("#form2").hide();
    })
    $(".click2").click(function () {
        $("#topswitch").removeClass("btn1").addClass("btn2");
        $('#dllx').val(2);
        $("#form2").show();
        $("#form1").hide();
    })
})
</script>
</head>
<body class="graybg">
	<input id="dllx" type="hidden" value="1">
    <div class="mainbox">
        <div class="loginlogo">
        </div>
    </div>
    <div class="logincnt">
        <div class="topswitch btn1" id="topswitch">
            <div class="click1"></div>
            <div class="click2"></div>
        </div>
        <div class="loginbox">
            <div class="loginform">
                <div class="forms" id="form1">
                    <h4>用户名</h4>
                    <div class="inputs">
                        <input type="text" name="name_1" id="name_1" class="easyui-validatebox"  maxlength="30"/>
                        <div class="username"></div>
                    </div>

                    <h4>密码</h4>
                    <div class="inputs">
                         <input type="password" name="password_1" id="password_1" class="easyui-validatebox" maxlength="30"/>
                        <div class="password"></div>
                    </div>

                    <div class="otherinput">
                        <input type="checkbox" value=" " /> 自动登录　　
                        <a href="<%=root%>/initRegister.do?khlb=0" >初次使用，未注册？</a>  　　  忘记密码？
                    </div>

                    <a href="javascript:void(0)" onclick="doLogin()" class="loginbtn"></a>

                    
                </div>
                <div class="forms" id="form2" style="display:none">
                    <h4>用户名</h4>
                    <div class="inputs">
                        <input type="text" name="name_2" id="name_2" class="easyui-validatebox"  maxlength="30"/>
                        <div class="username"></div>
                    </div>

                    <h4>密码</h4>
                    <div class="inputs">
                        <input type="password" name="password_2" id="password_2" class="easyui-validatebox" maxlength="30"/>
                        <div class="password"></div> 
                    </div>

                    <div class="otherinput">
                        <input type="checkbox"  value=" " /> 自动登录　　
                        <a href="<%=root%>/initRegister.do?khlb=1" >初次使用，未注册？</a>   　　  忘记密码？
                    </div>

                    <a href="javascript:void(0)" onclick="doLogin()" class="loginbtn"></a>

                </div>
                <br>
                <div>
                	<span id="login_msg" style="color:red;font-size:15px;font-weight:bold"></span>
                </div>
            </div>
            <div class="loginbanner">
				<img src="<%=root %>/images/temp5.png" alt="" />
            </div>

        </div>
    </div>
<s:include value="foot.html"></s:include>
</body>
</html>