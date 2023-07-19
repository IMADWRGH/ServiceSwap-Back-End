package com.ServiceSwap.Auth;

import com.ServiceSwap.Configuration.JwtService;
import com.ServiceSwap.Model.Customer;
import com.ServiceSwap.Model.Seller;
import com.ServiceSwap.Model.User;
import com.ServiceSwap.Repository.CustomerRepository;
import com.ServiceSwap.Repository.SellerRepository;
import com.ServiceSwap.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;
    private final SellerRepository sellerRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder encoder;



    public AuthenticationResponse singup(RegisterRequest request){
        if (request.getEmail() == null || request.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }
        if (request.getPassword() == null || request.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty");
        }
        var user = userRepository.findByEmail(request.getEmail());
        if (user.isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }
        User user1=new User();
        user1.setPassword(request.getPassword());
        user1.setPassword(encoder.encode(user1.getPassword()));
        user1.setEmail(request.getEmail());
        user1.setRole(request.getRole());
        user1.setFullname(request.getFullname());
        userRepository.save(user1);

       var jwtToken = jwtService.generateJwt(user1) ;
        return AuthenticationResponse.builder()
                .jwt(jwtToken)
                .build();
    }

    public AuthenticationResponse login(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateJwt(user);
        return AuthenticationResponse.builder()
                .jwt(jwtToken)
                .build();
    }

    public AuthenticationResponse register_seller(SellerRegisterRequest request) {
            Seller seller = new Seller();
            seller.setVille(request.getVille());
            seller.setSexe(request.getSexe());
            seller.setAddress(request.getAddress());
            seller.setPhone(request.getPhone());
            sellerRepository.save(seller);
        var jwtToken = jwtService.generateJwt(seller.getUser());
        return AuthenticationResponse.builder()
                .jwt(jwtToken)
                .build();
    }
    public AuthenticationResponse register_customer(CustomerRegisterRequest request) {
            Customer customer = new Customer();
            customer.setVille(request.getVille());
            customer.setSexe(request.getSexe());
            customer.setAddress(request.getAddress());
            customer.setPhone(request.getPhone());
            customerRepository.save(customer);

        var jwtToken = jwtService.generateJwt(customer.getUser());
        return AuthenticationResponse.builder()
                .jwt(jwtToken)
                .build();
    }

}












