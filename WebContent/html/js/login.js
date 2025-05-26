function checkUserInfo(){
	var username=document.getElementById('username').value;
	var userpwd=document.getElementById('userpwd').value;
	if(username==""||userpwd=="")
	{
		alert('账户或密码为空');
		document.getElementById('infoSpan').innerHTML="输入非法！";
		return ;
	}
}