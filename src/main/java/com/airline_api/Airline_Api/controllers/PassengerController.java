package com.airline_api.Airline_Api.controllers;

import com.airline_api.Airline_Api.models.Passenger;
import com.airline_api.Airline_Api.models.PassengerDTO;
import com.airline_api.Airline_Api.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("passengers")
public class PassengerController {
    @Autowired
    PassengerService passengerService;

    @GetMapping
    public ResponseEntity<List<Passenger>> getAllPassengers(
            @RequestParam(required = false, name = "phoneNumber") Integer phoneNumber
    ){
        if(phoneNumber != null){}
            return new ResponseEntity<>(passengerService.getAllPassengers(), HttpStatus.OK);
    }

//      Create a new passenger
    @PostMapping
    public ResponseEntity<PassengerDTO> addPassenger(@RequestBody PassengerDTO passengerDTO) {
        PassengerDTO createdPassenger = passengerService.addPassenger(passengerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPassenger);
    }

//    Get details of a specific passenger by ID
    @GetMapping("/{passengerId}")
    public ResponseEntity<PassengerDTO> getPassenger(@PathVariable Long passengerId) {
        PassengerDTO passenger = passengerService.getPassengerById(passengerId);
        if (passenger == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(passenger);
    }

//    Update details of a passenger
    @PutMapping("/{passengerId}")
    public ResponseEntity<PassengerDTO> updatePassenger(@PathVariable Long passengerId, @RequestBody PassengerDTO passengerDTO) {
        PassengerDTO updatedPassenger = passengerService.updatePassenger(passengerId, passengerDTO);
        if (updatedPassenger == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedPassenger);
    }

//     Delete a passenger
    @DeleteMapping("/{passengerId}")
    public ResponseEntity<Void> deletePassenger(@PathVariable Long passengerId) {
        boolean deleted = passengerService.deletePassenger(passengerId);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}