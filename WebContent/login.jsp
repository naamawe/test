<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!--导入jstl和c标签-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>校园闲置物品置售平台--登入界面</title>
		<style>
			@import url("css/login.css");
		</style>
		<script src="js/login.js"></script>	
	</head>
	<body>
		<div class="mainDiv"><!--mainDIV块                                     start-->
			<div class="contentDiv">	
			<div>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;
			<span class="spanTxt">
				登录
			</span>
				<br />
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<span style="color: red;" id="infoSpan">
					<!--${param }:取url的变量对象  -->
					<!--从LoginSevlet的url传递来的值进行非法用户判断显示非法用户信息  -->
					<c:if test="${param.info=='no'}">
					非法用户
					</c:if>
					<!--从RegUserSevlet的url传递来  -->
					<c:if test="${param.info=='iok'}">
					注册成功，请登入
					</c:if>
					<c:if test="${param.info=='nologin'}">
					没有登入，请登入
					</c:if>
					<c:if test="${param.info=='outlogin'}">
					你已经退出，请重新登录系统
					</c:if>
					</span>
					<br />
				<form action="LoginServlet" method="post">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="text" class="inputTxt" placeholder="用户名" name="username" id="username" />
				<br /><br />
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="password" class="inputTxt" placeholder="密码" name="userpwd" id="userpwd" />
				<br /><br />
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button class="loginBtn" type="submit" >
				<!-- style="width:180px;height:30px;background-color:aqua;font-size:20px;color:white;" -->
				<!-- onclick="checkUserInfo()" -->
				<!-- <a href="index.html">登录</a> -->
				立即登录
				</button>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</form>
				<font style="color:red;">
				<!-- ${sessionScope.user.username}-->
				</font>
				<br /><br /><br /><br />
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="register.jsp">还没有账号，去注册...</a>
			</div>
			</div>
		</div><!--mainDIV块                                                      end-->
	</body>
</html>
