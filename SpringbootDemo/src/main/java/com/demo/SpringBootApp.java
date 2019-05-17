package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.demo.controller","com.demo.service"})
@SpringBootApplication 
public class SpringBootApp {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(SpringBootApp.class, args); 
		
	}
}
