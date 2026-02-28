package com.many_to_many_bi.controller;

import com.many_to_many_bi.entity.Products;
import com.many_to_many_bi.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductsController {
    private final ProductRepo productRepo;

    @GetMapping("/")
    public ResponseEntity<List> getAllUser(){
        List<Products> usersList =productRepo.findAll();
        if(usersList.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(usersList);
    }

    @PostMapping("/")
    public ResponseEntity<Products> createUser(@RequestBody Products products){
        Products saved=productRepo.save(products);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
