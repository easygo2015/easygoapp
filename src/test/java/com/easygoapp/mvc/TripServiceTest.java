package com.easygoapp.mvc;

import com.easygoapp.config.RootConfig;
import com.easygoapp.domain.PassengerNodePoint;
import com.easygoapp.domain.Trip;
import com.easygoapp.domain.User;
import com.easygoapp.service.PassengerNodePointService;
import com.easygoapp.service.TripService;
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

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

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

    @Autowired
    private PassengerNodePointService passengerNodePointService;

    private Long driver_id;
    private Long passenger1_id;
    private Long passenger2_id;
    private Long trip_id;

    @Before
    public void initForTest(){
        //get driver
        User driver = new User();
        driver.setName("Luke Driver");
        driver.setEmail("luke@l.l");
        driver.setCar("Car");
        driver.setGender(Gender.MALE);
        driver.setLogin("bro");
        driver.setPassword("bro999");
        driver = userService.save(driver);
        driver_id = driver.getId();
        //get passengers
        User passenger1 = new User();
        passenger1.setName("Jack");
        passenger1.setLogin("black_jack");
        passenger1.setEmail("jack@jack.mi");
        passenger1.setGender(Gender.MALE);
        passenger1.setPassword("blabla");
        passenger1 = userService.save(passenger1);
        passenger1_id = passenger1.getId();

        User passenger2 = new User();
        passenger2.setName("Jane");
        passenger2.setLogin("janee");
        passenger2.setEmail("jane@j.mi");
        passenger2.setGender(Gender.FEMALE);
        passenger2.setPassword("blabla");
        passenger2 = userService.save(passenger2);
        passenger2_id = passenger2.getId();

        // create pnps
        PassengerNodePoint passengerNodePoint1 = new PassengerNodePoint();
        passengerNodePoint1.setLongitude(5454d);
        passengerNodePoint1.setLatitude(54545d);
        passengerNodePoint1.setDescription("bldsdd");
        passengerNodePoint1.setLeft(true);
        passengerNodePointService.save(passengerNodePoint1);

        PassengerNodePoint passengerNodePoint2 = new PassengerNodePoint();
        passengerNodePoint2.setLongitude(5454d);
        passengerNodePoint2.setLatitude(54545d);
        passengerNodePoint2.setDescription("bldsdd");
        passengerNodePoint2.setLeft(true);
        passengerNodePointService.save(passengerNodePoint2);

        Trip trip = new Trip();
        trip.setCarCapacity(3);
        trip.setDriver(driver);
        trip.setPrice(5d);
        trip.setStartTime(new Timestamp(System.currentTimeMillis()));

        List<User> companions = new ArrayList<User>();
        companions.add(userService.findOne(driver_id));
        companions.add(userService.findOne(passenger1_id));
        trip.setCompanions(companions);

        List<PassengerNodePoint> points = new ArrayList<PassengerNodePoint>();
        points.add(passengerNodePoint1);
        trip.setPassengerNodePoints(points);

        trip = tripService.save(trip);
        trip_id = trip.getId();
    }

    @Test
    public void testAddPassenger(){
        Trip trip = tripService.findOne(trip_id);
        User user = userService.findOne(passenger2_id);
        tripService.addPassenger(user, trip);
        Trip trip1 = tripService.findOne(trip_id);
        assertEquals(trip1.getCompanions().size(), 3);
    }

    @Test
    public void testRemovePassenger(){
        Trip trip = tripService.findOne(trip_id);
        User user = userService.findOne(passenger1_id);
        tripService.removePassenger(user, trip);
        Trip trip1 = tripService.findOne(trip_id);
        assertEquals(trip1.getCompanions().size(), 1);
    }

    @Test
    public void testAddPassengerNodePoint(){
        PassengerNodePoint passengerNodePoint = passengerNodePointService.findOne(1l);
        Trip tripBefore = tripService.findOne(trip_id);
        tripService.addPassengerNodePoint(passengerNodePoint, tripBefore);
        Trip tripAfter = tripService.findOne(trip_id);
        assertEquals(tripAfter.getPassengerNodePoints().size(),2);

    }

    @After
    public void finalizeForTest(){
        tripService.delete(trip_id);
        userService.delete(driver_id);
        userService.delete(passenger1_id);
        userService.delete(passenger2_id);
    }

}
