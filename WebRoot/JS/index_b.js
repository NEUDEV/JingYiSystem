//function app(x)
//{
//x.style.display="block";
//}
//function diap(x)
//{
//x.style.display="none";
//}
//function nologin(){
//	alert("请先登录！");
//}

function clicklogin(x)
{
	if(x.style.display=="none")
	x.style.display="block";
	else x.style.display="none";
}

function clicklogin1(x)
{
	x.innerHTML="学员UID";
	document.getElementById("chose").value = "学员UID";
}

function clicklogin2(x)
{
	x.innerHTML="用户名";
	document.getElementById("chose").value ="用户名";
}

function clicklogin3(x)
{
	x.innerHTML="真实姓名";
	document.getElementById("chose").value = "真实姓名";
}

function clicklogin4(x)
{
	x.innerHTML="手机号";
	document.getElementById("chose").value = "手机号";
}

function clicklogin5(x)
{
	x.innerHTML="QQ";
	document.getElementById("chose").value = "QQ";
}

function clicklogin6(x)
{
	x.innerHTML="邮箱";
	document.getElementById("chose").value = "邮箱";
}

//function userfocus(x)
//{if(document.getElementById('USERID').value=='')
//x.style.display="none";
//}
//function userblur(x)
//{if(document.getElementById('USERID').value=='')
//x.style.display="block";
//}
//
//function pswfocus(x)
//{if(document.getElementById('LOGPASS').value=='')
//x.style.display="none";
//}
//function pswblur(x)
//{if(document.getElementById('LOGPASS').value=='')
//x.style.display="block";
//}
//
//function ccb_lif_tab()
//{
//	document.getElementById('ccb_life').style.background="#1693f1";
//	document.getElementById('ccb_life').style.color="#fff";
//	document.getElementById('ccb_phone').style.background="#fff";
//	document.getElementById('ccb_phone').style.color="#000";
//	document.getElementById('ccb_life_div').style.display="block";
//	document.getElementById('ccb_phone_div').style.display="none";
//}
//
//function ccb_phone_tab()
//{
//	document.getElementById('ccb_phone').style.background="#1693f1";
//	document.getElementById('ccb_phone').style.color="#fff";
//	document.getElementById('ccb_life').style.background="#fff";
//	document.getElementById('ccb_life').style.color="#000";
//	document.getElementById('ccb_life_div').style.display="none";
//	document.getElementById('ccb_phone_div').style.display="block";
//}
//
//
//
//function useridnonull()
//{
//	if(document.getElementById('USERID').value=="")
//		{alert("用户名不能为空！");
//	return false;}
//	else if(document.getElementById('LOGPASS').value=="")
//		{alert("密码不能为空！");
//	return false;}
//	else return ture;
//	
//}

