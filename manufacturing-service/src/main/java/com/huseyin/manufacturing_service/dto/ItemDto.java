package com.huseyin.manufacturing_service.dto;

import com.huseyin.manufacturing_service.entity.Item;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemDto {

    private String itemName;

    private String description;

    private Double quantity;

    public ItemDto(Item item) {
        this.itemName = item.getItemName();
        this.description = item.getDescription();
        this.quantity = item.getQuantity();
    }

}
