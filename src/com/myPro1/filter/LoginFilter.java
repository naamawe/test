package com.myPro1.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter("/shoppingCart.jsp")
public class LoginFilter implements Filter {

    public LoginFilter() {
        
    }

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		 HttpServletRequest httpRequest = (HttpServletRequest) request;
	        HttpServletResponse httpResponse = (HttpServletResponse) response;
	        HttpSession session = httpRequest.getSession(false);

	        if (session == null || session.getAttribute("users") == null) {
	            httpResponse.sendRedirect("login.jsp?info=nologin");
	        } else {
	            // 用户已登录，继续执行后续的请求
	            chain.doFilter(request, response);
	        }
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
