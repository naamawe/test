package com.myPro1.service;

import java.util.ArrayList;
import java.util.List;

import com.myPro1.dao.CommodityDao;
import com.myPro2.bean.Commodity;
import com.myPro2.bean.User;

public class CommodityService {
CommodityDao commodityDao=new CommodityDao();
//保持商品
public int saveCommodity(Commodity commodity) {
	return commodityDao.saveCommodity(commodity);
}
//获取最大id
public int getMaxId(){
	return commodityDao.getMaxId();
}
//获取所有商品
public List<Commodity> getCommoditys(int offset,int limit){
	return commodityDao.getCommoditys(offset, limit);
}//获取数据库总数据量
public int getNumOfCommoditise() {
	return commodityDao.getNumOfCommoditise();
}
//根据商品id查找
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
	//根据商品名查找
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
	//根据商品类别查找
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
	//根据商品是否被购买进行查找
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
			//获取物品数量通过类型
			public int getNumOfCommodityByType(String type) {
				return commodityDao.getNumOfCommodityByType(type);
			}
			//获取物品数量通过名字
			public int getNumOfCommodityByName(String name) {
				return commodityDao.getNumOfCommodityByName(name);
			}
			//获取物品数量通过类型
			public int getNumOfCommodityByIsSold(String IsSold) {
				return commodityDao.getNumOfCommodityByIsSold(IsSold);
			}
			//通过用户id和商品id修改数据
			public int editCommodityByUserIdandCommodityId(int userId,int commodityId,int buyId) {
				return commodityDao.editCommodityByUserIdandCommodityId(userId, commodityId, buyId);
			}
	
	
}
