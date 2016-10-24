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
			<li class="active">选择班主任</li>
			<li><a href="#">登记班主任信息</a></li>
			<li><a href="#">登记成功</a></li>
		</ul>
		<nav class="navbar navbar-default navbar-static-top" role="navigation">
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<form class="navbar-form navbar-left" role="search"
				action="<%=basePath%>Manager/ManagerAgentManage_searchAgent.action"
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
				<button type="submit" class="btn btn-default">查找班主任</button>
			</form>
		</div>
		</nav>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>账户名</th>
					<th>姓名</th>
					<th>手机号</th>
					<th>QQ</th>
					<th>班主任类别</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${request.agentList}" var="agent">
					<tr>
						<td>${agent.aname}</td>
						<td>${agent.name}</td>
						<td>${agent.phone}</td>
						<td>${agent.qq}</td>
						<td>${agent.role}</td>
						<td><a
							href="<%=basePath%>manager/agentManage/mangerAdmitAgent.jsp?uid=${agent.uid}">修改
						</a> <a
							href="<%=basePath%>Manager/ManagerAgentManage_toDelete.action?uid=${agent.uid}">删除
						</a><a
							href="<%=basePath%>Manager/ManagerAgentManage_toDisplay.action?uid=${agent.uid}">查看
						</a><a
							href="<%=basePath%>Manager/ManagerAgentManage_displayStudentByAgent.action?uid=${agent.uid}">学员信息
						</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>


