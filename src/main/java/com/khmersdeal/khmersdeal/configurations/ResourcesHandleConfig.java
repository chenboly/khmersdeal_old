package com.khmersdeal.khmersdeal.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@PropertySource("classpath:/project_file.properties")
public class ResourcesHandleConfig implements WebMvcConfigurer {
    @Value("${server.path}")
    private String SERVER_PATH;
    @Value("${client.path}")
    private String CLIENT_PATH;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/static/admin-lte/");

        registry.addResourceHandler(CLIENT_PATH +"**").addResourceLocations("file:" + SERVER_PATH);
    }
}
