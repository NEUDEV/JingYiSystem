<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.JES.model.Student"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="./agentMemu.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

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
						<li class="active">学员信息</li>
					</ul>
					<form action="" id="form" method="post"
						enctype="multipart/form-data">
						<!-- <div class="form-group">
				<label for="qq">输入QQ：</label><input class="form-control" id="qq"
					type="text" name="qq" />
			</div> -->
						<div class="form-group">
							<label for="stuid">学号：</label> <label id="stuid" name="stuid"><%=request.getParameter("stuid")%></label>
						</div>
						<div class="form-group">
							<label for="name">姓名：</label><label id="name" name="name"><%=request.getParameter("name")%></label>
						</div>
						<div class="form-group">
							<label for="phone">电话：</label> <label id="phone" name="phone"><%=request.getParameter("phone")%></label>
						</div>
						<div class="form-group">
							<label for="qq">QQ：</label><label id="sqq" type="text" name="sqq"
								disabled=true><%=request.getParameter("qq")%></label>

						</div>

						<div class="form-group">
							<label for="weixin">微信：</label> <label id="weixin" name="weixin"><%=request.getParameter("weixin")%></label>
						</div>
						<div class="form-group">
							<label for="sign">状态：</label> <label id="sign" name="sign"><%=request.getParameter("sign")%></label>
						</div>
						<div class="form-group">
							<label for="sfrom">状态：</label> <label id="sign" name="sfrom"><%=request.getParameter("sfrom")%></label>
						</div>
						<div class="form-group">
							<label for="intime">状态：</label> <label id="intime" name="intime"><%=request.getParameter("intime")%></label>
						</div>
						<div class="form-group">
							<img alt="显示图片" style="height:200px;width: 300px "
								src="ShowviewAction.action?qq=<%=request.getParameter("qq")%>"></img>
						</div>
						<div class="form-group">
							<label for="note">备注：</label> <label id="note" name="note"><%=request.getParameter("note")%></label>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
