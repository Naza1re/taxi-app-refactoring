package org.example.rideservice.client;

import org.example.rideservice.model.Passenger;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "passenger-service", path = "/api/v1/passenger")
public interface PassengerClient {

    @GetMapping("/{passengerId}")
    Passenger getPassenger(@PathVariable("passengerId") Long passengerId);
}
