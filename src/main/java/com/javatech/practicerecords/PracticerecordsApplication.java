package com.javatech.practicerecords;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class PracticerecordsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticerecordsApplication.class, args);
	}



}
