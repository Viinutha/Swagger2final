package com.vinutha.Swagger2final;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.function.Predicate;


@SpringBootApplication
@EnableSwagger2
@Configuration
public class Swagger2finalApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(Swagger2finalApplication.class, args);
	}
	@Bean
	public Docket api(){
		return new Docket(DocumentationType.SWAGGER_2).select().apis(Predicate.not(RequestHandlerSelectors.basePackage("org.springframework.boot"))).build();
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//http://localhost:8080/swagger-ui/index.html is url for swagger
		registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

}
