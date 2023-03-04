package com.cg.health;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DaignosticMain {
	public static void main(String[] args) {
		SpringApplication.run(DaignosticMain.class, args);
		System.out.println("Server running...");
	}
}
