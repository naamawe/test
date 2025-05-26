package com.myPro1.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myPro1.service.ShoppingCartService;
import com.myPro2.bean.User;

@WebServlet("/DelAllShoppingCartByUserIdServlet")
public class DelAllShoppingCartByUserIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ShoppingCartService shoppingCartService=new ShoppingCartService();      
    public DelAllShoppingCartByUserIdServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		User user=(User)request.getSession().getAttribute("users");
		System.out.println("±»É¾³ý¼ÇÂ¼Êý:"+shoppingCartService.delShoppingCartByUserId(user.getId()));
		request.getRequestDispatcher("toShoppingCartServlet").forward(request, response);
	}

}
