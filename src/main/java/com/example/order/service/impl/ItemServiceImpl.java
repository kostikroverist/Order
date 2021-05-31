package com.example.order.service.impl;

import com.example.order.domain.Items;
import com.example.order.repository.ItemRepository;
import com.example.order.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository  itemRepository;

    @Override
    public List<Items> findByName(String name) {
        List<Items> allByNameOrderByPriceAsc = itemRepository.findAllByNameOrderByPriceAsc(name);
        List<Items> itemsList = new ArrayList<>();
        for (int i = 0; i < allByNameOrderByPriceAsc.size(); i++) {
             if(i < 5){
                itemsList.add(allByNameOrderByPriceAsc.get(i));
            }
        }
        return itemsList;
    }
}
