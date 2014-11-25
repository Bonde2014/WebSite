<%@include file="/pages/base.jsp"%>
<%@include file="/pages/top.jsp"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>供货商品选择</title>
    <link href="<%=root%>/css/style.css" rel="stylesheet" />
    <script src="<%=root%>/scripts/jquery.js"></script>
    <script src="<%=root%>/scripts/comm.js"></script>
    <script src="<%=root%>/scripts/supply.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=root%>/scripts/jquery-easyui-1.3.6/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="<%=root%>/scripts/jquery-easyui-1.3.6/themes/icon.css">
    <script type="text/javascript" src="<%=root%>/scripts/jquery-easyui-1.3.6/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=root%>/scripts/jquery-easyui-1.3.6/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="<%=root%>/scripts/jquery-easyui-1.3.6/validate/easyui_validate.js"></script>
    
    <link rel="stylesheet" type="text/css" href="<%=root%>/css/pager.css">
    <script type="text/javascript" src="<%=root%>/scripts/pager.js"></script>
    <style>
    ul.pic_list{width:790px;height:300px;position:relative}
    ul.pic_list li{float:left;width:100%;height:300px;position:absolute;top:0px;left:0px}
    .title_nav{float:left;width:100%;height:52px;position:absolute;bottom:-10px;left:0px}
    .title_nav a{float:left;display:inline-block;width:79px;margin-right:1px;background:#444;padding:5px 15px;text-align:center;color:#fff;text-decoration:none;}
    .title_nav a.select{background:#09C url(../images/sanj.gif) no-repeat center 47px}
    </style>
    <script type="text/javascript">
    $(function () {
        $(".adbox").turnPic();
    })
    </script>
</head>

<body>

	<div class="global_menu">
		<div class="mainbox">
			<div class="bigmenu">
				<h1 style="cursor:pointer" onclick="pageLink('/init.do')">全部商品分类</h1>
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

    <div class="topnav mainbox">
        <div class="breadcrumb">
            <span>供货商&nbsp;&gt;&nbsp;货架管理&nbsp;&gt;&nbsp;添加商品
            </span>
        </div>
    </div>

    <div class="mainbox usermain clearfix">
        <div class="user-right">
            <form action="" id="searchSupplyForm" method="post">
            <s:hidden id="page"  name="findEntity.page"></s:hidden> <!-- 当前所在分页号码 -->
            <div class="myprosearch">
                商品分类 
                <select id="spflDm" name="spflDm">
                    <option value="1001">电脑配件类</option>
                    <option value="1002">摄影设备类</option>
                    <option value="1003">手机类</option>
                </select>
                品牌
                <select id="spppDm" name="spppDm">  <!-- 如何将上次选择的条件，从后台跳转过来时，能带过来，是否要用s:select 标签 -->
                    <option value="9901">联想</option>
                    <option value="9902">华为</option>
                    <option value="9903">三星</option>
                </select>   <!-- <s:property value="#session.session_khxx.khDm"/>   < % =session.session_khxx.khDm % > -->
                <!--     <s:hidden id="ghsDm"  name="session.session_khxx.khDm"></s:hidden>
                <s:if test="#session.session_khxx!=null">
                   <input type="hidden" name="ghsDm" id="ghsDm"><s:property value="#session.session_khxx.khDm"/></input>
                </s:if>  -->
                <input type="button" name="name" value="搜索" class="btn4" onclick="querySupplyProducts()"/>
            </div>
            </form>

            <form action="" id="addSupplyForm" method="post">
            <table width="100%" border="1" cellspacing="0" cellpadding="0" id="resultable">
                <tr>
                    <th style="width:45px"> <input type="checkbox" name="name" value=" " /> </th>
                    <th style="width:245px">商品名称</th>
                    <th>分类</th>
                    <th>品牌</th>
                    <th>型号</th>
                    <th>市场价 (元)</th>
                </tr>
                <s:iterator value="pager.rows" id="row" status="s">
                <tr>
                    <td><input type="checkbox" name="spdms" id="spdms" value="<s:property value='#row.sp_dm'/>" /></td>
                    <td><s:property value='#row.spmc'/></td>
                    <td><s:property value='#row.spfl_mc'/></td>
                    <td><s:property value='#row.sppp_mc'/></td>
                    <td><s:property value='#row.spxh'/></td>
                    <td class="alir"><s:property value='#row.scjg'/></td>
                </tr>
                </s:iterator>
            </table>
            </form>
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
        <div class="total">    <a href="javascript:void(0)" onclick="addSupply()" class="btn3">放入我的货架</a>   </div>

        </div>



        <div class="user-left">
            <h1>供货商</h1>
            <ul>
                <li><a href="<%=root%>/pages/supplyCenter.jsp">用户中心</a>    </li>
                <li><a href="<%=root%>/supplyManageInit.do" class="current">我的货架</a> </li>

            </ul>
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
