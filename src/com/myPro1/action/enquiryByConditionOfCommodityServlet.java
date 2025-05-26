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
import javax.servlet.http.HttpSession;

import com.myPro1.service.CommodityService;
import com.myPro2.bean.Commodity;


@WebServlet("/enquiryByConditionOfCommodityServlet")
public class enquiryByConditionOfCommodityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    CommodityService commodityService=new CommodityService();
    List<Commodity> commoditiesList=new ArrayList<Commodity>();
    Commodity commodity=new Commodity();
    public enquiryByConditionOfCommodityServlet() {
        super();
       
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String queryTypec=request.getParameter("queryTjc");
	    String queryTxtc=request.getParameter("queryTxtc");
		int queryTypeIntc=Integer.parseInt(queryTypec);
		int offset=0;
		int limit=8;
		HttpSession session = request.getSession();
		session.setAttribute("queryTypeIntc", queryTypeIntc);
		session.setAttribute("queryTxtc", queryTxtc);
		if(queryTypeIntc==1) {
			try {
			commodity=commodityService.getCommodityById(Integer.parseInt(queryTxtc));
			}catch(Exception e){
				response.sendRedirect("homepage.jsp?info=unFound");
				return;
			}
			if(commodity==null)
			{
				response.sendRedirect("homepage.jsp?info=unFound");
			}else {
			List<Commodity> commoditiesList=new ArrayList<Commodity>();
			commoditiesList.add(commodity);
			request.setAttribute("commoditiesList", commoditiesList);
			request.setAttribute("totalPages", 1);
			request.setAttribute("totalRecords", 1);
			request.setAttribute("currentPage",1);
			request.getRequestDispatcher("homepage.jsp").forward(request, response);
			}
			//ID
		}else if(queryTypeIntc==2){
			//ук╨е
			commoditiesList=commodityService.getCommodityByType(queryTxtc,offset,limit);
			if(commoditiesList==null) {
				response.sendRedirect("homepage.jsp?info=unFound");
			}else {
				int totalRecords=commodityService.getNumOfCommodityByType(queryTxtc);
				int totalPages= (int) Math.ceil((double) totalRecords / 8);
				request.setAttribute("totalPages", totalPages);
				request.setAttribute("totalRecords", totalRecords);
				request.setAttribute("currentPage",1);
			    request.setAttribute("commoditiesList", commoditiesList);
			    request.getRequestDispatcher("homepage.jsp").forward(request, response);
			}
		}else if(queryTypeIntc==3) {
			
			commoditiesList=commodityService.getCommodityByname(queryTxtc,offset,limit);
			if(commoditiesList==null) {
				response.sendRedirect("homepage.jsp?info=unFound");
			}
			else
			{
			int totalRecords=commodityService.getNumOfCommodityByName(queryTxtc);
			int totalPages= (int) Math.ceil((double) totalRecords / 8);
			request.setAttribute("totalPages", totalPages);
			request.setAttribute("totalRecords", totalRecords);
			request.setAttribute("currentPage",1);
			 request.setAttribute("commoditiesList", commoditiesList);
			request.getRequestDispatcher("homepage.jsp").forward(request, response);
			}
		}else if(queryTypeIntc==4) {
			commoditiesList=commodityService.getCommodityByIsSold(queryTxtc,offset,limit);
			if(commoditiesList==null) {
				response.sendRedirect("homepage.jsp?info=unFound");
			}
			else{
				int totalRecords=commodityService.getNumOfCommodityByIsSold(queryTxtc);
				int totalPages= (int) Math.ceil((double) totalRecords / 8);
				request.setAttribute("totalPages", totalPages);
				request.setAttribute("totalRecords", totalRecords);
				request.setAttribute("currentPage",1);
				 request.setAttribute("commoditiesList", commoditiesList);
			    request.getRequestDispatcher("homepage.jsp").forward(request, response);
			}
		}else {
			
		}
	}

}
