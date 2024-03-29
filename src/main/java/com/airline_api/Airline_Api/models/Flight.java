package com.airline_api.Airline_Api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String destination;

    @Column
    private int capacity;

    @Column
    private LocalDate departureDate;

    @Column
    private LocalTime departureTime;

    @JsonIgnoreProperties({"flights"})
    @ManyToMany(mappedBy = "flights")
    private List<Flight> flights;

    public Flight(Long id, String destination, int capacity, LocalDate departureDate, LocalTime departureTime, List<Flight> flights) {
        this.id = id;
        this.destination = destination;
        this.capacity = capacity;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.flights = flights;
    }

    public Flight(){

    }
    public void addFlight(Flight flight){this.flights.add(flight);}

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }
}