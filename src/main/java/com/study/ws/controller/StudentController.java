package com.study.ws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.HashMap;

@Controller()
//@RequestMapping("/")
public class StudentController {

//    @Resource(name="druidDataSource")
//    @Autowired
//    DruidDataSource druidDataSource;

    @RequestMapping("/st")
    public ModelAndView test( ) throws SQLException {
        ModelAndView mv = new ModelAndView();
        mv.addObject("inlinevalue", "行内写法值");
        mv.addObject("msg", "from 数据库");
        mv.addObject("msg2", "<h5>这是从数据库取出的数据2!</h5>");
        mv.addObject("msg3", "<h5>这是从数据库取出的数据3!</h5>");
        mv.setViewName("/demo");
        return mv;
    }
}
