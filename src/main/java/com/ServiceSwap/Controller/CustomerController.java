package com.ServiceSwap.Controller;

import com.ServiceSwap.Model.Customer;
import com.ServiceSwap.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"http//localhost:4200"})
@RestController
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @GetMapping("/customer/")
    public ResponseEntity<List<Customer>> getCostomer(){
        List<Customer> customers =customerRepository.findAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
    @PostMapping("/customer/")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer customer1 = customerRepository.save(customer);
        return new ResponseEntity<>(customer1, HttpStatus.OK);
    }
    @PutMapping("/customer/")
    public ResponseEntity<Customer> UpdateCustomer(@RequestBody Customer customer){
        Optional<Customer> customer1=customerRepository.findById(customer.getId());
        Customer updateCustomer =customer1.get();
        updateCustomer.getFirstName(customer.getFirstName());
        Customer update = customerRepository.save(updateCustomer);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

}