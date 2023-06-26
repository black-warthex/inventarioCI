package com.crud_ci.ci.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "inventory")
public class InventoryEntity {

    @Id
    @Column(name = "inventory_item_name")
    private String inventoryItemName;

    @Column(name = "inventory_item_description")
    private String inventoryItemDescription;

    @Column(name = "inventory_item_price")
    private Double inventoryItemPrice;

}