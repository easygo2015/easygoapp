package com.easygoapp.service;

import com.easygoapp.domain.Trip;
import com.easygoapp.domain.User;

public interface ThreadCreateTrip extends Runnable {
    public Trip getTrip();
    public void setTrip(Trip trip);
    public String getStartDate();
    public void setStartDate(String startDate);
    public User getDriver();
    public void setDriver(User driver);
}
