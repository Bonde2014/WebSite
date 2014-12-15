<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="base.jsp"%>
<%@include file="top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>克莱姆购物平台</title>

<script type="text/javascript">

	$(function() {
	    //只有首页有轮换广告图片
		$(".adbox").turnPic();
	    //首页默认要显示产品分类导航下拉区域
		$("#catalogtree").show();
	    //TODO：要去掉分类导航顶部的点击事件，以避免点击隐藏，确保商品分类是固定显示效果
		//$("#menutype").click()=null;
	    //TODO:首页要增加热销商品列表
		
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
	
<s:include value="foot.html"></s:include>
</body>
</html>
