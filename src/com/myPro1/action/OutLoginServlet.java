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
		//�õ�session���󣬲����ڲ�����
		HttpSession session=request.getSession(false);
		//�ж��Ƿ��е����û���session����
		if(session!=null) {
			//����е�¼�õ�session������Ƴ�
			request.removeAttribute("users");
			//ʹ��ǰ�Ự��Ч
			session.invalidate();
			response.sendRedirect("login.jsp?info=outlogin");
		}
	}

}
