package com.ServiceSwap.Auth;

import com.ServiceSwap.Configuration.JwtService;
import com.ServiceSwap.Model.Customer;
import com.ServiceSwap.Model.Seller;
import com.ServiceSwap.Repository.CustomerRepository;
import com.ServiceSwap.Repository.SellerRepository;
import com.ServiceSwap.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;
    private final SellerRepository sellerRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

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

    public AuthenticationResponse register(RegisterRequest request) {
        if (request instanceof SellerRegisterRequest) {
            Seller seller = new Seller();
            seller.setVille(request.getVille());
            seller.setSexe(request.getSexe());
            seller.setAddress(request.getAddress());
            seller.setPhone(request.getPhone());
            sellerRepository.save(seller);
        } else {
            Customer customer = new Customer();
            customer.setPhone(request.getPhone());
            customer.setAddress(request.getAddress());

            customer.setPhone(request.getPhone());
            customerRepository.save(customer);
        }

        // Return the AuthenticationResponse
        return null; //new AuthenticationResponse(true);
    }


}












