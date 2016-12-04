<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../../managerMemu.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>审核学员</title>
</head>

<body>
	<div class="body slide">
		<div class="container-fluid left-border">
			<div class="row">
				<div class="col-md-12 col-lg-12">
					<br>
					<ul class="breadcrumb">
						<li><a href="<%=basePath%>manager/managerMemu.jsp">主页</a></li>
						<li class="active">选择学员</li>
						<li><a href="#">审核</a></li>
						<li><a href="#">审核成功</a></li>
					</ul>
					<nav class="navbar navbar-default navbar-static-top"
						role="navigation">
					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">

						<form class="navbar-form navbar-left" role="search"
							action="<%=basePath%>Manager/ManagerAuditStudent_searchUpStudent.action"
							method="post">
							<select name="searchType" class="form-control">
								<option>QQ</option>
								<option>姓名</option>
								<option>手机号</option>
							</select>
							<div class="form-group">
								<input class="form-control" name="searchValue" type="text" />
							</div>
							<button type="submit" class="btn btn-default">查找学员</button>
						</form>
					</div>
					</nav>

					<a>请选择班主任学员：</a>

					<table class="table table-bordered table-hover">
						<thead>
							<tr>
								<th>QQ</th>
								<th>姓名</th>
								<th>手机号</th>
								<th>微信</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${request.upStudentList}" var="student">
								<tr>
									<td>${student.qq}</td>
									<td>${student.name}</td>
									<td>${student.phone}</td>
									<td>${student.weixin}</td>
									<td><a
										href="<%=basePath%>Manager/ManagerAuditStudent_showUpStudent.action?qq=${student.qq}">审核
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

					<div class="row clearfix">
						<div class="col-md-12 column">${request.info}</div>
						</br>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>


