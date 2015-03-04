package com.easygoapp.mvc;

import com.easygoapp.config.RootConfig;
import com.easygoapp.domain.Trip;
import com.easygoapp.domain.User;
import com.easygoapp.service.TripService;
import com.easygoapp.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 04.03.15.
 */
@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = RootConfig.class)
public class TripServiceTest {
    @Autowired
    private TripService tripService;

    @Autowired
    private UserService userService;

    @Before
    public void initForTest(){
        User driver = new User();

        Trip trip = new Trip();
        trip.setCarCapacity(3);

        trip.setDriver(driver);
        trip.setPrice(5d);
        trip.setStartTime(new Timestamp(System.currentTimeMillis()));

        List<User> companions = new ArrayList<>();
        User user1 = userService.findOne(1l);
        User user2 = userService.findOne(2l);
        companions.add(user1);
        companions.add(user2);

        trip.setCompanions(companions);
    }

    @Test
    public void testAddPassenger(){

    }

    @After
    public void finalizeForTest(){

    }

}
