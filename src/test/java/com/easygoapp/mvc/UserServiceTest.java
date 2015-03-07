package com.easygoapp.mvc;

import com.easygoapp.config.RootConfig;
import com.easygoapp.domain.User;
import com.easygoapp.service.UserService;
import com.easygoapp.type.Gender;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;

/**
 * Created by Admin on 04.03.15.
 */
@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = RootConfig.class)
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Before
    public void initForTest(){
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john@doe.us");
        user.setGender(Gender.MALE);
        user.setLogin("john123");
        user.setPassword("password");
        userService.save(user);
    }



    @After
    public void finalizeForTest(){
        User user = userService.getByLogin("john123");
        userService.delete(user.getId());
    }
}
