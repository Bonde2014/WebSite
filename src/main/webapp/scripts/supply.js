﻿

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
