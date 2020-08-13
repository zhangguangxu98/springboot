package com.springboot.filter;

import com.google.gson.Gson;
import com.springboot.entity.User;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginFilter {
    private final static Logger logger= LoggerFactory.getLogger(LoginFilter.class);
    @Resource(name="userService")
    private UserService userService;

    @RequestMapping(value="login",method= RequestMethod.GET)
    public String login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().setAttribute("sess", "");
        return "userlogin";
    }

    @RequestMapping(value="userlogin",method={RequestMethod.POST,RequestMethod.GET})
    public ModelAndView userLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.info("登录成功：");
        String error="没有该账户或者密码错误";
        String markerror="没有该角色";
        String[] str={"admin","employee","leader"};
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        Map mp=new HashMap();
        List<User> userlist=userService.userLogin(name,password);
        if(userlist.size()==0){
            return new ModelAndView("userlogin","error",error);
        }else{
            request.getSession().setAttribute("sess", userlist.get(0).getMark());
            User userPojo=userlist.get(0);
            boolean flag=false;
            for(int i=0;i<str.length;i++){
                if(str[i].equals(userPojo.getMark())){
                    flag=true;
                }
            }
            if(flag){
                return new ModelAndView("/adminhome/adminhome");
            }else{
                return new ModelAndView("userlogin","error",markerror);
            }
        }

    }
}
