package com.myPro1.action;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myPro1.service.UsersService;
import com.myPro2.bean.User;

@WebServlet("/EditUserServlet")
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsersService usersService=new UsersService();
    public EditUserServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("utf-8");
		
		String id=request.getParameter("id");
		String username=request.getParameter("username");
		String userpwd=request.getParameter("userpwd");
		String sex=request.getParameter("sex");
		String birthday=request.getParameter("birthday");
		
		//要做数据是否存在判断...
		
		int idInt=Integer.parseInt(id);
				
		User users=new User();
		users.setUserpwd(userpwd);
		users.setId(idInt);
		users.setUsername(username);
		users.setSex(Integer.parseInt(sex));
		users.setBirthday(Timestamp.valueOf(birthday));
		
		//进行接收页面传递来的数据判断....
		int flag=usersService.editUsersById(users, idInt);
		HttpSession session=request.getSession();
		String ed=(String)session.getAttribute("ed");
	    if(flag>0) {
	    	if(ed.equals("1")) {
	    		session.removeAttribute("ed");
	    		session.setAttribute("users", users);
	    		response.sendRedirect("personalHomepage.jsp");
	    	}else {
				response.sendRedirect("getUsersServlet");
	    	}
		}else {
			//转到失败页面
			System.out.println("修改失败！");
		}
	}

}
