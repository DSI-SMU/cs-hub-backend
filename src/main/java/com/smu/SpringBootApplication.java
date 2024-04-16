package com.smu;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@org.springframework.boot.autoconfigure.SpringBootApplication
@EnableJpaRepositories
@EnableAspectJAutoProxy
public class SpringBootApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootApplication.class, args);
	}

}
