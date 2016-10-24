<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../managerMemu.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>开设班主任账户</title>
<script type="text/javascript">
	$(function() {
		$("#commit").click(function() {
			if ($("#aname").val() == "") {
				alert("用户名不能为空");
			} else if ($("#name").val() == "") {
				alert("姓名不能为空");

			} else if ($("#phone").val() == "") {
				alert("电话不能为空");
			} else {
				$('form').submit();
			}
		});
	});
</script>
</head>

<body>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<ul class="breadcrumb">
			<li><a href="<%=basePath%>/index.jsp">主页</a></li>
			<li class="active">注册班主任</li>
			<li><a href="#">注册成功</a></li>
		</ul>

		<form
			action="<%=basePath%>Manager/ManagerAgentManage_change.action?uid=<%=request.getParameter("uid")%>"
			id="form" method="post">
			<div class="form-group">
				<label for="aname">账户名</label><input class="form-control" id="aname"
					type="text" name="aname" value=""/>
			</div>
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
				<label for="role">选择班主任级别:</label> <select name="selectRole"
					class="form-control">
					<option>班主任</option>
					<option>超级班主任</option>
				</select>
			</div>

			<div class="col-md-12 column">${request.info}</div>
			<input type="button" class="btn btn-default" value="提交" id="commit">
		</form>
	</div>
</body>
</html>


