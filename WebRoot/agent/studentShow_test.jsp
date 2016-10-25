<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.JES.model.Student"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="./agentMemu.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript" src="jquery/JS/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(
			function getJSONData(pn) {
				$.ajax({
					url : "AgentStudentsAction.action",
					type : "post",
					success : function(data) {
						var jsonObj = eval("(" + data + ")");
						$.each(jsonObj, function(i, item) {
							jQuery("#courseList").append(
									"<tr><td>" + item.uid + "</td>" + "<td>"
											+ item.stuid + "</td>" + "<td>"
											+ item.name + "</td>" + "<td>"
											+ item.phone + "</td>" + "<td>"
											+ item.qq + "</td>" + "<td>"
											+ item.weixin + "</td>" + "<td>"
											+ item.sfrom + "</td>" + "<td>"
											+ item.sign + "</td>" + "<td>"
											+ item.intime + "</td>" + "<td>"
											+ item.mark + "</td></tr>");
						});
					},
					error : function(text) {
					}
				});
			})
</script>
</head>
<body>
	<div class="body slide">
		<div class="container-fluid left-border">
			<div class="row">
				<div class="col-md-12 col-lg-12">
					<br>
					<nav class="navbar navbar-default navbar-static-top"
						role="navigation">
					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<form class="navbar-form navbar-left" role="search" action=""
							method="post">
							<select name="searchtype" class="form-control">
								<option>学员UID</option>
								<option>真实姓名</option>
								<option>手机号</option>
								<option>QQ</option>
								<option>学号</option>
							</select>
							<div class="form-group">
								<input class="form-control" name="searchvalue" type="text" />
							</div>
							<button type="submit" class="btn btn-default">Submit</button>
							<a href="StudentMassageFileOutAction">导出所有学员信息</a>
						</form>
					</div>
					</nav>
					<table class="table">
						<thead>
							<tr>
								<!-- <th>序号</th> -->
								<th>UID</th>
								<th>学号</th>
								<th>姓名</th>
								<th>手机号</th>
								<th>QQ</th>
								<th>微信</th>
								<th>来源</th>
								<th>状态</th>
								<th>录入时间</th>
								<th>学员转化指数</th>
							</tr>
						</thead>
						<tbody id="courseList">
							<%-- <%
					List<Student> list = (List<Student>) request
							.getAttribute("mystudent");
					if (list != null) {
						for (int i = 0; i < list.size(); i++) {
				%> --%>
							<%-- <tr>
					<td><%=i + 1%></td>
					<td><%=list.get(i).getUid()%></td>
					<td><%=list.get(i).getStuid()%></td>
					<td><%=list.get(i).getName()%></td>
					<td><%=list.get(i).getPhone()%></td>
					<td><%=list.get(i).getQq()%></td>
					<td><%=list.get(i).getWeixin()%></td>
					<td><%=list.get(i).getSfrom()%></td>
					<td><%=list.get(i).getSign()%></td>
					<td><%=list.get(i).getIntime()%></td>
					<td><%=list.get(i).getMark()%></td>
				</tr> --%>
							<%-- <%
					}
						session.putValue("mystudent", null);
					}
				%> --%>
						</tbody>
					</table>

					<div>
						<!-- <input id="firstPage" name="firstPage" type="button" value="第一页" /> <input
				id="prev" name="prev" type="button" value="上一页" /> <input id="next"
				name="next" type="button" value="下一页" /> <input id="lastPage"
				name="lastPage" type="button" value="最后一页     " /> <input
				id=".page-num" name=".page-num" type="text" /> <input
				id="page-jump" name="page-jump" type="button" value="跳转—>" /> <label
				id=".page-count" name=".page-count"></label> -->
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
