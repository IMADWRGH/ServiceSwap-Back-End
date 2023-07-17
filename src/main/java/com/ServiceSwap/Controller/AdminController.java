package com.ServiceSwap.Controller;

import com.ServiceSwap.Model.Customer;
import com.ServiceSwap.Model.Seller;
import com.ServiceSwap.Service.CustomerService;
import com.ServiceSwap.Service.SellerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/api/admin")
@RestController
public class AdminController {
    private final CustomerService customerService;
    private final SellerService sellerService;

    public AdminController(CustomerService customerService, SellerService sellerService) {
        this.customerService = customerService;
        this.sellerService = sellerService;
    }

    ///////////////select list//////////////
    @GetMapping("/customer/")
    public ResponseEntity<List<Customer>> getCustomer(){
        List<Customer> customers =customerService.allCustomer();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
    @GetMapping("/seller/")
    public ResponseEntity<List<Seller>> getSeller() {
        List<Seller> sellers = sellerService.allSeller();
        return new ResponseEntity<>(sellers, HttpStatus.OK);
    }
    ///////////////select one//////////////

    ///////////////create//////////////

    //can't create new Seller or  customer;

    ///////////////update//////////////
    @PutMapping("/customer/{id}")
    public ResponseEntity<Customer> UpdateCustomer( @PathVariable Integer id) throws Exception {
        Customer customer1=customerService.updateCustomer(id);
        return new ResponseEntity<>(customer1, HttpStatus.OK);
    }
    ///////////////delete//////////////
    @DeleteMapping("/customer/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable(name = "id") Integer id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>("Customer id :"+id +"deleted successfully ",HttpStatus.OK);
    }
    @DeleteMapping("/seller/{id}")
    public ResponseEntity<String> deleteSeller(@PathVariable(name = "id") Integer id) {
        sellerService.deleteSeller(id);
        return new ResponseEntity<>("student id: "+ id + " deleted successfully", HttpStatus.OK);
    }
}
