package com.ServiceSwap.Repository;

import com.ServiceSwap.Model.Service;
import com.ServiceSwap.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServiceRepository extends JpaRepository<Service,Integer> {
    Optional<Service> findByType(String type);
    Optional<Service> findByNameService();
}
