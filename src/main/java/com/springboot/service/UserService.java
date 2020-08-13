package com.springboot.service;

import com.springboot.entity.Lottery;
import com.springboot.entity.User;
import com.springboot.page.Pager;

import java.util.ArrayList;
import java.util.List;

public interface UserService {
    List<User> userLogin(String name, String password);

    //显示信息
    public List<User> showAllUser(String[] paras);
    public Pager<User> showPager(User user, int pageNum, int pageSize, String[] paras);

    //更新信息
    public ArrayList<User> beforeUpdateUser(String paras);
    public void updateUser(User user);

    //添加信息
    public void addUser(User user);

    //删除信息
    public void deleteUser(String paras);
}
