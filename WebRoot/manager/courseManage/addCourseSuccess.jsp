<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../managerMemu.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>添加课程</title>
</head>

<body>
	<div class="body slide">
		<div class="container-fluid left-border">
			<div class="row">
				<div class="col-md-12 col-lg-12">
					<br>
					<ul class="breadcrumb">
						<li><a href="<%=basePath%>manager/managerMemu.jsp">主页</a></li>
						<li class="<%=basePath%>manager/courseManage/addCourse.jsp">添加课程</li>
						<li class="active">课程添加成功</li>
					</ul>

					<dl>
						<dt>
							<font size="4">课程信息：</font>
						</dt>
						</br>
						<dd>
							<font size="3">课程名：${course.cname}</font>
						</dd>
						<br>
						<dd>
							<font size="3">开课时间：
								${course.starttime.toString().substring(0,10)}</font>
						</dd>
						<br>
						<dd>
							<font size="3">结课时间：${course.endtime.toString().substring(0,10)}</font>
						</dd>
						<br>
						<dd>
							<font size="3">参考价格： ${course.referencebill}元</font>
						</dd>
						<br>
					</dl>

					<a class="btn btn-default"
						href="<%=basePath%>manager/courseManage/addCourse.jsp">继续添加课程</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>


