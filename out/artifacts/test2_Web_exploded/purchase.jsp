<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<title>确认购买页面</title>
		<style>
			a {
				text-decoration: none
			}

			a:hover {
				text-decoration: underline
			}
		</style>
		<style >
		@import url("css/purchase.css");
		</style>
</head>
<body>
<div class="homeMainDiv">
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
<div class="identify">
<font style="font-size: 40px;">悠&nbsp;&nbsp;&nbsp;悠&nbsp;&nbsp;&nbsp;收&nbsp;&nbsp;&nbsp;银&nbsp;&nbsp;&nbsp;台</font>
</div>
<div class="homeContentDiv">
<%
    String userId = request.getParameter("userId");
    String commodityId = request.getParameter("commodityId");
    String price = request.getParameter("price");
    String isSold = request.getParameter("isSold");
%>
<div class="purchase1">
    <form action="PurchaseServlet"  method="post">
        <!-- 具体的充值表单内容 -->
        <!-- 例如： -->
        <label>购买需进行身份验证，</label>
        <input type="hidden" name="userId" value="<%= userId %>">
    <input type="hidden" name="commodityId" value="<%= commodityId %>">
    <input type="hidden" name="price" value="<%= price %>">
    <input type="hidden" name="isSold" value="<%= isSold %>">
        请输入密码:<input type="password" name="userpwd" id="userpwd" class="homeCin">
        <button type="submit" class="clickOP">确认</button>
    </form>
    <button class="clickOP"><a href="toHomepageServlet"><font style="color:white;">返回</font></a> </button>
    <c:if test="${param.info=='unok'}">
			输入格式等其他错误，充值失败
   </c:if>
   <c:if test="${param.info=='passwordError'}">
			密码错误
   </c:if>
   <c:if test="${param.info=='balanceInsufficient'}">
			余额不足，请去往个人主页充值
   </c:if>
    <c:if test="${param.info=='beSold'}">
			商品未上架
   </c:if>
   <c:if test="${param.info=='success'}">
			购买成功！
   </c:if>
   </div>
  </div>
  
			<!--底层-->
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

			</div>
   </div>
</body>
</html>