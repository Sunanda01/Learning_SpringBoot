package com.one_to_one_bi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "userAddress")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
//@ToString(exclude = "user")

//Way to serialize data
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id"
//)
public class UserAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String address;
    private String city;
    private String state;
    private String pincode;
    @OneToOne(mappedBy = "userAddress")
    @JsonBackReference
    private User user;
}
