package com.springboot.controller;

import com.google.gson.Gson;
import com.springboot.entity.Lottery;
import com.springboot.entity.User;
import com.springboot.page.Pager;
import com.springboot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    private final static Logger logger= LoggerFactory.getLogger(UserController.class);

    @Resource(name="userService")
    private UserService userService;

    @RequestMapping(value="adminhome",method= RequestMethod.GET)
    public String adminhome(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "/adminhome/adminhome";
    }
/*    @RequestMapping(value="login",method= RequestMethod.GET)
    public String login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().setAttribute("sess", "");
        return "userlogin";
    }*/

  /*  @RequestMapping(value="userlogin",method={RequestMethod.POST,RequestMethod.GET})
    public ModelAndView userLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.info("登录成功：");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String error="没有该账户或者密码错误";
        String markerror="没有该角色";
        Map mp=new HashMap();
        List<User> userlist=userService.userLogin(name,password);
        if(userlist.size()==0){
            return new ModelAndView("userlogin","error",error);
        }else{
            request.getSession().setAttribute("sess", userlist.get(0).getMark());
            User userPojo=userlist.get(0);
            if((userPojo.getMark()).equals("admin")){
                *//*			return "/adminhome/adminhome";*//*
                return new ModelAndView("/adminhome/adminhome");
            }else if((userPojo.getMark()).equals("other")){
                *//*			return "othershome";*//*
                return new ModelAndView("/otherhome/otherhome");
            }else{
                *//*			return "userlogin";*//*
                return new ModelAndView("userlogin","error",markerror);
            }
        }

    }*/

    //显示全部信息
    @RequestMapping(value="/adminshowalluser", method={RequestMethod.POST,RequestMethod.GET})
    public ModelAndView adminShowAllUser(HttpServletRequest request, HttpServletResponse response){

        String pageNumString = request.getParameter("pageNum");
        String name = request.getParameter("name");
        int pageNum=Integer.valueOf(pageNumString);
        if(null==name || ""==name){
            name="0";
        }
        String paras[]={name};
        final int pageSize=10;

        User user=new User();
        Pager pager=new Pager();
        pager = userService.showPager(user, pageNum, pageSize,paras);

		/*Map mp = new HashMap();
		mp.put("showalllotteryresultlist", showalllotteryresultlist);
		mp.put("pager", pager);
		其中第一个参数为url,第二个参数为要传递的数据的key,第三个参数为数据对象。在这里要注意的是:数据是默认被存放在request中的。*/
        return new ModelAndView("/adminuser/adminshowalluser","pager",pager);
    }

    //更新信息
    @RequestMapping(value="/adminbeforeupdateuser", method={RequestMethod.POST,RequestMethod.GET})
    public ModelAndView beforeUpdateUser(HttpServletRequest request,HttpServletResponse response){
        String name = request.getParameter("name");

        ArrayList<User> adminbeforeupdateuserlist=userService.beforeUpdateUser(name);
        return new ModelAndView("/adminuser/adminbeforeupdateuser","adminbeforeupdateuserlist",adminbeforeupdateuserlist);
    }
    @RequestMapping(value="/adminupdateuser", method={RequestMethod.POST,RequestMethod.GET})
    public ModelAndView updateUser(HttpServletRequest request,HttpServletResponse response){
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String mark = request.getParameter("mark");
        String phone = request.getParameter("phone");
        User user=new User();
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);
        user.setMark(mark);
        user.setPhone(phone);

        userService.updateUser(user);
        return new ModelAndView("redirect:/adminshowalluser?pageNum=1");
    }

    //添加信息
    @RequestMapping(value="/adminadduser", method={RequestMethod.POST,RequestMethod.GET})
    public ModelAndView adminAddUser(HttpServletRequest request,HttpServletResponse response){
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String mark = request.getParameter("mark");
        String phone = request.getParameter("phone");
        User user=new User();
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);
        user.setMark(mark);
        user.setPhone(phone);
        userService.addUser(user);
        return new ModelAndView("redirect:/adminshowalluser?pageNum=1");
    }
    @RequestMapping(value="adminadd",method= RequestMethod.GET)
    public String adminadd(){
        return "/adminuser/adminadduser";
    }

    //删除信息
    @RequestMapping(value="/admindeleteuser", method={RequestMethod.POST,RequestMethod.GET})
    public ModelAndView admindeleteuser(HttpServletRequest request,HttpServletResponse response){
        String[] name = request.getParameterValues("tduCheckBox");
        if(null==name||"".equals(name)){
            return new ModelAndView("redirect:/adminshowalluser?pageNum=1");
        }
        for(int i=0;i<name.length;i++){
            userService.deleteUser(name[i]);
        }
        return new ModelAndView("redirect:/adminshowalluser?pageNum=1");
    }

}
