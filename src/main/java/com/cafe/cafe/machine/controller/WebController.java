package com.cafe.cafe.machine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe.cafe.machine.service.CafeService;

@Controller
public class WebController {
    private final CafeService service;

    private String selectedDrink;
    private String selectedSize;

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

    @PostMapping("/select-drink")
    public String selectDrink(@RequestParam String drink, Model model) {
        selectedDrink = drink; // store the drink
        model.addAttribute("selectedDrink", selectedDrink);
        model.addAttribute("selectedSize", selectedSize);

        model.addAttribute("selectedDrink", drink);
        return "result";
    }

    @PostMapping("/select-size")
    public String selectSize(@RequestParam String size, Model model) {
        model.addAttribute("size", size);
        return "result";
    }

    @PostMapping("/brew")
    public String brewCoffee(@RequestParam("type") String type,
            @RequestParam("size") String size,
            Model model) {

        // Create a nice display string
        String coffeeName = type.substring(0, 1).toUpperCase() + type.substring(1); // Capitalize
        String price = "€1.50";

        // This combined string is what result.html uses
        model.addAttribute("result", coffeeName + " (" + size + ") | " + price);

        return "result";
    }
}
