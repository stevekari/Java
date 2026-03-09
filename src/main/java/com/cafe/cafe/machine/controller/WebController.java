package com.cafe.cafe.machine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.cafe.cafe.machine.service.CafeService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {
    private final CafeService service;

    public WebController(CafeService service) {
        this.service = service;

    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/make")
    public String makeCoffee(@RequestParam String type, @RequestParam String size, Model model) {
        String result = service.prepareCoffeeText(type, size);
        model.addAttribute("result", result);

        return "result";
    }

}
