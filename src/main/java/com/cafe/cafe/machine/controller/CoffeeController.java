package com.cafe.cafe.machine.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe.cafe.machine.service.CafeService;

@RestController
@RequestMapping("/api/coffee")
public class CoffeeController {

    private final CafeService service;

    public CoffeeController(CafeService service) {
        this.service = service;
    }

    @GetMapping("/{type}/{size}")
    public String makeCoffee(@PathVariable String type, @PathVariable String size) {
        return service.prepareCoffeeText(type, size);
    }

}
