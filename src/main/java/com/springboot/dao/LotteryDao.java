package com.springboot.dao;

import com.springboot.entity.Lottery;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface LotteryDao {

    //显示信息
    List<Lottery> showAllLottery(String sdate, String edate);

    //更新信息
    public ArrayList<Lottery> beforeUpdateLotteryResult(String paras);
    public void updateLotteryResult(Lottery lottery);

    //添加信息
    public void addLotteryResult(Lottery lottery);

    //删除信息
    public void deleteLotteryResult(String phase);
}
