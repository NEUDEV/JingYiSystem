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
			}  else if ($("#qq").val() == "") {
				alert("qq不能为空");
			} else if ($("#password").val() == "") {
				alert("密码不能为空");
			} else {
			
			var url = "<%=basePath%>Manager/ManagerAgentManage_register.action";

			var params = {
				aname : $("#aname").val(),
				name : $("#name").val(),
				phone : $("#phone").val(),
				qq : $("#qq").val(),
				idcard : $("#idcard").val(),
				role : $("#role").val(),
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
				} else if (member.info == "代理商账号已存在"){
					$("#aname").val("");
					$("#anamems").html(member.info);
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
			<li class="active">注册班主任</li>
			<li><a href="#">注册成功</a></li>
		</ul>

			<div class="form-group">
				<label for="aname">账户名*:</label><label id="anamems" style="color:red"></label><input class="form-control" id="aname"
					type="text" name="aname" />
			</div>
			<div class="form-group">
				<label for="name">姓名*:</label><input class="form-control" id="name"
					type="text" name="name" />
			</div>
			<div class="form-group">
				<label for="qq">qq*:</label><input class="form-control" id="qq"
					type="number" name="qq" />
			</div>
			<div class="form-group">
				<label for="phone">电话*:</label><input class="form-control" id="phone"
					type="number" name="phone" size="11" />
			</div>
			<div class="form-group">
				<label for="phone">身份证号:</label><input class="form-control" id="idcard"
					type="number" name="idcard" size="11" />
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
			<div class="form-group">
				<label for="role">选择班主任类别:</label> <select name="selectRole"
					class="form-control" id="role">
					<option>班主任</option>
					<option>超级班主任</option>
				</select>
			</div>
			<div class="row clearfix">
				<div class="col-md-12 column">${request.info}</div></br>
			</div>
			<input type="button" class="btn btn-default" value="提交" id="commit">
	</div>
</body>
</html>


