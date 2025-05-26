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
    <!--导入jstl和c标签-->
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>个人主页</title>
	<style>
			@import url("css/personalHomepage.css");
	</style>
	<script>
    function openRechargePage(url) {
    // 打开一个新窗口或者弹出框来显示充值页面
    window.open('recharge.jsp', 'Recharge', 'width=400,height=300');
}
</script>
<style>
		        *{
		            list-style: none;
		            text-decoration:none;
		            margin: 0;
		            padding: 0;
		        }
		       header nav{
				   position:absolute;
				   z-index:999;
		            width: 1390px;
		            height: 60px;
		            background-color: slategrey;
		        }
		        header li{
					
		            width: 120px;
		            float: right;
		            line-height: 50px;
		            background-color:  slategrey;
		        }
		        header a{
		            color: white;
		            display: block;
		            text-align: center;
					font-size: 25px;
		        }
		        header a:hover{
		            background-color:cadetblue;
		        }
		        header .top_list{
		            display: none;
		        }
		        header li:hover .top_list{
		            display: block;
		        }
		    </style>
			<style>
				a {	text-decoration: none}
				a:hover {text-decoration: underline}
			</style>
	</head>
	<body>
	<div class="mainDiv">
	<div class="topDiv">
				<div class="topDivTxt">
				<font style="font-size: 40px;">悠&nbsp;&nbsp;悠&nbsp;&nbsp;平&nbsp;&nbsp;台</font>
				<br />
				<font style="color: white; font-size: 25px;">在线传递优品</font>
				</div>	
				
				<div class="coLeDiv">
					<a href="OutLoginServlet">
						<font style="color: slategray;font-size: 20px;">退出</font>
					</a>
				</div>
			</div>
			
				<div class="information">
					<header>
					<nav>
					<ul>
					    <li><a href="#">设置</a>
					        <ul class="top_list">
					            <li><a href="EditGetUserByIDServlet?id=${sessionScope.users.id}&ed=1">修改资料</a></li>
					        </ul>
					    </li>
					    <li><a href="#">交易</a>
					        <ul class="top_list">
					            <li><button onclick="openRechargePage()" class="chongzhi">充值</button></li>
					        </ul>
					    </li>
					</ul>
					</nav>
					    </header>
				</div>			
	<div class="contentDiv">
					<div class="contentLeftDiv">
					<div class="leftInfo"></div>
					<div class="leftInfoTxt">
						账号：${sessionScope.users.id}
						<br /><br />
						用户名：${sessionScope.users.username}
						<br /><br />
							性别:
	<c:if test="${sessionScope.users.sex==0}">
	男
	</c:if>
	<c:if test="${sessionScope.users.sex==1}">
	女
	</c:if> 
	<br /><br />
						生日:<fmt:formatDate value="${sessionScope.users.birthday}" pattern="yyyy-MM-dd" />
						<br /><br />
						￥余额￥:${sessionScope.users.balance}元
					</div>
				</div>
				<div class="contentRightDiv">
					<!-- 中层内部右边的div -->
				</div>
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