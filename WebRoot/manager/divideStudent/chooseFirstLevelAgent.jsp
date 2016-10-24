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
			<li class="active">选择一级代理商</li>
			<li><a href="#">划分</a></li>
			<li><a href="#">划分成功</a></li>
		</ul>
		<nav class="navbar navbar-default navbar-static-top" role="navigation">
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<form class="navbar-form navbar-left" role="search"
				action="<%=basePath%>Manager/ManagerDivideStudent_searchFirstLevelAgent.action"
				method="post">
				<select name="searchType" class="form-control">
					<option>账户名</option>
					<option>姓名</option>
					<option>手机号</option>
					<option>QQ</option>
				</select>
				<div class="form-group">
					<input class="form-control" name="searchValue" type="text" />
				</div>
				<button type="submit" class="btn btn-default">查找一级代理商</button>
			</form>
		</div>
		</nav>

		<a>请选择目的一级代理商：</a>
		<input type="button" class="btn btn-default " value="选择完成"
			onclick="document.getElementById('selectStudentForm').submit();"/><br>

		<form action="<%=basePath%>Manager/ManagerDivideStudent_divideJingyiToFirstLevelAgent.action"
			method="post" id="selectStudentForm">
			<table class="table table table-bordered">
				<thead>
					<tr>
						<th>账户名</th>
						<th>姓名</th>
						<th>手机号</th>
						<th>QQ</th>
						<th>代理商类别</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${request.firstLevelAgents}" var="agent">
						<tr>
							<td>${agent.aname}</td>
							<td>${agent.name}</td>
							<td>${agent.phone}</td>
							<td>${agent.qq}</td>
							<td>${agent.role}</td>
							<td><label><input name="radio" type="radio"
									value="${agent.uid}" /></label></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>


