package com.mongoexamples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

//@EnableMongoRepositories
@SpringBootApplication
public class MongoexamplesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoexamplesApplication.class, args);
	}
}
