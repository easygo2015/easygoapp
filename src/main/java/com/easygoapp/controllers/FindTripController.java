package com.easygoapp.controllers;

import com.easygoapp.domain.Trip;
import com.easygoapp.service.PassengerNodePointService;
import com.easygoapp.service.TripService;
import com.easygoapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SCJP on 04.03.2015.
 */
@Controller
@RequestMapping("/trip")
public class FindTripController {

    @Autowired
    private TripService tripService;

    @Autowired
    private UserService userService;

    @Autowired
    private PassengerNodePointService passengerNodePointService;

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView printTrip() {
        Trip trip = tripService.findOne(1l);
        Map<String, Object> map = new HashMap<>();
        map.put("message", trip);
        return new ModelAndView("showTrip", map);
    }
}
