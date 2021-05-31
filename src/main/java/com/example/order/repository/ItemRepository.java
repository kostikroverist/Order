package com.example.order.repository;

import com.example.order.domain.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Items,Long> {

    List<Items> findAllByNameOrderByPriceAsc(String name);
}
