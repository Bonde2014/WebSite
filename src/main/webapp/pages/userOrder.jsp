<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="base.jsp"%>
<%@include file="/pages/top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>克莱姆购物平台</title>
<script type="text/javascript">
	function searchOrder(obj)
	{
	
		var value=$(obj).attr("name");
		window.location = root + "/userOrder.action?ddzt=" + value+"&"+Math.random();
	}
	$(function()
	{
			$("#dd${ddzt}").addClass("current");
			$(".link").attr("target", "_blank"); 
	})
</script>
</head>

<body>
	<div class="topnav mainbox">
		<div class="breadcrumb">
			<span><a href="<%=root%>/init.do">首页</a> &nbsp;&gt;&nbsp;<a
				href="<%=root%>/userCenter.action">渠道商</a></span>
		</div>
	</div>
	<div class="mainbox usermain clearfix">
		<div class="user-right">
			<ul class="ordermenu">
				<li class="delorder">订单回收站</li>
				<li id="dd" name=""  onclick="searchOrder(this)"><span>全部订单</span></li>
				<s:iterator value="ddztList" id="ddztMap" >
				<li id="dd<s:property value='#ddztMap.VALUE' />"  name="<s:property value='#ddztMap.VALUE' />" onclick="searchOrder(this)"><span><s:property value='#ddztMap.NAME '/><i>(<s:property value='#ddztMap.DDSL'/>)</i></span></li>
				</s:iterator>
			</ul>

			<s:iterator value="xsddqkList" id="row" status="s">
				<s:set name="flag" value="0" />
				<h4 class="ordertime">
					订单生成时间：
					<s:date name='#row.DDSCSJ' format="yyyy-MM-dd HH:mm:ss" />
					&nbsp;|&nbsp;订单号：
					<s:property value='#row.DDXH' />
					&nbsp;|&nbsp;总计： <span style="color: red;">¥<s:property
							value='#row.DDZJE_GJ ' /></span>
				</h4>
				<table width="100%" border="1" cellspacing="0" cellpadding="0"
					style="margin:0">
					<tr>
						<th style="width:245px">商品信息</th>
						<th>单价</th>
						<th>数量</th>
						<th>实际应付款</th>
						<th>交易状态</th>
						<th style="width:100px;">操作</th>
					</tr>
					<s:iterator value="mapList" id="map" status="st">
						<s:if test="#map.DDID==#row.DDID">
							<tr>
								<td><a
									href="productDetail(<s:property value='#map.SP_DM'/>)"
									class="link"><s:property value='#map.SPMC' /></a></td>
								<td class="alir"><s:property value='#map.SP_JG_CJ' /></td>
								<td><s:property value='#map.SP_SL' /></td>
								<td class="alir"><s:property value='#map.SP_ZJ' /></td>
								<s:if test="#flag==0">
									<td rowspan="<s:property value='#row.SPSL' />"><s:property
											value='#row.NAME' /></td>
									<td rowspan="<s:property value='#row.SPSL' />"><div>
											<a href="#" id="chaKan">查看</a>
										</div>
										<div>
											<p></p>
											<a href="#">取消订单</a>
										</div></td>
									<s:set name="flag" value="1" />
								</s:if>
							</tr>
						</s:if>
					</s:iterator>

				</table>
			</s:iterator>
		</div>
		<div class="user-left">
			<h1>渠道商</h1>
			<ul>
				<li><a href="<%=root%>/userCenter.action">用户中心</a></li>
				<li><a href="<%=root%>/changePasswordInit.action">修改密码</a></li>
				<li><a href="<%=root%>/goShopcart.action">我的购物车</a></li>
				<li><a href="<%=root%>/userOrder.action" class="current">我的订单</a></li>
				<li><a href="#">汇款方式</a></li>
			</ul>
		</div>
	</div>
	<s:include value="foot.html"></s:include>
</body>
</html>
