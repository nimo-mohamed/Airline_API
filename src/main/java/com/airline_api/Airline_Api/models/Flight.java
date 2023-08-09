package com.airline_api.Airline_Api.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String destination;
    private int capacity;
    private LocalDate departureDate;
    private LocalTime departureTime;

    @ManyToMany(mappedBy = "flights")
    private Set<Passenger> passengers = new HashSet<>();

    // Getters and setters
}