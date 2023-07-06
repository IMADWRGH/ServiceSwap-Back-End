package com.ServiceSwap.Auth;

import com.ServiceSwap.Configuration.JwtService;
import com.ServiceSwap.Model.Role;
import com.ServiceSwap.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
public AuthenticationResponse register(RegisterRequest request){
    var user =User.builder()
            .firstname(request.getFirstname())
            .lastname(request.getLastnem())
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .role(Role.CUSTOMER)
            .build();

    return null;
}
public AuthenticationResponse authenticate(AuthenticationRequest request) {
    return null;
    }
}
