package lk.example.spring.service.impl;

import lk.example.spring.dto.CustomerDTO;
import lk.example.spring.entity.Customer;
import lk.example.spring.repo.CustomerRepo;
import lk.example.spring.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerRepo repo;

    @Override
    public void saveCustomer(CustomerDTO dto) {
        if (!repo.existsById(dto.getId())) {
            Customer map = modelMapper.map(dto, Customer.class);
            repo.save(map);
        } else {
            throw new RuntimeException("Customer innawa...");
        }
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
    public void updateCustomer(CustomerDTO dto){
        if (repo.existsById(dto.getId())) {
            Customer map = modelMapper.map(dto, Customer.class);
            repo.save(map);
        }else{
            throw new RuntimeException("Ehema ekek na");
        }
    }

    @Override
    public CustomerDTO searchCustomer(String id){
        if (repo.existsById(id)) {
            return modelMapper.map(repo.findById(id).get(), CustomerDTO.class);
        }else{
            throw new RuntimeException("Error"+id+"....");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers(){
        List<Customer> all = repo.findAll();
        return modelMapper.map(all, new TypeToken<List<CustomerDTO>>(){}.getType());
    }
}
