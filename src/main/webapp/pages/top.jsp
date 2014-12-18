<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
$(function () {
	
	//先加载数据
	requestCatalogTree($('#catalog').val());
	//再为相应元素绑定事件
	$("#menutype").click(function () {
	    if ($("#catalogtree").is(":hidden")) {
	        $("#catalogtree").show();
	        //$("#catalogtree_dispaly").hide();
	    } else {
	        $("#catalogtree").hide();
	        //$("#catalogtree_dispaly").show();
	    }
	})
	
	$("#catalogtree>li").hover(function () {
	    $(".othermenu").hide();
	    $(".lihover").removeClass("lihover");

	    $(this).find(".othermenu").show();
	    $(this).addClass("lihover")
	})
	$("#catalogtree").mouseleave(function () {
	    $(".othermenu").hide();
	    $(".lihover").removeClass("lihover")
	})		
})
</script>
</head>
<body>
	<form action="" id="searchForm" method="get">
    <div class="logotop mainbox">
        <div class="search">
            <div class="searchinput">
                <s:hidden id="page"  name="searchFindEntity.page"></s:hidden>
                <s:hidden id="catalog"  name="searchFindEntity.catalog"></s:hidden>
                <s:textfield name="searchFindEntity.keyword" id="keyword" maxLength="100"></s:textfield>
                <div class="searchbtn" onclick="productSearch()">搜索</div>
            </div>
            <!-- 隐藏搜索热词、去购物车结算等链接
            <div class="checkout" onclick="pageLink('/goShopcart.do')">去购物车结算 <span class="righticon"></span></div>
             -->
        </div>
        <div class="logo"></div>
    </div>
    </form>
    
	<div class="global_menu">
		<div class="mainbox">
			<div class="bigmenu">
				<h1 style="cursor:pointer" id="menutype">全部商品分类</h1>
				<!-- <ul id="catalogtree_dispaly"></ul>   -->
				<ul style="display:none" id="catalogtree"></ul>
			</div>
			<ul class="topmenu">
				<li onclick="pageLink('/init.do')">首页</li>
				<li onclick="pageLink('/todayPrice.action')">今日报价</li>
				<li onclick="pageLink('/searchCatalog.action')">订购中心</li>
				<li>待扩展功能</li>
			</ul>
		</div>
	</div>
</body>
</html>
