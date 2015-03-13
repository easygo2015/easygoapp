package com.easygoapp.controllers;

import com.easygoapp.domain.Trip;
import com.easygoapp.domain.User;
import com.easygoapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import javax.mail.MessagingException;

/**
 * Created by Markov on 08.03.2015.
 */
@Controller
@RequestMapping("/user/showTrips")
public class ShowUserTripsController {

    @Autowired
    private TripService tripService;

    @Autowired
    private UserService userService;

    @Autowired
    private PassengerNodePointService passengerNodePointService;

    @Autowired
    private ThreadDeleteTrip threadDeleteTrip;

    @Autowired
    private ThreadDeclineTrip threadDeclineTrip;


    @RequestMapping(method = {RequestMethod.GET, RequestMethod.HEAD})
    public String showTrips(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getByLogin(authentication.getName());
        List<Trip> tripsDriver = tripService.findAllFutureTripsForDriver(user);
        List<Trip> tripsPassenger = tripService.findAllFutureTripsForPassenger(user);
        model.addAttribute("tripsDriver", tripsDriver);
        model.addAttribute("tripsPassenger", tripsPassenger);
        return "showTrips";
    }

    @RequestMapping(value = "/deleteTrip", method = RequestMethod.GET)
    public String deleteTrip(@RequestParam("id") long id) throws MessagingException {
        //USING THREAD TO DELETE TRIP AND AVOID WAISTING TIME
        threadDeleteTrip.setId(id);
        Thread thread = new Thread(threadDeleteTrip);
        thread.start();
        return "redirect:/user";
    }

    @RequestMapping(value = "/declineTrip", method = RequestMethod.GET)
    public String declineTrip(@RequestParam("id") long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getByLogin(authentication.getName());
        //USING THREAD TO DECLINE TRIP AND AVOID WAISTING TIME
        threadDeclineTrip.setUserId(user.getId());
        threadDeclineTrip.setTripId(id);
        Thread thread = new Thread(threadDeclineTrip);
        thread.start();
        return "redirect:/user";
    }
}