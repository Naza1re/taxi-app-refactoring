package org.example.passengerservice.service;

import lombok.RequiredArgsConstructor;
import org.example.passengerservice.exception.PassengerNotFoundException;
import org.example.passengerservice.model.Passenger;
import org.example.passengerservice.repository.PassengerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PassengerService {
    private final PassengerRepository passengerRepository;

    public Passenger getPassengerById(Long passengerId) {
        return getOrThrow(passengerId);
    }

    private Passenger getOrThrow(Long passengerId) {
        return passengerRepository.findById(passengerId).orElseThrow(
                () -> new PassengerNotFoundException("Passenger with id : "+ passengerId + " not found")
        );
    }

    public Passenger createPassenger(Passenger passenger) {
        Passenger newPassenger = passengerRepository.save(passenger);
        return newPassenger;
    }

    public void deletePassenger(Long passengerId) {
        Passenger passenger = getOrThrow(passengerId);
        passengerRepository.delete(passenger);
    }

    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }
}
