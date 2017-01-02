<%@page import="org.apache.log4j.Logger"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>测试页面</title>
	<%@include file="/common/easy_ui.jsp" %>
</head>
<body>
	<div class="easyui-dialog" style="width:400px;height:200px"
	    data-options="title:'My Dialog',collapsible:true,iconCls:'icon-ok',onOpen:function(){}">
	        测试页面
	</div>
</body>
</html>