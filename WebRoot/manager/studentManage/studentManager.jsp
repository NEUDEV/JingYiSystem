<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.JES.model.Student"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../managerMemu.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
</head>
<body>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<ul class="breadcrumb">
			<li><a href="<%=basePath%>/index.jsp">主页</a></li>
			<li class="active">学员管理</li>
		</ul>
		<nav class="navbar navbar-default navbar-static-top" role="navigation">
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<form class="navbar-form navbar-left" role="search"
				action="<%=basePath%>Manager/ManagerStudentManage_searchStudent.action"
				method="post">
				<select name="searchType" class="form-control">
					<option>UID</option>
					<option>学号</option>
					<option>姓名</option>
					<option>手机号</option>
					<option>QQ</option>
				</select>
				<div class="form-group">
					<input class="form-control" name="searchValue" type="text" />
				</div>
				<button type="submit" class="btn btn-default">查找学员</button>
			</form>
		</div>

		</nav>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>序号</th>
					<th>UID</th>
					<th>学号</th>
					<th>姓名</th>
					<th>手机号</th>
					<th>QQ</th>
					<th>微信</th>
					<th>来源</th>
					<th>状态</th>
					<th>录入时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${request.studentList}" var="student">
					<tr>
						<td>${i=i+1}</td>
						<td>${student.uid}</td>
						<td>${student.stuid}</td>
						<td>${student.name}</td>
						<td>${student.phone}</td>
						<td>${student.qq}</td>
						<td>${student.weixin}</td>
						<td>${student.sfrom}</td>
						<td>${student.sign}</td>
						<td>${student.intime}</td>
						<td>${student.mark}</td>
						<td><a
							href="<%=basePath%>Manager/ManagerStudentManage_searchStudentById.action?uid=${student.uid}">修改
						</a></td>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
