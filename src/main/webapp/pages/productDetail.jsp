<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/pages/base.jsp"%>
<%@include file="/pages/top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>克莱姆购物平台</title>
<script type="text/javascript">
	$(function() {
		$("#introtab li").SwichBox({
			def : "none",
			chg : "curr",
			chglist : "#detail .detail",
			bindevent : "click"
		})
	})
</script>
</head>
<body>
	<div class="topnav mainbox">
		<div class="breadcrumb">
			<strong>
				<a href="<%=root%>/init.do">首页</a>
				<s:iterator value="spflList">
					&nbsp;&gt;&nbsp;<a href="javascript:void(0)" onclick="catalogSearch(<s:property value='spflDm'/>)" >
						<s:property value="spflMc"/>
					</a>
				</s:iterator>
			</strong>
		</div>
	</div>

	<div class="mainbox">
		<div id="product-intro" class="product-intro">
			<div id="name" class="name">
				<h1><s:property value="productMap.spmc"/></h1>
				<div id="sku_adwords"><s:property value="productMap.tzms"/></div>
			</div>
			<!--name end-->

			<div class="clearfix">
				<ul class="summary">
				    <li><strong>品牌：</strong><span><s:property value="productMap.sppp_mc"/></span></li>
					<li><strong>市场价：</strong><span><s:property value="productMap.scjg"/></span></li>
					<li class="red"><strong>平台价：</strong><span><s:property value="productMap['jg'+#session.session_khxx.qdsJb]" /></span></li>
				</ul>
				<ul class="edit">
					<li>选择颜色：</li>
					<li>选择版本：</li>
					<li>选择数量：<span class="minus"></span>
					<input type="type" name="name" value=" " /> <span class="plus"></span>
						库存：<s:property value="productMap.kssl"/></li>
				</ul>
			</div>
			<div class="addin"></div>
			<div class="preview">
				<div class="imgbig">
					<img data-img="1" width="350" height="350"
						src="http://img14.360buyimg.com/n1/jfs/t280/214/539431921/38396/2141865d/5416b05fNb3b79a11.jpg"
						alt="TCL 42D11 42英寸 内置wifi 安卓4.0智能自然光技术LED液晶电视（黑色）"
						jqimg="http://img14.360buyimg.com/n0/jfs/t280/214/539431921/38396/2141865d/5416b05fNb3b79a11.jpg">
				</div>
				<div class="clearfix zoompic">
					<a href="" class="left"></a> <a class="pic"><img
						src="http://img14.360buyimg.com/n5/jfs/t331/250/530819018/131064/4a1fc8fc/5416b05fN442b6c69.jpg"
						alt="Alternate Text" /></a> <a class="pic"><img
						src="http://img14.360buyimg.com/n5/jfs/t331/250/530819018/131064/4a1fc8fc/5416b05fN442b6c69.jpg"
						alt="Alternate Text" /></a> <a class="pic"><img
						src="http://img14.360buyimg.com/n5/jfs/t331/250/530819018/131064/4a1fc8fc/5416b05fN442b6c69.jpg"
						alt="Alternate Text" /></a> <a class="pic"><img
						src="http://img14.360buyimg.com/n5/jfs/t331/250/530819018/131064/4a1fc8fc/5416b05fN442b6c69.jpg"
						alt="Alternate Text" /></a> <a class="pic"><img
						src="http://img14.360buyimg.com/n5/jfs/t331/250/530819018/131064/4a1fc8fc/5416b05fN442b6c69.jpg"
						alt="Alternate Text" /></a> <a href="" class="right"></a>
				</div>
			</div>
		</div>
	</div>

	<div class="mainbox">
		<div class="intros">
			<div class="mt">
				<ul class="tab" id="introtab">
					<li class="curr" style="display: list-item;"><a
						href="javascript:;">商品详情</a></li>
					<li class="none"><a href="javascript:;">规格参数</a></li>
				</ul>
			</div>
			<div class="mc" id="detail">
				<div class="detail">
					<div class="content_tpl">
						<div class="formwork_bt">
							<br>
							<div class="formwork_bt_dz">
								<span>产品信息</span><span class="s2">Product Information</span>
							</div>
						</div>
						<div class="formwork">
							<div class="formwork_text">华为Emotion系统2.3（兼容Android
								4.4）、1.8GHz四核处理器</div>
						</div>
						<div class="formwork">
							<div class="formwork_text">5.0英寸Incell屏幕、16GB ROM + 2GB RAM</div>
						</div>
						<div class="formwork">
							<div class="formwork_text">1300万像素主摄像头 + 800万像素副摄像头，独立图像处理器</div>
						</div>
						<div class="formwork">
							<div class="formwork_text">LTE高速网络，支持CAT4 150 Mbps</div>
						</div>
						<div class="formwork">
							<div class="formwork_img">
								<img alt=""
									src="http://img20.360buyimg.com/vc/g10/M00/1E/0C/rBEQWFNmCNwIAAAAAAKubLTEMRQAAF81gO6gMsAAq6E134.jpg"
									class="err-product">
							</div>
						</div>
						<div class="formwork_bt">
							<div class="formwork_bt_dz">
								<span>产品细节</span><span class="s2">Product Details</span>
							</div>
						</div>
						<div class="formwork">
							<div class="formwork_img">
								<img alt=""
									src="http://img20.360buyimg.com/vc/g17/M00/00/1A/rBEbSFNq5s8IAAAAAADK2bbiBCEAAAKPQEi9xkAAMrx140.jpg"
									class="err-product">
							</div>
						</div>
						<div class="formwork">
							<div class="formwork_img">
								<img alt=""
									src="http://img20.360buyimg.com/vc/g15/M06/1B/12/rBEhWVNmCbsIAAAAAAIZx2oPoSYAAM17wEE6pwAAhnf254.jpg"
									class="err-product">
							</div>
						</div>
						<div class="formwork">
							<div class="formwork_img">
								<img alt=""
									src="http://img20.360buyimg.com/vc/g14/M02/02/00/rBEhVVNmCdQIAAAAAALIjUzpIGgAAM99QC0P6wAAsil487.jpg"
									class="err-product">
							</div>
						</div>
						<div class="formwork">
							<div class="formwork_img">
								<img alt=""
									src="http://img20.360buyimg.com/vc/g16/M00/00/12/rBEbRlNqBtAIAAAAAACwbcBzavwAAAHKwHCYvMAALCF127.jpg"
									class="err-product">
							</div>
						</div>
						<div class="formwork">
							<div class="formwork_img">
								<img alt=""
									src="http://img20.360buyimg.com/vc/g16/M00/00/12/rBEbRVNqBtgIAAAAAACgZpvSkmAAAAHLQAAAAAAAKB-507.jpg"
									class="err-product">
							</div>
						</div>
						<div class="formwork">
							<div class="formwork_img">
								<img alt=""
									src="http://img20.360buyimg.com/vc/g14/M09/02/00/rBEhVlNmCrsIAAAAAAWlOYvA5ysAAM9-ABjUHQABaVR397.jpg"
									class="err-product">
							</div>
						</div>
						<div class="formwork">
							<div class="formwork_img">
								<img alt=""
									src="http://img20.360buyimg.com/vc/g10/M00/1E/0C/rBEQWVNmCuAIAAAAAALCLA0qt2AAAF83wJrblkAAsJE066.jpg"
									class="err-product">
							</div>
						</div>
						<div class="formwork">
							<div class="formwork_img">
								<img alt=""
									src="http://img20.360buyimg.com/vc/g10/M00/1E/0C/rBEQWFNmCvUIAAAAAATQJi38gvEAAF84QAUnJoABNA-124.jpg"
									class="err-product">
							</div>
						</div>
						<div class="formwork">
							<div class="formwork_img">
								<img alt=""
									src="http://img20.360buyimg.com/vc/g17/M00/00/12/rBEbR1NqBukIAAAAAADjwLhA7WYAAAHKwJ0BOQAAOPY080.jpg"
									class="err-product">
							</div>
						</div>
						<div class="formwork">
							<div class="formwork_img">
								<img alt=""
									src="http://img20.360buyimg.com/vc/g12/M00/0F/03/rBEQYVNmC1QIAAAAAAC378mW960AAFemgMNlPoAALgH891.jpg"
									class="err-product">
							</div>
						</div>
						<div class="formwork">
							<div class="formwork_img">
								<img alt=""
									src="http://img20.360buyimg.com/vc/g13/M0A/00/12/rBEhUlNmC7UIAAAAAADDkRdKQiIAAM0ogHl8eoAAMOp970.jpg"
									class="err-product">
							</div>
						</div>
					</div>
				</div>
				<div class="detail"></div>
			</div>
		</div>
	</div>
	<s:include value="foot.html"></s:include>
</body>
</html>