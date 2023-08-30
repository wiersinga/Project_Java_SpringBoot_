package com.testsring.Test.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    // define one or more Docket instances using springs @Bean annotation
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                //Elle permet de filtrer la documentation à exposer selon les contrôleurs.
                // Ainsi, vous pouvez cacher la documentation d'une partie privée ou interne de votre API.
                .paths(PathSelectors.any())
                // paths: eliminer de la documentation
                .build();
    }
}
