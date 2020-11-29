package com.springboot.controller;

import com.google.gson.Gson;
import com.springboot.entity.Log;
import com.springboot.page.Pager;
import com.springboot.service.LogService;
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
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class LogController {
    private final static Logger logger= LoggerFactory.getLogger(LogController.class);

    @Resource(name="logService")
    private LogService logService;

    //显示全部信息
    @RequestMapping(value="/adminshowallmylog", method={RequestMethod.POST,RequestMethod.GET})
    public ModelAndView adminShowAllLog(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String error="对不起，您没有日记信息查看权限";
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

            Log log=new Log();
            Pager pager=new Pager();
            pager = logService.showPager(log, pageNum, pageSize,paras);

            /*Map mp = new HashMap();
            mp.put("showalllotteryresultlist", showalllotteryresultlist);
            mp.put("pager", pager);
            其中第一个参数为url,第二个参数为要传递的数据的key,第三个参数为数据对象。在这里要注意的是:数据是默认被存放在request中的。*/
            return new ModelAndView("/adminmylog/adminshowallmylog","pager",pager);
        }else{
            return new ModelAndView("/adminhome/adminhome","error",error);
        }

    }

    //更新信息
    @RequestMapping(value="/adminbeforeupdatemylog", method={RequestMethod.POST,RequestMethod.GET})
    public ModelAndView beforeUpdateLog(HttpServletRequest request,HttpServletResponse response){
        String phase = request.getParameter("id");

        List<Log> adminbeforeupdatemyloglist=logService.beforeUpdateLog(phase);
        return new ModelAndView("/adminmylog/adminbeforeupdatemylog","adminbeforeupdatemyloglist",adminbeforeupdatemyloglist);
    }
    @RequestMapping(value="/adminupdatemylog", method={RequestMethod.POST,RequestMethod.GET})
    public ModelAndView updateLog(HttpServletRequest request,HttpServletResponse response){
        String id = request.getParameter("id");
        String date = request.getParameter("date");
        String home = request.getParameter("home");
        String clothes = request.getParameter("clothes");
        String meal = request.getParameter("meal");
        String room = request.getParameter("room");
        String trip = request.getParameter("trip");
        String lifeuse = request.getParameter("lifeuse");
        String play = request.getParameter("play");
        String insurance = request.getParameter("insurance");
        String pretaxincome = request.getParameter("pretaxincome");
        String idroutine = request.getParameter("idroutine");
        String dateroutine = request.getParameter("dateroutine");
        String homeroutine = request.getParameter("homeroutine");
        String clothesroutine = request.getParameter("clothesroutine");
        String mealroutine = request.getParameter("mealroutine");
        String roomroutine = request.getParameter("roomroutine");
        String triproutine = request.getParameter("triproutine");
        String useroutine = request.getParameter("useroutine");
        String playroutine = request.getParameter("playroutine");
        String insuranceroutine = request.getParameter("insuranceroutine");
        String selfcontrol = request.getParameter("selfcontrol");
        String diligence = request.getParameter("diligence");
        String goodorder = request.getParameter("goodorder");
        String clean = request.getParameter("clean");
        String frugality = request.getParameter("frugality");
        String honest = request.getParameter("honest");
        String integrity = request.getParameter("integrity");
        String modest = request.getParameter("modest");
        String friendly = request.getParameter("friendly");
        String tolerant = request.getParameter("tolerant");
        String diary = request.getParameter("diary");

        Log myLogPojo=new Log();
        myLogPojo.setId(Integer.valueOf(id));
        myLogPojo.setDate(date);
        myLogPojo.setHome(Integer.valueOf(home));
        myLogPojo.setClothes(Integer.valueOf(clothes));
        myLogPojo.setMeal(Integer.valueOf(meal));
        myLogPojo.setRoom(Integer.valueOf(room));
        myLogPojo.setTrip(Integer.valueOf(trip));
        myLogPojo.setLifeuse(Integer.valueOf(lifeuse));
        myLogPojo.setPlay(Integer.valueOf(play));
        myLogPojo.setInsurance(Integer.valueOf(insurance));
        myLogPojo.setPretaxincome(Integer.valueOf(pretaxincome));
        myLogPojo.setIdroutine(idroutine);
        myLogPojo.setDateroutine(dateroutine);
        myLogPojo.setHomeroutine(homeroutine);
        myLogPojo.setClothesroutine(clothesroutine);
        myLogPojo.setMealroutine(mealroutine);
        myLogPojo.setRoomroutine(roomroutine);
        myLogPojo.setTriproutine(triproutine);
        myLogPojo.setUseroutine(useroutine);
        myLogPojo.setPlayroutine(playroutine);
        myLogPojo.setInsuranceroutine(insuranceroutine);
        myLogPojo.setSelfcontrol(selfcontrol);
        myLogPojo.setDiligence(diligence);
        myLogPojo.setGoodorder(goodorder);
        myLogPojo.setClean(clean);
        myLogPojo.setFrugality(frugality);
        myLogPojo.setHonest(honest);
        myLogPojo.setIntegrity(integrity);
        myLogPojo.setModest(modest);
        myLogPojo.setFriendly(friendly);
        myLogPojo.setTolerant(tolerant);
        myLogPojo.setDiary(diary);

        logService.updateLog(myLogPojo);
        return new ModelAndView("redirect:/adminbeforeupdatemylog?id="+id);
    }

    //添加信息之前
    @RequestMapping(value="/adminbeforeaddmylog", method={RequestMethod.GET})
    public ModelAndView adminBeforeAddLog(HttpServletRequest request,HttpServletResponse response) throws ParseException {
        Log log=logService.beforeAddLog();
        Log adminbeforeaddmylog=new Log();
        adminbeforeaddmylog.setId(Integer.valueOf(log.getId())+1);
        String endDate=log.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date sDate = sdf.parse(endDate);
        Format f = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(sDate);
        c.add(Calendar.DAY_OF_MONTH, 1);    //利用Calendar 实现 Date日期+1天
        sDate = c.getTime();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        endDate = sdf1.format(sDate);
        System.out.println("Date类型转String类型  "+endDate);//将日期转成String类型 方便进入数据库比较
        adminbeforeaddmylog.setDate(endDate);
        return new ModelAndView("/adminmylog/adminaddmylog","adminbeforeaddmylog",adminbeforeaddmylog);
    }
    //添加信息
    @RequestMapping(value="/adminaddmylog", method={RequestMethod.POST,RequestMethod.GET})
    public ModelAndView adminAddLog(HttpServletRequest request,HttpServletResponse response){
        String id = request.getParameter("id");
        String date = request.getParameter("date");
        String home = request.getParameter("home");
        String clothes = request.getParameter("clothes");
        String meal = request.getParameter("meal");
        String room = request.getParameter("room");
        String trip = request.getParameter("trip");
        String lifeuse = request.getParameter("lifeuse");
        String play = request.getParameter("play");
        String insurance = request.getParameter("insurance");
        String pretaxincome = request.getParameter("pretaxincome");
        String idroutine = request.getParameter("idroutine");
        String dateroutine = request.getParameter("dateroutine");
        String homeroutine = request.getParameter("homeroutine");
        String clothesroutine = request.getParameter("clothesroutine");
        String mealroutine = request.getParameter("mealroutine");
        String roomroutine = request.getParameter("roomroutine");
        String triproutine = request.getParameter("triproutine");
        String useroutine = request.getParameter("useroutine");
        String playroutine = request.getParameter("playroutine");
        String insuranceroutine = request.getParameter("insuranceroutine");
        String selfcontrol = request.getParameter("selfcontrol");
        String diligence = request.getParameter("diligence");
        String goodorder = request.getParameter("goodorder");
        String clean = request.getParameter("clean");
        String frugality = request.getParameter("frugality");
        String honest = request.getParameter("honest");
        String integrity = request.getParameter("integrity");
        String modest = request.getParameter("modest");
        String friendly = request.getParameter("friendly");
        String tolerant = request.getParameter("tolerant");
        String diary = request.getParameter("diary");
        String object[]={id,date,home,clothes,meal,room,trip,lifeuse,play,insurance,pretaxincome,idroutine,dateroutine
                ,homeroutine,clothesroutine,mealroutine,roomroutine,triproutine,useroutine,playroutine
                ,insuranceroutine,selfcontrol,diligence,goodorder,clean,frugality,honest,integrity,modest
                ,friendly,tolerant,diary};
        for(int i=0;i<object.length;i++){
            if("".equals(object[i])){
                object[i]="0";
            }
        }
        Log myLogPojo=new Log();
        myLogPojo.setId(Integer.valueOf(object[0]));
        myLogPojo.setDate(object[1]);
        myLogPojo.setHome(Integer.valueOf(object[2]));
        myLogPojo.setClothes(Integer.valueOf(object[3]));
        myLogPojo.setMeal(Integer.valueOf(object[4]));
        myLogPojo.setRoom(Integer.valueOf(object[5]));
        myLogPojo.setTrip(Integer.valueOf(object[6]));
        myLogPojo.setLifeuse(Integer.valueOf(object[7]));
        myLogPojo.setPlay(Integer.valueOf(object[8]));
        myLogPojo.setInsurance(Integer.valueOf(object[9]));
        myLogPojo.setPretaxincome(Integer.valueOf(object[10]));
        myLogPojo.setIdroutine(object[11]);
        myLogPojo.setDateroutine(object[12]);
        myLogPojo.setHomeroutine(object[13]);
        myLogPojo.setClothesroutine(object[14]);
        myLogPojo.setMealroutine(object[15]);
        myLogPojo.setRoomroutine(object[16]);
        myLogPojo.setTriproutine(object[17]);
        myLogPojo.setUseroutine(object[18]);
        myLogPojo.setPlayroutine(object[19]);
        myLogPojo.setInsuranceroutine(object[20]);
        myLogPojo.setSelfcontrol(object[21]);
        myLogPojo.setDiligence(object[22]);
        myLogPojo.setGoodorder(object[23]);
        myLogPojo.setClean(object[24]);
        myLogPojo.setFrugality(object[25]);
        myLogPojo.setHonest(object[26]);
        myLogPojo.setIntegrity(object[27]);
        myLogPojo.setModest(object[28]);
        myLogPojo.setFriendly(object[29]);
        myLogPojo.setTolerant(object[30]);
        myLogPojo.setDiary(object[31]);
        logService.addLog(myLogPojo);
        return new ModelAndView("redirect:/adminshowallmylog?pageNum=1&pageSize=10");
    }
    @RequestMapping(value="adminaddlog",method= RequestMethod.GET)
    public String adminaddlog(){
        return "/adminmylog/adminaddmylog";
    }

    //删除信息
    @RequestMapping(value="/admindeletemylog", method={RequestMethod.POST,RequestMethod.GET})
    public ModelAndView adminDeleteLog(HttpServletRequest request,HttpServletResponse response){
        String[] phase = request.getParameterValues("tduCheckBox");
        if(null==phase||"".equals(phase)){
            return new ModelAndView("redirect:/adminshowallmylog?pageNum=1&pageSize=10");
        }
        for(int i=0;i<phase.length;i++){
            logService.deleteLog(phase[i]);
        }
        return new ModelAndView("redirect:/adminshowallmylog?pageNum=1&pageSize=10");
    }

    //跳转到上传/下载页面
    @RequestMapping(value="adminupanddownloadmylog",method= RequestMethod.GET)
    public ModelAndView adminupanddownloadlog(HttpServletRequest request,HttpServletResponse respons){
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
            return new ModelAndView("/adminmylog/adminupanddownloadmylog");
        }else{
            return new ModelAndView("/adminhome/adminhome","error",error);
        }
    }
    //下载模板
    @RequestMapping(value="/adminuploadlogtemplate", method={RequestMethod.POST,RequestMethod.GET})
    public String adminuploadlogtemplate(HttpServletRequest request,HttpServletResponse response) throws Exception{
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
            String[] firstline={"序号","日期","家庭","衣服","食物","住宿","交通","用品","娱乐","税后收入","税前收入","序号事件","日期事件",
                    "家庭事件","衣服事件","食物事件","住宿事件","交通事件","用品事件","娱乐事件","收入事件","自制","勤奋",
                    "秩序","整洁","节俭","诚实","正直","谦虚","友善","宽容","日记"};
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
    @RequestMapping(value="/adminuploadmylog", method={RequestMethod.POST,RequestMethod.GET})
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
            return new ModelAndView("/adminmylog/adminupanddownloadmylog","error",error);
        }
        String sucess=logService.readExcel(uploadPath+"/"+myFileFileName);
        return new ModelAndView("/adminmylog/adminupanddownloadmylog","sucess",sucess);
    }
    //下载信息
    @RequestMapping(value="/admindownloadmylog", method={RequestMethod.POST,RequestMethod.GET})
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
        List<Log> al = logService.exportLog(paras);
        SXSSFWorkbook wb = new SXSSFWorkbook(100);
        try {
            Sheet sheet=wb.createSheet("日记");
            int rowIndex = 0;
            Row writeRow = sheet.createRow(rowIndex);
            //设置样式
            CellStyle headstyle = ExportUtil.getHeadStyle(wb);
            CellStyle bodystyle = ExportUtil.getBodyStyle(wb);
            String[] firstline={"序号","日期","家庭","衣服","食物","住宿","交通","用品","娱乐","税后收入","税前收入","序号事件","日期事件",
                    "家庭事件","衣服事件","食物事件","住宿事件","交通事件","用品事件","娱乐事件","收入事件","自制","勤奋",
                    "秩序","整洁","节俭","诚实","正直","谦虚","友善","宽容","日记"};
            for(int i=0;i<firstline.length;i++){
                Cell cell = writeRow.createCell(i);
                cell.setCellValue(firstline[i]);
                cell.setCellStyle(headstyle);
            }

            for (int i = 0; i < al.size(); i++) {
                Log mylogpojo = al.get(i);
                rowIndex += 1;
                writeRow = sheet.createRow(rowIndex);
                Object[] bodyline={mylogpojo.getId(), mylogpojo.getDate(),mylogpojo.getHome(), mylogpojo.getClothes(),mylogpojo.getMeal(), mylogpojo.getRoom(),mylogpojo.getTrip(),
                        mylogpojo.getLifeuse(), mylogpojo.getPlay(),mylogpojo.getInsurance(), mylogpojo.getPretaxincome(), mylogpojo.getIdroutine(), mylogpojo.getDateroutine(),
                        mylogpojo.getHomeroutine(),mylogpojo.getClothesroutine(), mylogpojo.getMealroutine(),mylogpojo.getRoomroutine(), mylogpojo.getTriproutine(),
                        mylogpojo.getUseroutine(), mylogpojo.getPlayroutine(), mylogpojo.getInsuranceroutine(),mylogpojo.getSelfcontrol(), mylogpojo.getDiligence(),
                        mylogpojo.getGoodorder(), mylogpojo.getClean(),mylogpojo.getFrugality(), mylogpojo.getHonest(), mylogpojo.getIntegrity(),mylogpojo.getModest(),
                        mylogpojo.getFriendly(), mylogpojo.getTolerant(), mylogpojo.getDiary(), };
                for(int j=0;j<bodyline.length;j++){
                    Cell cell = writeRow.createCell(j);
                    cell.setCellValue(StringUtil.replaceAllBlank(bodyline[j].toString()));
                    cell.setCellStyle(bodystyle);
                }
            }

            //输出Excel文件
            OutputStream output=response.getOutputStream();
            response.reset();
            response.setHeader("Content-disposition", "attachment; fileName="+"log"+today+".xlsx");
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
    @RequestMapping(value="adminshowmylogchart",method={RequestMethod.POST,RequestMethod.GET})
    public ModelAndView adminshowlogchart(HttpServletRequest request,HttpServletResponse response){
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
            return new ModelAndView("/adminmylog/adminshowmylogchart");
        }else{
            return new ModelAndView("/adminhome/adminhome","error",error);
        }

    }
    //展示报表
    @RequestMapping(value="/showmylogchart", method={RequestMethod.POST,RequestMethod.GET})
    public void showLogChart(HttpServletRequest request,HttpServletResponse response, ModelMap modelMap) throws Exception{
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

        int money[]=new int[10];
        money=logService.showLogChart(paras);

        // 调用GSON jar工具包封装好的toJson方法，可直接生成JSON字符串
        Gson gson = new Gson();
        String json = gson.toJson(money);
        // 输出到界面
        ResponseUtil.write(response, json);
    }
}
