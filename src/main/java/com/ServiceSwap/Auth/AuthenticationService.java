package com.ServiceSwap.Auth;

import com.ServiceSwap.Configuration.JwtService;
import com.ServiceSwap.Model.Role;
import com.ServiceSwap.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
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
        var user = request.getUser();
        Role role = user.getRole();
        if (role == Role.ADMIN) {
            userRepository.save(user);
            var jwtToken = jwtService.generateJwt(user);
            return AuthenticationResponse.builder()
                    .jwt(jwtToken)
                    .build();
        } else if (role == Role.SELLER) {

            userRepository.save(user);
            var jwtToken = jwtService.generateJwt(user);
            return AuthenticationResponse.builder()
                    .jwt(jwtToken)
                    .build();
        } else if (role == Role.CUSTOMER) {
            userRepository.save(user);
            userRepository.save(user);
            var jwtToken = jwtService.generateJwt(user);
            return AuthenticationResponse.builder()
                    .jwt(jwtToken)
                    .build();
        } else {
            return null;
        }
    }


}












