package com.example.clinic.services;

import com.example.clinic.entities.Services;
import com.example.clinic.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesService {

    @Autowired
    private ServiceRepository serviceRepository;

    public List<Services> getAllServices() {
        return serviceRepository.findAll();
    }

    public Services getServiceById(Long id) {
        return serviceRepository.findById(id).orElse(null);
    }

    public Services createService(Services service) {
        return serviceRepository.save(service);
    }

    public Services updateService(Long id, Services serviceDetails) {
        return serviceRepository.findById(id).map(service -> {
            service.setName(serviceDetails.getName());
            service.setPrice(serviceDetails.getPrice());
            return serviceRepository.save(service);
        }).orElse(null);
    }

    public void deleteService(Long id) {
        serviceRepository.deleteById(id);
    }
}
