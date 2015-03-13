package com.easygoapp.service.impl;

import com.easygoapp.domain.PassengerNodePoint;
import com.easygoapp.domain.Trip;
import com.easygoapp.domain.User;
import com.easygoapp.service.ThreadCreateTrip;
import com.easygoapp.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Transactional(readOnly = true)
@Service
public class ThreadCreateTripImpl implements ThreadCreateTrip {

    private Trip trip;
    private User driver;
    private String startDate;

    @Autowired
    private TripService tripService;

    @Override
    public Trip getTrip() {
        return trip;
    }

    @Override
    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    @Override
    public String getStartDate() {
        return startDate;
    }

    @Override
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @Override
    public User getDriver() {
        return driver;
    }

    @Override
    public void setDriver(User driver) {
        this.driver = driver;
    }

    @Transactional
    @Override
    public void run() {
        try {
            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            Date date = null;
            date = dateFormat.parse(startDate);
            long time = date.getTime();
            Timestamp start = new Timestamp(time);
            trip.setStartTime(start);
            trip.setDriver(driver);
            List<PassengerNodePoint> points = trip.getPassengerNodePoints();
            Iterator iterator = points.iterator();
            while (iterator.hasNext()) {
                PassengerNodePoint point = (PassengerNodePoint) iterator.next();
                if (point.getId() == null) {
                    iterator.remove();
                }
            }
            tripService.save(trip);
        } catch(ParseException e) {
            e.printStackTrace();
        }
    }
}
