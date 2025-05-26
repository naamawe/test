package com.myPro1.dao;

import java.sql.*;
import java.util.List;

import com.myPro2.bean.User;


public class BaseDao {
	//�������ݿ�(���ݿ�����)
	//�������������ݿ��еõ������ݷ�����У�
	ResultSet rs=null;
	static Connection conn=null;//�������Ӷ���
	PreparedStatement pstmt=null;
	
	//��ͨ���ݿ�����
	private static Connection getConnection() {
		conn=null; //�������Ӷ���
		//�������ݿ�����
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
	//ʹ���������������ݿ�����
	public void closeAll(Connection conn,PreparedStatement pstmt,ResultSet rs) {
		//�ر�Ҫ�����ʼ
		if(rs!=null) {
			try {
			rs.close();
			}catch(SQLException e){
				System.out.println("rs�ر�ʧ��:"+e.getMessage());
			}
		}
		if(pstmt!=null) {
			try {
			pstmt.close();
			}catch(SQLException e){
				System.out.println("pstmt�ر�ʧ��:"+e.getMessage());
			}
		}
		if(conn!=null) {
			try {
			conn.close();
			}catch(SQLException e){
				System.out.println("conn�ر�ʧ��:"+e.getMessage());
			}
		}
	}
	
	/*
	 * ִ��sql��䣬������ɾ��(����)���������ܽ��в�ѯ
	 * @param preparedSql:Ҫִ�е�sql���(�ַ���)
	 * @param param:���ݸ�sql���Ĳ���
	 * @return: ִ�е���������
	 */
	public int excuteUpdate(String preparedSql,Object[] param) {
		Connection conn=null;
		pstmt=null;//Ԥ����ִ�ж���(��ֹsqlע��)
		int num=0;//����ִ�н������(��������ִ�е�����)
		
		conn=getConnection();
		try {
			pstmt=conn.prepareStatement(preparedSql);
			if(pstmt!=null) {
				for(int i=0;i<param.length;i++) {
					pstmt.setObject(i+1, param[i]);
				}
			}
			//ִ��sql��䣬����ִ������
			num=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//������ζ�Ҫִ��
			if(pstmt!=null&&conn!=null) {
				closeAll(conn,pstmt,null);
			}
		}
		
		
		return num;
	}
	
	/**
	 * ִ��sql��䣬���в�ѯ�����ܽ�����ɾ�ģ����£�����
	 * @param preparedSql ��Ҫִ�е�sql��䣨�ַ�����
	 * @param param�����ݸ�sql���Ĳ���
	 * @return �����
	 */
	public ResultSet executeQuery(String preparedSql, Object[] param) {
		conn = getConnection(); // ʹ��ʵ�����������Ǿֲ�����
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
