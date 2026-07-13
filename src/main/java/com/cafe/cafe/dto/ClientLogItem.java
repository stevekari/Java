package com.cafe.cafe.dto;

// Returned to React as one row in a client's recent activity log.
public record ClientLogItem(String type, String size, String price, String orderTime, String cardName, String cardNumber) {
}
