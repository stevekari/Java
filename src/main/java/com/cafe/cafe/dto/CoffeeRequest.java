package com.cafe.cafe.dto;

// What React sends TO Spring
public record CoffeeRequest(String type, String size, String price, String cardName, String cardNumber) {
}
