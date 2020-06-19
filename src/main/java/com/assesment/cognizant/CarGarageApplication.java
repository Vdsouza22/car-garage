package com.assesment.cognizant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/*
 * This is the main Spring Boot application class to configure Spring Boot and Mongo Repository
 * @author Vinita 
 */

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = "com.assesment.cognizant")
@EntityScan(basePackages = "com.assesment.cognizant.domain")
@EnableMongoRepositories(basePackages = "com.assesment.cognizant.dao.jpa")
public class CarGarageApplication extends SpringBootServletInitializer{
	 private static final Class<CarGarageApplication> applicationClass = CarGarageApplication.class;
	 private static final Logger log = LoggerFactory.getLogger(applicationClass);
	
	
	public static void main(String[] args) {
		log.info("Main method : Entry point");
		SpringApplication.run(CarGarageApplication.class, args);
	}

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }
    
}
