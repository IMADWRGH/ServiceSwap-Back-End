package com.ServiceSwap.Repository;

import com.ServiceSwap.Model.ServiceCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ServiceCategoryRepository extends JpaRepository<ServiceCategory,Integer> {
}
