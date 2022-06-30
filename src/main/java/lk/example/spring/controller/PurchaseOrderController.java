package lk.example.spring.controller;

import lk.example.spring.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/purchase_Order")
@CrossOrigin

public class PurchaseOrderController {

    @Autowired
    PurchaseOrderService purchaseOrderService;
}
