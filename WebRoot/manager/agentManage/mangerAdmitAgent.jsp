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
						<li class="active">修改班主任</li>
						<li><a href="#">修改成功</a></li>
					</ul>

					<form
						action="<%=basePath%>Manager/ManagerAgentManage_change.action?uid=<%=request.getParameter("uid")%>"
						id="form" method="post">
						<div class="form-group">
							<label for="aname">账户名</label><input class="form-control"
								id="aname" type="text" name="aname" placeholder="不修改则不填" />
						</div>
						<div class="form-group">
							<label for="name">姓名</label><input class="form-control" id="name"
								type="text" name="name" placeholder="不修改则不填" />
						</div>
						<div class="form-group">
							<label for="qq">qq</label><input class="form-control" id="qq"
								type="number" name="qq" placeholder="不修改则不填" />
						</div>
						<div class="form-group">
							<label for="phone">电话</label><input class="form-control"
								id="phone" type="number" name="phone" size="11"
								placeholder="不修改则不填" />
						</div>
						<div class="form-group">
							<label for="role">选择班主任级别:</label> <select name="role"
								class="form-control">
								<option>班主任</option>
								<option>超级班主任</option>
							</select>
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


