<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../managerMemu.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>课程管理</title>
<link href="<%=basePath%>resource/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet" media="screen">
<script type="text/javascript"
	src="<%=basePath%>resource/js/bootstrap-datetimepicker.js"
	charset="UTF-8"></script>
<script type="text/javascript"
	src="<%=basePath%>resource/js/locales/bootstrap-datetimepicker.fr.js"
	charset="UTF-8"></script>
<script type="text/javascript">
	$(function() {
		$("#commit").click(function() {
			if ($("#classname").val() == "") {
				alert("课程名不能为空");
			} else if ($("#starttime").val() == "") {
				alert("开课时间不能为空");
			} else if ($("#endtime").val() == "") {
				alert("结课时间不能为空");
			} else if ($("#referencebill").val() == "") {
				alert("参考价格不能为空");
			} else {
				$('form').submit();
			}
		});
	});
</script>
</head>

<body>
	<div class="body slide">
		<div class="container-fluid left-border">
			<div class="row">
				<div class="col-md-12 col-lg-12">
					<br>
					<ul class="breadcrumb">
						<li><a href="<%=basePath%>manager/managerMemu.jsp">主页</a></li>
						<li class="active">添加课程</li>
						<li class="#">课程添加成功</li>
					</ul>

					<form
						action="<%=basePath%>Manager/ManagerCourseManage_addCourse.action"
						id="form" method="post">
						<div class="form-group">
							<label for="cname">选择课程类别</label> <select name="cname"
								class="form-control">
								<option>板式学员</option>
								<option>字体学员</option>
								<option>品牌学员</option>
								<option>全科班学员</option>
								<option>插画学员</option>
								<option>电商学员</option>
							</select>
						</div>
						<div class="form-group">
							<label for="classname">课程名：</label><input class="form-control"
								id="classname" type="text" name="classname" value="" />
						</div>
						<div class="form-group">
							<label for="starttime">开课时间：</label>

							<div class="controls input-append date form_date form-group"
								data-date="" data-date-format="yyyy-mm-dd">
								<input size="16" type="text" value="" readonly
									class="form-control" name="starttime" id="starttime"> <span
									class="add-on"><i class="icon-remove"></i></span> <span
									class="add-on"><i class="icon-th"></i></span>
							</div>
						</div>
						<div class="form-group">
							<label for="endtime">结课时间：</label>
							<div class="controls input-append date form_date form-group"
								data-date="" data-date-format="yyyy-mm-dd">
								<input size="16" type="text" value="" readonly
									class="form-control" id="endtime" name="endtime"> <span
									class="add-on"><i class="icon-remove"></i></span> <span
									class="add-on"><i class="icon-th"></i></span>
							</div>
						</div>
						<div class="form-group">
							<label for="referencebill">参考价格：</label><input
								class="form-control" id="referencebill" type="number"
								name="referencebill" size="11" />
						</div>
						<div class="col-md-12 column">${request.info}</div>
						<input type="button" class="btn btn-default" value="提交"
							id="commit">
					</form>
				</div>
			</div>
		</div>
	</div>

	<br />
	<script type="text/javascript">
		$('.form_date').datetimepicker({
			language : 'fr',
			weekStart : 1,
			todayBtn : 1,
			autoclose : 1,
			todayHighlight : 1,
			startView : 2,
			minView : 2,
			forceParse : 0
		});
	</script>
</body>
</html>


