<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>克莱姆购物平台</title>
</head>
<body>
	<div class="topnav mainbox">
		<div class="breadcrumb">
			<strong><a href="<%=root%>/init.do">首页</a>
		&nbsp;&gt;&nbsp;<a href="<%=root%>/userCenter.do">用户中心</a></strong>
		</div>
	</div>






	<div class="mainbox usermain clearfix">
		<div class="user-right">

			<a href="#" onclick="deleteSp(this);" class="btn1">移除</a>

			<table width="100%" border="1" cellspacing="0" cellpadding="0" id="gwc_table">
				<tr>
					<th style="width:45px"><input type="checkbox" id="checkboxAll" 
						value=" " /></th>
					<th style="width:245px">商品信息</th>
					<th>单价</th>
					<th>数量</th>
					<th>金额 (元)</th>
					<th style="width:100px;">操作</th>

				</tr>
				<c:forEach items="${shopcartList }" var="item">
					<tr>
						<td style="text-align: center;"><input type="checkbox"
							name="checkbox" value=" " /></td>
						<td style="text-align: center;"><a href="#" class="link">${item.SP_JG}</a></td>
						<td style="text-align: center;" class="alir" name="spJg">${item.SP_JG}</td>
						<td style="text-align: center;"><input name="spSl"
							class="easyui-numberspinner" style="width:60px;"
							value="${item.SP_SL }" /></td>
						<td class="alir" style="text-align: center;" name="spZj">${item.SP_ZJ}</td>
						<td style="text-align: center;"><a href="#" class="btn2" onclick="deleteByIndex(this)">删除</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<div class="total">
				<a href="<%=root %>/pages/allorder.html" class="btn3" >去结算</a> <span>合计（不含运费）：<font color="red">¥</font><font id="zje" color="red">0</font></span>
			</div>
		</div>
		<div class="user-left">
			<h1>帐户中心</h1>
			<ul>
				<li><a href="<%=root%>/userCenter.do">个人主页</a></li>
				 <li><a href="<%=root%>/addToShopCart.do?spdm='1'">修改密码</a> </li>
				<li><a href="<%=root%>/goShopcart.do" class="current">我的购物车</a></li>
				<li><a href="<%=root%>/userOrder.do" >我的订单</a></li>
				<li><a href="#">汇款方式</a></li>
			</ul>
		</div>
		<script type="text/javascript">
		 function toDecimal2(x) {  
	            var f = parseFloat(x);  
	            if (isNaN(f)) {  
	                return false;  
	            }  
	            var f = Math.round(x*100)/100;  
	            var s = f.toString();  
	            var rs = s.indexOf('.');  
	            if (rs < 0) {  
	                rs = s.length;  
	                s += '.';  
	            }  
	            while (s.length <= rs + 2) {  
	                s += '0';  
	            }  
	            return s;  
	        }  
		
			$("input[name='spSl']").numberspinner({ min : 1, max : 1000, editable : true,
			//missingMessage:"请输入商品数量",
			onChange : function(value)
			{
				if (value == "")
				{
					$(this).val("1");
				}
				$(this).parent().parent().parent().find("td[name='spZj']").text(toDecimal2(parseFloat($(this).parent().parent().parent().find("td[name='spJg']").text())* $(this).val()));
				countZje();
			/* 	$.ajax({

		             type: "POST",
		             url : root+"/doUpdateSl.do?"+Math.random(),// 请求的action路径
		     		 data : {
		     			"qxDlxx.dllx":dllx,
		     			"qxDlxx.dlm" : $.trim($('#name_'+dllx).val()),
		     			"qxDlxx.dlkl" : $.trim($('#password_'+dllx).val())
		     		} 
			} )；*/
			}
		});

			function deleteSp(obj)
			{
				var checkList=$("input[name='checkbox']:checked");
				if(checkList.size()==0){
					 $.messager.alert('提示信息','请选择需要删除的商品!','info');
					 return;
				}
				$.messager.confirm('删除商品', '确定从购物车中删除此商品？', function(value){
		               if (value){
		            	   checkList.each(function(i)
		           				{
		           					$(this).parent().parent().remove();
		           				});
		           				countZje();
		               }
              });	
		  }
			function deleteByIndex(obj){
				$.messager.confirm('删除商品', '确定从购物车中删除此商品？', function(value){
				               if (value){
				   				$(obj).parent().parent().remove();
				   				countZje();
				               }
		           });
			}
			
			function countZje(){
			    $("#zje").text(toDecimal2("0"));
			    $("td[name='spZj']").each(function(i){
				       $("#zje").text(toDecimal2(parseFloat($("#zje").text())+parseFloat($(this).text())));
			    });
			}
			
			$(function(){
				countZje();
				$("#checkboxAll").click(function(){
					if($(this).attr("checked")==true){
						$("input[name='checkbox']").attr("checked",true);
					}else{
						$("input[name='checkbox']").attr("checked",false);
					}
					
				}); 
			})
		</script>
	</div>
	<s:include value="foot.html"></s:include>
</body>
</html>
