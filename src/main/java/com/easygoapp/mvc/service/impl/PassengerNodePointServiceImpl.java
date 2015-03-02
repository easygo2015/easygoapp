package com.easygoapp.mvc.service.impl;

import com.easygoapp.mvc.domain.PassengerNodePoint;
import com.easygoapp.mvc.repository.PassengerNodePointRepository;
import com.easygoapp.mvc.service.PassengerNodePointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Станислав on 28.02.2015.
 */
@Service
public class PassengerNodePointServiceImpl implements PassengerNodePointService {

    @Autowired
    private PassengerNodePointRepository passengerNodePointRepository;

    @Override
    public PassengerNodePoint save(PassengerNodePoint point) {
        PassengerNodePoint savedPoint = passengerNodePointRepository.saveAndFlush(point);
        return savedPoint;
    }

    @Override
    public void delete(Long id) {
        passengerNodePointRepository.delete(id);
    }

    @Override
    public PassengerNodePoint getById(Long id) {
        return passengerNodePointRepository.findOne(id);
    }
}
