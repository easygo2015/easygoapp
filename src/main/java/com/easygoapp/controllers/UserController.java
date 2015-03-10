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
        modelAndView.addObject("oldPassword","");
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
}
