package com.huseyin.manufacturing_service.repository;


import com.huseyin.manufacturing_service.dto.ItemDto;
import com.huseyin.manufacturing_service.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    Optional<Item> getItemByItemName(String itemName);
}
