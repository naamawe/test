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
    <title>充值页面</title>
</head>
<body>
    <h2>请在此处输入您的充值信息：</h2>
    <form action="RechargeServlet" method="post">
        <!-- 具体的充值表单内容 -->
        <!-- 例如： -->
        <label>充值金额：</label>
        <input type="text" name="amount" id="amount">
        <button type="submit">确认充值</button>
    </form>
    <c:if test="${param.info=='unok'}">
			充值失败！
   </c:if>
   <c:if test="${param.info=='ok'}">
			充值成功！
   </c:if>
</body>
</html>