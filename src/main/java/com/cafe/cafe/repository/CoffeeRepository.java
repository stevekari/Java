package com.cafe.cafe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cafe.cafe.machine.model.CoffeeOrder;

public interface CoffeeRepository extends JpaRepository<CoffeeOrder, Long> {
	List<CoffeeOrder> findTop10ByCardNumberOrderByOrderTimeDesc(String cardNumber);
}