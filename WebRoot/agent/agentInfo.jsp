<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="./agentMemu.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>开设代理商账户</title>
<link href="<%=basePath%>resource/css/signin.css" rel="stylesheet">
</head>

<body>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<ul class="breadcrumb">
			<li><a href="<%=basePath%>/agent/agentMemu.jsp">主页</a></li>
			<li class="active">查看个人信息</li>
			<li><a href="#">修改个人信息</a></li>
		</ul>
		<dl>
			<dt><font size="4">个人信息：</font></dt>
			</br>
			<dd><font size="3">账号： ${agent.aname}</font></dd><br>
			<dd><font size="3">姓名： ${agent.name}</font></dd><br>
			<dd><font size="3">QQ： ${agent.qq}</font></dd><br>
			<dd><font size="3">手机号： ${agent.phone}</font></dd><br>
			<dd><font size="3">身份证号： ${agent.idcard}</font></dd><br>
			<dd><font size="3">班主任类别： ${agent.role}</font></dd><br>
			<dd><font size="3">超级班主任： ${superAgent.name}</font></dd><br>
		</dl>
		<a class="btn btn-default"
			href="<%=basePath%>Agent/AgentLoginAndInfo_getAgentInfo.action"
			role="button">修改个人信息</a>
	</div>
</body>
</html>

