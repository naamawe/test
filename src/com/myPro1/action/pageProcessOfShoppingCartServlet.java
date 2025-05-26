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

@WebServlet("/pageProcessOfShoppingCartServlet")
public class pageProcessOfShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ShoppingCartService shoppingCartService=new ShoppingCartService();   
    public pageProcessOfShoppingCartServlet() {
        super();
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int limit=10;
		int offset=0;
		List<Commodity> listCommodities=new ArrayList<Commodity>();
		String page=(String)request.getParameter("page");
		String type=(String)request.getParameter("type");
		User user=new User();
		user=(User)request.getSession().getAttribute("users");
		List<Commodity> listAllCommodities=new ArrayList<Commodity>();
		listAllCommodities=shoppingCartService.getShoppingCartByCommodityId(user.getId());
		double sumPrice=0;
		try {
		for(Commodity commodity : listAllCommodities) {
			sumPrice+=commodity.getPrice();
		}
		}catch (Exception e) {
			System.out.println("无购物车记录");
		}
		int pageInt=Integer.valueOf(page);
		String typeTxt=(String)request.getSession().getAttribute("typeTxt");
		if(typeTxt!=null) {
			System.out.println("进入分页分类");
			request.setAttribute("page", page);
			request.setAttribute("type", type);
			request.getRequestDispatcher("PageProcessAndCateOfShoppingCartServlet").forward(request, response);
		}else {
		int totalRecords=shoppingCartService.getNumOfshoppingCartByUserId(user.getId());
		int totalPages= (int) Math.ceil((double) totalRecords / limit);
		if(type!=null) {
		    if(type.equals("next")) {
				pageInt++;
			}
			else if(type.equals("before")) {
				pageInt--;
			}
			else {
				
			}
		    if(pageInt==0) {
				pageInt=1;
			}
			else if(pageInt>totalPages) {
				pageInt=totalPages;
			}
			else {
				
			}
		}
		offset=(pageInt-1)*10;
		listCommodities=shoppingCartService.getShoppingCartByCommodityId(user.getId(), offset, limit);
		request.setAttribute("sumPrice", sumPrice);
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("totalRecords", totalRecords);
		request.setAttribute("listCommodities", listCommodities);
		request.setAttribute("currentPage",pageInt);
		request.getRequestDispatcher("shoppingCart.jsp").forward(request, response);
	}
	}
	

}
