package com.myPro1.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.myPro1.service.CommodityService;
import com.myPro1.service.ShoppingCartService;
import com.myPro1.service.UsersService;
import com.myPro2.bean.User;


@WebServlet("/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     CommodityService commodityService=new CommodityService();
     ShoppingCartService shoppingCartService=new ShoppingCartService();
     UsersService usersService=new UsersService();
    public PurchaseServlet() {
        super();
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		User user=new User();
		user=(User)session.getAttribute("users");
		String userIdString=request.getParameter("userId");
		String commodityIdString=request.getParameter("commodityId");
		String priceString=request.getParameter("price");
		String password=request.getParameter("userpwd");
		String isSold=request.getParameter("isSold");
		try {
			//System.out.println(userIdString+" "+commodityIdString+" "+priceString+" "+password+" "+isSold);
		int userId=Integer.parseInt(userIdString);
		int commodityId=Integer.parseInt(commodityIdString);
		double price=Double.parseDouble(priceString);
		if(!user.getUserpwd().equals(password)) {
			response.sendRedirect("purchase.jsp?info=passwordError");
		}
		else if(price>user.getBalance()) {
			response.sendRedirect("purchase.jsp?info=balanceInsufficient");
		}
		else if(isSold.equals("ÊÇ")){
			response.sendRedirect("purchase.jsp?info=beSold");
		}
		else {
			shoppingCartService.delShoppingCartByCommodityId(commodityId);
			commodityService.editCommodityByUserIdandCommodityId(userId, commodityId, user.getId());
			usersService.editUsersPriceById(user.getId(), price);
			usersService.IncreaseUsersPriceById(commodityId, price);
			response.sendRedirect("purchase.jsp?info=success");
		}
		}catch(Exception e){
			e.printStackTrace();
			response.sendRedirect("purchase.jsp?info=unok");
		}
	}

}
