package org.example.rideservice.model;

import lombok.Data;

@Data
public class Passenger {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
