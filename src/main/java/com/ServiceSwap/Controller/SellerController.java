package com.ServiceSwap.Controller;

import java.util.List;
import java.util.Optional;

import com.ServiceSwap.Model.Seller;
import com.ServiceSwap.Repository.SellerRepository;
import com.ServiceSwap.Service.SellerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
public class SellerController {

    private final SellerService sellerService;

    public SellerController( SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @GetMapping("/seller/")
    public ResponseEntity<List<Seller>> getSeller() {
        List<Seller> sellers = sellerService.allSeller();
        return new ResponseEntity<>(sellers, HttpStatus.OK);
    }
    @PostMapping("/seller/")
    public ResponseEntity<Seller> createSeller(@RequestBody Seller seller) {
        Seller var_seller = sellerService.registerSeller(seller);
        return new ResponseEntity<>(var_seller, HttpStatus.OK);
    }
    @PutMapping("/seller/{id}")
    public ResponseEntity<Seller> updateSeller(@RequestBody Integer id) throws Exception {
        Seller sellerUpdated = sellerService.updateSeller(id);
        return new ResponseEntity<>(sellerUpdated, HttpStatus.OK);
    }
    @DeleteMapping("/seller/{id}")
    public ResponseEntity<String> createStudent(@PathVariable(name = "id") Integer id) {
        sellerService.deleteSeller(id);
        return new ResponseEntity<>("student id: "+ id + " deleted successfully", HttpStatus.OK);
    }
}
