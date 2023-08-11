package com.airline_api.Airline_Api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "passengers")
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String phoneNumber;

    @Column
    private String emailAddress;

    @JsonIgnoreProperties({"passengers"})
    @ManyToMany
    @JoinTable(
            name = "passengers_flights",
            joinColumns = @JoinColumn(name = "passenger_id"),
            inverseJoinColumns = @JoinColumn(name = "passenger_id")
    )
    private List<Passenger> passengers;

    public Passenger(Long id, String name, String phoneNumber, String emailAddress, List<Passenger> passengers) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.passengers = passengers;
    }

    public Passenger() {
    }

    public void addPassenger(Passenger passenger){
        this.passengers.add(passenger);
    }

    public void removePassenger(Passenger passenger){
        this.passengers.remove(passenger);
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }
}