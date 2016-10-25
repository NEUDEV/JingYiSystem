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
						<li class="active">电子表格录入学员信息</li>
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

									模板下载：<br> <a href="downestudents.action">点击这里下载模板</a> <br />
								<br />文件路径：<br> <input
									style="color:black;background-color:#5DA1E3;" type="file"
									name="upstudents" size="60"><br> <textarea
										rows="5" cols="69" name="fileinfo2"
										style="border:1px solid black;"></textarea><br> <input
									class="btn1" type="submit" value="上传"
									style="border:0;width:74;height:21" value=""> <input
									type="reset" class="btn1" style="width:74px;height:21px;"
									value="取消">
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
