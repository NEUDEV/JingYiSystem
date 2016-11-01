<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<script src="<%=basePath%>resource/jquery/jquery.min.js"></script>
<link href="<%=basePath%>resource/css/bootstrap.min.css"
	rel="stylesheet">
<script src="<%=basePath%>resource/js/bootstrap.min.js"></script>
<script src="<%=basePath%>resource/ie10-viewport-bug-workaround.js"></script>
</head>
<body>
	<header>
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span><span
						class="icon-bar"></span><span class="icon-bar"></span><span
						class="icon-bar"></span>
				</button>
				<img class="navbar-brand img-thumbnail"
					src="<%=basePath%>image/logo.png" />
			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">登录<strong class="caret"></strong></a>
						<ul class="dropdown-menu">
							<li><a
								href="<%=basePath%>manager/managerOperation/login.jsp">管理员登录</a></li>
							<li><a href="<%=basePath%>agent/agentLogin.jsp">班主任登录</a></li>
						</ul></li>
				</ul>
			</div>
		</nav>
	</header>
</body>
</html>
