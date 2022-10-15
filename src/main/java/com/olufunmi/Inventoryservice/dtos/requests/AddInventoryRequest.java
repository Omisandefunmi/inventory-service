package com.olufunmi.Inventoryservice.dtos.requests;

import lombok.Getter;

@Getter
public class AddInventoryRequest {
    private String skuCode;
    private Integer quantity;
}
