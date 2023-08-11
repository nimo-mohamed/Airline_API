package com.airline_api.Airline_Api.models;
import java.time.LocalDate;
import java.time.LocalTime;

public class FlightDTO {
    private Long id;
    private String destination;
    private int capacity;
    private LocalDate departureDate;
    private LocalTime departureTime;

    // Constructors, getters, setters

    public FlightDTO(Long id, String destination, int capacity, LocalDate departureDate, LocalTime departureTime) {
        this.id = id;
        this.destination = destination;
        this.capacity = capacity;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
    }

    public FlightDTO(){

    }

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
}

