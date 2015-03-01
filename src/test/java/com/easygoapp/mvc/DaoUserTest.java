package com.easygoapp.mvc;

import com.easygoapp.mvc.config.DataConfig;
import com.easygoapp.mvc.domain.User;
import com.easygoapp.mvc.service.UserService;
import com.easygoapp.mvc.type.Gender;
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
@ContextConfiguration(classes = DataConfig.class)
public class DaoUserTest {

    @Autowired
    private UserService userService;

    @Test
    public void access() {
        System.out.println("getUser");
        User user = userService.getById(1l);
        System.out.println(user);
    }

    @Test
    public void save(){

        System.out.println("saveUser");
        User user = new User();
        user.setPhoneNumber("000-000-00-00");
        user.setCar("lexus");
        user.setGender(Gender.MALE);
        user.setLogin("Markov");
        user.setPassword("1234");
        User user1 = userService.saveUser(user);
        System.out.println(user1);
    }

    @Test
    public void delete(){
        System.out.println("deleteUser");
        userService.delete(2l);
    }



    @Test
    public void getUserByLogin(){
        System.out.println("getByLogin");
        User user = userService.getByLogin("aaaaa");
        System.out.println(user);
    }

    @Test
    public void getUserById(){
        System.out.println("getById");
        User user = userService.getById(1l);
        System.out.println(user);
    }

}
