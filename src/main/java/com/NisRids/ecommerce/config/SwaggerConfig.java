package com.NisRids.ecommerce.config;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
@SpringBootApplication
@OpenAPIDefinition(
        info= @Info(
                title = "Spring Boot Social login Rest APIs",
                description = "Spring Boot Social login Rest APIs Documentation",
                version = "v1.0",
                contact = @Contact(
                        name = "ichebadu chukwu",
                        email = "chukwu.iche@gmail.com",
                        url = "https://www.ichejazz.net"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.ichejazz.net/license"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "spring Boot Social Login Documentation",
                url = "https://github.com/ichebadu/social-login"
        )

)
public class SwaggerConfig {
//    @Bean
//    public Docket productApi(){
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(getApiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.NisRids.ecommerce"))
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    private ApiInfo getApiInfo() {
//        Contact contact = new Contact("webtutsplus", "http://webtutsplus.com","contact.webtutsplus@gmail.com");
//        return new ApiInfoBuilder()
//                .title("Ecommerce API")
//                .description("Documentation Ecommerce api")
//                .version("1.0.0")
//                .license("Apache 2.0")
//                .contact(contact)
//                .build();
//    }
}
