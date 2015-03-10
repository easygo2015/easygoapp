package com.easygoapp.repository;

import com.easygoapp.domain.Trip;
import com.easygoapp.domain.User;
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

    List<Trip> findByDriverAndStartTimeGreaterThan(User user, Timestamp time);

    List<Trip> findBycompanionsAndStartTimeGreaterThan(User user, Timestamp stamp);

//    @Modifying
//    @Query("update TRIP_USER u set u.user_id=0 where u.user_id = ?1")
//    public void removeCompanionFromTrip(Long companionId);

//     @Modifying
//     void removeCompanionFromTrip(@Param("id")Long companionId);

//    @Query(value = "delete from trip_user where user_id = ?1 and trip_id = ?2", nativeQuery = true)
//    public void removeCompanionFromTrip(@Param("user_id")Long companionId, @Param("trip_id")Long tripId);
}
