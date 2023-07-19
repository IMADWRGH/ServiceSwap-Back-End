package com.ServiceSwap.Service;

import com.ServiceSwap.Model.User;
import com.ServiceSwap.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService{
    private final UserRepository userRepository;


//    public User save(User user){
//        return userRepository.save(user);
//    }
//    public Optional<User> findByEmail(String email) {
//        return userRepository.findByEmail(email);
//    }
//    public List<User> findAll(){
//        return Collections.emptyList();
//    }
}
