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

    @Test
    public void masha() {
        User user = new User();
        user.setName("user2");
        user.setEmail("us@ad.us");
        user.setPhoneNumber("78945612");
        user.setGender(Gender.MALE);
        user.setCar("my car");
        user.setLogin("user2");
        user.setPassword("password");
        UserRole userRole = new UserRole();
        userRole.setRole("ROLE_USER");
        List<UserRole> userRoles = new ArrayList<UserRole>();
        userRoles.add(userRole);
        user.setUserRoles(userRoles);
        User saved = userService.save(user);
        User getSaved = userService.findOne(saved.getId());
    }

//    @Before
//    public void save(){
//        User user = new User();
//        user.setPhoneNumber("000-000-00-00");
//        user.setCar("lexus");
//        user.setGender(Gender.MALE);
//        user.setLogin("Markov");
//        user.setPassword("1234");
//        user.setEmail("wer@wer.com");
//        User user1 = userService.save(user);
//        id = user1.getId();
//        System.out.println(id);
//        System.out.println(user1);
//    }
    @Test
    public void saveUser() {
    User user = new User();
    user.setPhoneNumber("000-000-00-00");
    user.setCar("lexus");
    user.setGender(Gender.MALE);
    user.setLogin("Markov");
    user.setPassword("123456");
        user.setName("Stas");
    user.setEmail("wer@wer.com");
        userService.save(user);
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
        User user = userService.findOne(1l);
        System.out.println(user);
    }



}
