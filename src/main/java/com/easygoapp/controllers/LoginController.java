package com.easygoapp.controllers;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Padonag on 04.03.2015.
 */
@Controller

public class LoginController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView logged(){
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        return model;
    }

    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public ModelAndView adminPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Hello World");
        model.addObject("message", "This is protected page - ADMIN Page!");
        model.setViewName("message");

        return model;

    }

    @RequestMapping(value = "/user**", method = RequestMethod.GET)
    public ModelAndView dbaPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Hello World");
        model.addObject("message", "This is protected page - USER Page!");
        model.setViewName("message");

        return model;

    }

//    @RequestMapping(value = "/message**", method = RequestMethod.GET)
//    public ModelAndView message() {
//
//        ModelAndView model = new ModelAndView();
//        model.addObject("title", "Spring Security Hello World");
//        model.addObject("message", "This is protected page - Under Spring Security Page!");
//        model.setViewName("message");
//
//        return model;
//
//    }

    //for 403 access denied page
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accesssDenied() {

        ModelAndView model = new ModelAndView();

        //check if user is login
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            model.addObject("username", userDetail.getUsername());
        }

        model.setViewName("403");
        return model;

    }
}
