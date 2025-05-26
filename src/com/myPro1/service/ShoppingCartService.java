package com.myPro1.service;

import java.util.List;

import com.myPro1.action.AddShoppingCartServlet;
import com.myPro1.dao.ShoppingCartDao;
import com.myPro2.bean.Commodity;
import com.myPro2.bean.ShoppingCart;

public class ShoppingCartService {
ShoppingCartDao shoppingCartDao=new ShoppingCartDao();
//��Ӽ�¼
public int AddShoppingCartById(ShoppingCart shoppingCart) {
	return shoppingCartDao.addShoppingCart(shoppingCart);
}
//��ѯ��Ӧ�Ĺ��ﳵ��¼�Ƿ����
public List<ShoppingCart> getShoppingCartByCommodityIdAndUserId(ShoppingCart shoppingCart){
	return shoppingCartDao.getShoppingCartByCommodityIdAndUserId(shoppingCart);
}
//��ȡ��Ӧ�˵�ȫ�����ﳵ
public List<Commodity> getShoppingCartByCommodityId(int userId,int offset,int limit) {
	return shoppingCartDao.getShoppingCartByCommodityId(userId, offset, limit);
}
//��ȡ��Ӧ�˵�ȫ�����ﳵ����
public int getNumOfshoppingCartByUserId(int userId) {
	return shoppingCartDao.getNumOfshoppingCartByUserId(userId);
}
//���ݶ�Ӧ�����Լ���Ʒ���Ͳ�ѯ��Ʒ
public List<Commodity> getShoppingCartByType(int userId,String type,int offset,int limit){
	return shoppingCartDao.getShoppingCartByType(userId, type, offset, limit);
}
//���ݶ�Ӧ�����Լ���Ʒ���͹��ﳵ����
public int getNumOfshoppingCartByType(int userId,String type) {
	return shoppingCartDao.getNumOfshoppingCartByType(userId, type);
}
//������Ʒ�ź������ɾ�����ﳵ��¼
public int delShoppingCartByCommodityIdAndUserId(int userId,int comodityId) {
	return shoppingCartDao.delShoppingCartByCommodityIdAndUserId(userId, comodityId);
}
//������Ʒ��ɾ����¼
public int delShoppingCartByCommodityId(int comodityId) {
	return shoppingCartDao.delShoppingCartByCommodityId(comodityId);
}
//�����û�idɾ�����ﳵ��¼
public int delShoppingCartByUserId(int userId) {
	return shoppingCartDao.delShoppingCartByUserId(userId);
}
//�����û�id����Ʒid�����ѯ��Ʒ��Ϣ
public List<Commodity> getShoppingCartByCommodityId(int userId){
	return shoppingCartDao.getShoppingCartByCommodityId(userId);
}
}
