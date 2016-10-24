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
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<form action="" id="form" method="post" enctype="multipart/form-data">
			<!-- <div class="form-group">
				<label for="qq">输入QQ：</label><input class="form-control" id="qq"
					type="text" name="qq" />
			</div> -->
			<div class="form-group">
				<img alt="显示图片" style="height:500px;width: 600px "
					src="<s:url action='ShowviewAction'><s:param name='qq' value='1354407066'></s:param></s:url>"></img>
			</div>
			<button type="submit" class="btn btn-default" id="button">提交</button>
		</form>
	</div>
</body>
</html>
