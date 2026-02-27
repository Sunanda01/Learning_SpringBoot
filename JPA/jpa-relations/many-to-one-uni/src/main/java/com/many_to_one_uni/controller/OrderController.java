package com.many_to_one_uni.controller;

import com.many_to_one_uni.entity.Order;
import com.many_to_one_uni.entity.Users;
import com.many_to_one_uni.repository.OrderRepo;
import com.many_to_one_uni.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderRepo orderRepo;
    private final UserRepo userRepo;
    @PostMapping("/order/{id}")
    public ResponseEntity<Order> createUser(@PathVariable("id") Long id, @RequestBody Order order){
        Users users=userRepo.findById(id).get();
        order.setUsers(users);
        orderRepo.save(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }
    @GetMapping("/order")
    public ResponseEntity<List> getAllOrder(){
        List<Order> orderList= orderRepo.findAll();
        if(orderList.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(orderList);
    }
}