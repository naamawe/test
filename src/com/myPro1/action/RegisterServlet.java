package com.myPro1.action;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myPro1.service.UsersService;
import com.myPro2.bean.User;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UsersService usersService=new UsersService();
		request.setCharacterEncoding("UTF-8");
		String username=request.getParameter("username");
		String userpwd=request.getParameter("userpwd");
		String Reuserpwd=request.getParameter("Reuserpwd");
		String sex=request.getParameter("querySex");
		String birthday=request.getParameter("birthday");
		if(userpwd.equals(Reuserpwd)&&username!=null&&userpwd!=null&&birthday!=null)
		{
			//更新操作用重定向
			User users=new User();
			users.setUsername(username);
			users.setUserpwd(userpwd);
			int autoID=usersService.getMaxId();
			autoID++;
			users.setId(autoID);
			users.setSex(Integer.parseInt(sex));
			users.setBirthday(Timestamp.valueOf(birthday));
			users.setBalance(0);
			int flag=usersService.register(users);
			if(flag>0) {
				response.sendRedirect("login.jsp?info=iok");
			}else {
				response.sendRedirect("register.jsp?info=unok");
			}
		}else {
			response.sendRedirect("register.jsp?info=unok");
		}
		/*System.out.println("username="+username);
		System.out.println("userpwd="+userpwd);
		System.out.println("Reuserpwd="+Reuserpwd);
		System.out.println("birthday="+birthday);*/
	}

}
