package com.myPro1.service;

import java.util.List;

import com.myPro1.action.AddShoppingCartServlet;
import com.myPro1.dao.ShoppingCartDao;
import com.myPro2.bean.Commodity;
import com.myPro2.bean.ShoppingCart;

public class ShoppingCartService {
ShoppingCartDao shoppingCartDao=new ShoppingCartDao();
//添加记录
public int AddShoppingCartById(ShoppingCart shoppingCart) {
	return shoppingCartDao.addShoppingCart(shoppingCart);
}
//查询对应的购物车记录是否存在
public List<ShoppingCart> getShoppingCartByCommodityIdAndUserId(ShoppingCart shoppingCart){
	return shoppingCartDao.getShoppingCartByCommodityIdAndUserId(shoppingCart);
}
//获取对应人的全部购物车
public List<Commodity> getShoppingCartByCommodityId(int userId,int offset,int limit) {
	return shoppingCartDao.getShoppingCartByCommodityId(userId, offset, limit);
}
//获取对应人的全部购物车数量
public int getNumOfshoppingCartByUserId(int userId) {
	return shoppingCartDao.getNumOfshoppingCartByUserId(userId);
}
//根据对应的人以及商品类型查询商品
public List<Commodity> getShoppingCartByType(int userId,String type,int offset,int limit){
	return shoppingCartDao.getShoppingCartByType(userId, type, offset, limit);
}
//根据对应的人以及商品类型购物车数量
public int getNumOfshoppingCartByType(int userId,String type) {
	return shoppingCartDao.getNumOfshoppingCartByType(userId, type);
}
//根据商品号和人物号删除购物车记录
public int delShoppingCartByCommodityIdAndUserId(int userId,int comodityId) {
	return shoppingCartDao.delShoppingCartByCommodityIdAndUserId(userId, comodityId);
}
//根据商品号删除记录
public int delShoppingCartByCommodityId(int comodityId) {
	return shoppingCartDao.delShoppingCartByCommodityId(comodityId);
}
//根据用户id删除购物车记录
public int delShoppingCartByUserId(int userId) {
	return shoppingCartDao.delShoppingCartByUserId(userId);
}
//根据用户id和商品id连表查询商品信息
public List<Commodity> getShoppingCartByCommodityId(int userId){
	return shoppingCartDao.getShoppingCartByCommodityId(userId);
}
}
