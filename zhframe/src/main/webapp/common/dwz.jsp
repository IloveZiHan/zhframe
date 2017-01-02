<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link href="<%=request.getContextPath() %>/dwz/themes/default/style.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<%=request.getContextPath() %>/dwz/themes/css/core.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<%=request.getContextPath() %>/dwz/themes/css/print.css" rel="stylesheet" type="text/css" media="print"/>
<link href="<%=request.getContextPath() %>/dwz/uploadify/css/uploadify.css" rel="stylesheet" type="text/css" media="screen"/>

<!--[if lt IE 9]><script src="js/speedup.js" type="text/javascript"></script><script src="js/jquery-1.11.3.min.js" type="text/javascript"></script><![endif]-->
<!--[if gte IE 9]><!--><script src="<%=request.getContextPath() %>/js/jquery-2.1.4.min.js" type="text/javascript"></script><!--<![endif]-->
<script src="<%=request.getContextPath() %>/dwz/js/jquery.validate.js" type="text/javascript"></script>

<script src="<%=request.getContextPath() %>/dwz/bin/dwz.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/dwz/js/dwz.regional.zh.js" type="text/javascript"></script>

<script type="text/javascript">
	$(function() {
		DWZ.init("<%=request.getContextPath() %>/dwz/dwz.frag.xml", {
			loginUrl:"login_dialog.html", loginTitle:"登录",	// 弹出登录对话框
//			loginUrl:"login.html",	// 跳到登录页面
			statusCode:{ok:200, error:300, timeout:301}, //【可选】
			pageInfo:{pageNum:"pageNum", numPerPage:"numPerPage", orderField:"orderField", orderDirection:"orderDirection"}, //【可选】
			keys: {statusCode:"statusCode", message:"message"}, //【可选】
			ui:{hideMode:'offsets'}, //【可选】hideMode:navTab组件切换的隐藏方式，支持的值有’display’，’offsets’负数偏移位置的值，默认值为’display’
			debug:false,	// 调试模式 【true|false】
			callback:function(){
				initEnv();
				$("#themeList").theme({themeBase:"themes"}); // themeBase 相对于index页面的主题base路径
			}
		});
	});
</script>
