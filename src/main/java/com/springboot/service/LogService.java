package com.springboot.service;

import com.springboot.entity.Log;
import com.springboot.page.Pager;

import java.util.ArrayList;
import java.util.List;

public interface LogService {
    //显示信息
    public List<Log> showAllLog(String[] paras);
    public Pager<Log> showPager(Log log, int pageNum, int pageSize, String[] paras);

    //更新信息
    public ArrayList<Log> beforeUpdateLog(String paras);
    public void updateLog(Log log);

    //添加信息之前
    public Log beforeAddLog();
    //添加信息
    public void addLog(Log log);

    //删除信息
    public void deleteLog(String paras);

    //上传信息
    public String readExcel(String filePath);
    //下载信息
    public List<Log> exportLog(String[] paras);

    //展示报表
    public int[] showLogChart(String[] paras);

}
