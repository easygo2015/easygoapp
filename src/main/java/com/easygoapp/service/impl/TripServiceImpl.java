package com.easygoapp.service.impl;

import com.easygoapp.domain.PassengerNodePoint;
import com.easygoapp.domain.Trip;
import com.easygoapp.domain.User;
import com.easygoapp.repository.TripRepository;
import com.easygoapp.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Станислав on 28.02.2015.
 */
@Service
public class TripServiceImpl extends AbstractCrudServiceImpl<Trip, Long> implements TripService {

    private TripRepository tripRepository;

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
    public boolean addPassenger(User user, Trip trip) {
        int capacity = trip.getCarCapacity();
        List<User> companions = trip.getCompanions();
        if (companions.size()-1 < capacity){
            companions.add(user);
            trip.setCompanions(companions);
            tripRepository.save(trip);
            /* here will be driver notification */
            return true;
        }
        return false;
    }

    @Override
    public boolean removePassenger(User user, Trip trip) {
        List<User> companions = trip.getCompanions();
        if (companions.size()>1 && companions.contains(user)){
            companions.remove(user);
            trip.setCompanions(companions);
            tripRepository.save(trip);
            /* here will be driver notification */
            return true;
        }
        return false;
    }

    @Override
    public boolean addPassengerNodePoint(PassengerNodePoint passengerNodePoint, Trip trip) {
        List<PassengerNodePoint> passengerNodePoints = trip.getPassengerNodePoints();
        /*need limits: range from, to */
        if (passengerNodePoints.size() < 15){
            passengerNodePoints.add(passengerNodePoint);
            trip.setPassengerNodePoints(passengerNodePoints);
            tripRepository.save(trip);
            return true;
        }
        return false;
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
