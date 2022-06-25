package lk.example.spring.service.impl;

import lk.example.spring.config.WebAppConfig;
import lk.example.spring.dto.CustomerDTO;
import lk.example.spring.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@WebAppConfiguration
@ContextConfiguration(classes = {WebAppConfig.class})
@ExtendWith(SpringExtension.class)
@Transactional
class CustomerServiceImplTest {

    @Autowired
    CustomerService customerService;

    @Test
    void saveCustomer() {
        CustomerDTO customerDTO = addOneCustomer();
        assertThrows(RuntimeException.class, () -> {
            customerService.saveCustomer(customerDTO);
        });
    }

    private CustomerDTO addOneCustomer() {
        return new CustomerDTO("C001", "Ramal", "Galle", 1000.00);
    }

    @Test
    void deleteCustomer() {
        assertDoesNotThrow(() -> {
            customerService.deleteCustomer("C001");
        });

        assertThrows(RuntimeException.class,() -> {
            customerService.deleteCustomer("C010");
        });
    }

    @Test
    void updateCustomer() {
        assertDoesNotThrow(() -> {
            customerService.updateCustomer(new CustomerDTO("C001", "Ramal", "Galle", 10000.00));
        });
    }

    @Test
    void searchCustomer() {
    }

    @Test
    void getAllCustomers() {
    }
}