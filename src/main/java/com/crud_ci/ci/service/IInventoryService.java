package com.crud_ci.ci.service;

import com.crud_ci.ci.dto.ResponseDto;
import com.crud_ci.ci.entity.InventoryEntity;
import org.springframework.stereotype.Service;

@Service
public interface IInventoryService {
    public ResponseDto addInventory(InventoryEntity inventory);
}
