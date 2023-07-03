package com.ServiceSwap.Repository;

import com.ServiceSwap.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmail(String email);
}
