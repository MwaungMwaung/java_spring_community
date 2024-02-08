package com.example.Spring_Community.api;

import com.example.Spring_Community.dto.CoffeeForm;
import com.example.Spring_Community.entity.Coffee;
import com.example.Spring_Community.repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class CoffeeApiController {
    @Autowired
    CoffeeRepository coffeeRepository;

    @GetMapping("/api/coffees")
    public List<Coffee> index() {
        return (List<Coffee>) coffeeRepository.findAll();
    }

    @GetMapping("/api/coffees/{id}")
    public Coffee show(@PathVariable Long id) {
        return coffeeRepository.findById(id).orElse(null);
    }

    @PostMapping("/api/coffees")
    public Coffee create(@RequestBody CoffeeForm dto) {
        coffeeRepository.save(dto.toEntity());
        return dto.toEntity();
    }

    @PatchMapping("/api/coffees/{id}")
    public ResponseEntity<Coffee> update(@PathVariable Long id, @RequestBody CoffeeForm dto) {
        Coffee coffee = dto.toEntity();
        Coffee target = coffeeRepository.findById(id).orElse(null);

        if(target == null || !Objects.equals(target.getId(), coffee.getId()))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        target.patch(coffee);
        coffeeRepository.save(target);

        return ResponseEntity.status(HttpStatus.OK).body(target);
    }

    @DeleteMapping("/api/coffees/{id}")
    public ResponseEntity<Coffee> delete(@PathVariable Long id) {
        Coffee target = coffeeRepository.findById(id).orElse(null);

        if(target == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
