package io.java.course_apidata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("io.java.*")
public class CourseApidataApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseApidataApplication.class, args);
	}

}
