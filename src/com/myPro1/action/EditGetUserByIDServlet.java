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

@WebServlet("/EditGetUserByIDServlet")
public class EditGetUserByIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsersService usersService=new UsersService();
  
    public EditGetUserByIDServlet() {
        super();
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�õ�ҳ�洫�����������ж�.....
		String id=request.getParameter("id");
		String ed=request.getParameter("ed");
		System.out.println(ed);
		if(ed!=null) {
		HttpSession session=request.getSession();
		session.setAttribute("ed", ed);
		}
		int idInt=Integer.parseInt(id);
		User users=new User();
		users=usersService.getUsersById(idInt);
		//�Ƿ��ѯ��users������ж�
		request.setAttribute("users", users);
		request.getRequestDispatcher("editUser.jsp").forward(request, response);
	}

}
