<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../../managerMemu.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>审核学员</title>
</head>

<body>
	<div class="body slide">
		<div class="container-fluid left-border">
			<div class="row">
				<div class="col-md-12 col-lg-12">
					<ul class="breadcrumb">
						<li><a href="<%=basePath%>manager/managerMemu.jsp">主页</a></li>
						<li><a href="#">选择学员</a></li>
						<li class="active">审核</li>
						<li><a href="#">审核成功</a></li>
					</ul>
					<br>
					<dl>
						<dt>
							<font size="4">待审核学员信息：</font>
						</dt>
						</br>
						<dd>
							<font size="3">qq： ${upStudent.qq}</font>
						</dd>
						<br>
						<dd>
							<font size="3">姓名： ${upStudent.name}</font>
						</dd>
						<br>
						<dd>
							<font size="3">手机号： ${upStudent.phone}</font>
						</dd>
						<br>
						<dd>
							<font size="3">微信： ${upStudent.weixin}</font>
						</dd>
						<br>
						<dd>
							<font size="3">备注： ${upStudent.note}</font>
						</dd>
						<br>
						<dd>
							<font size="3">图片：</font>
						</dd>
						<dd>
							<img alt="显示图片" style="height:200px;width: 300px "
								src="<%=basePath%>agent/ShowviewAction.action?qq=${upStudent.qq}"></img>
						</dd>
						<br>
					</dl>

					<a class="btn btn-default"
						href="<%=basePath%>Manager/ManagerAuditStudent_auditStudent.action">审核通过</a>
					<a class="btn btn-default"
						href="<%=basePath%>Manager/ManagerAuditStudent_deletUpStudent.action?stuqq=${upStudent.qq}">未通过删除</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>


