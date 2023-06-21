package com.ServiceSwap.Repository;

import com.ServiceSwap.Model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller,Integer> {
}
