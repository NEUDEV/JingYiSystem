<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.JES.model.Student"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="./agentMemu.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
</head>
<body>
	<div class="body slide">
		<div class="container-fluid left-border">
			<div class="row">
				<div class="col-md-12 col-lg-12">
					<br>
					<ul class="breadcrumb">
						<li><a href="<%=basePath%>agent/agentMemu.jsp">主页</a></li>
						<li class="active">操作结果</li>
					</ul>
					<nav class="navbar navbar-default navbar-static-top"
						role="navigation">
					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<form class="navbar-form navbar-left" role="search"
							action="upstudents.action" enctype="multipart/form-data"
							method="post">
							<tr>

								<td style="padding-left:30;padding-top:10;color:black;">

									提示：<br><br> <textarea readonly="readonly" name="fileinfo2"
										style="font-size:30px;border:1px solid black;height: 500pt;width: 745pt"><%=request.getAttribute("studentupms")%>>
								</textarea><br>
								</td>
							</tr>
						</form>
					</div>
					</nav>
					<table class="table" id="courseList">

						<tbody id="courseList">

						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
