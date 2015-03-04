package com.easygoapp.service.impl;

import com.easygoapp.domain.Trip;
import com.easygoapp.repository.TripRepository;
import com.easygoapp.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Станислав on 28.02.2015.
 */
@Service
public class TripServiceImpl extends AbstractCrudServiceImpl<Trip, Long> implements TripService {

    private TripRepository tripRepository;

    @Autowired
    public void setTripRepository(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
        super.setRepository(tripRepository);
    @Override
    public Trip save(Trip trip) {
        return tripRepository.saveAndFlush(trip);
    }

    @Override
    public void delete(Long id) {
        tripRepository.delete(id);
    }

    @Override
    public Trip getById(Long id) {
        Trip trip = tripRepository.findOne(id);
        trip.getCompanions().size();
        trip.getPassengerNodePoints().size();
        return trip;
    }

    @Override
    public List<Trip> getBetweenStartAndEnd(Timestamp start, Timestamp end) {
        return tripRepository.findByStartTimeBetween(start, end);
    }
}
