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
					<br>set-2 main">
					<form action="AgentNoteAction" id="form" method="post"
						enctype="multipart/form-data">
						<div class="form-group">
							<label for="name">记事：</label>
						</div>
						<div class="form-group">
							<textarea name="note" style="height:80px;" maxlength=100
								draggable=false>这里写内容</textarea>
						</div>
						<button type="submit" class="btn btn-default" id="button">提交</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
