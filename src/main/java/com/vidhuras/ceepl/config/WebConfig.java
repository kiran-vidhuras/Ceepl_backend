package com.vidhuras.ceepl.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${app.upload.dir:uploads/}")
    private String uploadDir;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET","POST","PUT","PATCH","DELETE")
                .allowedHeaders("*");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String absolutePath = System.getProperty("user.dir") + "/uploads/";
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:" + absolutePath);
    }



//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        String absolutePath = System.getProperty("user.dir") + File.separator + "uploads" + File.separator;
//        registry.addResourceHandler("/uploads/**")
//                .addResourceLocations("file:" + absolutePath);
//    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        // Match exactly where files are saved
//        registry.addResourceHandler("/uploads/**")
//                .addResourceLocations("file:C:/Users/vsoft/CEEPL/uploads/");
//    }

}
