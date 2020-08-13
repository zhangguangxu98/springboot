package com.springboot.dao;

import com.springboot.entity.Log;
import com.springboot.entity.Lottery;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface LogDao {
    //显示信息
    List<Log> showAllLog(String sdate, String edate);

    //更新信息
    public ArrayList<Log> beforeUpdateLog(String paras);
    public void updateLog(Log log);

    //添加信息
    public void addLog(Log log);

    //删除信息
    public void deleteLog(String phase);

    List<Log> showLogChart(String sdate, String edate);
}
