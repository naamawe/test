package com.myPro1.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myPro1.service.ShoppingCartService;
import com.myPro2.bean.Commodity;
import com.myPro2.bean.User;


@WebServlet("/toShoppingCartServlet")
public class toShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ShoppingCartService shoppingCartService=new ShoppingCartService();   
    public toShoppingCartServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		List<Commodity> listCommodities=new ArrayList<Commodity>();
		List<Commodity> listAllCommodities=new ArrayList<Commodity>();
		User user=(User)request.getSession().getAttribute("users");
		request.getSession().removeAttribute("typeTxt");
		listAllCommodities=shoppingCartService.getShoppingCartByCommodityId(user.getId());
		double sumPrice=0;
		try {
		for(Commodity commodity : listAllCommodities) {
			sumPrice+=commodity.getPrice();
		}
		}catch (Exception e) {
			System.out.println("无购物车记录");
		}
		//System.out.println("商品总价:"+sumPrice);
		int limit=10;
		int offset=0;
		listCommodities=shoppingCartService.getShoppingCartByCommodityId(user.getId(), offset, limit);
		//System.out.println(listCommodities);
		int totalRecords=shoppingCartService.getNumOfshoppingCartByUserId(user.getId());
		int totalPages= (int) Math.ceil((double) totalRecords / 10);
		int currentPage=1;
		request.setAttribute("sumPrice", sumPrice);
		request.setAttribute("totalRecords", totalRecords);
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("listCommodities", listCommodities);
		request.getRequestDispatcher("shoppingCart.jsp").forward(request, response);
	}

}
