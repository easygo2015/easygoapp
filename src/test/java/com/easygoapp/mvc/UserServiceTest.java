package com.easygoapp.mvc;

import com.easygoapp.config.RootConfig;
import com.easygoapp.domain.User;
import com.easygoapp.domain.UserRole;
import com.easygoapp.service.UserService;
import com.easygoapp.type.Gender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

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

//    @Before
//    public void initForTest(){
//        User user = new User();
//        user.setName("John Doe");
//        user.setEmail("john@doe.us");
//        user.setGender(Gender.MALE);
//        user.setLogin("john123");
//        user.setPassword("password");
//        userService.save(user);
//    }

    @Test
    public void testSave() {
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john@doe.us");
        user.setPhoneNumber("1234567");
        user.setGender(Gender.MALE);
        user.setLogin("john123");
        user.setPassword("password");
        UserRole userRole = new UserRole();
        userRole.setRole("ROLE_USER");
        List<UserRole> userRoles = new ArrayList<UserRole>();
        userRoles.add(userRole);
        user.setUserRoles(userRoles);
        User saved = userService.save(user);
        userService.findOne(saved.getId());
    }

//    @After
//    public void finalizeForTest(){
//        User user = userService.getByLogin("john123");
//        userService.delete(user.getId());
//    }
}
