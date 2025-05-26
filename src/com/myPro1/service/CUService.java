package com.myPro1.service;

import com.myPro1.dao.CUDao;
import com.myPro2.bean.CU;

public class CUService {
	CUDao cuDao=new CUDao();
	public int saveCURecord(CU cu) {
		return cuDao.saveCURecord(cu);
	}
}
