<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP 'index.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<script type="text/javascript"
	src="<%=basePath%>/scripts/jquery-1.9.0.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/scripts/jquery-easyui-1.3.6/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/scripts/jquery-easyui-1.3.6/themes/icon.css">
<script type="text/javascript"
	src="<%=basePath%>/scripts/jquery-easyui-1.3.6/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/scripts/jquery-easyui-1.3.6/easyui-lang-zh_CN.js"></script>
	<script>
	 function reloadgrid(){
		 $('#tt').datagrid('load', {
			          dlm: '',fzrxm:''});

	 }
	
	</script>
</head>
<body>
	 <%--表格显示区--%>
    <table id="tt" class="easyui-datagrid" style="width: auto; height: 90%;"      fit="true" 
        idfield="itemid" pagination="true" data-options="iconCls:'icon-save',rownumbers:true,url:'khgl.searchKeHuXinXi.do',pageSize:5, pageList:[5,10,15,20],method:'get',toolbar:'#tb',striped:true" fitcolumns="true"> <%--striped="true"--%>
        <%-- 表格标题--%>
        <thead>
            <tr>
                <th data-options="field:'FZRXM',checkbox:true"></th>
                <th data-options="field:'DLM',width:100">用户名</th>
                <th data-options="field:'FZRXM',width:120,align:'right'">负债人</th>
                <th data-options="field:'LXDH',width:120,align:'right'">联系电话</th>
                <th data-options="field:'KHLB',width:100">客户类别</th>               
                <th data-options="field:'LRSJ',width:100">渠道商级别</th>               
            </tr>
        </thead>
         <%--表格内容--%>
    </table>
    <%--功能区--%>
    
    <div id="tb" style="padding: 5px; height: auto">
     <%-- 查找管理员信息，根据时间、管理员名 --%>
        
        <%-- 包括添加管理员，修改、删除管理员 --%>
        <div style="margin-bottom: 5px">
            <a href="javascript:void(0)" onclick="newUser()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
            <a href="javascript:void(0)" onclick="editUser() " class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改</a>
            <a href="javascript:void(0)" onclick="removeUser()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
        </div>
        <div>
            用户名或姓名：<input id="AdminName" class="textbox"  style="width: 200px;" />&nbsp;
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="reloadgrid()">查询</a>
        </div>
    </div>
</body>
</html>
