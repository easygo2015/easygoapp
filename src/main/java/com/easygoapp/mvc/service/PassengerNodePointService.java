package com.easygoapp.mvc.service;

import com.easygoapp.mvc.domain.PassengerNodePoint;

/**
 * Created by Станислав on 28.02.2015.
 */
public interface PassengerNodePointService {
    PassengerNodePoint save(PassengerNodePoint point);
    void delete(Long id);
    PassengerNodePoint getById(Long id);
}
