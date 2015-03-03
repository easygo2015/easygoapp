package com.easygoapp.mvc;

import com.easygoapp.config.PersistenceConfig;
import com.easygoapp.domain.Trip;
import com.easygoapp.domain.User;
import com.easygoapp.service.TripService;
import com.easygoapp.service.UserService;
import com.easygoapp.mvc.config.PersistanceConfig;
import com.easygoapp.mvc.domain.PassengerNodePoint;
import com.easygoapp.mvc.domain.Trip;
import com.easygoapp.mvc.domain.User;
import com.easygoapp.mvc.service.PassengerNodePointService;
import com.easygoapp.mvc.service.TripService;
import com.easygoapp.mvc.service.UserService;
import com.easygoapp.mvc.type.Gender;
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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = PersistenceConfig.class)
public class DaoTripTest {

    @Autowired
    private TripService tripService;

    @Autowired
    private UserService userService;

    @Autowired
    private PassengerNodePointService passengerNodePointService;

//    @Before
//    public void saveUser(){
//        User user = new User();
//        user.setPhoneNumber("000-000-00-00");
//        user.setCar("lexus");
//        user.setGender(Gender.MALE);
//        user.setLogin("Markov");
//        user.setPassword("1234");
//        User user1 = userService.saveUser(user);
//        System.out.println(user1);
//
//        User passanger = new User();
//        passanger.setPhoneNumber("000-000-00-00");
//        passanger.setCar("lexus");
//        passanger.setGender(Gender.MALE);
//        passanger.setLogin("adf");
//        passanger.setPassword("1234");
//        User saved = userService.saveUser(passanger);
//        System.out.println(saved);
//    }

    @Test
    public void saveTripWithRatio(){
        Trip trip = new Trip();
        trip.setCarCapacity(3);
        User driver = userService.getById(1l);
        System.out.println(driver);
        trip.setDriver(driver);
        trip.setPrice(5d);
        trip.setStartTime(new Timestamp(System.currentTimeMillis()));

        List<User> companions = new ArrayList<>();
        User user1 = userService.getById(1l);
        User user2 = userService.getById(2l);
        companions.add(user1);
        companions.add(user2);

        trip.setCompanions(companions);

        Trip savedTrip = tripService.save(trip);
        System.out.println(savedTrip);
    }

    @Test
    public void saveWithPnp(){

        Trip trip = new Trip();
        trip.setCarCapacity(3);
        User driver = userService.getById(1l);
        System.out.println(driver);
        trip.setDriver(driver);
        trip.setPrice(5d);
        trip.setStartTime(new Timestamp(System.currentTimeMillis()));
        List<PassengerNodePoint> points = new ArrayList<>();
        PassengerNodePoint point = passengerNodePointService.getById(1l);
        System.out.println(point);
        points.add(point);
        trip.setPassengerNodePoints(points);
        tripService.save(trip);
    }

    @Test
    public void getAllTrips() throws ParseException {
        System.out.println("getAllTrips");
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = dateFormat.parse("02/03/2015");
        long time = date.getTime();
        Timestamp start = new Timestamp(time);
        List<Trip> trips = tripService.getBetweenStartAndEnd(start, new Timestamp(System.currentTimeMillis()));
        for (Trip trip: trips){
        System.out.println(trip);
        }
    }

}