package com.easygoapp.repository;

import com.easygoapp.domain.PassengerLanding;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerLandingRepository extends JpaRepository<PassengerLanding, Long> {

}
