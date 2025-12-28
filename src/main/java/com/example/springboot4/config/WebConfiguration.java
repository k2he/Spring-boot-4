package com.example.springboot4.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ApiVersionConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void configureApiVersioning(ApiVersionConfigurer configurer) {
        configurer.addSupportedVersions("1.0", "2.0")
                .setDefaultVersion("1.0")
                // Choose ONE of these approaches (they cannot be mixed)
                .usePathSegment(1)                              // Path-based: /api/v1/product
//                .useRequestHeader("X-API-Version")              // Header-based
                //.useQueryParam("version")                       // Query parameter-based
                .setVersionParser(new CustomApiVersionParser())
                ;
    }

}
