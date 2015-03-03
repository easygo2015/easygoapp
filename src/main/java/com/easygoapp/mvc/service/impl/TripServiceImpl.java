package com.easygoapp.mvc.service.impl;

import com.easygoapp.mvc.domain.Trip;
import com.easygoapp.repository.TripRepository;
import com.easygoapp.repository.UserRepository;
import com.easygoapp.mvc.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Станислав on 28.02.2015.
 */
@Service
public class TripServiceImpl implements TripService {

    @Qualifier("tripRepository")
    @Autowired
    private TripRepository tripRepository;

    @Override
    public Trip save(Trip trip) {
        Trip savedTrip = tripRepository.saveAndFlush(trip);
        return savedTrip;
    }

    @Override
    public void delete(Long id) {
        tripRepository.delete(id);
    }

    @Override
    public Trip getById(Long id) {
        return tripRepository.findOne(id);
    }

    @Override
    public List<Trip> getBetweenStartAndEnd(Timestamp start, Timestamp end) {
        return tripRepository.findByStartTimeBetween(start, end);
    }
}
