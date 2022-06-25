package lk.example.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import lk.example.spring.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer , String> {

}
