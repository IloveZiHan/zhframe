<%@page import="org.apache.log4j.Logger"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>测试页面</title>
	<%@include file="/common/dwz.jsp" %>
</head>
<body>
	<input type="text" name="xxx" class="date" pattern="yyyy-MM-dd" yearstart="-80" yearend="5"/>
</body>
</html>