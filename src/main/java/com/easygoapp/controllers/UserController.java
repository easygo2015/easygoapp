package com.easygoapp.controllers;

import com.easygoapp.domain.User;
import com.easygoapp.dto.PasswordObject;
import com.easygoapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/user/editProfile")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    BCryptPasswordEncoder encoder;

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView editProfile(ModelAndView modelAndView) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getByLogin(authentication.getName());
        modelAndView.setViewName("editProfile");
        modelAndView.addObject("user", user);
        PasswordObject pass = new PasswordObject();
        modelAndView.addObject("pass",pass);
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

    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView savePassword(ModelAndView modelAndView, @ModelAttribute("pass") PasswordObject pass,
                                     BindingResult result) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getByLogin(authentication.getName());
        String currentPassword = pass.getCurrentPassword();
        String newPassword = pass.getNewPassword();
        System.out.println("current password from jsp "+user.getPassword());
        if (encoder.matches(currentPassword, user.getPassword())){
            user.setPassword(encoder.encode(newPassword));
            userService.save(user);
        }
        System.out.println(newPassword);
        modelAndView.setViewName("editProfile");
        modelAndView.addObject("user", user);
        modelAndView.addObject("mes","password changed successfully");
        System.out.println(pass.getNewPassword());
        System.out.println(pass.getCurrentPassword());
        System.out.println("post is working");
        return modelAndView;
    }


}
