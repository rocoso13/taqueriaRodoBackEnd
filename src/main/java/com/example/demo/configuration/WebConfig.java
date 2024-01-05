package com.example.demo.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import java.util.Collections;

@Configuration
@EnableAutoConfiguration(exclude = org.springframework.boot.autoconfigure.web.servlet.HttpEncodingAutoConfiguration.class)
public class WebConfig {
    
    @Bean
    public FilterRegistrationBean<CharacterEncodingFilter> characterEncodingFilter() {
        FilterRegistrationBean<CharacterEncodingFilter> filter = new FilterRegistrationBean<>();
        filter.setFilter(new CharacterEncodingFilter());
        filter.setInitParameters(Collections.singletonMap("encoding", "UTF-8"));
        filter.addUrlPatterns("/*");
        return filter;
    }

    
}
