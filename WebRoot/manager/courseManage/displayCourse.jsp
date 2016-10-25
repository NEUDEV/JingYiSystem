<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../managerMemu.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>课程管理</title>
</head>

<body>
	<div class="body slide">
		<div class="container-fluid left-border">
			<div class="row">
				<div class="col-md-12 col-lg-12">
					<br>
					<ul class="breadcrumb">
						<li><a href="<%=basePath%>manager/managerMemu.jsp">主页</a></li>
						<li class="active">课程管理</li>
					</ul>

					<table class="table table-striped">
						<thead>
							<tr>
								<th>序号</th>
								<th>课程名</th>
								<th>开课时间</th>
								<th>结束时间</th>
								<th>参考价格</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${request.courseList}" var="course">
								<tr>
									<td>${i = i + 1}</td>
									<td>${course.cname}</td>
									<td>${course.starttime.toString().substring(0,10)}</td>
									<td>${course.endtime.toString().substring(0,10)}</td>
									<td>${course.referencebill}元</td>
									<td><a
										href="<%=basePath%>Manager/ManagerCourseManage_deleteCourse.action?cid=${course.cid}">删除
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


