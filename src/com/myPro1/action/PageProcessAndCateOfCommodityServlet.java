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

import com.myPro1.service.CommodityService;
import com.myPro2.bean.Commodity;

@WebServlet("/PageProcessAndCateOfCommodityServlet")
public class PageProcessAndCateOfCommodityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      CommodityService commodityService=new CommodityService();
 
    public PageProcessAndCateOfCommodityServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int queryTypeInt=(Integer)request.getSession().getAttribute("queryTypeIntc");
		String queryTxt=(String)request.getSession().getAttribute("queryTxtc");
		int limit=8;
		 List<Commodity> commoditiesList=new ArrayList<Commodity>();
		String page=request.getParameter("page1");
		String type=request.getParameter("type1");
		int pageInt=Integer.valueOf(page);
		if(queryTypeInt==1) {
		    Commodity commodity=new Commodity();
			try {
				commodity=commodityService.getCommodityById(Integer.parseInt(queryTxt));
				}catch(Exception e){
					response.sendRedirect("homepage.jsp?info=unFound");
					return;
				}
				if(commodity==null)
				{
					response.sendRedirect("homepage.jsp?info=unFound");
				}else {
					List<Commodity> commoditiesList1=new ArrayList<Commodity>();
					commoditiesList1.add(commodity);
					request.setAttribute("commoditiesList", commoditiesList1);
					request.setAttribute("totalPages", 1);
					request.setAttribute("totalRecords", 1);
					request.setAttribute("currentPage",1);
					request.getRequestDispatcher("homepage.jsp").forward(request, response);
					}
				}
		   else if(queryTypeInt==2) {
			int totalRecords=commodityService.getNumOfCommodityByType(queryTxt);
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
			commoditiesList=commodityService.getCommodityByType(queryTxt,offset,limit);
			request.setAttribute("totalPages", totalPages);
			request.setAttribute("totalRecords", totalRecords);
			request.setAttribute("currentPage",1);
		    request.setAttribute("commoditiesList", commoditiesList);
		    request.getRequestDispatcher("homepage.jsp").forward(request, response);
			
		}
		else if(queryTypeInt==3) {
			int totalRecords=commodityService.getNumOfCommodityByName(queryTxt);
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
			commoditiesList=commodityService.getCommodityByType(queryTxt,offset,limit);
			request.setAttribute("totalPages", totalPages);
			request.setAttribute("totalRecords", totalRecords);
			request.setAttribute("currentPage",1);
		    request.setAttribute("commoditiesList", commoditiesList);
		    request.getRequestDispatcher("homepage.jsp").forward(request, response);
		}
		else if(queryTypeInt==4) {
			int totalRecords=commodityService.getNumOfCommodityByIsSold(queryTxt);
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
			commoditiesList=commodityService.getCommodityByIsSold(queryTxt,offset,limit);
			request.setAttribute("totalPages", totalPages);
			request.setAttribute("totalRecords", totalRecords);
			request.setAttribute("currentPage",1);
		    request.setAttribute("commoditiesList", commoditiesList);
		    request.getRequestDispatcher("homepage.jsp").forward(request, response);
	
		}else {
			System.out.println("Î´½øÈë");
		}
	}
}


