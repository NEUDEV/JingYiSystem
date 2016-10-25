<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.JES.model.Student"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="./agentMemu.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript" src="jquery/JS/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
	function getJSONData() {
		var type = $("#searchtype").val();
		var value = $("#searchvalue").val();
		$.ajax({
			type : "post",
			url : "MyCpReportAction.action",
			data : {
				'searchtype' : type,
				'searchvalue' : value
			},
			datatype : "json",
			//contentType: "application/json",
			success : function(json) {
				//alert(typeof(json.jsonResult));
				var order = $.parseJSON(json.jsonResult);
				//var mybills = $.parseJSON(json.jsonResult.bills);
				//alert(typeof(order));
				//var data=JSON.parse(aa);
				//alert(order[0].uid);
				//alert("success:"+order[0].name);
				var result = "";
				if (order == null) {
					//alert('order is null');
					return;
				}
				result += "<thead>";
				result += "<tr class='thead'>";
				result += "<th>班主任姓名</th>";
				result += "<th>QQ</th>";
				result += "<th>电话</th>";
				result += "<th>新增非正式学员</th>";
				result += "<th>版式学员</th>";
				result += "<th>字体学员</th>";
				result += "<th>品牌学员</th>";
				result += "<th>全科班学员</th>";
				result += "<th>插画学员</th>";
				result += "<th>电商学员</th>";
				result += "<th>终身学员</th>";
				result += "<th>转化率</th>";
				result += "<th>业绩</th>";
				result += "</tr>";
				result += "</thead>";
				result += "<tbody>";
				//这里的order[i]就相当于list中的order,起属性也是一一对应的  
				for (var i = 0; i < order.length; i++) {
					result += "<tr >";
					result += "<td>" + order[i].aname + "</td>";
					result += "<td>" + order[i].aqq + "</td>";
					result += "<td>" + order[i].aphone + "</td>";
					result += "<td>" + order[i].informalstu + "</td>";
					result += "<td>" + order[i].platestu + "</td>";
					result += "<td>" + order[i].typefacestu + "</td>";
					result += "<td >" + order[i].brandstu + "</td>";
					result += "<td >" + order[i].fullstu + "</td>";
					result += "<td >" + order[i].illustration + "</td>";
					result += "<td >" + order[i].onlinestu + "</td>";
					result += "<td >" + order[i].lifetimestu + "</td>";
					result += "<td >" + order[i].transrate + "</td>";
					/* result += "<td ><a href=\"showstudentmassage.jsp?qq=" + order[i].qq + "\">查看|</a>";
					result += "<a href=\"billstudent.jsp?stuid=" + order[i].stuid + "&uid="+order[i].uid+ "&name="
						+order[i].name+"&qq="+order[i].qq+"&weixin="+order[i].weixin+"&phone="+order[i].phone+"\">提单</a></td>"; */
					result += "<td >" + order[i].allbills + "</td>";
					result += "</tr>";
				}
				result += "</tbody>";
				$("#courseList").html(result);
			},
			error : function(text) {
				alert("erro");
			}
		});
	}
</script>
</head>
<body onload="getJSONData()">
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<ul class="breadcrumb">
			<li><a href="<%=basePath%>agent/agentMemu.jsp">主页</a></li>
			<li class="active">班主任业绩</li>
		</ul>
		<nav class="navbar navbar-default navbar-static-top" role="navigation">
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<form class="navbar-form navbar-left" role="search" method="post">
				<select name="searchtype" id="searchtype" class="form-control">
					<option>班主任姓名</option>
					<option>班主任QQ</option>
					<option>班主任手机号</option>
				</select>
				<div class="form-group">
					<input class="form-control" name="searchvalue" id="searchvalue"
						type="text" />
				</div>
				<button type="button" class="btn btn-default"
					onclick="getJSONData()">Submit</button>
			</form>
		</div>
		</nav>
		<table class="table" id="courseList">

			<tbody id="courseList">

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
</body>
</html>
