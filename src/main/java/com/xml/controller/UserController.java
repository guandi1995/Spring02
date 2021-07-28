package com.xml.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * controller with xml-based configuration
 * 即Handler，需要注册到容器中
 * @author Di Guan on 7/28/2021 10:33 AM
 */

public class UserController implements Controller {

    //implements Controller接口，重写handleRequest()方法
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        //addObject相当于set Model
        modelAndView.addObject("message", "test for springMVC xml-based configuration");
        //setViewName即set View，ViewResolver对viewName进行解析变成/view/test.jsp
        modelAndView.setViewName("/test");
        return modelAndView;
    }
}
