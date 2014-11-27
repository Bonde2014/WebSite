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
		
		$("#prolist li").hover(
	            function () {
	                $(this).addClass("bg");
	            },
	            function () {
	                $(this).removeClass("bg");

	            }
	        )
		
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
						<a  title="<s:property value='#row.spmc'/>"
							href="javascript:void(0)"  onclick="productDetail(<s:property value='#row.sp_dm'/>)" > 
							<img width="160" height="160" src="" />
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