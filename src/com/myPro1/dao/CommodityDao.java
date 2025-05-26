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
	//�ϴ���Ʒ
	public int saveCommodity(Commodity commodity) {
		int count=0;
		//preparedSql:�ַ���sql���
		//?,?,?,?,?:ռλ��
		String preparedSql="insert into commodity(commodityId,userId,type,name,price,date,isSold)values(?,?,?,?,?,?,?)";
		Object[] param={commodity.getCommodityId(),commodity.getUserId(),commodity.getType(),commodity.getName(),commodity.getPrice(),commodity.getDate(),commodity.getIsSold()};
		count=baseDao.excuteUpdate(preparedSql, param);
		return count;
	}
	//��ȡ��Ʒ���id
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
	//��ȡ������Ʒ
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
			
			//������ζ�Ҫִ��
			if(rs!=null&&pstmt!=null&&conn!=null) {
				baseDao.closeAll(conn,pstmt,rs);
			}
		}
		return listCommodities;
	}
	//��ȡ���ݿ���������
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
		//������Ʒid����
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
		//�������ͽ��в���
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
		//�������ֽ��в���
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
		//�����Ƿ�����в���
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
		//��ȡ��Ʒ����ͨ������
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
		//��ȡ��Ʒ����ͨ������
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
				//��ȡ��Ʒ����ͨ������
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
				
				//�����û�id����Ʒid��ѯ����
				public int editCommodityByUserIdandCommodityId(int userId,int commodityId,int buyId) {
					int count=0;
					String preparedSql="update commodity set userId=?,isSold=? where userId=? and commodityId=?";
					Object[] param= {buyId,"��",userId,commodityId};
					count=baseDao.excuteUpdate(preparedSql, param); 
					return count;
				}

}
//��ȡ���ݿ���������
	