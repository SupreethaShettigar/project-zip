package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "grocery")
@EntityScan(basePackages = "grocery")
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/user/signin").allowedOrigins("http://localhost:4200");
				registry.addMapping("/user/signin").allowCredentials(true);

				registry.addMapping("/user/signup").allowedOrigins("http://localhost:4200");
				registry.addMapping("/user/signup").allowCredentials(true);

				registry.addMapping("/user/signout").allowedOrigins("http://localhost:4200");
				registry.addMapping("/user/signout").allowCredentials(true);

				registry.addMapping("/user/order/add").allowedOrigins("http://localhost:4200");
				registry.addMapping("/user/order/add").allowCredentials(true);

				registry.addMapping("/user/order/items/add").allowedOrigins("http://localhost:4200");
				registry.addMapping("/user/order/items/add").allowCredentials(true);

			}
		};
	}

}
