<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <!-- 使用标签判断用户是否登入(判断用户是否在session为空)，如果没有登录则跳转到login.jsp(标签重定向)，并且提示请登入 --> 
    <!-- 使用标签判断用户是否登入(判断用户是否在session为空)，如果没有登录则跳转到login.jsp(标签重定向)，并且提示请登入 --> 
    <c:if test="${empty sessionScope.users}">
	<c:redirect url="login.jsp">
		<c:param name="info" value="nologin"></c:param>
	</c:redirect>
</c:if>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8"/>
		<title>校园闲置物品置售平台--注册界面</title>
		<style>
		    @import url("css/register.css");	
		</style>
		<script src="js/register.js"></script>
			<!--导入第三方日期插件-->
		<script language="javascript" type="text/javascript" src="js/tools/My97DatePicker/WdatePicker.js"></script>
	</head>
	<body>
		<div class="mainDiv"><!--mainDiv块------------------------------------------------开始-->
			<div class="contentDiv">
				<!--contentDiv块-->
				<div class="registerTxt">
				<form action="RegisterServlet" method="post"><!-- 获取页面数据 -->
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span class="spanTxt">注册</span>
				<br />
				<span style="color: red;" id="infoSpan">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	
				<c:if test="${param.info=='unok'}">
				确认密码不一致，重新注册	
				</c:if>
				<br /><br />
				</span>
			    <input type="text" placeholder="注册用户名" name="username" id="username" class="inputTxt">
				<br /><br />
				<input type="password" placeholder="注册密码" name="userpwd" id="userpwd" class="inputTxt">
				<br /><br />
				<input type="password" placeholder="确认密码" name="Reuserpwd" id="Reuserpwd" class="inputTxt">
				<br /><br />
				性别：&nbsp;&nbsp;&nbsp;
				男<input type="radio" name="querySex"  value="0">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				女<input type="radio" name="querySex" value="1">
				<br /><br />
				<!-- <input type="date" id="birthday" name="birthday"> -->
				<input type="text" name="birthday" placeholder="生日" id="birthday" class="inputTxt" onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd HH:mm:ss'})">
				<font color=red>&lt;- 点我弹出日期控件</font>
				<br /><br />	
				<button class="buttonStyle" type="submit">
					注册
				</button>
				</form>
				<br /><br />
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="login.jsp">注册好了，去登入</a>
				</div>
				</div>
		</div><!--mainDiv块---------------------------------------------------------------结束-->
	</body>
</html>