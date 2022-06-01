package com.hagos.sportsteam.configs;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI xmlOpenApi() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Sports Teams")
                                .version("1.0.0")
                                .license(new License()
                                        .name("Dawit Hagos")))
                .externalDocs(
                        new ExternalDocumentation()
                                .description("Jackson XML Project")
                                .url("https://github.com/FasterXML/jackson-dataformat-xml")
                );
    }
}
