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

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@WebAppConfiguration
@ContextConfiguration(classes = {WebAppConfig.class})
@ExtendWith(SpringExtension.class)
@Transactional
class CustomerServiceImplTest {

    @Autowired
    CustomerService customerService;

    public void addCustomers(){
        CustomerDTO c1 = new CustomerDTO("C001","Dasun","Galle",100);
        CustomerDTO c2 = new CustomerDTO("C002","Kamal","Panadura",200);
        CustomerDTO c3 = new CustomerDTO("C003","Ramal","Kaluthara",300);
        CustomerDTO c4 = new CustomerDTO("C004","Oshan","Colombo",400);
        customerService.saveCustomer(c1);
        customerService.saveCustomer(c2);
        customerService.saveCustomer(c3);
        customerService.saveCustomer(c4);
    }

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
        addCustomers();

        assertDoesNotThrow(() -> {
            customerService.deleteCustomer("C001");
        });

        assertThrows(RuntimeException.class,() -> {
            customerService.deleteCustomer("C010");
        });
    }

    @Test
    void updateCustomer() {

        addCustomers();

        assertDoesNotThrow(() -> {
            customerService.updateCustomer(new CustomerDTO("C001", "Ramal", "Galle", 10000.00));
        });

        assertThrows(RuntimeException.class, () -> {
            customerService.updateCustomer(new CustomerDTO("C006","Oshan","Colombo",400));
        });
    }

    @Test
    void searchCustomer() {
        CustomerDTO customer = addOneCustomer();
        customerService.saveCustomer(customer);

        CustomerDTO c001 = customerService.searchCustomer("C001");
        assertNotNull(c001);

        assertThrows(RuntimeException.class, () -> {
            CustomerDTO c002 = customerService.searchCustomer("C002");
        });

    }

    @Test
    void getAllCustomers() {
        addCustomers();

        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        for (CustomerDTO allCustomer : allCustomers) {
            System.out.println(allCustomer.toString());
        }
        assertNotNull(allCustomers);
    }
}