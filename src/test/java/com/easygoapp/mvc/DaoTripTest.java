package com.easygoapp.mvc;

import com.easygoapp.mvc.config.PersistanceConfig;
import com.easygoapp.mvc.domain.Trip;
import com.easygoapp.mvc.domain.User;
import com.easygoapp.mvc.service.TripService;
import com.easygoapp.mvc.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.sql.Timestamp;


@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = PersistanceConfig.class)
public class DaoTripTest {

    @Autowired
    private TripService tripService;

    @Autowired
    private UserService userService;

    @Test
    public void saveJustTrip(){
        Trip trip = new Trip();
        trip.setCarCapacity(3);
        User driver = userService.getById(1l);
        System.out.println(driver);
        trip.setDriver(driver);
        trip.setPrice(5d);
        trip.setStartTime(new Timestamp(System.currentTimeMillis()));
        Trip savedTrip = tripService.save(trip);
        System.out.println(savedTrip);
    }


//    @Test
//    public void saveWithDriver(){
//
//        Trip trip = new Trip();
//        trip.setCarCapacity(3);
//        User driver = userService.getById(1l);
//        System.out.println(driver);
//        trip.setDriver(driver);
//        trip.setPrice(5d);
//        trip.setStartTime(new Timestamp(System.currentTimeMillis()));
//
//        List<Trip> trips = new ArrayList<>();
//        trips.add(trip);
//        driver.setTrips(trips);
//        Trip savedTrip = tripService.save(trip);
//        System.out.println(savedTrip);
//
//        List<Trip> trips = new ArrayList<>();
//        trips.add(trip);
//        driver.setTrips(trips);
//
//        List<PassengerNodePoint> points = new ArrayList<>();
//
//        PassengerNodePoint point = new PassengerNodePoint();
//        point.setDescription("one");
//        point.setLatitude(111d);
//        point.setLongitude(222d);
//        point.setLeft(true);
//
//        points.add(point);
//
//        trip.setPassengerNodePoints(points);
//
//    }

}
