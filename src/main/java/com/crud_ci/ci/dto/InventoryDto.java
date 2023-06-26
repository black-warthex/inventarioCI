package com.crud_ci.ci.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class InventoryDto {
    private String inventoryItemName;
    private String inventoryItemDescription;
    private Double inventoryItemPrice;
}
