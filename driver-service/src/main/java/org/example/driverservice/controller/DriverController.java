package org.example.driverservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.driverservice.model.Driver;
import org.example.driverservice.service.DriverService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/driver")
@RequiredArgsConstructor
public class DriverController {

    private final DriverService driverService;

    @GetMapping
    public List<Driver> getAllDrivers() {
        return driverService.getAll();
    }

    @GetMapping("/{driverId}")
    public Driver driver(@PathVariable("driverId") Long driverId) {
        return driverService.getDriverById(driverId);
    }
    @PostMapping
    public Driver createDriver(@RequestBody Driver driver) {
        return driverService.createDriver(driver);
    }

    @GetMapping("/available")
    public List<Driver> availableDrivers() {
        return driverService.getAvailableDrivers();
    }

    @PutMapping("/status/{driverId}")
    public Driver updateDriverStatus(@PathVariable("driverId") Long driverId) {
        return driverService.updateStatusOfAvailable(driverId);
    }
}
