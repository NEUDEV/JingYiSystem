<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/index.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link href="<%=basePath%>resource/css/dashboard.css" rel="stylesheet">
<script src="<%=basePath%>resource/js/warning.js"></script>
</head>

<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<div class="sidebar-nav">
					<div class="panel-group" id="panel-659100">
						<div class="panel panel-default">
							<div class="panel-heading">
								<a class="panel-title" data-toggle="collapse"
									data-parent="#panel-659100" href="#panel-element-24469">班主任管理</a>
							</div>
							<div id="panel-element-24469" class="panel-collapse collapse in">
								<div class="panel-body">
									<a href="<%=basePath%>Manager/ManagerAgentManage_display.action">班主任管理</a>
								</div>
								<div class="panel-body">
									<a href="<%=basePath%>manager/agentManage/agentRegister.jsp">开设班主任账户</a>
								</div>
								<div class="panel-body">
									<a href="<%=basePath%>Manager/ManagerAgentManage_displayCommonAgents.action">班主任划分至超级班主任</a>
								</div>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<a class="panel-title" data-toggle="collapse"
									data-parent="#panel-659100" href="#panel-element-936974">报表</a>
							</div>
							<div id="panel-element-936974" class="panel-collapse collapse">
								<div class="panel-body">
									<a href="<%=basePath%>Manager/ManagerViewReport_displayReport.action">查看系统报表</a>
								</div>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<a class="panel-title" data-toggle="collapse"
									data-parent="#panel-659100" href="#panel-element-936975">学员管理</a>
							</div>
							<div id="panel-element-936975" class="panel-collapse collapse">
								<div class="panel-body">
									<a href="<%=basePath%>manager/studentManage/divideStudent/divideStudent.jsp">学员划分</a>
								</div>
								<div class="panel-body">
									<a href="<%=basePath%>manager/studentManage/studentManager.jsp">学员管理</a>
								</div>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<a class="panel-title" data-toggle="collapse"
									data-parent="#panel-659101" href="#panel-element-936980">课程管理</a>
							</div>
							<div id="panel-element-936980" class="panel-collapse collapse">
								<div class="panel-body">
									<a href="<%=basePath%>Manager/ManagerCourseManage_displayCourse.action">课程管理</a>
								</div>
								<div class="panel-body">
									<a href="<%=basePath%>manager/courseManage/addCourse.jsp">增加课程</a>
								</div>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<a class="panel-title" data-toggle="collapse"
									data-parent="#panel-659102" href="#panel-element-936981">管理员管理</a>
							</div>
							<div id="panel-element-936981" class="panel-collapse collapse">
								<div class="panel-body">
									<a href="<%=basePath%>Manager/ManagerOperation_displayManager.action">管理员管理</a>
								</div>
								<div class="panel-body">
									<a href="<%=basePath%>manager/managerOperation/register.jsp">添加管理员</a>
								</div>
								<div class="panel-body">
									<a href="<%=basePath%>Manager/ManagerOperation_toDisplayManager.action">查看个人信息</a>
								</div>
								<div class="panel-body">
									<a href="<%=basePath%>manager/managerOperation/changePassword.jsp">密码修改</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
