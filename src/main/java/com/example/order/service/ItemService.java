package com.example.order.service;

import com.example.order.domain.Items;

import java.util.List;

public interface ItemService {


    List<Items> findByName(String name);
}
