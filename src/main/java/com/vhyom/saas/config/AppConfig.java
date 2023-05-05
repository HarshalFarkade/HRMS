package com.vhyom.saas.config;

import com.vhyom.saas.converter.MultipartFileToStringConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Autowired
    private MultipartFileToStringConverter multipartFileToStringConverter;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(multipartFileToStringConverter);
    }
}