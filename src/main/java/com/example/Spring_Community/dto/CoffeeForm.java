package com.example.Spring_Community.dto;

import com.example.Spring_Community.entity.Coffee;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CoffeeForm {
    private Long id;
    private String name;
    private Integer price;

    public Coffee toEntity() {
        return new Coffee(id, name, price);
    }
}
