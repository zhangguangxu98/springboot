package com.springboot.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    private final static Logger logger= LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(value=Exception.class)
    @ResponseBody
    public void exceptionHandler(HttpServletRequest req, Exception e){
        logger.info(e.getMessage());
//        Map<String,Object> modulemap=new HashMap<String,Object>();
//        modulemap.put("success",false);
//        modulemap.put("errMsg",e.getMessage());
//        return modulemap;
    }
}
