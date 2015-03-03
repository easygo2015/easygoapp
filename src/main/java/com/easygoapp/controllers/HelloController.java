package com.easygoapp.controllers;

import com.easygoapp.domain.User;
import com.easygoapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class HelloController {

    @Autowired
    private UserService userService;

	@RequestMapping(method = {RequestMethod.GET, RequestMethod.HEAD})
	public ModelAndView printWelcome() {
        User toView = userService.getById(1L);
//        model.addAttribute("message", toView.toString());
        Map<String, Object> map = new HashMap<>();
        map.put("message", toView.toString());
        return new ModelAndView("hello", map);
	}
}