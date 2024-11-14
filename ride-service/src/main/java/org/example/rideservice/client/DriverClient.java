package org.example.rideservice.client;

import org.example.rideservice.model.Driver;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "driver-service", path = "/api/v1/driver")
public interface DriverClient {

    @GetMapping("/available")
    List<Driver> getAvailableDrivers();

}
