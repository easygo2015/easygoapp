package com.easygoapp.controllers;

import com.easygoapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/editProfile", method = {RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView editProfile() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editProfile");
        return modelAndView;
    }
}
