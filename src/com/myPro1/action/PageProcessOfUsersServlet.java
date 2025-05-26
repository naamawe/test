package com.myPro1.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myPro1.service.UsersService;
import com.myPro2.bean.User;

@WebServlet("/PageProcessOfUsersServlet")
public class PageProcessOfUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     UsersService usersService=new UsersService();  
    public PageProcessOfUsersServlet() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int limit=8;
		List<User> usersList=new ArrayList<User>();
		String page=request.getParameter("page");
		String type=request.getParameter("type");
		int pageInt=Integer.valueOf(page);
		Integer queryTypeInt=(Integer)request.getSession().getAttribute("queryTypeInt");
		if(queryTypeInt!=null){
			request.setAttribute("page", page);
			request.setAttribute("type", type);
			request.getRequestDispatcher("PageProcessAndCateOfUsersServlet").forward(request, response);
		}else {
		int totalRecords=usersService.getNumOfUsers();
		int totalPages= (int) Math.ceil((double) totalRecords / 8);
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
			int offset=(pageInt-1)*8;
			usersList=usersService.getUsers(offset,limit);
			request.setAttribute("totalPages", totalPages);
			request.setAttribute("totalRecords", totalRecords);
			request.setAttribute("usersList", usersList);
			request.setAttribute("currentPage",pageInt);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
}
