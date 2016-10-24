<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../../managerMemu.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>划分学员</title>
</head>

<body>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<ul class="breadcrumb">
			<li><a href="<%=basePath%>manager/managerMemu.jsp">主页</a></li>
			<li class="active">选择班主任学员</li>
			<li><a href="#">划分</a></li>
			<li><a href="#">划分成功</a></li>
		</ul>
		<nav class="navbar navbar-default navbar-static-top" role="navigation">
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			
			<form class="navbar-form navbar-left" role="search"
				action="<%=basePath%>Manager/ManagerDivideStudent_searchStudent.action"
				method="post">
				<select name="searchType" class="form-control">
					<option>UID</option>
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

		<a>请选择班主任学员：</a>
		<input type="button" class="btn btn-default " value="选择完成"
			onclick="document.getElementById('selectStudentForm').submit();" style="margin-right;"/><br>

		<form action="<%=basePath%>Manager/ManagerDivideStudent_selectJingyiStudent.action"
			method="post" id="selectStudentForm">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>UID</th>
						<th>姓名</th>
						<th>手机号</th>
						<th>QQ</th>
						<th>班主任类别</th>
						<th>操作</th>
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
							<td><label><input name="check" type="checkbox"
									value="${student.uid}" /></label></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>


