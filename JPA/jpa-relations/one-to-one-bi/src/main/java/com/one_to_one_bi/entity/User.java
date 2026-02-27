package com.one_to_one_bi.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "userModel")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(exclude ="userAddress")

// Way to serialize
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id"
//)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "address_id", referencedColumnName ="id",unique = true )
    @JsonManagedReference
    private UserAddress userAddress;
}
