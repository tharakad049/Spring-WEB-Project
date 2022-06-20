package lk.example.spring.service;

import lk.example.spring.entity.Customer;

import java.util.List;

public interface CustomerService {
    void saveCustomer(Customer entity);
    void deleteCustomer(String id);
    void updateCustomer(Customer entity);
    Customer searchCustomer(String id);
    List<Customer> getAllCustomers();
}
