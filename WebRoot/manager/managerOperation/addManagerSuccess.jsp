<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../managerMemu.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>添加管理员</title>
</head>

<body>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<ul class="breadcrumb">
			<li><a href="<%=basePath%>/index.jsp">主页</a></li>
			<li class="<%=basePath%>manager/managerOperation/register.jsp">添加管理员</li>
			<li class="active">管理员添加成功</li>
		</ul>
		
		<dl>
			<dt>
				<font size="4">管理员信息：</font>
			</dt>
			</br>
			<dd>
				<font size="3">管理员名：${manager.mname}</font>
			</dd>
			<br>
		</dl>

		<a class="btn btn-default"
			href="<%=basePath%>manager/managerOperation/addCourse.jsp">继续添加管理员</a>
	</div>
</body>
</html>


