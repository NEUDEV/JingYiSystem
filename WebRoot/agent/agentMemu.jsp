<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.JES.model.Student"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/index.jsp"%>

<!DOCTYPE html>
<html>
<head>
<link href="<%=basePath%>resource/css/dashboard.css" rel="stylesheet">
<script src="<%=basePath%>resource/js/warning.js"></script>

<link rel="stylesheet" type="text/css"
	href="<%=basePath%>resource/css/sidebara.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>resource/css/sidebarb.css">
<link href="<%=basePath%>resource/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>resource/css/design.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>resource/css/font-awesome.min.css">


<script src="<%=basePath%>resource/jquery/jquery.min.js"></script>
<script src="<%=basePath%>resource/js/bootstrap.min.js"></script>

<script>
	(function(i, s, o, g, r, a, m) {
		i['GoogleAnalyticsObject'] = r;
		i[r] = i[r] || function() {
			(i[r].q = i[r].q || []).push(arguments)
		}, i[r].l = 1 * new Date();
		a = s.createElement(o), m = s.getElementsByTagName(o)[0];
		a.async = 1;
		a.src = g;
		m.parentNode.insertBefore(a, m)
	})(window, document, 'script', '//www.google-analytics.com/analytics.js',
			'ga');

	ga('create', 'UA-44073820-8', 'auto');
	ga('send', 'pageview');
</script>
</head>

<body>
	<div class="col-sm-3 col-md-2 sidebar">
		<aside class="sidebar show perfectScrollbar">
			<div id="solso-sidebar">
				<div class="panel-group" id="accordion" role="tablist"
					aria-multiselectable="true">

					<div class="panel panel-default">
						<div class="panel-heading" role="tab" id="heading2">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion"
									href="#collapse2" aria-expanded="true"
									aria-controls="collapse2"> <i class="fa"></i> 我的学员
								</a>
							</h4>
						</div>

						<div id="collapse2" class="panel-collapse collapse"
							role="tabpanel" aria-labelledby="heading2">
							<div>
								<a href="<%=basePath%>agent/studentAdmit.jsp"
									class="list-group-item">添加学员</a> <a
									href="<%=basePath%>agent/studentShow.jsp"
									class="list-group-item">我的学员</a> <a
									href="StudentMassageFileOutAction.action"
									class="list-group-item">导出学员</a>
							</div>
						</div>
					</div>

					<div class="panel panel-default">
						<div class="panel-heading" role="tab" id="heading3">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion"
									href="#collapse3" aria-expanded="true"
									aria-controls="collapse3"> <i class="fa"></i> 我的团队
								</a>
							</h4>
						</div>

						<div id="collapse3" class="panel-collapse collapse"
							role="tabpanel" aria-labelledby="heading3">
							<div>
								<a href="<%=basePath%>agent/agentShow.jsp"
									class="list-group-item">团队成员 </a>
							</div>
						</div>
					</div>

					<div class="panel panel-default">
						<div class="panel-heading" role="tab" id="heading4">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion"
									href="#collapse4" aria-expanded="true"
									aria-controls="collapse4"> <i class="fa"></i>我的业绩
								</a>
							</h4>
						</div>

						<div id="collapse4" class="panel-collapse collapse"
							role="tabpanel" aria-labelledby="heading4">
							<div>
								<a href="<%=basePath%>agent/myreport.jsp"
									class="list-group-item">我的业绩</a> <a
									href="<%=basePath%>agent/agentreport.jsp"
									class="list-group-item">班主任业绩</a><a
									href="<%=basePath%>agent/all_report.jsp"
									"
								class="list-group-item">业绩汇总</a>
							</div>
						</div>
					</div>

					<div class="panel panel-default">
						<div class="panel-heading" role="tab" id="heading5">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion"
									href="#collapse5" aria-expanded="true"
									aria-controls="collapse5"> <i class="fa"></i> 我的账户
								</a>
							</h4>
						</div>

						<div id="collapse5" class="panel-collapse collapse"
							role="tabpanel" aria-labelledby="heading5">
							<div>
								<a
									href="<%=basePath%>Agent/AgentLoginAndInfo_displayAgentInfo.action"
									class="list-group-item">个人信息</a> <a
									href="<%=basePath%>Agent/AgentLoginAndInfo_getAccountInfo.action"
									class="list-group-item">银行卡信息</a><a
									href="<%=basePath%>agent/agentChangePassword.jsp"
									class="list-group-item">修改密码</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</aside>
	</div>
</body>
</html>
