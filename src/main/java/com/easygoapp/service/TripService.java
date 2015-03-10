package com.easygoapp.service;

import com.easygoapp.domain.Trip;
import com.easygoapp.domain.User;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Станислав on 28.02.2015.
 */
@Service
public interface TripService extends AbstractCrudService<Trip, Long> {

    List<Trip> getBetweenStartAndEnd(Timestamp start, Timestamp end);

    List<Trip> findAllFutureTripsForPassenger(User user);

    List<Trip> findAllFutureTripsForDriver(User user);

    void removeCompanionFromTrip(Long companionId, Long tripId);
}
