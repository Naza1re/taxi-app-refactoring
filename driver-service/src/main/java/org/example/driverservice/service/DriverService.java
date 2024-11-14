package org.example.driverservice.service;

import lombok.RequiredArgsConstructor;
import org.example.driverservice.exception.DriverNotFoundException;
import org.example.driverservice.model.Driver;
import org.example.driverservice.repository.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverService {
    private final DriverRepository driverRepository;

    public Driver getDriverById(Long driverId) {
        return getOrThrow(driverId);
    }

    private Driver getOrThrow(Long driverId) {
        return driverRepository.findById(driverId).orElseThrow(
                () -> new DriverNotFoundException("Driver with id : "+ driverId+ " not found")
        );
    }

    public Driver createDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    public List<Driver> getAvailableDrivers() {
        List<Driver> drivers = driverRepository.findAllByAvailable(true);
        return drivers;
    }

    public List<Driver> getAll() {
        return driverRepository.findAll();
    }

    public Driver updateStatusOfAvailable(Long driverId) {
        Driver driver = getOrThrow(driverId);
        driver.setAvailable(!driver.isAvailable());
        return driverRepository.save(driver);
    }
}
