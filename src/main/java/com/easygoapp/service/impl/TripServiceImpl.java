package com.easygoapp.service.impl;

import com.easygoapp.domain.Trip;
import com.easygoapp.domain.User;
import com.easygoapp.repository.TripRepository;
import com.easygoapp.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * Created by Станислав on 28.02.2015.
 */
@Transactional(readOnly = true)
@Service
public class TripServiceImpl extends AbstractCrudServiceImpl<Trip, Long> implements TripService {

    private TripRepository tripRepository;

    @Override
    public List<Trip> getBetweenStartAndEnd(Timestamp start, Timestamp end) {
        List<Trip> trips = tripRepository.findByStartTimeBetween(start, end);
        for (Trip trip : trips) {
            trip.getPassengerNodePoints().size();
            trip.getCompanions().size();
        }
        return trips;
    }

    @Autowired
    public void setTripRepository(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
        super.setRepository(tripRepository);
    }

    @Override
    public Trip findOne(Long id) {
        Trip trip = super.findOne(id);
        trip.getCompanions().size();
        return trip;
    }

    @Override
    public List<Trip> findAllFutureTripsForPassenger(User user) {
        long time = new Date().getTime();
        Timestamp stamp = new Timestamp(time);
        List<Trip> trips = tripRepository.findBycompanionsAndStartTimeGreaterThan(user, stamp);
        Iterator iterator = trips.iterator();
        while (iterator.hasNext()) {
            Trip trip = (Trip) iterator.next();
            if (Objects.equals(user.getId(), trip.getDriver().getId())) {
                iterator.remove();
            }
        }
        for (Trip trip : trips) {
            trip.getCompanions().size();
            trip.getPassengerNodePoints().size();
        }
        return trips;
    }

    @Override
    public List<Trip> findAllFutureTripsForDriver(User user) {
        long time = new Date().getTime();
        Timestamp stamp = new Timestamp(time);
        List<Trip> trips = tripRepository.findByDriverAndStartTimeGreaterThan(user, stamp);
        for (Trip trip : trips) {
            trip.getCompanions().size();
            trip.getPassengerNodePoints().size();
        }
        return trips;
    }

    @Transactional
    @Override
    public void removeCompanionFromTrip(Long companionId, Long tripId) {
        Trip trip = tripRepository.findOne(tripId);
        List<User> users = trip.getCompanions();
        Iterator iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = (User) iterator.next();
            if (Objects.equals(user.getId(), companionId)) {
                iterator.remove();
            }
        }
        tripRepository.save(trip);
    }
}
