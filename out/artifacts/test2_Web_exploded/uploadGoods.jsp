<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 <!-- 使用标签判断用户是否登入(判断用户是否在session为空)，如果没有登录则跳转到login.jsp(标签重定向)，并且提示请登入 --> 
    <c:if test="${empty sessionScope.users}">
	<c:redirect url="login.jsp">
		<c:param name="info" value="nologin"></c:param>
	</c:redirect>
</c:if>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>卖闲置</title>
		<style>
		@import url("css/uploadGood.css");
		</style>
				<style>
			a {
				text-decoration: none
			}

			a:hover {
				text-decoration: underline
			}
					</style>
	</head>
<body>
	<div class="mainDiv">
		<div class="homeTopDiv">
				<div class="topDivTxt">
				<font style="font-size: 40px;">悠&nbsp;&nbsp;悠&nbsp;&nbsp;平&nbsp;&nbsp;台</font>
					<br />
					<br />
				<font style="color: white; font-size: 25px;">在线传递优品</font>
				</div>	
				<div class="coLeDiv">
					<!--显示登入用户以及退出选项-->
				     账户名:${sessionScope.users.username}
					<!-- 使用el表达式取session中users对象中的username值奥德彪 -->&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="OutLoginServlet"><font style="color: slategray;">退出</font></a>
				</div>
			</div>
	
		<div class="contentDiv">
			<c:if test="${param.info=='ok'}">
			上传成功
			</c:if>
			<c:if test="${param.info=='unok'}">
			上传失败
			</c:if>
			<c:if test="${param.info=='formateEror'}">
			上传成功
			</c:if>
			<h1>
			<form action="uploadGooodServlet" method="post">
				<table class="indexTable">
					<tr>
						<td align="center" width="80px" height="70px">
						<font style="color: dimgrey; bold;font-size: 50px;">上&nbsp;传&nbsp;您&nbsp;的&nbsp;物&nbsp;品</font>
						</td>
					</tr>
					<tr>
						<td align="center" width="80px" height="70px">
						<font style="color: gray;font-size:25px">商&nbsp;品&nbsp;名</font>
									&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="text" class="inputTxt" placeholder="请输入" name="itemname" id="itemname" />
						</td>
					</tr>
					<tr>
					<td align="center" width="80px" height="70px">
					<font style="color: gray;font-size:25px">商&nbsp;品&nbsp;类&nbsp;型</font>
									&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;
						<input type="text" class="inputTxt" placeholder="请输入" name="itemtype" id="itemtype" />
						</td>
					</tr>
					<tr>
					<td align="center" width="80px" height="70px">
						<font style="color: gray;font-size:25px">价&nbsp;&nbsp;格</font>
									&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="text" class="inputTxt" placeholder="请输入" name="price" id="price" />
						</td>
					</tr>
					<tr>
					<td align="center" width="80px" height="70px">
					<button tyep="submit" class="clickButtom">
					<font style="color: white;font-weight: bold;">上&nbsp;&nbsp;传</font>
					</button>	
					</td>
					</tr>
				</table>
			</form>
			</h1>
			</div>
			
			<div class="footDiv">
						<button type="button" class="clickButtom">
					<a href="toHomepageServlet">
						<font style="color: white;font-weight: bold;">首页</font>
					</a>
				</button>
				&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="button" class="clickButtom">
				<a href="uploadGoods.jsp">
					<font style="color: white;font-weight: bold;">卖闲置</font>
				</a>
				</button>
				&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="button" class="clickButtom">
					<a href="toIndexServlet">
						<font style="color: white;font-weight: bold;">账号管理</font>
					</a>
				</button>
				&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="button" class="clickButtom">
					<a href="personalHomepage.jsp">
						<font style="color: white;font-weight: bold;">个人主页</font>
					</a>
				</button>
				&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="button" class="clickButtom">
					<a href="toShoppingCartServlet">
						<font style="color: white;font-weight: bold;">购物车</font>
					</a>
				</button>
			</div>
	</div>
</body>
</html>