<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/pages/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<title>购物平台登录界面</title>
<style>
    ul.pic_list{width:790px;height:300px;position:relative}
    ul.pic_list li{float:left;width:100%;height:300px;position:absolute;top:0px;left:0px}
    .title_nav{float:left;width:100%;height:52px;position:absolute;bottom:-10px;left:0px}
    .title_nav a{float:left;display:inline-block;width:79px;margin-right:1px;background:#444;padding:5px 15px;text-align:center;color:#fff;text-decoration:none;}
    </style>
</head>
<body>
    <div class="logotop mainbox">
        <div class="search">
            <div class="searchinput">
                <input type="text" value="" />
                <div class="searchbtn">搜索</div>
            </div>
            <div class="checkout">去购物车结算 <span class="righticon"> </span>    </div>
            <ul class="searchtext">
                <span>热门搜索：</span>
                <li>雷神8系显卡</li>
                <li>  游戏本  </li>
                <li>呼叫会议设备</li>
                <li>  第五代智能路由器</li>
                <li>   移动硬盘</li>
            </ul>
        </div>

        <div class="logo"></div>
    </div>

    <div class="global_menu">
        <div class="mainbox">
            <div class="bigmenu">
                <h1>全部商品分类</h1>
                <ul>
                    <li>
                        <h2>手机通讯</h2>
                        <span><a href="#ddd">手机</a></span>    <span><a href="#ddd">手机配件</a></span>
                    </li>
                    <li class="odd">
                        <h2>电脑整机</h2>
                        <span><a href="#ddd">笔记本</a></span>    <span><a href="#ddd">台机</a></span> <span><a href="#ddd">苹果系列</a></span>
                    </li>
                    <li>
                        <h2>外设产品</h2>
                        <span><a href="#ddd">键套</a></span>    <span><a href="#ddd">鼠标</a></span> <span><a href="#ddd">耳机</a></span><span><a href="#ddd">手写板</a></span>
                    </li>
                    <li class="odd">
                        <h2>网络产品</h2>
                        <span><a href="#ddd"></a>网络</span>    <span><a href="#ddd">路由器</a></span> <span><a href="#ddd">交换机</a></span><span><a href="#ddd">网线</a></span>
                    </li>

                    <li>
                        <h2>安防监控</h2>
                        <span><a href="#ddd">监控摄像头</a></span>    <span><a href="#ddd">监控录像机</a></span>
                    </li>
                    <li class="odd">
                        <h2>网络产品</h2>
                        <span><a href="#ddd"></a>网络</span>    <span><a href="#ddd">路由器</a></span> <span><a href="#ddd">交换机</a></span><span><a href="#ddd">网线</a></span>
                    </li>

                    <li>
                        <h2>安防监控</h2>
                        <span><a href="#ddd">监控摄像头</a></span>    <span><a href="#ddd">监控录像机</a></span>
                    </li>

                </ul>
            </div>
            <ul class="topmenu">
            	<li>今日报价</li>
                <li onclick="pageLink('/pages/index.jsp')">首页</li>
                <li>特价专区</li>
                <li>自助装机</li>
            </ul>

        </div>
    </div>

    <div class="mainbox">
        <div class="adbox">
            <ul class="pic_list">
                <li style="display:block"><a href="#" title=""><img alt="1" src="<%=root%>/images/temp1.png" /></a></li>

                <li><a href="#" title=""><img alt="2" src="<%=root%>/images/temp2.png" /></a></li>
                <li><a href="#" title=""><img alt="2" src="<%=root%>/images/temp3.png" /></a></li>

            </ul>
            <div class="title_nav">
                <a href="#" class="select">相约情人节全场119元起</a>
                <a href="#">新款上线全场357元起</a>
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
            <img src="<%=root%>/images/temp4.png" />
            <span class="title">扬天S320 G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
        </div>
        <div class="probox">
            <img src="<%=root%>/images/temp4.png" />
            <span class="title">扬天S320 G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
        </div>
        <div class="probox">
            <img src="<%=root%>/images/temp4.png" />
            <span class="title">扬天S320 G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
        </div>
        <div class="probox">
            <img src="<%=root%>/images/temp4.png" />
            <span class="title">扬天S320 G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
        </div>
        <div class="probox">
            <img src="<%=root%>/images/temp4.png" />
            <span class="title">扬天S320 G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
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
            <img src="<%=root%>/images/temp4.png" />
            <span class="title">扬天S320 G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
        </div>
        <div class="probox">
            <img src="<%=root%>/images/temp4.png" />
            <span class="title">扬天S320 G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
        </div>
        <div class="probox">
            <img src="<%=root%>/images/temp4.png" />
            <span class="title">扬天S320 G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
        </div>
        <div class="probox">
            <img src="<%=root%>/images/temp4.png" />
            <span class="title">扬天S320 G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
        </div>
        <div class="probox">
            <img src="<%=root%>/images/temp4.png" />
            <span class="title">扬天S320 G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
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
            <img src="<%=root%>/images/temp4.png" />
            <span class="title">扬天S320 G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
        </div>
        <div class="probox">
            <img src="<%=root%>/images/temp4.png" />
            <span class="title">扬天S320 G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
        </div>
        <div class="probox">
            <img src="<%=root%>/images/temp4.png" />
            <span class="title">扬天S320 G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
        </div>
        <div class="probox">
            <img src="<%=root%>/images/temp4.png" />
            <span class="title">扬天S320 G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
        </div>
        <div class="probox">
            <img src="<%=root%>/images/temp4.png" />
            <span class="title">扬天S320 G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
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
            <img src="<%=root%>/images/temp4.png" />
            <span class="title">扬天S320 G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
        </div>
        <div class="probox">
            <img src="<%=root%>/images/temp4.png" />
            <span class="title">扬天S320 G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
        </div>
        <div class="probox">
            <img src="<%=root%>/images/temp4.png" />
            <span class="title">扬天S320 G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
        </div>
        <div class="probox">
            <img src="<%=root%>/images/temp4.png" />
            <span class="title">扬天S320 G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
        </div>
        <div class="probox">
            <img src="<%=root%>/images/temp4.png" />
            <span class="title">扬天S320 G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
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
            <img src="<%=root%>/images/temp4.png" />
            <span class="title">扬天S320 G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
        </div>
        <div class="probox">
            <img src="<%=root%>/images/temp4.png" />
            <span class="title">扬天S320 G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
        </div>
        <div class="probox">
            <img src="<%=root%>/images/temp4.png" />
            <span class="title">扬天S320 G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
        </div>
        <div class="probox">
            <img src="<%=root%>/images/temp4.png" />
            <span class="title">扬天S320 G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
        </div>
        <div class="probox">
            <img src="<%=root%>/images/temp4.png" />
            <span class="title">扬天S320 G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
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
            <img src="<%=root%>/images/temp4.png" />
            <span class="title">扬天S320 G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
        </div>
        <div class="probox">
            <img src="<%=root%>/images/temp4.png" />
            <span class="title">扬天S320 G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
        </div>
        <div class="probox">
            <img src="<%=root%>/images/temp4.png" />
            <span class="title">扬天S320 G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
        </div>
        <div class="probox">
            <img src="<%=root%>/images/temp4.png" />
            <span class="title">扬天S320 G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
        </div>
        <div class="probox">
            <img src="<%=root%>/images/temp4.png" />
            <span class="title">扬天S320 G1620 2G 500GDVD刻录 带无线网卡 COM卡</span>
        </div>
    </div>


    <div class="footcontent mainbox clearfix">
        <ul class="icon1">
            <li class="title">购物指南</li>
            <li>购物流程</li>
            <li>会员介绍</li>
            <li>团购机票</li>
            <li>常用问题</li>
            <li>大家电</li>
            <li>联系客服</li>
        </ul>
        <ul class="icon2">
            <li class="title">购物指南</li>
            <li>购物流程</li>
            <li>会员介绍</li>
            <li>团购机票</li>
            <li>常用问题</li>
            <li>大家电</li>
            <li>联系客服</li>
        </ul>
        <ul class="icon3">
            <li class="title">购物指南</li>
            <li>购物流程</li>
            <li>会员介绍</li>
            <li>团购机票</li>
            <li>常用问题</li>
            <li>大家电</li>
            <li>联系客服</li>
        </ul>
        <ul class="icon4">
            <li class="title">购物指南</li>
            <li>购物流程</li>
            <li>会员介绍</li>
            <li>团购机票</li>
            <li>常用问题</li>
            <li>大家电</li>
            <li>联系客服</li>
        </ul>
        <ul class="icon5">
            <li class="title">购物指南</li>
            <li>购物流程</li>
            <li>会员介绍</li>
            <li>团购机票</li>
            <li>常用问题</li>
            <li>大家电</li>
            <li>联系客服</li>
        </ul>
    </div>

    <div class="linkme mainbox">
        <div>
            <span>关于我们</span>|
            <span>联系我们</span>|
            <span>人才招聘</span>|
            <span>商家入驻</span>|
            <span>营销中心</span>|
            <span>手机京东</span>|
            <span>友情链接</span>|
            <span>销售联盟</span>|
            <span>京东社区</span>|
            <span>京东公益</span>
        </div>
        <div>
            北京市公安局朝阳分局备案编号110105014669  |  京ICP证070359号  |  互联网药品信息服务资格证编号(京)-经营性-2014-0008  |  新出发京零 字第大120007号<br>
            音像制品经营许可证苏宿批005号  |  出版物经营许可证编号新出发(苏)批字第N-012号  |  互联网出版许可证编号新出网证(京)字150号<br>
            网络文化经营许可证京网文[2011]0168-061号  违法和不良信息举报电话：4006561155  Copyright © 2004-2014  京东JD.com 版权所有<br>
            京东旗下网站：360TOP  拍拍网  网银在线<br>
        </div>
    </div>
</body>
</html>