package com.example.Spring_Community.repository;

import com.example.Spring_Community.entity.Coffee;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeRepository extends CrudRepository<Coffee, Long> {
}
