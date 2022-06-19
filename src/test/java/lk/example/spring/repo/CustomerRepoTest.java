package lk.example.spring.repo;

import lk.example.spring.config.JPAConfig;
import lk.example.spring.entity.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@WebAppConfiguration
@ContextConfiguration(classes = {JPAConfig.class})
@ExtendWith(SpringExtension.class)


class CustomerRepoTest {

    @Autowired
    CustomerRepo customerRepo;

    @Test
    public void saveCustomer(){
        Customer customer1 = new Customer("C-001", "Dilan", "Kataragama", 1000000.00);
        customerRepo.save(customer1);
    }

    @Test
    public void getAllCustomers(){
        List<Customer> all = customerRepo.findAll();
        for (Customer customer : all) {
            System.out.println(customer.toString());
        }
    }
    @Test
    public void searchCustomer(){
        Optional<Customer> byId = customerRepo.findById("C-001");
        boolean present = byId.isPresent();
        System.out.println(present);

        Customer customer = byId.get();
        System.out.print(customer.toString());
    }

    @Test
    public void deleteCustomer(){
        customerRepo.deleteById("C-001");
    }
}