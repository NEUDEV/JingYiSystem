<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../managerMemu.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>添加管理员</title>
<script type="text/javascript">
	$(function() {
		$("#commit").click(function() {
			if ($("#mname").val() == "") {
				alert("用户名不能为空");
			} else if ($("#password").val() == "") {
				alert("密码不能为空");
			} else {
			
			var url = "<%=basePath%>Manager/ManagerRegister_managerRegister.action";

			var params = {
				mname : $("#mname").val(),
				password : $("#password").val(),
				confirmPassword : $("#confirmPassword").val(),
			}
			$.post(

			url,

			params,		

			function(data) { 
				var member = eval("(" + data + ")");
				if (member.info == "OK") {
					window.location.href="<%=basePath%>Manager/ManagerAgentManage_toDisplay.action?uid="+member.uid;
				} else if (member.info == "管理员账号已存在"){
					$("#mname").val("");
					$("#mnamems").html(member.info);
				} else if (member.info == "两次密码不一致"){
					$("#password").val("");
					$("#confirmPassword").val("");
					$("#passwordms").html(member.info);
				}

			},

			'json' //数据传递的类型  json

			);

			}
		});
	});
</script>
</head>

<body>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<ul class="breadcrumb">
			<li><a href="<%=basePath%>/index.jsp">主页</a></li>
			<li class="active">添加管理员</li>
			<li><a href="#">管理员添加成功</a></li>
		</ul>

			<div class="form-group">
				<label for="mname">账户名*:</label><label id="mnamems" style="color:red"></label><input class="form-control" id="mname"
					type="text" name="mname" />
			</div>
			<div class="form-group">
				<label for="Password">登录密码:</label> <label id="passwordms" style="color:red"></label><input class="form-control"
					id="password" type="password" name="password" />
			</div>
			<div class="form-group">
				<label for="confirmPassword">密码确认:</label> <input
					class="form-control" id="confirmPassword" type="password"
					name="confirmPassword" />
			</div>
			<input type="button" class="btn btn-default" value="提交" id="commit">
	</div>
</body>
</html>


