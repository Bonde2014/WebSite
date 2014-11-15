<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/pages/base.jsp"%>
<%@include file="/pages/top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>克莱姆购物平台</title>
<style>
ul.pic_list {
	width: 790px;
	height: 300px;
	position: relative
}

ul.pic_list li {
	float: left;
	width: 100%;
	height: 300px;
	position: absolute;
	top: 0px;
	left: 0px
}

.title_nav {
	float: left;
	width: 100%;
	height: 52px;
	position: absolute;
	bottom: -10px;
	left: 0px
}

.title_nav a {
	float: left;
	display: inline-block;
	width: 79px;
	margin-right: 1px;
	background: #444;
	padding: 5px 15px;
	text-align: center;
	color: #fff;
	text-decoration: none;
}
</style>
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
				<h1 onclick="catalogSearch()">全部商品分类</h1>
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
							href="javascript:void(0)"
							onclick="productDetail(<s:property value='#row.sp_dm'/>"> <img
							width="160" height="160" data-src="done" data-img="1"
							src="http://img10.360buyimg.com/n2/jfs/t148/126/2809753935/89809/72561fe3/53d9f4c2N062a10af.jpg"
							class="" data-lazy-img="done" data-lazyload="done">
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

	<div class="mainbox"
		style="text-align: center; padding: 10px; height: 50px">
		<ul id="pagination-digg">
			<li class="previous-off">&laquo;上一页</li>
			<li class="active">1</li>
			<li><a href="?page=2">2</a></li>
			<li><a href="?page=3">3</a></li>
			<li><a href="?page=4">4</a></li>
			<li><a href="?page=5">5</a></li>
			<li><a href="?page=6">6</a></li>
			<li><a href="?page=7">7</a></li>
			<li class="next"><a href="?page=8">下一页 &raquo;</a></li>
		</ul>
	</div>
	<s:include value="foot.html"></s:include>
</body>
</html>