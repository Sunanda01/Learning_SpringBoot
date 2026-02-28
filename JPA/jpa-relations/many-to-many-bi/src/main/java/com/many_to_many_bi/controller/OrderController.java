package com.many_to_many_bi.controller;


import com.many_to_many_bi.entity.Order;
import com.many_to_many_bi.entity.Products;
import com.many_to_many_bi.repository.OrderRepo;
import com.many_to_many_bi.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderRepo orderRepo;
    private final ProductRepo productRepo;

    @PostMapping("/order")
    public Order createOrder(@RequestBody Order order) {

        List<Long> productIds = order.getProductsList()
                .stream()
                .map(Products::getId)
                .toList();
        List<Products> managedProducts = productRepo.findAllById(productIds);
        order.setProductsList(managedProducts);
        return orderRepo.save(order);
    }
    @GetMapping("/order")
    public ResponseEntity<List> getAllOrder(){
        List<Order> orderList= orderRepo.findAll();
        if(orderList.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(orderList);
    }
}