<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.JES.model.Student"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="./agentMemu.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript" src="jquery/JS/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
	function selectoption() {
		//先给年下拉框赋内容  
		var y = new Date().getFullYear();
		var str = "";
		var str2 = "";
		for (var i = (y - 20); i < (y + 20); i++) //以今年为准，前20年，后20年  
		{
			str += "<option value='" + i + "'> " + i + "</option>\r\n";
			str2 += "<option value='" + i + "'> " + i + "</option>\r\n";
		}
		$("#YYYY1").html(str + "</select>");
		$("#YYYY2").html(str2 + "</select>");
		//赋月份的下拉框  
		var str = "";
		var str2 = "";
		for (var i = 1; i < 13; i++) {
			str += "<option value='" + i + "'> " + i + "</option>\r\n";
			str2 += "<option value='" + i + "'> " + i + "</option>\r\n";
		}
		$("#MM1").html(str + "</select>");
		$("#MM2").html(str2 + "</select>");
		$("#YYYY1").val(y);
		$("#YYYY2").val(y);
		$("#MM1").val(new Date().getMonth() + 1);
		$("#MM2").val(new Date().getMonth() + 2);
		getJSONData('全部');
	}

	function getJSONData(value) {
		$("#YMchose").hide();
		var mid=$("#midvalue").val();
		$.ajax({
			type : "post",
			url : "SuperAgentLookAgentYejiAction.action",
			data : {
				'selecttype' : value,
				'mid':mid
			},
			datatype : "json",
			success : function(json) {
				var order = $.parseJSON(json.jsonResult);
				var result = "";
				if (order == null) {
					return;
				}
				result += "<thead>";
				result += "<tr class='thead'>";
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
				for (var i = 0; i < order.length; i++) {
					result += "<tr >";
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

	function getJSONDataBytime() {
		var fy = $("#YYYY1").val();
		var fm = $("#MM1").val()
		var ly = $("#YYYY2").val();
		var lm = $("#MM2").val();
		var mid=$("#midvalue").val();
		$.ajax({
			type : "post",
			url : "SuperReportFindAgentByTimeAction.action",
			data : {
				'firstY' : fy,
				'firstM' : fm,
				'lastY' : ly,
				'lastM' : lm,
				'mid': mid
			},
			datatype : "json",
			success : function(json) {
				var order = $.parseJSON(json.jsonResult);
				var result = "";
				if (order == null) {
					return;
				}
				result += "<thead>";
				result += "<tr class='thead'>";
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
				for (var i = 0; i < order.length; i++) {
					result += "<tr >";
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

	function showmyselect() {
		$("#YMchose").show();
	}
</script>
</head>
<body onload="selectoption()">
	<div class="body slide">
		<div class="container-fluid left-border">
			<div class="row">
				<div class="col-md-12 col-lg-12">
					<br>
					<ul class="breadcrumb">
						<li><a href="<%=basePath%>agent/agentMemu.jsp">主页</a></li>
						<li class="active">我的业绩</li>
					</ul>
					<nav class="navbar navbar-default navbar-static-top"
						role="navigation">
					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<form class="navbar-form navbar-left" role="search" method="post"
							name="form1">
							<div>
								<input type="radio" checked="checked" name="selecttype"
									value="全部" onclick="getJSONData(this.value)" />全部业绩<br /> <input
									type="radio" name="selecttype" value="周业绩"
									onclick="getJSONData(this.value)" />周业绩查询<br /> <input
									type="radio" name="selecttype" value="月业绩"
									onclick="getJSONData(this.value)" />月业绩查询<br /> <input
									type="radio" name="selecttype" value="自定义业绩"
									onclick="showmyselect()" />自定义业绩查询<br />
							</div>
							<div id="YMchose" style="display: none">
								<label>起始</label> <select id=YYYY1 name=YYYY1>
									<option value="">年</option>
								</select> <select id=MM1 name=MM1>
									<option value="">月</option>
								</select> <label> - 结束</label> <select id=YYYY2 name=YYYY2>
									<option value="">年</option>
								</select> <select id=MM2 name=MM2>
									<option value="">月</option>
								</select> <input type="button" onclick="getJSONDataBytime()" value="查询">
							</div>
							<input id="midvalue" type="hidden" value=<%=request.getParameter("mid")%>>
						</form>
					</div>
					</nav>
					<table class="table" id="courseList">

						<tbody id="courseList">

						</tbody>
					</table>

					<div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
