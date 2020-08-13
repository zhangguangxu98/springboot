package com.springboot.dao;

import com.springboot.entity.Lottery;
import com.springboot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Mapper
public interface UserDao {
    List<User> userLogin(String name, String password);

    //显示信息
    List<User> showAllUser(String name);

    //更新信息
    public ArrayList<User> beforeUpdateUser(String paras);
    public void updateUser(User user);

    //添加信息
    public void addUser(User user);

    //删除信息
    public void deleteUser(String phase);
}
