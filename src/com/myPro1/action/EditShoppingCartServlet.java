package com.myPro1.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myPro1.service.ShoppingCartService;
import com.myPro1.service.UsersService;
import com.myPro2.bean.User;

/**
 * Servlet implementation class EditShoppingCartServlet
 */
@WebServlet("/EditShoppingCartServlet")
public class EditShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ShoppingCartService shoppingCartService=new ShoppingCartService();   
    public EditShoppingCartServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String commodityString=(String) request.getParameter("commodityId");
		int commodityId=Integer.parseInt(commodityString);
		User user=(User)request.getSession().getAttribute("users");
		System.out.println(commodityId+" "+user.getId());
		System.out.println("受影响数目:"+shoppingCartService.delShoppingCartByCommodityId(commodityId));
		response.sendRedirect("toShoppingCartServlet");
	}

}
