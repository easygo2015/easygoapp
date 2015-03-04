package com.easygoapp.service;

import com.easygoapp.domain.PassengerNodePoint;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by Станислав on 28.02.2015.
 */
@Service
public interface PassengerNodePointService {
    PassengerNodePoint save(PassengerNodePoint point);
    void delete(Long id);
    PassengerNodePoint getById(Long id);
    List<PassengerNodePoint> getAll();
}
