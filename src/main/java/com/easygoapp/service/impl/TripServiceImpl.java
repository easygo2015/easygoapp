package com.easygoapp.service.impl;

import com.easygoapp.domain.PassengerNodePoint;
import com.easygoapp.domain.Trip;
import com.easygoapp.domain.User;
import com.easygoapp.repository.PassengerNodePointRepository;
import com.easygoapp.repository.TripRepository;
import com.easygoapp.repository.UserRepository;
import com.easygoapp.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    @Autowired
    private TripRepository tripRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PassengerNodePointRepository passengerNodePointRepository;

    @Override
    public List<Trip> getBetweenStartAndEnd(Long id, String start, String end) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        Date date = dateFormat.parse(start);
        long time = date.getTime();
        Timestamp startTrip = new Timestamp(time);
        date = dateFormat.parse(end);
        time = date.getTime();
        Timestamp endTrip = new Timestamp(time);
        List<Trip> trips = tripRepository.findByCarCapacityGreaterThanAndStartTimeBetween(0, startTrip,
                endTrip);

        Iterator iterator = trips.iterator();
        while (iterator.hasNext()) {
            Trip trip = (Trip) iterator.next();
            if (id.equals(trip.getDriver().getId())) {
                iterator.remove();
            }
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
    public Trip findOneEager(Long id) {
        Trip trip = super.findOne(id);
        trip.getCompanions().size();
        trip.getPassengerNodePoints().size();
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
        Trip trip = findOneEager(tripId);
        trip.getCompanions().size();
        List<User> users = trip.getCompanions();
        Iterator iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = (User) iterator.next();
            if (Objects.equals(user.getId(), companionId)) {
                iterator.remove();
            }
        }
        trip.setCarCapacity(trip.getCarCapacity() + 1);
        tripRepository.save(trip);
    }

    @Override
    @Transactional
    public void addPassenger(Long tripId, Long userId) {
        Trip currentTrip = findOneEager(tripId);
        User passenger = userRepository.getOne(userId);
        List<User> companions = currentTrip.getCompanions();
        companions.add(passenger);
        currentTrip.setCarCapacity(currentTrip.getCarCapacity() - 1);
        tripRepository.save(currentTrip);
        //TODO driver notification
    }

    @Override
    @Transactional
    public void addPassengerNodePoint(Long tripId, Long passengerNodePointId) {
        Trip currentTrip = tripRepository.findOne(tripId);
        PassengerNodePoint passengerNodePoint = passengerNodePointRepository.findOne(passengerNodePointId);
        List<PassengerNodePoint> passengerNodePoints = currentTrip.getPassengerNodePoints();
        passengerNodePoints.add(passengerNodePoint);
        tripRepository.save(currentTrip);
    }

    @Override
    @Transactional
    public void removePassengerNodePoint(Long tripId, Long passengerNodePointId) {
        Trip currentTrip = tripRepository.findOne(tripId);
        PassengerNodePoint passengerNodePoint = passengerNodePointRepository.getOne(passengerNodePointId);
        List<PassengerNodePoint> passengerNodePoints = currentTrip.getPassengerNodePoints();
        passengerNodePoints.remove(passengerNodePoint);
        tripRepository.save(currentTrip);
        for (User passenger : currentTrip.getCompanions()) {
            //TODO passengers notification
        }
    }

    @Override
    @Transactional
    public void setPassengerNodePointsList(Long tripId, List<PassengerNodePoint> points) {
        Trip currentTrip = tripRepository.findOne(tripId);
        currentTrip.setPassengerNodePoints(points);
        tripRepository.save(currentTrip);
    }


    @Override
    @Transactional
    public Trip modifyTrip(Trip trip) {
        Trip originalTrip = tripRepository.findOne(trip.getId());
        Trip modifiedTrip;
        List<User> companions = originalTrip.getCompanions();
        if (trip.getCarCapacity() > originalTrip.getCarCapacity()) {
            modifiedTrip = tripRepository.save(trip);
            //TODO passengers notification
            return modifiedTrip;
        } else {
            return originalTrip;
        }
    }

    @Override
    @Transactional
    public void cancelTrip(Trip trip) {
        List<User> companions = trip.getCompanions();
        if (companions.size() > 1) {
            for (User companion : companions) {
                //TODO passengers notification
            }
        }
        tripRepository.delete(trip);
    }
}
