package com.crud_ci.ci.service;

import com.crud_ci.ci.dto.ResponseDto;
import com.crud_ci.ci.entity.InventoryEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IInventoryService {
    public ResponseDto addInventory(InventoryEntity inventory);

    public List<InventoryEntity> getAllInventory();
    public List<InventoryEntity> findByItemName(String name);
    public ResponseDto deleteInventory(String name);
    public ResponseDto updateInventoryPricer(String name, Double price);
}
