package com.one_to_many_uni.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true )
    @JoinColumn(name = "user-id-fk", referencedColumnName = "id")
    private List<Order> orderList=new ArrayList<>();
}
//Without JoinColumns it will create three different tables
//orphanRemoval = true if absent then if the order gets deleted, it will show the user_id as null in orders_db, so to make sure it get deleted from orders_db orphanRemoval should be present