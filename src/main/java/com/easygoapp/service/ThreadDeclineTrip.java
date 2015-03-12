package com.easygoapp.service;

public interface ThreadDeclineTrip extends Runnable {
    public Long getUserId();
    public void setUserId(Long userId);
    public Long getTripId();
    public void setTripId(Long tripId);
}
