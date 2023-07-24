package com.ServiceSwap.Repository;

import com.ServiceSwap.Model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ServiceRepository extends JpaRepository<Service,Integer> {
    @Query("select s.nameService, s.type, s.seller.Ville from Service s")
    List<String> allServiceData();

    /// s.seller.Ville ///join the Service and Seller tables explicitly, since they are already mapped by a one-to-one relationship in your entities.
    @Query("select s from Service s where  s.seller.Ville = :ville and s.type = :type and s.nameService = :name")
    List<Service> findByCityAndTypeAndName(@Param("ville") String ville, @Param("type") String type, @Param("name") String name);

    @Query("select s.type from Service s where s.type=:type")
    List<Service> findByType( @Param("type") String type);
}
