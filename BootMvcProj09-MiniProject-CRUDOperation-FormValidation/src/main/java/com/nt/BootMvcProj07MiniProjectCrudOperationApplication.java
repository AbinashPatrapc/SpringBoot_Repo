package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value="com/nt/validations/validation.properties")
public class BootMvcProj07MiniProjectCrudOperationApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj07MiniProjectCrudOperationApplication.class, args);
	}

}
