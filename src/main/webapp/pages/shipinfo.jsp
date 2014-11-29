<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="base.jsp"%>
<%@include file="/pages/top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>克莱姆购物平台</title>
</head>
<body>
	<div class="topnav mainbox">
		<div class="breadcrumb">
			<span><a href="<%=root%>/init.do">首页</a> &nbsp;&gt;&nbsp;<a
				href="<%=root%>/userCenter.action">渠道商</a></span>
		</div>
	</div>
	<form id="form" class="easyui-form" method="post">
		<s:token />
		<s:set name="khxx" value="#session.session_khxx"></s:set>
		<input type="hidden" value="<s:property value='#khxx.fzrXm'/>"
			id="hid_fzrXm"> <input type="hidden"
			value="<s:property value='#khxx.lxdh'/>" id="hid_lxdh"> <input
			type="hidden" value="<s:property value='#khxx.lxdz'/>" id="hid_lxdz">
		<div class="mainbox usermain clearfix">
			<div class="user-right">
				<div class="shiptitle">
					<h3>请选择配送方式：</h3>
					<select class="easyui-combobox" editable="false"
						style="width:100px;" name="psfsdm">
						<s:iterator value="psfsList" id="item" status="s">
							<option value="<s:property value='#item.psfsdm'/>"><s:property
									value='#item.psfsmc' /></option>
						</s:iterator>
					</select>
				</div>
				<div class="shiptitle">
					<h3>请确认收货人信息：</h3>
					<div class="useraddr" id="userInfo1">
						<s:property value="#khxx.lxdz" />
						（
						<s:property value="#khxx.fzrXm" />
						）
						<s:property value="#khxx.lxdh" />
						&nbsp;&nbsp; <input type="button" name="name" class="btn4"
							onclick="$('#userInfo').window('open')" value="修改" />
					</div>
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
								name="lxdh" maxlength="12"
								value="<s:property value="#khxx.lxdh" />">
							<p></p>
							<span style="width:80px; " /> 详细地址：
							</span>
							<input class="easyui-textbox" style="width:300px;" id="lxdz"
								name="lxdz" maxlength="50"
								value="<s:property value="#khxx.lxdz" />">
							<p></p>
							<input type="button" class="btn4" onclick="updateUserInfo();"
								value="保存" />
							<input type="button" class="btn4" onclick="cancel();" value="取消" />
						</dir>
					</div>
				</div>
				<div class="shiptitle">
					<h3>请确认订单信息：</h3>
					<table width="100%" border="1" cellspacing="0" cellpadding="0"
						id="spxx" style="background:#fff;">
						<tr>
							<th style="width:245px">商品信息</th>
							<th>单价</th>
							<th>数量</th>
							<th>实际应付款(元)</th>
							<th style="width:100px;">操作</th>
						</tr>
						<s:iterator value="shopcartList" id="item" status="s">
							<tr>
								<td style="text-align: center;"><a
									href="<%=root%>/searchProduct.do?productId=<s:property value='#item.SP_DM'/>"
									class="link"><s:property value="#item.SPMC" /></a></td>
								<td style="text-align: center;" class="alir" name="spJg"><s:property
										value="#item['JG'+#session.session_khxx.qdsJb]" /></td>
								<td style="text-align: center;"><s:property
										value='#item.SP_SL' /></td>
								<td class="alir" style="text-align: center;" name="spZj"><s:property
										value="#item['ZJ'+#session.session_khxx.qdsJb]" /></td>
								<td style="text-align: center;"><input type="hidden"
									name="spdm" value=" <s:property value='#item.SP_DM'/>" /><a
									href="#" class="btn2" onclick="deleteByIndex(this)">删除</a></td>
							</tr>
						</s:iterator>
					</table>
				</div>
				<div class="total">
					<a href="#" class="btn3" onclick="saveOrder(this);">提交订单</a> <span>合计（不含运费）：<font
						color="red">¥</font><font id="zje" color="red">0</font></span>
				</div>
			</div>
			<div class="user-left">
				<h1>渠道商</h1>
				<ul>
					<li><a href="<%=root%>/userCenter.action">用户中心</a></li>
					<li><a href="<%=root%>/changePasswordInit.action">修改密码</a></li>
					<li><a href="<%=root%>/goShopcart.action" class="current">我的购物车</a></li>
					<li><a href="<%=root%>/userOrder.action">我的订单</a></li>
					<li><a href="#">汇款方式</a></li>
				</ul>
			</div>
		</div>
	</form>
	<script type="text/javascript">
		function toDecimal2(x)
		{
			var f = parseFloat(x);
			if (isNaN(f))
			{
				return false;
			}
			var f = Math.round(x * 100) / 100;
			var s = f.toString();
			var rs = s.indexOf('.');
			if (rs < 0)
			{
				rs = s.length;
				s += '.';
			}
			while (s.length <= rs + 2)
			{
				s += '0';
			}
			return s;
		}
		function deleteByIndex(obj)
		{
			if ($('#spxx  tr').length == 2)
			{
				$.messager.alert('提示信息', '订单中至少要有一件商品!', 'warning');
				return false;
			}
			$.messager.confirm('删除商品', '确定从购物车中删除此商品？', function(value)
			{
				if (value)
				{
					$(obj).parent().parent().remove();
					countZje();
				}
			});
		}

		function countZje()
		{
			$("#zje").text(toDecimal2("0"));
			$("td[name='spZj']").each(function(i)
			{
				$("#zje").text(toDecimal2(parseFloat($("#zje").text()) + parseFloat($(this).text())));
			});
		}

		$(function()
		{
			$("table a .link").attr("target", "_blank"); 
			countZje();
		});

		function saveOrder(obj)
		{
			$('#form').form('submit', { url : root + "/saveOrder.action?" + Math.random(), onSubmit : function()
			{
			}, success : function(msg)
			{
				if (msg == "true")
				{
					$.messager.alert('提示信息', '订单已生成!', 'info');
					window.location = root + "/userOrder.action";
				}
				else
				{
					$.messager.alert('提示信息', '订单生成失败!', 'info');
				}

			} });
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
	<s:include value="foot.html"></s:include>
</body>
</html>
