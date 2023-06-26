package com.crud_ci.ci.utils;

import com.crud_ci.ci.dto.InventoryDto;
import com.crud_ci.ci.entity.InventoryEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InventoryConverter {
    @Autowired
    private ModelMapper modelMapper = new ModelMapper();
    public InventoryEntity convertInventoryDtoToEntity(InventoryDto inventoryDto){
        InventoryEntity inventoryEntity =  modelMapper.map(inventoryDto, InventoryEntity.class);
        return inventoryEntity;
    }
}
