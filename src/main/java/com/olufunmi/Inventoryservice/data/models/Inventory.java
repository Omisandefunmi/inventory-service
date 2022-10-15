package com.olufunmi.Inventoryservice.data.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "t_inventory")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String skuCode;
    private Integer quantity;





}
