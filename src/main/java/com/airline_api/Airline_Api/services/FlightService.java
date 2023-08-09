package com.airline_api.Airline_Api.services;

import com.airline_api.Airline_Api.models.Flight;
import com.airline_api.Airline_Api.models.Passenger;
import com.airline_api.Airline_Api.repositories.FlightRepository;
import com.airline_api.Airline_Api.repositories.PassengerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;

    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public void bookPassengerOnFlight(Long passengerId, Long flightId) {
        Passenger passenger = passengerRepository.findById(passengerId).orElseThrow(() -> new EntityNotFoundException("Passenger not found"));
        Flight flight = flightRepository.findById(flightId).orElseThrow(() -> new EntityNotFoundException("Flight not found"));

        flight.getPassengers().add(passenger);
        flightRepository.save(flight);
    }

    // Other methods as needed
}