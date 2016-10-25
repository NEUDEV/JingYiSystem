<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../managerMemu.jsp"%>
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
						<li><a href="<%=basePath%>manager/managerMemu.jsp">主页</a></li>
						<li><a href="#">选择班主任</a></li>
						<li class="active">修改学员信息</li>
						<li><a href="#">登记成功</a></li>
					</ul>

					<form
						action="<%=basePath%>Manager/ManagerStudentManage_changeStudentInfo.action"
						id="form" method="post">
						<table class="table table-bordered table-hover">
							<thead>
								<tr>
									<th>字段</th>
									<th>目前值</th>
									<th>修改值</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>UID</td>
									<td>${student.uid}</td>
									<td><a>不能修改</a></td>
								</tr>
								<tr>
									<td>学号</td>
									<td>${student.stuid}</td>
									<td><a>不能修改</a></td>
								</tr>
								<tr>
									<td>姓名</td>
									<td>${student.name}</td>
									<td><a>不能修改</a></td>
								</tr>
								<tr>

									<td>QQ</td>
									<td>${student.qq}</td>
									<td><input class="form-control" id="qq" type="number"
										placeholder="不需要修改则不填" name="qq" /></td>
								</tr>
								<tr>

									<td>微信</td>
									<td>${student.weixin}</td>
									<td><input class="form-control" id="weixin" type="text"
										placeholder="不需要修改则不填" name="weixin" /></td>
								</tr>
							</tbody>
						</table>
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


