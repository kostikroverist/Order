package com.example.order.service;

import com.example.order.domain.Orders;

public interface OrdersService {

    double saveOrder(Orders orders) ;

    void deleteAllWhereValidityOrdersFalse();

    void timeValidityOrders();
}
