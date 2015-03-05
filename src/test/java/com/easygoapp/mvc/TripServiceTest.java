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
        PassengerNodePoint passengerNodePoint = passengerNodePointService.findOne(passengerNodePoint2_id);
        Trip tripBefore = tripService.findOne(trip_id);
        tripService.addPassengerNodePoint(passengerNodePoint, tripBefore);
        Trip tripAfter = tripService.findOne(trip_id);
        assertEquals(tripAfter.getPassengerNodePoints().size(),2);

    }

    @Test
    public void testRemovePassengerNodePoint(){
        PassengerNodePoint passengerNodePoint = passengerNodePointService.findOne(passengerNodePoint2_id);
        Trip tripBefore = tripService.findOne(trip_id);
        tripService.removePassengerNodePoint(passengerNodePoint, tripBefore);
        Trip tripAfter = tripService.findOne(trip_id);
        assertEquals(tripAfter.getPassengerNodePoints().size(),1);
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
        Trip trip = tripService.findOne(trip_id);
        tripService.cancelTrip(trip);
        List<Trip> trips = tripService.findAll();
        assertTrue(!trips.contains(trip));

    }

    @Test
    public void testAddPassengerNodePointsList(){
        Trip trip = tripService.findOne(trip_id);
        List<PassengerNodePoint> points = new ArrayList<PassengerNodePoint>();
        points.add(passengerNodePointService.findOne(passengerNodePoint1_id));
        points.add(passengerNodePointService.findOne(passengerNodePoint2_id));
        assertTrue(tripService.addPassengerNodePointsList(points, trip).equals(points));
    }

    @Test
    public void testGetTripsByDate(){
        Timestamp currentDate = new Timestamp(System.currentTimeMillis());
        List<Trip> trips = tripService.getTripsByDate(currentDate);
    }

    @Test
    public void testGetTripsByDateInTimeRange(){
        Timestamp currentDate = new Timestamp(System.currentTimeMillis());
        List<Trip> trips = tripService.getTripsByDateInTimeRange(currentDate, 10, 11);
    }

    @Test
    public void testGetTripsByDateAndPassengerNodePoints(){
        Timestamp currentDate = new Timestamp(System.currentTimeMillis());
        List<PassengerNodePoint> points = new ArrayList<PassengerNodePoint>();
        points.add(passengerNodePointService.findOne(passengerNodePoint1_id));
        points.add(passengerNodePointService.findOne(passengerNodePoint2_id));
        List<Trip> trips = tripService.getTripByDateAndPassengerNodePoints(currentDate, 10, 11, points);
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
