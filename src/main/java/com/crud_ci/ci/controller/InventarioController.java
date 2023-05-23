package com.crud_ci.ci.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inv")
public class InventarioController {

    @GetMapping(path = "/hello",produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String hello(){
        return "hola mundo";
    }
}
