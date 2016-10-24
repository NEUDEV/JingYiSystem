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

<link href="<%=basePath%>resource/css/dashboard.css" rel="stylesheet">
<script src="<%=basePath%>resource/js/warning.js"></script>
</head>


<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target="#bs-example-navbar-collapse-1">
			<span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span
				class="icon-bar"></span><span class="icon-bar"></span>
		</button>
		<strong><a class="navbar-brand"
			href="<%=basePath%>manager/chooseAgentAdmit.jsp">鲸艺教育</a></strong>
	</div>

	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		<ul class="nav navbar-nav navbar-right">
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown">登录<strong class="caret"></strong></a>
				<ul class="dropdown-menu">
					<li><a href="<%=basePath%>manager/login.jsp">管理员登录</a></li>
					<li><a href="#">代理商登录</a></li>
				</ul></li>
			<li><a href="<%=basePath%>agent/debug.jsp">代理商</a></li>
		</ul>
	</div>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<div class="sidebar-nav">
					<div class="panel-group" id="panel-659100">
						<div class="panel panel-default">
							<div class="panel-heading">
								<a class="panel-title" data-toggle="collapse"
									data-parent="#panel-659100" href="#panel-element-24469">代理商管理</a>
							</div>
							<div id="panel-element-24469" class="panel-collapse collapse in">
								<div class="panel-body">
									<a href="<%=basePath%>Manager/ManagerAgentManage_display.action">代理商管理</a>
								</div>
								<div class="panel-body">
									<a href="<%=basePath%>manager/agentRegister.jsp">开设代理商账户</a>
								</div>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<a class="panel-title" data-toggle="collapse"
									data-parent="#panel-659100" href="#panel-element-936974">报表</a>
							</div>
							<div id="panel-element-936974" class="panel-collapse collapse">
								<div class="panel-body">
									<a href="#">查看系统报表</a>
								</div>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<a class="panel-title" data-toggle="collapse"
									data-parent="#panel-659100" href="#panel-element-936975">学员管理</a>
							</div>
							<div id="panel-element-936975" class="panel-collapse collapse">
								<div class="panel-body">
									<a href="#">划分学员</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			</div>
		</div>
	</div>

</body>
</html>



