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
		<a>划分至超级班主任${request.superAgent.name}下的班主任如下：</a>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>序号</th>
						<th>账户名</th>
						<th>姓名</th>
						<th>手机号</th>
						<th>QQ</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${request.agentList}" var="agent">
						<tr>
							<td>${i=i+1}</td>
							<td>${agent.aname}</td>
							<td>${agent.name}</td>
							<td>${agent.phone}</td>
							<td>${agent.qq}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</table>
	</div>
</body>
</html>


