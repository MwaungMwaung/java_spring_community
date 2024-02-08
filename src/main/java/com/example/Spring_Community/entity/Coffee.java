package com.example.Spring_Community.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private Integer price;

    public void patch(Coffee coffee) {
        if(coffee.getName() != null)
            this.name = coffee.name;

        if(coffee.getPrice() != null)
            this.price = coffee.price;
    }
}
