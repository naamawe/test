package com.myPro1.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myPro1.dao.CommodityDao;
import com.myPro2.bean.Commodity;

@WebServlet("/toHomepageServlet")
public class toHomepageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public toHomepageServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		CommodityDao commodityDao=new CommodityDao();
		List<Commodity> commoditiesList=new ArrayList<Commodity>();
		HttpSession session = request.getSession();
		System.out.println((String)request.getAttribute("info"));
		session.removeAttribute("queryTypeIntc");
		session.removeAttribute("queryTxtc");
		commoditiesList=commodityDao.getCommoditys(0, 8);
		int totalRecords=commodityDao.getNumOfCommoditise();
		int totalPages= (int) Math.ceil((double) totalRecords / 8);
		request.setAttribute("commoditiesList", commoditiesList);
		request.setAttribute("currentPage", 1);
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("totalRecords", totalRecords);
		request.getRequestDispatcher("homepage.jsp").forward(request, response);
	}

}
