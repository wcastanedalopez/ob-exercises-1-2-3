package com.example.obejercicios123.controller;

import com.example.obejercicios123.entities.Laptop;
import com.example.obejercicios123.repository.LaptopRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LaptopController {
    LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    @GetMapping("/api/laptops")
    public List<Laptop> findAllLaptops () {
        return (List<Laptop>) laptopRepository.findAll();
    }

    @PostMapping("/api/create")
    public Laptop create (@RequestBody Laptop laptop) {
        return laptopRepository.save(laptop);
    }
}
