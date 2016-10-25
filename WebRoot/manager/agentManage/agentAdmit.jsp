<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
			<li><a href="#">选择班主任</a></li>
			<li class="active">登记班主任信息</li>
			<li><a href="#">登记成功</a></li>
		</ul>

		<form
			action="<%=basePath%>Manager/ManagerAgentRegister_register.action"
			id="form" method="post">
			<div class="form-group">
				<label for="name">姓名</label><input class="form-control" id="name"
					type="text" name="name" />
			</div>
			<div class="form-group">
				<label for="qq">qq</label><input class="form-control" id="qq"
					type="number" name="qq" />
			</div>
			<div class="form-group">
				<label for="phone">电话</label><input class="form-control" id="phone"
					type="number" name="phone" size="11" />
			</div>
			<div class="form-group">
				<label for="role">变更班主任类型:</label> <select name="role"
					class="form-control">
					<option>班主任</option>
					<option>超级班主任</option>
				</select>
			</div>
			<div class="col-md-12 column">${request.info}</div>
			<button type="submit" class="btn btn-default">提交</button>
		</form>
	</div>
</body>
</html>


