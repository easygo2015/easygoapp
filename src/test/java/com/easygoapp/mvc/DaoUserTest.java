package com.easygoapp.mvc;

import com.easygoapp.config.RootConfig;
import com.easygoapp.domain.User;
import com.easygoapp.service.UserService;
import com.easygoapp.type.Gender;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = RootConfig.class)
public class DaoUserTest {

    Long id;

    @Autowired
    private UserService userService;

    @Before
    public void save(){
        User user = new User();
        user.setPhoneNumber("000-000-00-00");
        user.setCar("lexus");
        user.setGender(Gender.MALE);
        user.setLogin("Markov");
        user.setPassword("1234");
        user.setEmail("bbb@bb.bb");
        User user1 = userService.save(user);
        id = user1.getId();
        System.out.println(id);
        System.out.println(user1);
    }

//    @After
//    public void deleteUser(){
//        System.out.println("deleteUser");
//        userService.delete(id);
//    }
//
//    @Test
//    public void getUserByLogin(){
//        System.out.println("getByLogin");
//        User user = userService.getByLogin("Markov");
//        System.out.println(user);
//    }

//    @Test
//    public void getUserById(){
//        System.out.println("getById");
//        User user = userService.findOne(id);
//        System.out.println(user);
//    }
    @Test
    public void testUpdate(){
        System.out.println("getById");
        User user = userService.findOne(id);
        user.setCar("FFFFFF");
        User saved = userService.save(user);
        System.out.println(saved);
    }




}
