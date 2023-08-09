package com.airline_api.Airline_Api.repositories;

import com.airline_api.Airline_Api.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    // Custom methods if needed
}