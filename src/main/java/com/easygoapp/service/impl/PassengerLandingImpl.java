package com.easygoapp.service.impl;

import com.easygoapp.domain.PassengerLanding;
import com.easygoapp.repository.PassengerLandingRepository;
import com.easygoapp.service.PassengerLandingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class PassengerLandingImpl extends AbstractCrudServiceImpl<PassengerLanding, Long> implements
                                                                                          PassengerLandingService {
    private PassengerLandingRepository passengerLandingRepository;

    @Autowired
    public void setPassengerLandingRepository(PassengerLandingRepository passengerLandingRepository) {
        this.passengerLandingRepository = passengerLandingRepository;
        super.setRepository(passengerLandingRepository);
    }
}
