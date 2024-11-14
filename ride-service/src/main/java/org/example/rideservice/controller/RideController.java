package org.example.rideservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.rideservice.model.Ride;
import org.example.rideservice.service.RideService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/ride")
public class RideController {
    private final RideService rideService;

    @GetMapping("/{rideId}")
    public Ride getRideById(@PathVariable Long rideId) {
        return rideService.getRideById(rideId);
    }

    @PostMapping
    public Ride createRide(@RequestBody Ride ride) {
        return rideService.createRide(ride);
    }

    @PutMapping("/end/{rideId}")
    public Ride endRide(@PathVariable Long rideId) {
        return rideService.endRide(rideId);
    }
    @PutMapping("/start/{rideId}")
    public Ride startRide(@PathVariable Long rideId) {
        return rideService.startRide(rideId);
    }
}
