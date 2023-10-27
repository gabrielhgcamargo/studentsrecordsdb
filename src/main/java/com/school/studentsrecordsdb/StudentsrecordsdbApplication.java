package com.school.studentsrecordsdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class StudentsrecordsdbApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentsrecordsdbApplication.class, args);
	}

}
