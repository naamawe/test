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

@WebServlet("/indexServlet")
public class indexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      UsersService usersService=new UsersService(); 
      List<User> usersList=new ArrayList<User>();
    public indexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		String queryType=request.getParameter("queryTj");
		int queryTypeInt=Integer.parseInt(queryType);
		if(queryTypeInt==1) {
			//ID
		}else if(queryTypeInt==2){
			//ÕËºÅ
			usersList=usersService.getUsersByUsername(queryType);
		}else if(queryTypeInt==3) {
			//ÐÔ±ð
			
		}else {
			
		}
	}

}
