package com.reactive.crud;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import org.dozer.DozerBeanMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setAnnotationIntrospector(new JacksonAnnotationIntrospector() {
			@Override
			public JsonPOJOBuilder.Value findPOJOBuilderConfig(AnnotatedClass ac) {
				if (ac.hasAnnotation(JsonPOJOBuilder.class)) {
					return super.findPOJOBuilderConfig(ac);
				}
				//for lombok generated pojo builders there wont be any annotation and the with prefix is empty and builder method is build
				return new JsonPOJOBuilder.Value("build", "");
			}
		});
		return objectMapper;
	}

	@Bean
	public DozerBeanMapper dozerBean() {
		return new DozerBeanMapper();
	}

}
