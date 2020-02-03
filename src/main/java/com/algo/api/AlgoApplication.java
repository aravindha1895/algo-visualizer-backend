package com.algo.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "com.algo.graph.controller", "com.algo.graph.service" })
public class AlgoApplication {
	public static void main(String[] args) {
		SpringApplication.run(AlgoApplication.class, args);
	}
}
