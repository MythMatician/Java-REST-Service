package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class DemoApplication {

	private JdbcTemplate jdbcTemplate;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
