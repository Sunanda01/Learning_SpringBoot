package com.one_to_one_uni.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "userAddress")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String address;
    private String city;
    private String state;
    private String pincode;
}
