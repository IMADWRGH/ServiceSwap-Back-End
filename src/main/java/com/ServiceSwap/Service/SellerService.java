package com.ServiceSwap.Service;

import com.ServiceSwap.Model.Customer;
import com.ServiceSwap.Model.Reviews;
import com.ServiceSwap.Model.Seller;
import com.ServiceSwap.Model.User;
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
    public Seller updateSeller(Integer id)throws Exception{
        Optional<Seller> sellerOptional=sellerRepository.findById(id);
        Optional<User> optionalUser=userRepository.findById(id);
        if (sellerOptional.isPresent() && optionalUser.isPresent()){
            Seller seller=sellerOptional.get();
            User user=optionalUser.get();
            if (user.getId().equals(seller.getId())){
                user.setFullname(user.getFullname());
                user.setPassword(user.getPassword());
                seller.setVille(seller.getVille());
                seller.setPhone(seller.getPhone());
                seller.setAddress(seller.getAddress());
                userRepository.save(user);
                return sellerRepository.save(seller);
            }
        }
        throw new ChangeSetPersister.NotFoundException();
    }
//    public Reviews insertService(Integer id, Service service) {
//        Optional<Seller> sellerOptional=sellerRepository.findById(id);
//        if (optionalCustomer.isPresent()) {
//            Customer customer = optionalCustomer.get();
//            review.setCustomer(customer);
//            return reviewsRepository.save(review);
//        } else {
//            return null;
//        }
//    }
}
