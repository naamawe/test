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

/**
 * Servlet implementation class SearchByTypeOfShoppingServlet
 */
@WebServlet("/SearchByTypeOfShoppingServlet")
public class SearchByTypeOfShoppingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ShoppingCartService shoppingCartService=new ShoppingCartService();   
    public SearchByTypeOfShoppingServlet() {
        super();
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		List<Commodity> listCommodities=new ArrayList<Commodity>();
		User user=new User();
		user=(User)request.getSession().getAttribute("users");
		String typeTxt=request.getParameter("typeTxt");
		request.getSession().setAttribute("typeTxt", typeTxt);
		int limit=10;
		int offset=0;
		listCommodities=shoppingCartService.getShoppingCartByType(user.getId(), typeTxt, offset, limit);
		int totalRecords=shoppingCartService.getNumOfshoppingCartByType(user.getId(), typeTxt);
		int totalPages= (int) Math.ceil((double) totalRecords / 10);
		int currentPage=1;
		request.setAttribute("totalRecords", totalRecords);
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("listCommodities", listCommodities);
		request.getRequestDispatcher("shoppingCart.jsp").forward(request, response);
	}

}
