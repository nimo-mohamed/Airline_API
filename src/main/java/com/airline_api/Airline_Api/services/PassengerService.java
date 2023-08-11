package com.airline_api.Airline_Api.services;

import com.airline_api.Airline_Api.models.Passenger;
import com.airline_api.Airline_Api.repositories.FlightRepository;
import com.airline_api.Airline_Api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {
    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private FlightRepository flightRepository;

    public Passenger addPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

}