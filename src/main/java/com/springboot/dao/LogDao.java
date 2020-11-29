package com.springboot.dao;

import com.springboot.entity.Log;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface LogDao {
    //显示信息
    List<Log> showAllLog(String sdate, String edate);

    //更新信息
    public ArrayList<Log> beforeUpdateLog(String paras);
    public void updateLog(Log log);

    //添加信息之前
    public Log beforeAddLog();
    //添加信息
    public void addLog(Log log);

    //删除信息
    public void deleteLog(String phase);

    //List<Log> showLogChart(String sdate, String edate);
}
