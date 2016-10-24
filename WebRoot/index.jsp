<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script src="<%=basePath%>resource/jquery/jquery.min.js"></script>
<link href="<%=basePath%>resource/css/bootstrap.min.css"
	rel="stylesheet">
<script src="<%=basePath%>resource/js/bootstrap.min.js"></script>
<script src="<%=basePath%>resource/ie10-viewport-bug-workaround.js"></script>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target="#bs-example-navbar-collapse-1">
			<span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span
				class="icon-bar"></span><span class="icon-bar"></span>
		</button>
		<img class="navbar-brand img-thumbnail"
			src="<%=basePath%>image/logo.jpg" />
	</div>

	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		<ul class="nav navbar-nav navbar-right">
			<li><a href="#">${session.loginMessage}</a></li>
			<li><a href="<%=basePath%>Manager/ManagerOperation_logout.action">${session.logout}</a></li>
		</ul>
	</div>
	</nav>
</body>
</html>
