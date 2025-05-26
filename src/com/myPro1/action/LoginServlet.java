package com.myPro1.action;

//导入jdk中的包或者类

import java.io.IOException;
import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myPro1.dao.CommodityDao;
import com.myPro1.service.UsersService;
import com.myPro2.bean.Commodity;
import com.myPro2.bean.User;

/**
 * @author master
 */
@WebServlet("/LoginServlet")//注解:设置访问该servlet路径
public class LoginServlet extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("service方法");
        //request:请求;  response:响应；String字符串修饰符；request.getParameter("username");得到页面username传来的值

        request.setCharacterEncoding("UTF-8");
        //Object:所有类型的父类，他可以代表所有类型
        String username = request.getParameter("username");
        String userpwd = request.getParameter("userpwd");

        //得到所有数据到list中
        UsersService usersService = new UsersService();
        CommodityDao commodityDao = new CommodityDao();
				/*List<User> usersList=new ArrayList<User>();
				//调用业务逻辑层模拟数据
				usersList=usersService.getUsers(0,8);
				int totalRecords=usersService.getNumOfUsers();
				int totalPages= (int) Math.ceil((double) totalRecords / 8);
				request.setAttribute("usersList", usersList);
				request.setAttribute("currentPage", 1);
				request.setAttribute("totalPages", totalPages);
				request.setAttribute("totalRecords", totalRecords);*/

        List<Commodity> commoditiesList = new ArrayList<Commodity>();
        commoditiesList = commodityDao.getCommoditys(0, 8);
        int totalRecords = commodityDao.getNumOfCommoditise();
        int totalPages = (int) Math.ceil((double) totalRecords / 8);
        request.setAttribute("commoditiesList", commoditiesList);
        request.setAttribute("currentPage", 1);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("totalRecords", totalRecords);

        //登入
        if (username != null && userpwd != null) {
            //登录
            User users = usersService.getUsersByNameAndPwd(username, userpwd);
            //在action层中处理数据（合法，非法的数据通过查询数据库得到）
            //调用业务逻辑层（com.myPro2.service）
            //假如：username：奥德彪；userpwd：123456,模拟从数据库中取出的值
            if (users != null) {
                if (username.equals(users.getUsername()) && userpwd.equals(users.getUserpwd())) {
                    //合法
                    //把users对象放入request响应中，传递到index.jsp
                    //request.setAttribute("users", users);
                    //把users对象放入session会话中，传递到index.jsp
                    //如果不存在就创建
                    request.getSession(true).setAttribute("users", users);
                    //转向分两种（重定向和转发）
                    //转发(页面过去了，后台没有过去)
                    request.getRequestDispatcher("homepage.jsp").forward(request, response);
                }
            } else {
                //request.getRequestDispatcher("index.jsp").forward(request, response);
                response.sendRedirect("login.jsp?info=no");
            }
        } else {
            //request.getRequestDispatcher("index.jsp").forward(request, response);
            response.sendRedirect("login.jsp?info=no");
        }
    }
}
