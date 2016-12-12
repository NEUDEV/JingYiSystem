<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.JES.model.Student"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="./agentMemu.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<style type="text/css">
.styled-select {

   width: 90px;

   height: 23px;

   overflow: hidden;

   background: url(new_arrow.png) no-repeat right #ddd;

}
</style>


<script type="text/javascript" src="jquery/JS/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
	function changemark(uid,value){
		$.ajax({
			type : "post",
			url : "changemark.action",
			data : {
				'uid' : uid,
				'mark':value
			},
			dataType : "json",
			error : function(data) {
				alert("修改转化指数失败");
				return false;
			}
		});
	}

	function getJSONData(chose) {
		if(chose==0){
			var type = $("#searchtype").val();
			var value = $("#searchvalue").val();
		}
		else {
			var type = "";
			var value = "";
		}
		$.ajax({
			type : "post",
			url : "AgentStudentsAction1.action",
			data : {
				'searchtype' : type,
				'searchvalue' : value,
				'chose':chose
			},
			datatype : "json",
			//contentType: "application/json",
			success : function(json) {
				//alert(typeof(json.jsonResult));
				var order = $.parseJSON(json.jsonResult);
				var max=6;
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
				result += "<th>学号</th>";
				result += "<th>姓名</th>";
				result += "<th>手机号</th>";
				result += "<th>QQ</th>";
				result += "<th>微信</th>";
				result += "<th>来源</th>";
				result += "<th>状态</th>";
				result += "<th>录入时间</th>";
				result += "<th>报名时间</th>";
				result += "<th>操作</th>";
				result += "<th>学员转化指数</th>";
				result += "</tr>";
				result += "</thead>";
				result += "<tbody>";
				//这里的order[i]就相当于list中的order,起属性也是一一对应的  
				for (var i = 0; i < order.length; i++) {
					result += "<tr >";
					result += "<td>" + order[i].stuid + "</td>";
					result += "<td>" + order[i].name + "</td>";
					result += "<td >" + order[i].phone + "</td>";
					result += "<td >" + order[i].qq + "</td>";
					result += "<td >" + order[i].weixin + "</td>";
					result += "<td >" + order[i].sfrom + "</td>";
					result += "<td >" + order[i].sign + "</td>";
					result += "<td >" + order[i].intime + "</td>";
					result += "<td >" + order[i].subtime + "</td>";
					/* result += "<td ><a href=\"showstudentmassage.jsp?stuid="
							+ order[i].stuid + "&uid=" + order[i].uid
							+ "&name=" + order[i].name + "&qq=" + order[i].qq
							+ "&weixin=" + order[i].weixin + "&phone="
							+ order[i].phone + "&note=" + order[i].note
							+ "&sfrom=" + order[i].sfrom + "&intime="
							+ order[i].intime + "&sign=" + order[i].sign
							+ "\">查看|</a>"; */
					result += "<td ><a href=\"billstudent.jsp?stuid="
							+ order[i].stuid + "&uid=" + order[i].uid
							+ "&name=" + order[i].name + "&qq=" + order[i].qq
							+ "&weixin=" + order[i].weixin + "&phone="
							+ order[i].phone + "\">修改</a></td>";
					/* result += "<td >" + order[i].mark + "</td>"; */
					result += "<td >";
					result +="<select class='styled-select' onchange=\"changemark('"+order[i].uid
					+"',this.value)\">"
					for (var j = 1; j < max; j++) {
					result += "<option value='"+j;
					if(order[i].mark==j) result +="' selected = 'selected"; 
					result +="'>" + j + "星</option>";
				}
					result +="</select></td>"; 
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
<body onload="getJSONData(1)">
	<div class="body slide">
		<div class="container-fluid left-border">
			<div class="row">
				<div class="col-md-12 col-lg-12">
					<br>
					<ul class="breadcrumb">
						<li><a href="<%=basePath%>agent/agentMemu.jsp">主页</a></li>
						<li class="active">我的学员</li>
					</ul>
					<nav class="navbar navbar-default navbar-static-top"
						role="navigation">
					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<form class="navbar-form navbar-left" role="search" method="post">
							<select name="searchtype" id="searchtype" class="form-control">
								<option>真实姓名</option>
								<option>手机号</option>
								<option>QQ</option>
								<option>微信</option>
								<option>学号</option>
							</select>
							<div class="form-group">
								<input class="form-control"  name="searchvalue" id="searchvalue"
									type="text" />
							</div>
							<button type="button"  class="btn btn-default"
								onclick="getJSONData(0)">提交</button>
							<button type="button"  class="btn btn-default"
								onclick="getJSONData(2)">提交(按指数排序)</button>
							<button type="button" class="btn btn-default"
								onclick="getJSONData(1)">显示全部</button>
							<button type="button" class="btn btn-default"
								onclick="getJSONData(3)">显示全部(按指数排序)</button>
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
			</div>
		</div>
	</div>
</body>
</html>
