package com.myPro1.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import com.myPro2.bean.User;



/*
 *ר�����Usersд���� 
 */
public class UsersDao {
	BaseDao baseDao=new BaseDao();
	
	//������ݣ���ɾ�Ŀ�����BaseDao��executeUpdate�йر����ݿ����ӣ�
	public int saveUsers(User users) {
		int count=0;
		//preparedSql:�ַ���sql���
		//?,?,?,?,?:ռλ��
		String preparedSql="insert into users(id,username,userpwd,sex,birthday,balance)values(?,?,?,?,?,?)";
		Object[] param={users.getId(),users.getUsername(),users.getUserpwd(),users.getSex(),users.getBirthday(),users.getBalance()};
		count=baseDao.excuteUpdate(preparedSql, param);
		return count;
	}
	
	//��ѯ��������(��ѯ�ر����ݿ����ӱ����ڽ����rsȥ�������Ժ��)
	public List<User> getUsers(){
		String preparedSql="select * from users";
		ResultSet rs=null;
		Object[] param= {};
		
		rs=baseDao.executeQuery(preparedSql, param);
		List<User> listUsers=new ArrayList<User>();
		try {
			while(rs.next()) {
				User users=new User();
				users.setId(rs.getInt("id"));
				users.setUsername(rs.getString("username"));
				users.setUserpwd(rs.getString("userpwd"));
				users.setSex(rs.getInt("sex"));
				users.setBirthday(rs.getTimestamp("birthday"));
				users.setBalance(rs.getDouble("balance"));
				listUsers.add(users);
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
		return listUsers;
	}
	
	public List<User> getUsers(int offset,int limit){
		String preparedSql="select * from users limit ? offset ?";
		ResultSet rs=null;
		Object[] param= {limit,offset};
		
		rs=baseDao.executeQuery(preparedSql, param);
		List<User> listUsers=new ArrayList<User>();
		try {
			while(rs.next()) {
				User users=new User();
				users.setId(rs.getInt("id"));
				users.setUsername(rs.getString("username"));
				users.setUserpwd(rs.getString("userpwd"));
				users.setSex(rs.getInt("sex"));
				users.setBirthday(rs.getTimestamp("birthday"));
				users.setBalance(rs.getDouble("balance"));
				listUsers.add(users);
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
		return listUsers;
	}
	
	//�����û����������ѯ����
	public List<User> getUsersByNameAndPwd(String username, String password) {
		if (username == null || username.trim().isEmpty() ||
				password == null || password.trim().isEmpty()) {
			return null;
		}

		String preparedSql = "SELECT * FROM users WHERE username = ? AND userpwd = ?";
		Object[] params = {username.trim(), password};
		List<User> userList = new ArrayList<>();
		ResultSet rs = null;

		try {
			rs = baseDao.executeQuery(preparedSql, params);
			if (rs != null) {
				while (rs.next()) {
					User user = createUserFromResultSet(rs);
					userList.add(user);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			// �ֶ��ر���Դ
			if (rs != null && baseDao.pstmt != null && BaseDao.conn != null) {
				baseDao.closeAll(BaseDao.conn, baseDao.pstmt, rs);
			}
		}

		return userList.isEmpty() ? null : userList;
	}

	/**
	 * ��ResultSet����User����
	 */
	private User createUserFromResultSet(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setUsername(rs.getString("username"));
		user.setUserpwd(rs.getString("userpwd"));
		user.setSex(rs.getInt("sex"));
		user.setBirthday(rs.getTimestamp("birthday"));
		user.setBalance(rs.getDouble("balance"));
		return user;
	}


	//����id�޸�ɾ��
	public int delUsersById(int id) {
		int count=0;
		String preparedSql="delete from users where id=?";
		Object[] param={id};
		count=baseDao.excuteUpdate(preparedSql, param);
		return count;
	}
	
	//����id����
	public List<User> getUsersById(int id) {
		String preparedSql="select * from users where id=?";
		ResultSet rs=null;
		Object[] param= {id};
		rs=baseDao.executeQuery(preparedSql, param);
	
		List<User> listUsers=new ArrayList<User>();
		
		try {
			int flag=0;
			while(rs.next()) {
				flag=1;
				User users=new User();
				users.setId(rs.getInt("id"));
				users.setUserpwd(rs.getString("userpwd"));
				users.setUsername(rs.getString("username"));
				users.setSex(rs.getInt("sex"));
				users.setBirthday(rs.getTimestamp("birthday"));
				users.setBalance(rs.getDouble("balance"));
				listUsers.add(users);
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
		
		return listUsers;
	}
	//����id�޸�users
	public int editUsersById(User users,int id) {
		int count=0;
		String preparedSql="update users set userpwd=?,username=?,sex=?,birthday=? where id=?";
		Object[] param= {users.getUserpwd(),users.getUsername(),users.getSex(),users.getBirthday(),id};
		count=baseDao.excuteUpdate(preparedSql, param); 
		
		return count;

	}
	public int editUsersPriceById(int id,double price) {
		int count=0;
		String preparedSql="update users set balance=balance-? where id=?";
		Object[] param= {price,id};
		count=baseDao.excuteUpdate(preparedSql, param); 
		
		return count;

	}
	public int IncreaseUsersPriceById(int id,double price) {
		int count=0;
		String preparedSql="update users set balance=balance+? where id=?";
		Object[] param= {price,id};
		count=baseDao.excuteUpdate(preparedSql, param); 
		
		return count;

	}
	//����id��ֵ
	public int rechargeById(double amount, int id) {
		int count=0;
		String preparedSql="update users set balance=balance+? where id=?";
		Object[] param= {amount,id};
		count=baseDao.excuteUpdate(preparedSql, param); 
		
		return count;

	}
	//�����˺Ų�ѯ
	public List<User> getUsersByUsername(String username) {
		String preparedSql="select * from users where username=?";
		ResultSet rs=null;
		Object[] param= {username};
		
		rs=baseDao.executeQuery(preparedSql, param);
	
		List<User> listUsers=new ArrayList<User>();
		
		try {
			int flag=0;
			while(rs.next()) {
				flag=1;
				User users=new User();
				users.setId(rs.getInt("id"));
				users.setUserpwd(rs.getString("userpwd"));
				users.setUsername(rs.getString("username"));
				users.setSex(rs.getInt("sex"));
				users.setBirthday(rs.getTimestamp("birthday"));
				users.setBalance(rs.getDouble("balance"));
				listUsers.add(users);
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
		
		return listUsers;
	}
	//�����˺Ų�ѯ
		public List<User> getUsersByUsername(String username,int offset,int limit) {
			String preparedSql="select * from users where username=? limit ? offset ?";
			ResultSet rs=null;
			Object[] param= {username,limit,offset};
			
			rs=baseDao.executeQuery(preparedSql, param);
		
			List<User> listUsers=new ArrayList<User>();
			
			try {
				int flag=0;
				while(rs.next()) {
					flag=1;
					User users=new User();
					users.setId(rs.getInt("id"));
					users.setUserpwd(rs.getString("userpwd"));
					users.setUsername(rs.getString("username"));
					users.setSex(rs.getInt("sex"));
					users.setBirthday(rs.getTimestamp("birthday"));
					users.setBalance(rs.getDouble("balance"));
					listUsers.add(users);
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
			
			return listUsers;
		}
	//�����Ա�
	public List<User> getUsersBySex(int sex) {
		String preparedSql="select * from users where sex=?";
		ResultSet rs=null;
		Object[] param= {sex};
		
		rs=baseDao.executeQuery(preparedSql, param);
	
		List<User> listUsers=new ArrayList<User>();
		
		try {
			int flag=0;
			while(rs.next()) {
			    flag=1;
				User users=new User();
				users.setId(rs.getInt("id"));
				users.setUserpwd(rs.getString("userpwd"));
				users.setUsername(rs.getString("username"));
				users.setSex(rs.getInt("sex"));
				users.setBirthday(rs.getTimestamp("birthday"));
				users.setBalance(rs.getDouble("balance"));
				listUsers.add(users);
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
		
		return listUsers;
	}
	public List<User> getUsersBySex(int sex,int offset,int limit) {
		String preparedSql="select * from users where sex=? limit ? offset ?";
		ResultSet rs=null;
		Object[] param= {sex,limit,offset};
		
		rs=baseDao.executeQuery(preparedSql, param);
	
		List<User> listUsers=new ArrayList<User>();
		
		try {
			int flag=0;
			while(rs.next()) {
			    flag=1;
				User users=new User();
				users.setId(rs.getInt("id"));
				users.setUserpwd(rs.getString("userpwd"));
				users.setUsername(rs.getString("username"));
				users.setSex(rs.getInt("sex"));
				users.setBirthday(rs.getTimestamp("birthday"));
				users.setBalance(rs.getDouble("balance"));
				listUsers.add(users);
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
		
		return listUsers;
	}
	//�������ս��в�ѯ
	public List<User> getUsersByBirthday(Date birthday) {
		String preparedSql="select * from users where cast(birthday as date)=?";
		ResultSet rs=null;
		Object[] param= {birthday};
		
		rs=baseDao.executeQuery(preparedSql, param);
	
		List<User> listUsers=new ArrayList<User>();
		
		try {
			int flag=0;
			while(rs.next()) {
				flag=1;
				User users=new User();
				users.setId(rs.getInt("id"));
				users.setUserpwd(rs.getString("userpwd"));
				users.setUsername(rs.getString("username"));
				users.setSex(rs.getInt("sex"));
				users.setBirthday(rs.getTimestamp("birthday"));
				users.setBalance(rs.getDouble("balance"));
				listUsers.add(users);
			}
			if(flag==0){
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Connection conn= BaseDao.conn;
			PreparedStatement pstmt=baseDao.pstmt;
			baseDao.closeAll(conn,pstmt,rs);
		}
		
		return listUsers;
	}
	
	public List<User> getUsersByBirthday(Date birthday,int offset,int limit) {
		String preparedSql="select * from users where cast(birthday as date)=? limit ? offset ?";
		ResultSet rs=null;
		Object[] param= {birthday,limit,offset};
		
		rs=baseDao.executeQuery(preparedSql, param);
	
		List<User> listUsers=new ArrayList<User>();
		
		try {
			int flag=0;
			while(rs.next()) {
				flag=1;
				User users=new User();
				users.setId(rs.getInt("id"));
				users.setUserpwd(rs.getString("userpwd"));
				users.setUsername(rs.getString("username"));
				users.setSex(rs.getInt("sex"));
				users.setBirthday(rs.getTimestamp("birthday"));
				users.setBalance(rs.getDouble("balance"));
				listUsers.add(users);
			}
			if(flag==0)
			{
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Connection conn= BaseDao.conn;
			PreparedStatement pstmt=baseDao.pstmt;
			baseDao.closeAll(conn,pstmt,rs);
		}
		
		return listUsers;
	}
	//��Ѱ���id
	public int getMaxId() {
		String preparedSql="select max(id) as max_id from users";
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
	//��ȡ���ݿ���������
	public int getNumOfUsers() {
		String preparedSql="SELECT COUNT(*) as sum FROM users";
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
    //ͨ���û�����ȡ�û�����
	public int getNumOfUsersByUsername(String username) {
		String preparedSql="SELECT COUNT(*) as sum FROM users where username=?";
		ResultSet rs=null;
		Object[] param= {username};
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
	//ͨ���Ա��ȡ�û�����
	public int getNumOfUsersBySex(int sex) {
		String preparedSql="SELECT COUNT(*) as sum FROM users where sex=?";
		ResultSet rs=null;
		Object[] param= {sex};
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
	
	//ͨ�����ջ�ȡ�û�����
	public int getNumOfUsersByBirthday(Date birthday) {
		String preparedSql="SELECT COUNT(*) as sum FROM users where cast(birthday as date)=?";
		ResultSet rs=null;
		Object[] param= {birthday};
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
	
	
	
	//������
	public void testSaveUsers() {
		UsersDao usersDao=new UsersDao();
		User users=new User();
		users.setId(8888);
		users.setUsername("ɽ��");
		users.setUserpwd("123456");
		users.setSex(1);
		users.setBirthday(Timestamp.valueOf("2024-01-01 01:01:01"));
		
		int count=usersDao.saveUsers(users);
		System.out.println("count="+count);
		
	}
	//���Բ�ѯ����
	public void testGetUsers() {
		UsersDao usersDao=new UsersDao();
		List<User> listUsers=new ArrayList<User>();
		listUsers=usersDao.getUsers();
		System.out.println(listUsers.size());
	}
	public static void main(String[] args){
		//UsersDao usersDao=new UsersDao();
		//usersDao.testSaveUsers();
		//usersDao.testGetUsers();
	}
}
