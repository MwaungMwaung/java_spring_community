package com.example.Spring_Community.service;

import com.example.Spring_Community.dto.CoffeeForm;
import com.example.Spring_Community.entity.Coffee;
import com.example.Spring_Community.repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeService {
    @Autowired
    CoffeeRepository coffeeRepository;

    public List<Coffee> index() {
        return (List<Coffee>)coffeeRepository.findAll();
    }

    public Coffee show(Long id) {
        return coffeeRepository.findById(id).orElse(null);
    }


    public Coffee create(CoffeeForm dto) {
        Coffee posted = dto.toEntity();
        return coffeeRepository.findById(posted.getId()).orElse(null);
    }

    public Coffee update(Long id, CoffeeForm dto) {
        Coffee upCoffee = dto.toEntity();
        Coffee target = coffeeRepository.findById(id).orElse(null);

        if(target == null || target.getId() != upCoffee.getId()) {
            return null;
        }

        target.patch(upCoffee);
        return target;
    }

    public Coffee delete(Long id) {
        Coffee target = coffeeRepository.findById(id).orElse(null);

        if(target != null)
            coffeeRepository.delete(target);

        return target;
    }
}
