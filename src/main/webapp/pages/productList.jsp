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
	       $("#strip").click(function () {
            if (!$("#completeframe").is(":hidden")) {
                $("#completeframe").hide();
                $("#lightcartinfo").show();
            } else {
                $("#completeframe").show();
                $("#lightcartinfo").hide();
            }
        })
       var data1= $('#datagrid').datagrid("getData");
		var zje=0;
		var count=0;
		for(var i=0;i<data1.total;i++){
			zje+=data1.rows[i].ZJ;
			count+=parseInt(data1.rows[i].SP_SL);
		}
		$("#zje").text("￥"+zje);
		$("#zsl").text(count);
		$("#zje1").text("￥"+zje);
		$("#zsl1").text(count);
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
								name="name" value=" 1" style="text-align: center;width:80px;" />
							</span>
							<br>
							<span style="text-align: center;width:100%;"><a
								class="btn-buy" style="text-align: center;" href="javaScript:;"
								onclick="addShopCart()">加入购物车</a></span>
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
	<s:include value="foot.html"></s:include>
	<script type="text/javascript">
	//var data=[{ 'SP_DM': '1', 'SPMC': 'Koi', 'JG': 10.00, 'SP_SL': '1', 'ZJ': 36.50} ];
	var data=[{"SP_SL":"2", "KH_DM":1, "JG1":120.30, "ZJ2":260.00, "JG2":130.00, "ZJ3":280.00, "BJRY_DM":"null", "JG3":140.00, "ZJ0":200.00, "TJSJ":"2014-12-01 18:13:22.0","ZJ1":240.60, "DELETE":"<a href='javascript:;' onclick='deleteBySpdm(1)'>删除</a>", "ZJ":240.60, "SPMC":"铁三角CKR5" , "JG0":100.00,  "SP_DM":1,  "JG":120.30},{"SP_SL":"2", "KH_DM":1, "JG1":120.30, "ZJ2":260.00, "JG2":130.00, "ZJ3":280.00, "BJRY_DM":"null", "JG3":140.00, "ZJ0":200.00, "TJSJ":"2014-12-01 18:13:22.0","ZJ1":240.60, "DELETE":"<a href='javascript:;' onclick='deleteBySpdm(1)'>删除</a>", "ZJ":240.60, "SPMC":"铁三角CKR5" , "JG0":100.00,  "SP_DM":1,  "JG":120.30}];
</script>
	</script>
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
                            data:data,method:'get',
                onClickCell: onClickCell">
					<thead>
						<tr>
							<th data-options="field:'SPMC',width:450,align:'right'">商品信息</th>
							<th
								data-options="field:'JG',align:'right',width:150,resizable:true">单价</th>
							<th
								data-options="field:'SP_SL',align:'center',width:150,resizable:true,editor:{type:'numberbox'}">数量&nbsp;<font
								color="red">(*单击可修改数量)</font></th>
							<th
								data-options="field:'ZJ',width:150,align:'right',resizable:true">实际应付款</th>
							<th
								data-options="field:'DELETE',align:'right',width:150,resizable:true">操作</th>
						</tr>
					</thead>
				</table>
				<script type="text/javascript">
            </script>

				<table style="width:100%;" class="ordertotal">
					<tr>
						<td style="text-align:right">共计:<span class="b fred" id="zsl"></span>
							件 应付款金额：<span class="b fred" id="zje"></span></td>
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
					件 应付款金额： <span class="b fred" id="zje1"></span>
					&nbsp;&nbsp;&nbsp;&nbsp; <input type="button"
					style="vertical-align:middle; margin-top:-3px;" value="生成订单"
					onclick="saveOrder(this);"> <input type="button"
					style="vertical-align:middle; margin-top:-3px;" value="清空购物车"
					onclick="deleteSp(this);">
				</span>
				<p class=""></p>
			</div>
			<script type="text/javascript">
    $.extend($.fn.datagrid.methods, {
        editCell: function(jq,param){
            return jq.each(function(){
                var opts = $(this).datagrid('options');
                var fields = $(this).datagrid('getColumnFields',true).concat($(this).datagrid('getColumnFields'));
                for(var i=0; i<fields.length; i++){
                    var col = $(this).datagrid('getColumnOption', fields[i]);
                    col.editor1 = col.editor;
                    if (fields[i] != param.field){
                        col.editor = null;
                    }
                }
                $(this).datagrid('beginEdit', param.index);
                for(var i=0; i<fields.length; i++){
                    var col = $(this).datagrid('getColumnOption', fields[i]);
                    col.editor = col.editor1;
                }
            });
        }
    });
    
    var editIndex = undefined;
    function endEditing(){
        if (editIndex == undefined){return true}
        if ($('#datagrid').datagrid('validateRow', editIndex)){
            $('#datagrid').datagrid('endEdit', editIndex);
            editIndex = undefined;
            return true;
        } else {
            return false;
        }
    }
    function onClickCell(index, field){
        if (endEditing()){
            $('#datagrid').datagrid('selectRow', index)
                    .datagrid('editCell', {index:index,field:field});
            editIndex = index;
        }
    }
    
    
    function saveOrder(obj)
	{
    	 var spdmArr="";
    	 var data1= $('#datagrid').datagrid("getData");
    	 for(var i=0;i<data1.total;i++){
 			spdmArr += data1.rows[i].SP_DM + ",";
 		}
    	$.ajax({
			type : "POST",
			async : false,
			cache : false,
			url : root + "/saveOrder.action?" + Math.random(),// 请求的action路径
			data : { "spdm" :spdmArr },
			success : function(msg)
			{
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
						  $('#datagrid').datagrid('reload');
					}
					else
					{
						$.messager.alert('提示信息', '删除商品失败!', 'info');
					}
				} })
			}
		});
	}
</script>
		</div>
	</s:if>
</body>
</html>