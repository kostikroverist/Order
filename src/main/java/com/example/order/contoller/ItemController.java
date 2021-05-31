package com.example.order.contoller;

import com.example.order.domain.Items;
import com.example.order.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/findAllByName/{name}")
    public List<Items> findAllItems(@PathVariable("name") String name){
        return  itemService.findByName(name);
    }

}
