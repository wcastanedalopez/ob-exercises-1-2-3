package com.example.obejercicios123.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "laptops")
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String model;
    private int amountRam;
    private String amountProcessor;

    public Laptop() {
    }

    public Laptop(Long id, String brand, String model, int amountRam, String amountProcessor) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.amountRam = amountRam;
        this.amountProcessor = amountProcessor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getAmountRam() {
        return amountRam;
    }

    public void setAmountRam(int amountRam) {
        this.amountRam = amountRam;
    }

    public String getAmountProcessor() {
        return amountProcessor;
    }

    public void setAmountProcessor(String amountProcessor) {
        this.amountProcessor = amountProcessor;
    }
}
