package com.ServiceSwap.Service;

import com.ServiceSwap.Model.Customer;
import com.ServiceSwap.Model.Panel;
import com.ServiceSwap.Model.Reviews;
import com.ServiceSwap.Model.User;
import com.ServiceSwap.Repository.CustomerRepository;
import com.ServiceSwap.Repository.ReviewsRepository;
import com.ServiceSwap.Repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final ReviewsRepository reviewsRepository;
    private final UserRepository userRepository;

    public CustomerService(CustomerRepository customerRepository, ReviewsRepository reviewsRepository, UserRepository userRepository) {
        this.customerRepository = customerRepository;
        this.reviewsRepository = reviewsRepository;
        this.userRepository = userRepository;
    }

    public Customer registerCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> allCustomer() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Integer id) throws Exception {
        Optional<User> optionalUser = userRepository.findById(id);
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalUser.isPresent() && optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            User user = optionalUser.get();
            if (user.getId().equals(customer.getId())) {
                return optionalCustomer.orElse(null);
            } else {
                throw new ChangeSetPersister.NotFoundException();
            }
        }
        return null;
    }

    public Customer updateCustomer(Integer id, Customer updatedCustomer) throws ChangeSetPersister.NotFoundException {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent() && optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            User user = optionalUser.get();
            if (user.getId().equals(customer.getId())) {
                user.setFullname(updatedCustomer.getUser().getFullname());
                user.setPassword(updatedCustomer.getUser().getPassword());
                customer.setAddress(updatedCustomer.getAddress());
                customer.setVille(updatedCustomer.getVille());
                customer.setPhone(updatedCustomer.getPhone());
                userRepository.save(user);
                return customerRepository.save(customer);
            }
        }
        throw new ChangeSetPersister.NotFoundException();
    }




    public boolean deleteCustomer(Integer id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            User user = customer.getUser();
            customerRepository.delete(customer);
            userRepository.delete(user);
            return true;
        } else {
            return false;
        }
    }

    public Reviews addReview(Integer customerId, Reviews review) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            review.setCustomer(customer);
            return reviewsRepository.save(review);
        } else {
            return null;
        }
    }
    public Panel getPanelBYCustomerID(Integer id) {
        Customer customer = customerRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Panel not found"));
        if (customer != null) {
            return customer.getPanel();
        }
        return null;
    }
}
