package com.easygoapp.controllers;

import com.easygoapp.domain.User;
import com.easygoapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/user/editProfile")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView editProfile(ModelAndView modelAndView) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getByLogin(authentication.getName());
        modelAndView.setViewName("editProfile");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView saveUserChanges(ModelAndView modelAndView, @ModelAttribute("user") User user,
            BindingResult result) {
        User modifiedUser = userService.getByLogin(user.getLogin());
        modifiedUser.setName(user.getName());
        modifiedUser.setEmail(user.getEmail());
        modifiedUser.setPhoneNumber(user.getPhoneNumber());
        modifiedUser.setGender(user.getGender());
        modifiedUser.setCar(user.getCar());
        userService.save(modifiedUser);
        modelAndView.setViewName("user");
        return modelAndView;
    }

    @RequestMapping(value = "/deleteProfile", method = {RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView deleteUser(ModelAndView modelAndView) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getByLogin(authentication.getName());
        userService.delete(user.getId());
        SecurityContextHolder.clearContext();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/changePassword", method = {RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView changePassword(ModelAndView modelAndView) {
        modelAndView.addObject("user", new User());
        modelAndView.addObject("message", "message");
        Map<String, String> modelMap = new HashMap<String, String>();
        modelMap.put("currentPassword", "");
        modelMap.put("newPassword", "");
        modelAndView.addObject("modelMap", modelMap);
        modelAndView.setViewName("editProfile");
        System.out.println("get is working");
        return modelAndView;
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    public ModelAndView savePassword(ModelAndView modelAndView,
            @ModelAttribute("modelMap") HashMap<String, String> modelMap,
            BindingResult result) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getByLogin(authentication.getName());
        //user.setPassword(password);
        //userService.save(user);
        //modelAndView.setViewName("user");
        System.out.println("post is working");
        return modelAndView;
    }
}
