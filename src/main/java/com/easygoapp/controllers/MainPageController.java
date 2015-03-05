package com.easygoapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//@Controller
//@RequestMapping("/main")
//public class MainPageController {
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.HEAD})
//    public ModelAndView printMain(){
//        return new ModelAndView("index");
//    }
//}

@Controller
public class MainPageController {
    @RequestMapping(value ={"/main"} , method = {RequestMethod.GET, RequestMethod.HEAD})
    public String showMainPage(){
        return "index";
    }
}