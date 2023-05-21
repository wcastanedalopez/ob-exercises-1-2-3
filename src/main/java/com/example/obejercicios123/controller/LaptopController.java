package com.example.obejercicios123.controller;

import com.example.obejercicios123.entities.Laptop;
import com.example.obejercicios123.repository.LaptopRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {
    LaptopRepository laptopRepository;
    private final Logger log = LoggerFactory.getLogger(Laptop.class);
    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    @GetMapping("/api/laptops")
    public List<Laptop> findAllLaptops () {
        return (List<Laptop>) laptopRepository.findAll();
    }

    @GetMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> findById (@PathVariable Long id) {
        Optional<Laptop> optBook = laptopRepository.findById(id);

        //Opción 1
        return optBook.isPresent() ? ResponseEntity.ok(optBook.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping("/api/laptops")
    public ResponseEntity<Laptop> create (@RequestBody Laptop laptop) {
        if (laptop.getId() != null) {
            log.warn("Trying to created a laptop existing");
            return ResponseEntity.badRequest().build();
        }
        Laptop aux = laptopRepository.save(laptop);
        return ResponseEntity.ok(aux);
    }

    @PutMapping("/api/laptops")
    public ResponseEntity<Laptop> update (@RequestBody Laptop laptop) {
        if (laptop.getId() == null) {
            log.warn("Can't update a laptop without an id");
            ResponseEntity.notFound();
        }
        if (!laptopRepository.existsById(laptop.getId())) {
            log.warn("Trying to update a laptop non existing");
            return ResponseEntity.notFound().build();
        }
        Laptop aux = laptopRepository.save(laptop);
        return ResponseEntity.ok(aux);
    }

    @DeleteMapping("/api/laptops")
    public ResponseEntity<Laptop> deleteAll () {
        if (laptopRepository.count() == 0) {
            log.warn("Nothing to delete");
            return ResponseEntity.notFound().build();
        }
        log.warn("Deleting all laptops");
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> deleteById (@PathVariable Long id) {
        if (laptopRepository.count() == 0) {
            log.warn("Nothing to delete");
            return ResponseEntity.notFound().build();
        }
        if (!laptopRepository.existsById(id)) {
            log.warn("Trying to delete a non existing laptop");
            return ResponseEntity.notFound().build();
        }
        log.warn("Deleting a laptop");
        laptopRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
