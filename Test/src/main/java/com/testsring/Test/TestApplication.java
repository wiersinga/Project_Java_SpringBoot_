package com.testsring.Test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableSwagger2
public class TestApplication {

	public static void main(String[] args) {
				SpringApplication.run(TestApplication.class, args);
	}

}
