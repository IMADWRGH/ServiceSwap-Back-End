package com.ServiceSwap.Controller;

import java.util.List;
import java.util.Optional;

import com.ServiceSwap.Model.Seller;
import com.ServiceSwap.Repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private SellerRepository sellerRepository;
    @GetMapping("/seller/")
    public ResponseEntity<List<Seller>> getStudents() {
        List<Seller> students = sellerRepository.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    @PostMapping("/seller/")
    public ResponseEntity<Seller> createStudent(@RequestBody Seller student) {
        Seller std = sellerRepository.save(student);
        return new ResponseEntity<>(std, HttpStatus.OK);
    }
    @PutMapping("/seller/")
    public ResponseEntity<Seller> updateStudent(@RequestBody Seller seller) {
        Optional<Seller> std = sellerRepository.findById(seller.getId());
        Seller stdUpdated = std.get();
        Seller studentUpdated = sellerRepository.save(stdUpdated);
        return new ResponseEntity<>(studentUpdated, HttpStatus.OK);
    }
    @DeleteMapping("/seller/{id}")
    public ResponseEntity<String> createStudent(@PathVariable(name = "id") Integer id) {
        sellerRepository.deleteById(id);
        return new ResponseEntity<>("student id: "+ id + " deleted successfully", HttpStatus.OK);
    }
}
