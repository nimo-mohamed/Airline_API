package com.airline_api.Airline_Api.services;

import com.airline_api.Airline_Api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerService {
    @Autowired
    private PassengerRepository passengerRepository;

    public Passenger addPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    // Other methods as needed
}