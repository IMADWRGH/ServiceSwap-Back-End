package com.ServiceSwap.Service;

import com.ServiceSwap.Model.Seller;
import com.ServiceSwap.Repository.SellerRepository;
import com.ServiceSwap.Repository.UserRepository;
import org.hibernate.mapping.Selectable;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellerService {
    private final SellerRepository sellerRepository;
    private  final UserRepository userRepository;

    public SellerService(SellerRepository sellerRepository, UserRepository userRepository) {
        this.sellerRepository = sellerRepository;
        this.userRepository = userRepository;
    }

    public Seller registerSeller(Seller seller){
        return sellerRepository.save(seller) ;
    }

    public List<Seller> allSeller() {
        return sellerRepository.findAll();
    }
     public Seller getSellerById(Integer id) throws ChangeSetPersister.NotFoundException {
         Optional<Seller> sellerOptional = sellerRepository.findById(id);
         if (sellerOptional.isPresent()) {
             Seller seller = sellerOptional.get();
             return sellerRepository.save(seller);
         }
         else {
             throw new ChangeSetPersister.NotFoundException();
         }
     }
}
