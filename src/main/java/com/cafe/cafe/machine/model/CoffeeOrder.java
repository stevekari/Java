package com.cafe.cafe.machine.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "coffee_orders")
public class CoffeeOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private String size;

    public String getSize() {
        return size;
    }

    private String price;
    private String cardName;
    private String cardNumber;
    private LocalDateTime orderTime;

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    // Default constructor for JPA
    public CoffeeOrder() {
    }

    public CoffeeOrder(String type, String size, String price, String cardName, String cardNumber) {
        this.type = type;
        this.size = size;
        this.price = price;
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.orderTime = LocalDateTime.now();
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getPrice() {
        return price;
    }

    public String getCardName() {
        return cardName;
    }

    public String getCardNumber() {
        return cardNumber;
    }
}