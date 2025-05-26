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
		<meta charset="utf-8">
		<!--确保网页能够正确地适应各种移动设备的屏幕尺寸，并且以正确的缩放比例显示内容-->
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>悠悠平台首页</title>
		<style>
			@import url("css/homepage.css");
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
		<div class="homeMainDiv">
			<!--顶层-->
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
					<br />
					<br />
					<font style="color: #999; font-size: 35px;">
					<!--${param }:取url的变量对象  -->
					<!--从LoginSevlet的url传递来的值进行非法用户判断显示非法用户信息  -->
					<c:if test="${requestScope.info=='isOwn'}">
					本人商品，无法添加
					</c:if>
					<!--从RegUserSevlet的url传递来  -->
					<c:if test="${requestScope.info=='isSold'}">
					已被卖出，无法添加
					</c:if>
					<c:if test="${requestScope.info=='isAdded'}">
					已被添加过，无法添加
					</c:if>
					<c:if test="${requestScope.info=='success'}">
					添加成功
					</c:if>
				</font>
				</div>
			</div>


			<!--中间内容部分-->
			<div class="homeContentDiv">
					
				<div class="exploration">
					<div class="indexQueryDiv">
					<form action="enquiryByConditionOfCommodityServlet" method="post">
						请选择查询条件：
						商品ID<input type="radio" name="queryTjc" value="1" checked />
						商品种类<input type="radio" name="queryTjc" value="2"/>
						商品名称<input type="radio" name="queryTjc" value="3"/>
						未被购买<input type="radio" name="queryTjc" value="4"/>
					</div>
					&nbsp;
					<input type="text" class="homeCin" name="queryTxtc" id="queryTxtc"placeholder="请输入您要搜索的商品" />
					<button type="submit" class="click1">
						<font style="color: white;font-weight: bold;">搜索</font>
					</button>
				</form>
				<br />
					<button class="click1"><a href="toHomepageServlet"><font style="color: white;font-weight: bold;font-size:15px">重置筛选</font></a></button>
				</div>
				<div class="exDiv">
					<!--表格，列表显示数据-->
					<table class="indexTable">
					     <c:forEach var="rowIndex" begin="0" end="1">
					            <tr>
					                <c:forEach var="colIndex" begin="0" end="3">
					                    <c:if test="${rowIndex * 4 + colIndex < requestScope.commoditiesList.size()}">
					                        <td>
					                          <img src="img/iphone15.png" width=220px height=220px /><br />
					                            <c:set var="index" value="${rowIndex * 4 + colIndex}" />
					                            主人ID:<c:out value="${requestScope.commoditiesList.get(index).getUserId()}" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					                            商品ID:<c:out value="${requestScope.commoditiesList.get(index).getCommodityId()}" /><br />
					                            商品类别:<c:out value="${requestScope.commoditiesList.get(index).getType()}" /><br/>
					                            商品名:<c:out value="${requestScope.commoditiesList.get(index).getName()}" /><br />
					                            商品售价:<c:out value="${requestScope.commoditiesList.get(index).getPrice()}" /><br />
					                            上架日期:<fmt:formatDate value="${requestScope.commoditiesList.get(index).getDate()}" pattern="yyyy-MM-dd HH:mm:ss" /><br />
					                            是否已卖:<c:out value="${requestScope.commoditiesList.get(index).getIsSold()}" />
					                            <button class="clickBuy">
					                            <a href="purchase.jsp?userId=${requestScope.commoditiesList.get(index).getUserId()}&commodityId=${requestScope.commoditiesList.get(index).getCommodityId()}&price=${requestScope.commoditiesList.get(index).getPrice()}&isSold=${requestScope.commoditiesList.get(index).getIsSold()}">
					                           <font style="color: white;font-weight: bold;">购买</font>
					                            </a>
					                            </button>
					                            <button class="clickBuy">
					                            <a href="AddShoppingCartServlet?userId=${requestScope.commoditiesList.get(index).getUserId()}&commodityId=${requestScope.commoditiesList.get(index).getCommodityId()}&isSold=${requestScope.commoditiesList.get(index).getIsSold()}">
					                            <font style="color: white;font-weight: bold;">购物车</font>
					                            </a>
					                            </button>
					                        </td>
					                    </c:if>
					                </c:forEach>
					            </tr>
					        </c:forEach>
					        <tr>
					        <c:if test="${param.info=='unFound'}">
								<td>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<font style="font-size:35px;color: dimgray;">亲,未查询到想要的物品,请重新查询....</font>
								</td>
							</c:if>
							</tr>
					</table>
				</div>
				</div>
				<div class="indexPageNumberDiv">
						   <a href="PageProcessOfCommoditiesServlet?page1=1">首页</a>
							--
							<a href="PageProcessOfCommoditiesServlet?page1=${requestScope.currentPage}&type1=before">上一页</a>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="PageProcessOfCommoditiesServlet?page1=${requestScope.currentPage}&type1=next">下一页</a>
							--
							<a href="PageProcessOfCommoditiesServlet?page1=${requestScope.totalPages}">末页</a>
					&nbsp;&nbsp;&nbsp;&nbsp;
					一共--<font style="color: royalblue;;">${requestScope.totalPages}</font>--页，
					共--<font style="color: royalblue;;">${requestScope.totalRecords }</font>--条数据
					现在是第--<font style="color: royalblue;;">${requestScope.currentPage}</font>--页
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