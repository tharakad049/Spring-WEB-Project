package lk.example.spring.repo;

import lk.example.spring.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item , String> {

}
