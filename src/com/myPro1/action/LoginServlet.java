package com.myPro1.action;

//����jdk�еİ�������

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
@WebServlet("/LoginServlet")//ע��:���÷��ʸ�servlet·��
public class LoginServlet extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("service����");
        //request:����;  response:��Ӧ��String�ַ������η���request.getParameter("username");�õ�ҳ��username������ֵ

        request.setCharacterEncoding("UTF-8");
        //Object:�������͵ĸ��࣬�����Դ�����������
        String username = request.getParameter("username");
        String userpwd = request.getParameter("userpwd");

        //�õ��������ݵ�list��
        UsersService usersService = new UsersService();
        CommodityDao commodityDao = new CommodityDao();
				/*List<User> usersList=new ArrayList<User>();
				//����ҵ���߼���ģ������
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

        //����
        if (username != null && userpwd != null) {
            //��¼
            User users = usersService.getUsersByNameAndPwd(username, userpwd);
            //��action���д������ݣ��Ϸ����Ƿ�������ͨ����ѯ���ݿ�õ���
            //����ҵ���߼��㣨com.myPro2.service��
            //���磺username���µ±룻userpwd��123456,ģ������ݿ���ȡ����ֵ
            if (users != null) {
                if (username.equals(users.getUsername()) && userpwd.equals(users.getUserpwd())) {
                    //�Ϸ�
                    //��users�������request��Ӧ�У����ݵ�index.jsp
                    //request.setAttribute("users", users);
                    //��users�������session�Ự�У����ݵ�index.jsp
                    //��������ھʹ���
                    request.getSession(true).setAttribute("users", users);
                    //ת������֣��ض����ת����
                    //ת��(ҳ���ȥ�ˣ���̨û�й�ȥ)
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
