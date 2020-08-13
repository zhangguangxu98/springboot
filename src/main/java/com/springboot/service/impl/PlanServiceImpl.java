package com.springboot.service.impl;

import com.springboot.dao.LogDao;
import com.springboot.dao.PlanDao;
import com.springboot.entity.Log;
import com.springboot.entity.Plan;
import com.springboot.page.Pager;
import com.springboot.service.LogService;
import com.springboot.service.PlanService;
import com.springboot.util.StringUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.util.*;

@Service("planService")
public class PlanServiceImpl implements PlanService {
    @Resource
    private PlanDao planDao;
    //显示信息
    public List<Plan> showAllPlan(String[] paras){
        List<Plan> al=planDao.showAllPlan(paras[0], paras[1]);
        return al;
    }
    public Pager<Plan> showPager(Plan plan, int pageNum, int pageSize, String[] paras) {
        Pager<Plan> pager = new Pager<Plan>(pageNum, pageSize, showAllPlan(paras));
        return pager;
    }

    //更新信息
    public ArrayList<Plan> beforeUpdatePlan(String paras){
        ArrayList<Plan> ll=planDao.beforeUpdatePlan(paras);
        return ll;
    }
    public void updatePlan(Plan plan){
        planDao.updatePlan(plan);
    }

    //添加信息
    public void addPlan(Plan plan){
        planDao.addPlan(plan);
    }

    //删除信息
    public void deletePlan(String paras){
        planDao.deletePlan(paras);
    }

    //上传信息
    public static int columuSize=6;
    public String readExcel(String filePath){
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
            String paras[][] = new String[rows][columuSize];
            int count = 0;
            if (rows > 0) {
                for (int r = 1; r < rows; r++) {
                    Row row = sheet.getRow(r);
                    if (row != null) {
                        Cell[] cell=new Cell[columuSize];
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
                            if(i==2){
                                Calendar cal = Calendar.getInstance();
                                cal.set(2017, 0, 1);
                                cal.add(Calendar.DAY_OF_MONTH, Integer.valueOf((String) paras[count][2])-42736);
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
                                paras[count][2]=date;
                            }
                            for(int j=0;j<paras[count].length;j++){
                                if(StringUtil.isEmpty(paras[count][j])){
                                    paras[count][j]="0";
                                }
                            }
                        }
                        Plan plan=new Plan();
                        plan.setId(Integer.valueOf(paras[count][0]));
                        plan.setStartdate(paras[count][1]);
                        plan.setEnddate(paras[count][2]);
                        plan.setPlan(paras[count][3]);
                        plan.setContent(paras[count][4]);
                        plan.setAssessment(paras[count][5]);

                        for(int i=0;i<planDao.showAllPlan("","").size();i++){
                            if((Integer.valueOf(paras[count][0]))==planDao.showAllPlan("","").get(i).getId()){
                                sucess="序号不能重复,添加失败";
                            }
                        }
                        if(!"序号不能重复,添加失败".equals(sucess)){
                            planDao.addPlan(plan);
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
    public List<Plan> exportPlan(String[] paras){
        List<Plan> al = planDao.showAllPlan(paras[0], paras[1]);
        return al;
    }

    //展示报表
    public Map<String,Integer> showPlanChart(String[] paras){

        List<Plan> list= planDao.showAllPlan(paras[0],paras[1]);
        Map<String,Integer> planmap = new HashMap<String,Integer>();
        for(int i=0;i<list.size();i++){
            switch(list.get(i).getAssessment()){
                case "优":
                    planmap.put(list.get(i).getStartdate(), 4);
                    break;
                case "良":
                    planmap.put(list.get(i).getStartdate(), 3);
                    break;
                case "中":
                    planmap.put(list.get(i).getStartdate(), 2);
                    break;
                case "差":
                    planmap.put(list.get(i).getStartdate(), 1);
                    break;
            }
        }
        return planmap;
    }
}
