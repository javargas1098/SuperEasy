package edu.eci.arsw.aplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "edu.eci.arsw" })
public class SuperEasyApiAplication {

	public static void main(String[] args) {
		SpringApplication.run(SuperEasyApiAplication.class, args);
	}

}
