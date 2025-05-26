package com.myPro1.service;

import java.util.ArrayList;
import java.util.List;

import com.myPro1.dao.CommodityDao;
import com.myPro2.bean.Commodity;
import com.myPro2.bean.User;

public class CommodityService {
CommodityDao commodityDao=new CommodityDao();
//������Ʒ
public int saveCommodity(Commodity commodity) {
	return commodityDao.saveCommodity(commodity);
}
//��ȡ���id
public int getMaxId(){
	return commodityDao.getMaxId();
}
//��ȡ������Ʒ
public List<Commodity> getCommoditys(int offset,int limit){
	return commodityDao.getCommoditys(offset, limit);
}//��ȡ���ݿ���������
public int getNumOfCommoditise() {
	return commodityDao.getNumOfCommoditise();
}
//������Ʒid����
	public Commodity getCommodityById(int commodityId) {
		List<Commodity> listCommodities=new ArrayList<Commodity>();
		listCommodities=commodityDao.getCommodityById(commodityId);
		if(listCommodities==null) {
			return null;
		}
		return listCommodities.get(0);
	}
	public Commodity getCommodityById(int commodityId,int offset,int limit) {
		List<Commodity> listCommodities=new ArrayList<Commodity>();
		listCommodities=commodityDao.getCommodityById(commodityId,offset,limit);
		if(listCommodities==null) {
			return null;
		}
		return listCommodities.get(0);
	}
	//������Ʒ������
	public List<Commodity> getCommodityByname(String name) {
		List<Commodity> listCommodities=new ArrayList<Commodity>();
		listCommodities=commodityDao.getCommodityByName(name);
		if(listCommodities==null) {
			return null;
		}
		return listCommodities;
	}
	public List<Commodity> getCommodityByname(String name,int offset,int limit) {
		List<Commodity> listCommodities=new ArrayList<Commodity>();
		listCommodities=commodityDao.getCommodityByName(name,offset,limit);
		if(listCommodities==null) {
			return null;
		}
		return listCommodities;
	}
	//������Ʒ������
		public List<Commodity> getCommodityByType(String Type) {
			List<Commodity> listCommodities=new ArrayList<Commodity>();
			listCommodities=commodityDao.getCommodityByType(Type);
			if(listCommodities==null) {
				return null;
			}
			return listCommodities;
		}
		public List<Commodity> getCommodityByType(String Type,int offset,int limit) {
			List<Commodity> listCommodities=new ArrayList<Commodity>();
			listCommodities=commodityDao.getCommodityByType(Type,offset,limit);
			if(listCommodities==null) {
				return null;
			}
			return listCommodities;
		}
	//������Ʒ�Ƿ񱻹�����в���
			public List<Commodity> getCommodityByIsSold(String isSold) {
			List<Commodity> listCommodities=new ArrayList<Commodity>();
			listCommodities=commodityDao.getCommodityByIsSold(isSold);
			if(listCommodities==null) {
				return null;
			}
			return listCommodities;
			}
			public List<Commodity> getCommodityByIsSold(String isSold,int offset,int limit) {
				List<Commodity> listCommodities=new ArrayList<Commodity>();
				listCommodities=commodityDao.getCommodityByIsSold(isSold,offset,limit);
				if(listCommodities==null) {
					return null;
				}
				return listCommodities;
				}
			//��ȡ��Ʒ����ͨ������
			public int getNumOfCommodityByType(String type) {
				return commodityDao.getNumOfCommodityByType(type);
			}
			//��ȡ��Ʒ����ͨ������
			public int getNumOfCommodityByName(String name) {
				return commodityDao.getNumOfCommodityByName(name);
			}
			//��ȡ��Ʒ����ͨ������
			public int getNumOfCommodityByIsSold(String IsSold) {
				return commodityDao.getNumOfCommodityByIsSold(IsSold);
			}
			//ͨ���û�id����Ʒid�޸�����
			public int editCommodityByUserIdandCommodityId(int userId,int commodityId,int buyId) {
				return commodityDao.editCommodityByUserIdandCommodityId(userId, commodityId, buyId);
			}
	
	
}
