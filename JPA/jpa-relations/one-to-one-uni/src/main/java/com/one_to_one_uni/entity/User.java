package com.one_to_one_uni.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "userModel")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "address_id", referencedColumnName ="id",unique = true )
    private UserAddress userAddress;
}
