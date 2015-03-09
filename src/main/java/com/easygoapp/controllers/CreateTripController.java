package com.easygoapp.controllers;

import com.easygoapp.domain.PassengerNodePoint;
import com.easygoapp.domain.Trip;
import com.easygoapp.domain.User;
import com.easygoapp.service.PassengerNodePointService;
import com.easygoapp.service.TripService;
import com.easygoapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Markov on 04.03.2015.
 */
@Controller
@RequestMapping("/user/createTrip")
public class CreateTripController {

    @Autowired
    private TripService tripService;

    @Autowired
    private UserService userService;

    @Autowired
    private PassengerNodePointService passengerNodePointService;

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.HEAD})
    public String createTrip(Model model) {
        List<PassengerNodePoint> points = passengerNodePointService.findAll();
        points.size();
        List<Integer> listCount20 = new ArrayList<>();
        for (int i = 1; i < 21; i++) {
            listCount20.add(i);
        }
        model.addAttribute("list", listCount20);
        model.addAttribute("points", points);
        model.addAttribute("trip", new Trip());
        return "createTrip";
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(method = RequestMethod.POST)
    public String saveTrip(@ModelAttribute Trip trip, String startDate) throws ParseException {
        //here must be current user from session
        User driver = userService.getByLogin("Markov");
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        Date date = dateFormat.parse(startDate);
        long time = date.getTime();
        Timestamp start = new Timestamp(time);
        trip.setStartTime(start);
        trip.setDriver(driver);
        List<User> companions = new ArrayList<>();
        companions.add(driver);
        trip.setCompanions(companions);
        List<PassengerNodePoint> points = trip.getPassengerNodePoints();
        Iterator iterator = points.iterator();
        while (iterator.hasNext()){
            PassengerNodePoint point = (PassengerNodePoint) iterator.next();
            if(point.getId() == null){
                iterator.remove();
            }
        }
        tripService.save(trip);
        return "index";
    }

}
