package com.myPro1.action;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myPro1.service.UsersService;
import com.myPro2.bean.User;

@WebServlet("/PageProcessAndCateOfUsersServlet")
public class PageProcessAndCateOfUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsersService usersService=new UsersService();  
    public PageProcessAndCateOfUsersServlet() {
        super();
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int queryTypeInt=(Integer)request.getSession().getAttribute("queryTypeInt");
		String queryTxt=(String)request.getSession().getAttribute("queryTxt");
		int limit=8;
		List<User> usersList=new ArrayList<User>();
		String page=request.getParameter("page");
		String type=request.getParameter("type");
		int pageInt=Integer.valueOf(page);
		if(queryTypeInt==1) {
			User users=new User();
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
				List<User> usersList1=new ArrayList<User>();
				usersList1.add(users);
				request.setAttribute("usersList", usersList1);
				request.setAttribute("totalPages", 1);
				request.setAttribute("totalRecords", 1);
				request.setAttribute("currentPage",1);
				request.getRequestDispatcher("index.jsp").forward(request, response);
				}
		}else if(queryTypeInt==2) {
			int totalRecords=usersService.getNumOfUsersByUsername(queryTxt);
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
			usersList=usersService.getUsersByUsername(queryTxt,offset,limit);
			request.setAttribute("totalPages", totalPages);
			request.setAttribute("totalRecords", totalRecords);
			request.setAttribute("usersList", usersList);
			request.setAttribute("currentPage",pageInt);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}
		else if(queryTypeInt==3) {
			int sex=0;
			if(queryTxt.equals("ÄÐ")) {
				sex=0;
			}
			else {
				sex=1;
			}
			int totalRecords=usersService.getNumOfUsersBySex(sex);
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
				usersList=usersService.getUsersBySex(sex,offset,limit);
				request.setAttribute("totalPages", totalPages);
				request.setAttribute("totalRecords", totalRecords);
				request.setAttribute("usersList", usersList);
				request.setAttribute("currentPage",pageInt);
				request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else if(queryTypeInt==4) {
			String birthday=(String)request.getSession().getAttribute("birthday");
			Date Tbirthday=Date.valueOf(birthday);
			int totalRecords=usersService.getNumOfUsersByBirthday(Tbirthday);
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
			usersList=usersService.getUsersByBirthday(Tbirthday,offset,limit);
			request.setAttribute("totalPages", totalPages);
			request.setAttribute("totalRecords", totalRecords);
			request.setAttribute("usersList", usersList);
			request.setAttribute("currentPage",pageInt);
			request.getRequestDispatcher("index.jsp").forward(request, response);
	
		}else {
			System.out.println("Î´½øÈë");
		}
	}

}
