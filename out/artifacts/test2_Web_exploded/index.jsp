<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!--导入jstl和c标签-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <!--导入jstl和c标签-->
    <!--导入jsp  -->
    
    <!-- 使用标签判断用户是否登入(判断用户是否在session为空)，如果没有登录则跳转到login.jsp(标签重定向)，并且提示请登入 --> 
    <c:if test="${empty sessionScope.users}">
	<c:redirect url="login.jsp">
		<c:param name="info" value="nologin"></c:param>
	</c:redirect>
</c:if>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>账号管理</title>
		<style>
			@import url("css/index.css");
		</style>
				<style>
			a {
				text-decoration: none
			}

			a:hover {
				text-decoration: underline
			}
		</style>
		<script src="js/index.js"></script>
		<script language="javascript" type="text/javascript" src="js/tools/My97DatePicker/WdatePicker.js"></script>
	</head>
	<body>
	<%
	//写jsp代码，但是一般不这样写(要遵循mvc思想)
	//用jstl(jsp标准标签库)来代替jsp的操作,el,c标签
	//要把标签库俩个jar包jst1.jar,standard.jar复制到项目的webcontent\wen-inf\lib目录中
	//在使用标签库的页面导入标签库
	%>
		<div class="mainDiv"><!--main块                                             开始-->
			<div class="topDiv">
				<div class="topDivTxt">
					<font style="font-size: 40px;">悠&nbsp;&nbsp;悠&nbsp;&nbsp;平&nbsp;&nbsp;台</font>
					<br />
					<br />
					<font style="color: white; font-size: 25px;">在线传递优品</font>
				</div>
				
				<div class="coLeDiv">
					<!--显示登入用户以及退出选项-->
					登入账户名:
					<!--  <input type="text" name="queryDataTxt" id="queryDataTxt" style="width: 130px;border-radius: 5px;">  -->
					<!-- 使用el表达式取session中users对象中的username值奥德彪 -->
					${sessionScope.users.username}
					&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="OutLoginServlet">
						<font style="color: dimgray;">退出</font>
					</a>
				</div>
			</div>
			<div class="contentDiv">

				<div class="coReDiv">
						<!--显示查询条件-->
						<div class="indexQueryDiv">
						<form action="enquiryByConditionOfIndexServlet" method="post">
							请选择查询条件：
							ID<input type="radio" name="queryTj" value="1" checked />&nbsp;&nbsp;&nbsp;
							用户名<input type="radio" name="queryTj" value="2">&nbsp;&nbsp;&nbsp;
							性别<input type="radio" name="queryTj" value="3">
							&nbsp;&nbsp;&nbsp;
						</div>
							<input type="text" name="queryTxt" id="queryTxt"placeholder="请输入查询条件"class="homeCin">
							<button type="submit" name="confirmButton"class="click1">
								查询
							</button>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<font style="color: gray;font-size: 20px;" >生日</font><input type="radio" name="queryTj" value="4">
							<input type="text" name="birthday" id="birthday" class="Wdate"
								onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd'})">
							<button type="submit" name="confirmButton" class="click1">
								查询
							</button>
						</form>
							&nbsp;&nbsp;&nbsp;&nbsp;
						<form action="getUsersServlet">
							<button type="submit" name="resetButton"class="click1">
							<font style="font-size: 15px;">重置筛选</font>
							</button>
						</form>
						<br />
				</div>
						<!--用表格显示待售物品-->
						<div class="conTaStyle">
							<table class="tableStyle" border="1" width="90%">
								<tr class="trClass">
									<td colspan="5" align="center"class="back">
										<font style="color: white;font-size: 40px;font-weight: 1000;font-family: YouYuan;">用&nbsp;&nbsp;
										户&nbsp;&nbsp;信&nbsp;&nbsp;息&nbsp;&nbsp;表
										</font>
									</td>
								</tr>
								<tr class="trClass">
									<td class="obTxtSt" align="center">用户名</td>
									<td class="obTxtSt" align="center">ID</td>
									<td class="obTxtSt" align="center">性别</td>
									<td class="obTxtSt" align="center">生日</td>
									<td class="obTxtSt" align="center" width="120px">操作</td>
								</tr>
								<c:forEach var="item" items="${requestScope.usersList}">
									<tr class="trClass">
										<td align="center">${item.username}</td>
										<td align="center">${item.id}</td>
										<td align="center">
											<c:if test="${item.sex==0}">
												男
											</c:if>
											<c:if test="${item.sex==1}">
												女
											</c:if>
										</td>
										<td align="center">
											<fmt:formatDate value="${item.birthday}" pattern="yyyy-MM-dd HH:mm:ss" />
										</td>
										<td align="center">
											<button type="button" class="op">
												<a href="EditGetUserByIDServlet?id=${item.id}">
												<font style="color: white;font-weight: bold;">修改</font>
												</a>
											</button>
											<button type="button" class="op">
												<a href="DelUsersByIdServlet?id=${item.id}">
													<font style="color: white;font-weight: bold;">删除</font>
													</a>
											</button>
										</td>
									</tr>
								</c:forEach>
							</table>
							<c:if test="${param.info=='unFound'}">
								<br /><br />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<font style="font-size:35px;color: dimgray;">亲,未查询到想要的物品,请重新查询....</font>
							</c:if>
						</div>
						<div class="indexPageNumberDiv">
							<a href="PageProcessOfUsersServlet?page=1">首页</a>
							--
							<a href="PageProcessOfUsersServlet?page=${requestScope.currentPage}&type=before">上一页</a>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="PageProcessOfUsersServlet?page=${requestScope.currentPage}&type=next">下一页</a>
							--
							<a href="PageProcessOfUsersServlet?page=${requestScope.totalPages}">末页</a>
							&nbsp;&nbsp;&nbsp;&nbsp;
							一共--<font style="color: royalblue; font-weight: bold;">${requestScope.totalPages}</font>--页，
							共--<font style="color: royalblue; font-weight: bold;">${requestScope.totalRecords}</font>--数据，
							现在是第--<font style="color: royalblue; font-weight: bold;">${requestScope.currentPage}</font>--页
						</div>
					</div>
			<div class="rootDiv">
				<!--实现各功能按钮-->
				<button class="funButton"  type="button">
					<a href="toHomepageServlet">
					<font style="color: white;font-weight: bold;">首页</font>
					</a>
				</button>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button class="funButton"  type="button">
					<a href="uploadGoods.jsp">
					<font style="color: white;font-weight: bold;">卖闲置</font>
					</a>
				</button>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button class="funButton" type=" button">
					<a href="toIndexServlet">
						<font style="color: white;font-weight: bold;">账号管理</font>
					</a>
				</button>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button class="funButton" type=" button">
					<a href="personalHomepage.jsp">
						<font style="color: white;font-weight: bold;">个人主页</font>
					</a>
				</button>
				&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;
				<button class="funButton" type=" button">
					<a href="toShoppingCartServlet">
						<font style="color: white;font-weight: bold;">购物车</font>
					</a>
				</button>
			</div>
		</div><!--main块                                             结束-->

	</body>
</html>