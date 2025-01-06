package com.example.clinic.controllers;

import com.example.clinic.entities.Services;
import com.example.clinic.services.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ServicesController {

    @Autowired
    private ServicesService servicesService;

    @GetMapping("/getAll")
    public List<Services> getAllServices() {
        return servicesService.getAllServices();
    }

    @GetMapping("/{id}")
    public Services getServiceById(@PathVariable Long id) {
        return servicesService.getServiceById(id);
    }

    @PostMapping("/createService")
    public Services createService(@RequestBody Services service) {
        return servicesService.createService(service);
    }

    @PutMapping("/updateService/{id}")
    public Services updateService(@PathVariable Long id, @RequestBody Services serviceDetails) {
        return servicesService.updateService(id, serviceDetails);
    }

    @DeleteMapping("/deleteService/{id}")
    public void deleteService(@PathVariable Long id) {
        servicesService.deleteService(id);
    }
}
