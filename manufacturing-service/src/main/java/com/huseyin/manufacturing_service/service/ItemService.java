package com.huseyin.manufacturing_service.service;

import com.huseyin.manufacturing_service.dto.CreateItemRequest;
import com.huseyin.manufacturing_service.dto.ItemDto;
import com.huseyin.manufacturing_service.entity.Item;
import com.huseyin.manufacturing_service.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public ItemDto getItemByItemName(String itemName){
        Optional<Item> item = itemRepository.getItemByItemName(itemName);
        return item.map(value -> ItemDto.builder()
                .itemName(value.getItemName())
                .description(value.getDescription())
                .quantity(value.getQuantity())
                .build()).orElseThrow(() -> new RuntimeException("Item not found"));
    }


    public void createItem(CreateItemRequest createItemRequest) {
        Item item = new Item();
        item.setItemName(createItemRequest.getItemName());
        item.setDescription(createItemRequest.getDescription());
        itemRepository.save(item);
    }
}
