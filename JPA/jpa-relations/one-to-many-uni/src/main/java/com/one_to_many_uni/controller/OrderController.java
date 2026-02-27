package com.one_to_many_uni.controller;

import com.one_to_many_uni.entity.Order;
import com.one_to_many_uni.repository.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderRepo repo;
    @GetMapping("/address/{id}")
    public String getUserByAddressId(@PathVariable("id") Long id){
        Order userAddress= repo.findById(id).orElseThrow();
        return "User Details\n"+userAddress;
    }
}
