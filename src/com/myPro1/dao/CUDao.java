package com.myPro1.dao;


import com.myPro2.bean.CU;


public class CUDao {
	BaseDao baseDao=new BaseDao();
	public int saveCURecord(CU cu) {
		int count=0;
		//preparedSql:�ַ���sql���
		//?,?,?,?,?:ռλ��
		String preparedSql="insert into CU(userId,commodityId)values(?,?)";
		Object[] param={cu.getUserId(),cu.getCommodityId()};
		count=baseDao.excuteUpdate(preparedSql, param);
		return count;
	}
	//��ȡ������Ϣ
	
}
