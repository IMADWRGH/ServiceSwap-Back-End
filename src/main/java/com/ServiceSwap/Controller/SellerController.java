package com.ServiceSwap.Controller;



import com.ServiceSwap.Model.Seller;
import com.ServiceSwap.Service.SellerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping(value="/api/seller")
@RestController
public class SellerController {

    private final SellerService sellerService;

    public SellerController( SellerService sellerService) {
        this.sellerService = sellerService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Seller> getSeller(@PathVariable(name = "id") Integer id) throws Exception {
        Seller sellerUpdated = sellerService.getSellerById(id);
        return new ResponseEntity<>(sellerUpdated, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Seller> createSeller(@RequestBody Seller seller){
        Seller seller1 =sellerService.registerSeller(seller);
        return new ResponseEntity<>(seller1,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Seller> updateSeller(@PathVariable(name = "id") Integer id,@RequestBody Seller seller) throws Exception {
        Seller sellerUpdated = sellerService.updateSeller(id,seller);
        return new ResponseEntity<>(sellerUpdated, HttpStatus.OK);
    }

}
