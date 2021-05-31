package com.example.order.contoller;

import com.example.order.domain.Orders;
import com.example.order.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdersController {

    @Autowired
    private OrdersService ordersService;


    @PostMapping("/saveOrders")
    public void saveAccount(@RequestBody Orders orders) {
         ordersService.saveOrder(orders);
    }
}
