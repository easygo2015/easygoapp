package com.easygoapp.controllers;

import com.easygoapp.domain.User;
import com.easygoapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.HEAD})
    public String showRegistrationPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveUser(@ModelAttribute User user) {
        if (user.getCar().equals("on,")) {
            user.setCar(null);
        } else {
            String str = user.getCar().substring(4);
            user.setCar(str);
        }
        userService.save(user);

        if (user.getCar() == null) {
            user.setCar("");
        }
        return "userInfo";
    }
}
