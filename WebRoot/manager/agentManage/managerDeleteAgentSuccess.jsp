<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../managerMemu.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>开设班主任账户</title>
</head>

<body>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<ul class="breadcrumb">
			<li><a href="<%=basePath%>manager/managerMemu.jsp">主页</a></li>
			<li><a href="#">班主任管理</a></li>
			<li><a href="#">删除班主任</a></li>
			<li class="active">删除成功</li>
		</ul>

		<dl>
			<dd>班主任${agent.aname} 删除成功</dd>
		</dl>

		<a class="btn btn-default" href="<%=basePath%>Manager/ManagerAgentManage_display.action">返回</a>
	</div>
</body>
</html>


