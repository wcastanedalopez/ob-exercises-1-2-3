package com.example.obejercicios123.repository;

import com.example.obejercicios123.entities.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepository extends JpaRepository <Laptop, Long> {
}
