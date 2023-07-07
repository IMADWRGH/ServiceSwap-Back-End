package com.ServiceSwap.Service;

import com.ServiceSwap.Model.Customer;
import com.ServiceSwap.Model.Reviews;
import com.ServiceSwap.Repository.CustomerRepository;
import com.ServiceSwap.Repository.ReviewsRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public Customer registerCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer getCustomerById(Integer id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        return optionalCustomer.orElse(null);
    }

    public Customer updateCustomer(Integer id, Customer updatedCustomer) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            // Update the customer properties as needed
//            customer.setFirstName(updatedCustomer.getFirstName());
//            customer.setLastName(updatedCustomer.getLastName());
            // ... set other properties accordingly
            return customerRepository.save(customer);
        } else {
            return null;
        }
    }

    public boolean deleteCustomer(Integer id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            customerRepository.delete(optionalCustomer.get());
            return true;
        } else {
            return false;
        }
    }

    public Reviews insertReviewForCustomer(Integer id, Reviews review) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            // Set the relationship between the customer and the review
            review.setCustomer(customer);
            // Save the review
//            return ReviewsRepository.save(review);
        } else {
            return null;
        }
    }
}
