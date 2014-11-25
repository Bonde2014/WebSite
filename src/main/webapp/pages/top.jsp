<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<form action="" id="searchForm" method="post">
    <div class="logotop mainbox">
        <div class="search">
            <div class="searchinput">
                <s:hidden id="page"  name="searchFindEntity.page"></s:hidden>
                <s:hidden id="catalog"  name="searchFindEntity.catalog"></s:hidden>
                <s:textfield name="searchFindEntity.keyword" id="keyword" maxLength="100"></s:textfield>
                <div class="searchbtn" onclick="productSearch()">搜索</div>
            </div>
            <div class="checkout" onclick="pageLink('/goShopcart.do')">去购物车结算 <span class="righticon"></span></div>
        </div>
        <div class="logo"></div>
    </div>
    </form>
</body>
</html>
