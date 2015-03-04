package com.easygoapp.service;

import com.easygoapp.domain.PassengerNodePoint;
import com.easygoapp.domain.Trip;
import com.easygoapp.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Станислав on 28.02.2015.
 */
@Service
public interface TripService extends AbstractCrudService<Trip, Long> {
    List<Trip> getBetweenStartAndEnd(Timestamp start, Timestamp end);
    User addPassenger(User user, Trip trip);
    boolean removePassenger(User user, Trip trip);
    PassengerNodePoint addPassengerNodePoint(PassengerNodePoint passengerNodePoint, Trip trip);
    boolean removePassengerNodePoint(PassengerNodePoint passengerNodePoint, Trip trip);
    boolean modifyTrip(Trip trip);
    void cancelTrip(Trip trip);
}
