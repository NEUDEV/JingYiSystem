<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../managerMemu.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>划分学员</title>
</head>

<body>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<ul class="breadcrumb">
			<li><a href="<%=basePath%>/index.jsp">主页</a></li>
			<li class="active">选择鲸艺代理商学员</li>
			<li><a href="#">划分</a></li>
			<li><a href="#">划分成功</a></li>
		</ul>
		<a>从鲸艺代理商划分至一级代理商学员如下：</a>
		<table class="table table table-bordered">
			<thead>
				<tr>
					<th>UID</th>
					<th>姓名</th>
					<th>手机号</th>
					<th>QQ</th>
					<th>代理商类别</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${request.studentList}" var="student">
					<tr>
						<td>${student.uid}</td>
						<td>${student.name}</td>
						<td>${student.phone}</td>
						<td>${student.qq}</td>
						<td>${student.msign}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>


