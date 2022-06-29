package lk.example.spring.service.impl;

import lk.example.spring.config.WebAppConfig;
import lk.example.spring.dto.ItemDTO;
import lk.example.spring.service.ItemService;
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
class ItemServiceImplTest {

    @Autowired
    ItemService itemService;

    public ItemDTO addOneItem(){
        return new ItemDTO("I001", "Herbal", 10,155.00 );
    }

    public void addItems(){
        ItemDTO i1 = new ItemDTO("I001", "Signal", 26,199.00 );
        ItemDTO i2 = new ItemDTO("I002", "Clogard", 1,250.00 );
        ItemDTO i3 = new ItemDTO("I003", "Lux", 4,130.00 );
        ItemDTO i4 = new ItemDTO("I004", "Delma", 5,150.00 );
        itemService.saveItem(i1);
        itemService.saveItem(i2);
        itemService.saveItem(i3);
        itemService.saveItem(i4);
    }
    @Test
    void saveItem() {
        ItemDTO itemDTO = addOneItem();
        assertDoesNotThrow(() -> {
            itemService.saveItem(itemDTO);
        });
    }

    @Test
    void updateItem() {
        addItems();
    }

    @Test
    void searchItem() {
    }

    @Test
    void deleteItem() {
        addItems();
    }

    @Test
    void getAllItems() {
        addItems();
    }
}