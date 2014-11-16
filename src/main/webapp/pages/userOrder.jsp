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


            <h4 class="ordertime">订单生成时间：2014-08-28:21:12:15        订单号：112347689653</h4>
            <table width="100%" border="1" cellspacing="0" cellpadding="0" style="margin:0">
                <tr>
                   
                    <th style="width:245px">商品信息</th>
                    <th>单价</th>
                    <th>数量</th>
                    <th>实际应付款</th>
                    <th>交易状态</th>
                    <th style="width:100px;">操作</th>

                </tr>
                <tr>
                   
                    <td > <a href="#" class="link">铁三角CKR5</a> </td>
                    <td class="alir">115.12</td>
                    <td>11</td>
                    <td class="alir">1535.22</td>
                    <td >待发货</td>
                    <td> <a href="cdd" class="btn2">删除</a> </td>
                </tr>
            </table>

            <h4 class="ordertime">订单生成时间：2014-08-28:21:12:15        订单号：112347689653</h4>
            <table width="100%" border="1" cellspacing="0" cellpadding="0" style="margin:0">
                <tr>

                    <th style="width:245px">商品信息</th>
                    <th>单价</th>
                    <th>数量</th>
                    <th>实际应付款</th>
                    <th>交易状态</th>
                    <th style="width:100px;">操作</th>

                </tr>
                <tr>

                    <td> <a href="#" class="link">铁三角CKR5</a> </td>
                    <td class="alir">115.12</td>
                    <td>11</td>
                    <td rowspan="2" class="alir">1535.22</td>
                    <td rowspan="2">待发货</td>
                    <td rowspan="2"> <a href="cdd" class="btn2">删除</a> </td>
                </tr>
                <tr>
                  <td><a href="#" class="link">铁三角CKR5</a></td>
                  <td class="alir">115.12</td>
                  <td>11</td>
                </tr>
            </table>
        </div>
        <div class="user-left">
            <h1>用户中心</h1>
            <ul>
                <li><a href="<%=root%>/userCenter.do">个人主页</a></li>
                <li><a href="#">修改密码</a> </li>
                <li><a href="#">我的购物车</a> </li>
                <li><a href="<%=root%>/userOrder.do" >我的订单</a> </li>
                <li><a href="#">汇款方式</a> </li>
            </ul>
        </div>
    </div>
	<s:include value="foot.html"></s:include>
</body>
</html>