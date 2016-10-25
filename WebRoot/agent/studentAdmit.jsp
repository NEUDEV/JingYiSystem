<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.JES.model.Student"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="./agentMemu.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript" src="jquery/JS/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
	function cheackblock(input) {
		//var bill=input.val();
		//alert(name+qq+s);
		if (input == "") {
			$('#submit').attr("disabled", "true");
		} else {
			if ($("#name").val() != "" && $("#qq").val() != ""
					&& document.form.file.value != "")
				$('#submit').removeAttr("disabled");
		}

	}

	function cheackfileblock() {
		var s = document.form.file.value;
		if (s == "") {
			$('#submit').attr("disabled", "true");
		} else {
			if ($("#name").val() != "" && $("#qq").val() != "")
				$('#submit').removeAttr("disabled");
		}
	}

	function clickQqFunctino() {
		//alert($("#xm").val());  
		var params = $("#qq").val();

		$.ajax({
			type : "post",
			url : "cheakqq.action",
			data : {
				'qq' : params
			},
			dataType : "json",
			success : function(data) {
				//alert(data);  
				//var obj = $.parseJSON(json);  //使用这个方法解析字符串json result  
				if (data.result == "true") {
					$("#qq").val("");
					$('#qqms').html("qq号已存在");
				} else if (data.result == "false") {
					$('#qqms').html("");
				}
				cheackblock($("#qq").val());
			},
			error : function(data) {
				alert("后台验证QQ号失败");
				return false;
			}
		});
	};
</script>
</head>
<body>
	<div class="body slide">
		<div class="container-fluid left-border">
			<div class="row">
				<div class="col-md-12 col-lg-12">
					<br>
					<ul class="breadcrumb">
						<li><a href="<%=basePath%>agent/agentMemu.jsp">主页</a></li>
						<li class="active">添加学员</li>
					</ul>
					<form action="AgentUpStudentAction" name="form" id="form"
						method="post" enctype="multipart/form-data">
						<div class="form-group">
							<label>电子表格录入</label><br> <a
								href="<%=basePath%>agent/studentmsUp.jsp">点击这里录入</a>
						</div>
						<div>
							<label>手动录入</label><br>
							<div class="form-group">
								<label for="name">姓名*</label><input class="form-control"
									id="name" type="text" name="name"
									onblur="cheackblock(this.value)" />
							</div>
							<div class="form-group">
								<label for="qq">QQ*</label><label id="qqms" style="color:red"></label>
								<input class="form-control" id="qq" type="text" name="qq"
									onblur="clickQqFunctino()" />

							</div>
							<div>
								<label id="qqms"></label>
							</div>
							<div class="form-group">
								<label for="weixin">微信</label> <input class="form-control"
									id="weixin" type="text" name="weixin" />
							</div>
							<div class="form-group">
								<label for="phone">电话</label> <input class="form-control"
									id="phone" type="text" name="phone" />
							</div>
							<div class="form-group">
								<label for="name">备注：</label>
							</div>
							<div class="form-group">
								<textarea name="note" id="note" style="height:80px;"
									maxlength=100 draggable=false>输入&#13;&#10;即可成功换行</textarea>
							</div>
							<div class="form-group">
								<label for="class_">上传截图*</label> <input type="file" name="file"
									id="file" onblur="cheackfileblock()">
							</div>
							<button type="submit" disabled="disabled" class="btn btn-default"
								id="submit" onclick="cheackblock()">提交</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
