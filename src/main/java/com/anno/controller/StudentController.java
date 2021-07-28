package com.anno.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 使用注解解析controller
 * @Controller: 将controller注册到容器中
 * @RequestMapping: 声明URL路径，即<bean>标签中的id属性
 * @author Di Guan on 7/28/2021 11:19 AM
 */

@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping("/fetchStudent")
    public ModelAndView test01(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message","test for annotation springmvc");
        modelAndView.setViewName("/test");
        return modelAndView;
    }

}
