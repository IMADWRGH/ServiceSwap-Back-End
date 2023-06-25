package com.ServiceSwap.Controller;

import java.util.List;
import java.util.Optional;

import com.ServiceSwap.Model.Seller;
import com.ServiceSwap.Repository.SellerRepository;
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
    private final SellerRepository sellerRepository;

    public SellerController(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @GetMapping("/seller/")
    public ResponseEntity<List<Seller>> getSeller() {
        List<Seller> sellers = sellerRepository.findAll();
        return new ResponseEntity<>(sellers, HttpStatus.OK);
    }
    @PostMapping("/seller/")
    public ResponseEntity<Seller> createSeller(@RequestBody Seller seller) {
        Seller var_seller = sellerRepository.save(seller);
        return new ResponseEntity<>(var_seller, HttpStatus.OK);
    }
    @PutMapping("/seller/")
    public ResponseEntity<Seller> updateSeller(@RequestBody Seller seller) {
        Optional<Seller> seller1 = sellerRepository.findById(seller.getId());
        Seller Updated = seller1.get();
        Seller sellerUpdated = sellerRepository.save(Updated);
        return new ResponseEntity<>(sellerUpdated, HttpStatus.OK);
    }
    @DeleteMapping("/seller/{id}")
    public ResponseEntity<String> createStudent(@PathVariable(name = "id") Integer id) {
        sellerRepository.deleteById(id);
        return new ResponseEntity<>("student id: "+ id + " deleted successfully", HttpStatus.OK);
    }
}
