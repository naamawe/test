package com.myPro2.bean;

/**
 * @author master
 */
public class ShoppingCart {
    private int userId;
    private int commodityId;

    public ShoppingCart(int userId, int commodityId) {
        this.userId = userId;
        this.commodityId = commodityId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(int commodityId) {
        this.commodityId = commodityId;
    }
}
