package com.example.order.scheduler;

import com.example.order.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class OrdersCleaner {

    @Autowired
    private OrdersService ordersService;

    @Scheduled(fixedDelay = 15*1000*60)
    public void clean(){
        ordersService.deleteAllWhereValidityOrdersFalse();
    }

}
