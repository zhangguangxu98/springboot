package com.springboot.controller;

import com.google.gson.Gson;
import com.springboot.entity.Lottery;
import com.springboot.page.Pager;
import com.springboot.service.LotteryService;
import com.springboot.util.ExportUtil;
import com.springboot.util.ResponseUtil;
import com.springboot.util.StringUtil;
import org.apache.poi.ss.usermodel.*;

import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class LotteryController {
    private final static Logger logger= LoggerFactory.getLogger(LotteryController.class);

    @Resource(name="lotteryService")
    private LotteryService lotteryService;

    //显示全部信息
    @RequestMapping(value="/adminshowalllotteryresult", method={RequestMethod.POST,RequestMethod.GET})
    public ModelAndView adminShowAllLotteryResult(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String error="对不起，您没有彩票信息查看权限";
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
            String phase1 = request.getParameter("startdate");
            String phase2 = request.getParameter("enddate");
            int pageNum=Integer.valueOf(pageNumString);
            if(null==phase1 || ""==phase1){
                phase1="0";
            }
            if(null==phase2 || ""==phase2){
                phase2="0";
            }
            String paras[]={phase1,phase2};
            final int pageSize=10;

            Lottery lotteryresult=new Lottery();
            Pager pager=new Pager();
            pager = lotteryService.showPager(lotteryresult, pageNum, pageSize,paras);

            /*Map mp = new HashMap();
            mp.put("showalllotteryresultlist", showalllotteryresultlist);
            mp.put("pager", pager);
            其中第一个参数为url,第二个参数为要传递的数据的key,第三个参数为数据对象。在这里要注意的是:数据是默认被存放在request中的。*/
            return new ModelAndView("/adminlotteryresult/adminshowalllotteryresult","pager",pager);
        }else{
            return new ModelAndView("/adminhome/adminhome","error",error);
        }

    }
    //更新信息
    @RequestMapping(value="/adminbeforeupdatelotteryresult", method={RequestMethod.POST,RequestMethod.GET})
    public ModelAndView beforeUpdateLotteryResult(HttpServletRequest request,HttpServletResponse response){
        String phase = request.getParameter("phase");

        ArrayList<Lottery> adminbeforeupdatelotteryresultlist=lotteryService.beforeUpdateLotteryResult(phase);
        return new ModelAndView("/adminlotteryresult/adminbeforeupdatelotteryresult","adminbeforeupdatelotteryresultlist",adminbeforeupdatelotteryresultlist);
    }
    @RequestMapping(value="/adminupdatelotteryresult", method={RequestMethod.POST,RequestMethod.GET})
    public ModelAndView updateLotteryResult(HttpServletRequest request,HttpServletResponse response){
        String phase = request.getParameter("phase");
        String date = request.getParameter("date");
        String red1 = request.getParameter("red1");
        String red2 = request.getParameter("red2");
        String red3 = request.getParameter("red3");
        String red4 = request.getParameter("red4");
        String red5 = request.getParameter("red5");
        String blue1 = request.getParameter("blue1");
        String blue2 = request.getParameter("blue2");
        Lottery lottery=new Lottery();
        lottery.setPhase(Integer.valueOf(phase));
        lottery.setDate(date);
        lottery.setRed1(Integer.valueOf(red1));
        lottery.setRed2(Integer.valueOf(red2));
        lottery.setRed3(Integer.valueOf(red3));
        lottery.setRed4(Integer.valueOf(red4));
        lottery.setRed5(Integer.valueOf(red5));
        lottery.setBlue1(Integer.valueOf(blue1));
        lottery.setBlue2(Integer.valueOf(blue2));

        lotteryService.updateLotteryResult(lottery);
        return new ModelAndView("redirect:/adminshowalllotteryresult?pageNum=1");
    }

    //添加信息
    @RequestMapping(value="/adminaddlotteryresult", method={RequestMethod.POST,RequestMethod.GET})
    public ModelAndView adminAddLotteryResult(HttpServletRequest request,HttpServletResponse response){
        String phase = request.getParameter("phase");
        String date = request.getParameter("date");
        String red1 = request.getParameter("red1");
        String red2 = request.getParameter("red2");
        String red3 = request.getParameter("red3");
        String red4 = request.getParameter("red4");
        String red5 = request.getParameter("red5");
        String blue1 = request.getParameter("blue1");
        String blue2 = request.getParameter("blue2");
        Lottery lottery=new Lottery();
        lottery.setPhase(Integer.valueOf(phase));
        lottery.setDate(date);
        lottery.setRed1(Integer.valueOf(red1));
        lottery.setRed2(Integer.valueOf(red2));
        lottery.setRed3(Integer.valueOf(red3));
        lottery.setRed4(Integer.valueOf(red4));
        lottery.setRed5(Integer.valueOf(red5));
        lottery.setBlue1(Integer.valueOf(blue1));
        lottery.setBlue2(Integer.valueOf(blue2));
        lotteryService.addLotteryResult(lottery);
        return new ModelAndView("redirect:/adminshowalllotteryresult?pageNum=1");
    }
    @RequestMapping(value="adminaddlottery",method= RequestMethod.GET)
    public String hello(){
        return "/adminlotteryresult/adminaddlotteryresult";
    }

    //删除信息
    @RequestMapping(value="/admindeletelotteryresult", method={RequestMethod.POST,RequestMethod.GET})
    public ModelAndView adminDeleteLotteryResult(HttpServletRequest request,HttpServletResponse response){
        String[] phase = request.getParameterValues("tduCheckBox");
        if(null==phase||"".equals(phase)){
            return new ModelAndView("redirect:/adminshowalllotteryresult?pageNum=1");
        }
        for(int i=0;i<phase.length;i++){
            lotteryService.deleteLotteryResult(phase[i]);
        }
        return new ModelAndView("redirect:/adminshowalllotteryresult?pageNum=1");
    }

    //跳转到上传/下载页面
    @RequestMapping(value="adminupanddownloadlotteryresult",method= RequestMethod.GET)
    public ModelAndView adminupanddownloadlotteryresult(HttpServletRequest request,HttpServletResponse respons){
        String error="对不起，您没有彩票信息查看权限";
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
            return new ModelAndView("/adminlotteryresult/adminupanddownloadlotteryresult");
        }else{
            return new ModelAndView("/adminhome/adminhome","error",error);
        }
    }
    //下载模板
    @RequestMapping(value="/adminuploadlotterytemplate", method={RequestMethod.POST,RequestMethod.GET})
    public String adminuploadlotterytemplate(HttpServletRequest request,HttpServletResponse response) throws Exception{
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
            Sheet sheet=wb.createSheet("大乐透");
            int rowIndex = 0;
            Row writeRow = sheet.createRow(rowIndex);
            //设置样式
            CellStyle headstyle = ExportUtil.getHeadStyle(wb);
            CellStyle bodystyle = ExportUtil.getBodyStyle(wb);
            String[] firstline={"期号","日期","红1","红2","红3","红4","红5","蓝1","蓝2"};
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
    @RequestMapping(value="/adminuploadlotteryresult", method={RequestMethod.POST,RequestMethod.GET})
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
            return new ModelAndView("/adminlotteryresult/adminupanddownloadlotteryresult","error",error);
        }
        String sucess=lotteryService.readExcel(uploadPath+"/"+myFileFileName);
        return new ModelAndView("/adminlotteryresult/adminupanddownloadlotteryresult","sucess",sucess);
    }
    //下载信息
    @RequestMapping(value="/admindownloadlotteryresult", method={RequestMethod.POST,RequestMethod.GET})
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
        List<Lottery> al = lotteryService.exportPlan(paras);
        SXSSFWorkbook wb = new SXSSFWorkbook(100);
        try {
            Sheet sheet=wb.createSheet("大乐透");
            int rowIndex = 0;
            Row writeRow = sheet.createRow(rowIndex);
            //设置样式
            CellStyle headstyle = ExportUtil.getHeadStyle(wb);
            CellStyle bodystyle = ExportUtil.getBodyStyle(wb);
            String[] firstline={"期号","日期","红1","红2","红3","红4","红5","蓝1","蓝2"};
            for(int i=0;i<firstline.length;i++){
                Cell cell = writeRow.createCell(i);
                cell.setCellValue(firstline[i]);
                cell.setCellStyle(headstyle);
            }

            for (int i = 0; i < al.size(); i++) {
                Lottery lottery = al.get(i);
                rowIndex += 1;
                writeRow = sheet.createRow(rowIndex);
                Object[] bodyline={lottery.getPhase(),lottery.getDate(),lottery.getRed1(),lottery.getRed2(),lottery.getRed3(),lottery.getRed4(),lottery.getRed5(),lottery.getBlue1(),lottery.getBlue2()};
                for(int j=0;j<bodyline.length;j++){
                    Cell cell = writeRow.createCell(j);
                    cell.setCellValue(StringUtil.replaceAllBlank(bodyline[j].toString()));
                    cell.setCellStyle(bodystyle);
                }
            }

            //输出Excel文件
            OutputStream output=response.getOutputStream();
            response.reset();
            response.setHeader("Content-disposition", "attachment; fileName="+"lottery"+today+".xlsx");
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
    @RequestMapping(value="adminshowlotteryresultchart",method= RequestMethod.GET)
    public ModelAndView adminshowlotteryresultchart(HttpServletRequest request,HttpServletResponse response){
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
            return new ModelAndView("/adminlotteryresult/adminshowlotteryresultchart");
        }else{
            return new ModelAndView("/adminhome/adminhome","error",error);
        }

    }
    //展示报表
    @RequestMapping(value="/showlotteryresultchart", method={RequestMethod.POST,RequestMethod.GET})
    public void showLotteryResultChart(HttpServletRequest request,HttpServletResponse response, ModelMap modelMap) throws Exception{
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
        Map<String,Integer> lotterymap = new LinkedHashMap<String,Integer>();
        int redone1=0,redone2=0,redone3=0,redone4=0,redone5=0,redone6=0,redone7=0,redone8=0,redone9=0,redone10=0,redone11=0,redone12=0,redone13=0,redone14=0,redone15=0,redone16=0,redone17=0,redone18=0,redone19=0,redone20=0,redone21=0,redone22=0,redone23=0,redone24=0,redone25=0,redone26=0,redone27=0,redone28=0,redone29=0,redone30=0,redone31=0,redone32=0,redone33=0,redone34=0,redone35=0,redoneothers=0;
        int quantityone[]={redone1,redone2,redone3,redone4,redone5,redone6,redone7,redone8,redone9,redone10,redone11,redone12,redone13,redone14,redone15,redone16,redone17,redone18,redone19,redone20,redone21,redone22,redone23,redone24,redone25,redone26,redone27,redone28,redone29,redone30,redone31,redone32,redone33,redone34,redone35,redoneothers};

        quantityone=lotteryService.showLotteryResultChart(paras,type);

        for(int i=0;i<quantityone.length;i++){
            lotterymap.put(i+1+"", quantityone[i]);
        }
        // 调用GSON jar工具包封装好的toJson方法，可直接生成JSON字符串
        Gson gson = new Gson();
        String json = gson.toJson(lotterymap);
        // 输出到界面
        ResponseUtil.write(response, json);
    }
}
