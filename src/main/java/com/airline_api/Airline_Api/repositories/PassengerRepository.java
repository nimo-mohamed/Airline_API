package com.airline_api.Airline_Api.repositories;

import com.airline_api.Airline_Api.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {

        // Find passengers by name
        List<Passenger> findByName(String name);

        // Find passengers by email address
        List<Passenger> findByEmailAddress(String emailAddress);

        // Find passengers by phone number
        List<Passenger> findByPhoneNumber(String phoneNumber);

    }