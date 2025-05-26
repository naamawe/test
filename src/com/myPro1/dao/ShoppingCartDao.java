package com.myPro1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myPro2.bean.Commodity;
import com.myPro2.bean.ShoppingCart;
import com.myPro2.bean.User;

public class ShoppingCartDao {
  BaseDao baseDao=new BaseDao();
  //添加购物车记录
  public int addShoppingCart(ShoppingCart shoppingCart) {
	  int count=0;
		//preparedSql:字符串sql语句
		//?,?,?,?,?:占位符
		String preparedSql="insert into shoppingCart(userId,commodityId)values(?,?)";
		Object[] param={shoppingCart.getUserId(),shoppingCart.getCommodityId()};
		count=baseDao.excuteUpdate(preparedSql, param);
		return count;
  }
  //根据用户Id和商品Id查询物品
  public List<ShoppingCart> getShoppingCartByCommodityIdAndUserId(ShoppingCart shoppingCart) {
		String preparedSql="select * from shoppingCart where commodityId=? and userId=?";
		ResultSet rs=null;
		Object[] param= {shoppingCart.getCommodityId(),shoppingCart.getUserId()};
		rs=baseDao.executeQuery(preparedSql, param);
	
		List<ShoppingCart> listShoppingCart=new ArrayList<ShoppingCart>();
		
		try {
			int flag=0;
			while(rs.next()) {
				flag=1;
				ShoppingCart shoppingCart1=new ShoppingCart(rs.getInt("userId"),rs.getInt("commodityId")); 
				listShoppingCart.add(shoppingCart1);
			}
			if(flag==0) {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Connection conn= BaseDao.conn;
			PreparedStatement pstmt=baseDao.pstmt;
			baseDao.closeAll(conn,pstmt,rs);
		}
		
		return listShoppingCart;
	}
  public List<Commodity> getShoppingCartByCommodityId(int userId,int offset,int limit) {
		String preparedSql="select * from commodity,shoppingCart where commodity.commodityId=shoppingCart.commodityId"
				+ " and shoppingCart.userId=? limit ? offset ?";
		ResultSet rs=null;
		Object[] param= {userId,limit,offset};
		
		rs=baseDao.executeQuery(preparedSql, param);
	
		List<Commodity> listCommodities=new ArrayList<Commodity>();
		if(rs!=null) {
		try {
			int flag=0;
			while(rs.next()) {
			    flag=1;
			    Commodity commodity=new Commodity();
			    commodity.setUserId(rs.getInt("commodity.userId"));
			    commodity.setCommodityId(rs.getInt("commodity.commodityId"));
			    commodity.setName(rs.getString("commodity.name"));
			    commodity.setType(rs.getString("commodity.type"));
			    commodity.setPrice(rs.getDouble("commodity.price"));
				listCommodities.add(commodity);
			}
			if(flag==0) {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Connection conn= BaseDao.conn;
			PreparedStatement pstmt=baseDao.pstmt;
			baseDao.closeAll(conn,pstmt,rs);
		}
		}
		
		return listCommodities;
	}
  public List<Commodity> getShoppingCartByCommodityId(int userId) {
		String preparedSql="select * from commodity,shoppingCart where commodity.commodityId=shoppingCart.commodityId"
				+ " and shoppingCart.userId=?";
		ResultSet rs=null;
		Object[] param= {userId};
		
		rs=baseDao.executeQuery(preparedSql, param);
	
		List<Commodity> listCommodities=new ArrayList<Commodity>();
		if(rs!=null) {
		try {
			int flag=0;
			while(rs.next()) {
			    flag=1;
			    Commodity commodity=new Commodity();
			    commodity.setUserId(rs.getInt("commodity.userId"));
			    commodity.setCommodityId(rs.getInt("commodity.commodityId"));
			    commodity.setName(rs.getString("commodity.name"));
			    commodity.setType(rs.getString("commodity.type"));
			    commodity.setPrice(rs.getDouble("commodity.price"));
				listCommodities.add(commodity);
			}
			if(flag==0) {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Connection conn= BaseDao.conn;
			PreparedStatement pstmt=baseDao.pstmt;
			baseDao.closeAll(conn,pstmt,rs);
		}
		}
		
		return listCommodities;
	}
  public List<Commodity> getShoppingCartByType(int userId,String type,int offset,int limit) {
		String preparedSql="select * from commodity,shoppingCart where commodity.commodityId=shoppingCart.commodityId"
				+ " and shoppingCart.userId=? and type=? limit ? offset ?";
		ResultSet rs=null;
		Object[] param= {userId,type,limit,offset};
		
		rs=baseDao.executeQuery(preparedSql, param);
	
		List<Commodity> listCommodities=new ArrayList<Commodity>();
		if(rs!=null) {
		try {
			int flag=0;
			while(rs.next()) {
			    flag=1;
			    Commodity commodity=new Commodity();
			    commodity.setUserId(rs.getInt("commodity.userId"));
			    commodity.setCommodityId(rs.getInt("commodity.commodityId"));
			    commodity.setName(rs.getString("commodity.name"));
			    commodity.setType(rs.getString("commodity.type"));
			    commodity.setPrice(rs.getDouble("commodity.price"));
				listCommodities.add(commodity);
			}
			if(flag==0) {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Connection conn= BaseDao.conn;
			PreparedStatement pstmt=baseDao.pstmt;
			baseDao.closeAll(conn,pstmt,rs);
		}
		}
		
		return listCommodities;
	}
  
  public int getNumOfshoppingCartByUserId(int userId) {
		String preparedSql="SELECT COUNT(*) as sum FROM shoppingCart where userId=?";
		ResultSet rs=null;
		Object[] param= {userId};
		int sum=0;
		rs=baseDao.executeQuery(preparedSql, param);
		try {
			while(rs.next()) {
				sum= rs.getInt("sum");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Connection conn= BaseDao.conn;
			PreparedStatement pstmt=baseDao.pstmt;
			baseDao.closeAll(conn,pstmt,rs);
		}
		return sum;
	}
  public int getNumOfshoppingCartByType(int userId,String type) {
		String preparedSql="SELECT COUNT(*) as sum FROM commodity,shoppingCart where commodity.commodityId=shoppingCart.commodityId"
				+ " and shoppingCart.userId=? and type=?";
		ResultSet rs=null;
		Object[] param= {userId,type};
		int sum=0;
		rs=baseDao.executeQuery(preparedSql, param);
		try {
			while(rs.next()) {
				sum= rs.getInt("sum");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Connection conn= BaseDao.conn;
			PreparedStatement pstmt=baseDao.pstmt;
			baseDao.closeAll(conn,pstmt,rs);
		}
		return sum;
	}
  public int delShoppingCartByCommodityIdAndUserId(int userId,int comodityId) {
		int count=0;
		String preparedSql="delete from shoppingCart where userId=? and commodityId=?";
		Object[] param={userId,comodityId};
		count=baseDao.excuteUpdate(preparedSql, param);
		return count;
	}
  public int delShoppingCartByCommodityId(int comodityId) {
		int count=0;
		String preparedSql="delete from shoppingCart where commodityId=?";
		Object[] param={comodityId};
		count=baseDao.excuteUpdate(preparedSql, param);
		return count;
	}
  public int delShoppingCartByUserId(int userId) {
		int count=0;
		String preparedSql="delete from shoppingCart where userId=?";
		Object[] param={userId};
		count=baseDao.excuteUpdate(preparedSql, param);
		return count;
	}
  
}
