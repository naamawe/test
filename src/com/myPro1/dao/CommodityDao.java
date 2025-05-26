package com.myPro1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myPro2.bean.Commodity;
import com.myPro2.bean.User;

public class CommodityDao {
	BaseDao baseDao=new BaseDao(); 
	//上传商品
	public int saveCommodity(Commodity commodity) {
		int count=0;
		//preparedSql:字符串sql语句
		//?,?,?,?,?:占位符
		String preparedSql="insert into commodity(commodityId,userId,type,name,price,date,isSold)values(?,?,?,?,?,?,?)";
		Object[] param={commodity.getCommodityId(),commodity.getUserId(),commodity.getType(),commodity.getName(),commodity.getPrice(),commodity.getDate(),commodity.getIsSold()};
		count=baseDao.excuteUpdate(preparedSql, param);
		return count;
	}
	//获取商品最大id
	public int getMaxId() {
		String preparedSql="select max(commodityId) as max_id from commodity";
		ResultSet rs=null;
		Object[] param= {};
		rs=baseDao.executeQuery(preparedSql, param);
	    int maxId=1;
		try {
			while(rs.next()) {
				maxId = rs.getInt("max_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Connection conn= BaseDao.conn;
			PreparedStatement pstmt=baseDao.pstmt;
			baseDao.closeAll(conn,pstmt,rs);
		}
		
		return maxId;
	}
	//获取所有商品
	public List<Commodity> getCommoditys(int offset,int limit){
		String preparedSql="select * from commodity limit ? offset ?";
		ResultSet rs=null;
		Object[] param= {limit,offset};
		
		rs=baseDao.executeQuery(preparedSql, param);
		List<Commodity> listCommodities=new ArrayList<Commodity>();
		try {
			while(rs.next()) {
				Commodity commodity=new Commodity();
				commodity.setCommodityId(rs.getInt("commodityId"));
				commodity.setUserId(rs.getInt("userId"));
				commodity.setName(rs.getString("name"));
				commodity.setType(rs.getString("type"));
				commodity.setPrice(rs.getInt("price"));
				commodity.setDate(rs.getTimestamp("date"));
				commodity.setIsSold(rs.getString("isSold"));
				listCommodities.add(commodity);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			Connection conn= BaseDao.conn;
			PreparedStatement pstmt=baseDao.pstmt;
			
			//无论如何都要执行
			if(rs!=null&&pstmt!=null&&conn!=null) {
				baseDao.closeAll(conn,pstmt,rs);
			}
		}
		return listCommodities;
	}
	//获取数据库总数据量
		public int getNumOfCommoditise() {
			String preparedSql="SELECT COUNT(*) as sum FROM commodity";
			ResultSet rs=null;
			Object[] param= {};
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
		//根据商品id查找
		public List<Commodity> getCommodityById(int commodityId) {
			String preparedSql="select * from commodity where commodityId=?";
			ResultSet rs=null;
			Object[] param= {commodityId};
			rs=baseDao.executeQuery(preparedSql, param);
		
			List<Commodity> listCommodities=new ArrayList<Commodity>();
			
			try {
				int flag=0;
				while(rs.next()) {
					flag=1;
					Commodity commodity=new Commodity();
					commodity.setCommodityId(rs.getInt("commodityId"));
					commodity.setUserId(rs.getInt("userId"));
					commodity.setName(rs.getString("name"));
					commodity.setType(rs.getString("type"));
					commodity.setPrice(rs.getInt("price"));
					commodity.setDate(rs.getTimestamp("date"));
					commodity.setIsSold(rs.getString("isSold"));
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
			
			return listCommodities;
		}
		public List<Commodity> getCommodityById(int commodityId,int offset,int limit) {
			String preparedSql="select * from commodity where commodityId=? limit ? offset ?";
			ResultSet rs=null;
			Object[] param= {commodityId,limit,offset};
			rs=baseDao.executeQuery(preparedSql, param);
		
			List<Commodity> listCommodities=new ArrayList<Commodity>();
			
			try {
				int flag=0;
				while(rs.next()) {
					flag=1;
					Commodity commodity=new Commodity();
					commodity.setCommodityId(rs.getInt("commodityId"));
					commodity.setUserId(rs.getInt("userId"));
					commodity.setName(rs.getString("name"));
					commodity.setType(rs.getString("type"));
					commodity.setPrice(rs.getInt("price"));
					commodity.setDate(rs.getTimestamp("date"));
					commodity.setIsSold(rs.getString("isSold"));
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
			
			return listCommodities;
		}
		//根据类型进行查找
		public List<Commodity> getCommodityByType(String type) {
			String preparedSql="select * from commodity where type=?";
			ResultSet rs=null;
			Object[] param= {type};
			rs=baseDao.executeQuery(preparedSql, param);
		
			List<Commodity> listCommodities=new ArrayList<Commodity>();
			
			try {
				int flag=0;
				while(rs.next()) {
					flag=1;
					Commodity commodity=new Commodity();
					commodity.setCommodityId(rs.getInt("commodityId"));
					commodity.setUserId(rs.getInt("userId"));
					commodity.setName(rs.getString("name"));
					commodity.setType(rs.getString("type"));
					commodity.setPrice(rs.getInt("price"));
					commodity.setDate(rs.getTimestamp("date"));
					commodity.setIsSold(rs.getString("isSold"));
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
			
			return listCommodities;
		}
		public List<Commodity> getCommodityByType(String type,int offset,int limit) {
			String preparedSql="select * from commodity where type=? limit ? offset ?";
			ResultSet rs=null;
			Object[] param= {type,limit,offset};
			rs=baseDao.executeQuery(preparedSql, param);
		
			List<Commodity> listCommodities=new ArrayList<Commodity>();
			
			try {
				int flag=0;
				while(rs.next()) {
					flag=1;
					Commodity commodity=new Commodity();
					commodity.setCommodityId(rs.getInt("commodityId"));
					commodity.setUserId(rs.getInt("userId"));
					commodity.setName(rs.getString("name"));
					commodity.setType(rs.getString("type"));
					commodity.setPrice(rs.getInt("price"));
					commodity.setDate(rs.getTimestamp("date"));
					commodity.setIsSold(rs.getString("isSold"));
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
			
			return listCommodities;
		}
		//根据名字进行查找
		public List<Commodity> getCommodityByName(String name) {
			String preparedSql="select * from commodity where name=?";
			ResultSet rs=null;
			Object[] param= {name};
			rs=baseDao.executeQuery(preparedSql, param);
		
			List<Commodity> listCommodities=new ArrayList<Commodity>();
			
			try {
				int flag=0;
				while(rs.next()) {
					flag=1;
					Commodity commodity=new Commodity();
					commodity.setCommodityId(rs.getInt("commodityId"));
					commodity.setUserId(rs.getInt("userId"));
					commodity.setName(rs.getString("name"));
					commodity.setType(rs.getString("type"));
					commodity.setPrice(rs.getInt("price"));
					commodity.setDate(rs.getTimestamp("date"));
					commodity.setIsSold(rs.getString("isSold"));
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
			
			return listCommodities;
		}
		public List<Commodity> getCommodityByName(String name,int offset,int limit) {
			String preparedSql="select * from commodity where name=? limit ? offset ?";
			ResultSet rs=null;
			Object[] param= {name,limit,offset};
			rs=baseDao.executeQuery(preparedSql, param);
		
			List<Commodity> listCommodities=new ArrayList<Commodity>();
			
			try {
				int flag=0;
				while(rs.next()) {
					flag=1;
					Commodity commodity=new Commodity();
					commodity.setCommodityId(rs.getInt("commodityId"));
					commodity.setUserId(rs.getInt("userId"));
					commodity.setName(rs.getString("name"));
					commodity.setType(rs.getString("type"));
					commodity.setPrice(rs.getInt("price"));
					commodity.setDate(rs.getTimestamp("date"));
					commodity.setIsSold(rs.getString("isSold"));
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
			
			return listCommodities;
		}
		//根据是否购买进行查找
		public List<Commodity> getCommodityByIsSold(String isSold) {
			String preparedSql="select * from commodity where isSold=?";
			ResultSet rs=null;
			Object[] param= {isSold};
			rs=baseDao.executeQuery(preparedSql, param);
		
			List<Commodity> listCommodities=new ArrayList<Commodity>();
			
			try {
				int flag=0;
				while(rs.next()) {
					flag=1;
					Commodity commodity=new Commodity();
					commodity.setCommodityId(rs.getInt("commodityId"));
					commodity.setUserId(rs.getInt("userId"));
					commodity.setName(rs.getString("name"));
					commodity.setType(rs.getString("type"));
					commodity.setPrice(rs.getInt("price"));
					commodity.setDate(rs.getTimestamp("date"));
					commodity.setIsSold(rs.getString("isSold"));
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
			
			return listCommodities;
		}
		public List<Commodity> getCommodityByIsSold(String isSold,int offset,int limit) {
			String preparedSql="select * from commodity where isSold=? limit ? offset ?";
			ResultSet rs=null;
			Object[] param= {isSold,limit,offset};
			rs=baseDao.executeQuery(preparedSql, param);
		
			List<Commodity> listCommodities=new ArrayList<Commodity>();
			
			try {
				int flag=0;
				while(rs.next()) {
					flag=1;
					Commodity commodity=new Commodity();
					commodity.setCommodityId(rs.getInt("commodityId"));
					commodity.setUserId(rs.getInt("userId"));
					commodity.setName(rs.getString("name"));
					commodity.setType(rs.getString("type"));
					commodity.setPrice(rs.getInt("price"));
					commodity.setDate(rs.getTimestamp("date"));
					commodity.setIsSold(rs.getString("isSold"));
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
			
			return listCommodities;
		}
		//获取物品数量通过类型
		public int getNumOfCommodityByType(String type) {
			String preparedSql="SELECT COUNT(*) as sum FROM commodity where type=?";
			ResultSet rs=null;
			Object[] param= {type};
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
		//获取物品数量通过名字
				public int getNumOfCommodityByName(String name) {
					String preparedSql="SELECT COUNT(*) as sum FROM commodity where name=?";
					ResultSet rs=null;
					Object[] param= {name};
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
				//获取物品数量通过类型
				public int getNumOfCommodityByIsSold(String IsSold) {
					String preparedSql="SELECT COUNT(*) as sum FROM commodity where IsSold=?";
					ResultSet rs=null;
					Object[] param= {IsSold};
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
				
				//根据用户id和商品id查询数据
				public int editCommodityByUserIdandCommodityId(int userId,int commodityId,int buyId) {
					int count=0;
					String preparedSql="update commodity set userId=?,isSold=? where userId=? and commodityId=?";
					Object[] param= {buyId,"是",userId,commodityId};
					count=baseDao.excuteUpdate(preparedSql, param); 
					return count;
				}

}
//获取数据库总数据量
	