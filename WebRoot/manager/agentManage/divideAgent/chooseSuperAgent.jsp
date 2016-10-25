<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../../managerMemu.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>班主任划分</title>
</head>

<body>
	<div class="body slide">
		<div class="container-fluid left-border">
			<div class="row">
				<div class="col-md-12 col-lg-12">
					<br>
					<ul class="breadcrumb">
						<li><a href="<%=basePath%>manager/managerMemu.jsp">主页</a></li>
						<li><a href="#">选择班主任</a></li>
						<li class="active">选择超级班主任</li>
						<li><a href="#">划分成功</a></li>
					</ul>
					<nav class="navbar navbar-default navbar-static-top"
						role="navigation">
					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<form class="navbar-form navbar-left" role="search"
							action="<%=basePath%>Manager/ManagerAgentManage_searchSuperAgents.action"
							method="post">
							<select name="searchType" class="form-control">
								<option>账户名</option>
								<option>姓名</option>
								<option>手机号</option>
								<option>QQ</option>
							</select>
							<div class="form-group">
								<input class="form-control" name="searchValue" type="text" />
							</div>
							<button type="submit" class="btn btn-default">查找超级班主任</button>
						</form>
					</div>
					</nav>

					<a>请选择超级班主任：（单选）</a>
					<form
						action="<%=basePath%>Manager/ManagerAgentManage_divideAgent.action"
						method="post" id="selectSuperAgentForm">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>序号</th>
									<th>账户名</th>
									<th>姓名</th>
									<th>手机号</th>
									<th>QQ</th>
									<th>班主任类别</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${request.agentList}" var="agent">
									<tr>
										<td>${i=i+1}</td>
										<td>${agent.aname}</td>
										<td>${agent.name}</td>
										<td>${agent.phone}</td>
										<td>${agent.qq}</td>
										<td>${agent.role}</td>
										<td><label><input name="radio" type="radio"
												value="${agent.uid}" /></label></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</form>
					<div class="row clearfix">
						<div class="col-md-12 column">${request.info}</div>
						<br>
					</div>
					<input type="button" class="btn btn-default " value="选择完成"
						onclick="document.getElementById('selectSuperAgentForm').submit();"
						style="margin-right;" /><br>
				</div>
			</div>
		</div>
	</div>
</body>
</html>


