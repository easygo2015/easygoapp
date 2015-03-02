package com.easygoapp.mvc;

import com.easygoapp.config.PersistenceConfig;
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
@ContextConfiguration(classes = PersistenceConfig.class)
public class DaoUserTest {

    Long id;

    @Autowired
    private UserService userService;

    @Before
    public void saveUser(){
        User user = new User();
        user.setPhoneNumber("000-000-00-00");
        user.setCar("lexus");
        user.setGender(Gender.MALE);
        user.setLogin("Markov");
        user.setPassword("1234");
        User user1 = userService.saveUser(user);
        id = user1.getId();
        System.out.println(id);
        System.out.println(user1);
    }

    @After
    public void deleteUser(){
        System.out.println("deleteUser");
        userService.delete(id);
    }

    @Test
    public void getUserByLogin(){
        System.out.println("getByLogin");
        User user = userService.getByLogin("Markov");
        System.out.println(user);
    }

    @Test
    public void getUserById(){
        System.out.println("getById");
        User user = userService.getById(1l);
        System.out.println(user);
    }

}
