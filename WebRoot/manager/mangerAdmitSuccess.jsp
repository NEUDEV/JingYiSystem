<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="./managerMemu.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>开设代理商账户</title>
</head>

<body>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<ul class="breadcrumb">
			<li><a href="<%=basePath%>/index.jsp">主页</a></li>
			<li><a href="#">代理商管理</a></li>
			<li class="active">删除代理商</li>
			<li><a href="#">删除成功</a></li>
		</ul>

		<dl>
			<dt>修改后代理商信息：</dt>
			</br>
			<dd>账号： ${agent.aname}</dd>
			<dd>姓名： ${agent.name}</dd>
			<dd>QQ： ${agent.qq}</dd>
			<dd>手机号： ${agent.phone}</dd>
			<dd>代理商类别： ${agent.role}</dd>
		</dl>

		<a class="btn btn-default" href="<%=basePath%>manager/managerMemu.jsp">返回</a>
	</div>
</body>
</html>


