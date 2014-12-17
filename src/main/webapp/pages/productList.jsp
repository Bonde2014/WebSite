<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/pages/base.jsp"%>
<%@include file="/pages/top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link
	href="<%=root%>/scripts/jquery-easyui-1.3.6/themes/bootstrap/easyui.css"
	rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="<%=root%>/css/pager.css">
<script type="text/javascript" src="<%=root%>/scripts/pager.js"></script>
<title>克莱姆购物平台</title>
<script type="text/javascript">
	$(function() {
		$(".adbox").turnPic();
		//刷新商品分类导航区域
		requestCatalogTree($('#catalog').val());
		
		$("#prolist li").hover(
	            function () {
	                $(this).addClass("bg");
	            },
	            function () {
	                $(this).removeClass("bg");

	            }
	        )
	       $("#updateShopCart").click(function () {
	    	   $("#completeframe").show();
               $("#lightcartinfo").hide();
	       });
	       $("#strip").click(function () {
            if (!$("#completeframe").is(":hidden")) {
                $("#completeframe").hide();
                $("#lightcartinfo").show();
            } else {
                $("#completeframe").show();
                $("#lightcartinfo").hide();
            }
        })
        countZje();
	})
</script>
</head>
<body>


	<div class="mainbox">
		<div class="adbox">
			<ul class="pic_list">
				<li style="display: block"><a href="#" title=""><img
						alt="1" src="<%=root%>/images/temp1.png" /></a></li>
				<li><a href="#" title=""><img alt="2"
						src="<%=root%>/images/temp2.png" /></a></li>
				<li><a href="#" title=""><img alt="2"
						src="<%=root%>/images/temp3.png" /></a></li>

			</ul>
			<div class="title_nav">
				<a href="#" class="select">相约情人节全场119元起</a> <a href="#">新款上线全场357元起</a>
				<a href="#">愤怒小鸟特卖全场89元</a>
			</div>
		</div>
	</div>



	<!--  <div class="prolistmenu mainbox"></div>   隐藏这个空白的分割行 -->

	<div class="mainbox prolist-box clearfix">
		<ul id="prolist">
			<s:iterator value="pager.rows" id="row" status="s">
				<li class="fore3">
					<div class="p-name">
						<a title="<s:property value='#row.spmc'/>"
							href="javascript:void(0)"
							onclick="productDetail(<s:property value='#row.sp_dm'/>)"><s:property
								value='#row.spmc' /></a>
					</div>
					<div class="p-img">
						<!-- 这样的写法，在ie下会在当前页面基础上新弹出两个窗口 ，其中一个是空白的javascript:void(0)，而在chrome下则是直接跳转 -->
						<a title="<s:property value='#row.spmc'/>"
							href="javascript:void(0)"
							onclick="productDetail(<s:property value='#row.sp_dm'/>)"> <img
							width="160" height="160" alt="<s:property value='#row.spmc'/>"
							src="http://img10.360buyimg.com/n2/g14/M05/00/0A/rBEhVVKC7lwIAAAAAAIZnKYaWdMAAFjhAPvmzwAAhm0694.jpg" />
						</a>
					</div>
					<div class="p-price">
						<s:if test="#session.session_khxx==null">
							<span>市场价：</span>
							<strong class="J-p-1123632">¥<s:property
									value="#row.scjg" /></strong>
						</s:if>
						<s:if test="#session.session_khxx!=null">
							<span> 平台价：</span>
							<strong class="J-p-1123632">¥<s:property
									value="#row['jg'+#session.session_khxx.qdsJb]" /></strong>
							<br>
							<span>订购数量：<input type="text" class="easyui-numberbox"
								data-options="min:1,max:10000" name="name"
								id="<s:property value='#row.sp_dm'/>" value=" 1"
								style="text-align: center;width:80px;" />
							</span>
							<br>
							<span style="text-align: center;width:100%;"><a
								class="btn-buy" style="text-align: center;" href="javaScript:;"
								onclick="addShopCart(<s:property value='#row.sp_dm'/>)">加入购物车</a></span>
						</s:if>
					</div>
				</li>
			</s:iterator>
		</ul>
	</div>
	<div id="pager" align="center">
		<s:if test="pager.total==null">
			<strong>无符合条件的产品，请尝试其他搜索条件</strong>
		</s:if>
		<s:else>
			<s:hidden name="pager.total" id="recordTotal"></s:hidden>
			<s:hidden name="pager.pageTotal" id="pageTotal"></s:hidden>
			<script type="text/javascript">
				kkpager.generPageHtml({
					pno : $('#page').val(),
					total : $('#pageTotal').val(),
					totalRecords :$('#recordTotal').val(),
					click : function(n){
						catalogSearch(null,n);
					}
				});
				</script>
		</s:else>
	</div>
	<s:set name="khxx" value="#session.session_khxx"></s:set>
	<input type="hidden" value="<s:property value='#khxx.fzrXm'/>"
		id="hid_fzrXm">
	<input type="hidden" value="<s:property value='#khxx.lxdh'/>"
		id="hid_lxdh">
	<input type="hidden" value="<s:property value='#khxx.lxdz'/>"
		id="hid_lxdz">
	<div id="userInfo" class="easyui-window " title="修改收货人信息"
		data-options="modal:true,closed:true,iconCls:'icon-save',minimizable:false,maximizable:false,collapsible:false"
		style="width:500px;height:200px;padding:10px;">
		<dir class="useraddr">
			<span style="width:80px; alaign" />收货人：
			</span>
			<input class="easyui-textbox" style="width:150px;" id="fzrXm"
				name="fzrXm" maxlength="15"
				value="<s:property value="#khxx.fzrXm" />">
			<p></p>
			<span style="width:80px; " /> 联系电话：
			</span>
			<input class="easyui-textbox" style="width:150px;" id="lxdh"
				name="lxdh" maxlength="12" value="<s:property value="#khxx.lxdh" />">
			<p></p>
			<span style="width:80px; " /> 详细地址：
			</span>
			<input class="easyui-textbox" style="width:300px;" id="lxdz"
				name="lxdz" maxlength="50" value="<s:property value="#khxx.lxdz" />">
			<p></p>
			<input type="button" class="btn4" onclick="updateUserInfo();"
				value="保存" />
			<input type="button" class="btn4" onclick="cancel();" value="取消" />
		</dir>
	</div>
	<s:include value="foot.html"></s:include>
	<s:if test="#session.session_khxx!=null">
		<div class="addcart">
			<div class="strip" id="strip"></div>
			<div class="completeframe" id="completeframe">
				<table class="easyui-datagrid" id="datagrid" style="height: 200px;"
					width="100%;" title="购物车列表信息"
					data-options="
                            singleSelect:true,
                            collapsible:true,
                            rownumbers:true,
                            url:'<%=root%>/initShopCart.action',
                            onLoadSuccess:countZje,
                            method:'post'">
					<thead>
						<tr>
							<th data-options="field:'SPMC',width:450,align:'right'">商品信息</th>
							<th
								data-options="field:'JG',align:'right',width:150,resizable:true">单价</th>
							<th
								data-options="field:'SP_SL',align:'center',width:150,resizable:true,formatter:getSl">数量</th>
							<th
								data-options="field:'ZJ',width:150,align:'right',resizable:true,formatter:getPrice">实际应付款</th>
							<th
								data-options="field:'SP_DM',align:'right',width:150,resizable:true,formatter:deleteSpdm">操作</th>
						</tr>
					</thead>
				</table>
				<script type="text/javascript">
            </script>

				<table style="width:100%;" class="ordertotal">
					<tr>
						<td style="text-align:center;width:200px;">配送方式： <select
							class="easyui-combobox" editable="false" style="width:100px;"
							name="psfsdm" id="psfsdm">
								<s:iterator value="psfsList" id="item" status="s">
									<option value="<s:property value='#item.psfsdm'/>"><s:property
											value='#item.psfsmc' /></option>
								</s:iterator>
						</select>
						</td>
						<td style="text-align:left;width:600px;">收货人信息： <a href="javascript:;"  onclick="$('#userInfo').window('open')"  title="点击修改收货人信息"
							class="useraddr" id="userInfo1"> <s:property
									value="#khxx.lxdz" /> （ <s:property value="#khxx.fzrXm" /> ）
								<s:property value="#khxx.lxdh" /></a></td>
						<td style="text-align:right">共计:<span class="b fred"
							id="zsl"></span> 件 应付款金额：<span class="b fred" id="zje"></span></td>
						<td style="text-align:right;width:200px;"><input
							type="button" style="vertical-align:middle; margin-top:-3px;"
							value="生成订单" onclick="saveOrder(this);"> <input
							type="button" style="vertical-align:middle; margin-top:-3px;"
							value="清空购物车" onclick="deleteSp(this);"></td>
					</tr>
				</table>
			</div>
			<div class="lightcartinfo" id="lightcartinfo" style="display:none;">
				<span class="unitext  "> 共计: <span class="b fred" id="zsl1"></span>
					件 应付款金额： <span class="b fred" id="zje1"></span> <input
					type="button" style="vertical-align:middle; margin-top:-3px;"
					value="修改" id="updateShopCart"> &nbsp;&nbsp;&nbsp;&nbsp; <input
					type="button" style="vertical-align:middle; margin-top:-3px;"
					value="清空购物车" onclick="deleteSp(this);">
				</span>
				<p class=""></p>
			</div>
			<script type="text/javascript">
    function getPrice(value,rowData,rowIndex)
    {     
    	return toDecimal2(value); 
    }
    function getSl(value,rowData,rowIndex)
    {     
    	var div = "<input id='spsl"+rowData.SP_DM+"' value='"+value+"'  type='text'  onkeypress=\"return event.keyCode>=48&&event.keyCode<=57\" onblur=\"changeShopCart(this,'"+rowData.SP_DM+"')\"/>";         
    	return div; 
    }
    
    function changeShopCart(obj,spdm){
    	if(isNaN(obj.value)){obj.value='1'}
    	var data=$('#datagrid').datagrid("getData");
    	for(var i=0;i<data.total;i++){
			if(data.rows[i].SP_DM==spdm){
				$('#datagrid').datagrid('updateRow',{
					index: i,
					row: {
						SP_SL: obj.value,
						ZJ: toDecimal2(parseInt(obj.value)*parseFloat(data.rows[i].JG))
					}
				});
			}
    	}	
    	countZje();
    	$.ajax({ type : "POST", async : false, cache : false, url : root + "/doUpdateSl.action?" + Math.random(),// 请求的action路径
			data : { "spdm" :spdm, "spsl" : obj.value } });
    }
    
    function deleteSpdm(value,rowData,rowIndex){
    	return "<a href='javascript:;' onclick='deleteBySpdm("+value+")'>删除</a>";
    }
    
	function countZje()
	{
		var zj=0.00;
    	var sl=0;
    	var data=$('#datagrid').datagrid("getData");
    	for(var i=0;i<data.total;i++){
    		zj+=parseFloat(data.rows[i].ZJ);
    		sl+=parseInt(data.rows[i].SP_SL);
    	}	
    	$("#zje").text("￥"+toDecimal2(zj));
		$("#zsl").text(sl);
		$("#zje1").text("￥"+toDecimal2(zj));
		$("#zsl1").text(sl);
	}

    
    function deleteBySpdm(spdm)
	{
		$.messager.confirm('删除商品', '确定从购物车中删除此商品？', function(value)
		{
			if (value)
			{
				$.ajax({ type : "POST", async : false, cache : false, url : root + "/doDeleteSp.action?" + Math.random(),// 请求的action路径
				data : { "spdm" : spdm }, success : function(msg)
				{
					if (msg == "true")
					{
						for(var i=0;i<$('#datagrid').datagrid("getData").total;i++){
							if($('#datagrid').datagrid("getData").rows[i].SP_DM==spdm){
				    	          $('#datagrid').datagrid("deleteRow",i);
				    	          break;
							}
				    	}
						countZje();
					}
					else
					{
						$.messager.alert('提示信息', '删除商品失败!', 'info');
					}
				} })
			}
		}); 
	}
    
    
    function saveOrder(obj)
	{
    	 var spdmArr="";
    	 var data1= $('#datagrid').datagrid("getData");
    	 for(var i=0;i<data1.total;i++){
 			spdmArr += data1.rows[i].SP_DM + ",";
 		}
    $("<div class=\"datagrid-mask\"></div>").css({display:"block",width:"100%",height:$(window).height()}).appendTo("body:first");//等待效果显示在wnavt控件
    $("<div class=\"datagrid-mask-msg\"></div>").html("请稍等，正在生成订单...").appendTo("body:first").css({display:"block",left:($(window).width()/2-50),top:$(window).height()/2}); 
    	$.ajax({
			type : "POST",
			async : false,
			cache : false,
			url : root + "/addOrder.action?" + Math.random(),// 请求的action路径
			data : { "spdm" :spdmArr,"psfsdm":$("#psfsdm").val() },
			success : function(msg)
			{
				$("body:first").find("div.datagrid-mask-msg").remove();
                $("body:first").find("div.datagrid-mask").remove();
				if (msg == "true")
				{
					$.messager.alert('提示信息', '订单已生成!', 'info');
					//$('#datagrid').datagrid('reload');
					window.location = root + "/userOrder.action";
				}
				else
				{
					$.messager.alert('提示信息', '订单生成失败!', 'info');
				}
			} });
		}
    
    function deleteSp(obj)
	{
		var spdmArr = "";
    	 var data1= $('#datagrid').datagrid("getData");
    	 for(var i=0;i<data1.total;i++){
 			spdmArr += data1.rows[i].SP_DM + ",";
 		}
		$.messager.confirm('清空商品', '确定从购物车中清空所有商品？', function(value)
		{
			if (value)
			{
				$.ajax({ type : "POST", async : false, cache : false, url : root + "/doDeleteSp.action?" + Math.random(),// 请求的action路径
				data : { "spdm" : spdmArr }, success : function(msg)
				{
					if (msg == "true")
					{
						for(var i=$('#datagrid').datagrid("getData").total-1;i>=0;i--){
				    	          $('#datagrid').datagrid("deleteRow",i);
				    	}
						countZje();
					}
					else
					{
						$.messager.alert('提示信息', '删除商品失败!', 'info');
					}
				} })
			}
		});
	}
    
    
    function addShopCart(spdm){
		var spsl=$("#"+spdm).val();
		$.ajax({
			type : "post",
			url : root+"/addToShopCart.action?"+Math.random(),
			data : {
				"spdm" :spdm,
				"spsl":spsl
			},
			async : false,
			error : function() {
				$.messager.alert('提示信息','添加商品失败！','info');
			},
			success : function(data) {
				if(data=="true"){
					$.messager.alert('提示信息','添加商品到购物车成功！','info');
					 $('#datagrid').datagrid('load',{});
		             $("#completeframe").show();
		             $("#lightcartinfo").hide();
				}else{
					$.messager.alert('提示信息','添加商品失败！','info');
				}
			}
		});
    }
    
    
    function cancel()
	{
		$.messager.confirm('取消', '确定取消修改?', function(value)
		{
			if (value)
			{
				$('#fzrXm').val($('#hid_fzrXm').val());
				$('#lxdh').val($('#hid_lxdh').val());
				$('#lxdz').val($('#hid_lxdz').val());
				$('#userInfo').window('close');
			}
		});
	}

	function updateUserInfo()
	{
		$.ajax({
			type : "POST",
			async : false,
			cache : false,
			url : root + "/doUserInfo.action?" + Math.random(),// 请求的action路径
			data : { "fzrXm" : $.trim($('#fzrXm').val()), "lxdh" : $.trim($('#lxdh').val()), "lxdz" : $.trim($('#lxdz').val()) },
			success : function(msg)
			{
				if (msg == "true")
				{
					$('#hid_fzrXm').val($('#fzrXm').val());
					$('#hid_lxdh').val($('#lxdh').val());
					$('#hid_lxdz').val($('#lxdz').val());
					$('#userInfo1').html(
							$('#lxdz').val() + "（" + $('#fzrXm').val() + "）" + $('#lxdh').val()
									+ "&nbsp;&nbsp;<input type=\"button\" name=\"name\" class=\"btn4\" onclick=\"$('#userInfo').window('open')\" value=\"修改\" />");
					$('#userInfo').window('close');
				}
				else
				{
					$.messager.alert('提示信息', '修改收货人信息失败!', 'info');
				}
			} })
	}
</script>
		</div>
	</s:if>
</body>
</html>