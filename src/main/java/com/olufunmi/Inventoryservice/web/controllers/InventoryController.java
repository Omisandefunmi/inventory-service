package com.olufunmi.Inventoryservice.web.controllers;

import com.olufunmi.Inventoryservice.dtos.requests.AddInventoryRequest;
import com.olufunmi.Inventoryservice.dtos.responses.InventoryResponse;
import com.olufunmi.Inventoryservice.services.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode){
        return inventoryService.isInStock(skuCode);
    }

    @PostMapping("/addInventory")
    public String addInventory(@RequestBody AddInventoryRequest request){
       return inventoryService.addInventory(request);
    }
}
