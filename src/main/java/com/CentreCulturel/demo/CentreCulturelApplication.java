package com.CentreCulturel.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class CentreCulturelApplication  {

	public static void main(String[] args) {
		SpringApplication.run(CentreCulturelApplication.class, args);
		System.out.print("...........Started");
	}

}
