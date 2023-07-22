package com.ServiceSwap.Controller;

import com.ServiceSwap.Model.Service;
import com.ServiceSwap.Service.Services_Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http//localhost:4200"})
@RequestMapping(value="/api/services")
@RestController
public class ServiceController {
    private final Services_Service services;

    public ServiceController(Services_Service services) {
        this.services = services;
    }


    @GetMapping("/{name}")
    public ResponseEntity<Service> getNameService(@PathVariable String name) throws Exception {
       return null;
    }
    @GetMapping("/")
    public List<Service> getAllServices() {
        return services.allServices();
    }
    @GetMapping("/{type}")
    public List<Service> getServicesByType(@PathVariable String type) {
        return null; //serviceRepository.findByType(type);
    }

}
