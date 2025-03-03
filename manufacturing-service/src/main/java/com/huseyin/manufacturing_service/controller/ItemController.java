package com.huseyin.manufacturing_service.controller;


import com.huseyin.manufacturing_service.dto.CreateItemRequest;
import com.huseyin.manufacturing_service.dto.ItemDto;
import com.huseyin.manufacturing_service.service.ItemService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = ItemController.PATH)
public class ItemController {

    static final String PATH = "item";

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping(path = "/{itemName}")
    public ItemDto getItemByItemName(@PathVariable String itemName) {
        return itemService.getItemByItemName(itemName);
    }

    @PostMapping
    public void createItem(@RequestBody CreateItemRequest createItemRequest) {
        itemService.createItem(createItemRequest);
    }

}
