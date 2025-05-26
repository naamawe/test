package com.myPro1.action;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
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

@WebServlet("/enquiryByConditionOfIndexServlet")
public class enquiryByConditionOfIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      UsersService usersService=new UsersService(); 
      List<User> usersList=new ArrayList<User>();
      User users=new User();
    public enquiryByConditionOfIndexServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String queryType=request.getParameter("queryTj");
	    String queryTxt=request.getParameter("queryTxt");
	    String birthday=request.getParameter("birthday");
		int queryTypeInt=Integer.parseInt(queryType);
		int offset=0;
		int limit=8;
		HttpSession session = request.getSession();
		session.setAttribute("queryTypeInt", queryTypeInt);
		session.setAttribute("queryTxt", queryTxt);
		session.setAttribute("birthday", birthday);
		if(queryTypeInt==1) {
			try {
			users=usersService.getUsersById(Integer.parseInt(queryTxt));
			}catch(Exception e){
				response.sendRedirect("index.jsp?info=unFound");
				return;
			}
			if(users==null)
			{
				response.sendRedirect("index.jsp?info=unFound");
			}else {
			List<User> usersList=new ArrayList<User>();
			usersList.add(users);
			request.setAttribute("usersList", usersList);
			request.setAttribute("totalPages", 1);
			request.setAttribute("totalRecords", 1);
			request.setAttribute("currentPage",1);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			//ID
		}else if(queryTypeInt==2){
			//ÕËºÅ
			usersList=usersService.getUsersByUsername(queryTxt,offset,limit);
			if(usersList==null) {
				response.sendRedirect("index.jsp?info=unFound");
			}else {
				int totalRecords=usersService.getNumOfUsersByUsername(queryTxt);
				int totalPages= (int) Math.ceil((double) totalRecords / 8);
				request.setAttribute("totalPages", totalPages);
				request.setAttribute("totalRecords", totalRecords);
				request.setAttribute("currentPage",1);
			    request.setAttribute("usersList", usersList);
			    request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}else if(queryTypeInt==3) {
			//ÐÔ±ð
			int sex=0;
			if(queryTxt.equals("ÄÐ")) {
				sex=0;
			}
			else {
				sex=1;
			}
			usersList=usersService.getUsersBySex(sex,offset,limit);
			if(usersList==null) {
				response.sendRedirect("index.jsp?info=unFound");
			}
			else
			{
			int totalRecords=usersService.getNumOfUsersBySex(sex);
			int totalPages= (int) Math.ceil((double) totalRecords / 8);
			request.setAttribute("totalPages", totalPages);
			request.setAttribute("totalRecords", totalRecords);
			request.setAttribute("currentPage",1);
			request.setAttribute("usersList", usersList);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}else if(queryTypeInt==4){
			Date Tbirthday=Date.valueOf(birthday);
			usersList=usersService.getUsersByBirthday(Tbirthday,offset,limit);
			if(usersList==null) {
				response.sendRedirect("index.jsp?info=unFound");
			}
			else{
				int totalRecords=usersService.getNumOfUsersByBirthday(Tbirthday);
				int totalPages= (int) Math.ceil((double) totalRecords / 8);
				request.setAttribute("totalPages", totalPages);
				request.setAttribute("totalRecords", totalRecords);
				request.setAttribute("currentPage",1);
			    request.setAttribute("usersList", usersList);
			    request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}else {
			
		}
	}

}
