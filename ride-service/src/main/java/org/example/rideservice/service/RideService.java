package org.example.rideservice.service;

import lombok.RequiredArgsConstructor;
import org.example.rideservice.client.DriverClient;
import org.example.rideservice.client.PassengerClient;
import org.example.rideservice.exceptions.RideNotFoundException;
import org.example.rideservice.model.Driver;
import org.example.rideservice.model.Passenger;
import org.example.rideservice.model.Ride;
import org.example.rideservice.repository.RideRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RideService {
    private final RideRepository repository;
    private final PassengerClient passengerClient;
    private final DriverClient driverClient;


    public Ride getRideById(Long rideId) {
        return getOrThrow(rideId);
    }

    private Ride getOrThrow(Long rideId) {
        return repository.findById(rideId).orElseThrow(
                () -> new RideNotFoundException("Ride with id " + rideId + " not found")
        );
    }

    public Ride createRide(Ride ride) {

        Passenger passenger = passengerClient.getPassenger(ride.getPassengerId());
        Ride saved = repository.save(ride);

        List<Driver> driver = driverClient.getAvailableDrivers();
        Ride rieToInsertDriver = getOrThrow(saved.getId());
        rieToInsertDriver.setDriverId(driver.get(0).getId());
        rieToInsertDriver.setPrice(20);
        rieToInsertDriver.setStatus("ACTIVE");

        return repository.save(rieToInsertDriver);
    }

    public Ride endRide(Long rideId) {
        Ride ride = getRideById(rideId);
        ride.setStatus("FINISHED");
        ride.setEndTime(LocalDateTime.now());
        return repository.save(ride);
    }

    public Ride startRide(Long rideId) {
        Ride ride = getRideById(rideId);
        ride.setStatus("ACTIVE");
        ride.setStartTime(LocalDateTime.now());
        return repository.save(ride);
    }
}
