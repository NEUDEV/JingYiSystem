mangerAdmitSuccess.jsp<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
			<li><a href="#">班主任管理</a></li>
			<li class="active">删除班主任</li>
			<li><a href="#">删除成功</a></li>
		</ul>

		<dl>
			<dt><font size="4">修改后班主任信息：</font></dt>
			</br>
			<dd><font size="3">账号： ${agent.aname}</font></dd><br>
			<dd><font size="3">姓名： ${agent.name}</font></dd><br>
			<dd><font size="3">QQ： ${agent.qq}</font></dd><br>
			<dd><font size="3">手机号： ${agent.phone}</font></dd><br>
			<dd><font size="3">身份证号： ${agent.idcard}</font></dd><br>
			<dd><font size="3">班主任类别： ${agent.role}</font></dd><br>
		</dl>


		<form action="<%=basePath%>Manager/ManagerAgentManage_delete.action"
			id="form" method="post">

			<input type="button" class="btn btn-default" value="确认删除"
				onclick="document.getElementById('form').submit();" />
		</form>
	</div>
</body>
</html>


