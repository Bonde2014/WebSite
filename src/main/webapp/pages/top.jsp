<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script type="text/javascript">
		function search(keyword){
			var searchWord;
			if(keyword){
				searchWord = keyword;
			}else{
				searchWord = $.trim($('#word').val());
			}
			$('#searchWord').val(searchWord);
			$('#searchForm').submit();
		}
	</script>
</head>
<body>
	<form action="doSearch.do" id="searchForm" method="post">
		<input type="hidden" name="searchWord" id="searchWord"/>
	</form>
    <div class="logotop mainbox">
        <div class="search">
            <div class="searchinput">
                <input type="text" id="word" size="200"/>
                <div class="searchbtn" onclick="search()">搜索</div>
            </div>
            <div class="checkout">去购物车结算 <span class="righticon"></span></div>
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
</body>
</html>
