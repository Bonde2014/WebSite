

/**
 * 按商品分类、商品品牌，从后台查询可放上当前供货商货架的商品列表
 * @param 
 * @return
 */
function querySupplyProducts(){
	alert("start query...");
	$('#searchSupplyForm').attr("action",root+"/selectSupply.do");
	$('#searchSupplyForm').submit();
	//alert("submit?");
   }

/**
 * 将选择好的一批商品代码列表，添加到当前供货商的货架
 * @param 
 * @return
 */
function addSupply(){
	//TODO：这里要判断spdms是否为空，为空不允许提交，否则会报错。
	$('#addSupplyForm').attr("action",root+"/addSupply.do");
	$('#addSupplyForm').submit();
//	alert($('#spdms').val());
//	alert($("input[name='spdms']").val());
//	$.ajax({
//	type : "post",
//	url : root+"/addSupply.do?"+Math.random(),// 请求的action路径
//	data : {
//		"spdms" : $('#spdms').val()   //要写js代码按name选择器，循环spdms，然后组织spdms的数组
//	},
//	async : false,  //同步
//	error : function() {// 请求失败处理函数
//		alert("call error...");
//	},
//	success : function() {
//	}
//  });
    }

	

/**
 * 修改报价信息
 * @param 
 * @return
 */
function editSupplyinfo(ghxh){
	alert(ghxh);
}

/**
 * 将某个供货信息下架
 * @param 
 * @return
 */
function downSupplyProduct(ghxh){
	alert(ghxh);
	$.ajax({
	type : "post",
	url : root+"/downSupplyProduct.do?"+Math.random(),// 请求的action路径
	data : {
		"ghxh" : ghxh  
	},
	async : false,  //同步
	error : function() {// 请求失败处理函数
		$.messager.alert("提示信息","下架操作失败","error");
	},
	success : function(data) {
		if (data == "true") {
	    	$.messager.alert("提示信息","下架操作成功...","info");
	    	//下架操作成功，需要修改当前行的操作栏的按钮状态，如何选择当前行的操作栏td元素?
	    	var operstr='<input type="button" name="editSupply" value="理货" class="btn4" onclick="editSupplyinfo('+ghxh+')"/>';
	    	$("#oper"+ghxh).html(operstr);
		}else{
			$.messager.alert("提示信息","下架操作失败","error");
		}
		
	}
  });
}

/**
 * 将客户注册信息保存下来
 * @param 
 * @return
 */
function saveRegist(){
	//alert( $('[name="token"]').val() );
	if(($('#dlm').val()=="")||($('#dlkl_new').val()=="")||($('#dlkl_old').val()=="")
			||($('#khmc').val()=="")||($('#fzr_xm').val()=="")||($('#lxdh').val()=="")
			){
		$.messager.alert('提示信息','登录名、密码、企业名称、负责人姓名、联系电话等都不能为空','info');
		return;
	}
	
	if($('#dlkl').val()!=$('#dlkl_2').val()){
		$.messager.alert('提示信息','两次录入的密码不一致','info');
		return;
	}
	//TODO:这里后续可以改成easyui的validate，但是风格比较丑
	//TODO：这里要先查询下dlm是否有重复
	//用ajax提交，而不是struts提交，因为要相应提示信息
	$.ajax({
		async : false,
		//cache : false,
		type : 'POST',
		//dataType : "json",
		url : root+"/addRegist.do?"+Math.random(),// 请求的action路径
		data : {
			//"token": $('[name="token"]').val() , //防止重复提交的作用
			"khlb":  $('#khlb').val(),
			"qxDlxx.dlm" : $.trim($('#dlm').val()),
			"qxDlxx.dlkl" : $.trim($('#dlkl').val()),
			"qxKhxx.fzrXm": $.trim($('#fzrXm').val()),
			"qxKhxx.khMc": $.trim($('#khMc').val()),
			"qxKhxx.lxdz": $.trim($('#lxdz').val()),
			"qxKhxx.lxdh": $.trim($('#lxdh').val())
		},
		error : function() {// 请求失败处理函数
			$.messager.alert("提示信息","注册失败","error");
		},
		success : function(data) { // 请求成功后处理函数。
			if (data == "true") {
				$.messager.alert('提示信息','客户信息注册成功，跳转登录页面...','info');  //TODO：这里直接一闪而过，要怎么停顿住？
				window.location = root+"/pages/login.jsp";
			} else {//后台异常处理
				$.messager.alert('提示信息','客户信息注册失败，请检查...','error');
			}
		}
	});
	//$('#registForm').attr("action",root+"/saveRegist.do");
	//$('#registForm').submit();
}
