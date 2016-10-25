<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../../managerMemu.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>划分学员</title>
</head>

<body>
	<div class="body slide">
		<div class="container-fluid left-border">
			<div class="row">
				<div class="col-md-12 col-lg-12">
					<br>
					<ul class="breadcrumb">
						<li><a href="<%=basePath%>manager/managerMemu.jsp">主页</a></li>
						<li><a href="#">选择班主任学员</a></li>
						<li><a href="#">划分</a></li>
						<li class="active">划分成功</li>
					</ul>
					<a>从班主任划分至其他班主任学员如下：</a>
					<table class="table table-bordered table-hover">
						<thead>
							<tr>
								<th>UID</th>
								<th>姓名</th>
								<th>手机号</th>
								<th>QQ</th>
								<th>班主任类别</th>
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
			</div>
		</div>
	</div>
</body>
</html>


