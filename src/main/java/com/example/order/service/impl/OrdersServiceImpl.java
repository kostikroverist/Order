package com.example.order.service.impl;

import com.example.order.domain.Items;
import com.example.order.domain.Orders;
import com.example.order.repository.OrderRepository;
import com.example.order.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class OrdersServiceImpl extends Thread implements OrdersService {

    @Autowired
    private OrderRepository orderRepository;

    @Override

    public void saveOrder(Orders orders) {
        List<Items> itemsList = orders.getItems();

        for (Items items : itemsList) {
            items.setOrders(Collections.singletonList(orders));
        }
        double reduce = itemsList.stream().mapToDouble(ob -> (ob.getPrice() * ob.getQuantity())).reduce(0, Double::sum);

        orders.setTotalPrice(reduce);
        orderRepository.save(orders);
    }

    @Override
    @Transactional
    public void deleteAllWhereValidityOrdersFalse() {

        orderRepository.deleteOrdersByValidityOrdersIsFalse();

    }

    @Override
    public void timeValidityOrders() {
        Date date = new Date(new Date().getTime() - 1000 * 60 * 10);

        List<Orders> allByCreatedAfter = orderRepository.getAllByCreatedIsBefore(date);
        for (Orders orders : allByCreatedAfter) {
            orders.setValidityOrders(false);
        }
        orderRepository.saveAll(allByCreatedAfter);
    }


}



