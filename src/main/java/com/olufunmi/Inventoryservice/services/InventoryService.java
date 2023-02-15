package com.olufunmi.Inventoryservice.services;

import com.olufunmi.Inventoryservice.dtos.requests.AddInventoryRequest;
import com.olufunmi.Inventoryservice.dtos.responses.InventoryResponse;

import java.util.List;

public interface InventoryService {
    List <InventoryResponse> isInStock(List<String> skuCode);
    String addInventory(AddInventoryRequest request);
}
