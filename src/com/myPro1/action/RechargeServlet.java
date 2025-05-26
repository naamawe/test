package com.myPro1.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myPro1.service.UsersService;
import com.myPro2.bean.User;

@WebServlet("/RechargeServlet")
public class RechargeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UsersService usersService=new UsersService();
    public RechargeServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		User users=new User();
		users=(User)session.getAttribute("users");
		String amount=request.getParameter("amount");
		try {
		double amountDouble=Double.parseDouble(amount);
		System.out.println(amountDouble);
		usersService.rechargeUsersById(amountDouble, users.getId());
		session.setAttribute("users", usersService.getUsersById(users.getId()));
		response.sendRedirect("recharge.jsp?info=ok");
		}
		catch(Exception e){
			e.printStackTrace();
			response.sendRedirect("recharge.jsp?info=unok");
		}
	}

}
