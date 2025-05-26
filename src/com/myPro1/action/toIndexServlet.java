package com.myPro1.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myPro1.service.UsersService;
import com.myPro2.bean.User;

@WebServlet("/toIndexServlet")
public class toIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public toIndexServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//得到所有数据到list中
		UsersService usersService=new UsersService();
		List<User> usersList=new ArrayList<User>();
		//调用业务逻辑层模拟数据
		HttpSession session = request.getSession();
		session.removeAttribute("queryTypeInt");
		session.removeAttribute("queryTxt");
		session.removeAttribute("birthday");
		usersList=usersService.getUsers(0,8);
		int totalRecords=usersService.getNumOfUsers();
		int totalPages= (int) Math.ceil((double) totalRecords / 8);
		request.setAttribute("usersList", usersList);
		request.setAttribute("currentPage", 1);
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("totalRecords", totalRecords);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
