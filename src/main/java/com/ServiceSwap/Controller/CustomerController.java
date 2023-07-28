package com.ServiceSwap.Controller;


import com.ServiceSwap.Model.Customer;
import com.ServiceSwap.Model.Panel;
import com.ServiceSwap.Model.Reviews;
import com.ServiceSwap.Model.Service;
import com.ServiceSwap.Service.CustomerService;
import com.ServiceSwap.Service.PanelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@CrossOrigin(origins = {"http//localhost:4200"})
@RequestMapping(value="/api/customer")
@RestController
public class CustomerController {

private final CustomerService customerService;
private final PanelService panelService;
    public CustomerController(CustomerService customerService, PanelService panelService) {
        this.customerService = customerService;
        this.panelService = panelService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Integer id) throws Exception {
        Customer customer=customerService.getCustomerById(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }



    @PutMapping("/{id}")
    public ResponseEntity<Customer> UpdateCustomer( @PathVariable Integer id,@RequestBody Customer customer) throws Exception {
        Customer customer1=customerService.updateCustomer(id,customer);
        return new ResponseEntity<>(customer1, HttpStatus.OK);
    }

   @PostMapping("/{id}")
   public ResponseEntity<Reviews> addReview(@PathVariable Integer id ,@RequestBody Reviews review) {
       Reviews reviews = customerService.addReview(id,review);
       return new ResponseEntity<>(reviews, HttpStatus.OK);
   }
   @GetMapping("/{id}")
   public ResponseEntity<Panel> addReview(@PathVariable Integer id ) {
      Panel panel1  = customerService.getPanelBYCustomerID(id);
       return new ResponseEntity<>(panel1, HttpStatus.OK);
   }
    @PostMapping("/{customerId}/panels/{panelId}/services")
    public ResponseEntity<Panel> addServiceToPanel(@PathVariable Integer customerId, @PathVariable Integer panelId, @RequestBody Service service) {
        Panel panel = panelService.getPanelById(panelId);
        if (panel != null) {
            panel.getServices().add(service);
            panelService.updatePanel(panelId, panel);
            return new ResponseEntity<>(panel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}