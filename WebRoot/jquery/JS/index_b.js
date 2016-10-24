function app(x)
{
x.style.display="block";
}
function diap(x)
{
x.style.display="none";
}
function nologin(){
	alert("请先登录！");
}

function clicklogin(x)
{
	if(x.style.display=="none")
	x.style.display="block";
	else x.style.display="none";
}

function clicklogin1(x)
{
	x.innerHTML="普通客户";
	document.getElementById("chose").value = "普通客户";
}

function clicklogin2(x)
{
	x.innerHTML="普通公司";
	document.getElementById("chose").value ="普通公司";
}

function clicklogin3(x)
{
	x.innerHTML="管理员";
	document.getElementById("chose").value = "管理员";
}

function userfocus(x)
{if(document.getElementById('USERID').value=='')
x.style.display="none";
}
function userblur(x)
{if(document.getElementById('USERID').value=='')
x.style.display="block";
}

function pswfocus(x)
{if(document.getElementById('LOGPASS').value=='')
x.style.display="none";
}
function pswblur(x)
{if(document.getElementById('LOGPASS').value=='')
x.style.display="block";
}

function ccb_lif_tab()
{
	document.getElementById('ccb_life').style.background="#1693f1";
	document.getElementById('ccb_life').style.color="#fff";
	document.getElementById('ccb_phone').style.background="#fff";
	document.getElementById('ccb_phone').style.color="#000";
	document.getElementById('ccb_life_div').style.display="block";
	document.getElementById('ccb_phone_div').style.display="none";
}

function ccb_phone_tab()
{
	document.getElementById('ccb_phone').style.background="#1693f1";
	document.getElementById('ccb_phone').style.color="#fff";
	document.getElementById('ccb_life').style.background="#fff";
	document.getElementById('ccb_life').style.color="#000";
	document.getElementById('ccb_life_div').style.display="none";
	document.getElementById('ccb_phone_div').style.display="block";
}



function useridnonull()
{
	if(document.getElementById('USERID').value=="")
		{alert("用户名不能为空！");
	return false;}
	else if(document.getElementById('LOGPASS').value=="")
		{alert("密码不能为空！");
	return false;}
	else return ture;
	
}

