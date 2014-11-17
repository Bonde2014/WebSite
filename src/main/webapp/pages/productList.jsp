<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/pages/base.jsp"%>
<%@include file="/pages/top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="<%=root%>/css/pager.css">
<script type="text/javascript" src="<%=root%>/scripts/pager.js"></script>
<title>克莱姆购物平台</title>
<script type="text/javascript">
	$(function() {
		$(".adbox").turnPic();
		//刷新商品分类导航区域
		requestCatalogTree($('#catalog').val());
	})
</script>
</head>
<body>
	<div class="global_menu">
		<div class="mainbox">
			<div class="bigmenu">
				<h1 onclick="pageLink('/init.do')">全部商品分类</h1>
				<ul id="catalogtree">
				</ul>
			</div>
			<ul class="topmenu">
				<li onclick="pageLink('/todayPrice.do')">今日报价</li>
				<li onclick="pageLink('/init.do')">首页</li>
				<li>特价专区</li>
				<li>自助装机</li>
			</ul>

		</div>
	</div>

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



	<div class="prolistmenu mainbox"></div>

	<div class="mainbox prolist-box clearfix">
		<ul>
			<s:iterator value="pager.rows" id="row" status="s">
				<li class="fore3">
					<div class="p-name">
						<a title="<s:property value='#row.spmc'/>"
							href="javascript:void(0)"
							onclick="productDetail(<s:property value='#row.sp_dm'/>)"><s:property
								value='#row.spmc' /></a>
					</div>
					<div class="p-img">
						<a target="_blank" title="<s:property value='#row.spmc'/>"
							href="javascript:void(0)"> <img width="160" height="160"
							src="" onclick="productDetail(<s:property value='#row.sp_dm'/>)" />
						</a>
					</div>
					<div class="p-price">
						市场价：<strong><s:property value="#row.scjg" /></strong><br /> 平台价：
						<strong><s:property
								value="#row['jg'+#session.session_khxx.qdsJb]" /></strong><br>
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
</body>
</html>