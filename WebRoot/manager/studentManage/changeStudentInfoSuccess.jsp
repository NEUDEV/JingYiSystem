<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../managerMemu.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>修改信息成功</title>
</head>

<body>
	<div class="body slide">
		<div class="container-fluid left-border">
			<div class="row">
				<div class="col-md-12 col-lg-12">
					<ul class="breadcrumb">
						<li><a href="<%=basePath%>manager/managerMemu.jsp">主页</a></li>
						<li><a href="#">选择班主任</a></li>
						<li><a href="#">修改学员信息</a></li>
						<li class="active">修改成功</li>
						
					</ul>
					<br>
					<dl>
						<dt>
							<font size="4">修改成功：</font>
						</dt>
						</br>
						<dd>
							<font size="3">学号： ${student.stuid}</font>
						</dd>
						<br>
						<dd>
							<font size="3">qq： ${student.qq}</font>
						</dd>
						<br>
						<dd>
							<font size="3">姓名： ${student.name}</font>
						</dd>
						<br>
						<dd>
							<font size="3">手机号： ${student.phone}</font>
						</dd>
						<br>
						<dd>
							<font size="3">微信： ${student.weixin}</font>
						</dd>
						<br>
					</dl>

					<a class="btn btn-default"
						href="<%=basePath%>Manager/ManagerStudentManage_displayAllStudent.action">返回学员管理页面</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>


