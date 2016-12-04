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
					&& document.form.file.value != ""
					&& $("#stuid").val() != "")
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
					$('#qqms').html("qq信息已存在数据库或未审核列表");
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

	function cheakfile() {
		var fileInput = $('#file')[0];
		var byteSize  = fileInput.files[0].size;
		var filename=fileInput.files[0].name;
		var file = $("#file")
		$('#filems').html("");
		if(!/.(jpg|jpeg|png)$/.test(filename)){   
			$('#filems').html("图片格式出错！格式必须为.jpg .jpeg .png"); 
			file.after(file.clone().val(""));
			file.remove(); 
			$('#submit').attr("disabled", "true");
			}
		else if (byteSize > 1024*2048) {
				$('#filems').html("图片大小必须小于2M！");
				file.after(file.clone().val(""));
				file.remove();
				$('#submit').attr("disabled", "true");
			}
			else cheackfileblock();
	}
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
								<label for="stuid">学号*</label><input class="form-control"
									id="stuid" type="text" name="stuid"
									onblur="cheackblock(this.value)" />
							</div>

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
								<textarea name="note" id="note"
									style="width: 100%; height: 100%" maxlength=200 draggable=false
									wrap="physical"></textarea>
							</div>
							<div class="form-group">
								<label for="class_">上传截图*(图片格式：.jpg .jpeg .png ， 大小小于2M)</label> <input type="file"
									name="file" id="file" onchange="cheakfile()">
							</div>
							<div>
								<label id="filems" style="color:red"></label>
							</div>
							<button type="submit" disabled="disabled" class="btn btn-default"
								id="submit">提交</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
