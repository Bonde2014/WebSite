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
</head>
<body>
	<div class="topnav mainbox">
		<div class="breadcrumb">
			<span><a href="<%=root%>/init.do">首页</a>
				&nbsp;&gt;&nbsp;<a href="javascript:void(0)" onclick="productSearch()">产品搜索</a></span>
		</div>
	</div>
	<div class="prolistmenu mainbox"></div>
	<div class="mainbox prolist-box clearfix">
		<ul>
			<s:iterator value="pager.rows" id="row" status="s">
				<li class="fore3">
					<div class="p-name">
						<a title="<s:property value='#row.spmc'/>" href="javascript:void(0)" onclick="productDetail(<s:property value='#row.sp_dm'/>)"><s:property value='#row.spmc'/></a>
					</div>
					<div class="p-img">
						<a target="_blank" title="<s:property value='#row.spmc'/>" href="javascript:void(0)" onclick="productDetail(<s:property value='#row.sp_dm'/>" > 
						<img width="160" height="160" data-src="done"  data-img="1"
							src="http://img10.360buyimg.com/n2/jfs/t148/126/2809753935/89809/72561fe3/53d9f4c2N062a10af.jpg"
							class="" data-lazy-img="done" data-lazyload="done">
						</a>
					</div>
					<div class="p-price">
						市场价：<strong><s:property value="#row.scjg"/></strong><br /> 
						平台价： <strong><s:property value="#row['jg'+#session.session_khxx.qdsJb]" /></strong><br>
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
						productSearch(null,null,n);
					}
				});
			</script>
		</s:else>
	</div>
	<s:include value="foot.html"></s:include>
</body>
</html>