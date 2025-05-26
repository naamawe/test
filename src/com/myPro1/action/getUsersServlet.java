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

@WebServlet("/getUsersServlet")
public class getUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsersService usersService=new UsersService();    
    public getUsersServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> usersList=new ArrayList<User>();
		int offset=0;
		int limit=8;
		int totalRecords=usersService.getNumOfUsers();
		int totalPages= (int) Math.ceil((double) totalRecords / 8);
		HttpSession session = request.getSession();
		session.removeAttribute("queryTypeInt");
		session.removeAttribute("queryTxt");
		session.removeAttribute("birthday");
		usersList=usersService.getUsers(offset,limit);
		request.setAttribute("usersList", usersList);
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("totalRecords", totalRecords);
		request.setAttribute("currentPage",1);
		//重定向(页面过去了，后台也过去了)；
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
