<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../managerMemu.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>我的个人信息</title>
</head>

<body>
	<div class="body slide">
		<div class="container-fluid left-border">
			<div class="row">
				<div class="col-md-12 col-lg-12">
					<br>
					<ul class="breadcrumb">
						<li><a href="<%=basePath%>manager/managerMemu.jsp">主页</a></li>
						<li class="active">我的个人信息</li>
					</ul>

					<dl>
						<dt>
							<font size="4">管理员信息：</font>
						</dt>
						</br>
						<dd>
							<font size="3">管理员名：${manager.mname}</font>
						</dd>
						<dd>
							<font size="3">密码： <a class="btn btn-default"
								href="<%=basePath%>manager/managerOperation/changePassword.jsp?uid=${manager.uid}">修改密码</a></font>
						</dd>
					</dl>

					<a class="btn btn-default"
						href="<%=basePath%>Manager/ManagerOperation_displayManager.action">返回</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>


