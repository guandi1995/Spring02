package com.anno.controller;

import com.anno.pojo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

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

    //接收参数

    /**
     * 名字一致
     * 接收的参数名字username和password 与 <input>标签中的name属性值 一致
     * 自动映射
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/receiveParam01")
    public String receiveParam01(String username, String password){
        System.out.println(username);
        System.out.println(password);
        return "/test";
    }

    /**
     * 名字不一致
     * 接收的参数名字pwd 与<input>标签中的name属性值password 不一致
     * 需要使用@RequestParam(name="password")进行映射
     * 也可以指定required，默认为true，即前台必须传递该参数
     * @param username
     * @param pwd
     * @return
     */
    @RequestMapping("/receiveParam02")
    public String receiveParam02(String username,
                                 @RequestParam(name = "password", required = true) String pwd){
        System.out.println(username);
        System.out.println(pwd);
        return "/test";
    }

    /**
     * 接收map集合
     * 使用@RequestParam接收map集合，自动将form标签中的内容封装到map中传递进来
     * @param map
     * @return
     */
    @RequestMapping("/receiveParam03")
    public String receiveParam03(@RequestParam Map map){
        System.out.println(map);
        System.out.println(map.get("username"));
        System.out.println(map.get("password"));
        return "/test";
    }

    /**
     * 接收实体pojo
     * 不需要使用@RequestParam，就可以自动将form标签中的内容封装到实体中传递进来
     * @param student
     * @return
     */
    @RequestMapping("/receiveParam04")
    public String receiveParam04(Student student){
        System.out.println(student);
        System.out.println(student.getUsername());
        System.out.println(student.getPassword());
        return "/test";
    }
}
