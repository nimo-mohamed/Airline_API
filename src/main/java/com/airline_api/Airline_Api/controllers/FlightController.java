package com.airline_api.Airline_Api.controllers;

import com.airline_api.Airline_Api.models.Flight;
import com.airline_api.Airline_Api.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    FlightService flightService;
    //    INDEX
    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights() {
        return new ResponseEntity(flightService.getAllFlights(),HttpStatus.OK;
    }

    @PostMapping
    public Flight addFlight(@RequestBody Flight flight) {
        return flightService.addFlight(flight);
    }

    @PostMapping("/{flightId}/book/{passengerId}")
    public void bookPassengerOnFlight(@PathVariable Long flightId, @PathVariable Long passengerId) {
        flightService.bookPassengerOnFlight(passengerId, flightId);
    }

    //    SHOW
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Flight>> getFlight(@PathVariable Long id){
        return new ResponseEntity(flightService.getFlight(id), HttpStatus.OK);
    }

    //    CREATE
    @PostMapping
    public ResponseEntity<Flight> postEstate(@RequestBody Flight flight){
        flightService.saveFlight(flight);
        return new ResponseEntity(flightService.getAllFlights(), HttpStatus.CREATED);
    }

    //    DELETE
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteFlight(@PathVariable Long id){
        flightService.removeFlightsFromPassengers(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    //    UPDATE
    @PutMapping(value = "/{id}")
    public ResponseEntity<Flight> updateFlight(@RequestBody Flight flight, @PathVariable Long id){
        flightService.updateFlight(flight, id);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }

}
