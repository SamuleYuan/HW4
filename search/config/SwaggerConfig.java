package com.example.search.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.search.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("weather API")
                .description("weather project SwaggerAPI management")
                .termsOfServiceUrl("")
                .version("1.0")
                .build();
    }
}
