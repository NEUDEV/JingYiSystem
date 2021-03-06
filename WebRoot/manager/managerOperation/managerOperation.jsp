<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../managerMemu.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>管理员管理</title>
</head>

<body>
	<div class="body slide">
		<div class="container-fluid left-border">
			<div class="row">
				<div class="col-md-12 col-lg-12">
					<br>
					<ul class="breadcrumb">
						<li><a href="<%=basePath%>manager/managerMemu.jsp">主页</a></li>
						<li class="active">管理员管理</li>
					</ul>

					<table class="table table-striped">
						<thead>
							<tr>
								<th>序号</th>
								<th>管理员名</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${request.managerList}" var="manager">
								<tr>
									<td>${i = i + 1}</td>
									<td>${manager.mname}</td>
									<td><a
										href="<%=basePath%>Manager/ManagerOperation_deleteManager.action?uid=${manager.uid}">删除
									</a> <a
										href="<%=basePath%>manager/managerOperation/changePassword.jsp?uid=${manager.uid}">修改密码
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>


