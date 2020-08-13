package com.springboot.service.impl;

import com.springboot.entity.Log;
import com.springboot.dao.LogDao;
import com.springboot.entity.Lottery;
import com.springboot.page.Pager;
import com.springboot.service.LogService;
import com.springboot.util.StringUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service("logService")
public class LogServiceImpl implements LogService {
    @Resource
    private LogDao logDao;
    //显示信息
    public List<Log> showAllLog(String[] paras){
        List<Log> al=logDao.showAllLog(paras[0], paras[1]);
        return al;
    }
    public Pager<Log> showPager(Log log, int pageNum, int pageSize, String[] paras) {
        Pager<Log> pager = new Pager<Log>(pageNum, pageSize, showAllLog(paras));
        return pager;
    }

    //更新信息
    public ArrayList<Log> beforeUpdateLog(String paras){
        ArrayList<Log> ll=logDao.beforeUpdateLog(paras);
        return ll;
    }
    public void updateLog(Log log){
        logDao.updateLog(log);
    }

    //添加信息
    public void addLog(Log log){
        logDao.addLog(log);
    }

    //删除信息
    public void deleteLog(String paras){
        logDao.deleteLog(paras);
    }

    //上传信息
    public static int columuSize=32;
    public String readExcel(String filePath){
        String sucess="";
        try {
            Workbook workBook = null;
            FileInputStream in = new FileInputStream(filePath);
            try {
                workBook = new XSSFWorkbook(in);
            } catch (Exception ex) {
                workBook = new HSSFWorkbook(in);
            }
            int column=columuSize;
            Sheet sheet = workBook.getSheetAt(0);
            int rows = sheet.getPhysicalNumberOfRows();
            System.out.println("共有===" + rows + "===行");
            Row roww = sheet.getRow(1);
            System.out.println("共有 ===" + roww.getLastCellNum()+ "===列");
            String paras[][] = new String[rows][column];
            int count = 0;
            if (rows > 0) {
                for (int r = 1; r < rows; r++) {
                    Row row = sheet.getRow(r);
                    if (row != null) {
                        Cell[] cell=new Cell[32];
                        for(int i=0;i<cell.length;i++){
                            cell[i]=row.getCell(i);
                            paras[count][i] = getValue(cell[i]);
                            if(i==1){
                                Calendar cal = Calendar.getInstance();
                                cal.set(2017, 0, 1);
                                cal.add(Calendar.DAY_OF_MONTH, Integer.valueOf((String) paras[count][1])-42736);
                                String date=(cal.get(Calendar.YEAR) + "-");
                                if((cal.get(Calendar.MONTH))<9){
                                    date+="0"+(cal.get(Calendar.MONTH) + 1 + "-");
                                }else{
                                    date+=cal.get(Calendar.MONTH) + 1 + "-";
                                }
                                if((cal.get(Calendar.DAY_OF_MONTH))<10){
                                    date+="0"+(cal.get(Calendar.DAY_OF_MONTH));
                                }else{
                                    date+=cal.get(Calendar.DAY_OF_MONTH);
                                }
                                paras[count][1]=date;
                            }
                            for(int j=0;j<paras[count].length;j++){
                                if(StringUtil.isEmpty(paras[count][j])){
                                    paras[count][j]="0";
                                }
                            }
                        }
                        Log myLogPojo=new Log();
                        myLogPojo.setId(Integer.valueOf(paras[count][0]));
                        myLogPojo.setDate((String)paras[count][1]);
                        myLogPojo.setHome(Integer.valueOf(paras[count][2]));
                        myLogPojo.setClothes(Integer.valueOf(paras[count][3]));
                        myLogPojo.setMeal(Integer.valueOf(paras[count][4]));
                        myLogPojo.setRoom(Integer.valueOf(paras[count][5]));
                        myLogPojo.setTrip(Integer.valueOf(paras[count][6]));
                        myLogPojo.setLifeuse(Integer.valueOf(paras[count][7]));
                        myLogPojo.setPlay(Integer.valueOf(paras[count][8]));
                        myLogPojo.setInsurance(Integer.valueOf(paras[count][9]));
                        myLogPojo.setPretaxincome(Integer.valueOf(paras[count][10]));
                        myLogPojo.setIdroutine(paras[count][11]);
                        myLogPojo.setDateroutine(paras[count][12]);
                        myLogPojo.setHomeroutine(paras[count][13]);
                        myLogPojo.setClothesroutine(paras[count][14]);
                        myLogPojo.setMealroutine(paras[count][15]);
                        myLogPojo.setRoomroutine(paras[count][16]);
                        myLogPojo.setTriproutine(paras[count][17]);
                        myLogPojo.setUseroutine(paras[count][18]);
                        myLogPojo.setPlayroutine(paras[count][19]);
                        myLogPojo.setInsuranceroutine(paras[count][20]);
                        myLogPojo.setSelfcontrol(paras[count][21]);
                        myLogPojo.setDiligence(paras[count][22]);
                        myLogPojo.setGoodorder(paras[count][23]);
                        myLogPojo.setClean(paras[count][24]);
                        myLogPojo.setFrugality(paras[count][25]);
                        myLogPojo.setHonest(paras[count][26]);
                        myLogPojo.setIntegrity(paras[count][27]);
                        myLogPojo.setModest(paras[count][28]);
                        myLogPojo.setFriendly(paras[count][29]);
                        myLogPojo.setTolerant(paras[count][30]);
                        myLogPojo.setDiary(paras[count][31]);

                        for(int i=0;i<logDao.showAllLog("","").size();i++){
                            if((Integer.valueOf(paras[count][0]))==logDao.showAllLog("","").get(i).getId()){
                                sucess="序号不能重复,添加失败";
                            }
                        }
                        if("".equals(sucess)){
                            logDao.addLog(myLogPojo);
                        }
                        count++;
                    }
                }
                in.close();
                sucess="上传成功";
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return sucess;
    }
    public String getValue(Cell cell) {
        String value = "";
        if(cell==null){
            value="";
        }else{
            if(cell.getCellType()==0){
                value=(int)cell.getNumericCellValue()+"";
            }else if(cell.getCellType()==1){
                System.out.println("getvalue");
                value = cell.getStringCellValue();
            }else if(cell.getCellType()==2){
                value="";
            }else if(cell.getCellType()==3){
                value="";
            }else if(cell.getCellType()==4){
                value="";
            }else if(cell.getCellType()==5){
                value="";
            }else{
                value="";
            }
        }
        return value;
    }
    //下载信息
    public List<Log> exportLog(String[] paras){
        List<Log> al = logDao.showAllLog(paras[0], paras[1]);
        return al;
    }

    //展示报表
    public int[] showLogChart(String[] paras){
        int money[]=new int[10];

        List<Log> list= logDao.showAllLog(paras[0],paras[1]);
        for(int i=0;i<list.size();i++){
             money[0]+=list.get(i).getHome();
        }
        for(int i=0;i<list.size();i++){
            money[1]+=list.get(i).getClothes();
        }
        for(int i=0;i<list.size();i++){
            money[2]+=list.get(i).getMeal();
        }
        for(int i=0;i<list.size();i++){
            money[3]+=list.get(i).getRoom();
        }
        for(int i=0;i<list.size();i++){
            money[4]+=list.get(i).getTrip();
        }
        for(int i=0;i<list.size();i++){
            money[5]+=list.get(i).getLifeuse();
        }
        for(int i=0;i<list.size();i++){
            money[6]+=list.get(i).getPlay();
        }
        for(int i=0;i<list.size();i++){
            money[7]+=list.get(i).getInsurance();
        }
        for(int i=0;i<list.size();i++){
            money[8]+=list.get(i).getPretaxincome();
        }
        for(int i=0;i<money.length-3;i++){
            money[9]+=money[i];
        }

        return money;
    }
}
