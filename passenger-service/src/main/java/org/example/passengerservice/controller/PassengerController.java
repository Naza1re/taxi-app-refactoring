package org.example.passengerservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.passengerservice.model.Passenger;
import org.example.passengerservice.service.PassengerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/passenger")
public class PassengerController {
    private final PassengerService passengerService;

    @GetMapping
    public List<Passenger> getAllPassengers() {
        return passengerService.getAllPassengers();
    }

    @GetMapping("/{passengerId}")
    public Passenger getPassengerById(@PathVariable Long passengerId) {
        return passengerService.getPassengerById(passengerId);
    }

    @PostMapping
    public Passenger createPassenger(@RequestBody Passenger passenger) {
        return passengerService.createPassenger(passenger);
    }

    @DeleteMapping("/{passengerId}")
    public void deletePassenger(@PathVariable Long passengerId) {
        passengerService.deletePassenger(passengerId);
    }
}
