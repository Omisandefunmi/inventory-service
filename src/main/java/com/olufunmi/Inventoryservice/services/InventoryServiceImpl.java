package com.olufunmi.Inventoryservice.services;

import com.olufunmi.Inventoryservice.data.models.Inventory;
import com.olufunmi.Inventoryservice.data.repositories.InventoryRepository;
import com.olufunmi.Inventoryservice.dtos.requests.AddInventoryRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService{
    private final InventoryRepository inventoryRepository;
    @Override
    @Transactional(readOnly = true)
    public boolean isInStock(String skuCode) {
        Optional<Inventory> inventory = inventoryRepository.findBySkuCode(skuCode);
        return inventory.isPresent();
    }

    @Override
    public String addInventory(AddInventoryRequest request) {
        Inventory inventory = Inventory.builder()
                .quantity(request.getQuantity())
                .skuCode(request.getSkuCode())
                .build();

        inventoryRepository.save(inventory);
        return "Inventory added successfully";
    }
}
