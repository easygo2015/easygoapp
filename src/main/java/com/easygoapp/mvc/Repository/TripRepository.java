package com.easygoapp.mvc.repository;

import com.easygoapp.mvc.domain.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Станислав on 28.02.2015.
 */

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
    List<Trip> findByStartTimeBetween(Timestamp start, Timestamp end);
}
