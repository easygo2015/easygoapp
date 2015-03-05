package com.easygoapp.controllers;

import com.easygoapp.domain.PassengerNodePoint;
import com.easygoapp.domain.Trip;
import com.easygoapp.domain.User;
import com.easygoapp.service.PassengerNodePointService;
import com.easygoapp.service.TripService;
import com.easygoapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Markov on 04.03.2015.
 */
@Controller
@RequestMapping("/createTrip")
public class CreateTripController {

    @Autowired
    private TripService tripService;

    @Autowired
    private UserService userService;

    @Autowired
    private PassengerNodePointService passengerNodePointService;

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.HEAD})
    public String createTrip(Model model) {
        List<PassengerNodePoint> points = passengerNodePointService.findAll();
        points.size();
        model.addAttribute("points", points);
        model.addAttribute("trip", new Trip());
        return "createTrip";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveTrip(@ModelAttribute Trip trip) {
        User driver = userService.findOne(1l);
        trip.setDriver(driver);
        List<User> companions = new ArrayList<>();
        companions.add(driver);
        trip.setCompanions(companions);
        PassengerNodePoint point = passengerNodePointService.findOne(1l);
        List<PassengerNodePoint> points = new ArrayList<>();
        points.add(point);
        trip.setPassengerNodePoints(points);
        tripService.save(trip);
        return "index";
    }

}
