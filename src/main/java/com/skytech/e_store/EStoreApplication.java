package com.skytech.e_store;



import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication

@OpenAPIDefinition(
        info = @Info(
                title = "Spring Boot Ecommerce App REST APIs",
                description = "Spring Boot ecommerce  App REST APIs Documentation",
                version = "v1.0",
                contact = @Contact(
                        name = "Anawana",
                        email = "isaac.arinze.dev@gmail.com",
                        url = "https://github.com/Isaac-Arinze"
                ),
                license = @License(
                        name = "Apache 2.8",
                        url = "https://github.com/Anawana/license"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Spring Boot ecommerce App REST APIs Documentation"
        )
)
//@EnableAutoConfiguration
public class EStoreApplication {
    public static void main(String[] args) {SpringApplication.run(EStoreApplication.class, args);
    }
}
