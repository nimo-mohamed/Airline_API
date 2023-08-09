package com.airline_api.Airline_Api.repositories;

import com.airline_api.Airline_Api.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
    // Custom methods if needed
}