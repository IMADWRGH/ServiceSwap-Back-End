package com.ServiceSwap.Auth;

import com.ServiceSwap.Configuration.JwtService;
import com.ServiceSwap.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private  final AuthenticationManager authenticationManager;
public AuthenticationResponse register(RegisterRequest request) {
return null;
}
public AuthenticationResponse authenticate(AuthenticationRequest request){
    return null;

}

























}
