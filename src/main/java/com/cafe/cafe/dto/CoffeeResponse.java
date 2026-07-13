package com.cafe.cafe.dto;

// What Spring sends BACK to React
public record CoffeeResponse(String name, String size, String price, String message) {
}
