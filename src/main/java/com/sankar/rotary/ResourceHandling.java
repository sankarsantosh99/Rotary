package com.sankar.rotary;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ResourceHandling implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Expose the uploads directory to be
        // accessible via the /uploads URL
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:uploads/");  // This
        // points to the uploads folder in the
        // root directory

    }
}
