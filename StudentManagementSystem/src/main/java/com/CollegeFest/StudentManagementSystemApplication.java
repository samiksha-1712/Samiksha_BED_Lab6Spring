package com.CollegeFest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
		
		System.out.println("\n\n Welcome to College Fest Registration Portal");

		System.out.println("\n\n Use URL as localhost:<PORT>/StudentManagementSystem ");
	}

}
