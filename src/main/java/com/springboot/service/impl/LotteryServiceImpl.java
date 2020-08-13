package com.springboot.service.impl;

import com.springboot.dao.LotteryDao;
import com.springboot.entity.Lottery;
import com.springboot.page.Pager;
import com.springboot.service.LotteryService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
@Service("lotteryService")
public class LotteryServiceImpl implements LotteryService{
    @Autowired
    private LotteryDao lotteryDao;

    //显示信息
    public List<Lottery> showAllLotteryResult(String[] paras){
        List<Lottery> al=lotteryDao.showAllLottery(paras[0], paras[1]);
        return al;
    }
    public Pager<Lottery> showPager(Lottery lotteryResultPojo, int pageNum, int pageSize, String[] paras) {
        Pager<Lottery> pager = new Pager<Lottery>(pageNum, pageSize, showAllLotteryResult(paras));
        return pager;
    }

    //更新信息
    public ArrayList<Lottery> beforeUpdateLotteryResult(String paras){
        ArrayList<Lottery> ll=lotteryDao.beforeUpdateLotteryResult(paras);
        return ll;
    }
    public void updateLotteryResult(Lottery lottery){
        lotteryDao.updateLotteryResult(lottery);
    }

    //添加信息
    public void addLotteryResult(Lottery lottery){
        lotteryDao.addLotteryResult(lottery);
    }

    //删除信息
    public void deleteLotteryResult(String paras){
        lotteryDao.deleteLotteryResult(paras);
    }

    //上传信息
    public static int columuSize=9;
    public String readExcel(String filePath){
        /*	System.out.println("hello");*/
        String sucess="上传失败";
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
            Object paras[][] = new Object[rows][column];
            int count = 0;
            if (rows > 0) {
                for (int r = 1; r < rows; r++) {
                    Row row = sheet.getRow(r);
                    if (row != null) {
                        Cell cell0=row.getCell(0);
                        Cell cell1=row.getCell(1);
                        Cell cell2=row.getCell(2);
                        Cell cell3=row.getCell(3);
                        Cell cell4=row.getCell(4);
                        Cell cell5=row.getCell(5);
                        Cell cell6=row.getCell(6);
                        Cell cell7=row.getCell(7);
                        Cell cell8=row.getCell(8);

                        String cellvalue0=getValue(cell0);
                        String cellvalue1=getValue(cell1);
                        int cellvalue2=Integer.parseInt(getValue(cell2));
                        int cellvalue3=Integer.parseInt(getValue(cell3));
                        int cellvalue4=Integer.parseInt(getValue(cell4));
                        int cellvalue5=Integer.parseInt(getValue(cell5));
                        int cellvalue6=Integer.parseInt(getValue(cell6));
                        int cellvalue7=Integer.parseInt(getValue(cell7));
                        int cellvalue8=Integer.parseInt(getValue(cell8));
                        Calendar cal = Calendar.getInstance();
                        cal.set(2017, 0, 1);
                        cal.add(Calendar.DAY_OF_MONTH, Integer.valueOf(cellvalue1)-42736);
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
                        paras[count][0] = cellvalue0;
                        paras[count][1] = date;
                        paras[count][2] = cellvalue2;
                        paras[count][3] = cellvalue3;
                        paras[count][4] = cellvalue4;
                        paras[count][5] = cellvalue5;
                        paras[count][6] = cellvalue6;
                        paras[count][7] = cellvalue7;
                        paras[count][8] = cellvalue8;
                        count++;
                    }
                }
                in.close();
                for(int i=0;i<count;i++){
                    String sql="insert into lotteryresult (phase,date,red1,red2,red3,red4,red5,blue1,blue2) values(?,?,?,?,?,?,?,?,?)";
                    //Object object[]={paras[i][0],paras[i][1],paras[i][2],paras[i][3],paras[i][4],paras[i][5],paras[i][6],paras[i][7],paras[i][8]};
                    Lottery lottery=new Lottery();
                    lottery.setPhase(Integer.valueOf(paras[i][0].toString()));
                    lottery.setDate(paras[i][1].toString());
                    lottery.setRed1(Integer.valueOf(paras[i][2].toString()));
                    lottery.setRed2(Integer.valueOf(paras[i][3].toString()));
                    lottery.setRed3(Integer.valueOf(paras[i][4].toString()));
                    lottery.setRed4(Integer.valueOf(paras[i][5].toString()));
                    lottery.setRed5(Integer.valueOf(paras[i][6].toString()));
                    lottery.setBlue1(Integer.valueOf(paras[i][7].toString()));
                    lottery.setBlue2(Integer.valueOf(paras[i][8].toString()));
                    lotteryDao.addLotteryResult(lottery);
                }
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
    public List<Lottery> exportPlan(String[] paras){
        List<Lottery> al = lotteryDao.showAllLottery(paras[0], paras[1]);
        return al;
    }

    //展示报表
    public int[] showLotteryResultChart(String[] paras,String type){
        int redone1=0,redone2=0,redone3=0,redone4=0,redone5=0,redone6=0,redone7=0,redone8=0,redone9=0,redone10=0,redone11=0,redone12=0,redone13=0,redone14=0,redone15=0,redone16=0,redone17=0,redone18=0,redone19=0,redone20=0,redone21=0,redone22=0,redone23=0,redone24=0,redone25=0,redone26=0,redone27=0,redone28=0,redone29=0,redone30=0,redone31=0,redone32=0,redone33=0,redone34=0,redone35=0,redoneothers=0;
        int quantityone[]={redone1,redone2,redone3,redone4,redone5,redone6,redone7,redone8,redone9,redone10,redone11,redone12,redone13,redone14,redone15,redone16,redone17,redone18,redone19,redone20,redone21,redone22,redone23,redone24,redone25,redone26,redone27,redone28,redone29,redone30,redone31,redone32,redone33,redone34,redone35,redoneothers};

        List<Lottery> list= lotteryDao.showAllLottery(paras[0],paras[1]);
        if("red1".equals(type)){
            for(int i=0;i<list.size();i++){
                for(int j=1;j<36;j++){
                    if(j==list.get(i).getRed1()){
                        quantityone[j-1]++;
                    }
                }
            }
        }else if("red2".equals(type)){
            for(int i=0;i<list.size();i++){
                for(int j=1;j<36;j++){
                    if(j==list.get(i).getRed2()){
                        quantityone[j-1]++;
                    }
                }
            }
        }else if("red3".equals(type)){
            for(int i=0;i<list.size();i++){
                for(int j=1;j<36;j++){
                    if(j==list.get(i).getRed3()){
                        quantityone[j-1]++;
                    }
                }
            }
        }else if("red4".equals(type)){
            for(int i=0;i<list.size();i++){
                for(int j=1;j<36;j++){
                    if(j==list.get(i).getRed4()){
                        quantityone[j-1]++;
                    }
                }
            }
        }else if("red5".equals(type)){
            for(int i=0;i<list.size();i++){
                for(int j=1;j<36;j++){
                    if(j==list.get(i).getRed5()){
                        quantityone[j-1]++;
                    }
                }
            }
        }else if("blue1".equals(type)){
            for(int i=0;i<list.size();i++){
                for(int j=1;j<36;j++){
                    if(j==list.get(i).getBlue1()){
                        quantityone[j-1]++;
                    }
                }
            }
        }else if("blue2".equals(type)){
            for(int i=0;i<list.size();i++){
                for(int j=1;j<36;j++){
                    if(j==list.get(i).getBlue2()){
                        quantityone[j-1]++;
                    }
                }
            }
        }
        return quantityone;
    }
}
