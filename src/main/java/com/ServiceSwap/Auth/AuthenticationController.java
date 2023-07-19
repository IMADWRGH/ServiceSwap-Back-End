package com.ServiceSwap.Auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    @PostMapping("/register-seller")
    public ResponseEntity<AuthenticationResponse>register_seller(@RequestBody SellerRegisterRequest request){
    return ResponseEntity.ok(authenticationService.register_seller(request));
    }
    @PostMapping("/register-customer")
    public ResponseEntity<AuthenticationResponse>register_customer(@RequestBody CustomerRegisterRequest request){
        return ResponseEntity.ok(authenticationService.register_customer(request));
    }
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse>login(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authenticationService.login(request));
    }

    @PostMapping("/singup")
    public ResponseEntity<AuthenticationResponse>singup(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authenticationService.singup(request));
    }



}
