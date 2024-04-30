package com.thinkdevs.msfitnessPlan;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableFeignClients
@Component
@Slf4j
@RequiredArgsConstructor
public class MsFitnessPlanApplication {
	@Value("${spring.datasource.url}")
	private String dbUrl;
	@Value("${spring.datasource.username}")
	private String dbUsername;
	@Value("${spring.datasource.password}")
	private String dbPassword;




	public static void main(String[] args) {
		Flyway flyway = Flyway.configure()
				.dataSource("jdbc:postgresql://localhost:5432/fitness_db?",
						"postgres",
						"postgres")
				.load();
		flyway.repair();
		log.info("---Flyway repair completed successfully------");

		SpringApplication.run(MsFitnessPlanApplication.class, args);
	}

//	@PostConstruct
//	public void init() {
//		// Validate if required credentials are provided
//		if (dbUrl == null || dbUsername == null || dbPassword == null) {
//			throw new IllegalArgumentException("Database credentials are missing. Please provide spring.datasource.url, spring.datasource.username, and spring.datasource.password properties in your application.properties file.");
//		}
//
//		// Configure Flyway migration
//		Flyway flyway = Flyway.configure()
//				.dataSource("jdbc:postgresql://localhost:5432/fitness_db?", "postgres", "postgres")
//				.load();
//
//		// Repair any potential database inconsistencies
//		flyway.repair();
//		log.info("Flyway repair completed successfully");
//	}


}


