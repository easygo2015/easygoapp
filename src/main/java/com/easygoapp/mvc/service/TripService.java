package com.easygoapp.mvc.service;

import com.easygoapp.mvc.domain.Trip;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Станислав on 28.02.2015.
 */
public interface TripService {
    Trip save(Trip trip);
    void delete(Long id);
    Trip getById(Long id);
    List<Trip> getBetweenStartAndEnd(Timestamp start, Timestamp end);
}
