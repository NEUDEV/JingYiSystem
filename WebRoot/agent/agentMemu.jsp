<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.JES.model.Student"%>
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
								<a class="panel-title collapsed" data-toggle="collapse"
									data-parent="#panel-699072" href="#panel-element-16476">我的学员</a>
							</div>
							<div id="panel-element-16476" class="panel-collapse collapse">
								<div class="panel-body">
									<a href="<%=basePath%>agent/studentAdmit.jsp">添加学员</a>
								</div>
								<div class="panel-body">
									<a href="<%=basePath%>agent/studentShow.jsp">我的学员</a>
								</div>
								<div class="panel-body">
									<a href="StudentMassageFileOutAction.action">导出学员</a>
								</div>
							</div>
						</div>

						<div class="panel panel-default">
							<div class="panel-heading">
								<a class="panel-title" data-toggle="collapse"
									data-parent="#panel-699072" href="#panel-element-724199">我的团队</a>
							</div>
							<div id="panel-element-724199" class="panel-collapse in">
								<div class="panel-body">
									<a href="<%=basePath%>agent/agentShow.jsp"">团队成员</a>
								</div>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<a class="panel-title" data-toggle="collapse"
									data-parent="#panel-699072" href="#panel-element-724200">我的业绩</a>
							</div>
							<div id="panel-element-724200" class="panel-collapse in">
								<div class="panel-body">
								<a  href="<%=basePath%>agent/myreport.jsp">我的业绩</a>
								</div>
								<div class="panel-body">
								<a  href="<%=basePath%>agent/agentreport.jsp">班主任业绩</a>
								</div>
								<div class="panel-body">
								<a  href="<%=basePath%>agent/all_report.jsp">业绩汇总</a>
								</div>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<a class="panel-title collapsed" data-toggle="collapse"
									data-parent="#panel-699072" href="#panel-element-16477">我的账户</a>
							</div>
							<div id="panel-element-16477" class="panel-collapse collapse">
								<div class="panel-body">
									<a
										href="<%=basePath%>Agent/AgentLoginAndInfo_displayAgentInfo.action">个人信息</a>
								</div>
								<div class="panel-body">
									<a
										href="<%=basePath%>Agent/AgentLoginAndInfo_getAccountInfo.action">银行卡信息</a>
								</div>
								<div class="panel-body">
									<a href="<%=basePath%>agent/agentChangePassword.jsp">修改密码</a>
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
