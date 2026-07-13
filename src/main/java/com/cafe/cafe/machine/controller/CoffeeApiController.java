package com.cafe.cafe.machine.controller;

import com.cafe.cafe.dto.ClientLogItem;
import com.cafe.cafe.dto.CoffeeRequest;
import com.cafe.cafe.dto.CoffeeResponse;
import com.cafe.cafe.machine.model.CoffeeOrder;
import com.cafe.cafe.repository.CoffeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173/")
public class CoffeeApiController {

    private static final Logger logger = LoggerFactory.getLogger(CoffeeApiController.class);

    private final CoffeeRepository repository;

    public CoffeeApiController(CoffeeRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/brew")
    public CoffeeResponse brew(@RequestBody CoffeeRequest request) {
        String normalizedType = request.type() == null ? "espresso" : request.type().trim().toLowerCase();
        String normalizedSize = request.size() == null ? "short" : request.size().trim().toLowerCase();
        String normalizedCardName = request.cardName() == null || request.cardName().isBlank()
                ? "Guest Card"
                : request.cardName().trim();
        String clientToken = toClientToken(request.cardNumber());

        String price = request.price();
        if (price == null || price.isBlank()) {
            price = switch (normalizedSize) {
                case "grande" -> "€2.50";
                case "long" -> "€2.00";
                default -> "€1.50";
            };
        }

        String message = "SAVED TO H2 DATABASE";
        try {
            CoffeeOrder order = new CoffeeOrder(normalizedType, normalizedSize, price, normalizedCardName, clientToken);
            repository.save(order);
        } catch (Exception ex) {
            logger.error("Could not save coffee order", ex);
            message = "BREWED - SAVE FAILED";
        }

        return new CoffeeResponse(
                normalizedType.toUpperCase(),
                normalizedSize,
                price,
                message);
    }

    @GetMapping("/client-log/{cardNumber}")
    public List<ClientLogItem> getClientLog(@PathVariable String cardNumber) {
        String clientToken = toClientToken(cardNumber);
        if (clientToken.isBlank()) {
            return List.of();
        }

        try {
            return repository.findTop10ByCardNumberOrderByOrderTimeDesc(clientToken)
                    .stream()
                    .map(order -> new ClientLogItem(
                            order.getType(),
                            order.getSize(),
                            order.getPrice(),
                            order.getOrderTime() == null ? "" : order.getOrderTime().toString(),
                            order.getCardName(),
                            order.getCardNumber()))
                    .toList();
        } catch (Exception ex) {
            logger.error("Could not read client log", ex);
            return List.of();
        }
    }

    @GetMapping("/stats")
    public long getTotalCoffees() {
        try {
            return repository.count();
        } catch (Exception ex) {
            logger.error("Could not read coffee stats", ex);
            return 0L;
        }
    }

    private String toClientToken(String cardNumber) {
        if (cardNumber == null) {
            return "";
        }

        String digitsOnly = cardNumber.replaceAll("\\D", "");
        if (digitsOnly.isBlank()) {
            return "";
        }

        return digitsOnly.length() <= 4 ? digitsOnly : digitsOnly.substring(digitsOnly.length() - 4);
    }
}