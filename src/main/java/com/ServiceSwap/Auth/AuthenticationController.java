package com.ServiceSwap.Auth;

import com.ServiceSwap.Model.Customer;
import com.ServiceSwap.Model.Seller;
import com.ServiceSwap.Model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    @PostMapping("/register-seller")
    public ResponseEntity<AuthenticationResponse>register_seller(@RequestBody Seller request){
    return ResponseEntity.ok(authenticationService.register_seller(request));
    }
    @PostMapping("/register-customer")
    public ResponseEntity<AuthenticationResponse>register_customer(@RequestBody Customer request){
        return ResponseEntity.ok(authenticationService.register_customer(request));
    }
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse>login(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authenticationService.login(request));
    }

    @PostMapping("/singup")
    public ResponseEntity<AuthenticationResponse>singup(@RequestBody User request){
        return ResponseEntity.ok(authenticationService.singup(request));
    }



}
