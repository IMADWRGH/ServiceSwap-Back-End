package com.ServiceSwap.Controller;


import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = {"http//localhost:4200"})
@RestController
public class CustomerController {
//
//    public CustomerController(CustomerRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }
//    @GetMapping("/customer/")
//    public ResponseEntity<List<Customer>> getCostomer(){
//        List<Customer> customers =customerRepository.findAll();
//        return new ResponseEntity<>(customers, HttpStatus.OK);
//    }
//    @PostMapping("/customer/")
//    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
//        Customer customer1 = customerRepository.save(customer);
//        return new ResponseEntity<>(customer1, HttpStatus.OK);
//    }
//    @PutMapping("/customer/")
//    public ResponseEntity<Customer> UpdateCustomer(@RequestBody Customer customer){
//        Optional<Customer> customer1=customerRepository.findById(customer.getId());
//        Customer updateCustomer =customer1.get();
//        updateCustomer.getFirstName(customer.getFirstName());
//        Customer update = customerRepository.save(updateCustomer);
//        return new ResponseEntity<>(update, HttpStatus.OK);
//    }

}