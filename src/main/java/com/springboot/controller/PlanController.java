package com.springboot.controller;

import com.google.gson.Gson;
import com.springboot.entity.Log;
import com.springboot.entity.Plan;
import com.springboot.page.Pager;
import com.springboot.service.LogService;
import com.springboot.service.PlanService;
import com.springboot.util.ExportUtil;
import com.springboot.util.ResponseUtil;
import com.springboot.util.StringUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class PlanController {
    private final static Logger logger= LoggerFactory.getLogger(PlanController.class);

    @Resource(name="planService")
    private PlanService planService;

    //显示全部信息
    @RequestMapping(value="/adminshowallmyplan", method={RequestMethod.POST,RequestMethod.GET})
    public ModelAndView adminShowAllPlan(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String error="对不起，您没有计划信息查看权限";
        HttpSession sessio = request.getSession(false);
        logger.info((String) sessio.getAttribute("sess"));
        String[] str={"admin","employee"};
        boolean flag=false;
        for(int i=0;i<str.length;i++){
            if(str[i].equals((String)sessio.getAttribute("sess"))){
                flag=true;
            }
        }
        if(flag){
            String pageNumString = request.getParameter("pageNum");
            String pageSizeString = request.getParameter("pageSize");
            String phase1 = request.getParameter("startdate");
            String phase2 = request.getParameter("enddate");
            int pageNum=Integer.valueOf(pageNumString);
            int pageSize=Integer.valueOf(pageSizeString);
            if(null==phase1 || ""==phase1){
                phase1="0";
            }
            if(null==phase2 || ""==phase2){
                phase2="0";
            }
            String paras[]={phase1,phase2};

            Plan planpojo=new Plan();
            Pager pager=new Pager();
            pager = planService.showPager(planpojo, pageNum, pageSize,paras);

            /*Map mp = new HashMap();
            mp.put("showalllotteryresultlist", showalllotteryresultlist);
            mp.put("pager", pager);
            其中第一个参数为url,第二个参数为要传递的数据的key,第三个参数为数据对象。在这里要注意的是:数据是默认被存放在request中的。*/
            return new ModelAndView("/adminmyplan/adminshowallmyplan","pager",pager);
        }else{
            return new ModelAndView("/adminhome/adminhome","error",error);
        }

    }

    //更新信息
    @RequestMapping(value="/adminbeforeupdatemyplan", method={RequestMethod.POST,RequestMethod.GET})
    public ModelAndView beforeUpdatePlan(HttpServletRequest request,HttpServletResponse response){
        String phase = request.getParameter("id");

        List<Plan> adminbeforeupdatemyplanlist=planService.beforeUpdatePlan(phase);
        return new ModelAndView("/adminmyplan/adminbeforeupdatemyplan","adminbeforeupdatemyplanlist",adminbeforeupdatemyplanlist);
    }
    @RequestMapping(value="/adminupdatemyplan", method={RequestMethod.POST,RequestMethod.GET})
    public ModelAndView updatePlan(HttpServletRequest request,HttpServletResponse response){
        String id = request.getParameter("id");
        String startdate = request.getParameter("startdate");
        String enddate = request.getParameter("enddate");
        String plan = request.getParameter("plan");
        String content = request.getParameter("content");
        String assessment = request.getParameter("assessment");

        Plan planpojo=new Plan();
        planpojo.setId(Integer.valueOf(id));
        planpojo.setStartdate(startdate);
        planpojo.setEnddate(enddate);
        planpojo.setPlan(plan);
        planpojo.setContent(content);
        planpojo.setAssessment(assessment);
        planService.updatePlan(planpojo);
        return new ModelAndView("redirect:/adminshowallmyplan?pageNum=1&pageSize=10");
    }

    //添加信息
    @RequestMapping(value="/adminaddmyplan", method={RequestMethod.POST,RequestMethod.GET})
    public ModelAndView adminAddPlan(HttpServletRequest request,HttpServletResponse response){
        String id = request.getParameter("id");
        String startdate = request.getParameter("startdate");
        String enddate = request.getParameter("enddate");
        String plan = request.getParameter("plan");
        String content = request.getParameter("content");
        String assessment = request.getParameter("assessment");
        String object[]={id,startdate,enddate,plan,content,assessment};

        for(int i=0;i<object.length;i++){
            if("".equals(object[i])){
                object[i]="0";
            }
        }
        Plan planpojo=new Plan();
        planpojo.setId(Integer.valueOf(id));
        planpojo.setStartdate(startdate);
        planpojo.setEnddate(enddate);
        planpojo.setPlan(plan);
        planpojo.setContent(content);
        planpojo.setAssessment(assessment);
        planService.addPlan(planpojo);
        return new ModelAndView("redirect:/adminshowallmyplan?pageNum=1&pageSize=10");
    }
    @RequestMapping(value="adminaddplan",method= RequestMethod.GET)
    public String adminaddplan(){
        return "/adminmyplan/adminaddmyplan";
    }

    //删除信息
    @RequestMapping(value="/admindeletemyplan", method={RequestMethod.POST,RequestMethod.GET})
    public ModelAndView adminDeletePlan(HttpServletRequest request,HttpServletResponse response){
        String[] phase = request.getParameterValues("tduCheckBox");
        if(null==phase||"".equals(phase)){
            return new ModelAndView("redirect:/adminshowallmyplan?pageNum=1&pageSize=10");
        }
        for(int i=0;i<phase.length;i++){
            planService.deletePlan(phase[i]);
        }
        return new ModelAndView("redirect:/adminshowallmyplan?pageNum=1&pageSize=10");
    }

    //跳转到上传/下载页面
    @RequestMapping(value="adminupanddownloadmyplan",method= RequestMethod.GET)
    public ModelAndView adminupanddownloadplan(HttpServletRequest request,HttpServletResponse respons){
        String error="对不起，您没有日志信息查看权限";
        HttpSession sessio = request.getSession(false);
        logger.info((String) sessio.getAttribute("sess"));
        String[] str={"admin","employee"};
        boolean flag=false;
        for(int i=0;i<str.length;i++){
            if(str[i].equals((String)sessio.getAttribute("sess"))){
                flag=true;
            }
        }
        if(flag){
            return new ModelAndView("/adminmyplan/adminupanddownloadmyplan");
        }else{
            return new ModelAndView("/adminhome/adminhome","error",error);
        }
    }
    //下载模板
    @RequestMapping(value="/adminuploadplantemplate", method={RequestMethod.POST,RequestMethod.GET})
    public String adminuploadplantemplate(HttpServletRequest request,HttpServletResponse response) throws Exception{
        request.setCharacterEncoding("UTF-8");
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        String today=format.format(date);
        String path=request.getServletContext().getRealPath("/upload");
        File myfile=new File(path);
        if (!myfile.exists() && !myfile.isDirectory())
        {
            myfile.mkdir();
        }
        SXSSFWorkbook wb = new SXSSFWorkbook(100);
        try {
            Sheet sheet=wb.createSheet("日记");
            int rowIndex = 0;
            Row writeRow = sheet.createRow(rowIndex);
            //设置样式
            CellStyle headstyle = ExportUtil.getHeadStyle(wb);
            CellStyle bodystyle = ExportUtil.getBodyStyle(wb);
            String[] firstline={"序号","起始日期","结束日期","计划主题","计划内容","评价"};
            for(int i=0;i<firstline.length;i++){
                Cell cell = writeRow.createCell(i);
                cell.setCellValue(firstline[i]);
                cell.setCellStyle(headstyle);
            }

            //输出Excel文件
            OutputStream output=response.getOutputStream();
            response.reset();
            response.setHeader("Content-disposition", "attachment; fileName="+"template"+today+".xlsx");
            response.setContentType("application/msexcel");
            wb.write(output);
            output.close();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //上传信息
    @RequestMapping(value="/adminuploadmyplan", method={RequestMethod.POST,RequestMethod.GET})
    public ModelAndView UploadExcel(@RequestParam("myFile") MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception{
        String myFileFileName=file.getOriginalFilename();
        String uploadPath=request.getServletContext().getRealPath("/upload");
        String error="文件不能为空";

        if(file.getName()!=null&&file.isEmpty()==false){
            InputStream in=file.getInputStream();
            File saveDir=new File(uploadPath);
            if(!saveDir.exists())
            {
                saveDir.mkdirs();
            }
            File target=new File(uploadPath,myFileFileName);
            OutputStream out=new FileOutputStream(target);
            byte []buffer=new byte[1024];
            int length=0;
            while((length=in.read(buffer))>0)
            {
                out.write(buffer, 0,length);
            }
            in.close();
            out.close();
        }else{
            return new ModelAndView("/adminmyplan/adminupanddownloadmyplan","error",error);
        }
        String sucess=planService.readExcel(uploadPath+"/"+myFileFileName);
        return new ModelAndView("/adminmyplan/adminupanddownloadmyplan","sucess",sucess);
    }
    //下载信息
    @RequestMapping(value="/admindownloadmyplan", method={RequestMethod.POST,RequestMethod.GET})
    public String adminExportPlan(HttpServletRequest request,HttpServletResponse response) throws Exception{
        request.setCharacterEncoding("UTF-8");
        String sdate = request.getParameter("sdate");
        String edate = request.getParameter("edate");
        if(null==sdate || ""==sdate){
            sdate="0";
        }
        if(null==edate || ""==edate){
            edate="0";
        }
        String[] paras={sdate,edate};
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        String today=format.format(date);
        String path=request.getServletContext().getRealPath("/upload");
        File myfile=new File(path);
        if (!myfile.exists() && !myfile.isDirectory())
        {
            myfile.mkdir();
        }
        List<Plan> al = planService.exportPlan(paras);
        SXSSFWorkbook wb = new SXSSFWorkbook(100);
        try {
            Sheet sheet=wb.createSheet("日记");
            int rowIndex = 0;
            Row writeRow = sheet.createRow(rowIndex);
            //设置样式
            CellStyle headstyle = ExportUtil.getHeadStyle(wb);
            CellStyle bodystyle = ExportUtil.getBodyStyle(wb);
            String[] firstline={"序号","起始日期","结束日期","计划主题","计划内容","评价"};
            for(int i=0;i<firstline.length;i++){
                Cell cell = writeRow.createCell(i);
                cell.setCellValue(firstline[i]);
                cell.setCellStyle(headstyle);
            }

            for (int i = 0; i < al.size(); i++) {
                Plan myplanpojo = al.get(i);
                rowIndex += 1;
                writeRow = sheet.createRow(rowIndex);
                Object[] bodyline={myplanpojo.getId(),myplanpojo.getStartdate(),myplanpojo.getEnddate(),myplanpojo.getPlan(),myplanpojo.getContent(),myplanpojo.getAssessment()};
                for(int j=0;j<bodyline.length;j++){
                    Cell cell = writeRow.createCell(j);
                    cell.setCellValue(StringUtil.replaceAllBlank(bodyline[j].toString()));
                    cell.setCellStyle(bodystyle);
                }
            }

            //输出Excel文件
            OutputStream output=response.getOutputStream();
            response.reset();
            response.setHeader("Content-disposition", "attachment; fileName="+"plan"+today+".xlsx");
            response.setContentType("application/msexcel");
            wb.write(output);
            output.close();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //跳转到报表页面
    @RequestMapping(value="adminshowmyplanchart",method={RequestMethod.POST,RequestMethod.GET})
    public ModelAndView adminshowplanchart(HttpServletRequest request,HttpServletResponse response){
        String error="对不起，您没有报表查看权限";
        HttpSession sessio = request.getSession(false);
        logger.info((String) sessio.getAttribute("sess"));
        String[] str={"admin","leader"};
        boolean flag=false;
        for(int i=0;i<str.length;i++){
            if(str[i].equals((String)sessio.getAttribute("sess"))){
                flag=true;
            }
        }
        if(flag){
            return new ModelAndView("/adminmyplan/adminshowmyplanchart");
        }else{
            return new ModelAndView("/adminhome/adminhome","error",error);
        }

    }
    //展示报表
    @RequestMapping(value="/showmyplanchart", method={RequestMethod.POST,RequestMethod.GET})
    public void showPlanChart(HttpServletRequest request,HttpServletResponse response, ModelMap modelMap) throws Exception{
        String phase1 = request.getParameter("startdate");
        String phase2 = request.getParameter("enddate");
        String type=request.getParameter("type");
        if(null==phase1 || ""==phase1){
            phase1="0";
        }
        if(null==phase2 || ""==phase2){
            phase2="0";
        }
        String paras[]={phase1,phase2};

        Map<String,Integer> planmap = new HashMap<String,Integer>();
        planmap=planService.showPlanChart(paras);

        // 调用GSON jar工具包封装好的toJson方法，可直接生成JSON字符串
        Gson gson = new Gson();
        String json = gson.toJson(planmap);
        // 输出到界面
        ResponseUtil.write(response, json);
    }
}
