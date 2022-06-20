package lk.example.spring.repo;

import lk.example.spring.config.JPAConfig;
import lk.example.spring.entity.Item;
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

class ItemRepoTest {

    @Autowired
    ItemRepo itemRepo;

    @Test
    public void saveItems(){
        Item item1 = new Item("I-001", "Bonchi", 10, 335.50);
        Item item2 = new Item("I-002", "Soya", 20, 299.50);
        Item item3 = new Item("I-003", "Parippu", 30, 678.50);
        itemRepo.save(item1);
        itemRepo.save(item2);
        itemRepo.save(item3);
    }

    @Test
    public void searchItems(){
        Optional<Item> id = itemRepo.findById("I-002");
        boolean present = id.isPresent();
        System.out.println(present);

        Item item = id.get();
        System.out.println(item.toString());
    }

    @Test
    public void getAllItems(){
        List<Item> all = itemRepo.findAll();
        for (Item item : all) {
            System.out.println(item.toString());
        }
    }

    @Test
    public void deleteItems(){
        itemRepo.deleteById("I-001");
    }

    @Test
    public void updateItem(){
        if (itemRepo.existsById("I-001")) {
            Item item1 = new Item("I-001", "Signal", 10, 335.50);
            itemRepo.save(item1);
        } else {
            throw new RuntimeException("No Such Item To Update");
        }
    }

}