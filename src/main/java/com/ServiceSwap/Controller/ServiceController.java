package com.ServiceSwap.Controller;

import com.ServiceSwap.Model.Service;
import com.ServiceSwap.Service.Services_Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"http//localhost:4200"})
@RequestMapping(value="/api/services")
@RestController
public class ServiceController {
    private final Services_Service services;

    public ServiceController(Services_Service services) {
        this.services = services;
    }


    @GetMapping("/data")
    public List<String> getData() {
       return services.getData();
    }

    @GetMapping("/{type}")
    ResponseEntity<List<Service>> getServicesType(@PathVariable String type){
        return (ResponseEntity<List<Service>>) services.getByType(type);
    }
    @GetMapping("/{id}")
    ResponseEntity<Service> getServicesType(@PathVariable Integer id){
        Optional<Service> service =services.getService(id);
        return service.map(value ->  ResponseEntity.ok(value)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }
    @GetMapping()
    public List<Service> getAllServices() {
        return services.allServices();
    }



}
