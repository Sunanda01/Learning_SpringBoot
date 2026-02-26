package com.sequence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "User1")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "unique_seq")
    @SequenceGenerator(name = "unique_seq",sequenceName = "db_unique_seq",initialValue = 10,allocationSize = 5)
    private Long id;
    private String name;

    @Override
    public String toString() {
        return "User "+id+"\nName =: "+name+"\n------------------------\n";
    }
}
