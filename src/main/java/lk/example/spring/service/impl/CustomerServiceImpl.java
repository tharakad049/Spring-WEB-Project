package lk.example.spring.service.impl;

import lk.example.spring.entity.Customer;
import lk.example.spring.repo.CustomerRepo;
import lk.example.spring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo repo;

    @Override
    public void saveCustomer(Customer entity){
        if (!repo.existsById(entity.getId())){
            repo.save(entity);
        }else
            throw new RuntimeException("Customer innawa...");
    }

    @Override
    public void deleteCustomer(String id){
        if (repo.existsById(id)) {
            repo.deleteById(id);
        }else{
            throw new RuntimeException("Ehema ekek na");
        }
    }

    @Override
    public void updateCustomer(Customer entity){
        if (repo.existsById(entity.getId())) {
            repo.save(entity);
        }else{
            throw new RuntimeException("Ehema ekek na");
        }
    }

    @Override
    public Customer searchCustomer(String id){
        if (repo.existsById(id)) {
            return repo.findById(id).get();
        }else{
            throw new RuntimeException("Error"+id+"....");
        }
    }

    @Override
    public List<Customer> getAllCustomers(){
        return repo.findAll();
    }
}
