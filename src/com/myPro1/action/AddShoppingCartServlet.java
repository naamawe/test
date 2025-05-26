package com.myPro1.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myPro1.service.CommodityService;
import com.myPro1.service.ShoppingCartService;
import com.myPro2.bean.ShoppingCart;
import com.myPro2.bean.User;


@WebServlet("/AddShoppingCartServlet")
public class AddShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ShoppingCartService shoppingCartService=new ShoppingCartService();  
  
    public AddShoppingCartServlet() {
        super();
    }


	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//添加购物车服务器
		String userIdString=request.getParameter("userId");
		String commodityIdString=request.getParameter("commodityId");
		String isSold=request.getParameter("isSold");
		String info;
		User users=(User)request.getSession().getAttribute("users");
		System.out.println(userIdString+" "+commodityIdString+" "+isSold+" "+users.getId());
		int userId=Integer.valueOf(userIdString);
		int commodityId=Integer.valueOf(commodityIdString);
		ShoppingCart shoppingCart=new ShoppingCart(users.getId(), commodityId);
		if(userId==users.getId()) {
			info="isOwn";
			//System.out.println(info);
			request.setAttribute("info", info);
			RequestDispatcher dispatcher=request.getRequestDispatcher("toHomepageServlet");
			dispatcher.forward(request, response);
		}
		else if(isSold.equals("是")) {
			info="isSold";
			//System.out.println(info);
			request.setAttribute("info", info);
			RequestDispatcher dispatcher=request.getRequestDispatcher("toHomepageServlet");
			dispatcher.forward(request, response);
		}
		else if(shoppingCartService.getShoppingCartByCommodityIdAndUserId(shoppingCart)!=null) {
			info="isAdded";
			//System.out.println(info);
			request.setAttribute("info", info);
			RequestDispatcher dispatcher=request.getRequestDispatcher("toHomepageServlet");
			dispatcher.forward(request, response);
		}
		else {
		shoppingCartService.AddShoppingCartById(shoppingCart);
		info="success";
		//System.out.println(info);
		request.setAttribute("info", info);
		RequestDispatcher dispatcher=request.getRequestDispatcher("toHomepageServlet");
		dispatcher.forward(request, response);
		}
	}

}
