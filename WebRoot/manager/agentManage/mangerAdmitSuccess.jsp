<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../managerMemu.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>开设班主任账户</title>
</head>

<body>
	<div class="body slide">
		<div class="container-fluid left-border">
			<div class="row">
				<div class="col-md-12 col-lg-12">
					<br>
					<dl>
						<dt>
							<font size="4">班主任信息：</font>
						</dt>
						</br>
						<dd>
							<font size="3">账号： ${agent.aname}</font>
						</dd>
						<br>
						<dd>
							<font size="3">密码： <a class="btn btn-default"
								href="<%=basePath%>manager/agentManage/agentChangePassword.jsp?uid=${agent.uid}">修改密码</a></font>
						</dd>
						<br>
						<dd>
							<font size="3">姓名： ${agent.name}</font>
						</dd>
						<br>
						<dd>
							<font size="3">QQ： ${agent.qq}</font>
						</dd>
						<br>
						<dd>
							<font size="3">手机号： ${agent.phone}</font>
						</dd>
						<br>
						<dd>
							<font size="3">身份证号： ${agent.idcard}</font>
						</dd>
						<br>
						<dd>
							<font size="3">班主任类别： ${agent.role}</font>
						</dd>
						<br>
					</dl>

					<a class="btn btn-default"
						href="<%=basePath%>Manager/ManagerAgentManage_display.action">返回</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>


