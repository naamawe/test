package com.myPro1.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myPro1.service.UsersService;

@WebServlet("/DelUsersByIdServlet")
public class DelUsersByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     UsersService usersService=new UsersService();  
    public DelUsersByIdServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		int idInt=Integer.parseInt(id);
		int flag=usersService.delUsersById(idInt);
		if(flag>0) {
			//转向到一个查询所有数据的servlet(GetUsersServlet)
			response.sendRedirect("getUsersServlet");
		}
	}

}
