package com.easygoapp.service;

import com.easygoapp.domain.Trip;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Станислав on 28.02.2015.
 */
@Transactional(readOnly = true)
@Service
public interface TripService {
    @Transactional
    Trip save(Trip trip);
    @Transactional
    void delete(Long id);
    Trip getById(Long id);
    List<Trip> getBetweenStartAndEnd(Timestamp start, Timestamp end);
}
