package com.olufunmi.Inventoryservice.data.repositories;

import com.olufunmi.Inventoryservice.data.models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
   Optional<Inventory> findBySkuCode(String skuCode);
}
