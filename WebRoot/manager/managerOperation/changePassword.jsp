<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../managerMemu.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>管理员密码修改</title>
</head>

<body>
	<div class="body slide">
		<div class="container-fluid left-border">
			<div class="row">
				<div class="col-md-12 col-lg-12">
					<br>
					<ul class="breadcrumb">
						<li><a href="<%=basePath%>manager/managerMemu.jsp">主页</a></li>
						<li class="active">密码修改</li>
					</ul>
					<form
						action="<%=basePath%>/Manager/ManagerOperation_changePassword.action?uid=<%=request.getParameter("uid")%>"
						id="form" method="post">
						<div class="form-group">
							<label for="Password">新密码:</label> <input class="form-control"
								id="chPassword" type="password" name="chPassword" />
						</div>
						<div class="form-group">
							<label for="Password">确认密码:</label> <input class="form-control"
								id="chPassword" type="password" name="confirmPassword" />
						</div>
						<div class="row clearfix">
							<div class="col-md-12 column">${request.info}</div>
							</br>
						</div>
						<button type="submit" class="btn btn-default">提交</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>


