package com.olufunmi.Inventoryservice.services;

import com.olufunmi.Inventoryservice.data.models.Inventory;
import com.olufunmi.Inventoryservice.data.repositories.InventoryRepository;
import com.olufunmi.Inventoryservice.dtos.requests.AddInventoryRequest;
import com.olufunmi.Inventoryservice.dtos.responses.InventoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService{
    private final InventoryRepository inventoryRepository;
    @Override
    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCode) {
        return inventoryRepository.findBySkuCodeIn(skuCode)
                .stream()
                .map(inventory -> InventoryResponse.builder()
                        .skuCode(inventory.getSkuCode())
                        .isInStock(inventory.getQuantity() > 0)
                        .build()
                ).toList();


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
