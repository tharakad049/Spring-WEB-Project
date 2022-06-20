package lk.example.spring.service;

import lk.example.spring.dto.ItemDTO;
import lk.example.spring.entity.Item;

import java.util.List;

public interface ItemService {
    void saveItem(ItemDTO dto);
    void updateItem(ItemDTO dto);
    ItemDTO searchItem(String code);
    void deleteItem(String code);
    List<ItemDTO> getAllItems();
}
