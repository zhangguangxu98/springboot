package com.springboot.service.impl;

import com.springboot.entity.Lottery;
import com.springboot.page.Pager;
import com.springboot.service.UserService;
import com.springboot.dao.UserDao;
import com.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> userLogin(String name, String password) {
        return userDao.userLogin(name,password);
    }

    //显示信息
    public List<User> showAllUser(String[] paras){
        List<User> al=userDao.showAllUser(paras[0]);
        return al;
    }
    public Pager<User> showPager(User user, int pageNum, int pageSize, String[] paras) {
        Pager<User> pager = new Pager<User>(pageNum, pageSize, showAllUser(paras));
        return pager;
    }

    //更新信息
    public ArrayList<User> beforeUpdateUser(String paras){
        ArrayList<User> ll=userDao.beforeUpdateUser(paras);
        return ll;
    }
    public void updateUser(User user){
        userDao.updateUser(user);
    }

    //添加信息
    public void addUser(User user){
        userDao.addUser(user);
    }

    //删除信息
    public void deleteUser(String paras){
        userDao.deleteUser(paras);
    }


}
