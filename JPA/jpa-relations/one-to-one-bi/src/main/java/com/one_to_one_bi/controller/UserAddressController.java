package com.one_to_one_bi.controller;

import com.one_to_one_bi.entity.UserAddress;
import com.one_to_one_bi.repository.UserAddressRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserAddressController {
    private final UserAddressRepo repo;
    @GetMapping("/address/{id}")
    public String getUserByAddressId(@PathVariable("id") Long id){
        UserAddress userAddress= repo.findById(id).orElseThrow();
        return "User Details\n"+userAddress;
    }
}
