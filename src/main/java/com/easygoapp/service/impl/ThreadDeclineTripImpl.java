package com.easygoapp.service.impl;
import com.easygoapp.service.ThreadDeclineTrip;
import com.easygoapp.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
public class ThreadDeclineTripImpl implements ThreadDeclineTrip {

    public ThreadDeclineTripImpl(){}

    private Long userId;
    private Long tripId;

    @Autowired
    private TripService tripService;

    @Override
    public Long getUserId() {
        return userId;
    }

    @Override
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public Long getTripId() {
        return tripId;
    }

    @Override
    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    @Transactional
    @Override
    public void run() {
        tripService.removeCompanionFromTrip(userId, tripId);
    }
}
