package com.airline_api.Airline_Api.controllers;

import com.airline_api.Airline_Api.models.Flight;
import com.airline_api.Airline_Api.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @PostMapping
    public Flight addFlight(@RequestBody Flight flight) {
        return flightService.addFlight(flight);
    }

    @GetMapping
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    @PostMapping("/{flightId}/book/{passengerId}")
    public void bookPassengerOnFlight(@PathVariable Long flightId, @PathVariable Long passengerId) {
        flightService.bookPassengerOnFlight(passengerId, flightId);
    }

    // Other endpoints
}
