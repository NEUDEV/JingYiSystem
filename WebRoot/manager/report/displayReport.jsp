<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../managerMemu.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>划分学员</title>
</head>

<body>
	<div class="body slide">
		<div class="container-fluid left-border">
			<div class="row">
				<div class="col-md-12 col-lg-12">
					<br>
					<ul class="breadcrumb">
						<li><a href="<%=basePath%>manager/managerMemu.jsp">主页</a></li>
						<li class="active">查看系统报表</li>
					</ul>
					<nav class="navbar navbar-default navbar-static-top"
						role="navigation">
					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<form class="navbar-form navbar-left" role="search"
							action="<%=basePath%>Manager/ManagerViewReport_displayReportByAgent.action"
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
							<button type="submit" class="btn btn-default">查找</button>
						</form>
					</div>
					</nav>

					<table class="table table table-bordered">
						<thead>
							<tr>
								<th>序号</th>
								<th>新增非正式学员</th>
								<th>正式学员</th>
								<th>板式学员</th>
								<th>字体学员</th>
								<th>品牌学员</th>
								<th>全科班学员</th>
								<th>插画学员</th>
								<th>电商学员</th>
								<th>终身学员</th>
								<th>金额</th>
								<th>转化率</th>
							</tr>
						</thead>

						<tbody>
							<c:forEach items="${request.reports}" var="report">
								<tr>
									<td>${i = i + 1}</td>
									<td>${report.informalstu}</td>
									<td>${report.allinnum}</td>
									<td>${report.platestu}</td>
									<td>${report.typefacestu}</td>
									<td>${report.brandstu}</td>
									<td>${report.fullstu}</td>
									<td>${report.illustration}</td>
									<td>${report.onlinestu}</td>
									<td>${report.lifetimestu}</td>
									<td>${report.allbills}</td>
									<td>${report.transrate}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>


