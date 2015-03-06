package com.easygoapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Padonag on 03.03.2015.
 */
@Controller
@RequestMapping("/")
public class MainPageController {

@RequestMapping(method = RequestMethod.GET)
public ModelAndView getMainPage(){
    return new ModelAndView("main");
}
}
