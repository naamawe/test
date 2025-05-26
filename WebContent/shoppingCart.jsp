<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <!--导入jstl和c标签-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 <!-- 使用标签判断用户是否登入(判断用户是否在session为空)，如果没有登录则跳转到login.jsp(标签重定向)，并且提示请登入 --> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
    <style>
		@import url("css/shoppingCart.css");
	</style>
</head>
<body>
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
				  <div class="title">
						<font style="color: #999; font-size: 35px;">购物车</font>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				  </div>
				  
				  <div class="searchTxt">
				  <form action="SearchByTypeOfShoppingServlet" method="post">
						<input type="text" class="homeCin" name="typeTxt" id="typeTxt"placeholder="请输入商品类别" />
					<button type="submit" class="click1">
						<font style="color: white;font-weight: bold;">搜索</font>
					</button>
					</form>
				</div>
				<button type="submit" class="click1">
					<a href="toShoppingCartServlet">
						<font style="color: white;font-weight: bold;">重置</font>
					</a>
				</button>
				  </div>
						<!--用表格显示待售物品-->
				  <div class="conTaStyle">
						<table class="tableStyle" border="1" width="90%">
						<tr class="trClass">
									<td colspan="6" align="center"class="back">
										<font style="color: white;font-size: 40px;font-weight: 1000;font-family: YouYuan;">
										购&nbsp;&nbsp;物&nbsp;&nbsp;车&nbsp;&nbsp;信&nbsp;&nbsp;息&nbsp;&nbsp;表
										</font>
									</td>
						</tr>
						<tr class="trClass">
									<td class="obTxtSt" align="center">主人ID</td>
									<td class="obTxtSt" align="center">商品ID</td>
									<td class="obTxtSt" align="center">商品名字</td>
									<td class="obTxtSt" align="center">商品类型</td>
									<td class="obTxtSt" align="center">商品价格</td>
									<td class="obTxtSt" align="center">操作</td>
						</tr>
						<c:forEach var="item" items="${requestScope.listCommodities}">
									<tr class="trClass">
										<td align="center">${item.userId}</td>
										<td align="center">${item.commodityId}</td>
										<td align="center">${item.name}</td>
										<td align="center">${item.type}</td>
										<td align="center">${item.price}</td>
										<td align="center">
											<button type="button" class="op">
												<a href="purchase.jsp?userId=${requestScope.listCommodities.get(index).getUserId()}&commodityId=${requestScope.listCommodities.get(index).getCommodityId()}&price=${requestScope.listCommodities.get(index).getPrice()}&isSold=否">
												<font style="color: white;font-weight: bold;">购买</font>
												</a>
											</button>
											<button type="button" class="op">
												<a href="EditShoppingCartServlet?commodityId=${item.commodityId}">
													<font style="color: white;font-weight: bold;">删除</font>
												</a>
											</button>
										</td>
									</tr>
						</c:forEach>
						</table>
				  <div class="shoppingCartTxt">
						<font style="color: #999; font-size: 20px;">商品总价:${requestScope.sumPrice}</font>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<button type="submit" class="clickbottom">
					<a href="DelAllShoppingCartByUserIdServlet">
						<font style="color: white;font-weight: bold;">一建清空</font>
					</a>
					</button>
				  </div>	
				  </div>
				<div class="indexPageNumberDiv">
				           <a href="pageProcessOfShoppingCartServlet?page=1">首页</a>
							--
							<a href="pageProcessOfShoppingCartServlet?page=${requestScope.currentPage}&type=before">上一页</a>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="pageProcessOfShoppingCartServlet?page=${requestScope.currentPage}&type=next">下一页</a>
							--
							<a href="pageProcessOfShoppingCartServlet?page=${requestScope.totalPages}">末页</a>
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
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button class="funButton" type=" button">
					<a href="toShoppingCartServlet">
						<font style="color: white;font-weight: bold;">购物车</font>
					</a>
				</button>
			</div>
	</div>
</body>
</html>