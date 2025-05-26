package com.myPro1.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.myPro1.dao.UsersDao;
import com.myPro2.bean.User;

//users的业务逻辑层
public class UsersService {
    UsersDao usersDao = new UsersDao();

    //得到users表所有的的数据；List<Users>：泛型（有数据类型的数组）
    public List<User> getUsers() {

        List<User> usersList = new ArrayList<User>();
        usersList = usersDao.getUsers();
        //如果需要数据逻辑处理，在这里进行....

        return usersList;
    }

    public List<User> getUsers(int offset, int limit) {

        List<User> usersList = new ArrayList<User>();
        usersList = usersDao.getUsers(offset, limit);
        //如果需要数据逻辑处理，在这里进行....

        return usersList;
    }

    public int register(User users) {
        return usersDao.saveUsers(users);
    }

    //根据用户名以及密码查找
    public User getUsersByNameAndPwd(String usersname, String pwd) {
        User users;
        List<User> listUsers;
        listUsers = usersDao.getUsersByNameAndPwd(usersname, pwd);
        if (listUsers != null) {
            users = listUsers.get(0);
            return users;
        }
        return null;
    }

    //根据用户名查找
    public List<User> getUsersByUsername(String username) {
        List<User> listUsers = new ArrayList<User>();
        listUsers = usersDao.getUsersByUsername(username);
        if (listUsers == null) {
            return null;
        }
        return listUsers;
    }

    public List<User> getUsersByUsername(String username, int offset, int limit) {
        List<User> listUsers = new ArrayList<User>();
        listUsers = usersDao.getUsersByUsername(username, offset, limit);
        if (listUsers == null) {
            return null;
        }
        return listUsers;
    }

    //根据性别查找
    public List<User> getUsersBySex(int sex) {
        List<User> listUsers = new ArrayList<User>();
        listUsers = usersDao.getUsersBySex(sex);
        if (listUsers == null) {
            return null;
        }
        return listUsers;
    }

    public List<User> getUsersBySex(int sex, int offset, int limit) {
        List<User> listUsers = new ArrayList<User>();
        listUsers = usersDao.getUsersBySex(sex, offset, limit);
        if (listUsers == null) {
            return null;
        }
        return listUsers;
    }

    //根据id修改删除
    public int delUsersById(int id) {
        return usersDao.delUsersById(id);
    }

    //根据id查找
    public User getUsersById(int id) {
        List<User> listUsers = new ArrayList<User>();
        listUsers = usersDao.getUsersById(id);
        if (listUsers == null) {
            return null;
        }
        return listUsers.get(0);
    }

    //根据生日查找
    public List<User> getUsersByBirthday(Date birthday) {
        List<User> listUsers = new ArrayList<User>();
        listUsers = usersDao.getUsersByBirthday(birthday);
        if (listUsers == null) {
            return null;
        }
        return listUsers;
    }

    public List<User> getUsersByBirthday(Date birthday, int offset, int limit) {
        List<User> listUsers = new ArrayList<User>();
        listUsers = usersDao.getUsersByBirthday(birthday, offset, limit);
        if (listUsers == null) {
            return null;
        }
        return listUsers;
    }

    //根据id修改users
    public int editUsersById(User users, int id) {
        return usersDao.editUsersById(users, id);
    }

    //获取最大id
    public int getMaxId() {
        return usersDao.getMaxId();
    }

    //获取数据总数
    public int getNumOfUsers() {
        return usersDao.getNumOfUsers();
    }

    //根据账户名获取数量
    public int getNumOfUsersByUsername(String username) {
        return usersDao.getNumOfUsersByUsername(username);
    }

    //根据性别获取用户数量
    public int getNumOfUsersBySex(int sex) {
        return usersDao.getNumOfUsersBySex(sex);
    }

    //根据生日获取用户数量
    public int getNumOfUsersByBirthday(Date birthday) {
        return usersDao.getNumOfUsersByBirthday(birthday);
    }

    //根据id充值
    public int rechargeUsersById(double amount, int id) {
        return usersDao.rechargeById(amount, id);
    }

    //根据id付款
    public int editUsersPriceById(int id, double price) {
        return usersDao.editUsersPriceById(id, price);
    }

    //根据id收款
    public int IncreaseUsersPriceById(int id, double price) {
        return usersDao.IncreaseUsersPriceById(id, price);
    }
}
