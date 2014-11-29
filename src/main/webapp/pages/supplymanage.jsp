<%@include file="/pages/base.jsp"%>
<%@include file="/pages/top.jsp"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>克莱姆购物平台</title>
    <script src="<%=root%>/scripts/supply.js"></script>
    
    <link rel="stylesheet" type="text/css" href="<%=root%>/css/pager.css">
    <script type="text/javascript" src="<%=root%>/scripts/pager.js"></script>
    <style>
    ul.pic_list{width:790px;height:300px;position:relative}
    ul.pic_list li{float:left;width:100%;height:300px;position:absolute;top:0px;left:0px}
    .title_nav{float:left;width:100%;height:52px;position:absolute;bottom:-10px;left:0px}
    .title_nav a{float:left;display:inline-block;width:79px;margin-right:1px;background:#444;padding:5px 15px;text-align:center;color:#fff;text-decoration:none;}
    .title_nav a.select{background:#09C url(../images/sanj.gif) no-repeat center 47px}
    </style>

</head>

<body>


    <div class="topnav mainbox">
        <div class="breadcrumb">
            <span>首页&nbsp;&gt;&nbsp;供货商
            </span>
        </div>
    </div>

    <div class="mainbox usermain clearfix">
        <div class="user-right">
             <form action="" id="manageSupplyForm" method="post">
             <s:hidden id="page"  name="supplyfindEntity.page"></s:hidden> <!-- 当前所在分页号码 -->
             <table width="100%" border="1" cellspacing="0" cellpadding="0" id="resultable">
                <tr>
                    <th style="width:200px">商品名称</th>
                    <th>分类</th>
                    <th>品牌</th>
                    <th>型号</th>
                    <th>市场价 (元)</th>
                    <th>我的报价 (元)</th>
                    <th>可供数量</th>
                    <th>计量单位</th>
                    <th>操作</th>
                </tr>
                <s:iterator value="pager.rows" id="row" status="s">
                <tr>
                    <td><s:property value='#row.spmc'/></td>
                    <td><s:property value='#row.spfl_mc'/></td>
                    <td><s:property value='#row.sppp_mc'/></td>
                    <td><s:property value='#row.spxh'/></td>
                    <td class="alir"><s:property value='#row.scjg'/></td>
                    <td class="alir"><s:property value='#row.sp_jg'/></td>
                    <td><s:property value='#row.sp_sl'/></td>
                    <td><s:property value='#row.jldw'/></td>
                    <td id="oper<s:property value='#row.ghxh'/>">
                    <input type="button" name="editSupply" value="理货" class="btn4" onclick="editSupplyinfo(<s:property value='#row.ghxh'/>)"/>
                    <s:if test="#row.ghbz=='1'">   <!-- 对于已上架的记录，允许进行下架操作 -->
                       <input type="button" name="downSupply" value="下架" class="btn4" onclick="downSupplyProduct(<s:property value='#row.ghxh'/>)"/>
                    </s:if>
                    </td>
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
	    <div class="total">    <a href="<%=root%>/pages/supply.jsp"  class="btn3">添加商品</a>   </div>
        </div>

        <div class="user-left">
            <h1>供货商</h1>
            <ul>
<<<<<<< HEAD
                <li><a href="<%=root%>/supplyCenter.action">用户中心</a>    </li>
=======
                <li><a href="<%=root%>/supplyCenter.action">用户中心</a></li>
                <li><a href="<%=root%>/changeSupplyPasswordInit.action">修改密码</a></li>
>>>>>>> branch 'master' of https://github.com/Bonde2014/WebSite.git
                <li><a href="<%=root%>/supplyManageInit.action" class="current">我的货架</a> </li>
            </ul>
        </div>
    </div>

    <s:include value="foot.html"></s:include>

</body>
</html>
