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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

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

    private Long driver_id, passenger1_id, passenger2_id, trip_id,
            passengerNodePoint1_id, passengerNodePoint2_id;

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
        passengerNodePoint1 = passengerNodePointService.save(passengerNodePoint1);
        passengerNodePoint1_id = passengerNodePoint1.getId();

        PassengerNodePoint passengerNodePoint2 = new PassengerNodePoint();
        passengerNodePoint2.setLongitude(111d);
        passengerNodePoint2.setLatitude(1115d);
        passengerNodePoint2.setDescription("aaaaa");
        passengerNodePoint2.setLeft(false);
        passengerNodePoint2 = passengerNodePointService.save(passengerNodePoint2);
        passengerNodePoint2_id = passengerNodePoint2.getId();

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
        tripService.addPassenger(trip_id, passenger2_id);
        Trip trip = tripService.findOneEager(trip_id);
        assertEquals(3, trip.getCompanions().size());
    }

    @Test
    public void testRemovePassenger(){
        tripService.removePassenger(trip_id, passenger1_id);
        Trip trip = tripService.findOneEager(trip_id);
        assertEquals(1, trip.getCompanions().size());
    }

    @Test
    public void testAddPassengerNodePoint(){
        tripService.addPassengerNodePoint(trip_id, passengerNodePoint2_id);
        Trip tripAfter = tripService.findOneEager(trip_id);
        assertEquals(2, tripAfter.getPassengerNodePoints().size());

    }

    @Test
    public void testRemovePassengerNodePoint(){
        tripService.removePassengerNodePoint(trip_id, passengerNodePoint2_id);
        Trip tripAfter = tripService.findOneEager(trip_id);
        assertEquals(1, tripAfter.getPassengerNodePoints().size());
    }

    @Test
    public void testModifyTrip(){
        Trip modifiedTrip;
        int wantedCapacity;
        int realCapacity;
        Trip trip = tripService.findOne(trip_id);
        List<User> companions = trip.getCompanions();
        companions.add(userService.findOne(passenger2_id));
        trip = tripService.save(trip);
        //modify1
        trip.setPrice(40d);
        trip.setStartTime(new Timestamp(System.currentTimeMillis()));
        trip.setCarCapacity(2);
        wantedCapacity = trip.getCarCapacity();
        modifiedTrip = tripService.modifyTrip(trip);
        realCapacity = modifiedTrip.getCarCapacity();
        assertEquals(wantedCapacity, realCapacity);
        assertEquals(trip.getPrice(), modifiedTrip.getPrice());
        assertEquals(trip.getStartTime(), trip.getStartTime());
        //modify2
        trip.setCarCapacity(1);
        wantedCapacity = trip.getCarCapacity();
        modifiedTrip = tripService.modifyTrip(trip);
        realCapacity = modifiedTrip.getCarCapacity();
        assertNotEquals(wantedCapacity, realCapacity);
        assertEquals(trip.getPrice(), modifiedTrip.getPrice());
        assertEquals(trip.getStartTime(), trip.getStartTime());
    }

    @Test
    public void testCancelTrip(){
        Trip trip = tripService.findOneEager(trip_id);
        tripService.cancelTrip(trip);
        List<Trip> trips = tripService.findAll();
        assertTrue(!trips.contains(trip));
    }

    @Test
    public void testSetPassengerNodePointsList(){
        List<PassengerNodePoint> points = new ArrayList<PassengerNodePoint>();
        points.add(passengerNodePointService.findOne(passengerNodePoint1_id));
        points.add(passengerNodePointService.findOne(passengerNodePoint2_id));
        tripService.setPassengerNodePointsList(trip_id,points);
        Trip trip = tripService.findOneEager(trip_id);
        assertTrue(trip.getPassengerNodePoints().size() == points.size());
    }

    @Test
    public void testGetBetweenStartAndEnd(){
        Timestamp startDate = new Timestamp(System.currentTimeMillis()-10000000);
        Timestamp endDate = new Timestamp(System.currentTimeMillis());
        List<Trip> trips = tripService.getBetweenStartAndEnd(startDate,endDate);
        assertTrue(trips.size()>0);

    }

    @After
    public void finalizeForTest(){
        tripService.delete(trip_id);
        userService.delete(driver_id);
        userService.delete(passenger1_id);
        userService.delete(passenger2_id);
        passengerNodePointService.delete(passengerNodePoint1_id);
        passengerNodePointService.delete(passengerNodePoint2_id);
    }

}
