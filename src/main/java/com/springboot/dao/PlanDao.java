package com.springboot.dao;

import com.springboot.entity.Log;
import com.springboot.entity.Plan;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface PlanDao {
    //显示信息
    List<Plan> showAllPlan(String sdate, String edate);

    //更新信息
    public ArrayList<Plan> beforeUpdatePlan(String paras);
    public void updatePlan(Plan plan);

    //添加信息
    public void addPlan(Plan plan);

    //删除信息
    public void deletePlan(String phase);

    List<Log> showLogChart(String sdate, String edate);
}
