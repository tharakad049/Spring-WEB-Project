package lk.example.spring.controller;

import lk.example.spring.dto.ItemDTO;
import lk.example.spring.entity.Item;
import lk.example.spring.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("item")
@CrossOrigin
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping
    public List<ItemDTO> getAllItem(){
        return itemService.getAllItems();
    }

    @PostMapping
    public void saveItem(@ModelAttribute ItemDTO dto){
        itemService.saveItem(dto);
    }

    @PutMapping
    public void updateItem(@ModelAttribute ItemDTO dto){
        itemService.updateItem(dto);
    }

    @GetMapping(path = "/{code}")
    public ItemDTO searchItem(@PathVariable String code){
        return itemService.searchItem(code);
    }

    @DeleteMapping(params = {"code"})
    public void deleteItem(@RequestParam String code){
        itemService.deleteItem(code);
    }
}
