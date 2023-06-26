package com.crud_ci.ci.service.impl;

import com.crud_ci.ci.dto.ResponseDto;
import com.crud_ci.ci.entity.InventoryEntity;
import com.crud_ci.ci.repository.IInventoryRepository;
import com.crud_ci.ci.service.IInventoryService;
import com.crud_ci.ci.utils.DefaultAnserEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
           return  response;

    }

}
