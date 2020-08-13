package com.springboot.service;

import com.springboot.entity.Lottery;
import com.springboot.page.Pager;

import java.util.ArrayList;
import java.util.List;

public interface LotteryService {
    //显示信息
    public List<Lottery> showAllLotteryResult(String[] paras);
    public Pager<Lottery> showPager(Lottery lottery, int pageNum, int pageSize, String[] paras);

    //更新信息
    public ArrayList<Lottery> beforeUpdateLotteryResult(String paras);
    public void updateLotteryResult(Lottery lottery);

    //添加信息
    public void addLotteryResult(Lottery lottery);

    //删除信息
    public void deleteLotteryResult(String paras);

    //上传信息
    public String readExcel(String filePath);
    //下载信息
    public List<Lottery> exportPlan(String[] paras);

    //展示报表
    public int[] showLotteryResultChart(String[] paras,String type);

}
