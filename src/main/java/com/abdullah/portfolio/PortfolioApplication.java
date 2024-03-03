package com.abdullah.portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PortfolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioApplication.class, args);
	}

}

/*
  drop schema if exists `portfolio`;
  create schema `portfolio`;
  USE `portfolio`;
 */