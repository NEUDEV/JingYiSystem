<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="./agentMemu.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>开设代理商账户</title>
<link href="<%=basePath%>resource/css/signin.css" rel="stylesheet">
</head>

<body>
	<div class="body slide">
		<div class="container-fluid left-border">
			<div class="row">
				<div class="col-md-12 col-lg-12">
					<br>
					<ul class="breadcrumb">
						<li><a href="<%=basePath%>/agent/agentMemu.jsp">主页</a></li>
						<li class="active">查看银行卡信息</li>
					</ul>
					<dl>
						<dt>我的账号信息：</dt>

					</dl>

					<table class="table table table-bordered">
						<thead>
							<tr>
								<th>序号</th>
								<th>银行</th>
								<th>卡号</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${request.accounts}" var="account">
								<tr>
									<td>${i=i+1}</td>
									<td>${account.bank}</td>
									<td>${account.account}</td>
									<td><a
										href="<%=basePath%>Agent/AgentLoginAndInfo_deleteAccount.action?bid=${account.bid}">删除
									</a></td>

								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="row clearfix">
						<div class="col-md-12 column">${request.info}</div>
					</div>
					<a class="btn btn-default"
						href="<%=basePath%>agent/agentAddAccount.jsp" role="button">新增银行卡</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

