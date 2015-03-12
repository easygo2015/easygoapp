package com.easygoapp.service.impl;

import com.easygoapp.repository.TripRepository;
import com.easygoapp.service.ThreadDeleteTrip;
import com.easygoapp.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
@Transactional(readOnly = true)
@Service
public class ThreadDeleteTripImpl implements ThreadDeleteTrip {

    private Long id;

    @Autowired
    protected TripRepository tripRepository;

    @Autowired
    private TripService tripService;

    public ThreadDeleteTripImpl(){}
    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Transactional
    @Override
    public void run() {
        try {
            tripService.cancelTrip(id);
        } catch(MessagingException e) {
            e.printStackTrace();
        }
    }
}
