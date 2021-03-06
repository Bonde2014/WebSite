$(document).ready(function(){
	//setDialog();
	//进入页面，焦点在用户名文本框上
	//$("#dlm").focusout();
});

/**
 * Ajax执行登录操作
 * @return
 */
function doLogin() {
	var dllx = $('#dllx').val();
	var validateResult = true;
	//easyui 表单验证
	if (!$('#name_'+dllx).validatebox('isValid')
			||!$('#password_'+dllx).validatebox('isValid')) {
		//如果验证不通过，则返回false
		validateResult = false;
		return;
    }
	$("#login_msg").html("登录中，请稍后...");
	$.ajax({
		async : false,
		cache : false,
		type : 'POST',
		//dataType : "json",
		url : root+"/doLogin.do?"+Math.random(),// 请求的action路径
		data : {
			"qxDlxx.dllx":dllx,
			"qxDlxx.dlm" : $.trim($('#name_'+dllx).val()),
			"qxDlxx.dlkl" : $.trim($('#password_'+dllx).val())
		},
		error : function() {// 请求失败处理函数
			$.messager.alert("提示信息","登录失败","info")
		},
		success : function(data) { // 请求成功后处理函数。
			if (data == "true") {
				window.location = root+"/init.do";
			} else {//后台异常处理
				$("#login_msg").html(data);
			}
		}
	});
}

/**
 * 执行reset操作
 */
function doReset(){
	$("#dlm").val("");
	$("#dlkl").val("");
	$("#login_msg").html("&nbsp;");
}


/**--------------操作弹出框------------------**/
//设置弹出框的属性
function setDialog(){
	$('#login').dialog({
		title : '用户登录',
		modal: true,         //模式窗口：窗口背景不可操作
		collapsible : false,  //可折叠，点击窗口右上角折叠图标将内容折叠起来
		resizable : true,    //可拖动边框大小
		closable : false     //不提供关闭窗口按钮
	});
}