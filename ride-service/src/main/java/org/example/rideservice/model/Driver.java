package org.example.rideservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Driver {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private boolean available;
}
