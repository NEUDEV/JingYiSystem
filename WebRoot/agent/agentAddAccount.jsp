<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="./agentMemu.jsp"%>
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
					<ul class="breadcrumb">
						<li><a href="<%=basePath%>/agent/agentMemu.jsp">主页</a></li>
						<li><a href="#">查看银行卡信息</a></li>
						<li class="active">新增银行卡</li>
					</ul>

					<form
						action="<%=basePath%>Agent/AgentLoginAndInfo_addAccount.action"
						id="form" method="post">
						<div class="form-group">
							<label for="role">银行</label> <select name="selectBank"
								class="form-control">
								<option>工商银行</option>
								<option>建设银行</option>
								<option>中国银行</option>
								<option>农业银行</option>
								<option>招商银行</option>
								<option>中信银行</option>
								<option>其他银行</option>
							</select>
						</div>
						<div class="form-group">
							<label for="name">账号</label><input class="form-control"
								id="account" type="number" name="account" />
						</div>
						<div class="col-md-12 column">${request.info}</div>
						<button type="submit" class="btn btn-default">提交</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>


