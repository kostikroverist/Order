package com.example.order.repository;

import com.example.order.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {

    void deleteOrdersByValidityOrdersIsFalse();

    List<Orders> getAllByCreatedIsBefore(Date date);
}
