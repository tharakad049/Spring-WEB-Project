package lk.example.spring.service.impl;

import lk.example.spring.dto.ItemDTO;
import lk.example.spring.entity.Item;
import lk.example.spring.repo.ItemRepo;
import lk.example.spring.service.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ItemRepo itemRepo;

    @Override
    public void saveItem(ItemDTO dto){
        if (!itemRepo.existsById(dto.getCode())){
            Item map = mapper.map(dto, Item.class);
            itemRepo.save(map);
        }else{
            throw new RuntimeException("Item ek innawa.. ");
        }
    }

    @Override
    public void updateItem(ItemDTO dto){
        if (itemRepo.existsById(dto.getCode())){
            Item map = mapper.map(dto, Item.class);
            itemRepo.save(map);
        }else{
            throw new RuntimeException("Ehema ekek na");
        }
    }

    @Override
    public ItemDTO searchItem(String code){
        if (itemRepo.existsById(code)){
            return mapper.map(itemRepo.findById(code).get(), ItemDTO.class);
        }else{
            throw new RuntimeException("Ehema ekek na");
        }
    }

    @Override
    public void deleteItem(String code){
        if (itemRepo.existsById(code)){
            itemRepo.deleteById(code);
        }else{
            throw new RuntimeException("Ehema ekek na");
        }
    }

    @Override
    public List<ItemDTO> getAllItems() {
        List<Item> all = itemRepo.findAll();
        return mapper.map(all, new TypeToken<List<ItemDTO>>(){}.getType());
    }
}
