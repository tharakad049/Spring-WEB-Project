package lk.example.spring.controller;

import lk.example.spring.dto.CustomerDTO;
import lk.example.spring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping
    public List<CustomerDTO> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping
    public void saveCustomer(@ModelAttribute CustomerDTO dto){
        customerService.saveCustomer(dto);
    }

    @PutMapping
    public void updateCustomer(@RequestBody CustomerDTO dto){
        customerService.updateCustomer(dto);
    }

    @DeleteMapping(params = {"id"})
    public void deleteCustomer(@RequestParam String id){
        customerService.deleteCustomer(id);
    }

    @GetMapping(path = "/{id}")
    public CustomerDTO searchCustomer(@PathVariable String id){
        return customerService.searchCustomer(id);
    }
}
