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
import java.util.List;

/**
 * Created by Станислав on 28.02.2015.
 */
@Service
@Transactional(readOnly = true)
public class TripServiceImpl extends AbstractCrudServiceImpl<Trip, Long> implements TripService {
    @Autowired
    private TripRepository tripRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PassengerNodePointRepository passengerNodePointRepository;

    @Override
    public List<Trip> getBetweenStartAndEnd(Timestamp start, Timestamp end) {
        return tripRepository.findByStartTimeBetween(start,end);
    }

    @Autowired
    public void setTripRepository(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
        super.setRepository(tripRepository);
    }

    @Override
    public Trip findOne(Long id){
        Trip trip = super.findOne(id);
        trip.getCompanions().size();
        trip.getPassengerNodePoints().size();
        return trip;
    }

    @Override
    @Transactional
    public User addPassenger(User user, Trip trip) {
        User passenger = userRepository.findOne(user.getId());
        Trip current_trip = tripRepository.findOne(trip.getId());
        int capacity = current_trip.getCarCapacity();
        List<User> companions = current_trip.getCompanions();
        if (companions.size()-1 < capacity){
            companions.add(passenger);
            current_trip.setCompanions(companions);
            tripRepository.save(current_trip);
            /* here will be driver notification */
        }
        return passenger;
    }

    @Override
    @Transactional
    public boolean removePassenger(User user, Trip trip) {
        Trip current_trip = tripRepository.findOne(trip.getId());
        User passenger = userRepository.findOne(user.getId());
        List<User> companions = current_trip.getCompanions();
        if (companions.size()>1 && companions.contains(passenger)){
            companions.remove(passenger);
            trip.setCompanions(companions);
            tripRepository.save(current_trip);
            /* here will be driver notification */
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public PassengerNodePoint addPassengerNodePoint(PassengerNodePoint passengerNodePoint, Trip trip) {
        PassengerNodePoint curPassengerNodePoint = passengerNodePointRepository.findOne(passengerNodePoint.getId());
        Trip currentTrip = tripRepository.findOne(trip.getId());
        List<PassengerNodePoint> passengerNodePoints = currentTrip.getPassengerNodePoints();
        passengerNodePoints.add(passengerNodePoint);
        currentTrip.setPassengerNodePoints(passengerNodePoints);
        tripRepository.save(currentTrip);
        return passengerNodePoint;
    }

    @Override
    public boolean removePassengerNodePoint(PassengerNodePoint passengerNodePoint, Trip trip) {
        List<PassengerNodePoint> passengerNodePoints = trip.getPassengerNodePoints();
        /*need limits: range from, to */
        if (passengerNodePoints.size()>2 && passengerNodePoints.contains(passengerNodePoint)){
            passengerNodePoints.remove(passengerNodePoint);
            trip.setPassengerNodePoints(passengerNodePoints);
            for (User passenger : trip.getCompanions()) {
                /* passengers notification */
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean modifyTrip(Trip trip) {
        Trip oldTrip = tripRepository.findOne(trip.getId());
        List<User> companions = oldTrip.getCompanions();
        if (companions.size() <= trip.getCarCapacity()){
            tripRepository.save(trip);
            /*passengers notification*/
            return true;
        }else{
            /*passengers conflict*/
            return false;
        }
    }

    @Override
    public void cancelTrip(Trip trip) {
        List<User> companions = trip.getCompanions();
        if (companions.size() != 0){
            for (User companion : companions) {
                /*passengers notification*/
            }
            tripRepository.delete(trip.getId());
        }
        tripRepository.delete(trip.getId());
    }


}
