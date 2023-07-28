package com.ServiceSwap.Controller;



import com.ServiceSwap.Model.Seller;
import com.ServiceSwap.Model.Service;
import com.ServiceSwap.Service.SellerService;
import org.springframework.data.crossstore.ChangeSetPersister;
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
    public ResponseEntity<Seller> getSeller(@PathVariable Integer id) throws Exception {
        Seller sellerUpdated = sellerService.getSellerById(id);
        return new ResponseEntity<>(sellerUpdated, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Seller> updateSeller(@PathVariable Integer id,@RequestBody Seller seller) throws Exception {
        Seller sellerUpdated = sellerService.updateSeller(id,seller);
        return new ResponseEntity<>(sellerUpdated, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Service> addSeervice (@PathVariable Integer id,@RequestBody Service services) throws ChangeSetPersister.NotFoundException {
        Service service= sellerService.addService(id,services);
        return new ResponseEntity<>(service, HttpStatus.OK);
    }
}
