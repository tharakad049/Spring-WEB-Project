package lk.example.spring.service.impl;

import lk.example.spring.dto.OrderDTO;
import lk.example.spring.repo.ItemRepo;
import lk.example.spring.repo.OrderRepo;
import lk.example.spring.service.PurchaseOrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void purchaseOrder(OrderDTO dto) {

    }

    @Override
    public void deleteOrder(String oid) {

    }

    @Override
    public void updateOrder(OrderDTO dto) {

    }

    @Override
    public OrderDTO searchOrder(String oid) {
        return null;
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return null;
    }
}
