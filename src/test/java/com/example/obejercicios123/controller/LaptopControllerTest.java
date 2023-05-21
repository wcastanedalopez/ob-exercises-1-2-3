package com.example.obejercicios123.controller;

import com.example.obejercicios123.entities.Laptop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.http.client.support.HttpRequestWrapper;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaptopControllerTest {

    private TestRestTemplate testRestTemplate;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private String port;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri( "http://localhost:" + port );
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @Test
    void findAllLaptops() {
        ResponseEntity<Laptop[]> response = testRestTemplate.getForEntity("/api/laptops", Laptop[].class);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(HttpStatus.OK, response.getStatusCode());


    }

    @Test
    void findById() {
        ResponseEntity<Laptop> response = testRestTemplate.getForEntity("/api/laptops/1", Laptop.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void create() {
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        String json = """
                {
                    "brand":"HP",
                    "model": "Ideapad",
                    "amountRam": 4,
                    "amountProcessor": "Ryzen"
                }
                """;
        HttpEntity<String> request = new HttpEntity<>(json, header);
        ResponseEntity<Laptop> response =
                testRestTemplate.exchange("/api/laptops", HttpMethod.POST, request, Laptop.class);
        assertEquals(1L, response.getBody().getId());
        assertEquals("HP", response.getBody().getBrand());

    }

    @Test
    void update() {
    }

    @Test
    void deleteAll() {
    }

    @Test
    void deleteById() {
    }
}