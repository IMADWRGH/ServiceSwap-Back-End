package com.ServiceSwap.Controller;


import com.ServiceSwap.Model.Customer;
import com.ServiceSwap.Model.Reviews;
import com.ServiceSwap.Service.CustomerService;
import org.hibernate.dialect.function.SQLServerEveryAnyEmulation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@CrossOrigin(origins = {"http//localhost:4200"})
@RequestMapping(value="/api/customer")
@RestController
public class CustomerController {

private final CustomerService customerService;
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Integer id) throws Exception {
        Customer customer=customerService.getCustomerById(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

//    @PostMapping
//    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
//        Customer customer1 = customerService.registerCustomer(customer);
//        return new ResponseEntity<>(customer1, HttpStatus.OK);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> UpdateCustomer( @PathVariable Integer id) throws Exception {
        Customer customer1=customerService.updateCustomer(id);
        return new ResponseEntity<>(customer1, HttpStatus.OK);
    }

   @PostMapping("/{id}")
   public ResponseEntity<Reviews> addReview(@PathVariable Integer id ,@RequestBody Reviews review) {
       Reviews reviews = customerService.insertReviewForCustomer(id,review);
       return new ResponseEntity<>(reviews, HttpStatus.OK);
   }


}