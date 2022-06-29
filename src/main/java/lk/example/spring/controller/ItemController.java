package lk.example.spring.controller;

import lk.example.spring.dto.ItemDTO;
import lk.example.spring.service.ItemService;
import lk.example.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllItem(){
        return new ResponseUtil(200, "Ok", itemService.getAllItems());
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveItem(@ModelAttribute ItemDTO dto){
        itemService.saveItem(dto);
        return new ResponseUtil(200, "Ok", null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateItem(@ModelAttribute ItemDTO dto){
        itemService.updateItem(dto);
        return new ResponseUtil(200, "Ok", null);
    }

    @GetMapping(path = "/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchItem(@PathVariable String code){
        return new ResponseUtil(200, "Ok", itemService.searchItem(code));
    }

    @DeleteMapping(params = {"code"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteItem(@RequestParam String code){
        itemService.deleteItem(code);
        return new ResponseUtil(200, "Deleted", null);
    }
}
