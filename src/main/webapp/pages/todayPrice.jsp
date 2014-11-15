<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<%=root%>/scripts/catalogtree.js"></script>
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

.title_nav a.select {
	background: #09C url(../images/sanj.gif) no-repeat center 47px
}
</style>
<script type="text/javascript">

	$(function() {
		$("table tr").hover(function() {
			$(this).addClass("current");
		}, function() {
			$(this).removeClass("current");
		})
	
		$("#siwtchbox div").SwichBox({
			def : "def",
			chg : "chg",
			chglist : "#daynow table",
			bindevent : "click"
		})
		
	})
	
	
</script>
</head>
<body>
	<div class="topnav mainbox">
		<div class="breadcrumb">
			<strong><a href="<%=root%>/pages/index.jsp">首页</a>
				&nbsp;&gt;&nbsp;<a href="<%=root%>/todayPrice.do">今日报价</a></strong>
		</div>
	</div>

	<div class="mainbox daynow " id="daynow">

		<div class="siwtchbox" id="siwtchbox">
			<s:iterator value="oneLevelCategoryList" id="spfl">
				<div class="chg"
					onclick="queryPrice(<s:property value="#spfl.spflDm"/>)">
					<s:property value="#spfl.spflMc" />
				</div>
			</s:iterator>
		</div>
		<s:iterator value="todayPriceList" id="list" status="st">
			<table width="100%" border="1" cellspacing="0" cellpadding="0">
				<tr>
					<th style="width: 245px">商品名称</th>
					<th>商品分类</th>
					<th>品牌</th>
					<th>市场价</th>
					<th>平台销售价</th>
					<th>可售数量</th>
					<th>最后报价时间</th>
				</tr>
				<s:iterator value="list" id="map" status="s">
					<tr>
						<td><a href="javascprit:void(0)" class="link"
							onclick="productDetail(<s:property value='#map.spDm' />)"><s:property
									value="#map.spmc" /></a></td>
						<td><s:property value="#map.spflMc" /></td>
						<td><s:property value="#map.spppMc" /></td>
						<td class="mktprice"><s:property value="#map.scjg" /></td>
						<td class="avlprice">
							<s:property value="#map['jg'+#session.session_khxx.qdsJb]" />
						</td>
						<td><s:property value="#map.kssl" /></td>
						<td><s:property value="#map.bjsj" /></td>
					</tr>
				</s:iterator>
			</table>
		</s:iterator>
	</div>
	<s:include value="foot.html"></s:include>
</body>
</html>