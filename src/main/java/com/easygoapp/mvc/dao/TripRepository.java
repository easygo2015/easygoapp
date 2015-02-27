package com.easygoapp.mvc.dao;

import com.easygoapp.mvc.domain.Point;
import com.easygoapp.mvc.domain.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by SCJP on 27.02.2015.
 */
public interface TripRepository extends JpaRepository<Trip, Long> {
    List<Trip> findByStartTime(Date startTime);

    @Query("")
    List<Trip> findByStartTimeBetween(Date from, Date to);
}
