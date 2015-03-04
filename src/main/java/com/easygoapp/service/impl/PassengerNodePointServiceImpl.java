package com.easygoapp.service.impl;

import com.easygoapp.domain.PassengerNodePoint;
import com.easygoapp.repository.PassengerNodePointRepository;
import com.easygoapp.service.PassengerNodePointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * Created by Станислав on 28.02.2015.
 */
@Service
@Repository
@Transactional(readOnly = true)
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

    @Override
    public List<PassengerNodePoint> getAll() {
        return passengerNodePointRepository.findAll();
    }
}
