<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!--导入jstl和c标签-->
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
		<title>修改资料</title>
		<!--style代码块 -->
		<style>
			/*导入第三方样式文件*/
			@import url("css/editUser.css");
		</style>
		<style>
			* {
				list-style: none;
				text-decoration: none;
				margin: 0;
				padding: 0;
			}

			header nav {
				width: 130px;
				height: 70px;
				background-color: white;
			}

			header li {
				width: 130px;
				float: right;
				/* 设置文本行高 */
				line-height: 70px;
				background-color: lightgray;
			}

			header a {
				color: white;
				display: block;
				text-align: center;
			}

			header a:hover {
				background-color:darkgrey;
			}

			/* 下拉菜单隐藏 */
			header .top_list {
				display: none;
			}

			/* 下拉菜单显示 */
			header li:hover .top_list {
				display: block;
			}
		</style>
		<script src="js/script.js"></script>
		<!--导入第三方日期插件-->
		<script language="javascript" type="text/javascript" src="js/tools/My97DatePicker/WdatePicker.js"></script>
	</head>
	<body>
			<!--主div（代表body）                  开始-->
		<div class="mainDiv">
			<div class="topDiv">
				&nbsp;&nbsp;&nbsp;
				<img src="img/mei.png" width="120" height="96">
		
				悠&nbsp;悠&nbsp;平&nbsp;台
				
				<img src="img/mei.png" width="120" height="106">
			</div>
			<div class="contentDiv">
				<!-- 中层 -->

				<div class="daohang">
					<header>
						<!--nav 是 HTML5 新增的语义标签，用于定义导航链接的部分-->
						<nav>
							<ul>
								<li><a href="personalHomepage.jsp">
										<font style="color: white; font-size: 20px;font-weight:bold;">返&nbsp;&nbsp;&nbsp;&nbsp;回</font>
									</a> </li>
							</ul>
						</nav>
					</header>
				</div>
				<div class="editTable">
					<form action="EditUserServlet" method="post">
						<table class="indexTable" width="800px" height="480px" >
							<tr>
								<td colspan="3" align="center"width="100px" height="70px">
									<font style="color: dimgrey; font-weight: bold;font-size: 50px;">修&nbsp;改&nbsp;资&nbsp;料</font>
								</td>
							</tr>
							<tr>
								<td width="70px" height="70px">
									<font style="color: gray; font-weight: bold;font-size: 25px;">账户名</font>
								</td>
								<td align="center" width="80px" height="70px">
									<!-- 隐藏域，页面不会显示 -->
									<input type="hidden" name="id" id="id" value="${users.id}">
									<input type="text" name="username" id="username" value="${users.username}"
										class="inputTxt" placeholder="请输入账户名" />
								</td>
							</tr>
							<tr>
								<td width="70px" height="70px">
									<font style="color: gray; font-weight: bold;font-size: 25px;">密码：</font>
								</td>
								<td align="center" width="400px" height="70px">
									<!-- 隐藏域，页面不会显示 -->
									<input type="text" name="userpwd" id="userpwd" value="${users.userpwd}"
										class="inputTxt" placeholder="请输入密码" />
								</td>

							</tr>

							<tr>
								<td width="100px" height="70px">
									<font style="color: gray; font-weight: bold;font-size: 25px;">性别：</font>
								</td>
								<td   width="100px" height="70px">
									<c:if test="${users.sex==0}">
									    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										男<input type="radio" name="sex" id="sex0" value="0" checked />
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										女<input type="radio" name="sex" id="sex1" value="1" />
									</c:if>
									<c:if test="${users.sex==1}">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										男<input type="radio" name="sex" id="sex0" value="0" />
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										女<input type="radio" name="sex" id="sex1" value="1" checked />
									</c:if>
								</td>
							</tr>
							
						<tr>
							<td>
							<font style="color: gray; font-weight: bold;font-size: 25px;">生日：</font>
							</td>
							<td>
								&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="text" name="birthday" id="birthday" class="Wdate"  
								onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="<fmt:formatDate value="${users.birthday}" pattern="yyyy-MM-dd HH:mm:ss"/>" />
								<font style="color:royalblue;font-size:15px">&lt;- 点我弹出日期控件</font>
							</td>
						</tr>
					<tr>
								<!--跨三列-->
								<td colspan="3" align="center"height="50px">
									<br><br>
									<button type="submit" class="clickOp">
										修改
									</button>
									&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="reset" value="重置" class="clickOp" />
								</td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>
				