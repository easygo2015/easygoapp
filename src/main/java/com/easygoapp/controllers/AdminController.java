package com.easygoapp.controllers;

import com.easygoapp.domain.User;
import com.easygoapp.service.UserService;
import com.easygoapp.type.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin/**")
public class AdminController {

    @Autowired
    BCryptPasswordEncoder encoder;

    @Autowired
    UserService userService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/admin/usersList", method = RequestMethod.GET)
    public ModelAndView getUsersList(ModelAndView modelAndView) {
        List<User> allUsers = userService.findAll();
        modelAndView.addObject("usersList", allUsers);
        modelAndView.setViewName("admin");
        return modelAndView;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/admin/userlist/edit", method = RequestMethod.GET)
    public ModelAndView editUser(ModelAndView modelAndView, HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        User userToEdit = userService.findOne(id);
        modelAndView.addObject("userToEdit", userToEdit);
        modelAndView.setViewName("editUser");
        return modelAndView;
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    @RequestMapping(value="/admin/userlist/edit**", method=RequestMethod.POST)
//    public String result(@ModelAttribute("editUserForm")User user,
//            BindingResult result,
//            Model model){
//        return "admin";
//    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/admin/userlist/edit**", method = RequestMethod.POST)
    public ModelAndView editedUser(ModelAndView modelAndView, HttpServletRequest request) {
        User editedUser = getUserFromHttpRequest(request);
        userService.save(editedUser);
        modelAndView.addObject("editedUser", editedUser);
        modelAndView.setViewName("editUser");
        return modelAndView;
    }

    public User getUserFromHttpRequest(HttpServletRequest request) {
        User result = new User();
        result.setId(Long.parseLong(request.getParameter("id")));
        result.setName(request.getParameter("name"));
        result.setPassword(request.getParameter("password"));
        result.setLogin(request.getParameter("login"));
        result.setEmail(request.getParameter("email"));
        result.setPhoneNumber(request.getParameter("phone"));
        if (request.getParameter("gender").equals("MALE")) {
            result.setGender(Gender.MALE);
        } else {
            result.setGender(Gender.FEMALE);
        }
        return result;
    }
}
