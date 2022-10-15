package com.olufunmi.Inventoryservice.services;

import com.olufunmi.Inventoryservice.dtos.requests.AddInventoryRequest;

public interface InventoryService {
    boolean isInStock(String skuCode);
    String addInventory(AddInventoryRequest request);
}
