package com.ServiceSwap.Service;


import com.ServiceSwap.Model.Seller;
import com.ServiceSwap.Model.User;

import com.ServiceSwap.Repository.SellerRepository;
import com.ServiceSwap.Repository.UserRepository;

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
//             Seller seller = sellerOptional.get();
//             return sellerRepository.save(seller);
             return sellerOptional.get();
         }
         else {
             throw new ChangeSetPersister.NotFoundException();
         }
     }
    public boolean deleteSeller(Integer id) {
        Optional<Seller> sellerOptional = sellerRepository.findById(id);
        if (sellerOptional.isPresent()) {
            Seller seller = sellerOptional.get();
            User user = seller.getUser();
            sellerRepository.delete(seller);
            userRepository.delete(user);
            return true;
        } else {
            return false;
        }
    }
    public Seller updateSeller(Integer id, Seller updatedSeller) throws ChangeSetPersister.NotFoundException {
        Optional<Seller> sellerOptional = sellerRepository.findById(id);
        Optional<User> optionalUser = userRepository.findById(id);
        if (sellerOptional.isPresent() && optionalUser.isPresent()) {
            Seller seller = sellerOptional.get();
            User user = optionalUser.get();
            if (user.getId().equals(seller.getId())) {
                user.setFullname(updatedSeller.getUser().getFullname());
                user.setPassword(updatedSeller.getUser().getPassword());
                seller.setVille(updatedSeller.getVille());
                seller.setPhone(updatedSeller.getPhone());
                seller.setAddress(updatedSeller.getAddress());
                userRepository.save(user);
                return sellerRepository.save(seller);
            }
        }
        throw new ChangeSetPersister.NotFoundException();
    }

    public com.ServiceSwap.Model.Service AddService(Integer sellerId, com.ServiceSwap.Model.Service srv) throws ChangeSetPersister.NotFoundException {
        Optional<Seller> sellerOptional = sellerRepository.findById(sellerId);
        if (sellerOptional.isPresent()) {
            Seller seller = sellerOptional.get();
            srv.setSeller(seller);
           seller.setService(srv);
            sellerRepository.save(seller);
            return srv;
        } else {
            throw new ChangeSetPersister.NotFoundException();
        }
    }

}
