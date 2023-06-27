package com.crud_ci.ci.service.impl;

import com.crud_ci.ci.dto.ResponseDto;
import com.crud_ci.ci.entity.InventoryEntity;
import com.crud_ci.ci.repository.IInventoryRepository;
import com.crud_ci.ci.service.IInventoryService;
import com.crud_ci.ci.utils.DefaultAnserEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryServiceImpl implements IInventoryService {

    @Autowired
    private IInventoryRepository repository;
    private ResponseDto response = new ResponseDto(DefaultAnserEnum.MESSAGE_ERROR.getValue(),false);

    @Override
    public ResponseDto addInventory (InventoryEntity inventory){
        repository.save(inventory);
        response.setMessage(DefaultAnserEnum.MESSAGE_INSERT.getValue());
        response.setSuccess(true);
        return response;
    }

    @Override
    public List<InventoryEntity> getAllInventory(){
        return  repository.findAll();
    }

    @Override
    public List<InventoryEntity> findByItemName(String name){
        return  repository.findByinventoryItemName(name);
    }

    @Override
    public ResponseDto deleteInventory(String name){
        repository.deleteById(name);
        response.setMessage(DefaultAnserEnum.MESSAGE_DELETE.getValue());
        response.setSuccess(true);
        return response;
    }

    @Override
    public ResponseDto updateInventoryPricer(String name,Double price){

        List<InventoryEntity> inventoryEntity = repository.findByinventoryItemName(name);
        InventoryEntity inventory = inventoryEntity.get(0);
        inventory.setInventoryItemPrice(price);
        repository.save(inventory);
        response.setMessage(DefaultAnserEnum.MESSAGE_UPDATE.getValue());
        response.setSuccess(true);
        return response;
    }

}
