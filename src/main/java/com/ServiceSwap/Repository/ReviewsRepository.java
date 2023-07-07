package com.ServiceSwap.Repository;


import com.ServiceSwap.Model.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewsRepository  extends JpaRepository<Reviews,Integer>  {
}
