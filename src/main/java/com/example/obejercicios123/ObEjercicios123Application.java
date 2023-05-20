package com.example.obejercicios123;

import com.example.obejercicios123.entities.Laptop;
import com.example.obejercicios123.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ObEjercicios123Application {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(ObEjercicios123Application.class, args);
		LaptopRepository laptopRepository = context.getBean(LaptopRepository.class);

		Laptop laptop = new Laptop(null, "Lenovo", "Ideapad", 16, "intel");
		Laptop laptop1 = new Laptop(null, "Lenovo", "Ideapad", 8, "ryzen");
		laptopRepository.save(laptop);
		laptopRepository.save(laptop1);
	}

}
