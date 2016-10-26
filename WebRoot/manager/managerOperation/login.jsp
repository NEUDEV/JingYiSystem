<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/welcome.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>管理员登录</title>
<link href="<%=basePath%>resource/css/signin.css" rel="stylesheet">
</head>

<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<form class="form-signin" role="form"
					action="<%=basePath%>Manager/ManagerOperation_login.action"
					method="post">
					<h3 class="form-signin-heading">管理员登录</h3>
					
					<input class="form-control" placeholder="账号名" required=""
						autofocus="" type="text" name="mname"> <br><input
						class="form-control" placeholder="密码" required="" type="password"
						name="password">
					<div class="checkbox">
						<label> <input value="remember-me" type="checkbox">
							记住我
						</label>
					</div>
					<div class="row clearfix">
						<div class="col-md-12 column">${request.info}</div>
					</div>
					<button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
