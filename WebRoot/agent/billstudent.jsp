<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.JES.model.Student"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="./agentMemu.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript" src="jquery/JS/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="jquery/JS/jQuery.js"></script>
<script type="text/javascript">
	function cheackblock() {
		var bill = $("#bill").val();
		var s = /^[0-9]*$/;
		//alert(name+qq+s);
		if (bill == ""||!s.test(bill)) {
			$("#submit1").attr("disabled", "true");
			$('#billms').html("(请输入学费)");
		} else {
			//$("#submit1").attr("disabled", "false");
			$('#submit1').removeAttr("disabled");
			$('#billms').html("");
		}

	}

	function course() {
		$.ajax({
			type : "post",
			url : "GetCourseAction.action",
			data : "",
			datatype : "json",
			success : function(json) {
				var order = $.parseJSON(json.jsonResult);
				var result = "";
				if (order == null) {
					return;
				}
				result += "<label for='class_'>报名科目</label>";
				result += "<select name='class_' class='form-control'>";
				for (var i = 0; i < order.length; i++) {
					result += "<option value='"+order[i].cname+"'>" + order[i].classname + "</option>";
				}
				result += "</select>";
				$("#courseshow").html(result);
			},
			error : function(text) {
				alert("erro");
			}
		});
	}
</script>
</head>
<body onload="course()">
	<div class="body slide">
		<div class="container-fluid left-border">
			<div class="row">
				<div class="col-md-12 col-lg-12">
					<br>
					<ul class="breadcrumb">
						<li><a href="<%=basePath%>agent/agentMemu.jsp">主页</a></li>
						<li class="active">提单</li>
					</ul>
					<form action="AgentBillAction" name="form" id="form" method="post"
						enctype="multipart/form-data">
						<input type="hidden" name="uid"
							value=<%=request.getParameter("uid")%>></input>
						<div class="form-group">
							<label for="stuid">学号*</label><input class="form-control"
								id="stuid" type="text" name="stuid" disabled=true
								value=<%=request.getParameter("stuid")%>></input>
						</div>
						<div class="form-group">
							<label for="name">姓名*</label><input class="form-control"
								id="name" type="text" name="name" disabled=true
								value=<%=request.getParameter("name")%>></input>
						</div>
						<div class="form-group">
							<label for="phone">电话</label> <input class="form-control"
								id="phone" type="text" name="phone"
								value=<%=request.getParameter("phone")%>></input>
						</div>
						<div class="form-group">
							<label for="qq">QQ*</label><input class="form-control" id="sqq"
								type="text" name="sqq" disabled=true
								value=<%=request.getParameter("qq")%>></input>

						</div>

						<div class="form-group">
							<label for="weixin">微信</label> <input class="form-control"
								id="weixin" type="text" name="weixin"
								value=<%=request.getParameter("weixin")%>></input>
						</div>
						<div class="form-group">
							<label for="sign">状态</label> <select name="sign"
								class="form-control">
								<option>正式学员</option>
								<option>非正式学员</option>
							</select>
						</div>
						<div class="form-group" id="courseshow">
							<!-- <label for="class_">报名科目</label> 
				<select name="class_" class="form-control">
					<option>科目A</option>
					<option>科目B</option>
				</select> -->
						</div>
						<div class="form-group">
							<label for="bill">学费</label><label style="color:red">*</label> <label
								id="billms" style="color:red"></label> <input
								class="form-control" id="bill" type="number" name="bill"
								onblur="cheackblock()"  />
						</div>
						<div>
							<label id="billms"></label>
						</div>
						<div class="form-group">
							<label for="mark">转化指数</label>
							<div>
								<input type="radio" checked="checked" name="mark" value="1" />1星<br />
							</div>
							<div>
								<input type="radio" name="mark" value="2" />2星<br />
							</div>
							<div>
								<input type="radio" name="mark" value="3" />3星<br />
							</div>
							<div>
								<input type="radio" name="mark" value="4" />4星<br />
							</div>
							<div>
								<input type="radio" name="mark" value="5" />5星<br />
							</div>
						</div>
						<button type="submit" disabled=true class="btn btn-default"
							id="submit1" name="submit1">提交</button>
						<label>带*为必填项</label>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
