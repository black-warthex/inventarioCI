package com.crud_ci.ci.controller;

import com.crud_ci.ci.dto.InventoryDto;
import com.crud_ci.ci.dto.ResponseDto;
import com.crud_ci.ci.service.IInventoryService;
import com.crud_ci.ci.utils.InventoryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inv")
public class InventarioController {
    @Autowired
    private IInventoryService service;
    private InventoryConverter converter = new InventoryConverter();
    @GetMapping(path = "/hello",produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String hello(){
        return "hola mundo";
    }

    @PostMapping(path = "/add",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<ResponseDto> addInventory(@RequestBody InventoryDto inventoryDto){
        return new ResponseEntity<>(service.addInventory(converter.convertInventoryDtoToEntity(inventoryDto)), HttpStatus.OK);
    }

}
