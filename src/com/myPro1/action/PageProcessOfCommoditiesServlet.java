package com.myPro1.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myPro1.service.CommodityService;
import com.myPro1.service.ShoppingCartService;
import com.myPro2.bean.Commodity;
import com.myPro2.bean.User;


@WebServlet("/PageProcessOfCommoditiesServlet")
public class PageProcessOfCommoditiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     CommodityService commodityService=new CommodityService();  
    public PageProcessOfCommoditiesServlet() {
        super();
        
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int limit=8;
		List<Commodity> commoditiesList=new ArrayList<Commodity>();
		String page=request.getParameter("page1");
		String type=request.getParameter("type1");
		int pageInt=Integer.valueOf(page);
		Integer queryTypeInt=(Integer)request.getSession().getAttribute("queryTypeIntc");
		if(queryTypeInt!=null){
			request.setAttribute("page1", page);
			request.setAttribute("type1", type);
			request.getRequestDispatcher("PageProcessAndCateOfCommodityServlet").forward(request, response);
		}else {
		int totalRecords=commodityService.getNumOfCommoditise();
		int totalPages= (int) Math.ceil((double) totalRecords / 8);
		    if(type!=null) {
		    if(type.equals("next")) {
				pageInt++;
			}
			else if(type.equals("before")) {
				pageInt--;
			}
			else {
				
			}
		    if(pageInt==0) {
				pageInt=1;
			}
			else if(pageInt>totalPages) {
				pageInt=totalPages;
			}
			else {
				
			}
	}
			int offset=(pageInt-1)*8;
			commoditiesList=commodityService.getCommoditys(offset,limit);
			request.setAttribute("totalPages", totalPages);
			request.setAttribute("totalRecords", totalRecords);
			request.setAttribute("commoditiesList", commoditiesList);
			request.setAttribute("currentPage",pageInt);
			request.getRequestDispatcher("homepage.jsp").forward(request, response);
		
		}
	}
}
