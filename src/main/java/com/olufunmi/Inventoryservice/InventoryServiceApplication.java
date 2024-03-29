package com.olufunmi.Inventoryservice;

import com.olufunmi.Inventoryservice.data.models.Inventory;
import com.olufunmi.Inventoryservice.data.repositories.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
		return args -> {
			Inventory inventory = new Inventory();
			inventory.setQuantity(100);
			inventory.setSkuCode("MacBook Pro");

			Inventory inventory2 = new Inventory();
			inventory2.setQuantity(0);
			inventory2.setSkuCode("MacBook Pro Lite");

			inventoryRepository.save(inventory);
			inventoryRepository.save(inventory2);

		};

	}
}
