package com.myPro1.action;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myPro1.service.CUService;
import com.myPro1.service.CommodityService;
import com.myPro2.bean.CU;
import com.myPro2.bean.Commodity;
import com.myPro2.bean.User;

@WebServlet("/uploadGooodServlet")
public class uploadGooodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     CommodityService commodityService=new CommodityService();  
     CUService cuService=new CUService();
    public uploadGooodServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String itemname=request.getParameter("itemname");
		String itemtype=request.getParameter("itemtype");
		String priceString=request.getParameter("price");
		int commodityId=commodityService.getMaxId()+1;
		double price=0;
		Timestamp timestamp= new Timestamp(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateS= sdf.format(timestamp);
		Timestamp date=Timestamp.valueOf(dateS);
		HttpSession sesiion=request.getSession();
		User users=new User();
		users=(User)sesiion.getAttribute("users");
		int usersId=users.getId();
		
		try {
			price=Double.valueOf(priceString);
		}catch (Exception e) {
			System.out.println("价格上传格式出差");
			response.sendRedirect("uploadGoods.jsp?info=formateEror");
		}
		Commodity commodity=new Commodity();
		commodity.setCommodityId(commodityId);
		commodity.setUserId(usersId);
		commodity.setIsSold("否");
		commodity.setName(itemname);
		commodity.setType(itemtype);
		commodity.setPrice(price);
		commodity.setDate(date);
		int flag1=commodityService.saveCommodity(commodity);
		if(flag1>0) {
			response.sendRedirect("uploadGoods.jsp?info=ok");
		}
		else {
			response.sendRedirect("uploadGoods.jsp?info=unok");
		}
		//System.out.println(itemname);
		//System.out.println(itemtype);
		//System.out.println(price);
	}

}
