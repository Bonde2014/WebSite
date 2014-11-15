<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="base.jsp"%>
<%@include file="top.jsp"%>
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
	    //轮换广告图片
		$(".adbox").turnPic();
		//刷新商品分类导航区域
		requestCatalogTree();
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


	<div class="mainbox index-typett index-icon1">
		<span class="typetext">电脑整机</span>
		<ul>
			<li><a href="#">笔记本</a></li>
			<li><a href="#">台机</a></li>
			<li><a href="#">苹果系列</a></li>
			<li><a href="#">一体机</a></li>
		</ul>
	</div>


	<div class="mainbox pro-box">
		<div class="probox">
			<img src="<%=root%>/images/temp4.png" /> <span class="title">扬天S320
				G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
		</div>
		<div class="probox">
			<img src="<%=root%>/images/temp4.png" /> <span class="title">扬天S320
				G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
		</div>
		<div class="probox">
			<img src="<%=root%>/images/temp4.png" /> <span class="title">扬天S320
				G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
		</div>
		<div class="probox">
			<img src="<%=root%>/images/temp4.png" /> <span class="title">扬天S320
				G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
		</div>
		<div class="probox">
			<img src="<%=root%>/images/temp4.png" /> <span class="title">扬天S320
				G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
		</div>
	</div>



	<div class="mainbox index-typett index-icon2">
		<span class="typetext">电脑整机</span>
		<ul>
			<li><a href="#">笔记本</a></li>
			<li><a href="#">台机</a></li>
			<li><a href="#">苹果系列</a></li>
			<li><a href="#">一体机</a></li>
		</ul>
	</div>


	<div class="mainbox pro-box">
		<div class="probox">
			<img src="<%=root%>/images/temp4.png" /> <span class="title">扬天S320
				G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
		</div>
		<div class="probox">
			<img src="<%=root%>/images/temp4.png" /> <span class="title">扬天S320
				G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
		</div>
		<div class="probox">
			<img src="<%=root%>/images/temp4.png" /> <span class="title">扬天S320
				G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
		</div>
		<div class="probox">
			<img src="<%=root%>/images/temp4.png" /> <span class="title">扬天S320
				G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
		</div>
		<div class="probox">
			<img src="<%=root%>/images/temp4.png" /> <span class="title">扬天S320
				G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
		</div>
	</div>





	<div class="mainbox index-typett index-icon3">
		<span class="typetext">电脑整机</span>
		<ul>
			<li><a href="#">笔记本</a></li>
			<li><a href="#">台机</a></li>
			<li><a href="#">苹果系列</a></li>
			<li><a href="#">一体机</a></li>
		</ul>
	</div>


	<div class="mainbox pro-box">
		<div class="probox">
			<img src="<%=root%>/images/temp4.png" /> <span class="title">扬天S320
				G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
		</div>
		<div class="probox">
			<img src="<%=root%>/images/temp4.png" /> <span class="title">扬天S320
				G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
		</div>
		<div class="probox">
			<img src="<%=root%>/images/temp4.png" /> <span class="title">扬天S320
				G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
		</div>
		<div class="probox">
			<img src="<%=root%>/images/temp4.png" /> <span class="title">扬天S320
				G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
		</div>
		<div class="probox">
			<img src="<%=root%>/images/temp4.png" /> <span class="title">扬天S320
				G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
		</div>
	</div>





	<div class="mainbox index-typett index-icon4">
		<span class="typetext">电脑整机</span>
		<ul>
			<li><a href="#">笔记本</a></li>
			<li><a href="#">台机</a></li>
			<li><a href="#">苹果系列</a></li>
			<li><a href="#">一体机</a></li>
		</ul>
	</div>


	<div class="mainbox pro-box">
		<div class="probox">
			<img src="<%=root%>/images/temp4.png" /> <span class="title">扬天S320
				G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
		</div>
		<div class="probox">
			<img src="<%=root%>/images/temp4.png" /> <span class="title">扬天S320
				G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
		</div>
		<div class="probox">
			<img src="<%=root%>/images/temp4.png" /> <span class="title">扬天S320
				G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
		</div>
		<div class="probox">
			<img src="<%=root%>/images/temp4.png" /> <span class="title">扬天S320
				G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
		</div>
		<div class="probox">
			<img src="<%=root%>/images/temp4.png" /> <span class="title">扬天S320
				G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
		</div>
	</div>





	<div class="mainbox index-typett index-icon5">
		<span class="typetext">电脑整机</span>
		<ul>
			<li><a href="#">笔记本</a></li>
			<li><a href="#">台机</a></li>
			<li><a href="#">苹果系列</a></li>
			<li><a href="#">一体机</a></li>
		</ul>
	</div>


	<div class="mainbox pro-box">
		<div class="probox">
			<img src="<%=root%>/images/temp4.png" /> <span class="title">扬天S320
				G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
		</div>
		<div class="probox">
			<img src="<%=root%>/images/temp4.png" /> <span class="title">扬天S320
				G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
		</div>
		<div class="probox">
			<img src="<%=root%>/images/temp4.png" /> <span class="title">扬天S320
				G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
		</div>
		<div class="probox">
			<img src="<%=root%>/images/temp4.png" /> <span class="title">扬天S320
				G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
		</div>
		<div class="probox">
			<img src="<%=root%>/images/temp4.png" /> <span class="title">扬天S320
				G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
		</div>
	</div>






	<div class="mainbox index-typett index-icon6">
		<span class="typetext">电脑整机</span>
		<ul>
			<li><a href="#">笔记本</a></li>
			<li><a href="#">台机</a></li>
			<li><a href="#">苹果系列</a></li>
			<li><a href="#">一体机</a></li>
		</ul>
	</div>


	<div class="mainbox pro-box">
		<div class="probox">
			<img src="<%=root%>/images/temp4.png" /> <span class="title">扬天S320
				G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
		</div>
		<div class="probox">
			<img src="<%=root%>/images/temp4.png" /> <span class="title">扬天S320
				G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
		</div>
		<div class="probox">
			<img src="<%=root%>/images/temp4.png" /> <span class="title">扬天S320
				G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
		</div>
		<div class="probox">
			<img src="<%=root%>/images/temp4.png" /> <span class="title">扬天S320
				G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
		</div>
		<div class="probox">
			<img src="<%=root%>/images/temp4.png" /> <span class="title">扬天S320
				G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
		</div>
	</div>
<s:include value="foot.html"></s:include>
</body>
</html>