package com.ceiba.boardgamesnfood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = "com.ceiba.boardgamesnfood")
public class BoardgamesnfoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardgamesnfoodApplication.class, args);
	}

}
