package com.springboot.aspect;

import com.springboot.util.StringUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Aspect
@Component
public class HttpAspect {
    private final static Logger logger= LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution (public * com.springboot.controller..*.*(..)))")
    public void log(){
    }
    @Before("log()")
    public void doBefore(JoinPoint joinPoint) throws IOException {
        ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        HttpSession sessio = request.getSession(true);
        HttpServletResponse response=attributes.getResponse();
        if(StringUtil.isEmpty((String) sessio.getAttribute("sess"))){
            response.sendRedirect(request.getContextPath() + "/login");
        }
        logger.info("方法开始");
        logger.info("url={}",request.getRequestURL());
        logger.info("method={}",request.getRequestURL());
        logger.info("ip={}",request.getRemoteAddr());
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        logger.info("args={}",joinPoint.getArgs());
    }
    @After("log()")
    public void doAfter(){
        logger.info("方法结束");
    }
    @AfterReturning(returning="object",pointcut="log()")
    public void doAfterReturning(Object object){
        logger.info("response={}",object.toString());
    }
}
