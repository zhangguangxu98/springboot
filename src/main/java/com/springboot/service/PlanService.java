package com.springboot.service;

import com.springboot.entity.Log;
import com.springboot.entity.Plan;
import com.springboot.page.Pager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface PlanService {
    //显示信息
    public List<Plan> showAllPlan(String[] paras);
    public Pager<Plan> showPager(Plan plan, int pageNum, int pageSize, String[] paras);

    //更新信息
    public ArrayList<Plan> beforeUpdatePlan(String paras);
    public void updatePlan(Plan plan);

    //添加信息
    public void addPlan(Plan plan);

    //删除信息
    public void deletePlan(String paras);

    //上传信息
    public String readExcel(String filePath);
    //下载信息
    public List<Plan> exportPlan(String[] paras);

    //展示报表
    public Map<String,Integer> showPlanChart(String[] paras);

}
