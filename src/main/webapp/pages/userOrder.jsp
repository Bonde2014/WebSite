<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>克莱姆购物平台</title>
</head>
<body>
	<div class="topnav mainbox">
		<div class="breadcrumb">
			<strong><a href="<%=root%>/init.do">首页</a>
		&nbsp;&gt;&nbsp;<a href="<%=root%>/userCenter.do">用户中心</a></strong>
		</div>
	</div>
<div class="mainbox usermain clearfix">
        <div class="user-right">
            <ul class="ordermenu">
                <li class="delorder">订单回收站</li>
                <li class="current"><span>全部订单</span></li>
                <li><span>待发货<i>(2)</i></span></li>
                <li><span>待收货<i>(2)</i></span></li>
                <li><span>待付款<i>(2)</i></span></li>
            </ul>

           <s:iterator value="xsddqkList" id="row" status="s">
            <h4 class="ordertime">订单生成时间：<s:property value='#row.ddscsj'/> &nbsp;订单号：<s:property value='#row.ddxh'/></h4>
            <table width="100%" border="1" cellspacing="0" cellpadding="0" style="margin:0">
                <tr>
                    <th style="width:245px">商品信息</th>
                    <th>单价</th>
                    <th>数量</th>
                    <th>实际应付款</th>
                    <th>交易状态</th>
                    <th style="width:100px;">操作</th>
                </tr>
                <s:iterator value="mapList" id="map" status="s">
                <s:if test="#map.DDXH==#row.ddxh">
                <tr>
                    <td > <a href="productDetail(<s:property value='#map.SP_DM'/>)" class="link"><s:property value='#map.SPMC'/></a> </td>
                    <td class="alir"><s:property value='#map.SP_JG'/></td>
                    <td><s:property value='#map.SP_SL'/></td>
                    <td class="alir"><s:property value='#map.SP_ZJ'/></td>
                    <td>待发货</td>
                    <td> <a href="cdd" class="btn2">删除</a> </td>
                </tr>
                </s:if>
                </s:iterator>
            </table>
            </s:iterator>
        </div>
        <div class="user-left">
            <h1>用户中心</h1>
            <ul>
                <li><a href="<%=root%>/userCenter.do">个人主页</a></li>
                <li><a href="#">修改密码</a> </li>
                <li><a href="<%=root%>/goShopcart.do">我的购物车</a> </li>
                <li><a href="<%=root%>/userOrder.do" class="current">我的订单</a> </li>
                <li><a href="#">汇款方式</a> </li>
            </ul>
        </div>
    </div>
	<s:include value="foot.html"></s:include>
</body>
</html>