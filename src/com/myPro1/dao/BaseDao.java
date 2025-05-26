package com.myPro1.dao;

import java.sql.*;
import java.util.List;

import com.myPro2.bean.User;


public class BaseDao {
	//连接数据库(数据库驱动)
	//定义结果表（把数据库中得到的数据放入此中）
	ResultSet rs=null;
	static Connection conn=null;//定义链接对象
	PreparedStatement pstmt=null;
	
	//普通数据库链接
	private static Connection getConnection() {
		conn=null; //定义链接对象
		//加载数据库驱动
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","050126");
		
		}catch(ClassNotFoundException e){
			e.printStackTrace();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	//使用主方法测试数据库链接
	public void closeAll(Connection conn,PreparedStatement pstmt,ResultSet rs) {
		//关闭要从最后开始
		if(rs!=null) {
			try {
			rs.close();
			}catch(SQLException e){
				System.out.println("rs关闭失败:"+e.getMessage());
			}
		}
		if(pstmt!=null) {
			try {
			pstmt.close();
			}catch(SQLException e){
				System.out.println("pstmt关闭失败:"+e.getMessage());
			}
		}
		if(conn!=null) {
			try {
			conn.close();
			}catch(SQLException e){
				System.out.println("conn关闭失败:"+e.getMessage());
			}
		}
	}
	
	/*
	 * 执行sql语句，进行增删改(更新)操作，不能进行查询
	 * @param preparedSql:要执行的sql语句(字符串)
	 * @param param:传递给sql语句的参数
	 * @return: 执行的数据条数
	 */
	public int excuteUpdate(String preparedSql,Object[] param) {
		Connection conn=null;
		pstmt=null;//预编译执行对象(防止sql注入)
		int num=0;//定义执行结果变量(返回数据执行的条数)
		
		conn=getConnection();
		try {
			pstmt=conn.prepareStatement(preparedSql);
			if(pstmt!=null) {
				for(int i=0;i<param.length;i++) {
					pstmt.setObject(i+1, param[i]);
				}
			}
			//执行sql语句，返回执行条数
			num=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//无论如何都要执行
			if(pstmt!=null&&conn!=null) {
				closeAll(conn,pstmt,null);
			}
		}
		
		
		return num;
	}
	
	/**
	 * 执行sql语句，进行查询，不能进行增删改（更新）操作
	 * @param preparedSql ：要执行的sql语句（字符串）
	 * @param param：传递给sql语句的参数
	 * @return 结果集
	 */
	public ResultSet executeQuery(String preparedSql, Object[] param) {
		conn = getConnection(); // 使用实例变量，不是局部变量
		try {
			pstmt = conn.prepareStatement(preparedSql);
			if(pstmt != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setObject(i+1, param[i]);
				}
			}
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	

	public static void main(String[] args) {
		Connection conn=getConnection();
		System.out.println("conn="+conn);
	}
}
