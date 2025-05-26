package com.myPro1.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.myPro1.dao.UsersDao;
import com.myPro2.bean.User;

//users��ҵ���߼���
public class UsersService {
    UsersDao usersDao = new UsersDao();

    //�õ�users�����еĵ����ݣ�List<Users>�����ͣ����������͵����飩
    public List<User> getUsers() {

        List<User> usersList = new ArrayList<User>();
        usersList = usersDao.getUsers();
        //�����Ҫ�����߼��������������....

        return usersList;
    }

    public List<User> getUsers(int offset, int limit) {

        List<User> usersList = new ArrayList<User>();
        usersList = usersDao.getUsers(offset, limit);
        //�����Ҫ�����߼��������������....

        return usersList;
    }

    public int register(User users) {
        return usersDao.saveUsers(users);
    }

    //�����û����Լ��������
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

    //�����û�������
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

    //�����Ա����
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

    //����id�޸�ɾ��
    public int delUsersById(int id) {
        return usersDao.delUsersById(id);
    }

    //����id����
    public User getUsersById(int id) {
        List<User> listUsers = new ArrayList<User>();
        listUsers = usersDao.getUsersById(id);
        if (listUsers == null) {
            return null;
        }
        return listUsers.get(0);
    }

    //�������ղ���
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

    //����id�޸�users
    public int editUsersById(User users, int id) {
        return usersDao.editUsersById(users, id);
    }

    //��ȡ���id
    public int getMaxId() {
        return usersDao.getMaxId();
    }

    //��ȡ��������
    public int getNumOfUsers() {
        return usersDao.getNumOfUsers();
    }

    //�����˻�����ȡ����
    public int getNumOfUsersByUsername(String username) {
        return usersDao.getNumOfUsersByUsername(username);
    }

    //�����Ա��ȡ�û�����
    public int getNumOfUsersBySex(int sex) {
        return usersDao.getNumOfUsersBySex(sex);
    }

    //�������ջ�ȡ�û�����
    public int getNumOfUsersByBirthday(Date birthday) {
        return usersDao.getNumOfUsersByBirthday(birthday);
    }

    //����id��ֵ
    public int rechargeUsersById(double amount, int id) {
        return usersDao.rechargeById(amount, id);
    }

    //����id����
    public int editUsersPriceById(int id, double price) {
        return usersDao.editUsersPriceById(id, price);
    }

    //����id�տ�
    public int IncreaseUsersPriceById(int id, double price) {
        return usersDao.IncreaseUsersPriceById(id, price);
    }
}
