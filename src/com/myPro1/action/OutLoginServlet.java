package com.myPro1.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/OutLoginServlet")
public class OutLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public OutLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("1111");
		//得到session对象，不存在不创建
		HttpSession session=request.getSession(false);
		//判断是否有登入用户的session对象
		if(session!=null) {
			//如果有登录用的session对象就移除
			request.removeAttribute("users");
			//使当前会话无效
			session.invalidate();
			response.sendRedirect("login.jsp?info=outlogin");
		}
	}

}
