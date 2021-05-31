package com.example.order.scheduler;

import com.example.order.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class OrdersValidate {

    @Autowired
    private OrdersService ordersService;

    @Scheduled(fixedDelay = 1000*10*60)
    public void validate(){
        ordersService.timeValidityOrders();
    }

}
