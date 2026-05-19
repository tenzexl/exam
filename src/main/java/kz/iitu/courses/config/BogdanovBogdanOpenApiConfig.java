package kz.iitu.courses.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BogdanovBogdanOpenApiConfig {
    @Bean
    public OpenAPI bogdanovBogdanOpenApi() {
        return new OpenAPI()
            .info(new Info()
                .title("Online Course Platform API")
                .description("REST API documentation")
                .version("v1"));
    }
}
